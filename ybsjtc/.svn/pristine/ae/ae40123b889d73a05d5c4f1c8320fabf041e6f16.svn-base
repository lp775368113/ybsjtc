package com.wondersgroup.framework.redis;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.redis]
 * @ClassName:    [PropertyConfigurer]   
 * @Description:  [Properties文件解析器]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月9日 下午10:34:40]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月9日 下午10:34:40]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class PropertyConfigurer extends PropertyPlaceholderConfigurer {

	/**@Fields ctxPropertiesMap: TODO[用一句话描述这个变量表示什么]   */
	private static Map<String, Object> ctxPropertiesMap;

	/**Title: processProperties
	 * Description:[用一句话描述这个方法的作用]
	 * @param beanFactoryToProcess
	 * @param props
	 * @throws BeansException   
	 * @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer#processProperties(org.springframework.beans.factory.config.ConfigurableListableBeanFactory, java.util.Properties)   
	 */
	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
			throws BeansException {
		// spring载入配置文件(具体原理还在研究中)
		super.processProperties(beanFactoryToProcess, props);
		ctxPropertiesMap = new HashMap<String, Object>();
		// 便利加载的配置文件的键值，并根据键值获取到value值，然后一同保存进map对象
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			ctxPropertiesMap.put(keyStr, value);
		}
	}

	/**@Title: 		 getContextProperty   
	 * @Description: TODO[按键取值]   
	 * @param name
	 * @return      
	 * @return_type: Object      
	 */
	public static Object getContextProperty(String name) {
		return ctxPropertiesMap.get(name);
	}
}