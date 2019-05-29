package com.wondersgroup.permission.button.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.framework.comwork.controller.SessionConstants;
import com.wondersgroup.permission.button.service.ButtonService;
import com.wondersgroup.permission.button.vo.Button;
import com.wondersgroup.permission.user.vo.User;
/**
 * *********************************************** Simple to Introduction
 * 
 * @ProjectName: [hzxzxt]
 * @Package: [com.wondersgroup.permission.menu.controller]
 * @ClassName: [UaasMenuController]
 * @Description: [一句话描述该类的功能]
 * @Author: [chenyibing]
 * @CreateDate: [2018-5-7 下午5:34:15]
 * @UpdateUser: [chenyibing]
 * @UpdateDate: [2018-5-7 下午5:34:15]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 ************************************************** **/
@Controller
@RequestMapping("button")
public class ButtonController{
	
	public static Logger logger = Logger.getLogger(ButtonController.class);
	
	@Autowired
	private ButtonService buttonService;

	
	@ResponseBody
	@RequestMapping("buttonPer")
	public Map<String, Object> buttonPer(@RequestParam Map<String, Object> params,HttpServletRequest request) {
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			User user=(User)request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
			List<Button> list= buttonService.buttonPer(user);
			result.put("buttons", list);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
			result.put("success", false);
		}
		return result;
	}
	
	
	@ResponseBody
    @RequestMapping("queryButton")
    public Map<String, Object> queryButton(@RequestParam Map<String, Object> params) {
		int pageIndex = Integer.parseInt( params.get("pageIndex").toString());
        int pageSize = Integer.parseInt(params.get("pageSize").toString());
		int start = pageIndex * pageSize;
		int end = start + pageSize;
		params.put("row",pageSize);
		params.put("start",start);
		Map<String, Object> map = buttonService.getPage(params);
		return map;
	}
	
	
	
	@ResponseBody
    @RequestMapping("queryUserButton")
    public Map<String, Object> queryUserButton(@RequestParam Map<String, Object> params) {
		int pageIndex = Integer.parseInt( params.get("pageIndex").toString());
        int pageSize = Integer.parseInt(params.get("pageSize").toString());
		int start = pageIndex * pageSize;
		int end = start + pageSize;
		params.put("row",pageSize);
		params.put("start",start);
		Map<String, Object> map = buttonService.queryUserButton(params);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("changeButtonRole")
	public Map<String, Object> changeButtonRole(@RequestParam Map<String, Object> map) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
				buttonService.changeButtonRole(map);
				result.put("success", true);
				result.put("msg", "操作成功");
		} catch (Exception e) {
			logger.error("操作失败：" + e.getMessage(), e);
			result.put("success", false);
			result.put("msg", "操作失败：" + e.getMessage());
		}

		return result;
	}
	
	
	@ResponseBody
	@RequestMapping("changeButtonUser")
	public Map<String, Object> changeButtonUser(@RequestParam Map<String, Object> map) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
				buttonService.changeButtonUser(map);
				result.put("success", true);
				result.put("msg", "操作成功");
		} catch (Exception e) {
			logger.error("操作失败：" + e.getMessage(), e);
			result.put("success", false);
			result.put("msg", "操作失败：" + e.getMessage());
		}

		return result;
	}
}
