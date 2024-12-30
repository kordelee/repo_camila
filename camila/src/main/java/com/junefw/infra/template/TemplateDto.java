package com.junefw.infra.template;

import java.io.Serializable;

import com.junefw.common.base.BaseDto;

public class TemplateDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String iftpSeq;
	private Integer iftpTypeCd;
	private String iftpTitle;
	private String iftpName;
	private String iftpContents;
	private Integer iftpUseNy;
	private String iftpDesc;
	private Integer iftpDelNy;
	public String getIftpSeq() {
		return iftpSeq;
	}
	public void setIftpSeq(String iftpSeq) {
		this.iftpSeq = iftpSeq;
	}
	public Integer getIftpTypeCd() {
		return iftpTypeCd;
	}
	public void setIftpTypeCd(Integer iftpTypeCd) {
		this.iftpTypeCd = iftpTypeCd;
	}
	public String getIftpTitle() {
		return iftpTitle;
	}
	public void setIftpTitle(String iftpTitle) {
		this.iftpTitle = iftpTitle;
	}
	public String getIftpName() {
		return iftpName;
	}
	public void setIftpName(String iftpName) {
		this.iftpName = iftpName;
	}
	public String getIftpContents() {
		return iftpContents;
	}
	public void setIftpContents(String iftpContents) {
		this.iftpContents = iftpContents;
	}
	public Integer getIftpUseNy() {
		return iftpUseNy;
	}
	public void setIftpUseNy(Integer iftpUseNy) {
		this.iftpUseNy = iftpUseNy;
	}
	public String getIftpDesc() {
		return iftpDesc;
	}
	public void setIftpDesc(String iftpDesc) {
		this.iftpDesc = iftpDesc;
	}
	public Integer getIftpDelNy() {
		return iftpDelNy;
	}
	public void setIftpDelNy(Integer iftpDelNy) {
		this.iftpDelNy = iftpDelNy;
	}
	
}
