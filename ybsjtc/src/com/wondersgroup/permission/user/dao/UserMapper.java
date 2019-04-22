package com.wondersgroup.permission.user.dao;

import java.util.Map;

import org.mybatis.spring.annotation.MapperScan;
import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.permission.user.vo.Dd_User;
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

	/**@Title: 		 updatepwd   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param paramMap      
	 * @return_type: void      
	 */
	void updatepwd(Map<String, Object> paramMap);

	/**@Title: 		 getDd_users   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param string
	 * @return      
	 * @return_type: Dd_User      
	 */
	Dd_User getDd_users(String string);

}