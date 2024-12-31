package com.junefw.infra.template;

import java.io.Serializable;

import com.junefw.common.base.BaseVo;

public class TemplateVo extends BaseVo implements Serializable {

	private static final long serialVersionUID = 1L;
	private String iftpSeq;
	private String xdTestTarget;
	public String getIftpSeq() {
		return iftpSeq;
	}

	public void setIftpSeq(String iftpSeq) {
		this.iftpSeq = iftpSeq;
	}

	public String getXdTestTarget() {
		return xdTestTarget;
	}

	public void setXdTestTarget(String xdTestTarget) {
		this.xdTestTarget = xdTestTarget;
	}

}
