package com.wondersgroup.permission.rolePermission.dao;

import java.util.List;
import java.util.Map;

import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.permission.rolePermission.vo.RolePermission;

public interface RolePermissionMapper extends BaseDAO<BaseObject>{

    int saveRolePermission(List<RolePermission> list);
    
    int updateRolePermission(RolePermission list);
    
    RolePermission getRolePermission(Map<String, Object> map);
    
}