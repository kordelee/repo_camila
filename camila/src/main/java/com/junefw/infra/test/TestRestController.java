//package com.junefw.infra.test;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.ValueOperations;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.junefw.infra.code.CodeDto;
//
//import jakarta.annotation.PostConstruct;
//
//@RestController
//@RequestMapping("/rest/test")
//public class TestRestController {
//	
//	@Autowired
//	private RedisTemplate<String, Object> redisTemplate;
//	
//	
//	private static RedisTemplate<String, Object> staticRedisTemplate;
//	
//	@PostConstruct
//	public void init() {
//		staticRedisTemplate = this.redisTemplate;
//	}
//	
//	@GetMapping("{ifcgSeq}")
//	public List<CodeDto> selectList(@PathVariable("ifcgSeq") String ifcgSeq) throws Exception {
//	    ValueOperations<String, Object> vop = staticRedisTemplate.opsForValue();
//	    List<CodeDto> redisList = new ArrayList<>(); 
//
//	    
//	    // 모든 키 가져오기 
//	    Set<String> keys = staticRedisTemplate.keys("*");
//	    if (keys != null) {
//	        for (String key : keys) {
//	            Object dtoObject = vop.get(key);
//
//	            if (dtoObject instanceof CodeDto) {
//	                CodeDto dtos = (CodeDto) dtoObject;  
//	                if (dtos.getIfcgSeq().equals(ifcgSeq) ) {
//	                    redisList.add(dtos);
//	                }
//	            }
//
//	        }
//	    }
//
//	    return redisList;  
//	}
//	
//	
////	@GetMapping("")
////	public Object selectList(CodeVo vo) throws Exception {
////	    ValueOperations<String, Object> vop = staticRedisTemplate.opsForValue();
////	    
////	    Object dtoObject = vop.get(String.valueOf(1));
////	        
////	    return dtoObject;  
////	}
//	
//	
////	@GetMapping("")
////	public Object selectList(int code) throws Exception {
////	    ValueOperations<String, Object> vop = staticRedisTemplate.opsForValue();
////	    ObjectMapper objectMapper = new ObjectMapper();
////	    
////	    Object dtoObject = vop.get(String.valueOf(code));
////	    
////	    RestTemplate restTemplate = new RestTemplate();
////		
////    	// 요청을 보낼 URL
////        String apiUrl = "http://localhost:8090/rest/test";
////	 // HTTP GET 요청 보내기
////        ResponseEntity<String> responseEntity = restTemplate.exchange(
////                apiUrl,
////                HttpMethod.GET,
////                null,
////                String.class
////        );
////
////	    String responseBody = responseEntity.getBody();
////        System.out.println("Exchange GET Response: " + responseBody);
////        // ObjectMapper를 사용하여 JSON 문자열을 Map으로 변환
////        Map<String, Object> responseMap = objectMapper.readValue(responseBody, Map.class);
////        
////        // 원하는 키의 값 가져오기 (예: "yourKey")
////        Object desiredValue = responseMap.get("ifcdName");
////        
////	    return desiredValue;  
////	}
//}
