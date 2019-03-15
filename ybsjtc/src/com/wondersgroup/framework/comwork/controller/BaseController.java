package com.wondersgroup.framework.comwork.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.wondersgroup.framework.upms.vo.UasUserVO;
import com.wondersgroup.permission.user.vo.User;

/**
 * *********************************************** 
 * Simple to Introduction
 * @ProjectName: [ybsjtc]
 * @Package: [com.wondersgroup.framework.action]
 * @ClassName: [BaseAction]
 * @Description: [Base Action Class, 业务系统的Action需要继承BaseAction]
 * @Author: [Administrator]
 * @CreateDate: [2018年1月9日 上午12:19:21]
 * @UpdateUser: [Administrator]
 * @UpdateDate: [2018年1月9日 上午12:19:21]
 * @UpdateRemark: [说明本次修改内容]
 * @Version: [v1.0]
 **/
public class BaseController {
	/** @Fields logger: TODO[用一句话描述这个变量表示什么] */
	protected Logger logger = Logger.getLogger(getClass());
	/** @Fields request: TODO[用一句话描述这个变量表示什么] */
	@Autowired
	private HttpServletRequest request;

	/**
	 * @Title: getLoginUser
	 * @Description: TODO[获取用户登录信息]
	 * @param request
	 * @return
	 * @return_type: UasUserVO
	 */
	public User getLoginUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
	}

	/**
	 * @Title: getLoginUser
	 * @Description: TODO[获取用户登录信息]
	 * @return
	 * @return_type: UasUserVO
	 */
	public User getLoginUser() {
		return (User) request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
	}
}
