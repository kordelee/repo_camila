package com.junefw.infra.category;

import java.io.Serializable;

import com.junefw.common.base.BaseVo;

public class CategoryVo extends BaseVo implements Serializable {

	private static final long serialVersionUID = -5817158880785231109L;

	private String ifctSeq;
//	----------
	public String getIfctSeq() {
		return ifctSeq;
	}

	public void setIfctSeq(String ifctSeq) {
		this.ifctSeq = ifctSeq;
	}
}
