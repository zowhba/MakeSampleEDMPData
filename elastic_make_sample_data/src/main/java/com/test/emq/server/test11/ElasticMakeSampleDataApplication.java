package com.test.emq.server.test11;

//import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;

import org.apache.http.HttpHost;
//import org.elasticsearch.action.index.IndexRequest;
//import org.elasticsearch.action.index.IndexResponse;
//import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticMakeSampleDataApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ElasticMakeSampleDataApplication.class, args);
		
		try {
			runMakeSampl();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	
	static void runMakeSampl() throws IOException {
		
		RestHighLevelClient client = new RestHighLevelClient(
		        RestClient.builder(
		                new HttpHost("localhost", 9200, "http")));
		
		MakeSampleDataFactory makeSampleDataFactory = new MakeSampleDataFactory(client);
		makeSampleDataFactory.makeUpdateSample();
		makeSampleDataFactory.makeStbVocSample();
		client.close();
	}
			
}