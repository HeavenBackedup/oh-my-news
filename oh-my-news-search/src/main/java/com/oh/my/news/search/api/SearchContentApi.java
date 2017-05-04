package com.oh.my.news.search.api;

import com.oh.my.news.model.dto.SearchContent;
import com.oh.my.news.search.util.ESService;
import org.codehaus.jackson.map.ObjectMapper;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shj on 2017/4/27.
 */
@Component
public class SearchContentApi {
    @Autowired
    private ESService esService;
    private ObjectMapper mapper;
    @PostConstruct
    public void init(){
        mapper = new ObjectMapper();
    }

    public List<Integer> search(String text,int from,int size){
        List<Integer> res = new ArrayList<Integer>();
        SearchResponse searchResponse = esService.query(text,from,size);
        SearchHit[] searchHits= searchResponse.getHits().getHits();
        for(SearchHit s:searchHits){
            res.add(Integer.parseInt(s.getId().trim()));
        }
        return res;
    }

    public void insert(SearchContent searchContent)throws Exception{
        esService.insert(mapper.writeValueAsString(searchContent),searchContent.getId());
    }

   public void insert(List<SearchContent> searchContents)throws Exception{

        for(SearchContent s:searchContents){
            esService.insert(mapper.writeValueAsString(s),s.getId());
        }
    }

    public void update(SearchContent searchContent)throws Exception{
        esService.update(mapper.writeValueAsString(searchContent),searchContent.getId());
    }

    public void update(List<SearchContent> searchContents)throws Exception{
        for(SearchContent s:searchContents){
            esService.update(mapper.writeValueAsString(s),s.getId());
        }
    }

    public void delete(int id)throws Exception{
        esService.delete(id);
    }
}
