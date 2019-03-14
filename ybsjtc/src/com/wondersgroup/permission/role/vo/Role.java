package com.wondersgroup.permission.role.vo;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.permission.role.vo]
 * @ClassName:    [Role]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2019年3月14日 下午12:49:48]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2019年3月14日 下午12:49:48]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class Role {
	private Integer idl;
	private String name;
	private String description;
	private String roletype;
	private String enddate;
	private Integer creatorid;
	private String systemrole;
	private String state;
	private String removed;
	private String isapply;
	/**@Title:  	getIdl
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public Integer getIdl() {
		return idl;
	}
	/**@Title:  	setIdl
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public void setIdl(Integer idl) {
		this.idl = idl;
	}
	/**@Title:  	getName
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getName() {
		return name;
	}
	/**@Title:  	setName
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**@Title:  	getDescription
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getDescription() {
		return description;
	}
	/**@Title:  	setDescription
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**@Title:  	getRoletype
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getRoletype() {
		return roletype;
	}
	/**@Title:  	setRoletype
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	/**@Title:  	getEnddate
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getEnddate() {
		return enddate;
	}
	/**@Title:  	setEnddate
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	/**@Title:  	getCreatorid
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public Integer getCreatorid() {
		return creatorid;
	}
	/**@Title:  	setCreatorid
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public void setCreatorid(Integer creatorid) {
		this.creatorid = creatorid;
	}
	/**@Title:  	getSystemrole
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getSystemrole() {
		return systemrole;
	}
	/**@Title:  	setSystemrole
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setSystemrole(String systemrole) {
		this.systemrole = systemrole;
	}
	/**@Title:  	getState
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getState() {
		return state;
	}
	/**@Title:  	setState
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**@Title:  	getRemoved
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getRemoved() {
		return removed;
	}
	/**@Title:  	setRemoved
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setRemoved(String removed) {
		this.removed = removed;
	}
	/**@Title:  	getIsapply
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getIsapply() {
		return isapply;
	}
	/**@Title:  	setIsapply
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setIsapply(String isapply) {
		this.isapply = isapply;
	}
	/**Title: toString
	 * Description:[用一句话描述这个方法的作用]
	 * @return   
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return "Role [idl=" + idl + ", name=" + name + ", description=" + description + ", roletype=" + roletype
				+ ", enddate=" + enddate + ", creatorid=" + creatorid + ", systemrole=" + systemrole + ", state="
				+ state + ", removed=" + removed + ", isapply=" + isapply + "]";
	}

		
}
