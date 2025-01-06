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
	
	private MultipartFile[] uploadImg1;
	private Integer uploadImg1Type;	
	private Integer uploadImg1MaxNumber;
	private String[] uploadImg1DeleteSeq;
	private String[] uploadImg1DeletePathFile;
//	----------
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
