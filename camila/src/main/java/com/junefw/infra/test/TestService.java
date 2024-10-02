package com.junefw.infra.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DefaultedRedisConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junefw.common.base.BaseService;
import com.junefw.infra.code.CodeDao;
import com.junefw.infra.code.CodeDto;
import com.junefw.infra.code.CodeService;

import jakarta.annotation.PostConstruct;

@Service
public class TestService extends BaseService {
	
//	@Autowired
//	private RedisTemplate<String, Object> redisTemplate;
//	
//	@Autowired
//	CodeDao dao;
//	
//	private static RedisTemplate<String, Object> staticRedisTemplate;
//	
//	@PostConstruct
//	public void init() {
//		staticRedisTemplate = this.redisTemplate;
//	}
//	
//	@PostConstruct
//    public void init1() {
//        // Initialization logic
//    }
//
//	@Autowired
//	CodeService service;
//	
//
//	ObjectMapper objectMapper = new ObjectMapper();


//    public static String getRequest2(int code) throws Exception {
//    	 ValueOperations<String, Object> vop = staticRedisTemplate.opsForValue();
// 	    String rt ="";
// 	    // 모든 키 가져오기 
// 	    Set<String> keys = staticRedisTemplate.keys("*");
// 	    if (keys != null) {
// 	        for (String key : keys) {
// 	            Object dtoObject = vop.get(key);
//
// 	            if (dtoObject instanceof CodeDto) {
// 	                CodeDto dtos = (CodeDto) dtoObject;  
// 	                if (dtos.getIfcdSeq().equals(String.valueOf(code)) ) {
// 	                    rt = dtos.getIfcdName();
// 	                }
// 	            }
//
// 	        }
// 	    }
//
// 	    return rt;
//    }
    
    
    
    
    
//    RedisAPI(By TestRestController)==========================================================================
    
//  @PostConstruct
//  public void setKeyValue() throws Exception {
//  	ValueOperations<String, Object> vop = staticRedisTemplate.opsForValue();
//  	int i = 0;
//      for (CodeDto dto : service.selectListCachedCodeArrayList1()) {
//          String key = String.valueOf(i);
//          vop.set(key, dto);  // Redis에 데이터 저장
//          i++;
//      }
//      
//      System.out.println("redisCodeArrayList to Radis: " + CodeDto.radisCodeArrayList.size() + " uploaded !");
//  }
//  
//  public static String getRequest(int code) throws Exception {
//  	// RestTemplate 객체 생성
//  	RestTemplate restTemplate = new RestTemplate();
//  	
//  	 // 요청 URL 설정
//      String baseUrl = "http://localhost:8090";
//
//      // URI 컴포넌트를 사용하여 파라미터 추가
//      URI url = UriComponentsBuilder
//              .fromUriString(baseUrl)
//              .path("/rest/test/{ifcgSeq}")
//              .buildAndExpand(3)  // {ifcgSeq}에 대한 값을 대체
//              .toUri();
//      
//  	HttpHeaders header = new HttpHeaders();
////      header.set("Content-Type", "application/json");
//      HttpEntity<?> entity = new HttpEntity<>(header);
//      
//  	// HTTP GET 요청
//      ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
//  	 
//  	 String responseBody = response.getBody();
//       
//       ObjectMapper objectMapper = new ObjectMapper();
//       
//       JsonNode jsonArray = objectMapper.readTree(responseBody); // JSON 배열 읽기
//
//       String rt = ""; 
//
//       for (JsonNode jsonNode : jsonArray) {
//      	 if(jsonNode.has("ifcdSeq")) {
//      	 
//	             if (jsonNode.get("ifcdSeq").asText().equals(String.valueOf(code))) {
//	                 rt = jsonNode.get("ifcdName").asText(); 
//	             }else {
////	            	 by pass
//	             }
//      	 }else {
////      		 by pass
//      	 }
//       }
//
//       return rt;
//   }
    
    
//	RedisCached Code ===========================================================
	
//	@PostConstruct
//	public void setKeyValue() throws Exception {
//	    ValueOperations<String, Object> vop = staticRedisTemplate.opsForValue();
//	    int i = 0;
//
//	    // Redis에 데이터 저장
//	    for (CodeDto dto : service.selectListCachedCodeArrayList1()) {
//	        String key = String.valueOf(i);
//	        vop.set(key, dto);
//	        i++;
//	    }
//
//	    CodeDto.radisCodeArrayList.clear();
//
//	    // Redis에서 가져온 값을 CodeDto로 변환
//	    for (int j = 0; j < i; j++) {
////	    	j는 integer인데 key type은 String
//	        Object dtoObject = vop.get(String.valueOf(j));
//	        if (dtoObject instanceof CodeDto) {
//	            CodeDto dtos = (CodeDto) dtoObject;  
//	            CodeDto.radisCodeArrayList.add(dtos);
//	        }
//	    }
//
//	    System.out.println("cachedRedisCodeArrayList: " + CodeDto.radisCodeArrayList.size() + " chached !");
//	    System.out.println("redisCodeArrayList to Radis: " + CodeDto.radisCodeArrayList.size() + " uploaded !");
//	}
//	
//    public String selectOneRadisCode(int code) throws Exception {
//    	String rt ="";
//    	for(CodeDto codeRow : CodeDto.radisCodeArrayList) {
//			if (codeRow.getIfcdSeq().equals(Integer.toString(code))) {
//				rt = codeRow.getIfcdName();
//			} else {
//				// by pass
//			}
//			System.out.println(codeRow +"2222222222222222222222222");
//		}
//		return rt;
//    }
	
	
	
//	======================================================
	
    
    
}
