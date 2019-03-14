package com.wondersgroup.permission.user.service;

import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.wondersgroup.framework.comwork.service.BaseService;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.permission.user.dao.UserMapper;
import com.wondersgroup.permission.user.vo.User;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [hzxzxt]
 * @Package:      [com.wondersgroup.permission.user.service]
 * @ClassName:    [UserService]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [chenyibing]   	   
 * @CreateDate:   [2018-5-10 下午3:28:09]  
 * @UpdateUser:   [chenyibing]   	   
 * @UpdateDate:   [2018-5-10 下午3:28:09]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
@Service
public class UserService extends BaseService<BaseObject>{
	@Resource(name="userMapper")
	private UserMapper userMapper;
	
	public User  getUserByLoginname(String loginname){
		return userMapper.getUserByLoginname(loginname);
	}

	/**@Title: 		 signin   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @return_type: User      
	 */
	public Integer signin(Map<String, Object> params) {
		int a=userMapper.signin(params);
		return a;
	}

	/**@Title: 		 getloginname   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @return_type: User      
	 */
	public User getloginname(String loginname) {
		// TODO Auto-generated method stub
		return userMapper.getUserByLoginname(loginname);
	}

	
}
