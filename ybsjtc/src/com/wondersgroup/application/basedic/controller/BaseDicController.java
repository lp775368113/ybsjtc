package com.wondersgroup.application.basedic.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wondersgroup.application.basedic.service.BaseDicService;
import com.wondersgroup.application.basedic.vo.DicCodeInfo;
import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.materiel.bomsys.product.service.ProductService;
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
@RequestMapping("dictionaries")
public class BaseDicController extends BaseController{
	
	public static Logger logger = Logger.getLogger(BaseDicController.class);
	
	@Autowired
	private  BaseDicService baseDicService;
	
	@ResponseBody
	@RequestMapping("getDic")
	public List<DicCodeInfo> getDic(@RequestParam Map<String, Object> params){
		return baseDicService.getDic(params);
	}
	
	@ResponseBody
	@RequestMapping("getProductType")
	public List<Map<String,Object>> getProductType(@RequestParam Map<String, Object> params){
		return baseDicService.getProductType(params);
	}
	
}
