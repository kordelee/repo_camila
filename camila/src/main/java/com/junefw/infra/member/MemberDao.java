package com.junefw.infra.member;

import java.util.List;

import com.junefw.common.base.BaseDao;

public interface MemberDao extends BaseDao{

    public int selectOneCount(MemberVo vo);
    public List<MemberDto> selectList(MemberVo vo);
    public MemberDto selectOne(MemberVo vo);
    public int insert(MemberDto dto);
    public int update(MemberDto dto);
    public int uelete(MemberDto dto);
    public int delete(MemberVo vo);
	public List<MemberDto> selectListUploaded(MemberVo vo);
	
	public int useUpdate(MemberDto dto);
    
//	upload
	public int insertUploaded(MemberDto dto);
	public int ueleteUploaded(MemberDto dto);
	public int deleteUploaded(MemberDto dto);
	
	
//  signin
	public MemberDto selectOneId(MemberDto dto);
	public MemberDto selectOneLogin(MemberDto dto);
	public int insertLogLogin(MemberDto dto);
	public int updateIfmmPwdModDate(MemberDto dto);
	
	
	public int insertEmail(MemberDto dto);
	public int insertPhone(MemberDto dto);
	public int insertAddress(MemberDto dto);
	
//	
//	usr
//	
	
	public MemberDto selectOneFindIdPwd(MemberDto dto);
	
//	signupUsr
	public int selectOneIdCheck(MemberDto dto);
	public int selectOneEmailCheck(MemberDto dto);
	
	
//	findPwd
	public int insertCertification(MemberDto dto);
	public MemberDto selectOneCertification(MemberDto dto);
	public int updateChangePwd(MemberDto dto);
	
	
//	infoChange
	public int updateInfo(MemberDto dto);
	
//	withdraw
	public int ueleteWithdraw(MemberDto dto);
}
