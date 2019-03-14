package com.wondersgroup.framework.redis;

import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wondersgroup.framework.util.StringUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.redis]
 * @ClassName:    [RedisCache]   
 * @Description:  [二级缓存的Redis实现]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月9日 下午10:37:37]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月9日 下午10:37:37]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class RedisCache implements Cache {
	/**@Fields logger: TODO[用一句话描述这个变量表示什么]   */
	private static final Logger logger = LoggerFactory.getLogger(RedisCache.class);

	/**@Fields readWriteLock: TODO[读写锁定义]   */
	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	/**@Fields jedisPool: TODO[redis连接池]   */
	@Autowired
	public static JedisPool jedisPool;

	/**@Fields DB_INDEX: TODO[实例编码]   */
	private int DB_INDEX = 0;
	
	/**@Fields COMMON_CACHE_KEY: TODO[reids键值目录]   */
	private final String COMMON_CACHE_KEY = "COM:";
	
	/**@Fields UTF_8: TODO[字符集编码]   */
	private static final String UTF_8 = "utf-8";

	/**@Title: 		 getKey   
	 * @Description: TODO[按照一定规则标识key]   
	 * @param key
	 * @return      
	 * @return_type: String      
	 */
	private String getKey(Object key) {
		StringBuilder accum = new StringBuilder();
		accum.append(COMMON_CACHE_KEY);
		accum.append(this.id).append(":");
		accum.append(DigestUtils.md5Hex(String.valueOf(key)));
		return accum.toString();
	}

	/**@Title: 		 getKeys   
	 * @Description: TODO[redis key规则前缀]   
	 * @return      
	 * @return_type: String      
	 */
	private String getKeys() {
		return COMMON_CACHE_KEY + this.id + ":*";
	}

	/**@Fields id: TODO[入参ID]   */
	private String id;

	/**@Title:  	RedisCache   
	 * @Description:TODO[RedisCache 构造器]     
	 */
	public RedisCache() {
	}

	/**@Title:  	RedisCache   
	 * @Description:TODO[RedisCache 构造器]   
	 * @param id  
	 */
	public RedisCache(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("必须传入ID");
		}
		logger.debug("MybatisRedisCache:id=" + id);
		this.id = id;
		this.DB_INDEX = getDB_INDEX();
	}

	/**Title: getId
	 * Description:[用一句话描述这个方法的作用]
	 * @return   
	 * @see org.apache.ibatis.cache.Cache#getId()   
	 */
	@Override
	public String getId() {
		return this.id;
	}

	/**Title: getSize
	 * Description:[获取当前namespace的总缓存数]
	 * @return   
	 * @see org.apache.ibatis.cache.Cache#getSize()   
	 */
	@Override
	public int getSize() {
		Jedis jedis = null;
		int result = 0;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = jedisPool.getResource();
			jedis.select(DB_INDEX);
			Set<byte[]> keys = jedis.keys(getKeys().getBytes(UTF_8));
			if (null != keys && !keys.isEmpty()) {
				result = keys.size();
			}
			logger.debug(this.id + "---->>>>总缓存数:" + result);
		} catch (Exception e) {
			borrowOrOprSuccess = false;
			if (jedis != null)
				jedis.close();
		} finally {
			if (borrowOrOprSuccess)
				jedis.close();
		}
		return result;

	}

	/**Title: putObject
	 * Description:[存入键值对信息]
	 * @param key
	 * @param value   
	 * @see org.apache.ibatis.cache.Cache#putObject(java.lang.Object, java.lang.Object)   
	 */
	@Override
	public void putObject(Object key, Object value) {
		Jedis jedis = null;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = jedisPool.getResource();
			jedis.select(DB_INDEX);
			byte[] keys = getKey(key).getBytes(UTF_8);
			jedis.set(keys, SerializeUtil.serialize(value));
			logger.debug("添加缓存--------" + this.id);
			// getSize();
		} catch (Exception e) {
			borrowOrOprSuccess = false;
			if (jedis != null)
				jedis.close();
		} finally {
			if (borrowOrOprSuccess)
				jedis.close();
		}

	}

	/**Title: getObject
	 * Description:[取出键值对信息]
	 * @param key
	 * @return   
	 * @see org.apache.ibatis.cache.Cache#getObject(java.lang.Object)   
	 */
	@Override
	public Object getObject(Object key) {
		Jedis jedis = null;
		Object value = null;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = jedisPool.getResource();
			jedis.select(DB_INDEX);
			value = SerializeUtil.unserialize(jedis.get(getKey(key).getBytes(UTF_8)));
			logger.debug("从缓存中获取-----" + this.id);
		} catch (Exception e) {
			borrowOrOprSuccess = false;
			if (jedis != null)
				jedis.close();
		} finally {
			if (borrowOrOprSuccess)
				jedis.close();
		}
		return value;
	}

	/**Title: removeObject
	 * Description:[删除键值对信息]
	 * @param key
	 * @return   
	 * @see org.apache.ibatis.cache.Cache#removeObject(java.lang.Object)   
	 */
	@Override
	public Object removeObject(Object key) {
		Jedis jedis = null;
		Object value = null;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = jedisPool.getResource();
			jedis.select(DB_INDEX);
			value = jedis.del(getKey(key).getBytes(UTF_8));
			logger.debug("LRU算法从缓存中移除-----" + this.id);
			// getSize();
		} catch (Exception e) {
			borrowOrOprSuccess = false;
			if (jedis != null)
				jedis.close();
		} finally {
			if (borrowOrOprSuccess)
				jedis.close();
		}
		return value;
	}

	/**Title: clear
	 * Description:[清空当前namespace的所有键值对]   
	 * @see org.apache.ibatis.cache.Cache#clear()   
	 */
	@Override
	public void clear() {
		Jedis jedis = null;
		boolean borrowOrOprSuccess = true;
		try {
			jedis = jedisPool.getResource();
			jedis.select(DB_INDEX);
			Set<byte[]> keys = jedis.keys(getKeys().getBytes(UTF_8));
			logger.debug("出现CUD操作，清空对应Mapper缓存======>" + keys.size());
			for (byte[] key : keys) {
				jedis.del(key);
			}
		} catch (Exception e) {
			borrowOrOprSuccess = false;
			if (jedis != null)
				jedis.close();
		} finally {
			if (borrowOrOprSuccess)
				jedis.close();
		}
	}

	/**Title: getReadWriteLock
	 * Description:[获取读写锁]
	 * @return   
	 * @see org.apache.ibatis.cache.Cache#getReadWriteLock()   
	 */
	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	/**@Title: 		 setJedisPool   
	 * @Description: TODO[实例化二级缓存池]   
	 * @param jedisPool      
	 * @return_type: void      
	 */
	public static void setJedisPool(JedisPool jedisPool) {
		RedisCache.jedisPool = jedisPool;
	}

	/**@Title: 		 getDB_INDEX   
	 * @Description: TODO[调用Properties文件解析器获取实例编码]   
	 * @return      
	 * @return_type: int      
	 */
	public int getDB_INDEX() {
		return StringUtil.isNullOrEmpty(PropertyConfigurer.getContextProperty(this.id)) ? 0
				: Integer.valueOf(PropertyConfigurer.getContextProperty(this.id).toString());
	}
}
