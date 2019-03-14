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
 * @ClassName:    [Monthpicker_Extend]   
 * @Description:  [继承mini-monthpicker 查询条件-时间选择]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年2月5日 下午10:01:50]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年2月5日 下午10:01:50]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class Monthpicker_Extend   extends TagSupport{

	/**@Fields serialVersionUID: TODO[用一句话描述这个变量表示什么]   */
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private JspWriter out;
	
	private String property;
	private String format;
	private String required;
	private String laber;
	private String value;
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
//		<td class="mini_title">选择时间：</td>
//		<td>
//			<input id="time" name="jyrq" class="mini-monthpicker" format="yyyyMM" required="true" style="width: 250px"/>
//		</td>
		try {
			_Combobox.append("<td class='mini_title'>");
				if("true".equals(this.required)) 
					_Combobox.append("<span style='color:#F00'>*</span>");
				_Combobox.append(this.laber.trim()+"：");
			_Combobox.append("</td>");
			_Combobox.append("<td>");
				_Combobox.append("<input ");
				if(!StringUtil.isNullOrEmpty(this.style)) 
					_Combobox.append("class='mini-monthpicker' style='"+this.style+"' ");
				else
					_Combobox.append("class='mini-monthpicker' style='width:200px;' ");
				_Combobox.append("id='"+this.property+"' ");
				_Combobox.append("name='"+this.property+"' ");
				_Combobox.append("format='"+this.format+"' ");
				if("true".equals(this.required)) 
					_Combobox.append("required='"+this.required+"' ");
				if(!StringUtil.isNullOrEmpty(this.value))
					_Combobox.append("value='"+this.value+"' ");
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
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
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
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
}
