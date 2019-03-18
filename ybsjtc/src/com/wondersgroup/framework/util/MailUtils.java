package com.wondersgroup.framework.util;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.util]
 * @ClassName:    [MailUtils]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2019年3月16日 下午5:14:13]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2019年3月16日 下午5:14:13]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import com.wondersgroup.framework.exception.SendEmailException;


/**
 * 注意：必须要用mail.jar与 activation.jar包，使用javaee.jar包报错
 * @author liupeng
 *邮件发送工具类
 */

public class MailUtils {
	public static void main(String[] args) throws Exception {
		sendEmail("775368113@qq.com", "1111");
	}
	public static boolean sendEmail(String mailto,String password) throws SendEmailException{
		//1.创建连接对象
		Properties props=new Properties();
		Session session=Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("775368113@qq.com", "520LXCpeng%");
			}
		});
		
		//2创建邮件对象
		Message message=new MimeMessage(session);
		try {
			//设置发送人
			message.setFrom(new InternetAddress("liupeng@hcfa.cn"));
			//设置收件人
			message.setRecipient(RecipientType.TO, new InternetAddress(mailto));
			//设置邮件主题
			message.setSubject("密码重置");
			//设置邮件内容
			message.setContent("禾川科技提醒您，您的密码已被重置，新密码为："+password+",请妥善保管。", "text/html;charset=utf-8");
			//3发送邮件
			Transport.send(message);
		} catch (Exception e) {
			e.printStackTrace();
			throw new SendEmailException(e.getMessage());
		}
		return true;
	}
}

