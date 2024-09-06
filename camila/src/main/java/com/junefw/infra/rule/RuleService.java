package com.junefw.infra.rule;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.junefw.common.base.BaseService;

@Service
public class RuleService extends BaseService {

	@Autowired
	RuleDao dao;
    
	@Autowired
	private AmazonS3Client amazonS3Client;
	
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
	
    public int selectOneCount(RuleVo vo) { 
    	return dao.selectOneCount(vo); 
    }
    
    
    public List<RuleDto> selectList(RuleVo vo) { 
    	return dao.selectList(vo); 
    }
    
    
    public RuleDto selectOne(RuleVo vo) { 
    	return dao.selectOne(vo); 
    }
    
    
    public int insert(RuleDto dto) throws Exception { 
    	setRegMod(dto);
    	dao.insert(dto);
    	
    	return 1; 
    }

    
    public int update(RuleDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.update(dto); 
    }
    
    
    public int uelete(RuleDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.uelete(dto); 
    }
    
    
    public int delete(RuleVo vo) { 
    	return dao.delete(vo);
    }
    
    
    public List<RuleDto> selectListWithoutPaging() { 
    	return dao.selectListWithoutPaging(); 
    }
}
