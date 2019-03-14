package com.wondersgroup.framework.fmtcheck;

import java.lang.reflect.Field;
import org.apache.commons.lang.StringUtils;

import com.wondersgroup.framework.fmtcheck.Fmtdescribe.RegexType;
/**
 * 
 * Simple to Introduction
 * 
 * @ProjectName: ws_webservice
 * @Package: com.wondersgroup.framework.fmtcheck
 * @ClassName: validateService
 * @Description: 校验数据格式
 * @Author: dld
 * @Version: 1.0
 * 
 */
public class ValidateService {
	private static Fmtdescribe fmt;

	public ValidateService() {
		super();
	}

	/**
	 * Simple to Introduction
	 * @throws Exception 
	 * @ProjectName: ws_webservice
	 * @Package: com.wondersgroup.framework.fmtcheck
	 * @Description: 校验数据格式
	 * @Author: dld
	 * @Version: 1.0
	 */	
	public static void valid(Object object) throws Exception  {
		// 获取object的类型
		Class<? extends Object> clazz = object.getClass();
		// 获取该类型声明的成员
		Field[] fields = clazz.getDeclaredFields();
		// 遍历属性
		for (Field field : fields) {
			// 对于private私有化的成员变量，通过setAccessible来修改器访问权限
			field.setAccessible(true);
			validate(field, object);
			// 重新设置会私有权限
			field.setAccessible(false);
		}
	}
	/**
	 * Simple to Introduction
	 * @throws Exception 
	 * @ProjectName: ws_webservice
	 * @Package: com.wondersgroup.framework.fmtcheck
	 * @Description: 按照字段的注解检验字段内容
	 * @Author: dld
	 * @Version: 1.0
	 */	
	public static void validate(Field field, Object object) throws Exception{
		String description;
		Object value;
		// 获取对象的成员的注解信息
		fmt = field.getAnnotation(Fmtdescribe.class);
		try{
			value = field.get(object);
		}catch(Exception e){
			throw new Exception("Fmt0001<系统异常>:获取对象值异常");
		}
		if (fmt == null)
			return;
		description = fmt.description().equals("") ? field.getName() : fmt
				.description();
		/************* 注解解析工作开始 ******************/
		if (!fmt.nullable()) {
			if (value == null || StringUtils.isBlank(value.toString())) {
				throw new Exception("Fmt0002<"+description+">:不能为空");
			}
		}
		if (value.toString().length() > fmt.maxLength() && fmt.maxLength() != 0) {
			throw new Exception("Fmt0003<"+description+">:长度不能超过"+fmt.maxLength());
		}
		if (value.toString().length() < fmt.minLength() && fmt.minLength() != 0) {
			throw new Exception("Fmt0004<"+description+">:长度不能小于"+fmt.minLength());
		}
		if (fmt.regexType() != RegexType.FTM_NONE) {
			switch (fmt.regexType()) {
			case FTM_NONE:
				break;
			case FTM_YWBH:
				if (!Fmtrealization.check_FTM_YWBH(value.toString())) {
					throw new Exception("Fmt0005<"+description+">:接口编号不存在");
				}else{
					if(!Fmtrealization.check_FTM_UPCase(value.toString())){
						throw new Exception("Fmt0006<"+description+">:接口编号存在小写字符");
					}
				}
				break;
			case FTM_DATE8:
				if(!Fmtrealization.check_FTM_DATE8(value.toString())){
					throw new Exception("Fmt0007<"+description+">:8位年月日时间不合法");
				}
				break;
			case FTM_DATE14:
				if(!Fmtrealization.check_FTM_DATE14(value.toString())){
					throw new Exception("Fmt0008<"+description+">:14位年月日时分秒时间不合法");
				}
				break;	
			case FTM_SFZ:
				if(!Fmtrealization.check_FTM_SFZLen(value.toString())){
					throw new Exception("Fmt0009<"+description+">:身份证长度不合法");
				}
				break;					
			default:
				break;
			}
		}
		if (!fmt.regexExpression().equals("")) {
			if (value.toString().matches(fmt.regexExpression())) {
				throw new Exception("Fmt0010<"+description+">:自定义数据格式不合法");
			}
		}
		/************* 注解解析工作结束 ******************/
	}
}
