package com.wondersgroup.permission.userMenu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSONArray;
import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.service.BaseService;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.permission.menu.vo.PerMenu;
import com.wondersgroup.permission.rolePermission.dao.RolePermissionMapper;
import com.wondersgroup.permission.rolePermission.vo.RolePermission;
import com.wondersgroup.permission.userMenu.dao.UserMenuMapper;
import com.wondersgroup.permission.userMenu.vo.UserMenu;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [hzxzxt]
 * @Package:      [com.wondersgroup.permission.rolePermission.service]
 * @ClassName:    [RolePermissionService]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [chenyibing]   	   
 * @CreateDate:   [2018-5-6 下午6:58:15]  
 * @UpdateUser:   [chenyibing]   	   
 * @UpdateDate:   [2018-5-6 下午6:58:15]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
@Service
public class UserMenuService extends BaseService<BaseObject> {
	@Resource(name="userMenuMapper")
	private UserMenuMapper userMenuMapper;
	
	@Resource(name="userMenuMapper")
	public void setDao(BaseDAO<BaseObject> dao) {
		super.dao = dao;
	}
	
	public void saveUserMenu(Map<String, Object> map){
		String userid = map.get("userid").toString();
		String json = map.get("data").toString();
		List<PerMenu> list = JSONArray.parseArray(json, PerMenu.class);
		List<UserMenu> permissionAddList = new ArrayList<UserMenu>();
		List<UserMenu> permissionUpdateList = new ArrayList<UserMenu>();
		for(PerMenu menu:list){
			boolean flag = false;//默认更新
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userid", Integer.valueOf(userid));
			params.put("menuid", menu.getId());
			UserMenu userMenu = userMenuMapper.getUserMenu(params);
			if(userMenu == null){
				userMenu = new UserMenu();
				flag = true;
			}
			userMenu.setMenuid(menu.getId());
			userMenu.setUserid(Integer.valueOf(userid));
			if("1".equals(menu.getIschecked())){
				userMenu.setRemoved(0);//启用
			}else{
				userMenu.setRemoved(1);//禁用
			}
			if(flag)
				permissionAddList.add(userMenu);
			else
				permissionUpdateList.add(userMenu);
		}
		if(permissionAddList.size()>0)
			userMenuMapper.saveUserMenu(permissionAddList);
		if(permissionUpdateList.size()>0)
			for(UserMenu rolemenu:permissionUpdateList) {
				userMenuMapper.updateUserMenu(rolemenu);
			}
	}
	
}
