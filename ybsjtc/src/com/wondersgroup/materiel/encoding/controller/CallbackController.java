package com.wondersgroup.materiel.encoding.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wondersgroup.framework.dingding.config.Constant;
import com.wondersgroup.framework.dingding.config.MessageUtil;
import com.wondersgroup.framework.dingding.config.URLConstant;
import com.wondersgroup.framework.dingding.util.AccessTokenUtil;
import com.wondersgroup.materiel.encoding.service.EncodingService;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiCallBackDeleteCallBackRequest;
import com.dingtalk.api.request.OapiCallBackRegisterCallBackRequest;
import com.dingtalk.api.request.OapiUserGetRequest;
import com.dingtalk.api.response.OapiCallBackRegisterCallBackResponse;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.dingtalk.oapi.lib.aes.DingTalkEncryptor;
import com.dingtalk.oapi.lib.aes.Utils;
import com.taobao.api.ApiException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.Map;
/**
 * E应用回调信息处理
 */
@RestController
public class CallbackController {
	
	@Autowired
	private  EncodingService encodingService;
	
    private static final Logger bizLogger = LoggerFactory.getLogger("BIZ_CALLBACKCONTROLLER");
    private static final Logger mainLogger = LoggerFactory.getLogger(CallbackController.class);

    /**
     * 创建套件后，验证回调URL创建有效事件（第一次保存回调URL之前）
     */
    private static final String CHECK_URL = "check_url";

    /**
     * 审批任务回调
     */
    private static final String BPMS_TASK_CHANGE = "bpms_task_change";

    /**
     * 审批实例回调
     */
    private static final String BPMS_INSTANCE_CHANGE = "bpms_instance_change";

    /**
     * 相应钉钉回调时的值
     */
    private static final String CALLBACK_RESPONSE_SUCCESS = "success";


