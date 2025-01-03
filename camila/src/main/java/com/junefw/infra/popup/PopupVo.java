package com.junefw.infra.popup;

import java.io.Serializable;

import com.junefw.common.base.BaseVo;

public class PopupVo extends BaseVo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String ifppSeq;
	
	private Integer shDisplayNy;
//	----------
	public String getIfppSeq() {
		return ifppSeq;
	}

	public void setIfppSeq(String ifppSeq) {
		this.ifppSeq = ifppSeq;
	}

	public Integer getShDisplayNy() {
		return shDisplayNy;
	}

	public void setShDisplayNy(Integer shDisplayNy) {
		this.shDisplayNy = shDisplayNy;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
