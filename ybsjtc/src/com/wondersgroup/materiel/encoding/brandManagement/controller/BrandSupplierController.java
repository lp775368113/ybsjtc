package com.wondersgroup.materiel.encoding.brandManagement.controller;
import java.util.HashMap;
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
@RequestMapping("BrandSupplier")
public class BrandSupplierController extends BaseController{
	
	public static Logger logger = Logger.getLogger(BrandSupplierController.class);
	
	@Autowired
	private  BrandSupplierService brandSupplierService;
	
	@ResponseBody
	@RequestMapping("queryBrand")
	public Map<String, Object> queryBrand(@RequestParam Map<String, Object> params){
		int pageIndex = Integer.parseInt( params.get("pageIndex").toString());
        int pageSize = Integer.parseInt(params.get("pageSize").toString());
		int start = pageIndex * pageSize;
		params.put("row",pageSize);
		params.put("start",start);
		Map<String, Object> map =brandSupplierService.getBrandPage(params);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("addBrand")
	public Map<String, Object> addBrand(MaterielBrand brand){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			brand.setRemoved("0");
			brandSupplierService.addBrand(brand);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping("querySupplier")
	public Map<String, Object> querySupplier(@RequestParam Map<String, Object> params){
		int pageIndex = Integer.parseInt( params.get("pageIndex").toString());
        int pageSize = Integer.parseInt(params.get("pageSize").toString());
		int start = pageIndex * pageSize;
		params.put("row",pageSize);
		params.put("start",start);
		Map<String, Object> map =brandSupplierService.getSupplierPage(params);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("addSupplier")
	public Map<String, Object> addSupplier(MaterielSupplier supplier){
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			supplier.setRemoved("0");
			supplier.setStatus("1");
			brandSupplierService.addSupplier(supplier);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result.put("success", false);
			result.put("msg", e.getMessage());
		}
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping("changeBrandSupplier")
	public Map<String, Object> changeBrandSupplier(@RequestParam Map<String, Object> map) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			if(brandSupplierService.changeBrandSupplier(map)){
				result.put("success", true);
				result.put("message", "操作成功");
			}else{
				result.put("success", false);
				result.put("message", "操作失败");
				return result;
			}
		} catch (Exception e) {
			logger.error("操作失败：" + e.getMessage(), e);
			result.put("success", false);
			result.put("message", "操作失败：" + e.getMessage());
		}

		return result;
	}
}