    @RequestMapping(value = "/callback", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> callback(@RequestParam(value = "signature", required = false) String signature,
                                        @RequestParam(value = "timestamp", required = false) String timestamp,
                                        @RequestParam(value = "nonce", required = false) String nonce,
                                        @RequestBody(required = false) JSONObject json) {
        String params = " signature:"+signature + " timestamp:"+timestamp +" nonce:"+nonce+" json:"+json;
        try {
            DingTalkEncryptor dingTalkEncryptor = new DingTalkEncryptor(Constant.TOKEN, Constant.ENCODING_AES_KEY,
                Constant.CORP_ID);

            //从post请求的body中获取回调信息的加密数据进行解密处理
            String encryptMsg = json.getString("encrypt");
            String plainText = dingTalkEncryptor.getDecryptMsg(signature, timestamp, nonce, encryptMsg);
            JSONObject obj = JSON.parseObject(plainText);
            //根据回调数据类型做不同的业务处理
            String eventType = obj.getString("EventType");
            String processCode=obj.getString("processCode");
            if (BPMS_TASK_CHANGE.equals(eventType)) {
                //bizLogger.info("收到审批任务进度更新: " + plainText);
                //todo: 实现审批的业务逻辑，如发消息
            } else if (BPMS_INSTANCE_CHANGE.equals(eventType)) {
               // bizLogger.info("收到审批实例状态更新: " + plainText);
                //todo: 实现审批的业务逻辑，如发消息
                String processInstanceId = obj.getString("processInstanceId");
                //区域权限申请回调
                if (obj.containsKey("result") && obj.getString("result").equals("agree")&&"PROC-FFYJ66TV-XQZ3EWD526QFE96HMKEN3-MI1XMNTJ-N1".equals(processCode)) {
                    Map<String,String> a=MessageUtil.getProcessinstanceById(processInstanceId);
//                    String userid=a.get("userid");
//                    String accessToken = AccessTokenUtil.getToken();
//                    OapiUserGetResponse userProfile = getUserProfile(accessToken, userid);
//            		String userName = userProfile.getName();
//            		String title=a.get("title");
//            		title=title.substring(title.length()-6,title.length());
//            		if("查看区域权限".equals(title)) {
//                		List<Dd_Info_Dic> quyulist=voMapper.getQuyu(a.get("区域权限"));//用户提交的区域权限数据
//                		List<Dd_User_Quyu_Per> oldPermission=voMapper.getAllPermission(userid);
//                		for(Dd_User_Quyu_Per old:oldPermission) {
//                			old.setRemoved("1");
//                		}
//                		for(Dd_Info_Dic newPer:quyulist) {
//                			Boolean flag=false;
//                			for(Dd_User_Quyu_Per old:oldPermission) {
//                				if((newPer.getCode()).equals(old.getPermission())) {
//                					flag=true;
//                					old.setRemoved("0");
//                				}
//                			}
//                			if(!flag) {
//                				Dd_User_Quyu_Per p=new Dd_User_Quyu_Per();
//                				p.setType("1");
//                				p.setUserid(userid);
//                				p.setRemoved("0");
//                				p.setPermission(newPer.getCode());
//                				//新增权限
//                				voMapper.addDd_User_Quyu_Per(p);
//                			}
//                		}
//                		for(Dd_User_Quyu_Per old:oldPermission) {
//                			voMapper.updateDd_User_Quyu_Per(old);
//            			}
//                		mainLogger.info("区域权限授权成功！");
//                		Dd_Operation op=Dd_Operation.getInstance(userid, 17, "授权区域："+a.get("区域权限"), "true", "");
//            			voMapper.addOperation(op);//添加登录日志到数据库
//                		 MessageUtil.sendMessageToOriginator(processInstanceId);//发送通知
//            		}
//            		//物料审批回调 同意
                }else if(obj.containsKey("result") && obj.getString("result").equals("agree")&&"PROC-D2BB2099-F117-4B81-AEF1-A9ABD1FFEE21".equals(processCode)) {
                	Map<String,String> a=MessageUtil.getProcessinstanceById(processInstanceId);
                	String id=a.get("物料唯一识别码");
                	int num=encodingService.agree(id);
                	if(num==0) {
                		mainLogger.error("更新的数据不存在！");
                	}
                	//物料审批回调 不同意
                }else if(obj.containsKey("result") && obj.getString("result").equals("refuse")&&"PROC-D2BB2099-F117-4B81-AEF1-A9ABD1FFEE21".equals(processCode)) {
                	Map<String,String> a=MessageUtil.getProcessinstanceById(processInstanceId);
                	String id=a.get("物料唯一识别码");
                	int num=encodingService.refuse(id);
                	if(num==0) {
                		mainLogger.error("更新的数据不存在！");
                	}
                	}
//                }
            } else{
            	
            }
            // 返回success的加密信息表示回调处理成功
            return dingTalkEncryptor.getEncryptedMap(CALLBACK_RESPONSE_SUCCESS, System.currentTimeMillis(), Utils.getRandomStr(8));
        } catch (Exception e) {
            //失败的情况，应用的开发者应该通过告警感知，并干预修复
            mainLogger.error("process callback failed！"+params,e);
            return null;
        }
    }

    public static void main(String[] args) throws Exception{
        // 先删除企业已有的回调
        DingTalkClient client = new DefaultDingTalkClient(URLConstant.DELETE_CALLBACK);
        OapiCallBackDeleteCallBackRequest request = new OapiCallBackDeleteCallBackRequest();
        request.setHttpMethod("GET");
        client.execute(request, AccessTokenUtil.getToken());

        // 重新为企业注册回调
        client = new DefaultDingTalkClient(URLConstant.REGISTER_CALLBACK);
        OapiCallBackRegisterCallBackRequest registerRequest = new OapiCallBackRegisterCallBackRequest();
        registerRequest.setUrl(Constant.CALLBACK_URL_HOST + "/callback");
        registerRequest.setAesKey(Constant.ENCODING_AES_KEY);
        registerRequest.setToken(Constant.TOKEN);
        registerRequest.setCallBackTag(Arrays.asList("bpms_instance_change", "bpms_task_change"));
        OapiCallBackRegisterCallBackResponse registerResponse = client.execute(registerRequest,AccessTokenUtil.getToken());
        if (registerResponse.isSuccess()) {
            System.out.println("回调注册成功了！！！");
        }
    }
    
    
    /**
	 * 获取用户详情
	 *
	 * @param accessToken
	 * @param userId
	 * @return
	 */
	private OapiUserGetResponse getUserProfile(String accessToken, String userId) {
		try {
			DingTalkClient client = new DefaultDingTalkClient(URLConstant.URL_USER_GET);
			OapiUserGetRequest request = new OapiUserGetRequest();
			request.setUserid(userId);
			request.setHttpMethod("GET");
			OapiUserGetResponse response = client.execute(request, accessToken);

			return response;
		} catch (ApiException e) {
			e.printStackTrace();
			return null;
		}
	}
}
