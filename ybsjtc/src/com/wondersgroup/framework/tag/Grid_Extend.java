package com.wondersgroup.framework.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.alibaba.fastjson.JSONArray;
import com.wondersgroup.framework.util.StringUtil;


/**   ***********************************************
 * Simple to Introduction  
 * @ProjectName:  [ybsjtc]
 * @Package:      [com.wondersgroup.framework.tag]
 * @ClassName:    [Grid_Extend]   
 * @Description:  [一句话描述该类的功能]  
 * @Author:       [Administrator]   	   
 * @CreateDate:   [2018年2月7日 下午11:04:43]  
 * @UpdateUser:   [Administrator]   	   
 * @UpdateDate:   [2018年2月7日 下午11:04:43]  
 * @UpdateRemark: [说明本次修改内容]     
 * @Version:      [v1.0] 		   
 ************************************************** **/
public class Grid_Extend   extends TagSupport{
	/**@Fields serialVersionUID: TODO[用一句话描述这个变量表示什么]   */
	private static final long serialVersionUID = 1L;
	
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	private JspWriter out;
	//<m:grid id="grid1" Edit="false" url="/kb01/listkb01.do" checkcol="true"  showCol="grid1Col"   />

	private String id;
	private String edit;
	private String url;
	private String checkcol;
	private String col;
	private String idField;
	private String style;
	private String data;
	
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
		List<_Grid_Column> list = JSONArray.parseArray(this.col,_Grid_Column.class);
		
