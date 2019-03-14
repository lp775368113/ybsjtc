package com.wondersgroup.framework.mpage;

import java.lang.reflect.Field;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.fy]
 * @ClassName:    [ReflectHelper]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年1月31日 下午5:01:23]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年1月31日 下午5:01:23]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class ReflectHelper {
	   public static Field getFieldByFieldName(Object obj, String fieldName) {
	        for (Class<?> superClass = obj.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
	            try {
	                return superClass.getDeclaredField(fieldName);
	            } catch (NoSuchFieldException e) {
	            }
	        }
	        return null;
	    }

	    /**
	     * Obj fieldName的获取属性值.
	     * 
	     * @param obj
	     * @param fieldName
	     * @return
	     * @throws SecurityException
	     * @throws NoSuchFieldException
	     * @throws IllegalArgumentException
	     * @throws IllegalAccessException
	     */
	    public static Object getValueByFieldName(Object obj, String fieldName) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
	        Field field = getFieldByFieldName(obj, fieldName);
	        Object value = null;
	        if (field != null) {
	            if (field.isAccessible()) {
	                value = field.get(obj);
	            } else {
	                field.setAccessible(true);
	                value = field.get(obj);
	                field.setAccessible(false);
	            }
	        }
	        return value;
	    }

	    /**
	     * obj fieldName设置的属性值.
	     * 
	     * @param obj
	     * @param fieldName
	     * @param value
	     * @throws SecurityException
	     * @throws NoSuchFieldException
	     * @throws IllegalArgumentException
	     * @throws IllegalAccessException
	     */
	    public static void setValueByFieldName(Object obj, String fieldName, Object value) throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
	        Field field = obj.getClass().getDeclaredField(fieldName);
	        if (field.isAccessible()) {
	            field.set(obj, value);
	        } else {
	            field.setAccessible(true);
	            field.set(obj, value);
	            field.setAccessible(false);
	        }
	    }

}
