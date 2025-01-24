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
import com.junefw.infra.category.CategoryDao;
import com.junefw.infra.category.CategoryDto;
import com.junefw.infra.code.CodeDao;
import com.junefw.infra.code.CodeDto;

import jakarta.annotation.PostConstruct;

@Service
public class RedisService extends BaseService {

	@Autowired
	CodeDao codeDao;
	
	@Autowired
	CategoryDao categoryDao;
	
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
	        
	    	ListOperations.rightPush(Constants.PROJECT_NAME + "code", redisList);
	    }
	    
		for (CategoryDto categoryListFromDb : categoryDao.selectListCachedCategoryArrayList()) {
	    	List<String> redisList = new ArrayList<String>();
	    	redisList.add(categoryListFromDb.getIfctSeq());
	    	redisList.add(categoryListFromDb.getIfctName());
	    	redisList.add(categoryListFromDb.getIfctParents().toString());
	    	redisList.add(categoryListFromDb.getIfctDepth().toString());
	    	redisList.add(categoryListFromDb.getIfctOrder().toString());
	    	if(categoryListFromDb.getIfctUseNy() == 1) {
				redisList.add(categoryListFromDb.getIfctUseNy().toString());
			}
	        
	    	ListOperations.rightPush(Constants.PROJECT_NAME + "category", redisList);
	    }
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Object> selectListCodeInRedisList(String ifcgSeq) throws Exception {
		ListOperations<String, Object> ListOperations = staticRedisTemplate.opsForList();
		
		List<Object> rt = new ArrayList<Object>();
		
		List<Object> value = ListOperations.range(Constants.PROJECT_NAME + "code", 0, -1);
		
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
		
		List<Object> value = vop.range(Constants.PROJECT_NAME + "code", 0, -1);
		
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
	
	
	@SuppressWarnings("unchecked")
	public static List<Object> selectListCategoryInRedisList(String parents) throws Exception {
		ListOperations<String, Object> ListOperations = staticRedisTemplate.opsForList();
		
		List<Object> rt = new ArrayList<Object>();
		
		List<Object> value = ListOperations.range(Constants.PROJECT_NAME + "category", 0, -1);
		
		for (int i=0; i<value.size(); i++) {
//			value.get(i)).get(2) : ifctParents
			if(parents.equals(((List<Object>) value.get(i)).get(2))) {
//				value.get(i)).get(1): ifctName
				CategoryDto catgoryDto = new CategoryDto();
				catgoryDto.setIfctSeq(((List<Object>) value.get(i)).get(0).toString()); 
				catgoryDto.setIfctName(((List<Object>) value.get(i)).get(1).toString());
				catgoryDto.setIfctParents(Integer.valueOf(((List<Object>) value.get(i)).get(2).toString()));
				catgoryDto.setIfctDepth(Integer.valueOf(((List<Object>) value.get(i)).get(3).toString()));
				catgoryDto.setIfctOrder(Integer.valueOf(((List<Object>) value.get(i)).get(4).toString()));
				catgoryDto.setIfctUseNy(Integer.valueOf(((List<Object>) value.get(i)).get(5).toString()));
				rt.add(catgoryDto);
			} else {
//				by pass
			}
		}
		
		return rt;
	}
	
	
	@SuppressWarnings("unchecked")
	public static List<Object> selectListCategory2InRedisList(String parents) throws Exception {
		ListOperations<String, Object> ListOperations = staticRedisTemplate.opsForList();
				
			List<Object> rt = new ArrayList<Object>();
			
			List<Object> value = ListOperations.range(Constants.PROJECT_NAME + "category", 0, -1);
			
			for (int i=0; i<value.size(); i++) {
	//			value.get(i)).get(2) : ifctParents
				if(parents.equals(((List<Object>) value.get(i)).get(2))) {
	//				value.get(i)).get(1): ifctName
					CategoryDto catgoryDto = new CategoryDto();
					catgoryDto.setIfctSeq(((List<Object>) value.get(i)).get(0).toString()); 
					catgoryDto.setIfctName(((List<Object>) value.get(i)).get(1).toString());
					catgoryDto.setIfctParents(Integer.valueOf(((List<Object>) value.get(i)).get(2).toString()));
					catgoryDto.setIfctDepth(Integer.valueOf(((List<Object>) value.get(i)).get(3).toString()));
					catgoryDto.setIfctOrder(Integer.valueOf(((List<Object>) value.get(i)).get(4).toString()));
					catgoryDto.setIfctUseNy(Integer.valueOf(((List<Object>) value.get(i)).get(5).toString()));
					rt.add(catgoryDto);
				} else {
	//				by pass
				}
			}
			
			return rt;
	}
	
	
	@SuppressWarnings("unchecked")
	public static String selectOneCategoryInRedisList(int parents) throws Exception {
		ListOperations<String, Object> ListOperations = staticRedisTemplate.opsForList(); 
		String rt ="";
		
		List<Object> value = ListOperations.range(Constants.PROJECT_NAME + "category", 0, -1);
		
		for (int i=0; i<value.size(); i++) {
//				value.get(i)).get(0) : ifctSeq
			if(String.valueOf(parents).equals(((List<Object>) value.get(i)).get(0))) {
//					value.get(i)).get(1): ifctName
				rt =(String) ((List<Object>) value.get(i)).get(1);
			} else {
//					by pass
			}
		}
		return rt;
	}
	
}
