package com.junefw.infra.qna;

import java.io.Serializable;
import java.util.Date;

import com.junefw.common.base.BaseDto;

public class QnaDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ifqaSeq;
	private Integer ifqaStatusCd;
	private Integer ifqaTypeCd;
	private String ifqaTitle;
	private String ifqaAnswer;
	private String ifqaContents;
	private String ifqaAnswerSeq;
	private Date ifqaAnswerDateTime;
	private Integer ifqaAnswerDisplayNy;
	private Integer ifqaDelNy;
	private Integer ifqaSecurityNy;
	public String getIfqaSeq() {
		return ifqaSeq;
	}
	public void setIfqaSeq(String ifqaSeq) {
		this.ifqaSeq = ifqaSeq;
	}
	public Integer getIfqaStatusCd() {
		return ifqaStatusCd;
	}
	public void setIfqaStatusCd(Integer ifqaStatusCd) {
		this.ifqaStatusCd = ifqaStatusCd;
	}
	public Integer getIfqaTypeCd() {
		return ifqaTypeCd;
	}
	public void setIfqaTypeCd(Integer ifqaTypeCd) {
		this.ifqaTypeCd = ifqaTypeCd;
	}
	public String getIfqaTitle() {
		return ifqaTitle;
	}
	public void setIfqaTitle(String ifqaTitle) {
		this.ifqaTitle = ifqaTitle;
	}
	public String getIfqaAnswer() {
		return ifqaAnswer;
	}
	public void setIfqaAnswer(String ifqaAnswer) {
		this.ifqaAnswer = ifqaAnswer;
	}
	public String getIfqaContents() {
		return ifqaContents;
	}
	public void setIfqaContents(String ifqaContents) {
		this.ifqaContents = ifqaContents;
	}
	public String getIfqaAnswerSeq() {
		return ifqaAnswerSeq;
	}
	public void setIfqaAnswerSeq(String ifqaAnswerSeq) {
		this.ifqaAnswerSeq = ifqaAnswerSeq;
	}
	public Date getIfqaAnswerDateTime() {
		return ifqaAnswerDateTime;
	}
	public void setIfqaAnswerDateTime(Date ifqaAnswerDateTime) {
		this.ifqaAnswerDateTime = ifqaAnswerDateTime;
	}
	public Integer getIfqaAnswerDisplayNy() {
		return ifqaAnswerDisplayNy;
	}
	public void setIfqaAnswerDisplayNy(Integer ifqaAnswerDisplayNy) {
		this.ifqaAnswerDisplayNy = ifqaAnswerDisplayNy;
	}
	public Integer getIfqaDelNy() {
		return ifqaDelNy;
	}
	public void setIfqaDelNy(Integer ifqaDelNy) {
		this.ifqaDelNy = ifqaDelNy;
	}
	public Integer getIfqaSecurityNy() {
		return ifqaSecurityNy;
	}
	public void setIfqaSecurityNy(Integer ifqaSecurityNy) {
		this.ifqaSecurityNy = ifqaSecurityNy;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
