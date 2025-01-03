package com.junefw.infra.popup;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.junefw.common.base.BaseDto;

public class PopupDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String ifppSeq;
	private Integer ifppDisplayNy;
	private Integer ifppXpoint;
	private Integer ifppYpoint;
	private String ifppTitle;
	private String ifppContents;
	private Integer ifppOrder;
	private String ifppStartDateTime;
	private String ifppEndDateTime;
	private String ifppUrl;
	private String ifppDesc;
	private Integer ifppDelNy;
	
	private MultipartFile[] uploadImg1;
	private Integer uploadImg1Type;	
	private Integer uploadImg1MaxNumber;
	private String[] uploadImg1DeleteSeq;
	private String[] uploadImg1DeletePathFile;
//	----------
	public String getIfppSeq() {
		return ifppSeq;
	}
	public void setIfppSeq(String ifppSeq) {
		this.ifppSeq = ifppSeq;
	}
	public Integer getIfppDisplayNy() {
		return ifppDisplayNy;
	}
	public void setIfppDisplayNy(Integer ifppDisplayNy) {
		this.ifppDisplayNy = ifppDisplayNy;
	}
	public Integer getIfppXpoint() {
		return ifppXpoint;
	}
	public void setIfppXpoint(Integer ifppXpoint) {
		this.ifppXpoint = ifppXpoint;
	}
	public Integer getIfppYpoint() {
		return ifppYpoint;
	}
	public void setIfppYpoint(Integer ifppYpoint) {
		this.ifppYpoint = ifppYpoint;
	}
	public String getIfppTitle() {
		return ifppTitle;
	}
	public void setIfppTitle(String ifppTitle) {
		this.ifppTitle = ifppTitle;
	}
	public String getIfppContents() {
		return ifppContents;
	}
	public void setIfppContents(String ifppContents) {
		this.ifppContents = ifppContents;
	}
	public Integer getIfppOrder() {
		return ifppOrder;
	}
	public void setIfppOrder(Integer ifppOrder) {
		this.ifppOrder = ifppOrder;
	}
	public String getIfppStartDateTime() {
		return ifppStartDateTime;
	}
	public void setIfppStartDateTime(String ifppStartDateTime) {
		this.ifppStartDateTime = ifppStartDateTime;
	}
	public String getIfppEndDateTime() {
		return ifppEndDateTime;
	}
	public void setIfppEndDateTime(String ifppEndDateTime) {
		this.ifppEndDateTime = ifppEndDateTime;
	}
	public String getIfppUrl() {
		return ifppUrl;
	}
	public void setIfppUrl(String ifppUrl) {
		this.ifppUrl = ifppUrl;
	}
	public String getIfppDesc() {
		return ifppDesc;
	}
	public void setIfppDesc(String ifppDesc) {
		this.ifppDesc = ifppDesc;
	}
	public Integer getIfppDelNy() {
		return ifppDelNy;
	}
	public void setIfppDelNy(Integer ifppDelNy) {
		this.ifppDelNy = ifppDelNy;
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
	
}
