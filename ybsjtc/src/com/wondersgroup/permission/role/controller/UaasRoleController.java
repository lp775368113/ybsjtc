package com.wondersgroup.permission.role.controller;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.framework.comwork.controller.SessionConstants;
import com.wondersgroup.permission.role.service.UaasRoleService;
import com.wondersgroup.permission.role.vo.UaasRole;
import com.wondersgroup.permission.user.service.UserService;
import com.wondersgroup.permission.user.vo.UaasUser;

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
@RequestMapping("uaasRole")
public class UaasRoleController  extends BaseController{
	@Autowired
	private UaasRoleService uaasRoleService;
	@Autowired
	private UserService userService;
	
	@ResponseBody
    @RequestMapping("queryRole")
    public Map<String, Object> queryRole(@RequestParam Map<String, Object> params) {
    	Map<String, Object> resultMap = uaasRoleService.getPage(params);
		return resultMap;
	}
	
	@ResponseBody
    @RequestMapping("queryUser")
    public Map<String, Object> queryUser(@RequestParam Map<String, Object> params) {
    	Map<String, Object> resultMap = userService.getPage(params);
		return resultMap;
	}
	
	@ResponseBody
	@RequestMapping("saveUaasRole")
	public Map<String, Object> saveUaasRole(HttpServletRequest request,UaasRole record) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			UaasUser user = (UaasUser)request.getSession().getAttribute(SessionConstants.SECURITY_LOGIN_USER);
			if(user!=null){
				record.setCreatorid(user.getId());
			}
			uaasRoleService.saveUaasRole(record);
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
	@RequestMapping("changeUserRole")
	public Map<String, Object> changeUserRole(@RequestParam Map<String, Object> map) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if(uaasRoleService.changeUserRole(map)){
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
	
	@ResponseBody
	@RequestMapping("updateUaasRole")
	public Map<String, Object> updateUaasRole(UaasRole record) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			uaasRoleService.updateUaasRole(record);
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
			List<UaasRole> list  = JSONArray.parseArray(json, UaasRole.class);
			uaasRoleService.removeUaasRole(list);
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
	
}
