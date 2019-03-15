package com.wondersgroup.permission.menu.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.permission.menu.service.PerMenuService;
import com.wondersgroup.permission.menu.vo.PerMenu;
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
@RequestMapping("menu")
public class PerMenuController extends BaseController {
	@Autowired
	private PerMenuService perMenuService;

	
	@ResponseBody
	@RequestMapping("listMenu")
	public List<Map<String, Object>> listMenu(@RequestParam Map<String, Object> params) {
		List<PerMenu> list = perMenuService.listMenu();
		List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>(list.size());
		for (PerMenu menu : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", menu.getId());
			map.put("pid", menu.getParentid());
			map.put("text", menu.getName());
			map.put("type", menu.getType());
			treeList.add(map);
		}
		return treeList;
	}
	
	@ResponseBody
	@RequestMapping("getMenu")
	public Map<String, Object> getMenu(@RequestParam Map<String, Object> params) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			int id = Integer.valueOf(params.get("menuid").toString());
			PerMenu menu = perMenuService.getMenu(id);
			result.put("success", true);
			result.put("data", menu);
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", "菜单加载失败");
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("updateUaasMenu")
	public Map<String, Object> updateUaasMenu(PerMenu vo) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			perMenuService.updateUaasMenu(vo);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			result.put("success", false);
			result.put("msg", "保存失败");
		}
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping("saveUaasMenu")
	public Map<String, Object> saveUaasMenu(PerMenu vo) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			vo.setRemoved("0");
			perMenuService.saveUaasMenu(vo);
			result.put("success", true);
			result.put("id", vo.getId());
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.put("success", false);
			result.put("msg", "保存失败");
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("removeUaasMenu")
	public Map<String, Object> removeUaasMenu(@RequestParam Map<String, Object> params) {
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			params.put("removed", "1");
			perMenuService.removeUaasMenu(params);
			result.put("success", true);
		} catch (Exception e) {
			result.put("success", false);
			result.put("msg", "删除失败");
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("listMenuPermission")
	public List<Map<String, Object>> listMenuPermission(@RequestParam Map<String, Object> params) {
		List<PerMenu> list = perMenuService.listMenuPermission(params);
		List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>(list.size());
		for (PerMenu menu : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", menu.getId());
			map.put("parentid", menu.getParentid());
			map.put("name", menu.getName());
			map.put("ischecked","1".equals(menu.getIschecked())?true:false);
			treeList.add(map);
		}
		return treeList;
	}
	
	@ResponseBody
	@RequestMapping("listUserMenuPermission")
	public List<Map<String, Object>> listUserMenuPermission(@RequestParam Map<String, Object> params) {
		List<PerMenu> list = perMenuService.listUserMenuPermission(params);
		List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>(list.size());
		for (PerMenu menu : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("id", menu.getId());
			map.put("parentid", menu.getParentid());
			map.put("name", menu.getName());
			map.put("ischecked","1".equals(menu.getIschecked())?true:false);
			treeList.add(map);
		}
		return treeList;
	}
}
