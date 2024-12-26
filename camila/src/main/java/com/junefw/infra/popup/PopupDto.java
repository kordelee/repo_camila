package com.junefw.infra.popup;

import java.io.Serializable;
import java.util.Date;

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
	private Integer ifppDelNy;
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
	public Integer getIfppDelNy() {
		return ifppDelNy;
	}
	public void setIfppDelNy(Integer ifppDelNy) {
		this.ifppDelNy = ifppDelNy;
	}
	
}
