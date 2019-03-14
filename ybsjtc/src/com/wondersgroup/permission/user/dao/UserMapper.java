package com.wondersgroup.permission.user.dao;

import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.permission.user.vo.User;
@MapperScan
public interface UserMapper extends BaseDAO<BaseObject>{
	User   getUserByLoginname(String loginname);

	int signin(Map<String, Object> params);

	/**@Title: 		 getloginname   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @return_type: User      
	 */
	User getUserByloginname(Map<String, Object> params);
}