package com.wondersgroup.permission.menu.dao;

import java.util.List;
import java.util.Map;
import org.mybatis.spring.annotation.MapperScan;
import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.permission.menu.vo.PerMenu;
@MapperScan
public interface PerMenuMapper extends BaseDAO<BaseObject>{
	
	List<PerMenu> listUserMenu(Map<String, Object> map);
	
	List<PerMenu> listMenu();
	
	PerMenu getMenu(int id);
	
	int updateUaasMenu(PerMenu record);
	
	int saveUaasMenu(PerMenu record);

	void removeUaasMenu(Map<String, Object> map);
	
	
	/*List<PerMenu> listMenuPermission(Map<String, Object> map);
	
	List<UaasMenu> listRoleMenu(Map<String, Object> map);
	
	
	UaasMenu getMenu(int id);
	
    */
}