package com.junefw.infra.codegroup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.junefw.common.base.BaseService;

@Service
public class CodeGroupService extends BaseService{

	@Autowired
	CodeGroupDao dao;
    
	@Autowired
	private AmazonS3Client amazonS3Client;
	
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
	
    public int selectOneCount(CodeGroupVo vo) { 
    	return dao.selectOneCount(vo); 
    }
    
    
    public List<CodeGroupDto> selectList(CodeGroupVo vo) { 
    	return dao.selectList(vo); 
    }
    
    
    public CodeGroupDto selectOne(CodeGroupVo vo) { 
    	return dao.selectOne(vo); 
    }
    
    
    public int insert(CodeGroupDto dto) throws Exception { 
    	setRegMod(dto);
//    	dao.insert(dto);
    	
    	

    	
		for(MultipartFile multipartFile : dto.getUploadFiles()) {
			
			if(!multipartFile.isEmpty()) {
				System.out.println("multipartFile.getOriginalFilename() : " + multipartFile.getOriginalFilename());
				
		        ObjectMetadata metadata = new ObjectMetadata();
		        metadata.setContentLength(multipartFile.getSize());
		        metadata.setContentType(multipartFile.getContentType());
		        
		        amazonS3Client.putObject(bucket, multipartFile.getOriginalFilename(), multipartFile.getInputStream(), metadata);
				
		        String objectUrl = amazonS3Client.getUrl(bucket, multipartFile.getOriginalFilename()).toString();
		        
		        System.out.println(objectUrl);
				
			}
		}
    	
    	return 1; 
    }

    
    public int update(CodeGroupDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.update(dto); 
    }
    
    
    public int uelete(CodeGroupDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.uelete(dto); 
    }
    
    
    public int delete(CodeGroupVo vo) { 
    	return dao.delete(vo);
    }
    
    
    public List<CodeGroupDto> selectListWithoutPaging() { 
    	return dao.selectListWithoutPaging(); 
    }
}
