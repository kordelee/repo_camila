package com.junefw.common.redis;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.junefw.common.base.BaseService;
import com.junefw.common.constants.Constants;
import com.junefw.infra.code.CodeDao;
import com.junefw.infra.code.CodeDto;

import jakarta.annotation.PostConstruct;

@Service
public class RedisService extends BaseService {

	@Autowired
	CodeDao codeDao;
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	private static RedisTemplate<String, Object> staticRedisTemplate;
	
	@PostConstruct
	public void init() {
		staticRedisTemplate = this.redisTemplate;
	}
	

	@PostConstruct
	public void selectListCodeArrayListInRedisList() throws Exception {
	    ListOperations<String, Object> ListOperations = staticRedisTemplate.opsForList();
	   
	    Set<String> keys = redisTemplate.keys("*"); 
	    
        if (keys != null) {
            redisTemplate.delete(keys); 
        }
	        
	    for (CodeDto codeListFromDb : codeDao.selectListCachedCodeArrayList()) {
	    	
	    	List<String> redisList = new ArrayList<String>();
	    	redisList.add(codeListFromDb.getIfcdSeq());
	    	redisList.add(codeListFromDb.getIfcdName());
	    	redisList.add(codeListFromDb.getIfcgSeq());
	        
	    	ListOperations.rightPush(Constants.PROJECT_NAME + "codeGroup", redisList);
	    }
	}
	

	@SuppressWarnings("unchecked")
	public static List<Object> selectListCodeInRedisList(String ifcgSeq) throws Exception {
		ListOperations<String, Object> ListOperations = staticRedisTemplate.opsForList();
		
		List<Object> rt = new ArrayList<Object>();
		
		List<Object> value = ListOperations.range("codeGroup", 0, -1);
		
		for (int i=0; i<value.size(); i++) {
//			value.get(i)).get(2) : ifcgSeq
			if(ifcgSeq.equals(((List<Object>) value.get(i)).get(2))) {
//				value.get(i)).get(1): ifcdName
				CodeDto codeDto = new CodeDto();
	            codeDto.setIfcdSeq(((List<Object>) value.get(i)).get(0).toString()); 
	            codeDto.setIfcdName(((List<Object>) value.get(i)).get(1).toString());
	            codeDto.setIfcgSeq(((List<Object>) value.get(i)).get(2).toString());
				rt.add(codeDto);
			} else {
//				by pass
			}
		}
		
		return rt;
	}
	

	@SuppressWarnings("unchecked")
	public static String selectOneCodeInRedisList(int code) throws Exception {
		ListOperations<String, Object> vop = staticRedisTemplate.opsForList(); 
	
		String rt ="";
		
		List<Object> value = vop.range("codeGroup", 0, -1);
		
			for (int i=0; i<value.size(); i++) {
//				value.get(i)).get(0) : ifcdSeq
				if(String.valueOf(code).equals(((List<Object>) value.get(i)).get(0))) {
//					value.get(i)).get(1): ifcdName
					rt =(String) ((List<Object>) value.get(i)).get(1);
				} else {
//					by pass
				}
			}
		return rt;
	}	
}
