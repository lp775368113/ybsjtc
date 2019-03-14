package com.wondersgroup.framework.fmtcheck;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

/**
 * 进行数据校验规则的详细实现
 * 
 * @author dld
 * @version 1.0
 * @time 20160518
 */
public class Fmtrealization {
	/**
	 * Simple to Introduction
	 * @ProjectName: ws_webservice
	 * @Package: com.wondersgroup.framework.fmtcheck
	 * @Description: 检验业务编码
	 * @Author: dld
	 * @Version: 1.0
	 */
	public static boolean check_FTM_YWBH(String val) {
		if(Pattern.matches("([a-zA-Z]{2})([0-9]{4})", val))
			return true;
		return false;
	}
	
	/**
	 * Simple to Introduction
	 * @ProjectName: ws_webservice
	 * @Package: com.wondersgroup.framework.fmtcheck
	 * @Description: 检验字符大写
	 * @Author: dld
	 * @Version: 1.0
	 */
	public static boolean check_FTM_UPCase(String val){
		if(val.toUpperCase().equals(val))
			return true;
		return false;
	}
	
	/**
	 * Simple to Introduction
	 * @ProjectName: ws_webservice
	 * @Package: com.wondersgroup.framework.fmtcheck
	 * @Description: 检验字符小写
	 * @Author: dld
	 * @Version: 1.0
	 */	
	public static boolean check_FTM_LOWCase(String val){
		if(val.toLowerCase().equals(val))
			return true;
		return false;
	}
	/**
	 * Simple to Introduction
	 * @ProjectName: ws_webservice
	 * @Package: com.wondersgroup.framework.fmtcheck
	 * @Description: 检验8位时间格式
	 * @Author: dld
	 * @Version: 1.0
	 */	
	public static boolean check_FTM_DATE8(String val) {
		try{
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			df.setLenient(false);
			df.parse(val);
		}catch(ParseException e){
			return false;
		}
		return true;
	}	
	/**
	 * Simple to Introduction
	 * @ProjectName: ws_webservice
	 * @Package: com.wondersgroup.framework.fmtcheck
	 * @Description: 检验14位时间格式
	 * @Author: dld
	 * @Version: 1.0
	 */	
	public static boolean check_FTM_DATE14(String val) {
		try{
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
			df.setLenient(false);
			df.parse(val);
		}catch(ParseException e){
			return false;
		}
		return true;
	}
	
	public static boolean check_FTM_SFZLen(String val){
		if(val.length() != 15 && val.length() != 18)
			return false;
		return true;
	}
}
