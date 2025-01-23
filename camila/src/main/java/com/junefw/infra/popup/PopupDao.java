package com.junefw.infra.popup;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.junefw.common.base.BaseDao;

@Repository
public interface PopupDao extends BaseDao {

	public int selectOneCount(PopupVo vo);
    public List<PopupDto> selectList(PopupVo vo);
    public List<PopupDto> selectListUploaded(PopupVo vo);
    public List<PopupDto> selectListUploadedPopup(PopupVo vo);
    public PopupDto selectOne(PopupVo vo);
    public int insert(PopupDto dto);
    public int update(PopupDto dto);
    public int uelete(PopupDto dto);
    public int delete(PopupVo vo);
    
    public List<PopupDto> selectListWithoutPaging();
}
