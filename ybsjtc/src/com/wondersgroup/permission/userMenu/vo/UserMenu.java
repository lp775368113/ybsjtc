package com.wondersgroup.permission.userMenu.vo;

import com.wondersgroup.framework.comwork.vo.BaseObject;

public class UserMenu extends BaseObject{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer userid;
    
    private Integer menuid;

    private Integer removed;

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

	/**@Title:  	getUserid
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public Integer getUserid() {
		return userid;
	}

	/**@Title:  	setUserid
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**@Title:  	getMenuid
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public Integer getMenuid() {
		return menuid;
	}

	/**@Title:  	setMenuid
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public void setMenuid(Integer menuid) {
		this.menuid = menuid;
	}

	/**@Title:  	getRemoved
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public Integer getRemoved() {
		return removed;
	}

	/**@Title:  	setRemoved
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public void setRemoved(Integer removed) {
		this.removed = removed;
	}

	/**@Title:  	getSerialversionuid
	 * @Description:[please write your description]
	 * @return: 	long
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
    
}