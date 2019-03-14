package com.wondersgroup.framework.filter;

import java.io.IOException;
import java.util.Date;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.filter]
 * @ClassName:    [SystemFilter]   
 * @Description:  [自定义系统过滤器]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月9日 下午10:24:55]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月9日 下午10:24:55]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class SystemFilter implements Filter {

	/**@Fields logger: TODO[用一句话描述这个变量表示什么]   */
	public static Logger logger = Logger.getLogger(SystemFilter.class);
	
	/**@Fields filterConfig: TODO[用一句话描述这个变量表示什么]   */
	private FilterConfig filterConfig = null;

	/**@Title: 		 getApplicationContext   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @return      
	 * @return_type: ApplicationContext      
	 */
	public ApplicationContext getApplicationContext() {
		return WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
	}
	
	/**Title: destroy
	 * Description:[过滤器结束操作]   
	 * @see javax.servlet.Filter#destroy()   
	 */
	public void destroy() {
	}

	/**Title: doFilter
	 * Description:[过滤器业务实现]
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws IOException
	 * @throws ServletException   
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)   
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		long begin = System.currentTimeMillis();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		try {
			HttpSession session = req.getSession();
			req.setCharacterEncoding("utf-8");
			res.setContentType("text/html;charset=UTF-8");
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			//在同意异常处理器中,已经进行了堆栈日志打印，此处不需要在进行日志信息输出了
			//logger.error(e.getMessage(), e);
		}	
		long end = System.currentTimeMillis();
		System.out.println(req.getRequestURL() + " 耗时" + (end - begin) + "毫秒 " + new Date().toLocaleString());
	}

	/**Title: init
	 * Description:[过滤器初始化]
	 * @param filterConfig
	 * @throws ServletException   
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)   
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	/**@Title: 		 setFilterConfig   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param filterConfig      
	 * @return_type: void      
	 */
	public void setFilterConfig(FilterConfig filterConfig) {
		this.filterConfig = filterConfig;
	}

}
