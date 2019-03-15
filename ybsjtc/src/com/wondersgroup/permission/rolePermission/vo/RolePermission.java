package com.wondersgroup.permission.rolePermission.vo;

public class RolePermission {
    private Integer id;

    private Integer roleid;

    private Integer permissionid;

    private String permissiontype;

    private String removed;

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

    public Integer getPermissionid() {
        return permissionid;
    }

    public void setPermissionid(Integer permissionid) {
        this.permissionid = permissionid;
    }

    public String getPermissiontype() {
        return permissiontype;
    }

    public void setPermissiontype(String permissiontype) {
        this.permissiontype = permissiontype == null ? null : permissiontype.trim();
    }

    public String getRemoved() {
        return removed;
    }

    public void setRemoved(String removed) {
        this.removed = removed == null ? null : removed.trim();
    }
}