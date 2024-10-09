package com.junefw.infra.qna;

import java.io.Serializable;

import com.junefw.common.base.BaseVo;

public class QnaVo extends BaseVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private String ifqaSeq;
	
	private Integer shSecurityNy;
	
	private String regSeq;

	public String getIfqaSeq() {
		return ifqaSeq;
	}

	public void setIfqaSeq(String ifqaSeq) {
		this.ifqaSeq = ifqaSeq;
	}

	public Integer getShSecurityNy() {
		return shSecurityNy;
	}

	public void setShSecurityNy(Integer shSecurityNy) {
		this.shSecurityNy = shSecurityNy;
	}

	public String getRegSeq() {
		return regSeq;
	}

	public void setRegSeq(String regSeq) {
		this.regSeq = regSeq;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
