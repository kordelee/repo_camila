 package com.junefw.infra.codegroup;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.junefw.common.base.BaseDao;

@Repository
public interface CodeGroupDao extends BaseDao{
	
    public int selectOneCount(CodeGroupVo vo);
    public List<CodeGroupDto> selectList(CodeGroupVo vo);
    public CodeGroupDto selectOne(CodeGroupVo vo);
    public int insert(CodeGroupDto dto);
    public int update(CodeGroupDto dto);
    public int uelete(CodeGroupDto dto);
    public int delete(CodeGroupVo vo);
    
    public List<CodeGroupDto> selectListWithoutPaging();
    
}
