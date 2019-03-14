package com.wondersgroup.framework.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.wondersgroup.framework.util.JSONUtil;


/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.exception]
 * @ClassName:    [SysHandlerExceptionResolver]   
 * @Description:  [SpringMVC统一异常处理器]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月9日 下午10:23:12]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月9日 下午10:23:12]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class SysHandlerExceptionResolver implements HandlerExceptionResolver {
	public static Logger logger = Logger.getLogger(SysHandlerExceptionResolver.class);
	/**Title: resolveException
	 * Description:[业务实现]
	 * @param request
	 * @param response
	 * @param handler
	 * @param exception
	 * @return   
	 * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)   
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) {
		logger.error("=======================MVC统一异常处理器启动=======================");
		logger.error("概述>"+exception);
		logger.error("详情>");exception.printStackTrace();
		ModelAndView mav = null ;
		String StrClass = exception.getClass().getSimpleName();
		String StrErr	= "";
		String retErr	= "";
		if(exception instanceof BusinessException) 
			StrErr = StringUtils.isNotEmpty(exception.getMessage())?((BusinessException) exception).getMessage():((BusinessException) exception).getKey();
		else
			StrErr = exception.getMessage();
		retErr = "系统报错了-_-!"+'\n'+
				 "详情: "+'\n'+
				 "   异常定位: "+StrClass+'\n'+
				 "   异常描述: "+StrErr;	
		if(!(
				request.getHeader("accept").indexOf("application/json") > -1
				|| (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1)
			)
		   ) {
			retErr = retErr.replaceAll('\n'+"", "<br/>");
			mav = new ModelAndView("/error", "ERRORMSG",retErr);
		}else {
			response.setContentType("application/json;charset=UTF-8");
			PrintWriter writer;
			HashMap<String, Object> ret = new HashMap<>();
			ret.put("code", 500);
			ret.put("msg", retErr);
			
			try {
				PrintWriter out = response.getWriter();
				out.print("<<<"+JSONUtil.Ajax(ret)+">>>");//必须加上自定义标识符，不然json字符串会误导 success
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
		logger.info("=======================MVC统一异常处理器结束=======================");
		return mav;
	}
}
