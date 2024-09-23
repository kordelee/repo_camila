package com.junefw.infra.template;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.junefw.common.base.BaseDao;

@Repository
public interface TemplateDao extends BaseDao {

	 public int selectOneCount(TemplateVo vo);
	    public List<TemplateDto> selectList(TemplateVo vo);
	    public TemplateDto selectOne(TemplateVo vo);
	    public int insert(TemplateDto dto);
	    public int update(TemplateDto dto);
	    public int uelete(TemplateDto dto);
	    public int delete(TemplateVo vo);
	    
	    public List<TemplateDto> selectListWithoutPaging();
}
