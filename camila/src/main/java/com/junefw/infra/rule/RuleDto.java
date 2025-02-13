package com.junefw.infra.rule;

import java.io.Serializable;

import com.junefw.common.base.BaseDto;

public class RuleDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String ifrlSeq;
	private String ifrlTitle;
	private String ifrlContents;
	private String ifrlVersion;
	private String ifrlNoticeDateTime;
	private String ifrlStartDateTime;
	private String ifrlEndDateTime;
	private Integer ifrlUseNy;
	private String ifrlDesc;
	private Integer ifrlDelNy;
//	----------
	public String getIfrlSeq() {
		return ifrlSeq;
	}
	public void setIfrlSeq(String ifrlSeq) {
		this.ifrlSeq = ifrlSeq;
	}
	public String getIfrlTitle() {
		return ifrlTitle;
	}
	public void setIfrlTitle(String ifrlTitle) {
		this.ifrlTitle = ifrlTitle;
	}
	public String getIfrlContents() {
		return ifrlContents;
	}
	public void setIfrlContents(String ifrlContents) {
		this.ifrlContents = ifrlContents;
	}
	public String getIfrlVersion() {
		return ifrlVersion;
	}
	public void setIfrlVersion(String ifrlVersion) {
		this.ifrlVersion = ifrlVersion;
	}
	public String getIfrlNoticeDateTime() {
		return ifrlNoticeDateTime;
	}
	public void setIfrlNoticeDateTime(String ifrlNoticeDateTime) {
		this.ifrlNoticeDateTime = ifrlNoticeDateTime;
	}
	public String getIfrlStartDateTime() {
		return ifrlStartDateTime;
	}
	public void setIfrlStartDateTime(String ifrlStartDateTime) {
		this.ifrlStartDateTime = ifrlStartDateTime;
	}
	public String getIfrlEndDateTime() {
		return ifrlEndDateTime;
	}
	public void setIfrlEndDateTime(String ifrlEndDateTime) {
		this.ifrlEndDateTime = ifrlEndDateTime;
	}
	public String getIfrlDesc() {
		return ifrlDesc;
	}
	public void setIfrlDesc(String ifrlDesc) {
		this.ifrlDesc = ifrlDesc;
	}
	public Integer getIfrlUseNy() {
		return ifrlUseNy;
	}
	public void setIfrlUseNy(Integer ifrlUseNy) {
		this.ifrlUseNy = ifrlUseNy;
	}
	public Integer getIfrlDelNy() {
		return ifrlDelNy;
	}
	public void setIfrlDelNy(Integer ifrlDelNy) {
		this.ifrlDelNy = ifrlDelNy;
	}
	
}
