package com.junefw.infra.rule;

import java.io.Serializable;

import com.junefw.common.base.BaseVo;

public class RuleVo extends BaseVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ifrlSeq;

	public String getIfrlSeq() {
		return ifrlSeq;
	}

	public void setIfrlSeq(String ifrlSeq) {
		this.ifrlSeq = ifrlSeq;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
