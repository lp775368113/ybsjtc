package com.wondersgroup.materiel.bomsys.bom.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.materiel.bomsys.bom.service.MaterielBomService;
import com.wondersgroup.materiel.bomsys.bom.vo.MaterielBom;
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
@RequestMapping("bom")
public class MaterielBomController extends BaseController{
	
	public static Logger logger = Logger.getLogger(MaterielBomController.class);
	
	@Autowired
	private  MaterielBomService materielBomService;
	
	@ResponseBody
	@RequestMapping("queryBom")
	public List<MaterielBom> queryBom(@RequestParam Map<String, Object> params){
		return materielBomService.queryBom(params);
	}
	
	@ResponseBody
	@RequestMapping(value = "importBom", method = RequestMethod.POST)
	 public Map<String,Object> importExcle(@RequestParam MultipartFile[] myfiles,  @RequestParam Map<String, Object> paramMap,HttpServletRequest request) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			materielBomService.importBom(myfiles,paramMap,request);
			result.put("success", true);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		return result;
    }
	
	@ResponseBody
	@RequestMapping("editBom")
	 public Map<String,Object> editBom(@RequestParam Map<String, Object> param,HttpServletRequest request) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		try {
			materielBomService.editBom(param,request);
			result.put("success", true);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		return result;
    }
	
	
	@ResponseBody
	@RequestMapping("getAllVersion")
	 public List<Map> getAllVersion(@RequestParam Map<String, Object> param) throws Exception{
		return materielBomService.getAllVersion(param);
    }
	
	
	@ResponseBody
	@RequestMapping("canImportBom")
	 public Map<String,Object> canImportBom(@RequestParam Map<String, Object> param) throws Exception{
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			Boolean can= materielBomService.canImportBom(param);
			result.put("can", can);
			result.put("success",true);
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		return result;
    }
}
