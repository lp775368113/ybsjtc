<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>物料编码</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/scripts/jquery-1.10.0.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/scripts/ajaxfileupload.js"></script>
<style type="text/css">
html, body {
	font-size: 13px;
	padding: 0;
	margin: 0;
	border: 0;
	height: 100%;
	overflow: hidden;
}

.mini-panel-header {
	background-color: #E0EEEE;
}

.mini-panel-body {
	padding: 0px;
}

#form1 table tr {
	height: 28px;
}
</style>


</head>
<body>
	<div class="mini-panel" title="操作面板" showCollapseButton="false"
			style="width: 100%; height: auto;">
	<div class="mini-fit">
		<form id="form1" name="form1" style="" action="#" method="post">
		<div style="width: 100%;">
			<div class="mini-toolbar">
				<div class="operate" style="text-align: right !important">
				<div id="reload" style="float: left">
					<input class="mini-htmlfile" name="myfiles"  id="file0" style="width:200px;"  limitType="*.xlsx;*.xls"/>
				</div>
				<div style="float: left">
					<button type="button" class="bc_color" onclick="importExcle()" >
						<span class=""></span>导入
					</button>
					<button type="button" class="bc_color" onclick="exportExcle()" >
						<span class=""></span>导出
					</button>
					<button type="button" class="bc_color" onclick="reload()" >
						<span class=""></span>刷新
					</button>
				</div>
				</div>
			</div>
		</div>
		</form>
		</div>
		<!-- center begin -->
		<div class="mini-panel" title="查询结果" showCollapseButton="false"
			style="width: 100%; height: auto;">
			<div id="grid1" class="mini-datagrid" idField="id" multiSelect="true"
				style="width: 100%; height: auto;" allowResize="false" pageSize="20"
				showReloadButton="flase" showPageSize="false" multiSelect="false"
				virtualScroll="true" allowResize="true"
				url="${pageContext.request.contextPath}/encoding/getMaterielUpdata.do">
				<div property="columns">
					<!-- <div type="checkcolumn"></div> -->
					<div field="id" width="11%" headerAlign="center" align="center">序号</div> 
					<div field="erpid" width="11%" headerAlign="center" align="center">Rkey</div> 
					<div field="invPartNumber" width="20%" headerAlign="center"
						align="center">物料编码</div>
					<div field="extraDesc" width="33%" headerAlign="center"
						align="center">禾川编码</div>
					<!-- <div field="invPartDescriptionC" width="33%" headerAlign="center" align="center">物料大类</div> -->
					<!-- <div field="prodCodeSellPtr" width="33%" headerAlign="center"
						align="center">物料小类</div> -->
					<div field="prodSupperStr" width="25%" headerAlign="center"
						align="center">制造厂商</div>
					<div field="package_Str" width="25%" headerAlign="center"
						align="center">封装</div>
					<!-- <div field="smtFlag" width="33%" headerAlign="center"
						align="center">SMT/DIP</div>  -->
					<div field="invPartDescriptionC" width="40%" headerAlign="center"
						align="center">物料名称（描述）</div>
					<!-- <div field="custPartName" width="33%" headerAlign="center"
						align="center">供应商物料名称</div> -->
					<div field="custPartCode" width="25%" headerAlign="center"
						align="center">供应商料号</div>
					<div  type="comboboxcolumn"  name="purchUnitPtr"  field="purchUnitPtr" headerAlign="center" width="10%"   align="center" >包装单位</span>
                		<input property="editor" class="mini-combobox" style="width:100%;" minWidth="200" textField="unit_name" valueField="rkey"   url="${pageContext.request.contextPath}/encoding/getUnit.do" />
            		</div>
            		<div  type="comboboxcolumn"  name="stockUnitPtr"  field="stockUnitPtr" headerAlign="center" width="10%"   align="center" >仓存单位</span>
                		<input property="editor" class="mini-combobox" style="width:100%;" minWidth="200" textField="unit_name" valueField="rkey"   url="${pageContext.request.contextPath}/encoding/getUnit.do" />
            		</div>
            		<div field="supplierPtrStr" width="25%" headerAlign="center"
						align="center">优先供应商</div>
					<!-- 	<div field="peVersion" width="33%" headerAlign="center" align="center">版本号</div>
					<div field="stdCost" width="33%" headerAlign="center"
						align="center">核算单价</div>
					<div field="stockPurch" width="33%" headerAlign="center" align="center" >包装数量</div>
					<div field="iqcFlag" width="33%" headerAlign="center" align="center"  >IQC检查</div>	
					<div field="stockPakQty" width="33%" headerAlign="center" align="center"  >无仓存发货</div>	
					<div field="stopPurch" width="33%" headerAlign="center" align="center"  >停止采购</div>	
					<div field="qtyPerK" width="33%" headerAlign="center" align="center"  >重</div>
					<div field="mwidth" width="33%" headerAlign="center" align="center"  >宽</div>
					<div field="mlength" width="33%" headerAlign="center" align="center"  >长</div>	
					<div field="restIqcDate" width="33%" headerAlign="center" align="center"  >采购间隔</div>	
					<div field="restIqcDate" width="33%" headerAlign="center" align="center"  >标准机器工时</div>	
					<div field="workManH" width="33%" headerAlign="center" align="center"  >标准人工工时</div> renderer="ondayRenderer" -->
				</div>
			</div>
			<!-- center end -->
		</div>
		<div id="hid1" style="display: block">
		</div>
	</div>


</body>
</html>
<script type="text/javascript">
	mini.parse();
	var grid = mini.get("grid1");
	grid.load();
	function search() {
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
	
	function exportExcle(){
		document.form1.action ="${pageContext.request.contextPath}/encoding/exportExcle.do";
		document.form1.submit();
	} 
	
	function reload(){
		grid.reload();
	}
	function importExcle(){
		var file=mini.get("file0").getValue();
		if(file==""){
			mini.alert("请选择你需要导入的Excel文件！");
			return;
		}
		var data={};
		var fileids= ['file0'];
         $.ajaxFileUpload({
                    url:'${pageContext.request.contextPath}/encoding/importExcle.do',  
                    secureuri:false,  
                    fileElementId:fileids,     //这里不在是以前的id了，要写成数组的形式哦！  数组内容是文件控件的ID名称
                    dataType: 'json',  
                    data:data,//需要传输的数据  
                    success:function(data){
                    		mini.alert("导入成功！");
                    		$("#reload").empty().html("<input class='mini-htmlfile' name='myfiles'  id='file0' style='width:240px;'  limitType='*.xlsx;*.xls'/>");
                    		mini.parse();
                    		reload();
                    },
                    error: function(data){
                   	var reg = /<pre.+?>(.+)<\/pre>/g; 
						var result = data.responseText.match(reg);  	
						data.responseText= RegExp.$1;	
						var fun= jQuery.parseJSON(data.responseXML.activeElement.innerText); 			
                    	if(fun.success){
                    		mini.alert("导入成功！");
                    		$("#reload").empty().html("<input class='mini-htmlfile' name='myfiles'  id='file0' style='width:200px;'  limitType='*.xlsx;*.xls'/>");
                    		mini.parse();
                    		reload();
                    	}else if(fun.error){
                    		mini.alert(fun.error);
                    		reload();
                  		}else{
                  			mini.alert("服务器异常上传失败，请重新尝试！");
                  		}  //tomcat 使用
                  		//mini.alert("服务器异常，请重新尝试！","失败",window.CloseOwnerWindow);
                    }  
      });  
	}
	

	

</script>