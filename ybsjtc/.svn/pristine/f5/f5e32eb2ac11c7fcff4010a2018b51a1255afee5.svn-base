package com.wondersgroup.application.basedic.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wondersgroup.application.basedao.bo.Aa10;
import com.wondersgroup.application.basedao.bo.Aa13;
import com.wondersgroup.application.basedic.service.ComService;
import com.wondersgroup.framework.comwork.controller.BaseController;
import com.wondersgroup.framework.util.StringUtil;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.application.basedic.controller]
 * @ClassName:    [ComController]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年2月3日 下午8:17:59]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年2月3日 下午8:17:59]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
@Controller
@RequestMapping("common")
public class ComController  extends BaseController {
	@Resource(name = "comService")
	private ComService comService;
	
    @RequestMapping(value="getDic_s",produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Object> getDic_s(@RequestParam Map<String, Object> paramMap){
//		bka142	varchar2(10)	y		参数1
//		bka143	varchar2(10)	y		参数2
//		bka144	varchar2(10)	y		参数3
//		bka145	varchar2(10)	y		参数4
//		bka146	varchar2(10)	y		参数5
    	//转数组覆盖原来的字符串
    	if(paramMap.containsKey("bka142") && !StringUtil.isNullOrEmpty(paramMap.get("bka142")) ) 
    		paramMap.put("bka142",paramMap.get("bka142").toString().split(","));
    	if(paramMap.containsKey("bka143") && !StringUtil.isNullOrEmpty(paramMap.get("bka143")) ) 
    		paramMap.put("bka143",paramMap.get("bka143").toString().split(","));
    	if(paramMap.containsKey("bka144") && !StringUtil.isNullOrEmpty(paramMap.get("bka144")) ) 
    		paramMap.put("bka144",paramMap.get("bka144").toString().split(","));
    	if(paramMap.containsKey("bka145") && !StringUtil.isNullOrEmpty(paramMap.get("bka145")) ) 
    		paramMap.put("bka145",paramMap.get("bka145").toString().split(","));
    	if(paramMap.containsKey("bka146") && !StringUtil.isNullOrEmpty(paramMap.get("bka146")) ) 
    		paramMap.put("bka146",paramMap.get("bka146").toString().split(","));
    	List<Object> list = null;
		if("AAA027".equals(paramMap.get("aaa100").toString().toUpperCase().trim()))
			list = comService.getAAA027(paramMap);
		else
			list = comService.getDic(paramMap);
    	return list;
    }
    
    @RequestMapping(value="getDic_c",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getDic_c(@RequestParam Map<String, Object> paramMap){
    	StringBuffer sb = new StringBuffer();
    	try {
    		List<Object> list = null;
    		sb.append("[");
	    	if("AAA027".equals(paramMap.get("aaa100").toString().toUpperCase().trim())) {
	    		list = comService.getAAA027(paramMap);
	    		for(Object item : list){
	    			Aa13 aa13 = (Aa13) item;
	    			sb.append("{id: \"" + aa13.getAaa027() + "\", text: \"" + aa13.getAaa129() + "\"},");
	    			
	    		}
	    	}else {
	    		list = comService.getDic(paramMap);
	    		for(Object item : list){
	    			Aa10 aa10 = (Aa10) item;
	    			sb.append("{id: \"" + aa10.getAaa102() + "\", text: \"" + aa10.getAaa103() + "\"},");
	    		}
	    	}
	    	sb.append("] \n");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage(),e);
		}
    	return sb.toString();
    }
}
