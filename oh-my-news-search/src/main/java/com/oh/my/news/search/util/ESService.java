package com.oh.my.news.search.util;

import org.apache.log4j.Logger;
import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsRequest;
import org.elasticsearch.action.admin.indices.exists.indices.IndicesExistsResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.search.MatchQuery;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import sun.misc.IOUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by shj on 2017/4/26.
 */
@Component(value = "esService")
public class ESService {


    @Value("#{configProperties['index']}")
    private  String indexName;
    @Value("#{configProperties['type']}")
    private String indexType;
    @Value("classpath:content_index.json")
    private Resource data;
    private String mappings;
    @Autowired
    private  ESClient esclient;
    private Client client;

    private static Logger logger = Logger.getLogger(ESService.class);


    @PostConstruct
    public void init()throws Exception{
         mappings = new String(IOUtils.readFully(data.getInputStream(), -1,true));
         client = esclient.getClient();
    }




    public boolean indexExists(Client client, String index_name) throws Exception{
        IndicesExistsResponse indicesExistsResponse = client.admin().indices()
                .exists(new IndicesExistsRequest(new String[]{index_name})).actionGet();
        return indicesExistsResponse.isExists();
    }


    public  void createIndex()throws Exception{
        if(indexExists(client,indexName))
            return;
        esclient.getClient()
                .admin()
                .indices()
                .prepareCreate(indexName)
                .setSource(mappings)
                .execute()
                .actionGet();
    }

    public void insert(String jsonDoc,int id)throws JSONException,ElasticsearchException{
        JSONObject jsonObject = new JSONObject(jsonDoc);
        client.prepareIndex(indexName,indexType,String.valueOf(id))
                .setSource(jsonDoc)
                .execute()
                .actionGet();

    }

    public void update(String jsonDoc,int id)throws JSONException,ElasticsearchException{
        JSONObject jsonObject = new JSONObject(jsonDoc);
        try {
            delete(id);
        }catch (Exception e){
            logger.error(e);
        }
        insert(jsonDoc,id);

    }


    public SearchResponse query(String text, int from, int size)throws ElasticsearchException{
       QueryBuilder queryBuilder = QueryBuilders.boolQuery()
               .should(QueryBuilders.matchQuery("topic.cn",text))
               .should(QueryBuilders.matchQuery("topic.en",text))
               .should(QueryBuilders.matchQuery("topic.pinyin",text))
               .should(QueryBuilders.matchQuery("content.cn",text))
               .should(QueryBuilders.matchQuery("content.en",text))
               .should(QueryBuilders.matchQuery("author",text));
      return client.prepareSearch(indexName)
              .setTypes(indexType)
              .setSearchType(SearchType.DFS_QUERY_AND_FETCH)
              .setQuery(queryBuilder)
              .setNoFields()
               .setFrom(from)
               .setSize(size)
               .setExplain(false)
               .execute()
               .actionGet();
    }



    public void delete(int id)throws ElasticsearchException{
        client.prepareDelete(indexName,indexType,String.valueOf(id)).execute().actionGet();
    }














}
