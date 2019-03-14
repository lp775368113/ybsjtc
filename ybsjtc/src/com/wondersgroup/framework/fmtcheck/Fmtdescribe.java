package com.wondersgroup.framework.fmtcheck;

import java.lang.annotation.*;

/**
 * 数据格式校验清单
 * 
 * @author dld
 * @version 1.0
 * @time 20160518
 */
@Retention(RetentionPolicy.RUNTIME)
@Target( { ElementType.FIELD, ElementType.PARAMETER })
public @interface Fmtdescribe {

	/* 基础限定描述 */
	boolean nullable() default false; // 是否可以为空

	int maxLength() default 0; // 最大长度

	int minLength() default 0; // 最小长度

	int fdLength() default 0;  // 数据格式化定长 当组装报文的时候，补全限定的长度 
	/* 正则表达式匹配 */
	RegexType regexType() default RegexType.FTM_NONE; // 提供几种常用的正则验证

	String regexExpression() default ""; // 自定义正则验证

	String description() default ""; // 参数或者字段描述,这样能够显示友好的异常信息

	public enum RegexType {
		FTM_DATE8, 				//时间 YYYYMMDD
		FTM_DATE14, 			//时间YYYYMMDDH24MISS
		FTM_NONE,				//初始化数据格式
		FTM_UPCase,				//校验大写
		FTM_LOWCase,			//校验小写
		FTM_SFZ,				//身份证
		
		FTM_YWBH, 				//业务编号
		FTM_TCQ;				//统筹区
	}
}
