package com.oh.my.news.search.util;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentHashMap;
@Component
public class ESClient {
	
	private static TransportClient client;

	@Value("#{configProperties['cluster_name']}")
	private  String clusterName;
	@Value("#{configProperties['node_ip']}")
	private  String nodeIp;

	public  Client getClient() throws ElasticsearchException, UnknownHostException{
		if(client!=null)
			return client;
		synchronized (ESClient.class) {
			if(client!=null){
				return client;
			}
			Settings settings = ImmutableSettings.settingsBuilder().put("client.transport.sniff", true)
					.put("client", true)//仅作为客户端连接
					.put("data", false)
					.put("cluster.name", clusterName)//集群名称
					.build();
			client =  new TransportClient(settings);
				client.addTransportAddress(new InetSocketTransportAddress(
		        		nodeIp, 9300));

			return client;
		}

	}


	

}
