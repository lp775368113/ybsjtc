package com.wondersgroup.framework.dingding.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.wondersgroup.framework.dingding.config.Constant;
import com.wondersgroup.framework.dingding.config.URLConstant;
import com.wondersgroup.materiel.bomsys.ecn.vo.MaterielBomEcn;
import com.wondersgroup.materiel.encoding.vo.Data0017;
import com.wondersgroup.materiel.encoding.vo.MaterielCheck;
import com.wondersgroup.permission.user.vo.Dd_User;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.dingding.util]
 * @ClassName:    [Check]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2019年4月19日 下午3:38:16]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2019年4月19日 下午3:38:16]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class CheckEcn {
	public static Logger logger = Logger.getLogger(CheckEcn.class);
	
	public static void startProcessInstance(MaterielBomEcn params,Dd_User dd_user,String pngname){
		try {
		DefaultDingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_PROCESSINSTANCE_START);
		OapiProcessinstanceCreateRequest request = new OapiProcessinstanceCreateRequest();
		request.setProcessCode(Constant.PROCESS_CODE_ECN);
		
		List<OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValues = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
		OapiProcessinstanceCreateRequest.FormComponentValueVo obj1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		obj1.setName("工程变更编号");
		obj1.setValue(String.valueOf((int)params.getId()));
		formComponentValues.add(obj1);
		
		OapiProcessinstanceCreateRequest.FormComponentValueVo obj2 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		obj2.setName("工程变更主题");
		obj2.setValue(params.getTheme());
		formComponentValues.add(obj2);
		
		OapiProcessinstanceCreateRequest.FormComponentValueVo obj3 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		obj3.setName("要求切入日期");
		obj3.setValue(params.getCutDate());
		formComponentValues.add(obj3);
		
		OapiProcessinstanceCreateRequest.FormComponentValueVo obj4 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		obj4.setName("变更原因");
		obj4.setValue(params.getWhy());
		formComponentValues.add(obj4);
		
		OapiProcessinstanceCreateRequest.FormComponentValueVo obj5 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		obj5.setName("变更内容概述");
		obj5.setValue(params.getSummarize());
		formComponentValues.add(obj5);	
		
		OapiProcessinstanceCreateRequest.FormComponentValueVo obj6 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		obj6.setName("备注");
		obj6.setValue(params.getRemark());
		formComponentValues.add(obj6);		
		
		String path=URLConstant.ECN_PNG+dd_user.getUserid()+"/"+pngname+".png";
		OapiProcessinstanceCreateRequest.FormComponentValueVo vo3 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		vo3.setName("附件");
		vo3.setValue("[\""+path+"\"]");
		formComponentValues.add(vo3);	
		
		request.setFormComponentValues(formComponentValues);
		request.setOriginatorUserId(dd_user.getDd_userid());
		request.setDeptId(Long.valueOf(dd_user.getDepartment()));
		request.setCcPosition("FINISH");
		OapiProcessinstanceCreateResponse response = client.execute(request, AccessTokenUtil.getToken());
		if (response.getErrcode().longValue() != 0) {
			logger.error(response.getErrorCode());
			logger.error(response.getErrmsg());
			throw new RuntimeException(response.getErrmsg());
		}
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new RuntimeException("钉钉发起ECN审批失败！");
		}
	}

}
