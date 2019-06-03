<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/scripts/buttonPremission.js"></script>
<head>
<title>物料编码</title>

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
	<div class="mini-fit">
		<div class="mini-panel" title="查询条件" showCollapseButton="false"
			style="width: 100%; height: auto;">
			<form id="form1" name="form1" style="" action="#" method="post">
				<table width="99%" border="0" cellpadding="0" cellspacing="0px"
					style="padding-top: 8px;">
					<tr height="28px">
						<td class="mini_title" align="right" width="60px" >大类名称：</td>
						<td><input id="maxclass" name="maxclass"
							class="mini-combobox"
							url="${pageContext.request.contextPath}/class/getAllbigclassPre.do"
							onvaluechanged="onClassChanged"  showNullItem="true"
							textField="classname" width="80%" valueField="id" /></td>
						<td class="mini_title" align="right" width="80px"  >制造厂商：</td>
						<td><input id="prodSupper" name="prodSupper"
							class="mini-combobox"
							url=""
							valueFromSelect="true" textField="brandname"  width="80%" 
							valueField="id" allowInput="true" onclick="loadprodSupper" /></td>
						<td class="mini_title" align="right" width="110px">封装：</td>
						<td><input id="package_" name="package_"
						class="mini-combobox" valueFromSelect="true" allowInput="true" 
						url="" 
						textField="packagename"  width="80%"  valueField="id" onclick="loadpackage" /></td>
						<td class="mini_title" width="80px">供应商：</td>
							<td width="16%"><input id="supplierPtr" name="supplierPtr"
								class="mini-combobox"  valueFromSelect="true"   showNullItem="true"
								url="" onclick="loadsupplierPtr"
								textField="supplier_name" width="80%" valueField="id"  allowInput="true" /></td>
					</tr>
					<tr height="28px">
						<td class="mini_title" align="right"  width="60px" >小类名称：</td>
						<td><input id="prodCodeSellPtr" name="prodCodeSellPtr"
							class="mini-combobox" url=""  showNullItem="true"
							textField="classname"  width="80%"  valueField="id"
							 /></td>
						<td class="mini_title" align="right"  width="80px" >供应商料号：</td>
						<td><input class="mini-textbox" id="custPartCode"
							name="custPartCode"  width="80%"  /></td>
						<td class="mini_title" align="right" width="110px"  >物料名称（描述）：</td>
						<td><input class="mini-textbox" id="ipdcSTR" name="ipdcSTR"
							 width="80%"  emptyText="多个关键词用空格隔开" /></td>
						<td colspan="2" align="center" valign="right">
							<div style="width: 150px; padding-right: 12px;" class="operate">
								<button type="button" class="cx_color" onclick="search()">
									<span class=""></span>查询
								</button>
								<button type="button" class="cz_color" onclick="resetForm()">
									<span class=""></span>重置
								</button>
							</div>
						</td>
					</tr>
					<tr height="28px">
						<td class="mini_title" align="right"  width="60px" >审核：</td>
						<td><input class="mini-combobox" name="status" id="status"
							 width="80%" 
							data="[{text:'ERP同步',code:9},{text:'审核中',code:1},{text:'不同意',code:3}]"
							textField="text" valueField="code" value=9 onvaluechanged="onStatusChanged" /></td>
						<td class="mini_title" align="right" width="80px"  >物料编码：</td>
						<td><input class="mini-textbox" id="invPartNumber"
							name="invPartNumber"  width="80%"  /></td>
						<td class="mini_title" align="right" width="110px" >禾川编码：</td>
						<td><input class="mini-textbox" id="extraDesc"
							name="extraDesc"  width="80%"  /></td>

					</tr>

				</table>
			</form>
		</div>
		<div style="width: 100%;">
			<div class="mini-toolbar">
				<div class="operate" style="text-align: left !important">
					<button type="button" class="bc_color" onclick="add()" id="addMaterialInfo" style="display:none;" >
						<span class=""></span>新增物料
					</button>
					<button type="button" class="bc_color" onclick="copy()" id="copyMaterialInfo" style="display:none;" >
						<span class=""></span>复制物料
					</button>
					<button type="button" class="bc_color" onclick="addReplace()" style="display:none;" id="addReplace" >
						<span class=""></span>新增替换料
					</button>
					<button type="button" class="bc_color" onclick="modify()" id="modifyMaterialInfo" style="display:none;" >
						<span class=""></span>修改物料
					</button>
					<button id="shixiaocode" type="button" class="bc_color" style="display:none;"
						onclick="SD('S')">
						<span class=""></span>失效编码审批
					</button>
					<button id="zuofeicode" type="button" class="bc_color" style="display:none;"
						onclick="SD('D')">
						<span class=""></span>作废编码审批
					</button>
				</div>
			</div>
		</div>
		<!-- center begin -->
		<div class="mini-panel" title="查询结果" showCollapseButton="false"
			style="width: 100%; height: auto;">
			<div id="grid1" class="mini-datagrid" idField="id"
				multiSelect="false" style="width: 100%; height: auto;"
				allowResize="false" pageSize="20" showReloadButton="flase"
				showPageSize="false" virtualScroll="true"
				allowResize="true"
				url="${pageContext.request.contextPath}/encoding/getMaterielList.do">
				<div property="columns">
					<div type="checkcolumn"></div>
					<div field="prodCodeSellPtrStr" width="20%" headerAlign="center"
						align="center">物料小类</div> 
					<!-- <div field="rkey" width="13%" headerAlign="center" align="center">RKEY</div>  -->
					<!-- <div field="ttype" width="20%" headerAlign="center" align="center">原料标识</div> -->
					<div field="invPartNumber" width="20%" headerAlign="center"
						align="center">物料编码</div>
					<div field="extraDesc" width="15%" headerAlign="center"
						align="center">禾川编码</div>
					<!-- <div field="invPartDescriptionC" width="33%" headerAlign="center" align="center">物料大类</div> -->
					<div field="prodSuppersStr" width="15%" headerAlign="center"
						align="center">制造厂商</div>
					<div field="package_Str" width="17%" headerAlign="center"
						align="center">封装</div>
					<div field="invPartDescriptionC" width="45%" headerAlign="center"
						align="center">物料名称（描述）</div>
					<div field="supplierPtrStr" width="25%" headerAlign="center"
						align="center">供应商</div>
					<div field="custPartCode" width="25%" headerAlign="center"
						align="center">供应商料号</div>
					<div field="stockPurch" width="10%" headerAlign="center"
						align="center">包装数量</div>
					<div field="warehouse" width="10%" headerAlign="center"
						align="center">仓存</div>
				</div>
			</div>
			<!-- center end -->
		</div>
		<div id="hid1" style="display: block">
			<!-- <table width="100%" border="0" cellpadding="0" cellspacing="0" >
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
	</table> -->
		</div>
	</div>


