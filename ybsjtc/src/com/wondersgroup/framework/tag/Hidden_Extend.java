package com.wondersgroup.framework.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.tag]
 * @ClassName:    [Hidden_Extend]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年2月6日 下午3:05:17]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年2月6日 下午3:05:17]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class Hidden_Extend   extends TagSupport{
	/**@Fields serialVersionUID: TODO[用一句话描述这个变量表示什么]   */
	private static final long serialVersionUID = 1L;
	
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private JspWriter out;
	private String property;
	
	@Override
	public int doStartTag() throws JspException {
		request = (HttpServletRequest) pageContext.getRequest();
		response = (HttpServletResponse) pageContext.getResponse();
		out = pageContext.getOut();
		return this.EVAL_BODY_INCLUDE;
	}
	@Override
	public int doEndTag() throws JspException {
		String contextPath = request.getContextPath();
		StringBuffer _Combobox = new StringBuffer();
		
//		<input id="akb020_H" name="akb020_H" class="mini-hidden" /> 
		
		_Combobox.append("<input ");
		_Combobox.append("id='"+this.property+"' ");
		_Combobox.append("name='"+this.property+"' ");
		_Combobox.append("class='mini-hidden'");
		_Combobox.append(" />");
		try {
			out.print(_Combobox.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.EVAL_PAGE;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	
}
