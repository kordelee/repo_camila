package com.junefw.infra.popup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junefw.common.base.BaseService;

@Service
public class PopupService extends BaseService{

	@Autowired
	PopupDao dao;
    
    public int selectOneCount(PopupVo vo) { 
    	return dao.selectOneCount(vo); 
    }
    
    
    public List<PopupDto> selectList(PopupVo vo) { 
    	return dao.selectList(vo); 
    }
    
    
    public PopupDto selectOne(PopupVo vo) { 
    	return dao.selectOne(vo); 
    }
    
    
    public int insert(PopupDto dto) throws Exception { 
    	setRegMod(dto);
    	dao.insert(dto);
    	
    	return 1; 
    }

    
    public int update(PopupDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.update(dto); 
    }
    
    
    public int uelete(PopupDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.uelete(dto); 
    }
    
    
    public int delete(PopupVo vo) { 
    	return dao.delete(vo);
    }
    
    
    public List<PopupDto> selectListWithoutPaging() { 
    	return dao.selectListWithoutPaging(); 
    }
}
