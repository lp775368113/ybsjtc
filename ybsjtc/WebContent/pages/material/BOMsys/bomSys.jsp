<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>工伤认定查询导出</title>

<style type="text/css">
html, body {
    font-size: 13px;
    padding: 0;
    margin: 0;
    border: 0;
    height: 100%;
    overflow: hidden;
}
.mini-panel-header{
    background-color:#E0EEEE;
}
.mini-panel-body{
padding:0px;
}
#form1 table tr {
	height:28px;
}
</style>


</head>
<body>
<div class="mini-fit">
    <div class="mini-panel" title="查询" showCollapseButton="false"
        style="width: 98%; height: auto;" >
        <form id="form1" name="form1" style="" action="#" method="post">
            <table width="99%" border="0" cellpadding="0" cellspacing="0px" style="padding-top:8px;">
    <tr height="28px">
      <td class="mini_title" align="right">业务编号：</td>
      <td>
      	<input class="mini-hidden" name="pageindex" id="pageindex"/> 
		<input class="mini-hidden" name="pagesize" id="pagesize"/> 
		<input class="mini-hidden" name="contentvalue" id="contentvalue"/>
		<input class="mini-hidden" name="sele" id="sele"/>
      	<input class="mini-textbox"  id="qrecordid" name="qrecordid" style="width:100px"/>		
      </td>
      <td class="mini_title" align="right">编号：</td>
      <td>
      	<input class="mini-textbox"  id="qdocumentyear" name="qdocumentyear" style="width:100px" />&nbsp年
      	<input class="mini-textbox"  id="qdocumentno1" name="qdocumentno1" style="width:100px" />
      	- <input class="mini-textbox"  id="qdocumentno2" name="qdocumentno2" style="width:100px" />
      </td>
      <td class="mini_title" align="right">业务状态：</td>
      <td>
      	<input id="qstatusid" name="qstatusid" style="width:100px" class="mini-combobox" style="width:100%" showNullItem="true"  textField="name" valueField="code"
				url="<%-- ${pageContext.request.contextPath}/common/listDic.do?type_code=GSRDSTATUS --%>" />
      </td>
    </tr>
    <tr height="28px">
      <td class="mini_title" align="right">姓名：</td>
      <td>
      	<input class="mini-textbox"  id="qname" name="qname" style="width:100px"/>
      </td>
      <td class="mini_title" align="right">审核时间：</td>
      <td>
      	<input class="mini-datepicker"  id="qoptime1" name="qoptime1" style="width:170px"/>一<input class="mini-datepicker"  id="qoptime2" name="qoptime2" style="width:170px"/>
      </td>
      <td class="mini_title" align="right">身份证号码：</td>
      <td>
      	<input class="mini-textbox"  id="qidcard" name="qidcard" style="width:100px"/>
      </td>
    </tr>
    <tr height="28px">
      <td class="mini_title" align="right">认定结果：</td>
      <td>
      	<input id="qresult" name="qresult" class="mini-combobox" style="width:100px;" showNullItem="true"  textField="name" valueField="code"
				url="<%-- ${pageContext.request.contextPath}/common/listDic.do?type_code=RDJG --%>" />
      </td>
      <td class="mini_title" align="right">单位名称：</td>
      <td>
      	<input class="mini-textbox"  id="qcompany" name="qcompany" style="width:354px"/>
      </td>
      <td colspan="2" align="right" valign="right">
            <div style="width: 150px;padding-right:12px;" class="operate">
				<button type="button" class="cx_color" onclick="search()">
					<span class=""></span>查询
				</button>
				<button type="button" class="cz_color" onclick="resetForm()">
					<span class=""></span>重置
				</button>
			</div>
	  </td>
    </tr>
  </table>
