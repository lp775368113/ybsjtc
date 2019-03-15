package com.wondersgroup.permission.userRole.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.wondersgroup.permission.userRole.vo.UserRole;
@MapperScan
public interface UserRoleMapper {
    int saveUserRole(List<UserRole> list);
    
    int updateUserRole(UserRole list);
    
    UserRole getUaasUserRole(Map<String, Object> params);
    
    List<UserRole> queryUaasUserRole(int userid);
    
    void removeUserRole(int roleid);
    
    int insertUserRole(UserRole uaasUserRole);
}