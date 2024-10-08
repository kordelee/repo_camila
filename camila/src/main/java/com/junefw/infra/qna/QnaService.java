package com.junefw.infra.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junefw.common.base.BaseService;

@Service
public class QnaService extends BaseService{

	@Autowired
	QnaDao dao;
    
    public int selectOneCount(QnaVo vo) { 
    	return dao.selectOneCount(vo); 
    }
    
    
    public List<QnaDto> selectList(QnaVo vo) { 
    	return dao.selectList(vo); 
    }
    
    
    public QnaDto selectOne(QnaVo vo) { 
    	return dao.selectOne(vo); 
    }
    
    
    public int insert(QnaDto dto) throws Exception { 
    	setRegMod(dto);
    	dao.insert(dto);
    	
    	return 1; 
    }

    
    public int update(QnaDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.update(dto); 
    }
    
    
    public int uelete(QnaDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.uelete(dto); 
    }
    
    
    public int delete(QnaVo vo) { 
    	return dao.delete(vo);
    }
    
    
    public List<QnaDto> selectListWithoutPaging() { 
    	return dao.selectListWithoutPaging(); 
    }
    
//    
//    usr
//    
    
    public List<QnaDto> selectMyList(QnaVo vo) throws Exception {
    	return dao.selectMyList(vo);
    }
}
