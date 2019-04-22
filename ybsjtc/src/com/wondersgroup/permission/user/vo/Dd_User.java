package com.wondersgroup.permission.user.vo;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.permission.user.vo]
 * @ClassName:    [Dd_User]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2019年4月19日 上午9:26:53]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2019年4月19日 上午9:26:53]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class Dd_User {
	private int userid;
	private String dd_userid;
	private String name;
	private String mobile;
	private String email;
	private String department;
	private String remark;
	private String removed;
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getDd_userid() {
		return dd_userid;
	}
	public void setDd_userid(String dd_userid) {
		this.dd_userid = dd_userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRemoved() {
		return removed;
	}
	public void setRemoved(String removed) {
		this.removed = removed;
	}
}
