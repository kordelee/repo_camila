package com.junefw.infra.banner;

import java.io.Serializable;

import com.junefw.common.base.BaseDto;

public class BannerDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ifbnSeq;
	private Integer ifbnLocationCd;
	private String ifbnTitle;
	private String ifbnUrl;
	private Integer ifbnOrder;
	private Integer ifbnUseNy;
	private Integer ifbnDelNy;
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
	public Integer getIfbnDelNy() {
		return ifbnDelNy;
	}
	public void setIfbnDelNy(Integer ifbnDelNy) {
		this.ifbnDelNy = ifbnDelNy;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
