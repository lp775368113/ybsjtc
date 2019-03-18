package com.wondersgroup.permission.user.service;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.stereotype.Service;

import com.wondersgroup.framework.comwork.dao.BaseDAO;
import com.wondersgroup.framework.comwork.service.BaseService;
import com.wondersgroup.framework.comwork.vo.BaseObject;
import com.wondersgroup.framework.util.DESUtil;
import com.wondersgroup.framework.util.EncryptUtil;
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
	
	
	@Resource(name="userMapper")
	public void setDao(BaseDAO<BaseObject> dao) {
		super.setDao(dao);
	}
	
	public User  getUserByLoginname(String loginname){
		return userMapper.getUserByLoginname(loginname);
	}

	/**@Title: 		 signin   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchPaddingException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @return_type: User      
	 */
	public Integer signin(Map<String, Object> params) throws InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeySpecException {
		String pwd=(String)params.get("password");
		String des=DESUtil.encrypt(DESUtil.KEY, pwd);
		String md5 = EncryptUtil.generate(des);  
		params.put("password", md5);
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

	/**@Title: 		 modUserPassword   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param paramMap      
	 * @return_type: void      
	 */
	public void modUserPassword(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		userMapper.updatepwd(paramMap);
	}

	/**@Title: 		 resetpwd   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param params
	 * @return      
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchPaddingException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @return_type: String      
	 */
	public String resetpwd(Map<String, Object> params) throws InvalidKeyException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeySpecException {
		String pwd=getPassword();
		String des=DESUtil.encrypt(DESUtil.KEY, pwd);
		String md5 = EncryptUtil.generate(des);  
		params.put("password", md5);
		userMapper.updatepwd(params);
		return pwd;
	}
	
	public  String getPassword() {
		Random rd = new Random(); // 创建随机对象
		String n = ""; // 保存随机数
		int rdGet; // 取得随机数
		do {
			if (rd.nextInt() % 2 == 1) {
				rdGet = Math.abs(rd.nextInt()) % 10 + 48; // 产生48到57的随机数(0-9的键位值)
			} else {
				rdGet = Math.abs(rd.nextInt()) % 26 + 97; // 产生97到122的随机数(a-z的键位值)
			}
			char num1 = (char) rdGet; // int转换char
			String dd = Character.toString(num1);
			n += dd;
		} while (n.length() < 6);// 设定长度，此处假定长度小于8
		return n;
	}

	
}
