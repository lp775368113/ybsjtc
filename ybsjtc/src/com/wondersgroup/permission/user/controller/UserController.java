package com.wondersgroup.permission.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.permission.user.service.UserService;
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
@RequestMapping("user")
public class UserController extends BaseController {
	@Autowired
	private UserService userService;

	@ResponseBody
    @RequestMapping("signin")
    public Map<String, Object> queryOperator(@RequestParam Map<String, Object> params) {
		Map<String, Object> result = new HashMap<String,Object>();
        try {
        	Integer newuser=userService.signin(params);
        	result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
			logger.error(e.getMessage(),e);
		}
		return result ;
	}
	
	
	
	
	@ResponseBody
    @RequestMapping("getloginname")
    public Map<String, Object> getloginname(@RequestParam Map<String, Object> params) {
		Map<String, Object> result = new HashMap<String,Object>();
        try {
        	User user=userService.getloginname((String)params.get("loginname"));
        	if(user!=null) {
        		result.put("usable", false);
        	}else {
        		result.put("usable", true);
        	}
        	
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
			logger.error(e.getMessage(),e);
		}
		return result ;
	}
	
	@ResponseBody
    @RequestMapping("queryUser")
    public Map<String, Object> queryRole(@RequestParam Map<String, Object> params) {
    	Map<String, Object> resultMap = userService.getPage(params);
		return resultMap;
	}
	
	@ResponseBody
    @RequestMapping("resetpwd")
    public Map<String, Object> resetpwd(@RequestParam Map<String, Object> params) {
		Map<String, Object> result = new HashMap<String,Object>();
        try {
        	String pwd=userService.resetpwd(params);
        	result.put("password", pwd);
        	result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
			logger.error(e.getMessage(),e);
		}
		return result ;
	}
}
