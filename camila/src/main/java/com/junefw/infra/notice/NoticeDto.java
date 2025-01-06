package com.junefw.infra.notice;

import java.io.Serializable;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.junefw.common.base.BaseDto;

public class NoticeDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ifntSeq;
	private String ifntTitle;
	private String ifntContents;
	private Integer ifntTopNy;
	private Integer ifntTopOrder;
	private String ifntTopDateStart;
	private String ifntTopDateEnd;
	private Integer ifntDisplayNy;
	private String ifntDesc;
	private Integer ifntDelNy;
	private Integer ifntTargetCd;
	
	private MultipartFile[] uploadImg1;
	private Integer uploadImg1Type;	
	private Integer uploadImg1MaxNumber;
	private String[] uploadImg1DeleteSeq;
	private String[] uploadImg1DeletePathFile;	
	
	private MultipartFile[] uploadFile2;
	private Integer uploadFile2Type;
	private Integer uploadFile2MaxNumber;
	private String[] uploadFile2DeleteSeq;
	private String[] uploadFile2DeletePathFile;
//	----------
	public String getIfntSeq() {
		return ifntSeq;
	}
	public void setIfntSeq(String ifntSeq) {
		this.ifntSeq = ifntSeq;
	}
	public String getIfntTitle() {
		return ifntTitle;
	}
	public void setIfntTitle(String ifntTitle) {
		this.ifntTitle = ifntTitle;
	}
	public String getIfntContents() {
		return ifntContents;
	}
	public void setIfntContents(String ifntContents) {
		this.ifntContents = ifntContents;
	}
	public Integer getIfntTopNy() {
		return ifntTopNy;
	}
	public void setIfntTopNy(Integer ifntTopNy) {
		this.ifntTopNy = ifntTopNy;
	}
	public Integer getIfntTopOrder() {
		return ifntTopOrder;
	}
	public void setIfntTopOrder(Integer ifntTopOrder) {
		this.ifntTopOrder = ifntTopOrder;
	}
	public String getIfntTopDateStart() {
		return ifntTopDateStart;
	}
	public void setIfntTopDateStart(String ifntTopDateStart) {
		this.ifntTopDateStart = ifntTopDateStart;
	}
	public String getIfntTopDateEnd() {
		return ifntTopDateEnd;
	}
	public void setIfntTopDateEnd(String ifntTopDateEnd) {
		this.ifntTopDateEnd = ifntTopDateEnd;
	}
	public Integer getIfntDisplayNy() {
		return ifntDisplayNy;
	}
	public void setIfntDisplayNy(Integer ifntDisplayNy) {
		this.ifntDisplayNy = ifntDisplayNy;
	}
	public String getIfntDesc() {
		return ifntDesc;
	}
	public void setIfntDesc(String ifntDesc) {
		this.ifntDesc = ifntDesc;
	}
	public Integer getIfntDelNy() {
		return ifntDelNy;
	}
	public void setIfntDelNy(Integer ifntDelNy) {
		this.ifntDelNy = ifntDelNy;
	}
	public Integer getIfntTargetCd() {
		return ifntTargetCd;
	}
	public void setIfntTargetCd(Integer ifntTargetCd) {
		this.ifntTargetCd = ifntTargetCd;
	}
	public MultipartFile[] getUploadImg1() {
		return uploadImg1;
	}
	public void setUploadImg1(MultipartFile[] uploadImg1) {
		this.uploadImg1 = uploadImg1;
	}
	public Integer getUploadImg1Type() {
		return uploadImg1Type;
	}
	public void setUploadImg1Type(Integer uploadImg1Type) {
		this.uploadImg1Type = uploadImg1Type;
	}
	public Integer getUploadImg1MaxNumber() {
		return uploadImg1MaxNumber;
	}
	public void setUploadImg1MaxNumber(Integer uploadImg1MaxNumber) {
		this.uploadImg1MaxNumber = uploadImg1MaxNumber;
	}
	public String[] getUploadImg1DeleteSeq() {
		return uploadImg1DeleteSeq;
	}
	public void setUploadImg1DeleteSeq(String[] uploadImg1DeleteSeq) {
		this.uploadImg1DeleteSeq = uploadImg1DeleteSeq;
	}
	public String[] getUploadImg1DeletePathFile() {
		return uploadImg1DeletePathFile;
	}
	public void setUploadImg1DeletePathFile(String[] uploadImg1DeletePathFile) {
		this.uploadImg1DeletePathFile = uploadImg1DeletePathFile;
	}
	public MultipartFile[] getUploadFile2() {
		return uploadFile2;
	}
	public void setUploadFile2(MultipartFile[] uploadFile2) {
		this.uploadFile2 = uploadFile2;
	}
	public Integer getUploadFile2Type() {
		return uploadFile2Type;
	}
	public void setUploadFile2Type(Integer uploadFile2Type) {
		this.uploadFile2Type = uploadFile2Type;
	}
	public Integer getUploadFile2MaxNumber() {
		return uploadFile2MaxNumber;
	}
	public void setUploadFile2MaxNumber(Integer uploadFile2MaxNumber) {
		this.uploadFile2MaxNumber = uploadFile2MaxNumber;
	}
	public String[] getUploadFile2DeleteSeq() {
		return uploadFile2DeleteSeq;
	}
	public void setUploadFile2DeleteSeq(String[] uploadFile2DeleteSeq) {
		this.uploadFile2DeleteSeq = uploadFile2DeleteSeq;
	}
	public String[] getUploadFile2DeletePathFile() {
		return uploadFile2DeletePathFile;
	}
	public void setUploadFile2DeletePathFile(String[] uploadFile2DeletePathFile) {
		this.uploadFile2DeletePathFile = uploadFile2DeletePathFile;
	}
	
}
