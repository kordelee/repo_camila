package com.junefw.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junefw.common.base.BaseService;

@Service
public class MemberService extends BaseService{
	
	@Autowired
	MemberDao dao;
    
	
	public int selectOneCount(MemberVo vo) { 
    	return dao.selectOneCount(vo); 
    }

	
	public List<MemberDto> selectList(MemberVo vo) { 
		return dao.selectList(vo); 
	}
	
	
    public MemberDto selectOne(MemberVo vo) { 
    	return dao.selectOne(vo); 
    }
    
    
    public int insert(MemberDto dto) throws Exception {
    	setRegMod(dto);
    	return dao.insert(dto); 
    }
    
    
    public int update(MemberDto dto) throws Exception {
    	setRegMod(dto);
    	return dao.update(dto); 
    }
    
    
    public int uelete(MemberDto dto) throws Exception {
    	setRegMod(dto);
    	return dao.uelete(dto); 
    }
    
    
    public int delete(MemberVo vo) { 
    	return dao.delete(vo); 
    }
    
}
