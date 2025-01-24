package com.junefw.infra.category;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.junefw.common.base.BaseDao;

@Repository
public interface CategoryDao extends BaseDao {

	public int selectOneCount(CategoryVo vo);
    public List<CategoryDto> selectList(CategoryVo vo);
    public CategoryDto selectOne(CategoryVo vo);
    public int insert(CategoryDto dto);
    public int update(CategoryDto dto);
    public int uelete(CategoryDto dto);
    public int delete(CategoryVo vo);
    
    public List<CategoryDto> selectListCachedCategoryArrayList();
}
