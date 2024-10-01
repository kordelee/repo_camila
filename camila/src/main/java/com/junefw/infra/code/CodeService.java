package com.junefw.infra.code;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junefw.common.base.BaseService;

import jakarta.annotation.PostConstruct;

@Service
public class CodeService extends BaseService{
	
	@Autowired
	CodeDao dao;
    
	
	public int selectOneCount(CodeVo vo) { 
    	return dao.selectOneCount(vo); 
    }

	
	public List<CodeDto> selectList(CodeVo vo) { 
		return dao.selectList(vo); 
	}
	
	
    public CodeDto selectOne(CodeVo vo) { 
    	return dao.selectOne(vo); 
    }
    
    
    public int insert(CodeDto dto) throws Exception {
    	setRegMod(dto);
    	return dao.insert(dto); 
    }
    
    
    public int update(CodeDto dto) throws Exception {
    	setRegMod(dto);
    	return dao.update(dto); 
    }
    
    
    public int uelete(CodeDto dto) throws Exception {
    	setRegMod(dto);
    	return dao.uelete(dto); 
    }
    
    
    public int delete(CodeVo vo) { 
    	return dao.delete(vo); 
    }
    
    
    @PostConstruct
	public void selectListCachedCodeArrayList() throws Exception {
		List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) dao.selectListCachedCodeArrayList();
//		codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
		CodeDto.cachedCodeArrayList.clear(); 
		CodeDto.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
	}
    
//    redisTest
    public List<CodeDto> selectListCachedCodeArrayList1() throws Exception {
    	List<CodeDto> codeListFromDb = (ArrayList<CodeDto>) dao.selectListCachedCodeArrayList();
//		codeListFromDb = (ArrayList<Code>) dao.selectListCachedCodeArrayList();
    	System.out.println("cachedCodeArrayList: " + CodeDto.cachedCodeArrayList.size() + " chached !");
    	return codeListFromDb;
    }

	
	public static void clear() throws Exception {
		CodeDto.cachedCodeArrayList.clear();
	}
	
	
	public static List<CodeDto> selectListCachedCode(String ifcgSeq) throws Exception {
		List<CodeDto> rt = new ArrayList<CodeDto>();
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getIfcgSeq().equals(ifcgSeq)) {
				rt.add(codeRow);
			} else {
				// by pass
			}
		}
		return rt;
	}

	
	public static String selectOneCachedCode(int code) throws Exception {
		String rt = "";
		for(CodeDto codeRow : CodeDto.cachedCodeArrayList) {
			if (codeRow.getIfcdSeq().equals(Integer.toString(code))) {
				rt = codeRow.getIfcdName();
			} else {
				// by pass
			}
		}
		return rt;
	}

}
