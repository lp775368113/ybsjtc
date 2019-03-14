package com.wondersgroup.permission.role.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.permission.role.vo.UaasRole;
@MapperScan
public interface RoleMapper extends BaseDAO<BaseObject>{
    
    int saveUaasRole(UaasRole record);

    int updateUaasRole(UaasRole record);
    
    void removeUaasRole(List<UaasRole> list);
    
    UaasRole getUaasRole(int id);
    
    List<UaasRole> queryRole(Map<String, Object>  map);
    
    int queryRoleCount(Map<String, Object>  map);
}