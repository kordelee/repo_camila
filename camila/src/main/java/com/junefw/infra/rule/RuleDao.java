package com.junefw.infra.rule;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.junefw.common.base.BaseDao;

@Repository
public interface RuleDao extends BaseDao {

	public int selectOneCount(RuleVo vo);
    public List<RuleDto> selectList(RuleVo vo);
    public RuleDto selectOne(RuleVo vo);
    public int insert(RuleDto dto);
    public int update(RuleDto dto);
    public int uelete(RuleDto dto);
    public int delete(RuleVo vo);
    
    public List<RuleDto> selectListWithoutPaging();
}
