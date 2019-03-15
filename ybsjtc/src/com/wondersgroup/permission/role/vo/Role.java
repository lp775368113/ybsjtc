package com.wondersgroup.permission.role.vo;

import java.util.Date;



@SuppressWarnings("serial")
public class Role{
    private Integer id;

    private String name;

    private String description;

    private String roletype;

    private Date enddate;

    private Integer creatorid;

    private String systemrole;
    
    private String _state;
    
    private Integer removed;
    
    private Integer isApply;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getRoletype() {
        return roletype;
    }

    public void setRoletype(String roletype) {
        this.roletype = roletype == null ? null : roletype.trim();
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public Integer getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(Integer creatorid) {
        this.creatorid = creatorid;
    }

    public String getSystemrole() {
        return systemrole;
    }

    public void setSystemrole(String systemrole) {
        this.systemrole = systemrole == null ? null : systemrole.trim();
    }

	/**@Title:  	get_state
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public String get_state() {
		return _state;
	}

	/**@Title:  	set_state
	 * @Description:[please write your description]
	 * @return: 	String
	 */
	public void set_state(String _state) {
		this._state = _state;
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

	/**@Title:  	getIsApply
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public Integer getIsApply() {
		return isApply;
	}

	/**@Title:  	setIsApply
	 * @Description:[please write your description]
	 * @return: 	Integer
	 */
	public void setIsApply(Integer isApply) {
		this.isApply = isApply;
	}
	
	
}