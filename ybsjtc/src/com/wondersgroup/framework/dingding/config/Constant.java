package com.wondersgroup.framework.dingding.config;

/**
 * 项目中的常量定义类
 */
public class Constant {
    /**
     * 开发者后台->企业自建应用->选择您创建的E应用->查看->AppKey
     */
    public static final String APP_KEY = "dingxvrhhs8ivu62hqu1";
    /**
     * 开发者后台->企业自建应用->选择您创建的E应用->查看->AppSecret
     */
    public static final String APP_SECRET="tWDJyS2SaOnpJIJK2MW6aJx2CS15wWJSE1kWFMYvsejMyNlGFjYYW_HMI4Ir6rtD";
    
    /**
     * 企业corpid, 需要修改成开发者所在企业
     */
    public static final String CORP_ID = "ding0e20c95cc213dca335c2f4657eb6378f";
    /**
     * 应用的AppKey，登录开发者后台，点击应用管理，进入应用详情可见
     */
    public static final String APPKEY = "dingxvrhhs8ivu62hqu1";
    /**
     * 应用的AppSecret，登录开发者后台，点击应用管理，进入应用详情可见
     */
    public static final String APPSECRET = "tWDJyS2SaOnpJIJK2MW6aJx2CS15wWJSE1kWFMYvsejMyNlGFjYYW_HMI4Ir6rtD";

    /**
     * 数据加密密钥。用于回调数据的加密，长度固定为43个字符，从a-z, A-Z, 0-9共62个字符中选取,您可以随机生成
     */
    public static final String ENCODING_AES_KEY = "AAAAAAAAAABBBBBBBBBBCCCCCCCCCCDDDDDDDDDD123";

    /**
     * 加解密需要用到的token，企业可以随机填写。如 "12345"
     */
    public static final String TOKEN = "12345";

    /**
     * 应用的agentdId，登录开发者后台可查看
     */
    public static final Long AGENTID = 245227362L;

    /**
     * 审批模板唯一标识，可以在审批管理后台找到
     */
    public static final String PROCESS_CODE = "PROC-D2BB2099-F117-4B81-AEF1-A9ABD1FFEE21";

    /**
     * 回调host
     */
    public static final String CALLBACK_URL_HOST = "http://115.238.111.190:8087";
}
