package com.junefw.infra.template;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junefw.common.base.BaseService;

@Service
public class TemplateService extends BaseService{

	@Autowired
	TemplateDao dao;
    
    public int selectOneCount(TemplateVo vo) { 
    	return dao.selectOneCount(vo); 
    }
    
    
    public List<TemplateDto> selectList(TemplateVo vo) { 
    	return dao.selectList(vo); 
    }
    
    
    public TemplateDto selectOne(TemplateVo vo) { 
    	return dao.selectOne(vo); 
    }
    
    
    public int insert(TemplateDto dto) throws Exception { 
    	setRegMod(dto);
    	dao.insert(dto);
    	
    	return 1; 
    }

    
    public int update(TemplateDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.update(dto); 
    }
    
    
    public int uelete(TemplateDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.uelete(dto); 
    }
    
    
    public int delete(TemplateVo vo) { 
    	return dao.delete(vo);
    }
    
    
    public List<TemplateDto> selectListWithoutPaging() { 
    	return dao.selectListWithoutPaging(); 
    }
}
