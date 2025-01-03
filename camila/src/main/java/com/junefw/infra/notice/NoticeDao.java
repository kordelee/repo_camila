package com.junefw.infra.notice;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.junefw.common.base.BaseDao;

@Repository
public interface NoticeDao extends BaseDao{

	public int selectOneCount(NoticeVo vo);
    public List<NoticeDto> selectList(NoticeVo vo);
    public List<NoticeDto> selectListUploaded(NoticeVo vo);
    public NoticeDto selectOne(NoticeVo vo);
    public int insert(NoticeDto dto);
    public int update(NoticeDto dto);
    public int uelete(NoticeDto dto);
    public int delete(NoticeVo vo);
    
    public List<NoticeDto> selectListWithoutPaging();
}
