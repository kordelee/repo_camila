package com.junefw.infra.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.junefw.common.base.BaseService;

@Service
public class NoticeService extends BaseService{

	@Autowired
	NoticeDao dao;
    
	@Autowired
	private AmazonS3Client amazonS3Client;
	
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
	
    public int selectOneCount(NoticeVo vo) { 
    	return dao.selectOneCount(vo); 
    }
    
    
    public List<NoticeDto> selectList(NoticeVo vo) { 
    	return dao.selectList(vo); 
    }
    
    
    public NoticeDto selectOne(NoticeVo vo) { 
    	return dao.selectOne(vo); 
    }
    
    
    public int insert(NoticeDto dto) throws Exception { 
    	setRegMod(dto);
    	dao.insert(dto);
    	
    	return 1; 
    }

    
    public int update(NoticeDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.update(dto); 
    }
    
    
    public int uelete(NoticeDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.uelete(dto); 
    }
    
    
    public int delete(NoticeVo vo) { 
    	return dao.delete(vo);
    }
    
    
    public List<NoticeDto> selectListWithoutPaging() { 
    	return dao.selectListWithoutPaging(); 
    }
}
