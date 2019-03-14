package com.wondersgroup.framework.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.wondersgroup.framework.util.StringUtil;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.tag]
 * @ClassName:    [Textbox_Extend]   
 * @Description:  [继承mini-textbox 查询条件-文本输入]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年2月5日 下午10:22:51]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年2月5日 下午10:22:51]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class Textbox_Extend    extends TagSupport{

	/**@Fields serialVersionUID: TODO[用一句话描述这个变量表示什么]   */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private JspWriter out;
	
	private String property;
	private String value;
	private String required;
	private String laber;
	private String style;
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
//		<td class="mini_title">参数代码类别：</td>
//		<td ><input id="aaa001" name="aaa001" class="mini-textbox" style="width: 100px" />
//	    </td>
		try {
			_Combobox.append("<td class='mini_title'>");
				if("true".equals(this.required)) 
					_Combobox.append("<span style='color:#F00'>*</span>");
				_Combobox.append(this.laber.trim()+"：");
			_Combobox.append("</td>");
			_Combobox.append("<td>");
				_Combobox.append("<input ");
				if(!StringUtil.isNullOrEmpty(this.style)) 
					_Combobox.append("class='mini-textbox' style='"+this.style+"' ");
				else
					_Combobox.append("class='mini-textbox' style='width:200px;' ");
				_Combobox.append("id='"+this.property+"' ");
				_Combobox.append("name='"+this.property+"' ");
				if(!StringUtil.isNullOrEmpty(this.value))
					_Combobox.append("value='"+this.value+"' ");
				if("true".equals(this.required)) 
					_Combobox.append("required='"+this.required+"' ");
				_Combobox.append(" />");
			_Combobox.append("</td>");
			
			
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getRequired() {
		return required;
	}
	public void setRequired(String required) {
		this.required = required;
	}
	public String getLaber() {
		return laber;
	}
	public void setLaber(String laber) {
		this.laber = laber;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
}
