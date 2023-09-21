package com.junefw.infra.code;

import java.util.List;

import com.junefw.common.base.BaseDao;

public interface CodeDao extends BaseDao{

    public int selectOneCount(CodeVo vo);
    public List<CodeDto> selectList(CodeVo vo);
    public CodeDto selectOne(CodeVo vo);
    public int insert(CodeDto dto);
    public int update(CodeDto dto);
    public int uelete(CodeDto dto);
    public int delete(CodeVo vo);
    
    public List<CodeDto> selectListCachedCodeArrayList();
}
