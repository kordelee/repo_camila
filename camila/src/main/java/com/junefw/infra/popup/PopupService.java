package com.junefw.infra.popup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.junefw.common.base.BaseService;

@Service
public class PopupService extends BaseService{

//	for aws.s3 fileupload s
	@Autowired
	private AmazonS3Client amazonS3Client;
	
	@Autowired
	PopupDao dao;
    
    public int selectOneCount(PopupVo vo) { 
    	return dao.selectOneCount(vo); 
    }
    
    
    public List<PopupDto> selectList(PopupVo vo) { 
    	return dao.selectList(vo); 
    }
    
    
    public List<PopupDto> selectListUploaded(PopupVo vo) { 
    	return dao.selectListUploaded(vo); 
    }
    
    
    public PopupDto selectOne(PopupVo vo) { 
    	return dao.selectOne(vo); 
    }
    
    
    public int insert(PopupDto dto) throws Exception { 
    	setRegMod(dto);
    	dao.insert(dto);
    	uploadFilesToS3(dto.getUploadImg1(), dto, "infrPopupUploaded", dto.getUploadImg1Type(), dto.getUploadImg1MaxNumber(), dto.getIfppSeq(), dao, amazonS3Client);
    	return 1; 
    }

    
    public int update(PopupDto dto) throws Exception { 
    	setRegMod(dto);
    	dao.update(dto);
    	if(dto.getUploadImg1() != null) {
    		uploadFilesToS3(dto.getUploadImg1(), dto, "infrPopupUploaded", dto.getUploadImg1Type(), dto.getUploadImg1MaxNumber(), dto.getIfppSeq(), dao, amazonS3Client);
    	}
    	return 1;
    }
    
    
    public int uelete(PopupDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.uelete(dto); 
    }
    
    
    public int delete(PopupVo vo) { 
    	return dao.delete(vo);
    }
    
    
    public int ueleteUploaded(PopupDto dto) throws Exception { 
    	setRegMod(dto);
    	dto.setTableName("infrPopupUploaded");
    	return dao.ueleteUploaded(dto); 
    }
    
    
    public int deleteUploaded(PopupDto dto) { 
    	dto.setTableName("infrPopupUploaded");
    	return dao.deleteUploaded(dto);
    }
    
    
    public List<PopupDto> selectListWithoutPaging() { 
    	return dao.selectListWithoutPaging(); 
    }
}
