package com.wondersgroup.materiel.encoding.controller;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
import com.wondersgroup.materiel.encoding.classManagement.service.ClassService;
import com.wondersgroup.materiel.encoding.classManagement.vo.MaterielSmallclass;
import com.wondersgroup.materiel.encoding.service.EncodingService;
import com.wondersgroup.materiel.encoding.vo.Data0017;
import com.wondersgroup.materiel.encoding.vo.MaterielDevice;
import com.wondersgroup.materiel.encoding.vo.MaterielFile;
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
	
	@Autowired
	private  ClassService classService;
	
	
	
	@ResponseBody
	@RequestMapping("getMaterielList")
	public Map<String, Object> listSysParameter(@RequestParam Map<String, Object> params){
		int pageIndex = Integer.parseInt( params.get("pageIndex").toString());
        int pageSize = Integer.parseInt(params.get("pageSize").toString());
		int start = pageIndex * pageSize;
		int end = start + pageSize;
		params.put("row",pageSize);
		params.put("end",end);
		params.put("start",start);
		Map<String, Object> map = encodingService.getPage(params);
		return map;
	}
	
	/**
	 * @Title: 		 checkValue   
	 * @Description: TODO[用一句话描述这个方法的作用]   验证厂商料号和物料描述唯一
	 * @param params
	 * @return      
	 * @return_type: Map<String,Object>
	 */
	@ResponseBody
	@RequestMapping("checkValue")
	public Map<String, Object> checkValue(@RequestParam Map<String, Object> params){
		Map<String, Object> map = encodingService.checkValue(params);
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping("getUnit")
	public List<Units> getUnit(@RequestParam Map<String, Object> params){
		return encodingService.getUnit(params);
	}
	
	
	
	@ResponseBody
	@RequestMapping("getSmallclass")
	public MaterielSmallclass getSmallclass(@RequestParam Map<String, Object> params){
		return classService.getSmallclassById(params);
	}
	
	@ResponseBody
	@RequestMapping("getSupplier")
	public List<MaterielSupplier> getSupplier(@RequestParam Map<String, Object> params){
		return encodingService.getSupplier(params);
	}
	
	
	
	@ResponseBody
	@RequestMapping("getAllSupplier")
	public List<MaterielSupplier> getAllSupplier(@RequestParam Map<String, Object> params){
		return encodingService.getAllSupplier(params);
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
	
	
	@ResponseBody
	@RequestMapping("editData0017")
	public Map editData0017(Data0017 params,HttpServletRequest request){
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			User user=(User)request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
			params.setErpid(Integer.parseInt(params.getRkey()));
			encodingService.editData0017(params,user);
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
	@RequestMapping("saveReplaceData0017")
	public Map saveReplaceData0017(Data0017 params,HttpServletRequest request){
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			User user=(User)request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
			encodingService.saveReplaceData0017(params,user);
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
	 * @Description: TODO[用一句话描述这个方法的作用]    作废编码,失效编码
	 * @param params
	 * @return      
	 * @return_type: Map
	 */
	@ResponseBody
	@RequestMapping("SD")
	public Map SD(@RequestParam Map<String, Object> params,@RequestParam String SD,HttpServletRequest request){
		Map<String,Object> result=new HashMap<String,Object>();
		try {
			Data0017 bean=new Data0017();
			bean.setInvPartNumber((String)params.get("invPartNumber"));
			bean.setProdSupper((String)params.get("prodSupper"));
			bean.setPackage_((String)params.get("package_"));
			bean.setErpid(Integer.parseInt((String)params.get("rkey")));
			bean.setTtype((String)params.get("ttype"));
			bean.setProdCodeSellPtr((String)params.get("prodCodeSellPtr"));
			bean.setSmtFlag((String)params.get("smtFlag"));
			bean.setInvPartDescriptionC((String)params.get("invPartDescriptionC"));
			bean.setCustPartName((String)params.get("custPartName"));
			bean.setCustPartCode((String)params.get("custPartCode"));
			bean.setPurchUnitPtr((String)params.get("purchUnitPtr"));
			bean.setStockUnitPtr((String)params.get("stockUnitPtr"));
			bean.setSupplierPtr((String)params.get("supplierPtr"));
			bean.setStdCost((String)params.get("stdCost"));
			bean.setStockPurch((String)params.get("stockPurch"));
			String extraDesc=(String)params.get("extraDesc");
			extraDesc=extraDesc+"-"+SD;
			bean.setStatus("5");
			bean.setExtraDesc(extraDesc);
			String message="";
			if("S".equals(SD)){
				message="失效编码";
			}else{
				message="作废编码";
			}
			User user=(User)request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
			encodingService.addUpdateData(bean,user,message);
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
        	if("1".equals(bean.getErpstatus())) {
        		Data0017 needupdate=new Data0017();
        		needupdate.setErpid(bean.getErpid());
        		needupdate.setId(bean.getId());
        		needupdate.setInvPartNumber(bean.getInvPartNumber());
        		needupdate.setRkey(String.valueOf((int)bean.getErpid()));
        		needupdate.setStatus("9");
            	encodingService.updateThisData(needupdate);
        	}
        }
        result.put("success", true);
        return result;
		} catch (Exception e) {
			e.printStackTrace();
			result.put("error", e.getMessage());
			return result;
		}
        
    }
	
	/**
	 * @Title: 		 upload   
	 * @Description: TODO[用一句话描述这个方法的作用]    上传文件
	 * @param request
	 * @param myfile
	 * @param params
	 * @return
	 * @throws IOException      
	 * @return_type: Map<String,Object>
	 */
	@RequestMapping("uploadfile")
	@ResponseBody
	public Map<String ,Object> upload(HttpServletRequest request, @RequestParam MultipartFile[] myfile,@RequestParam Map<String, Object> params){
		Map<String, Object> resultMap = new HashMap<String,Object>();;
		try {
			MaterielFile sm = encodingService.upload(myfile,request,params);
			resultMap.put("success", true);
			resultMap.put("file", sm);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("error", e.getMessage());
			return resultMap;
		}
		return resultMap;
	}
	
	@RequestMapping("downloadFile")
	public  ResponseEntity<byte[]> base64ToFile(HttpServletRequest request) throws IOException {
				return encodingService.downloadFile(request);
	}

	
	@ResponseBody
	@RequestMapping("getProdSupper")
	public List<MaterielDevice> getProdSupper(@RequestParam Map<String, Object> params){
		return encodingService.getProdSupper(params);
	}
	
	
	@ResponseBody
	@RequestMapping("getFilesPre")
	public List<MaterielFile> getFilesPre(@RequestParam Map<String, Object> params){
		return encodingService.getFilesPre(params);
	}
	
	
	@ResponseBody
	@RequestMapping("lodingremark")
	public Data0017 lodingremark(Integer erpid){
		return encodingService.lodingremark(erpid);
	}
	
}
