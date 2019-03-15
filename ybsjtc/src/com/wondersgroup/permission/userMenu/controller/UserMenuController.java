package com.wondersgroup.permission.userMenu.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.permission.rolePermission.service.RolePermissionService;
import com.wondersgroup.permission.userMenu.service.UserMenuService;

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
@RequestMapping("userMenu")
public class UserMenuController extends BaseController {
	@Autowired
	private UserMenuService userMenuService;
	
	@ResponseBody
	@RequestMapping("saveUserMenu")
	public Map<String, Object> saveUserMenu(@RequestParam Map<String, Object> map) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			userMenuService.saveUserMenu(map);
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
