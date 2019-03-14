package com.wondersgroup.framework.tag;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.wondersgroup.framework.exception.BusinessException;
import com.wondersgroup.framework.util.StringUtil;

import net.sf.json.JSONObject;

/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.tag]
 * @ClassName:    [Autocomplete_Extend]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年2月5日 下午11:28:46]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年2月5日 下午11:28:46]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class Autocomplete_Extend   extends TagSupport{
	/**@Fields serialVersionUID: TODO[用一句话描述这个变量表示什么]   */
	private static final long serialVersionUID = 1L;
	
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private JspWriter out;
	
	private String property;
	private String value;
	private String laber;
	private String required;
	private String url;
	private String textField;
	private String valueField;
	private String show;
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
//		<td class="mini_title">智能补全：</td>
//		<td>
//		   <div class="mini-autocomplete" style="width:250px;"  popupWidth="400" textField="aaa103" valueField="aaa102" 
//				url="${pageContext.request.contextPath}/aa10/listautoaa10.do" >     
//		        <div property="columns">
//		            <div header="编码" field="aaa100" width="30"></div>
//		            <div header="键值" field="aaa102" ></div>
//		            <div header="名称" field="aaa103"></div>
//		        </div>
//		    </div>
//		</td>
		StringBuffer ReqSval = new StringBuffer();
		if(!StringUtil.isNullOrEmpty(this.show)) {
			JSONObject  svalJson = JSONObject.fromObject(this.show);
			Iterator iterator = svalJson.keys();
			String key = null;
			String value = null;
			while(iterator.hasNext()){
	        	key = (String) iterator.next();
	        	if(StringUtil.isNullOrEmpty(key))
	        		throw new BusinessException("1", "list_auto标签展示列显示名称不能为空");
	        	value = svalJson.getString(key);
	        	if(StringUtil.isNullOrEmpty(value))
	        		throw new BusinessException("1", "list_auto标签展示列字段名称不能为空");
	        	ReqSval.append("<div header='"+key+"' field='"+value+"'></div>");
			}
		}
		
		_Combobox.append("<td class='mini_title'>");
			if("true".equals(this.required)) 
				_Combobox.append("<span style='color:#F00'>*</span>");
			_Combobox.append(this.laber.trim()+"：");
		_Combobox.append("</td>");
	
		_Combobox.append("<td>");
			_Combobox.append("<div ");
			if(!StringUtil.isNullOrEmpty(this.style)) 
				_Combobox.append("class='mini-autocomplete' style='"+this.style+"' popupWidth='400' ");
			else
				_Combobox.append("class='mini-autocomplete' style='width:200px;' popupWidth='400' ");
			_Combobox.append("id='"+this.property+"' ");
			_Combobox.append("name='"+this.property+"' ");
			if("true".equals(this.required)) 
				_Combobox.append("required='"+this.required+"' ");
			_Combobox.append("textField='"+this.textField+"' ");
			_Combobox.append("valueField='"+this.valueField+"' ");
			_Combobox.append("url='"+contextPath+this.url+"' ");
			if(!StringUtil.isNullOrEmpty(this.value))
				_Combobox.append("value='"+this.value+"' ");
			_Combobox.append("> ");
			
				if(!StringUtil.isNullOrEmpty(ReqSval.toString())) {
					_Combobox.append("<div property='columns'> ");
						_Combobox.append(ReqSval);
					_Combobox.append("</div> ");
				}
			_Combobox.append("</div> ");
		_Combobox.append("</td> ");
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
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
}
