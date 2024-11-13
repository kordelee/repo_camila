package com.junefw.mallbicycle.major;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junefw.common.base.BaseService;

@Service
public class MajorService extends BaseService {
	
	@Autowired
	MajorDao dao;


//	goods
	public int selectOneCountMajorGoods(MajorVo vo){
		return dao.selectOneCountMajorGoods(vo);
	}
	
	public List<MajorDto> selectListMajorGoods(MajorVo vo) throws Exception {
		return dao.selectListMajorGoods(vo);
	}
	
	public MajorDto selectOneMajorGoods(MajorVo vo) throws Exception {
		return dao.selectOneMajorGoods(vo);
	}
	
	public int insertMajorGoods(MajorDto dto) throws Exception {
		setRegMod(dto);
		return dao.insertMajorGoods(dto);
	}

	public int updateMajorGoods(MajorDto dto) throws Exception {
		setRegMod(dto);
		return dao.updateMajorGoods(dto);
	}
	
	public int ueleteMajorGoods(MajorDto dto) throws Exception {
		setRegMod(dto);
		return dao.ueleteMajorGoods(dto);
	}
	
	public int deleteMajorGoods(MajorVo vo) throws Exception {
		return dao.deleteMajorGoods(vo);
	}
	
	
//	trade
	public int selectOneCountMajorTrade(MajorVo vo){
		return dao.selectOneCountMajorTrade(vo);
	}
	
	public List<MajorDto> selectListMajorTrade(MajorVo vo) throws Exception {
		return dao.selectListMajorTrade(vo);
	}
	
	public MajorDto selectOneMajorTrade(MajorVo vo) throws Exception {
		return dao.selectOneMajorTrade(vo);
	}
	
	public int insertMajorTrade(MajorDto dto) throws Exception {
		setRegMod(dto);
		return dao.insertMajorTrade(dto);
	}
	
	public int updateMajorTrade(MajorDto dto) throws Exception {
		setRegMod(dto);
		return dao.updateMajorTrade(dto);
	}

	public int updateMajorTradeSalesNy(MajorDto dto) throws Exception {
		setRegMod(dto);
		return dao.updateMajorTradeSalesNy(dto);
	}
	
	public int ueleteMajorTrade(MajorDto dto) throws Exception {
		setRegMod(dto);
		return dao.ueleteMajorTrade(dto);
	}
	
	public int deleteMajorTrade(MajorVo vo) throws Exception {
		return dao.deleteMajorTrade(vo);
	}

	
//	favorite
	public int selectOneCountMajorFavorite(MajorVo vo){
		return dao.selectOneCountMajorFavorite(vo);
	}
	
	public List<MajorDto> selectListMajorFavorite(MajorVo vo) throws Exception {
		return dao.selectListMajorFavorite(vo);
	}
	
	public MajorDto selectOneMajorFavorite(MajorVo vo) throws Exception {
		return dao.selectOneMajorFavorite(vo);
	}
	
	public int insertMajorFavorite(MajorDto dto) throws Exception {
		setRegMod(dto);
		return dao.insertMajorFavorite(dto);
	}
	
	
	public int ueleteMajorFavorite(MajorDto dto) throws Exception {
		setRegMod(dto);
		return dao.ueleteMajorFavorite(dto);
	}
	
	public int deleteMajorFavorite(MajorVo vo) throws Exception {
		return dao.deleteMajorFavorite(vo);
	}
	
	
//	show
	public int selectOneCountMajorShow(MajorVo vo){
		return dao.selectOneCountMajorShow(vo);
	}
	
	public List<MajorDto> selectListMajorShow(MajorVo vo) throws Exception {
		return dao.selectListMajorShow(vo);
	}
	
	public MajorDto selectOneMajorShow(MajorVo vo) throws Exception {
		return dao.selectOneMajorShow(vo);
	}
	
	
//	hit
	public int insertMajorHit(MajorDto dto) throws Exception {
		setRegMod(dto);
		return dao.insertMajorHit(dto);
	}
	
}
