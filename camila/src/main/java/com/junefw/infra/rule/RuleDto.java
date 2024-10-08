package com.junefw.infra.rule;

import java.io.Serializable;
import java.util.Date;

import com.junefw.common.base.BaseDto;

public class RuleDto extends BaseDto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String ifrlSeq;
	private String ifrlTitle;
	private String ifrlDesc;
	private Integer ifrlUseNy;
	private Integer ifrlDelNy;
	private String ifrlVersion;
	private Date ifrlStartDateTime;
	private Date ifrlEndDateTime;
	private Date ifrlNoticeDateTime;
	
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
	public Date getIfrlStartDateTime() {
		return ifrlStartDateTime;
	}
	public void setIfrlStartDateTime(Date ifrlStartDateTime) {
		this.ifrlStartDateTime = ifrlStartDateTime;
	}
	public Date getIfrlEndDateTime() {
		return ifrlEndDateTime;
	}
	public void setIfrlEndDateTime(Date ifrlEndDateTime) {
		this.ifrlEndDateTime = ifrlEndDateTime;
	}
	public Date getIfrlNoticeDateTime() {
		return ifrlNoticeDateTime;
	}
	public void setIfrlNoticeDateTime(Date ifrlNoticeDateTime) {
		this.ifrlNoticeDateTime = ifrlNoticeDateTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
