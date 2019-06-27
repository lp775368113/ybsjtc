package com.wondersgroup.framework.dingding.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiCspaceAddRequest;
import com.dingtalk.api.request.OapiFileUploadSingleRequest;
import com.dingtalk.api.request.OapiProcessinstanceCreateRequest;
import com.dingtalk.api.request.OapiProcessinstanceCspaceInfoRequest;
import com.dingtalk.api.response.OapiCspaceAddResponse;
import com.dingtalk.api.response.OapiFileUploadSingleResponse;
import com.dingtalk.api.response.OapiProcessinstanceCreateResponse;
import com.dingtalk.api.response.OapiProcessinstanceCspaceInfoResponse;
import com.taobao.api.ApiException;
import com.taobao.api.FileItem;
import com.taobao.api.internal.util.WebUtils;
import com.wondersgroup.framework.dingding.config.Constant;
import com.wondersgroup.framework.dingding.config.URLConstant;
import com.wondersgroup.materiel.encoding.vo.Data0017;
import com.wondersgroup.materiel.encoding.vo.MaterielCheck;
import com.wondersgroup.permission.user.vo.Dd_User;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.dingding.util]
 * @ClassName:    [DingU]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2019年6月26日 下午9:02:10]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2019年6月26日 下午9:02:10]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class DingU {
	public static Logger logger = Logger.getLogger(CheckMateriel.class);
	
	public static Map<String,String> fileAddUser(Long fileSize,String filePath,String dd_userid){
		try {
		DingTalkClient client = new DefaultDingTalkClient(URLConstant.FILE_ADD_USER);
		OapiCspaceAddRequest request = new OapiCspaceAddRequest();
		request.setAgentId(String.valueOf(Constant.AGENTID));
		request.setCode("test");
		request.setMediaId(uploadFile(fileSize,filePath));
		String spaceId=String.valueOf(getSpaceId(dd_userid));
		request.setSpaceId(spaceId);
		request.setFolderId("0");
		request.setName("ecn.pdf");
		request.setOverwrite(false);
		request.setHttpMethod("GET");
		OapiCspaceAddResponse rsp = client.execute(request,AccessTokenUtil.getToken());
		if (rsp.getErrcode().longValue() != 0) {
			logger.error(rsp.getErrorCode());
			logger.error(rsp.getErrmsg());
			throw new RuntimeException(rsp.getErrmsg());
		}
		Map<String,String> result=new HashMap<String, String>();
		String jsonobj=rsp.getDentry();
		JSONObject json=JSONObject.parseObject(jsonobj);
		result.put("spaceId", spaceId);
		result.put("fileId", json.getString("id"));
		result.put("fileName", json.getString("name"));
		result.put("fileType", json.getString("extension"));
		result.put("fileSize", json.getString("size"));
		return result;
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new RuntimeException("获取上传钉盘的文件信息失败！");
		}
	}
	
	public static Long getSpaceId(String dd_userid){
		try {
		DingTalkClient client = new DefaultDingTalkClient(URLConstant.GET_SPACE_ID);
		OapiProcessinstanceCspaceInfoRequest req = new OapiProcessinstanceCspaceInfoRequest();
		req.setUserId(dd_userid);
		OapiProcessinstanceCspaceInfoResponse rsp = client.execute(req, AccessTokenUtil.getToken());
		if (rsp.getErrcode().longValue() != 0) {
			logger.error(rsp.getErrorCode());
			logger.error(rsp.getErrmsg());
			throw new RuntimeException(rsp.getErrmsg());
		}
		return rsp.getResult().getSpaceId();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new RuntimeException("钉盘控件的上传授权失败！");
		}
	}
	
	
	public static String uploadFile(Long fileSize,String filePath){
		try {
		OapiFileUploadSingleRequest request = new OapiFileUploadSingleRequest();
		request.setFileSize(fileSize);
		request.setAgentId(String.valueOf(Constant.AGENTID));
		DingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/file/upload/single?"+WebUtils.buildQuery(request.getTextParams(),"utf-8"));
		// 必须重新new一个请求
		request = new OapiFileUploadSingleRequest();
		request.setFile(new FileItem(filePath));
		OapiFileUploadSingleResponse rsp = client.execute(request,AccessTokenUtil.getToken());
		if (rsp.getErrcode().longValue() != 0) {
			logger.error(rsp.getErrorCode());
			logger.error(rsp.getErrmsg());
			throw new RuntimeException(rsp.getErrmsg());
		}
		return rsp.getMediaId();
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new RuntimeException("文件上传钉盘失败！");
		}
	}
}
