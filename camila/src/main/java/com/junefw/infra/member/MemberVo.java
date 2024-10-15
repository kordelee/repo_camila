package com.junefw.infra.member;

import java.io.Serializable;
import java.util.Date;

import com.junefw.common.base.BaseVo;

public class MemberVo extends BaseVo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String ifmmSeq;
	
	private String ifmmPassword;
	
	private Date modDateTime;

//	search item extra (optional)
	private Integer shAdminNy = 0;
//-----

	public String getIfmmSeq() {
		return ifmmSeq;
	}

	public void setIfmmSeq(String ifmmSeq) {
		this.ifmmSeq = ifmmSeq;
	}

	public Integer getShAdminNy() {
		return shAdminNy;
	}

	public void setShAdminNy(Integer shAdminNy) {
		this.shAdminNy = shAdminNy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getIfmmPassword() {
		return ifmmPassword;
	}

	public void setIfmmPassword(String ifmmPassword) {
		this.ifmmPassword = ifmmPassword;
	}

	public Date getModDateTime() {
		return modDateTime;
	}

	public void setModDateTime(Date modDateTime) {
		this.modDateTime = modDateTime;
	}

	
}
