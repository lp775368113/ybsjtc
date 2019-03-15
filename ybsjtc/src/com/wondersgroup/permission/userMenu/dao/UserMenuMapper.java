package com.wondersgroup.permission.userMenu.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;

import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.permission.userMenu.vo.UserMenu;
import com.wondersgroup.permission.userRole.vo.UserRole;
@MapperScan
public interface UserMenuMapper  extends BaseDAO<BaseObject>{
    int saveUserMenu(List<UserMenu> list);
    
    int updateUserMenu(UserMenu list);
    
    UserMenu getUserMenu(Map<String, Object> params);
    
    List<UserMenu> queryUserMenu(int userid);
    
    void removeUserMenu(int userid);
    
    int insertUserMenu(UserMenu userMenu);
}