package com.junefw.infra.notice;

import java.io.Serializable;
import java.util.Date;

import com.junefw.common.base.BaseDto;

public class NoticeDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ifntSeq;
	private String ifntTitle;
	private String ifntContents;
	private Integer ifntTopNy;
	private Integer ifntTopOrder;
	private String ifntTopDateStart;
	private String ifntTopDateEnd;
	private Integer ifntDisplayNy;
	private String ifntDesc;
	private Integer ifntDelNy;
	private Integer ifntTargetCd;
	public String getIfntSeq() {
		return ifntSeq;
	}
	public void setIfntSeq(String ifntSeq) {
		this.ifntSeq = ifntSeq;
	}
	public String getIfntTitle() {
		return ifntTitle;
	}
	public void setIfntTitle(String ifntTitle) {
		this.ifntTitle = ifntTitle;
	}
	public String getIfntContents() {
		return ifntContents;
	}
	public void setIfntContents(String ifntContents) {
		this.ifntContents = ifntContents;
	}
	public Integer getIfntTopNy() {
		return ifntTopNy;
	}
	public void setIfntTopNy(Integer ifntTopNy) {
		this.ifntTopNy = ifntTopNy;
	}
	public Integer getIfntTopOrder() {
		return ifntTopOrder;
	}
	public void setIfntTopOrder(Integer ifntTopOrder) {
		this.ifntTopOrder = ifntTopOrder;
	}
	public String getIfntTopDateStart() {
		return ifntTopDateStart;
	}
	public void setIfntTopDateStart(String ifntTopDateStart) {
		this.ifntTopDateStart = ifntTopDateStart;
	}
	public String getIfntTopDateEnd() {
		return ifntTopDateEnd;
	}
	public void setIfntTopDateEnd(String ifntTopDateEnd) {
		this.ifntTopDateEnd = ifntTopDateEnd;
	}
	public Integer getIfntDisplayNy() {
		return ifntDisplayNy;
	}
	public void setIfntDisplayNy(Integer ifntDisplayNy) {
		this.ifntDisplayNy = ifntDisplayNy;
	}
	public String getIfntDesc() {
		return ifntDesc;
	}
	public void setIfntDesc(String ifntDesc) {
		this.ifntDesc = ifntDesc;
	}
	public Integer getIfntDelNy() {
		return ifntDelNy;
	}
	public void setIfntDelNy(Integer ifntDelNy) {
		this.ifntDelNy = ifntDelNy;
	}
	public Integer getIfntTargetCd() {
		return ifntTargetCd;
	}
	public void setIfntTargetCd(Integer ifntTargetCd) {
		this.ifntTargetCd = ifntTargetCd;
	}
	
}
