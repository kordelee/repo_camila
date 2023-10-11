package com.junefw.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junefw.common.base.BaseService;

@Service
public class CodeGroupService extends BaseService{

	@Autowired
	CodeGroupDao dao;
    
    public int selectOneCount(CodeGroupVo vo) { 
    	return dao.selectOneCount(vo); 
    }
    
    
    public List<CodeGroupDto> selectList(CodeGroupVo vo) { 
    	return dao.selectList(vo); 
    }
    
    
    public CodeGroupDto selectOne(CodeGroupVo vo) { 
    	return dao.selectOne(vo); 
    }
    
    
    public int insert(CodeGroupDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.insert(dto); 
    }

    
    public int update(CodeGroupDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.update(dto); 
    }
    
    
    public int uelete(CodeGroupDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.uelete(dto); 
    }
    
    
    public int delete(CodeGroupVo vo) { 
    	return dao.delete(vo);
    }
    
    
    public List<CodeGroupDto> selectListWithoutPaging() { 
    	return dao.selectListWithoutPaging(); 
    }
}
