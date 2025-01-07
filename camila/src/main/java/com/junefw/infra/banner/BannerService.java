package com.junefw.infra.banner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.junefw.common.base.BaseService;

@Service
public class BannerService extends BaseService {

//	for aws.s3 fileupload s
	@Autowired
	private AmazonS3Client amazonS3Client;
	
	@Autowired
	BannerDao dao;
    
    public int selectOneCount(BannerVo vo) { 
    	return dao.selectOneCount(vo); 
    }
    
    
    public List<BannerDto> selectList(BannerVo vo) { 
    	return dao.selectList(vo); 
    }
    
    
    public List<BannerDto> selectListUploaded(BannerVo vo) { 
    	return dao.selectListUploaded(vo); 
    }
    
    
    public BannerDto selectOne(BannerVo vo) { 
    	return dao.selectOne(vo); 
    }
    
    
    public int insert(BannerDto dto) throws Exception { 
    	setRegMod(dto);
    	dao.insert(dto);
    	uploadFilesToS3(dto.getUploadImg1(), dto, "infrBannerUploaded", dto.getUploadImg1Type(), dto.getUploadImg1MaxNumber(), dto.getIfbnSeq(), dao, amazonS3Client);
    	return 1; 
    }

    
    public int update(BannerDto dto) throws Exception { 
    	setRegMod(dto);
    	dao.update(dto);
    	if(dto.getUploadImg1() != null) {
    		uploadFilesToS3(dto.getUploadImg1(), dto, "infrBannerUploaded", dto.getUploadImg1Type(), dto.getUploadImg1MaxNumber(), dto.getIfbnSeq(), dao, amazonS3Client);
    	}
    	return 1; 
    }
    
    
    public int uelete(BannerDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.uelete(dto); 
    }
    
    
    public int delete(BannerVo vo) { 
    	return dao.delete(vo);
    }
    
    
    public int ueleteUploaded(BannerDto dto) throws Exception { 
    	setRegMod(dto);
    	dto.setTableName("infrBannerUploaded");
    	return dao.ueleteUploaded(dto); 
    }
    
    
    public int deleteUploaded(BannerDto dto) { 
    	dto.setTableName("infrBannerUploaded");
    	return dao.deleteUploaded(dto);
    }
    
    
    public List<BannerDto> selectListWithoutPaging() { 
    	return dao.selectListWithoutPaging(); 
    }
}
