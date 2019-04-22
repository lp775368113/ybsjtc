package com.wondersgroup.framework.dingding.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.wondersgroup.framework.dingding.config.Constant;
import com.wondersgroup.framework.dingding.config.URLConstant;
import com.wondersgroup.materiel.encoding.vo.Data0017;
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
public class Check {
	public static Logger logger = Logger.getLogger(Check.class);
	
	public static void startProcessInstance(Data0017 params,Dd_User dd_user,String message) throws Exception {
		
		DefaultDingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_PROCESSINSTANCE_START);
		OapiProcessinstanceCreateRequest request = new OapiProcessinstanceCreateRequest();
		request.setProcessCode(Constant.PROCESS_CODE);
		
		List<OapiProcessinstanceCreateRequest.FormComponentValueVo> formComponentValues = new ArrayList<OapiProcessinstanceCreateRequest.FormComponentValueVo>();
		OapiProcessinstanceCreateRequest.FormComponentValueVo obj1 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		obj1.setName("物料唯一识别码");
		obj1.setValue(String.valueOf((int)params.getId()));
		formComponentValues.add(obj1);
		
		OapiProcessinstanceCreateRequest.FormComponentValueVo obj2 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		obj2.setName("禾川编码");
		obj2.setValue(params.getExtraDesc());
		formComponentValues.add(obj2);
		
		OapiProcessinstanceCreateRequest.FormComponentValueVo obj3 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		obj3.setName("物料名称描述");
		obj3.setValue(params.getInvPartDescriptionC());
		formComponentValues.add(obj3);
		
		OapiProcessinstanceCreateRequest.FormComponentValueVo obj4 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		obj4.setName("厂商料号");
		obj4.setValue(params.getCustPartCode());
		formComponentValues.add(obj4);
		
		OapiProcessinstanceCreateRequest.FormComponentValueVo obj5 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		obj5.setName("合算单价");
		obj5.setValue(params.getStdCost());
		formComponentValues.add(obj5);	
		
		OapiProcessinstanceCreateRequest.FormComponentValueVo obj6 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		obj6.setName("包装数量");
		obj6.setValue(params.getStockPurch());
		formComponentValues.add(obj6);		
		
		
		OapiProcessinstanceCreateRequest.FormComponentValueVo obj7 = new OapiProcessinstanceCreateRequest.FormComponentValueVo();
		obj7.setName("申请原因");
		obj7.setValue(message);
		formComponentValues.add(obj7);
		request.setFormComponentValues(formComponentValues);
		request.setOriginatorUserId(dd_user.getDd_userid());
		request.setDeptId(Long.valueOf(dd_user.getDepartment()));
		request.setCcPosition("FINISH");
		OapiProcessinstanceCreateResponse response = client.execute(request, AccessTokenUtil.getToken());
		if (response.getErrcode().longValue() != 0) {
			logger.error(response.getErrorCode());
			logger.error(response.getErrmsg());
			throw new Exception(response.getErrmsg());
		}
	}

}
