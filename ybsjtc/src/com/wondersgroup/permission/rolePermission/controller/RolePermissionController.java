package com.wondersgroup.permission.rolePermission.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.permission.rolePermission.service.RolePermissionService;

/**
 * *********************************************** Simple to Introduction
 * 
 * @ProjectName: [hzxzxt]
 * @Package: [com.wondersgroup.permission.rolePermission.controller]
 * @ClassName: [RolePermissionController]
 * @Description: [一句话描述该类的功能]
 * @Author: [chenyibing]
 * @CreateDate: [2018-5-6 下午6:43:54]
 * @UpdateUser: [chenyibing]
 * @UpdateDate: [2018-5-6 下午6:43:54]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 ************************************************** **/
@Controller
@RequestMapping("rolePermission")
public class RolePermissionController extends BaseController {
	@Autowired
	private RolePermissionService rolePermissionService;
	
	@ResponseBody
	@RequestMapping("saveRoleMenu")
	public Map<String, Object> saveRoleMenu(@RequestParam Map<String, Object> map) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			rolePermissionService.saveRoleMenu(map);
			result.put("success", true);
			result.put("msg", "授权成功");
		} catch (Exception e) {
			logger.error("授权失败：" + e.getMessage(), e);
			result.put("success", false);
			result.put("msg", "授权失败：" + e.getMessage());
		}
		return result;
	}
}