</form>
</div>



        <!-- center begin -->
		<div class="mini-panel" title="查询结果" showCollapseButton="false"
			style="width: 98%; height: auto;" >
       

			<div id="grid1" class="mini-datagrid" idField="id" multiSelect="true"
				style="width: 100%; height: auto;" allowResize="false" pageSize="10"
				 showReloadButton="flase" showPageSize="false"  multiSelect="false"
				onload="onload" url="${pageContext.request.contextPath}/gsrd/gsrdQuery.do"
				
				>
				<div property="columns">
					<div type="checkcolumn" ></div>
					<div field="recordid" width="10%" headerAlign="center" align="center">业务编号</div>
					<div field="documentno"  width="12%"   headerAlign="center" align="center" renderer="viewRDBH">认定书编号</div>
                    <div field="statusname" width="10%" headerAlign="center" align="center">业务状态</div>
				    <div field="name"  width="10%"   headerAlign="center" align="center">姓名 </div>
                   	<div field="idcard" width="15%" headerAlign="center" align="center">身份证号</div>
					<div field="result" width="10%" headerAlign="center" align="center" renderer="viewRDJG">认定结果</div>
					<div field="optime" width="33%" headerAlign="center" align="center" renderer="ondayRenderer">审核时间</div>	
				</div>
			</div>
			<!-- center end -->
		</div>
	<div id="hid1" style="display:block" >
	<table width="100%" border="0" cellpadding="0" cellspacing="0" >
		<tr align="center">
			<td>&nbsp;</td>
		</tr>
		<tr align="center">
			<td>导出内容：
				<input type="radio" name="exportcontent" id="exportcontent" value="all" checked/>导出全部
				<input type="radio" name="exportcontent" id="exportcontent" value="current"/>导出本页
				<input type="radio" name="exportcontent" id="exportcontent" value="selected" />导出选中项
			</td>
		</tr>
		<tr align="center">
			<td>&nbsp;</td>
		</tr>
		<tr align="center">
			<td>
			<div style="width: 200px" class="operate">
				<button type="button" class="cz_color" onclick="toexport()">
					<span class=""></span>导出
				</button>
				</div>
			</td>
		</tr>
	</table>
</div> 	
</div>
   

</body>
</html>
<script type="text/javascript">
        mini.parse();
        var form = new mini.Form("form1");
        var grid = mini.get("grid1");
        //grid.load();
        function search(){
			 form.validate();
			if (form.isValid() == false) {
				return;
			} 
			var data = form.getData(true);
			grid.load(data);			
		}
		
		function resetForm() {
			form.reset();
		}
		
		function viewRDJG(e){
        	var value = e.value;
        	if(value==1){
        		return "认定";
        	}
        	if(value==2){
        		return "视同";
        	}
        	if(value==3){
        		return "不予认定";
        	}
        	return "";
        }
        
        function viewRDBH(e){
        	var value = e.value;
        	var record = e.record;
        	var doyear = "";
        	var dono = "";
        	if(record.documentyear!=null){
        		doyear = record.documentyear;
        	}
        	if(record.documentno!=null){
        		dono = record.documentno;
        	}
        	return doyear+"-"+dono;
        }
        function ondayRenderer(e) {
            	//var value = mini.get("utime").value;
                var dateValue = new Date(e.value);
                if (dateValue){
                	 return mini.formatDate(dateValue, "yyyy-MM-dd HH:mm:ss");
                }
              
        }
        function toexport(){
        	var content=document.getElementsByName("exportcontent");
        	var forlen=content.length;
			var contentvalue="";
			for(var i=0;i<forlen;i++){
				if(content[i].checked==true){
					contentvalue=content[i].value;
				}
			}
			mini.get("contentvalue").setValue(contentvalue);
        	if(contentvalue=="all"){
				document.form1.action ="${pageContext.request.contextPath}/gsrd/exportGsrd.do";
            	document.form1.submit();
    		}else if(contentvalue=="current"){
            	var pageindex = grid.getPageIndex();
            	var pagesize = grid.getPageSize();
            	mini.get("pageindex").setValue(pageindex);
            	mini.get("pagesize").setValue(pagesize);
            	var data = form.getData(true);
            	document.form1.action ="${pageContext.request.contextPath}/gsrd/exportGsrd.do";
            	document.form1.submit();
			}else if(contentvalue=="selected"){
				var sele = mini.encode(grid.getSelecteds());
				mini.get("sele").setValue(sele);
				document.form1.action ="${pageContext.request.contextPath}/gsrd/exportGsrd.do";
            	document.form1.submit();
			}
        }
</script>