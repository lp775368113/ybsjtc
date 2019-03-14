package com.wondersgroup.permission.user.vo;

import java.util.Date;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.permission.user.vo]
 * @ClassName:    [user]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2019年3月12日 上午11:18:21]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2019年3月12日 上午11:18:21]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class User {
	private Integer uid;
	private String loginname;
	private String password;
	private String vsername;
	private String mobilephone;
	private String email;
	private Date create_time;
	private Date last_login_time;
	private String address;
	private String status;
	/**@Title:  	getUid
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public Integer getUid() {
		return uid;
	}
	/**@Title:  	setUid
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**@Title:  	getLoginname
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getLoginname() {
		return loginname;
	}
	/**@Title:  	setLoginname
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	/**@Title:  	getPassword
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getPassword() {
		return password;
	}
	/**@Title:  	setPassword
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**@Title:  	getVsername
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getVsername() {
		return vsername;
	}
	/**@Title:  	setVsername
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setVsername(String vsername) {
		this.vsername = vsername;
	}
	/**@Title:  	getMobilephone
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getMobilephone() {
		return mobilephone;
	}
	/**@Title:  	setMobilephone
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}
	/**@Title:  	getEmail
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getEmail() {
		return email;
	}
	/**@Title:  	setEmail
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**@Title:  	getCreate_time
	 * @Description:[please write your description]
	 * @return: 	Date
	 */
	public Date getCreate_time() {
		return create_time;
	}
	/**@Title:  	setCreate_time
	 * @Description:[please write your description]
	 * @return: 	Date
	 */
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	/**@Title:  	getLast_login_time
	 * @Description:[please write your description]
	 * @return: 	Date
	 */
	public Date getLast_login_time() {
		return last_login_time;
	}
	/**@Title:  	setLast_login_time
	 * @Description:[please write your description]
	 * @return: 	Date
	 */
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	/**@Title:  	getAddress
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getAddress() {
		return address;
	}
	/**@Title:  	setAddress
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**@Title:  	getStatus
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getStatus() {
		return status;
	}
	/**@Title:  	setStatus
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**Title: toString
	 * Description:[用一句话描述这个方法的作用]
	 * @return   
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return "User [uid=" + uid + ", loginname=" + loginname + ", password=" + password + ", vsername=" + vsername
				+ ", mobilephone=" + mobilephone + ", email=" + email + ", create_time=" + create_time
				+ ", last_login_time=" + last_login_time + ", address=" + address + ", status=" + status + "]";
	}
	
}
