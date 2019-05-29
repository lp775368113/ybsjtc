package com.wondersgroup.permission.button.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.service.BaseService;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.materiel.encoding.vo.Data0017;
import com.wondersgroup.permission.button.dao.ButtonMapper;
import com.wondersgroup.permission.button.vo.Button;
import com.wondersgroup.permission.button.vo.UserButtonPermission;
import com.wondersgroup.permission.menu.dao.PerMenuMapper;
import com.wondersgroup.permission.menu.vo.PerMenu;
import com.wondersgroup.permission.role.dao.RoleMapper;
import com.wondersgroup.permission.role.vo.Role;
import com.wondersgroup.permission.rolePermission.dao.RolePermissionMapper;
import com.wondersgroup.permission.rolePermission.vo.RolePermission;
import com.wondersgroup.permission.user.vo.User;
import com.wondersgroup.permission.userMenu.vo.UserMenu;
import com.wondersgroup.permission.userRole.dao.UserRoleMapper;
import com.wondersgroup.permission.userRole.vo.UserRole;

/**
 * *********************************************** Simple to Introduction
 * 
 * @ProjectName: [hzxzxt]
 * @Package: [com.wondersgroup.permission.menu.service]
 * @ClassName: [UaasMenuService]
 * @Description: [一句话描述该类的功能]
 * @Author: [chenyibing]
 * @CreateDate: [2018-5-7 下午5:30:57]
 * @UpdateUser: [chenyibing]
 * @UpdateDate: [2018-5-7 下午5:30:57]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 **/
@Service
public class ButtonService {

	@Resource(name = "buttonMapper")
	private ButtonMapper buttonMapper;

	@Resource(name="rolePermissionMapper")
	private RolePermissionMapper rolePermissionMapper;
	
	public List<Button> buttonPer(User user) {
		List<Button> list = buttonMapper.buttonPer(user);
		return list;
	}

	public Map<String, Object> getPage(Map<String, Object> params) {
		List<Button> list = buttonMapper.getPage(params);
		Integer count = buttonMapper.getPageCount(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", count);
		result.put("data", list);
		return result;
	}

	public void changeButtonRole(Map<String, Object> map) {
		String roleid = map.get("roleid").toString();
		String json = map.get("data").toString();
		List<Button> list = JSONArray.parseArray(json, Button.class);
		List<RolePermission> permissionAddList = new ArrayList<RolePermission>();
		List<RolePermission> permissionUpdateList = new ArrayList<RolePermission>();
		for (Button button : list) {
			boolean flag = false;// 默认更新
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("roleid", Integer.valueOf(roleid));
			params.put("permissionid", button.getId());
			params.put("permissiontype", "2");// 按钮权限
			RolePermission rolePermission = rolePermissionMapper.getRolePermission(params);
			if (rolePermission == null) {
				rolePermission = new RolePermission();
				flag = true;
			}
			rolePermission.setPermissionid(button.getId());
			rolePermission.setPermissiontype("2");//  按钮权限
			rolePermission.setRoleid(Integer.valueOf(roleid));
			if ("added".equals(button.get_state())) {
				rolePermission.setRemoved("0");
			} else if ("removed".equals(button.get_state())) {
				rolePermission.setRemoved("1");
			}
			if (flag)
				permissionAddList.add(rolePermission);
			else
				permissionUpdateList.add(rolePermission);
		}
		if (permissionAddList.size() > 0)
			rolePermissionMapper.saveRolePermission(permissionAddList);
		if (permissionUpdateList.size() > 0)
			for (RolePermission rolePermission : permissionUpdateList) {
				rolePermissionMapper.updateRolePermission(rolePermission);
			}
	}

	public Map<String, Object> queryUserButton(Map<String, Object> params) {
		List<Button> list = buttonMapper.getUserButtonPage(params);
		Integer count = buttonMapper.getUserButtonPageCount(params);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("total", count);
		result.put("data", list);
		return result;
	}

	public void changeButtonUser(Map<String, Object> map) {
		String userid = map.get("userid").toString();
		String json = map.get("data").toString();
		List<Button> list = JSONArray.parseArray(json, Button.class);
		List<UserButtonPermission> permissionAddList = new ArrayList<UserButtonPermission>();
		List<UserButtonPermission> permissionUpdateList = new ArrayList<UserButtonPermission>();
		for(Button button:list){
			boolean flag = false;//默认更新
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userid", Integer.valueOf(userid));
			params.put("buttonid", button.getId());
			UserButtonPermission userButton = buttonMapper.getUserButton(params);
			if(userButton == null){
				userButton = new UserButtonPermission();
				flag = true;
			}
			userButton.setButtonid(button.getId());
			userButton.setUserid(Integer.valueOf(userid));
			if ("added".equals(button.get_state())) {
				userButton.setRemoved(0);
			} else if ("removed".equals(button.get_state())) {
				userButton.setRemoved(1);
			}
			if(flag)
				permissionAddList.add(userButton);
			else
				permissionUpdateList.add(userButton);
		}
		if(permissionAddList.size()>0)
			buttonMapper.insertUserButton(permissionAddList);
		if(permissionUpdateList.size()>0)
			for(UserButtonPermission userButton:permissionUpdateList) {
				buttonMapper.updateUserButton(userButton);
			}
	}

}
