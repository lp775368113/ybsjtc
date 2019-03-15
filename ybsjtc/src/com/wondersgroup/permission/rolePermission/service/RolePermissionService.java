package com.wondersgroup.permission.rolePermission.service;

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
public class RolePermissionService extends BaseService<BaseObject> {
	@Resource(name="rolePermissionMapper")
	private RolePermissionMapper rolePermissionMapper;
	@Resource(name="rolePermissionMapper")
	public void setDao(BaseDAO<BaseObject> dao) {
		super.dao = dao;
	}
	
	public void saveRoleMenu(Map<String, Object> map){
		String roleid = map.get("roleid").toString();
		String json = map.get("data").toString();
		List<PerMenu> list = JSONArray.parseArray(json, PerMenu.class);
		List<RolePermission> permissionAddList = new ArrayList<RolePermission>();
		List<RolePermission> permissionUpdateList = new ArrayList<RolePermission>();
		for(PerMenu menu:list){
			boolean flag = false;//默认更新
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("roleid", Integer.valueOf(roleid));
			params.put("permissionid", menu.getId());
			params.put("permissiontype", "1");//菜单
			RolePermission rolePermission = rolePermissionMapper.getRolePermission(params);
			if(rolePermission == null){
				rolePermission = new RolePermission();
				flag = true;
			}
			rolePermission.setPermissionid(menu.getId());
			rolePermission.setPermissiontype("1");//菜单权限
			rolePermission.setRoleid(Integer.valueOf(roleid));
			if("1".equals(menu.getIschecked())){
				rolePermission.setRemoved("0");//启用
			}else{
				rolePermission.setRemoved("1");//禁用
			}
			if(flag)
				permissionAddList.add(rolePermission);
			else
				permissionUpdateList.add(rolePermission);
		}
		if(permissionAddList.size()>0)
			rolePermissionMapper.saveRolePermission(permissionAddList);
		if(permissionUpdateList.size()>0)
			for(RolePermission rolePermission:permissionUpdateList) {
				rolePermissionMapper.updateRolePermission(rolePermission);
			}
	}
	
}
