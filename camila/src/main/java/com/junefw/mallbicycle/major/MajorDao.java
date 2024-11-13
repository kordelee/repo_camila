package com.junefw.mallbicycle.major;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.junefw.common.base.BaseDao;

@Repository
public interface MajorDao extends BaseDao {

	public void setRegMod(MajorDto dto);
	public void uploadFiles(MultipartFile[] multipartFiles, MajorDto dto, String tableName, int type);
	
//	goods
	public int selectOneCountMajorGoods(MajorVo vo);
	public List<MajorDto> selectListMajorGoods(MajorVo vo); 
	public MajorDto selectOneMajorGoods(MajorVo vo);
	public int insertMajorGoods(MajorDto dto);
	public int updateMajorGoods(MajorDto dto); 
	public int ueleteMajorGoods(MajorDto dto); 
	public int deleteMajorGoods(MajorVo vo);
	
//	trade
	public int selectOneCountMajorTrade(MajorVo vo);
	public List<MajorDto> selectListMajorTrade(MajorVo vo); 
	public MajorDto selectOneMajorTrade(MajorVo vo);
	public int insertMajorTrade(MajorDto dto);
	public int updateMajorTrade(MajorDto dto); 
	public int updateMajorTradeSalesNy(MajorDto dto); 
	public int ueleteMajorTrade(MajorDto dto); 
	public int deleteMajorTrade(MajorVo vo);
	
//	favorite
	public int selectOneCountMajorFavorite(MajorVo vo);
	public List<MajorDto> selectListMajorFavorite(MajorVo vo); 
	public MajorDto selectOneMajorFavorite(MajorVo vo);
	public int insertMajorFavorite(MajorDto dto);
	public int ueleteMajorFavorite(MajorDto dto); 
	public int deleteMajorFavorite(MajorVo vo);

//	show
	public int selectOneCountMajorShow(MajorVo vo);
	public List<MajorDto> selectListMajorShow(MajorVo vo); 
	public MajorDto selectOneMajorShow(MajorVo vo);	
	
//	hit
	public int insertMajorHit(MajorDto dto);
	
}
