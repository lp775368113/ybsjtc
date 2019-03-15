package com.wondersgroup.permission.userRole.vo;

import com.wondersgroup.framework.comwork.vo.BaseObject;

public class UserRole extends BaseObject{
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer roleid;

    private Integer userid;

    private Integer removed;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRemoved() {
        return removed;
    }

    public void setRemoved(Integer removed) {
        this.removed = removed;
    }
}