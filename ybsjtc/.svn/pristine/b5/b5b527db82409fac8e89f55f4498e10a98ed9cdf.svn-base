package com.wondersgroup.framework.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.wondersgroup.framework.util.StringUtil;

import net.sf.json.JSONObject;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.tag]
 * @ClassName:    [Buttonedit_Extend]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年2月6日 下午3:15:43]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年2月6日 下午3:15:43]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class Buttonedit_Extend  extends TagSupport{
	/**@Fields serialVersionUID: TODO[用一句话描述这个变量表示什么]   */
	private static final long serialVersionUID = 1L;
	
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private JspWriter out;
	
	private String laber;
	private String property;
	private String allowInput;
	private String value;
	private String onbuttonclick;
	private String textField;
	private String valueField;
	private String required;
	private String style;
	
	@Override
	public int doStartTag() throws JspException {
		request = (HttpServletRequest) pageContext.getRequest();
		response = (HttpServletResponse) pageContext.getResponse();
		out = pageContext.getOut();
		String contextPath = request.getContextPath();
		StringBuffer _Combobox = new StringBuffer();
		
		_Combobox.append("<td class='mini_title'>");
			if("true".equals(this.required)) 
				_Combobox.append("<span style='color:#F00'>*</span>");
			_Combobox.append(this.laber.trim()+"：");
		_Combobox.append("</td>");
	
		_Combobox.append("<td>");
			_Combobox.append("<input ");
			if(!StringUtil.isNullOrEmpty(this.style)) 
				_Combobox.append("class='mini-buttonedit' style='"+this.style+"' ");
			else
				_Combobox.append("class='mini-buttonedit' style='width:200px;' ");
			_Combobox.append("id='"+this.property+"' ");
			_Combobox.append("name='"+this.property+"' ");
			if("true".equals(this.required)) 
				_Combobox.append("required='"+this.required+"' ");
			_Combobox.append("textField='"+this.textField+"' ");
			_Combobox.append("valueField='"+this.valueField+"' ");
			if(!StringUtil.isNullOrEmpty(this.allowInput))
				_Combobox.append("allowInput='"+this.allowInput+"' ");
			if(!StringUtil.isNullOrEmpty(this.value))
				_Combobox.append("value='"+this.value+"' ");
			_Combobox.append("onbuttonclick='"+this.onbuttonclick+"' ");
			_Combobox.append(" />");		
		try {
			out.print(_Combobox.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.EVAL_BODY_INCLUDE;
	}
	@Override
	public int doEndTag() throws JspException {
//		<td id="yljg" class="mini_title"><span style="color: red">*</span>医院名称：</td>
//		<td id="yljg1" >
//			<input id="akb020" name="akb020" class="mini-buttonedit" allowInput="false" onbuttonclick="onButtonEdit" textName="akb021" required="true" style="width: 250px"/>
//			<m:hidden property="akb020_H" />
//			<m:hidden property="akb021_H" />
//		</td>
		String contextPath = request.getContextPath();
		StringBuffer _Combobox = new StringBuffer();
		_Combobox.append("</td>");
		try {
			out.print(_Combobox.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.EVAL_PAGE;
	}
	public String getLaber() {
		return laber;
	}
	public void setLaber(String laber) {
		this.laber = laber;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public String getAllowInput() {
		return allowInput;
	}
	public void setAllowInput(String allowInput) {
		this.allowInput = allowInput;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getOnbuttonclick() {
		return onbuttonclick;
	}
	public void setOnbuttonclick(String onbuttonclick) {
		this.onbuttonclick = onbuttonclick;
	}
	public String getTextField() {
		return textField;
	}
	public void setTextField(String textField) {
		this.textField = textField;
	}
	public String getValueField() {
		return valueField;
	}
	public void setValueField(String valueField) {
		this.valueField = valueField;
	}
	public String getRequired() {
		return required;
	}
	public void setRequired(String required) {
		this.required = required;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
}
