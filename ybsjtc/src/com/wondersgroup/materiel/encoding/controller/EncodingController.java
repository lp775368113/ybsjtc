package com.wondersgroup.materiel.encoding.controller;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.framework.comwork.controller.SessionConstants;
import com.wondersgroup.framework.jxls.JxlsExcelView;
import com.wondersgroup.framework.jxls.JxlsRead;
import com.wondersgroup.materiel.encoding.service.EncodingService;
import com.wondersgroup.materiel.encoding.vo.Data0017;
import com.wondersgroup.materiel.encoding.vo.MaterielDevice;
import com.wondersgroup.materiel.encoding.vo.MaterielSupplier;
import com.wondersgroup.materiel.encoding.vo.Units;
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
@RequestMapping("encoding")
public class EncodingController extends BaseController{
	
	public static Logger logger = Logger.getLogger(EncodingService.class);
	
	@Autowired
	private  EncodingService encodingService;
	
	@ResponseBody
	@RequestMapping("getMaterielList")
	public Map<String, Object> listSysParameter(@RequestParam Map<String, Object> params){
		int pageIndex = Integer.parseInt( params.get("pageIndex").toString());
        int pageSize = Integer.parseInt(params.get("pageSize").toString());
		int start = pageIndex * pageSize;
		int end = start + pageSize;
		params.put("end",end);
		params.put("start",start);
		Map<String, Object> map = encodingService.getPage(params);
		return map;
	}
	
	@ResponseBody
	@RequestMapping("getMaxClass")
	public List<MaterielDevice> getMaxClass(@RequestParam Map<String, Object> params){
		return encodingService.getMaxClass(params);
	}
	
	
	@ResponseBody
	@RequestMapping("getMinClass")
	public List<MaterielDevice> getMinClass(@RequestParam Map<String, Object> params){
		return encodingService.getMinClass(params);
	}
	
	
	@ResponseBody
	@RequestMapping("getUnit")
	public List<Units> getUnit(@RequestParam Map<String, Object> params){
		return encodingService.getUnit(params);
	}
	
	
	@ResponseBody
	@RequestMapping("getSupplier")
	public List<MaterielSupplier> getSupplier(@RequestParam Map<String, Object> params){
		return encodingService.getSupplier(params);
	}
	
	@ResponseBody
	@RequestMapping("getWLMS")
	public MaterielDevice getWLMS(@RequestParam Map<String, Object> params){
		return encodingService.getWLMS(params);
	}
	
	/**
	 * @Title: 		 getWLMS   
	 * @Description: TODO[用一句话描述这个方法的作用]  新增物料信息 
	 * @param params
	 * @return      
	 * @return_type: MaterielDevice
	 */
	@ResponseBody
	@RequestMapping("saveData0017")
	public Map saveData0017(Data0017 params,HttpServletRequest request){
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			User user=(User)request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
			encodingService.saveData0017(params,user);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		return result;
	}
	
	/**
	 * @Title: 		 SD   
	 * @Description: TODO[用一句话描述这个方法的作用]    作废失效编码
	 * @param params
	 * @return      
	 * @return_type: Map
	 */
	@ResponseBody
	@RequestMapping("SD")
	public Map SD(Data0017 params,@RequestParam String SD,HttpServletRequest request){
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			String extraDesc=params.getExtraDesc();
			extraDesc=extraDesc+"-"+SD;
			params.setStatus("5");
			params.setExtraDesc(extraDesc);
			params.setErpid(Integer.parseInt(params.getRkey()));
			String message="";
			if("S".equals(SD)){
				message="失效编码";
			}else{
				message="作废编码";
			}
			User user=(User)request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
			encodingService.addUpdateData(params,user,message);
			result.put("success", true);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			result.put("success", false);
			result.put("message", e.getMessage());
		}
		return result;
	}
	
	
	@ResponseBody
	@RequestMapping("getMaterielUpdata")
	public Map getMaterielUpdata(@RequestParam Map<String, Object> params){
		int pageIndex = Integer.parseInt( params.get("pageIndex").toString());
        int pageSize = Integer.parseInt(params.get("pageSize").toString());
		int start = pageIndex * pageSize;
		int end = start + pageSize;
		int row=end-start;
		params.put("end",end);
		params.put("start",start);
		params.put("row",row);
		Map<String, Object> map = encodingService.getThisPage(params);
		return map;
	}
	
	/**
	 * @Title: 		 exportExcle   
	 * @Description: TODO[用一句话描述这个方法的作用]   Excle导入
	 * @param params
	 * @return      
	 * @return_type: ModelAndView
	 */
	@RequestMapping("exportExcle") 
	public ModelAndView exportExcle(@RequestParam Map<String,Object> params){
		Map<String, Object> model = new HashMap<String, Object>();
		List<Data0017> list = encodingService.getExportData(params);
        model.put("users", list);
        String affairtypeid=(String) params.get("affairtypeid");
        return new ModelAndView(new JxlsExcelView("xls/exportMaterial_info.xls","Material"), model);
	}
	
	@SuppressWarnings("unchecked")
	@ResponseBody
    @RequestMapping("importExcle")
    public Map<String,Object> importExcle(@RequestParam MultipartFile[] myfiles,  @RequestParam Map<String, Object> paramMap,HttpServletRequest request) throws Exception{
		Map<String,Object> result = new HashMap<String,Object>();
		try {
		Map<String,Object> beans = new HashMap<String,Object>();
        InputStream inputXML = new BufferedInputStream(request.getServletContext().getResourceAsStream("xls/ImportMaterial.xml"));  
        List<Data0017> data0017list = new ArrayList<Data0017>();
        beans.put("list", data0017list);
        Map<String,Object> needSaveData=JxlsRead.ExcelToBean(inputXML, myfiles[0], beans);
		ArrayList<Data0017> list=(ArrayList<Data0017>) needSaveData.get("list");
        for(Data0017 bean:list){
        	bean.setRkey(String.valueOf((int)bean.getErpid()));
        	bean.setStatus("9");
        	encodingService.updateThisData(bean);
        }
        result.put("success", true);
        return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
			return result;
		}
        
    }
	
}
