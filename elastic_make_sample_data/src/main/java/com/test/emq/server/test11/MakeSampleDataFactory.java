package com.test.emq.server.test11;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;

import sample.model.UpdateStatus;

public class MakeSampleDataFactory {

	RestHighLevelClient client;
	
	public MakeSampleDataFactory(RestHighLevelClient clientInput) {
		client = clientInput;
	}
	
	// 업데이트 샘플 데이터 생성
	public void makeUpdateSample() throws IOException {
		
		// 몇 일 전부터 데이터 만들지
		int fromDay = 10;
		
		Long now = System.currentTimeMillis();
		System.out.println("현재 : " + new Date(now));
		Long startTime = System.currentTimeMillis() - (fromDay * 24 * 60 * 60 * 1000);

		for(;startTime < now; startTime += (long)(1000 * 60 *60 * 2)) {
			// 샘플 데이터 생성 : i=stb종류(샘플 데이터는 * 5정도 생성됨)
			int stb_count = (int)(Math.random()* 50) +20;
//			int stb_count = 80000;
			System.out.println("일시 : " + new Date(startTime) + " stb count : " + stb_count);
			for(int i=0; i<stb_count; i++) {
				genSampleUpdateStatus(i,client, startTime);
			}
		}
		
	}
	
	// VOC 샘플 데이터 생성
	public void makeStbVocSample() {
//		System.out.println("dd");
	}
	
	
	// 샘플 데이터 생성
	public void genSampleUpdateStatus(int i, RestHighLevelClient client, long startTime) throws IOException {
		
		int seed = (int)(Math.random() * 100);
		Long temp = (long) 0;
		String error_code = "000";
//		System.out.println("seed = " + seed);
			
		for(int j=0;j<(seed>=5?5:(seed+1));j++) {
			
			UpdateStatus us = new UpdateStatus();
			us.setStb_id("0000-000-0001" + i);
			us.setSw_nm("Full patch");
			us.setSw_ver("5.1.1.0000");
			us.setCust_type("Mass");
			us.setUpdate_plan_nm("UP_000002");
			if(i>1000)
				us.setUpdate_exec_nm("UE_000003");
			else
				us.setUpdate_exec_nm("UE_000004");
			String stat="";
			if(j==0) {
				stat = "Push발송";
				if(seed==j) {
					error_code = "990";
				}
			}else if(j==1) {
				stat = "다운로드 시작";
				if(seed==j) {
					error_code = "991";
				}
			}else if(j==2) {
				stat = "다운로드 완료";
				if(seed==j) {
					error_code = "992";
				}
			}else if(j==3) {
				stat = "설치 시작";
				if(seed==j) {
					error_code = "993";
				}
			}else if(j==4) {
				stat = "설치 완료";
				if(seed==j) {
					error_code = "994";
				}
			}
			
			// 모델명 세팅
			
			if(seed%12 == 0) {
				us.setModel_nm("BKO-UH400");
			}else if(seed%12 == 1){
				us.setModel_nm("BKO-100");
			}else if(seed%12 == 2){
				us.setModel_nm("BKO-200");
			}else if(seed%12 == 3){
				us.setModel_nm("BKO-300");
			}else if(seed%12 == 4){
				us.setModel_nm("BKO-400");
			}else if(seed%12 == 5){
				us.setModel_nm("BKO-500");
			}else if(seed%12 == 6){
				us.setModel_nm("BKO-600");
			}else if(seed%12 == 7){
				us.setModel_nm("BKO-700");
			}else if(seed%12 == 8){
				us.setModel_nm("BKO-800");
			}else if(seed%12 == 9){
				us.setModel_nm("BKO-900");
			}else if(seed%12 == 10){
				us.setModel_nm("BKO-100S");
			}else if(seed%12 == 11){
				us.setModel_nm("BKO-AI200");
			}
			
			// 통합품솔 세팅
			if(seed%14 == 0) {
				us.setTeam_nm("동작품질솔루션팀");
			}else if(seed%14 == 1) {
				us.setTeam_nm("수원품질솔루션팀");
			}else if(seed%14 == 2) {
				us.setTeam_nm("부산품질솔루션팀");
			}else if(seed%14 == 3) {
				us.setTeam_nm("강남품질솔루션팀");
			}else if(seed%14 == 4) {
				us.setTeam_nm("인천품질솔루션팀");
			}else if(seed%14 == 5) {
				us.setTeam_nm("전북품질솔루션팀");
			}else if(seed%14 == 6) {
				us.setTeam_nm("전남품질솔루션팀");
			}else if(seed%14 == 7) {
				us.setTeam_nm("충청품질솔루션팀");
			}else if(seed%14 == 8) {
				us.setTeam_nm("경북품질솔루션팀");
			}else if(seed%14 == 9) {
				us.setTeam_nm("경남품질솔루션팀");
			}else if(seed%14 == 10) {
				us.setTeam_nm("강동품질솔루션팀");
			}else if(seed%14 == 11) {
				us.setTeam_nm("강북품질솔루션팀");
			}else if(seed%14 == 12) {
				us.setTeam_nm("강원품질솔루션팀");
			}else if(seed%14 == 13) {
				us.setTeam_nm("제주품질솔루션팀");
			}
			
			
			// 업데이트 조건 세팅
			if(seed%10 == 0) {
				us.setRouting("Wake Up");
			}else if(seed%10 == 1) {
				us.setRouting("Wake Up");
			}else if(seed%10 == 2) {
				us.setRouting("Sleep");
			}else if(seed%10 == 3) {
				us.setRouting("Sleepp");
			}else if(seed%10 == 4) {
				us.setRouting("Sleep");
			}else if(seed%10 == 5) {
				us.setRouting("Manual");
			}else if(seed%10 == 6) {
				us.setRouting("Sleep State");
			}else if(seed%10 == 7) {
				us.setRouting("Wake Up");
			}else if(seed%10 == 8) {
				us.setRouting("Cold Booting");
			}else if(seed%10 == 9) {
				us.setRouting("Sleep");
			}
			
			// random seed2 생성
			int seed2 = (int)(Math.random() * 80)+20;
			
			// 시간 세팅
			if(j == 0) {
				temp = startTime;
				temp = temp + seed2*seed2*1000 - 3600000;
				Date date = new Date(temp);
				us.setCreated_time(date);
			}else {
				temp = temp + seed2 * j * 20 + (j%2 * 1000 * (seed2%5+2));
				Date date = new Date(temp);
				us.setCreated_time(date);
			}
		
			us.setStatus(stat);
			us.setError_code(error_code);
			
			// 로그 샘플 입력
			indexSampleUpdateStatus(us, client, i);
		}
	}
	
	// 샘플 데이터 입력
	public void indexSampleUpdateStatus(UpdateStatus us, RestHighLevelClient client, int i) throws IOException {
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("created_time", us.getCreated_time());
		jsonMap.put("stb_id", us.getStb_id());
		jsonMap.put("route_condition", us.getRouting());
		jsonMap.put("sw_nm", us.getSw_nm());
		jsonMap.put("team_nm", us.getTeam_nm());
		jsonMap.put("model_nm", us.getModel_nm());
		jsonMap.put("sw_ver", us.getSw_ver());
		jsonMap.put("cust_type", us.getCust_type());
		jsonMap.put("update_plan_id", us.getUpdate_plan_nm());
		jsonMap.put("update_exec_id", us.getUpdate_exec_nm());
		jsonMap.put("status", us.getStatus());
		jsonMap.put("error_code", us.getError_code());
		
		IndexRequest indexRequest = new IndexRequest("tiger", "tiger").source(jsonMap);
		
		IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);

//		System.out.println("결과 : " + i + "차수" + indexResponse.getResult());
	}
}
