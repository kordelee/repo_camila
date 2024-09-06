package com.junefw.infra.qna;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.junefw.common.base.BaseDao;

@Repository
public interface QnaDao extends BaseDao{

	public int selectOneCount(QnaVo vo);
    public List<QnaDto> selectList(QnaVo vo);
    public QnaDto selectOne(QnaVo vo);
    public int insert(QnaDto dto);
    public int update(QnaDto dto);
    public int uelete(QnaDto dto);
    public int delete(QnaVo vo);
    
    public List<QnaDto> selectListWithoutPaging();
}
