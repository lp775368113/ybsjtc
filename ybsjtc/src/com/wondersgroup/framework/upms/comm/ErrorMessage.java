package com.wondersgroup.framework.upms.comm;

public class ErrorMessage {
	public final static String ERR_UNAUTH_ACCESS = "非法操作";
	public final static String ERR_SYS_EXCEPTION = "系统错误";//1005
	public final static String ERR_UNLEGAL_PARAM = "传入参数不符合规则";//1001
	public final static String ERR_UNLEGAL_BUSI_PARAM = "传入业务参数不符合规则";//1004
	public final static String ERR_AUTH = "接口解密失败";//1002
	
	public final static String UNAVD_SERVICE="服务不可用";
	public final static String ACCOUT_UNEXSIST="账号不存在";//1006
	public final static String LOGIN_PWD_ERROR="帐号或者密码错误";//1007
	public final static String LOGIN_UNAUTH="未授权登录";//1008
	public final static String ACCOUT_ERR_OPWD="该帐号原密码错误";//1009
	
	public final static String LOGIN_UNEMPTY = "账号或者密码不能为空";
	public final static String LOGIN_ERROR = "登陆失败";
	public final static String SYS_UNAUTH = "系统未授权";//1003
}
