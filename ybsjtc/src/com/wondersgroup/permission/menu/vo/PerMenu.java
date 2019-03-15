package com.wondersgroup.permission.menu.vo;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.permission.menu.vo]
 * @ClassName:    [PerMenu]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2019年3月12日 下午2:55:13]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2019年3月12日 下午2:55:13]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class PerMenu {
	private Integer id;
	private Integer parentid;
	private String code;
	private String name;
	private String url;
	private String icon1;
	private String icon2;
	private String icon3;
	private String removed;
	private String type;
	private Integer priority;
	private String description;
	private String ischecked;
	/**@Title:  	getId
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public Integer getId() {
		return id;
	}
	/**@Title:  	setId
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**@Title:  	getParentid
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public Integer getParentid() {
		return parentid;
	}
	/**@Title:  	setParentid
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}
	/**@Title:  	getCode
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getCode() {
		return code;
	}
	/**@Title:  	setCode
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setCode(String code) {
		this.code = code;
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
	/**@Title:  	getUrl
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getUrl() {
		return url;
	}
	/**@Title:  	setUrl
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**@Title:  	getIcon1
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getIcon1() {
		return icon1;
	}
	/**@Title:  	setIcon1
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setIcon1(String icon1) {
		this.icon1 = icon1;
	}
	
	/**@Title:  	getIcon2
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getIcon2() {
		return icon2;
	}
	/**@Title:  	setIcon2
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setIcon2(String icon2) {
		this.icon2 = icon2;
	}
	/**@Title:  	getIcon3
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getIcon3() {
		return icon3;
	}
	/**@Title:  	setIcon3
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setIcon3(String icon3) {
		this.icon3 = icon3;
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
	/**@Title:  	getType
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getType() {
		return type;
	}
	/**@Title:  	setType
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**@Title:  	getPriority
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public Integer getPriority() {
		return priority;
	}
	/**@Title:  	setPriority
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
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
	/**@Title:  	getIschecked
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String getIschecked() {
		return ischecked;
	}
	/**@Title:  	setIschecked
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void setIschecked(String ischecked) {
		this.ischecked = ischecked;
	}
	/**Title: toString
	 * Description:[用一句话描述这个方法的作用]
	 * @return   
	 * @see java.lang.Object#toString()   
	 */
	@Override
	public String toString() {
		return "PerMenu [id=" + id + ", parentid=" + parentid + ", code=" + code + ", name=" + name + ", url=" + url
				+ ", icon1=" + icon1 + ", icon2=" + icon2 + ", icon3=" + icon3 + ", removed=" + removed + ", type="
				+ type + ", priority=" + priority + ", description=" + description + ", ischecked=" + ischecked + "]";
	}
}