</body>
</html>
<script type="text/javascript">
	mini.parse();
	var form = new mini.Form("form1");
	var grid = mini.get("grid1");
	grid.load({
		status : 9
	});
	
	function onStatusChanged(){
		var data = form.getData(true);
		grid.load(data);
	}
	
	function loadprodSupper(){
		var url=mini.get("prodSupper").getUrl();
		if(!url){
			url="${pageContext.request.contextPath}/encoding/getProdSupper.do";
			mini.get("prodSupper").setUrl(url);
		}
	}
	
	function loadpackage(){
		var url=mini.get("package_").getUrl();
		if(!url){
		var url="${pageContext.request.contextPath}/package/getAllpackage.do";
		mini.get("package_").setUrl(url);
		}
	}
	
	function loadsupplierPtr(){
		var url=mini.get("supplierPtr").getUrl();
		if(!url){
		var url="${pageContext.request.contextPath}/encoding/getAllSupplier.do";
		mini.get("supplierPtr").setUrl(url);
		}
	}

	function onClassChanged() {
		var maxclass = mini.get("maxclass");
		var bigclassid = maxclass.getValue();
		var url = "${pageContext.request.contextPath}/class/getSmallClassPre.do?bigclassid="
				+ bigclassid;
		mini.get("prodCodeSellPtr").setUrl(url);
	}

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
	
	function copy(){
		var row = grid.getSelected();
		if (row) {
			var status=mini.get("status").getValue();
			row.status=status;
			mini
					.open({
						targetWindow : window,
						url : "${pageContext.request.contextPath}/pages/material/management/material_copy.jsp",
						title : "新增物料",
						width : 1100,
						height : 650,
						showMaxButton : true,
						allowResize : true,
						onload : function() {
							var iframe = this.getIFrameEl();
							iframe.contentWindow.SetData(row);
						},
						ondestroy : function(action) {
							grid.reload();
						}
					});
		} else {
			mini.alert("请选择需要复制的物料");
		}
	}

	function modify() {
		var row = grid.getSelected();
		if (row) {
			var status=mini.get("status").getValue();
			row.status=status;
			mini
					.open({
						targetWindow : window,
						url : "${pageContext.request.contextPath}/pages/material/management/material_edit.jsp",
						title : "修改物料",
						width : 1100,
						height : 650,
						showMaxButton : true,
						allowResize : true,
						onload : function() {
							var iframe = this.getIFrameEl();
							iframe.contentWindow.SetData(row);
						},
						ondestroy : function(action) {
							grid.reload();
						}
					});
		} else {
			mini.alert("请选择需要修改的物料");
		}
	}

	function add() {
		mini
				.open({
					targetWindow : window,
					url : "${pageContext.request.contextPath}/pages/material/management/material_add.jsp",
					title : "新增物料",
					width : 1100,
					height : 650,
					showMaxButton : true,
					allowResize : true,
					onload : function() {
						var iframe = this.getIFrameEl();
						iframe.contentWindow.SetData();
					},
					ondestroy : function(action) {
						grid.reload();
					}
				});
	}

	function addReplace() {
		var row = grid.getSelected();
		if (row) {
			var status=mini.get("status").getValue();
			row.status=status;
			mini.open({
						targetWindow : window,
						url : "${pageContext.request.contextPath}/pages/material/management/material_addReplace.jsp",
						title : "新增替代料",
						width : 1100,
						height : 650,
						showMaxButton : true,
						allowResize : true,
						onload : function() {
							var iframe = this.getIFrameEl();
							iframe.contentWindow.SetData(row);
						},
						ondestroy : function(action) {
							grid.reload();
						}
					});
		} else {
			mini.alert("请选择替代的物料");
		}
	}

	grid.on(
					"rowdblclick",
					function(e) {
						var row = e.row;
						mini
								.open({
									targetWindow : window,
									url : "${pageContext.request.contextPath}/pages/material/management/material_view.jsp",
									title : "物料详情",
									width : "100%",
									height : "100%",
									showMaxButton : true,
									allowResize : true,
									onload : function() {
										var iframe = this.getIFrameEl();
										iframe.contentWindow.SetData(row);
									},
									ondestroy : function(action) {

									}
								});
					});

	function SD(e) {
		var row = grid.getSelected();
		if (row) {
			row.SD = e;
			var title = '';
			if ('S' == e) {
				title = "失效编码";
			} else {
				title = "作废编码";
			}
			console.log(row);
			mini
					.confirm(
							"确定" + title + "？",
							"确定？",
							function(action) {
								if (action == "ok") {
									$
											.ajax({
												url : "${pageContext.request.contextPath}/encoding/SD.do",
												type : "post",
												dataType : "json",
												cache : false,
												data : row,
												success : function(data) {
													if (data.success) {
														mini.alert("成功发起审批！",
																"成功");
													} else {
														mini.alert(
																data.message,
																"失败");
													}
												}
											});
								}
							});
		} else {
			mini.alert("请选择一条记录");
		}

	}
</script>