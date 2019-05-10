package com.wondersgroup.materiel.encoding.packageManagement.controller;
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
import org.springframework.web.multipart.MultipartFile;

import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.framework.comwork.controller.SessionConstants;
import com.wondersgroup.materiel.encoding.brandManagement.service.BrandSupplierService;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrand;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielSupplier;
import com.wondersgroup.materiel.encoding.classManagement.service.ClassService;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielBigclass;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielSmallclass;
import com.wondersgroup.materiel.encoding.packageManagement.service.PackageService;
import com.wondersgroup.materiel.encoding.packageManagement.vo.MaterielPackage;
import com.wondersgroup.materiel.encoding.vo.MaterielFile;
import com.wondersgroup.permission.user.vo.User;
/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [hzxzxt]
 * @Package:      [com.wondersgroup.sysSetup.paramManage.controller]
 * @ClassName:    [SysParameterController]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [wumengfei]   	   
 * @CreateDate:   [2018-6-21 下午2:36:12]  
 * @UpdateUser:   [wumengfei]   	   
 * @UpdateDate:   [2018-6-21 下午2:36:12]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
@Controller
@RequestMapping("package")
public class PackageController extends BaseController{
	
	public static Logger logger = Logger.getLogger(PackageController.class);
	
	@Autowired
	private  PackageService packageService;
	
	@ResponseBody
	@RequestMapping("querypackage")
	public Map<String, Object> querybigclass(@RequestParam Map<String, Object> params){
		int pageIndex = Integer.parseInt( params.get("pageIndex").toString());
        int pageSize = Integer.parseInt(params.get("pageSize").toString());
		int start = pageIndex * pageSize;
		params.put("row",pageSize);
		params.put("start",start);
		Map<String, Object> map =packageService.querybigclass(params);
		return map;
	}
	
	
	
	@ResponseBody
	@RequestMapping("editpackage")
	public Map<String ,Object> editpackage(HttpServletRequest request, @RequestParam MultipartFile[] images,MaterielPackage materielPackage){
		Map<String, Object> resultMap = new HashMap<String,Object>();;
		try {
			 packageService.editpackage(images,request,materielPackage);
			resultMap.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("success", false);
			resultMap.put("message", e.getMessage());
			return resultMap;
		}
		return resultMap;
	}
	
	
	@ResponseBody
	@RequestMapping("delete")
	public Map<String ,Object> delete(MaterielPackage materielPackage){
		Map<String, Object> resultMap = new HashMap<String,Object>();;
		try {
			 packageService.delete(materielPackage);
			resultMap.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("success", false);
			resultMap.put("message", e.getMessage());
			return resultMap;
		}
		return resultMap;
	}
	
	
	@ResponseBody
	@RequestMapping("getAllpackage")
	public List<MaterielPackage> getAllpackage(@RequestParam Map<String, Object> params){
		List<MaterielPackage> list =packageService.getAllpackage(params);
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping("getPackageByName")
	public MaterielPackage getPackageByName(@RequestParam Map<String, Object> params){
		MaterielPackage materielPackage =packageService.getPackageByName(params);
		return materielPackage;
	}
}
