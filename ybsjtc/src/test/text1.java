package test;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.wondersgroup.framework.dbutil.centre.centreJdbcUtil;
import com.wondersgroup.framework.util.DESUtil;
import com.wondersgroup.framework.util.EncryptUtil;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [test]
 * @ClassName:    [text1]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2019年3月16日 上午10:59:45]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2019年3月16日 上午10:59:45]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class text1 {

	/**@Title: 		 main   
	 * @Description: TODO[用一句话描述这个方法的作用]   
	 * @param args      
	 * @throws InvalidKeySpecException 
	 * @throws NoSuchPaddingException 
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws SQLException 
	 * @return_type: void      
	 */
	public static void main(String[] args) throws Exception {
//		String des=DESUtil.encrypt(DESUtil.KEY, "1111");
//		String md5 = EncryptUtil.generate(des);  
//		System.out.println(md5);
		String str="精密电阻1%-规格=430R(431)/10W-封装=SMD0603";
		int i;
		if(str.indexOf(" ", 1)==-1) {
			i=str.indexOf("(", 1);
		}else {
			i=str.indexOf(" ", 1);
		}
		String hou=str.substring(str.indexOf("阻")+1, str.indexOf("-",1));
		String qian=str.substring(str.indexOf("=", 1)+1, i);
		String out=qian+"/"+hou;
		System.out.println(out);
	}

}
