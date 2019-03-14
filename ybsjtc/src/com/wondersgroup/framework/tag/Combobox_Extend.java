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
 * @ClassName:    [Miniui_Extend]   
 * @Description:  [继承mini-combobox 查询条件-字典下拉]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年2月2日 下午2:52:24]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年2月2日 下午2:52:24]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class Combobox_Extend  extends TagSupport{
	/**@Fields serialVersionUID: TODO[用一句话描述这个变量表示什么]   */
	private static final long serialVersionUID = 1L;
	
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private JspWriter out;
	
	private String property;
	private String allowInput;
	private String value;
	private String laber;
	private String required;
	private String url;
	private String textField;
	private String valueField;
	private String showNullItem;
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
//		<td class="mini_title">统筹区：</td>
//		<td><input id="aaa027" name="aaa027"
//			class="mini-combobox" textField="aaa129" valueField="aaa027" value="<%=loginuser_area_id %>"
//			emptyText="全部"
//			url="${pageContext.request.contextPath}/f30010000/listTcq.do" showNullItem="true" /> 
//		</td>
		_Combobox.append("<td class='mini_title'>");
			if("true".equals(this.required)) 
				_Combobox.append("<span style='color:#F00'>*</span>");
			_Combobox.append(this.laber.trim()+"：");
		_Combobox.append("</td>");
	
		_Combobox.append("<td>");
			_Combobox.append("<input ");
			if(!StringUtil.isNullOrEmpty(this.style)) 
				_Combobox.append("class='mini-combobox' style='"+this.style+"' ");
			else
				_Combobox.append("class='mini-combobox' style='width:200px;' ");
			_Combobox.append("id='"+this.property+"' ");
			_Combobox.append("name='"+this.property+"' ");
			if("true".equals(this.required)) 
				_Combobox.append("required='"+this.required+"' ");
			_Combobox.append("textField='"+this.textField+"' ");
			_Combobox.append("valueField='"+this.valueField+"' ");
			_Combobox.append("url='"+contextPath+this.url+"' ");
			if(!StringUtil.isNullOrEmpty(this.value))
				_Combobox.append("value='"+this.value+"' >");
			if("true".equals(this.showNullItem)) 
				_Combobox.append("showNullItem='"+this.showNullItem+"' ");
			_Combobox.append("emptyText='全部' ");
			
			_Combobox.append("/>");
		_Combobox.append("</td>");
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
	public String getLaber() {
		return laber;
	}
	public void setLaber(String laber) {
		this.laber = laber;
	}
	public String getRequired() {
		return required;
	}
	public void setRequired(String required) {
		this.required = required;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public String getShowNullItem() {
		return showNullItem;
	}
	public void setShowNullItem(String showNullItem) {
		this.showNullItem = showNullItem;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
}
