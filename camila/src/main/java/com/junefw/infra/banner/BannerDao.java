package com.junefw.infra.banner;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.junefw.common.base.BaseDao;

@Repository
public interface BannerDao extends BaseDao {

	public int selectOneCount(BannerVo vo);
    public List<BannerDto> selectList(BannerVo vo);
    public BannerDto selectOne(BannerVo vo);
    public int insert(BannerDto dto);
    public int update(BannerDto dto);
    public int uelete(BannerDto dto);
    public int delete(BannerVo vo);
    
    public List<BannerDto> selectListWithoutPaging();
}
