package com.wondersgroup.framework.aop;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.wondersgroup.framework.comwork.controller.SessionConstants;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.framework.upms.vo.UasUserVO;
import com.wondersgroup.framework.util.BeanUtil;
import com.wondersgroup.permission.user.vo.User;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.log]
 * @ClassName:    [OperateLog]   
 * @Description:  [操作记录公共类]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月9日 下午10:32:21]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月9日 下午10:32:21]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
@SuppressWarnings("unchecked")
public class OperateLog {

	/**@Fields request: TODO[用一句话描述这个变量表示什么]   */
	@Autowired
	private HttpServletRequest request;

	/**@Fields sqlSessionTemplate: TODO[用一句话描述这个变量表示什么]   */
	@Resource
	private SqlSessionTemplate sqlSessionTemplate = null;

	/**@Fields jt: TODO[用一句话描述这个变量表示什么]   */
	@Resource(name = "basicJdbcDAO")
	private JdbcTemplate jt = null;

	/**@Title: 		 doLog   
	 * @Description: TODO[日志入库操作]   
	 * @param joinPoint      
	 * @return_type: void      
	 */
	public void doLog(JoinPoint joinPoint) {
		String className = joinPoint.getTarget().getClass().getName();
		String method = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		String sql = "";
		if (args != null && args.length > 0) {
			if (args[0] instanceof String) {
			} else if (args[0] instanceof HashMap) {
				Map map = (Map) args[0];
				if (BaseObject.WRITE_LOG_YES.equals(map.get("iswritelog"))) {
					User loginUser = (User) request.getSession()
							.getAttribute(SessionConstants.CW_LOGINUSER);
					System.out.println("map----------------------------" + map.get("logywlsh"));
					map.put("classname", className);
					map.put("methodname", method);
					map.put("czjg", "1");
					map.put("login_userid", loginUser.getLoginname());
					map.put("login_realname", loginUser.getVsername());
					sqlSessionTemplate.insert("com.wondersgroup.framework.comwork.dao.BaseDAO.saveOperateLog", map);
				}
			} else if (args[0] instanceof BaseObject) {
				BaseObject bo = (BaseObject) args[0];
				Map map = BeanUtil.convertBeanToMap(bo);
				if (BaseObject.WRITE_LOG_YES.equals(map.get("iswritelog"))) {
					User loginUser = (User) request.getSession()
							.getAttribute(SessionConstants.CW_LOGINUSER);
					map.put("login_userid", loginUser.getLoginname());
					map.put("login_realname", loginUser.getVsername());
					map.put("classname", className);
					map.put("methodname", method);
					map.put("czjg", "1");
					map.put("logywlsh", bo.getLogywlsh());
					sqlSessionTemplate.insert("com.wondersgroup.framework.comwork.dao.BaseDAO.saveOperateLog", map);
				}
			}
		}
	}
}
