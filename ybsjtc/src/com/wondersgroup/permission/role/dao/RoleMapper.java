package com.wondersgroup.permission.role.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.permission.role.vo.Role;
@MapperScan
public interface RoleMapper extends BaseDAO<BaseObject>{
    
    int saveUaasRole(Role record);

    int updateUaasRole(Role record);
    
    void removeUaasRole(List<Role> list);
    /*
    
    UaasRole getUaasRole(int id);
    
    List<UaasRole> queryRole(Map<String, Object>  map);
    
    int queryRoleCount(Map<String, Object>  map);*/
}