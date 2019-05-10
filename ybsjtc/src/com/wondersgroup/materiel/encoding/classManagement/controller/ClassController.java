package com.wondersgroup.materiel.encoding.classManagement.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.materiel.encoding.brandManagement.service.BrandSupplierService;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrand;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielSupplier;
import com.wondersgroup.materiel.encoding.classManagement.service.ClassService;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielBigclass;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielSmallclass;
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
@RequestMapping("class")
public class ClassController extends BaseController{
	
	public static Logger logger = Logger.getLogger(ClassController.class);
	
	@Autowired
	private  ClassService classService;
	
	@ResponseBody
	@RequestMapping("querybigclass")
	public Map<String, Object> querybigclass(@RequestParam Map<String, Object> params){
		int pageIndex = Integer.parseInt( params.get("pageIndex").toString());
        int pageSize = Integer.parseInt(params.get("pageSize").toString());
		int start = pageIndex * pageSize;
		params.put("row",pageSize);
		params.put("start",start);
		Map<String, Object> map =classService.querybigclass(params);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("savebigclass")
	public Map<String, Object> savebigclass(MaterielBigclass params){
		Map<String, Object> result=new HashMap<String,Object>();
		try {
			classService.savebigclass(params);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		return result;
	}
	
	@ResponseBody
	@RequestMapping("updatebigclass")
	public Map<String, Object> updatebigclass(MaterielBigclass params){
		Map<String, Object> result=new HashMap<String,Object>();
		try {
			classService.updatebigclass(params);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		return result;
	}

	@ResponseBody
	@RequestMapping("getAllbigclass")
	public List<MaterielBigclass> getAllbigclass( ){
		return classService.getAllbigclass();
	}
	
	
	@ResponseBody
	@RequestMapping("getAllbigclassPre")
	public List<MaterielBigclass> getAllbigclassPre( ){
		return classService.getAllbigclassPre();
	}
	
	@ResponseBody
	@RequestMapping("querysmallclass")
	public Map<String, Object> querysmallclass(@RequestParam Map<String, Object> params){
		int pageIndex = Integer.parseInt( params.get("pageIndex").toString());
        int pageSize = Integer.parseInt(params.get("pageSize").toString());
		int start = pageIndex * pageSize;
		params.put("row",pageSize);
		params.put("start",start);
		Map<String, Object> map =classService.querysmallclass(params);
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping("getSmallClassPre")
	public List<MaterielSmallclass> getSmallClassPre(@RequestParam Map<String, Object> params){
		return classService.getSmallClassPre(params);
	}
	
	@ResponseBody
	@RequestMapping("getAllSmallClass")
	public List<MaterielSmallclass> getAllSmallClass(@RequestParam Map<String, Object> params){
		return classService.getAllSmallClass(params);
	}
	
	
	@ResponseBody
	@RequestMapping("getBigClassBySmallclassid")
	public List<MaterielSmallclass> getBigClassBySmallclassid(@RequestParam Map<String, Object> params){
		return classService.getBigClassBySmallclassid(params);
	}
	
	@ResponseBody
	@RequestMapping("savesmallclass")
	public Map<String, Object> savesmallclass(MaterielSmallclass params){
		Map<String, Object> result=new HashMap<String,Object>();
		try {
			classService.savesmallclass(params);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping("updatesmallclass")
	public Map<String, Object> updatesmallclass(MaterielSmallclass params){
		Map<String, Object> result=new HashMap<String,Object>();
		try {
			classService.updatesmallclass(params);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		return result;
	}
}
