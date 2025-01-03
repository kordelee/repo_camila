package com.junefw.infra.banner;

import java.io.Serializable;

import com.junefw.common.base.BaseVo;

public class BannerVo extends BaseVo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String ifbnSeq;
//	----------
	public String getIfbnSeq() {
		return ifbnSeq;
	}

	public void setIfbnSeq(String ifbnSeq) {
		this.ifbnSeq = ifbnSeq;
	}

}
