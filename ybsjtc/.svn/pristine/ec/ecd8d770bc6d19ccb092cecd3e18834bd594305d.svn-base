package com.wondersgroup.framework.redis;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.ibatis.cache.CacheException;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.redis]
 * @ClassName:    [SerializeUtil]   
 * @Description:  [redis作为二级缓存的序列化工具]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月9日 下午10:51:09]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月9日 下午10:51:09]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public final class SerializeUtil {

	/**@Title: 		 serialize   
	 * @Description: TODO[对象的序列化操作]   
	 * @param object
	 * @return      
	 * @return_type: byte[]      
	 */
	public static byte[] serialize(Object object) {
		ObjectOutputStream oos = null;
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			oos.writeObject(object);
			final byte[] bytes = baos.toByteArray();
			return bytes;
		} catch (final Exception e) {
			throw new CacheException(e);
		}
	}

	/**@Title: 		 unserialize   
	 * @Description: TODO[反序列化操作]   
	 * @param bytes
	 * @return      
	 * @return_type: Object      
	 */
	public static Object unserialize(byte[] bytes) {
		if (bytes == null) {
			return null;
		}
		ByteArrayInputStream bais = null;
		try {
			bais = new ByteArrayInputStream(bytes);
			final ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (final Exception e) {
			throw new CacheException(e);
		}
	}

}
