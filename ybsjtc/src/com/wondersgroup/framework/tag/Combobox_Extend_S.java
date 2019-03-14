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
 * @ClassName:    [Miniui_Extend]   
 * @Description:  [继承mini-combobox 查询条件-字典下拉]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年2月2日 下午2:52:24]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年2月2日 下午2:52:24]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class Combobox_Extend_S  extends TagSupport{
	/**@Fields serialVersionUID: TODO[用一句话描述这个变量表示什么]   */
	private static final long serialVersionUID = 1L;
	
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private JspWriter out;
	
	private String property;
	private String dic;
	private String allowInput;
	private String value;
	/**@Fields sval: TODO[匹配字典条件] {'1':'2,3,4','2':'1,2,3'}   */
	private String sval;
	private String laber;
	private String required;
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
		String _textField  = null;
		String _valueField = null;
		if(!StringUtil.isNullOrEmpty(this.dic) && "AAA027".equals(this.dic.toString().toUpperCase().trim())) {
			_textField ="aaa129";
			_valueField = "aaa027";
		}else {
			_textField ="aaa103";
			_valueField = "aaa102";
		}
		String contextPath = request.getContextPath();
		StringBuffer _Combobox = new StringBuffer();
		//5个参数的识别
		StringBuffer ReqSval = new StringBuffer();
		if(!StringUtil.isNullOrEmpty(this.sval)) {
			JSONObject  svalJson = JSONObject.fromObject(this.sval);
			if(svalJson.has("1") &&  !StringUtil.isNullOrEmpty(svalJson.get("1")))
				ReqSval.append("&bka142="+svalJson.get("1"));
			if(svalJson.has("2") &&  !StringUtil.isNullOrEmpty(svalJson.get("2")))
				ReqSval.append("&bka143="+svalJson.get("2"));
			if(svalJson.has("3") &&  !StringUtil.isNullOrEmpty(svalJson.get("3")))
				ReqSval.append("&bka144="+svalJson.get("3"));
			if(svalJson.has("4") &&  !StringUtil.isNullOrEmpty(svalJson.get("4")))
				ReqSval.append("&bka145="+svalJson.get("4"));
			if(svalJson.has("5") &&  !StringUtil.isNullOrEmpty(svalJson.get("5")))
				ReqSval.append("&bka146="+svalJson.get("5"));
		}
		//指标有效标志
		StringBuffer IsUser = new StringBuffer();
		IsUser.append("&aae100=1");
		
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
			_Combobox.append("textField='"+_textField+"' ");
			_Combobox.append("valueField='"+_valueField+"' ");
			_Combobox.append("emptyText='全部' ");
			_Combobox.append("url='"+contextPath+"/common/getDic_s.do?aaa100="+this.dic+ReqSval.toString()+IsUser.toString()+"' ");
			System.out.println("url='"+contextPath+"/common/getDic_s.do?aaa100="+this.dic+ReqSval.toString()+IsUser.toString()+"' ");
			if(!StringUtil.isNullOrEmpty(this.allowInput))
				_Combobox.append("allowInput='"+this.allowInput+"' ");
			if(!StringUtil.isNullOrEmpty(this.value))
				_Combobox.append("value='"+this.value+"' ");
			_Combobox.append("showNullItem='false' ");
			_Combobox.append(" />");
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
	public String getDic() {
		return dic;
	}
	public void setDic(String dic) {
		this.dic = dic;
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
	public String getSval() {
		return sval;
	}
	public void setSval(String sval) {
		this.sval = sval;
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
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	
	
	
}
