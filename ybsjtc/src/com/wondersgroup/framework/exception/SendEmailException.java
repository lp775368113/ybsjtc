package com.wondersgroup.framework.exception;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.exception]
 * @ClassName:    [SendEmailException]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2019年3月16日 下午5:24:40]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2019年3月16日 下午5:24:40]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class SendEmailException extends RuntimeException {
	public SendEmailException(String message) {
		super(message);
	}
	public SendEmailException() {
		super();
	}
}
