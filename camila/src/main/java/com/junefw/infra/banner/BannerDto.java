package com.junefw.infra.banner;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import com.junefw.common.base.BaseDto;

public class BannerDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ifbnSeq;
	private Integer ifbnLocationCd;
	private String ifbnTitle;
	private String ifbnUrl;
	private Integer ifbnOrder;
	private Integer ifbnUseNy;
	private String ifbnDesc;
	private Integer ifbnDelNy;
	
	private MultipartFile[] uploadImg;
	private Integer uploadImgType;	
	private Integer uploadImgMaxNumber;
	private String[] uploadImgDeleteSeq;
	private String[] uploadImgDeletePathFile;
	public String getIfbnSeq() {
		return ifbnSeq;
	}
	public void setIfbnSeq(String ifbnSeq) {
		this.ifbnSeq = ifbnSeq;
	}
	public Integer getIfbnLocationCd() {
		return ifbnLocationCd;
	}
	public void setIfbnLocationCd(Integer ifbnLocationCd) {
		this.ifbnLocationCd = ifbnLocationCd;
	}
	public String getIfbnTitle() {
		return ifbnTitle;
	}
	public void setIfbnTitle(String ifbnTitle) {
		this.ifbnTitle = ifbnTitle;
	}
	public String getIfbnUrl() {
		return ifbnUrl;
	}
	public void setIfbnUrl(String ifbnUrl) {
		this.ifbnUrl = ifbnUrl;
	}
	public Integer getIfbnOrder() {
		return ifbnOrder;
	}
	public void setIfbnOrder(Integer ifbnOrder) {
		this.ifbnOrder = ifbnOrder;
	}
	public Integer getIfbnUseNy() {
		return ifbnUseNy;
	}
	public void setIfbnUseNy(Integer ifbnUseNy) {
		this.ifbnUseNy = ifbnUseNy;
	}
	public String getIfbnDesc() {
		return ifbnDesc;
	}
	public void setIfbnDesc(String ifbnDesc) {
		this.ifbnDesc = ifbnDesc;
	}
	public Integer getIfbnDelNy() {
		return ifbnDelNy;
	}
	public void setIfbnDelNy(Integer ifbnDelNy) {
		this.ifbnDelNy = ifbnDelNy;
	}
	public MultipartFile[] getUploadImg() {
		return uploadImg;
	}
	public void setUploadImg(MultipartFile[] uploadImg) {
		this.uploadImg = uploadImg;
	}
	public Integer getUploadImgType() {
		return uploadImgType;
	}
	public void setUploadImgType(Integer uploadImgType) {
		this.uploadImgType = uploadImgType;
	}
	public Integer getUploadImgMaxNumber() {
		return uploadImgMaxNumber;
	}
	public void setUploadImgMaxNumber(Integer uploadImgMaxNumber) {
		this.uploadImgMaxNumber = uploadImgMaxNumber;
	}
	public String[] getUploadImgDeleteSeq() {
		return uploadImgDeleteSeq;
	}
	public void setUploadImgDeleteSeq(String[] uploadImgDeleteSeq) {
		this.uploadImgDeleteSeq = uploadImgDeleteSeq;
	}
	public String[] getUploadImgDeletePathFile() {
		return uploadImgDeletePathFile;
	}
	public void setUploadImgDeletePathFile(String[] uploadImgDeletePathFile) {
		this.uploadImgDeletePathFile = uploadImgDeletePathFile;
	}
	
}
