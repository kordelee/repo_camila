package com.junefw.infra.rule;

import java.io.Serializable;
import java.util.Date;

import com.junefw.common.base.BaseDto;

public class RuleDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String ifrlSeq;
	private String ifrlTitle;
	private String ifrlDesc;
	private String ifrlContents;
	private Integer ifrlUseNy;
	private Integer ifrlDelNy;
	private String ifrlVersion;
	private String ifrlStartDateTime;
	private String ifrlEndDateTime;
	private String ifrlNoticeDateTime;
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
	public String getIfrlDesc() {
		return ifrlDesc;
	}
	public void setIfrlDesc(String ifrlDesc) {
		this.ifrlDesc = ifrlDesc;
	}
	public String getIfrlContents() {
		return ifrlContents;
	}
	public void setIfrlContents(String ifrlContents) {
		this.ifrlContents = ifrlContents;
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
	public String getIfrlVersion() {
		return ifrlVersion;
	}
	public void setIfrlVersion(String ifrlVersion) {
		this.ifrlVersion = ifrlVersion;
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
	public String getIfrlNoticeDateTime() {
		return ifrlNoticeDateTime;
	}
	public void setIfrlNoticeDateTime(String ifrlNoticeDateTime) {
		this.ifrlNoticeDateTime = ifrlNoticeDateTime;
	}
}