		if("true".equals(this.edit)) {
			_Combobox.append("<div id='"+this.id.trim()+"' class='mini-datagrid' idField='"+this.idField.trim()+"' multiSelect='true' ");
			if(!StringUtil.isNullOrEmpty(this.style))
				_Combobox.append("style='"+this.style+"' ");
			else
				_Combobox.append("style='width:100%;height:100%;' ");
			_Combobox.append("allowCellEdit='true' allowCellSelect='true'  editNextOnEnterKey='true'  editNextRowCell='true' ");
			_Combobox.append("sizeList='[20,30,50,100]' pageSize='20' allowResize='true' onload='onload' url='"+contextPath+this.url+"'> ");
			
				_Combobox.append("<div property='columns'> ");
					_Combobox.append("<div type='indexcolumn'>序号</div> ");
					if(!StringUtil.isNullOrEmpty(this.checkcol)) 
						_Combobox.append("<div type='checkcolumn'>选择</div> ");
					for (_Grid_Column _Grid_Column : list) {
						if(!StringUtil.isNullOrEmpty(_Grid_Column.getFmt()) && "DIC".equals(_Grid_Column.getFmt().toUpperCase().trim())) {
							_Combobox.append("<div header='"+_Grid_Column.getName().trim()+"' field='"+_Grid_Column.getValue().trim()+"' type='comboboxcolumn'  headerAlign='center' align='center'>");	
								_Combobox.append("<input property='editor' class='mini-combobox' style='width:100%;' url='"+contextPath+"/common/getDic_c.do?aaa100="+_Grid_Column.getValue().toUpperCase().trim()+"' />");
							_Combobox.append("</div>");
						}else if(!StringUtil.isNullOrEmpty(_Grid_Column.getFmt()) && "MONEY".equals(_Grid_Column.getFmt().toUpperCase().trim())) {
							_Combobox.append("<div header='"+_Grid_Column.getName().trim()+"' field='"+_Grid_Column.getValue().trim()+"' dataType='currency'  headerAlign='center' align='center' >");
								_Combobox.append("<input property='editor' class='mini-textbox' style='width:100%;' minWidth='200' />");
							_Combobox.append("</div>");
						}else if(!StringUtil.isNullOrEmpty(_Grid_Column.getFmt()) && "INT".equals(_Grid_Column.getFmt().toUpperCase().trim())) {
							_Combobox.append("<div header='"+_Grid_Column.getName().trim()+"' field='"+_Grid_Column.getValue().trim()+"' dataType='int'  headerAlign='center' align='center' >");
								_Combobox.append("<input property='editor' class='mini-textbox' style='width:100%;' minWidth='200' />");
							_Combobox.append("</div>");
						}else if(!StringUtil.isNullOrEmpty(_Grid_Column.getFmt()) && "FLOAT".equals(_Grid_Column.getFmt().toUpperCase().trim())) {
							_Combobox.append("<div header='"+_Grid_Column.getName().trim()+"' field='"+_Grid_Column.getValue().trim()+"' dataType='float'  headerAlign='center' align='center' >");
								_Combobox.append("<input property='editor' class='mini-textbox' style='width:100%;' minWidth='200' />");
							_Combobox.append("</div>");
						}else if(!StringUtil.isNullOrEmpty(_Grid_Column.getFmt()) && "DATE".equals(_Grid_Column.getFmt().toUpperCase().trim())) {
							_Combobox.append("<div header='"+_Grid_Column.getName().trim()+"' field='"+_Grid_Column.getValue().trim()+"' dateFormat='yyyy-MM-dd'  headerAlign='center' align='center' >");
								_Combobox.append("<input property='editor' class='mini-datepicker' style='width:100%;' minWidth='200' />");
							_Combobox.append("</div>");
						}else if(!StringUtil.isNullOrEmpty(_Grid_Column.getFmt()) && "CHECK".equals(_Grid_Column.getFmt().toUpperCase().trim())) {
							_Combobox.append("<div header='"+_Grid_Column.getName().trim()+"' field='"+_Grid_Column.getValue().trim()+"' type='checkboxcolumn' trueValue='1' falseValue='0' headerAlign='center' align='center' >");
							_Combobox.append("</div>");
						}else{
							_Combobox.append("<div header='"+_Grid_Column.getName().trim()+"' field='"+_Grid_Column.getValue().trim()+"'  headerAlign='center' align='center' >");
								_Combobox.append("<input property='editor' class='mini-textbox' style='width:100%;' minWidth='200' />");
							_Combobox.append("</div>");
						}
					}
				_Combobox.append("</div> ");
			_Combobox.append("</div> ");			
		}else {
			_Combobox.append("<div id='"+this.id.trim()+"' class='mini-datagrid' idField='"+this.idField.trim()+"' multiSelect='true' ");
			if(!StringUtil.isNullOrEmpty(this.style))
				_Combobox.append("style='"+this.style+"' ");
			else
				_Combobox.append("style='width:100%;height:100%;' ");
			_Combobox.append("sizeList='[20,30,50,100]' pageSize='20' allowResize='true' onload='onload' url='"+contextPath+this.url+"'> ");
				_Combobox.append("<div property='columns'> ");
					_Combobox.append("<div type='indexcolumn'>序号</div> ");
					if(!StringUtil.isNullOrEmpty(this.checkcol)) 
						_Combobox.append("<div type='checkcolumn'>选择</div> ");
					for (_Grid_Column _Grid_Column : list) {
						if(!StringUtil.isNullOrEmpty(_Grid_Column.getFmt()) && "DIC".equals(_Grid_Column.getFmt().toUpperCase().trim())) {
							_Combobox.append("<div header='"+_Grid_Column.getName().trim()+"' field='"+_Grid_Column.getValue().trim()+"' type='comboboxcolumn'  headerAlign='center' align='center'>");	
								_Combobox.append("<input property='editor' class='mini-combobox' style='width:100%;' url='"+contextPath+"/common/getDic_c.do?aaa100="+_Grid_Column.getValue().toUpperCase().trim()+"' />");
							_Combobox.append("</div>");
						}else {
							_Combobox.append("<div header='"+_Grid_Column.getName().trim()+"' field='"+_Grid_Column.getValue().trim()+"'  headerAlign='center' align='center' >");
								_Combobox.append("<input property='editor' class='mini-textbox' style='width:100%;' minWidth='200' />");
							_Combobox.append("</div>");
						}
					}
				_Combobox.append("</div> ");
			_Combobox.append("</div> ");
		}
		
//			<div id="grid1" class="mini-datagrid" idField="id" multiSelect="true" style="width:100%;height:100%;" 
//					sizeList="[20,30,50,100]" 
//					allowCellEdit="true" allowCellSelect="true"  editNextOnEnterKey="true"  editNextRowCell="true"
//					allowResize="true" pageSize="20" onload="onload" url="${pageContext.request.contextPath}/kb01/listkb01.do">
//					<div property="columns">
//						<div type="indexcolumn">序号</div>
//						<div type="checkcolumn">选择</div>
//						<div header="行政区划代码" field="aaa027" type="comboboxcolumn"	headerAlign="center" align="center">
//							<input property="editor" class="mini-combobox" url="${pageContext.request.contextPath}/aa13/getDic.do" />
//						</div>
//						<div header="医疗机构代码" field="akb020"  headerAlign="center" align="center">
//							<input property="editor" class="mini-textbox" style="width:100%;" minWidth="200" />
//						</div>
//						<div header="医疗机构名称" field="akb021" class="mini-textarea"  headerAlign="center" align="center">
//							<input property="editor" class="mini-textarea" style="width:100%;" minWidth="200" />
//						</div>
//						<div header="等级" field="aka101" type="comboboxcolumn"   headerAlign="center" align="center">
//							<input property="editor" class="mini-combobox" style="width: 100%" url="${pageContext.request.contextPath}/common/getDic_c.do?aaa100=AKA101" />
//		                </div>
//					    <div header="性质" field="akb022" type="comboboxcolumn"  headerAlign="center" align="center">
//					    	<m:list_dic_c dic="AKB022" />
//		                </div>
//		                <div header="类别" field="akb023" type="comboboxcolumn"  headerAlign="center" align="center">
//		                   	<m:list_dic_c dic="AKB023" />
//		                </div>
//					</div>
//				</div>

		
		
		try {
			out.print(_Combobox.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.EVAL_PAGE;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEdit() {
		return edit;
	}
	public void setEdit(String edit) {
		this.edit = edit;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCheckcol() {
		return checkcol;
	}
	public void setCheckcol(String checkcol) {
		this.checkcol = checkcol;
	}
	public String getCol() {
		return col;
	}
	public void setCol(String col) {
		this.col = col;
	}
	public String getIdField() {
		return idField;
	}
	public void setIdField(String idField) {
		this.idField = idField;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
}
