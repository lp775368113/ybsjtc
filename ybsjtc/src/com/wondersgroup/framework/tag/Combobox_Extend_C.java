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
 * @Description:  [继承mini-combobox 表单列-字典翻译]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年2月2日 下午2:52:24]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年2月2日 下午2:52:24]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class Combobox_Extend_C  extends TagSupport{
	/**@Fields serialVersionUID: TODO[用一句话描述这个变量表示什么]   */
	private static final long serialVersionUID = 1L;
	
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private JspWriter out;
	private String dic;
	
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
		
//		<input property="editor" class="mini-combobox" style="width: 100%" url="<%=ZD_%>AKA101" />
		
		_Combobox.append("<input ");
		_Combobox.append("property='editor' ");
		_Combobox.append("class='mini-combobox' style='width:100%;' ");
		if(!StringUtil.isNullOrEmpty(this.dic))
			_Combobox.append("url='"+contextPath+"/common/getDic_c.do?aaa100="+this.dic+"' ");
		_Combobox.append(" />");
		try {
			out.print(_Combobox.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.EVAL_PAGE;
	}
	public String getDic() {
		return dic;
	}
	public void setDic(String dic) {
		this.dic = dic;
	}
	
}
