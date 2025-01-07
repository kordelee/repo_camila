package com.junefw.infra.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.junefw.common.base.BaseService;

@Service
public class NoticeService extends BaseService{

//	for aws.s3 fileupload s
	@Autowired
	private AmazonS3Client amazonS3Client;
	
	@Autowired
	NoticeDao dao;
    
    public int selectOneCount(NoticeVo vo) { 
    	return dao.selectOneCount(vo); 
    }
    
    
    public List<NoticeDto> selectList(NoticeVo vo) { 
    	return dao.selectList(vo); 
    }
    
    
    public List<NoticeDto> selectListUploaded(NoticeVo vo) { 
    	return dao.selectListUploaded(vo); 
    }
    
    
    public NoticeDto selectOne(NoticeVo vo) { 
    	return dao.selectOne(vo); 
    }
    
    
    public int insert(NoticeDto dto) throws Exception { 
    	setRegMod(dto);
    	dao.insert(dto);
    	uploadFilesToS3(dto.getUploadImg1(), dto, "infrNoticeUploaded", dto.getUploadImg1Type(), dto.getUploadImg1MaxNumber(), dto.getIfntSeq(), dao, amazonS3Client);
    	uploadFilesToS3(dto.getUploadFile2(), dto, "infrNoticeUploaded", dto.getUploadFile2Type(), dto.getUploadFile2MaxNumber(), dto.getIfntSeq(), dao, amazonS3Client);
    	return 1; 
    }

    
    public int update(NoticeDto dto) throws Exception { 
    	setRegMod(dto);
    	dao.update(dto);
    	if (dto.getUploadImg1() != null) {
    		uploadFilesToS3(dto.getUploadImg1(), dto, "infrNoticeUploaded", dto.getUploadImg1Type(), dto.getUploadImg1MaxNumber(), dto.getIfntSeq(), dao, amazonS3Client);
		}
    	if (dto.getUploadFile2() != null) {
    		uploadFilesToS3(dto.getUploadFile2(), dto, "infrNoticeUploaded", dto.getUploadFile2Type(), dto.getUploadFile2MaxNumber(), dto.getIfntSeq(), dao, amazonS3Client);
    	}
    	return 1; 
    }
    
    
    public int uelete(NoticeDto dto) throws Exception { 
    	setRegMod(dto);
    	return dao.uelete(dto); 
    }
    
    
    public int delete(NoticeVo vo) { 
    	return dao.delete(vo);
    }
    
    public int ueleteUploaded(NoticeDto dto) throws Exception { 
    	setRegMod(dto);
    	dto.setTableName("infrNoticeUploaded");
    	return dao.ueleteUploaded(dto); 
    }
    
    
    public int deleteUploaded(NoticeDto dto) { 
    	dto.setTableName("infrNoticeUploaded");
    	return dao.deleteUploaded(dto);
    }
    
    
    public List<NoticeDto> selectListWithoutPaging() { 
    	return dao.selectListWithoutPaging(); 
    }
}
