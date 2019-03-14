package com.wondersgroup.framework.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.listener]
 * @ClassName:    [RedisListener]   
 * @Description:  [Servlet 容器监听]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月9日 下午10:31:22]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月9日 下午10:31:22]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class RedisListener implements ServletContextListener {
	/**@Fields logger: TODO[用一句话描述这个变量表示什么]   */
	private static final Logger logger = LoggerFactory.getLogger(RedisListener.class);

	/**Title: contextDestroyed
	 * Description:[容器注销执行操作]
	 * @param arg0   
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)   
	 */
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	/**Title: contextInitialized
	 * Description:[容器启动执行操作]
	 * @param arg0   
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)   
	 */
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		logger.debug("应用监听器初始化工作开始-redis_MENU...>>>>>>>>>>>>>>>>>>>>>>");
		try {
//			RedisService redisService = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext())
//					.getBean(RedisService.class);
//			redisService.queryMenu();
//			redisService.queryRight();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("应用监听器初始化工作完成-redis_MENU...>>>>>>>>>>>>>>>>>>>>>>");
	}

}
