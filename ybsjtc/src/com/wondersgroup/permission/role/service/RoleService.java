package com.wondersgroup.permission.role.service;

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
import com.wondersgroup.permission.role.dao.RoleMapper;
import com.wondersgroup.permission.role.vo.Role;
import com.wondersgroup.permission.user.vo.User;
import com.wondersgroup.permission.userRole.dao.UserRoleMapper;
import com.wondersgroup.permission.userRole.vo.UserRole;

/**
 * *********************************************** Simple to Introduction
 * 
 * @ProjectName: [hzxzxt]
 * @Package: [com.wondersgroup.permission.role.service]
 * @ClassName: [UaasRoleService]
 * @Description: [一句话描述该类的功能]
 * @Author: [chenyibing]
 * @CreateDate: [2018-5-6 下午4:09:00]
 * @UpdateUser: [chenyibing]
 * @UpdateDate: [2018-5-6 下午4:09:00]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 ************************************************** **/
@Service
public class RoleService extends BaseService<BaseObject> {
	@Resource(name = "roleMapper")
	private RoleMapper roleMapper;
	
	@Resource(name = "userRoleMapper")
	private UserRoleMapper userRoleMapper;
	
	@Resource(name = "roleMapper")
	public void setDao(BaseDAO<BaseObject> dao) {
		super.dao = dao;
	}

	public int saveUaasRole(Role record) {
		return roleMapper.saveUaasRole(record);
	}

	public int updateUaasRole(Role record) {
		return roleMapper.updateUaasRole(record);
	}
	
	public void removeUaasRole(List<Role> list) {
		roleMapper.removeUaasRole(list);
		for(Role role:list){
			userRoleMapper.removeUserRole(role.getId());
		}
	}


	/*public UaasRole getUaasRole(int id) {
		return uaasRoleMapper.getUaasRole(id);
	}*/
	
	/*public Map<String, Object> queryRole(Map<String, Object>  map){
	    Map<String, Object> result = new HashMap<String, Object>();
        int pageIndex = Integer.parseInt( map.get("pageIndex").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        int start = pageIndex * pageSize, end = start + pageSize;
        map.put("start", start + 1);
        map.put("end", end);
        List<Role> list = roleMapper.queryRole(map);
        int count = roleMapper.queryRoleCount(map);
        result.put("total", count);
		result.put("data", list);
	    return result;
	}*/


	public boolean changeUserRole(Map<String, Object> map) {
		String roleid = map.get("roleid") != null ? map.get("roleid").toString() : "";
		String userid = map.get("userid") != null ? map.get("userid").toString() : "";
		String json = map.get("data").toString();
		List<UserRole> addList = new ArrayList<UserRole>();
		List<UserRole> updateList = new ArrayList<UserRole>();
		if (StringUtils.isNotEmpty(userid)) {
			List<Role> list = JSONArray.parseArray(json, Role.class);
			for (Role role : list) {
				boolean flag = false;// 默认更新
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("userid", Integer.valueOf(userid));
				params.put("roleid", role.getId());
				UserRole userRole = userRoleMapper.getUaasUserRole(params);
				if (userRole == null) {
					userRole = new UserRole();
					flag = true;
				}

				userRole.setUserid(Integer.valueOf(userid));
				userRole.setRoleid(role.getId());
				// 判断是删除还是增加
				if ("added".equals(role.get_state())) {
					userRole.setRemoved(0);
				} else if ("removed".equals(role.get_state())) {
					userRole.setRemoved(1);
				}
				// 判断是insert还是update
				if (flag) {
					addList.add(userRole);
				} else {
					updateList.add(userRole);
				}
			}
		} else if (StringUtils.isNotEmpty(roleid)) {
			List<User> list = JSONArray.parseArray(json, User.class);
			for (User user : list) {
				boolean flag = false;// 默认更新
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("userid", user.getId());
				params.put("roleid", Integer.valueOf(roleid));
				UserRole userRole = userRoleMapper.getUaasUserRole(params);
				if (userRole == null) {
					userRole = new UserRole();
					flag = true;
				}

				userRole.setUserid(user.getId());
				userRole.setRoleid(Integer.valueOf(roleid));
				// 判断是删除还是增加
				if ("added".equals(user.get_state())) {
					userRole.setRemoved(0);
				} else if ("removed".equals(user.get_state())) {
					userRole.setRemoved(1);
				}
				// 判断是insert还是update
				if (flag) {
					addList.add(userRole);
				} else {
					updateList.add(userRole);
				}
			}
		} else {
			return false;
		}
		if (addList.size() > 0) {
			userRoleMapper.saveUserRole(addList);
		}

		if (updateList.size() > 0) {
			for(UserRole userrole:updateList) {
				userRoleMapper.updateUserRole(userrole);
			}
			
		}
		return true;
	}
}
