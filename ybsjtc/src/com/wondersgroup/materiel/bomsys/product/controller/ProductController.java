package com.wondersgroup.materiel.bomsys.product.controller;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.framework.comwork.controller.SessionConstants;
import com.wondersgroup.materiel.bomsys.product.service.ProductService;
import com.wondersgroup.materiel.bomsys.product.vo.MaterielProduct;
import com.wondersgroup.materiel.encoding.brandManagement.service.BrandSupplierService;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielBrand;
import com.wondersgroup.materiel.encoding.brandManagement.vo.MaterielSupplier;
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
@RequestMapping("product")
public class ProductController extends BaseController{
	
	public static Logger logger = Logger.getLogger(ProductController.class);
	
	@Autowired
	private  ProductService productService;
	
	@ResponseBody
	@RequestMapping("queryProduct")
	public Map<String, Object> queryProduct(@RequestParam Map<String, Object> params){
		int pageIndex = Integer.parseInt( params.get("pageIndex").toString());
        int pageSize = Integer.parseInt(params.get("pageSize").toString());
		int start = pageIndex * pageSize;
		params.put("row",pageSize);
		params.put("start",start);
		Map<String, Object> map =productService.getPage(params);
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value = "editProduct", method = RequestMethod.POST)
	public Map<String, Object> editProduct(MaterielProduct materielProduct,HttpServletRequest request){
		Map<String, Object> result=new HashMap<String, Object>();
		try {
			User user=(User)request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
			String action =materielProduct.getAction();
			if("add".equals(action)) {
				materielProduct.setCreateUserid(user.getId());
				productService.addProduct(materielProduct);
			}else if("modify".equals(action)) {
				materielProduct.setUpdateUserid(user.getId());
				productService.updateProduct(materielProduct);
			}else {
				throw new RuntimeException("操作有误，请重试！");
			}
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		return result;
	}
	
	
	
}
