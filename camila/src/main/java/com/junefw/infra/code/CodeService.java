package com.junefw.infra.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junefw.common.base.BaseService;

@Service
public class CodeService extends BaseService{
	
	@Autowired
	CodeDao dao;
    
    public int selectOneCount(CodeVo vo) { return dao.selectOneCount(vo); }
    public List<CodeDto> selectList(CodeVo vo) { return dao.selectList(vo); }
    public CodeDto selectOne(CodeVo vo) { return dao.selectOne(vo); }
    public int insert(CodeDto dto) { return dao.insert(dto); }
    public int update(CodeDto dto) { return dao.update(dto); }
    public int uelete(CodeDto dto) { return dao.uelete(dto); }
    public int delete(CodeVo vo) { return dao.delete(vo); }
    
    public List<CodeDto> selectListCachedCodeArrayList() { return dao.selectListCachedCodeArrayList(); }

}
