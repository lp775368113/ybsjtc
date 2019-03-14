package com.wondersgroup.framework.redis;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.JedisPool;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.redis]
 * @ClassName:    [RedisCacheTransfer]   
 * @Description:  [RedisCache的中间类]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月9日 下午10:49:21]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月9日 下午10:49:21]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class RedisCacheTransfer {
	/**@Title: 		 setJedisPool   
	 * @Description: TODO[RedisCache.jedisConnectionFactory的静态注入]   
	 * @param jedisPool      
	 * @return_type: void      
	 */
	@Autowired
	public void setJedisPool(JedisPool jedisPool) {
		RedisCache.setJedisPool(jedisPool);
	}
}
