package com.wondersgroup.framework.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtil {

    public static Map convertBeanToMap(Object obj) {
        Map<String, Object> reMap = new HashMap<String, Object>();

        if (obj == null) {
            return null;
        }

        try {

            // 获取父类属性
            Field[] fields = obj.getClass().getSuperclass().getDeclaredFields();
            if (fields == null || fields.length == 0) {
                return reMap;
            }

            for (Field field : fields) {
                // System.out.println("--- :"+field.getName());

                // 重置属性可见(而且一般属性都是私有的)，否则操作无效
                boolean accessible = field.isAccessible();
                if (!accessible) {
                    field.setAccessible(true);
                }

                // 获取属性名称及值存入Map
                String key = field.getName();
                reMap.put(key, field.get(obj));
                // System.out.println("---o :"+field.get(obj));
                // 还原属性标识
                field.setAccessible(accessible);

            }

            fields = obj.getClass().getDeclaredFields();

            for (int i = 0; i < fields.length; i++) {

                Field f = obj.getClass().getDeclaredField(fields[i].getName());
                // System.out.println("--- :"+f.getName());
                f.setAccessible(true);
                Object o = f.get(obj);
                // System.out.println("---o :"+o);
                reMap.put(f.getName(), o);

            }

        } catch (SecurityException e) {

            e.printStackTrace();
        } catch (NoSuchFieldException e) {

            e.printStackTrace();
        } catch (IllegalArgumentException e) {

            e.printStackTrace();
        } catch (IllegalAccessException e) {

            e.printStackTrace();
        }

        return reMap;
    }

    // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
    public static Map convertBeanToMap2(Object obj) {

        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();

                // 过滤class属性
                if (!key.equals("class")) {
                    // 得到property对应的getter方法
                    Method getter = property.getReadMethod();
                    Object value = getter.invoke(obj);

                    map.put(key, value);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;

    }

}
