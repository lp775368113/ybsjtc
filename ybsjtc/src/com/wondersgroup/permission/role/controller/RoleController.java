package com.wondersgroup.permission.role.controller;

import java.net.URLDecoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.framework.comwork.controller.SessionConstants;
import com.wondersgroup.permission.role.service.RoleService;
import com.wondersgroup.permission.role.vo.Role;
import com.wondersgroup.permission.user.service.UserService;
import com.wondersgroup.permission.user.vo.User;
/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [hzxzxt]
 * @Package:      [com.wondersgroup.permission.role.controller]
 * @ClassName:    [UaasRoleController]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [chenyibing]   	   
 * @CreateDate:   [2018-5-6 下午4:07:15]  
 * @UpdateUser:   [chenyibing]   	   
 * @UpdateDate:   [2018-5-6 下午4:07:15]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
@Controller
@RequestMapping("role")
public class RoleController  extends BaseController{
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
    @RequestMapping("queryRole")
    public Map<String, Object> queryRole(@RequestParam Map<String, Object> params) {
    	Map<String, Object> resultMap = roleService.getPage(params);
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping("saveUaasRole")
	public Map<String, Object> saveUaasRole(HttpServletRequest request,Role record) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			User user = (User)request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
			if(user!=null){
				record.setCreatorid(user.getId());
			}
			record.setRemoved(0);
			record.setEnddate(new Date());
			roleService.saveUaasRole(record);
			result.put("success", true);
			result.put("msg", "新增成功");
		} catch (Exception e) {
			logger.error("新增失败：" + e.getMessage(), e);
			result.put("success", false);
			result.put("msg", "新增失败：" + e.getMessage());
		}

		return result;
	}
	
	@ResponseBody
	@RequestMapping("updateUaasRole")
	public Map<String, Object> updateUaasRole(Role record) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			roleService.updateUaasRole(record);
			result.put("success", true);
			result.put("msg", "修改成功");
		} catch (Exception e) {
			logger.error("修改失败：" + e.getMessage(), e);
			result.put("success", false);
			result.put("msg", "修改失败：" + e.getMessage());
		}

		return result;
	}
	
	@ResponseBody
	@RequestMapping("removeUaasRole")
	public Map<String, Object> removeUaasRole(@RequestParam Map<String, Object> params) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			String json = URLDecoder.decode(params.get("datalist").toString(), "UTF-8");
			List<Role> list  = JSONArray.parseArray(json, Role.class);
			roleService.removeUaasRole(list);
			result.put("success", true);
			result.put("msg", "删除成功");
		} catch (Exception e) {
			logger.error("删除失败：" + e.getMessage(), e);
			result.put("success", false);
			result.put("msg", "删除失败：" + e.getMessage());
		}

		return result;
	}
	
	@ResponseBody
    @RequestMapping("queryUser")
    public Map<String, Object> queryUser(@RequestParam Map<String, Object> params) {
    	Map<String, Object> resultMap = userService.getPage(params);
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping("changeUserRole")
	public Map<String, Object> changeUserRole(@RequestParam Map<String, Object> map) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if(roleService.changeUserRole(map)){
				result.put("success", true);
				result.put("msg", "操作成功");
			}else{
				result.put("success", false);
				result.put("msg", "操作失败");
				return result;
			}
		} catch (Exception e) {
			logger.error("操作失败：" + e.getMessage(), e);
			result.put("success", false);
			result.put("msg", "操作失败：" + e.getMessage());
		}

		return result;
	}
	/*
	@ResponseBody
	@RequestMapping("getUaasRole")
	public Map<String, Object> getUaasRole(@RequestParam Map<String, Object> params) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			int id = Integer.valueOf(params.get("id").toString());
			UaasRole role = uaasRoleService.getUaasRole(id);
			result.put("success", true);
			result.put("data", role);
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", "角色加载失败");
		}
		return result;
	}
	*/
}
