package com.junefw.infra.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
public class RedisService extends BaseService {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	@Autowired
	CodeDao dao;
	
	private static RedisTemplate<String, Object> staticRedisTemplate;
	
	@PostConstruct
	public void init() {
		staticRedisTemplate = this.redisTemplate;
	}
	
	@PostConstruct
    public void init1() {
        // Initialization logic
    }

	@Autowired
	CodeService service;
	

	ObjectMapper objectMapper = new ObjectMapper();


	@PostConstruct
	public void redisList() throws Exception {
	    ListOperations<String, Object> vop = staticRedisTemplate.opsForList();
	    List<Object> value = vop.range("codeGroup", 0, -1);
//	    key 삭제
	    Set<String> keys = redisTemplate.keys("*"); 
	        if (keys != null) {
	            redisTemplate.delete(keys); 
	        }
	        
	    // DB에서 가져온 리스트
	    for (CodeDto codeListFromDb : service.selectListCachedCodeArrayList1()) {
	        // 개별 값들을 리스트에 추가
	    	
	    	List<String> redisList = new ArrayList<String>();
	    	redisList.add(codeListFromDb.getIfcdSeq());
	    	redisList.add(codeListFromDb.getIfcdName());
	    	redisList.add(codeListFromDb.getIfcgSeq());
	        
	        vop.rightPush("codeGroup", redisList);  // 	    }
	    }
//	    System.out.println(value.get(0).getClass().getName()+"@@@@@@@@@@@@@@@@@@@@@@@");
//	    System.out.println(vop.size("codeGroup") + "afewawegaewgawge");
//	    System.out.println("redisCodeArrayList to Redis: "+ " uploaded !");
	}
	

  @SuppressWarnings("unchecked")
public static String getRequest2(int code) throws Exception {
	  ListOperations<String, Object> vop = staticRedisTemplate.opsForList();  
    String rt ="";
    // 모든 키 가져오기 
    List<Object> value = vop.range("codeGroup", 0, -1);
        for (int i=0; i<value.size(); i++) {
    		if(String.valueOf(code).equals(((List<Object>) value.get(i)).get(0))) {
    			rt =(String) ((List<Object>) value.get(i)).get(1);
    		}
//        	String[] split = aaa.split(",");
//        	String ifcdSeq =split[0].trim().substring(1);
//            if(ifcdSeq.equals(String.valueOf(code))) {
//            	String ifcdName = split[1].trim();  
//            	rt = ifcdName;
//            	System.out.println(rt);
//            }
        }
    
    return rt;
}
}
