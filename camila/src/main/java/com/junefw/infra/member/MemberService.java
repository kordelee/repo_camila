package com.junefw.infra.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junefw.common.base.BaseService;
import com.junefw.common.constants.Constants;
import com.junefw.common.util.UtilDateTime;

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
    

	public List<MemberDto> selectListUploaded(MemberVo vo) throws Exception {
		return dao.selectListUploaded(vo);
	}
    
    
//	signin
	public MemberDto selectOneId(MemberDto dto) throws Exception {
		return dao.selectOneId(dto);
	}

	
	public MemberDto selectOneLogin(MemberDto dto) throws Exception {
		return dao.selectOneLogin(dto);
	}
	

	public int insertLogLogin(MemberDto dto) throws Exception {
		setRegMod(dto);
		return dao.insertLogLogin(dto);
	}
	
	
	public int updateIfmmPwdModDate(MemberDto dto) throws Exception {
		dto.setIfmmPwdModDate(UtilDateTime.calculateDayDate(UtilDateTime.nowLocalDateTime(), (int) Constants.PASSWOPRD_CHANGE_INTERVAL));
		return dao.updateIfmmPwdModDate(dto);
	}
}
