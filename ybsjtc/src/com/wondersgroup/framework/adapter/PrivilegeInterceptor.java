package com.wondersgroup.framework.adapter;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wondersgroup.framework.comwork.controller.SessionConstants;
import com.wondersgroup.framework.exception.BusinessException;
import com.wondersgroup.framework.redis.PropertyConfigurer;
import com.wondersgroup.framework.redis.RedisCache;
import com.wondersgroup.framework.redis.SerializeUtil;
import com.wondersgroup.framework.upms.vo.UasUserVO;
import com.wondersgroup.permission.user.vo.User;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.adapter]
 * @ClassName:    [PrivilegeInterceptor]   
 * @Description:  [拦截器-后台权限登录拦截]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月9日 下午9:58:13]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月9日 下午9:58:13]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class PrivilegeInterceptor extends HandlerInterceptorAdapter {
	protected Logger logger = LoggerFactory.getLogger(PrivilegeInterceptor.class);

	/**@Fields whiteList: TODO[白名单hash集合]   */
	public static Set<String> whiteList = new HashSet<String>();

	public void setWhiteList(Set<String> whiteList) {
		this.whiteList = whiteList;
	}

	static {
		whiteList.add("/login/doLogin.do");// 登录请求
		whiteList.add("/login/doLoginout.do");// 退出登录界面
		whiteList.add("/user/signin.do");//注册界面
		whiteList.add("/user/getloginname.do");//注册界面
	}

	// 方法前 /buyer/
	/**Title: preHandle
	 * Description:[自定义拦截器业务实现]
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception   
	 * @see org.springframework.web.servlet.handler.HandlerInterceptorAdapter#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)   
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String redis_singlelogin = (String) PropertyConfigurer.getContextProperty("redis.singlelogin");
		int redis_slpage = Integer.valueOf((String) PropertyConfigurer.getContextProperty("redis.slpage")) ;
		int redis_sltimeout = Integer.valueOf((String) PropertyConfigurer.getContextProperty("redis.sltimeout"));
		
		HttpSession session = request.getSession();
		User userinfo = null;
		String requestURI = request.getServletPath();
		System.out.println("--request.getContextPath(): " + request.getContextPath());
		System.out.println("--requestURI: " + requestURI.replace(request.getContextPath(), ""));
		System.out.println("--whiteList: " + whiteList);
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/login.jsp";
		if (whiteList != null && whiteList.contains(requestURI.replace(path, ""))) {// 白名单 放行
			return true;
		}
		userinfo = (User) session.getAttribute(SessionConstants.CW_LOGINUSER);
		if (userinfo != null)
			return true;
		// 必须登陆
		boolean isAjaxRequest = true;
		// 判断是不是ajax请求
		String header = request.getHeader("X-Requested-With");// XMLHttpRequest
		if (header == null || !header.equalsIgnoreCase("XMLHttpRequest")) {
			isAjaxRequest = false;
		}
		if (isAjaxRequest) {
			System.out.println("--isAjaxRequest:" + isAjaxRequest);
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("登录已过期，请重新登录！");
			out.flush();
		} else {
			PrintWriter out = response.getWriter();
			out.print("<script>alert('登录已过期，请重新登录！');window.top.location.href='" + basePath + "';</script>");
			out.flush();
		}
		return false;

	}

	// 方法后
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	// 页面渲染后
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
