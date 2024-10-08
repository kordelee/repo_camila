package com.junefw.infra.code;

import java.io.Serializable;

import com.junefw.common.base.BaseVo;

public class CodeVo extends BaseVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String ifcdSeq;
//-----

	public String getIfcdSeq() {
		return ifcdSeq;
	}

	public void setIfcdSeq(String ifcdSeq) {
		this.ifcdSeq = ifcdSeq;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
