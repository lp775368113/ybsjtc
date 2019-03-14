package com.wondersgroup.framework.upms.vo;

import java.io.Serializable;
import java.util.List;

public class UasUserVO implements Serializable{
	
	/**@Fields serialVersionUID: TODO[用一句话描述这个变量表示什么]   */
	private static final long serialVersionUID = 1L;
	private String uid;
	private String loginname;
	private String phone;
	private String depts;
	private List<DeptVO> deptList;
	private String funcs;
	private List<UasFuncVO> funcList;
	
	private String email;
	private String name;
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepts() {
		return depts;
	}
	public void setDepts(String depts) {
		this.depts = depts;
	}
	public String getFuncs() {
		return funcs;
	}
	public void setFuncs(String funcs) {
		this.funcs = funcs;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<DeptVO> getDeptList() {
		return deptList;
	}
	public void setDeptList(List<DeptVO> deptList) {
		this.deptList = deptList;
	}
	public List<UasFuncVO> getFuncList() {
		return funcList;
	}
	public void setFuncList(List<UasFuncVO> funcList) {
		this.funcList = funcList;
	}

	
}
