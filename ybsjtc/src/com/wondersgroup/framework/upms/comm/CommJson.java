package com.wondersgroup.framework.upms.comm;

import java.io.Serializable;

public class CommJson implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ret;
	private String msg;
	private Object result;
	private String code;

	public void setSuc() {
		ret = "1";
	}

	public void setError() {
		ret = "0";
	}

	public String getRet() {
		return ret;
	}

	public void setRet(String ret) {
		this.ret = ret;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
