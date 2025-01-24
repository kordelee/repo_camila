package com.junefw.infra.category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junefw.common.base.BaseService;

import jakarta.annotation.PostConstruct;

@Service 
public class CategoryService extends BaseService {

	@Autowired
	CategoryDao dao;
	
    public int selectOneCount(CategoryVo vo) { 
    	return dao.selectOneCount(vo); 
    }
    
    
    public List<CategoryDto> selectList(CategoryVo vo) { 
    	return dao.selectList(vo); 
    }
    
    
    public CategoryDto selectOne(CategoryVo vo) { 
    	return dao.selectOne(vo); 
    }
    
    
    public int insert(CategoryDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.insert(dto); 
    }

    
    public int update(CategoryDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.update(dto); 
    }
    
    
    public int uelete(CategoryDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.uelete(dto); 
    }
    
    
    public int delete(CategoryVo vo) { 
    	return dao.delete(vo);
    }
    
//    redis사용시 사용하지 않음
//    @PostConstruct
	public void selectListCachedCategoryArrayList() throws Exception {
		List<CategoryDto> categoryListFromDb = (ArrayList<CategoryDto>) dao.selectListCachedCategoryArrayList();
//		codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
		CategoryDto.cachedCategoryArrayList.clear(); 
		CategoryDto.cachedCategoryArrayList.addAll(categoryListFromDb);
		System.out.println("cachedCategoryArrayList: " + CategoryDto.cachedCategoryArrayList.size() + " chached !");
	}
    
    public static void clear() throws Exception {
		CategoryDto.cachedCategoryArrayList.clear();
	}
	
	
	public static List<CategoryDto> selectListCachedCateogry1() throws Exception {
		List<CategoryDto> rt = new ArrayList<CategoryDto>();
		
		for(CategoryDto categoryRow : CategoryDto.cachedCategoryArrayList) {
			if(categoryRow.getIfctDepth() == 1) {
				rt.add(categoryRow);
			}
		}
		return rt;
	}
	
	
	public static List<CategoryDto> selectListCachedCategory2() throws Exception {
		List<CategoryDto> rt = new ArrayList<CategoryDto>();
		
		for(CategoryDto categoryRow : CategoryDto.cachedCategoryArrayList) {
			if(categoryRow.getIfctDepth() == 2) {
				rt.add(categoryRow);
			}
		}
		return rt;
	}
	
	
	public static List<CategoryDto> selectListCachedCategory2(int depth) throws Exception {
		List<CategoryDto> rt = new ArrayList<CategoryDto>();
		
		for(CategoryDto categoryRow : CategoryDto.cachedCategoryArrayList) {
			if(categoryRow.getIfctDepth() == depth && Integer.parseInt(categoryRow.getIfctSeq()) != depth) {
				rt.add(categoryRow);
			}
		}
		return rt;
	}
	
	
//	public static List<CategoryDto> selectListCachedCategory2ForList(List<RaceAdArea1Dto> aaa) throws Exception {
//		List<CategoryDto> rt = new ArrayList<CategoryDto>();
//		
//		for(CategoryDto categoryRow : CategoryDto.cachedCategoryArrayList) {
//			for(RaceAdArea1Dto raceAdArea1Dto: aaa) {
//				if(categoryRow.getIfctDepth() == raceAdArea1Dto.getFaa1AdArea1Cd() && Integer.parseInt(categoryRow.getIfctSeq()) != raceAdArea1Dto.getFaa1AdArea1Cd()) {
//					rt.add(categoryRow);
//				}
//			}
//		}
//		return rt;
//	}

	
	public static String selectOneCachedCategory(int code) throws Exception {
		String rt = "";
		
		for(CategoryDto categoryRow : CategoryDto.cachedCategoryArrayList) {
			if (categoryRow.getIfctSeq().equals(Integer.toString(code))) {
				rt = categoryRow.getIfctName();
			} else {
				// by pass
			}
		}
		return rt;
	}    
}
