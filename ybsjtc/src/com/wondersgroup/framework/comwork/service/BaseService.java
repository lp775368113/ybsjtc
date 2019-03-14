package com.wondersgroup.framework.comwork.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wondersgroup.framework.comwork.controller.SessionConstants;
import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.upms.vo.UasUserVO;


/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.application.service]
 * @ClassName:    [BaseService]   
 * @Description:  [通用Service类]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月9日 下午2:19:13]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月9日 下午2:19:13]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
@Service
public   class BaseService<M>  {
	@Autowired  
	private HttpSession session;
	@Autowired
	private HttpServletRequest request;
	
	/**@Fields logger: TODO[用一句话描述这个变量表示什么]   */
	protected Logger logger = Logger.getLogger(getClass());
	 
	/**@Fields dao: TODO[用一句话描述这个变量表示什么]   */
	protected BaseDAO<M> dao ;
	    
	/**@Title: 		 setDao   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param dao      
	 * @return_type: void      
	 */
	public void setDao(BaseDAO<M> dao) {
		this.dao = dao;
	}


	/**
	 * @Title: getLoginUser
	 * @Description: TODO[获取用户登录信息]
	 * @return
	 * @return_type: UasUserVO
	 */
	public UasUserVO getLoginUser() {
		return (UasUserVO) session.getAttribute(SessionConstants.CW_LOGINUSER);
	}
	
	
	/**@Title: 		 getSequence   
	 * @Description: TODO[通用seq获取]   
	 * @param sequence_name
	 * @param length
	 * @param pattern
	 * @param date
	 * @return      
	 * @return_type: String      
	 */
	public String getSequence(String sequence_name, int length, String  pattern ,boolean date){
		Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("sequence_name", sequence_name);
   	    paramMap.put("length", length);
   	    paramMap.put("pattern", pattern);
   	    paramMap.put("date",  date);
   	    return dao.getSequence(paramMap);
	}
	
	
	
	/**@Title: 		 getPage   
	 * @Description: TODO[获取分页信息]   
	 * @param map
	 * @return      
	 * @return_type: Map<String,Object>      
	 */
	public Map<String, Object> getPage(Map<String, Object>  map){
	    Map<String, Object> result = new HashMap<String, Object>();
        int pageIndex = Integer.parseInt( map.get("pageIndex").toString());
        int pageSize = Integer.parseInt(map.get("pageSize").toString());
        int start = pageIndex * pageSize, end = start + pageSize;
        map.put("start", start + 1);
        map.put("end", end);
        List<M> list = dao.getPage(map);
        int count = dao.getPageCount(map);
        result.put("total", count);
		result.put("data", list);
	    return result;
	}
}
