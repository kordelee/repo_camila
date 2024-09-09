package com.junefw.infra.qna;

import com.junefw.common.base.BaseVo;

public class QnaVo extends BaseVo{

	private String ifqaSeq;
	
	private Integer shSecurityNy;

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

	
}
