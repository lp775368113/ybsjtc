package com.wondersgroup.framework.util;

import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;
import net.sf.json.JSONObject;

public class JSONUtil {
	public final static ObjectMapper MAPPER = new ObjectMapper().
			configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	
	public static String Encode(Object obj) {
		if(obj == null || obj.toString().equals("null")) return null;
		if(obj != null && obj.getClass() == String.class){
			return obj.toString();
		}
		JSONSerializer serializer = new JSONSerializer();
		serializer.transform(new DateTransformer("yyyy-MM-dd'T'HH:mm:ss"), Date.class);
		serializer.transform(new DateTransformer("yyyy-MM-dd'T'HH:mm:ss"), Timestamp.class);
		return serializer.deepSerialize(obj);
	}
	
	public static Object Decode(String json) {
		if (StringUtil.isNullOrEmpty(json)) return "";
		JSONDeserializer  deserializer = new JSONDeserializer();
//		deserializer.use(String.class, new DateTransformer("yyyy-MM-dd'T'HH:mm:ss"));		
		Object obj = deserializer.deserialize(json);
		if(obj != null && obj.getClass() == String.class){
			return Decode(obj.toString());
		}		
		return obj;
	}
	
	/**
	 * JSON转对象
	 * @param json
	 * @param clazz
	 * @return
	 * @throws Exception
	 */
	public static <T> T fromJson(String json, Class<T> clazz) throws Exception {
		return MAPPER.readValue(json, clazz);  
	}
	
	/**@Title: 		 Ajax   
	 * @Description: TODO[ajax请求反馈json字符串]   
	 * @param obj
	 * @return      
	 * @return_type: String      
	 */
	public static String Ajax(Object obj) {
		return JSONObject.fromObject(obj).toString();
	}
}

