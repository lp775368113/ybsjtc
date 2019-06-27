<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
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
						<td class="mini_title" >产品类型：</td>
						<td><input name="productType" id="productType" width="80%"
							  class="mini-buttonedit"
							onbuttonclick="onButtonEdit" /></td>
					</tr>
					<tr height="28px">
						<td class="mini_title" align="right"  width="60px" >小类名称：</td>
						<td><input id="prodCodeSellPtr" name="prodCodeSellPtr"
							class="mini-combobox" url=""  showNullItem="true"
							textField="classname"  width="80%"  valueField="id"  onvaluechanged="onSmallClassChanged"
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
						<td class="mini_title" width="80px">供应商：</td>
							<td width="16%"><input id="supplierPtr" name="supplierPtr"
								class="mini-combobox"  valueFromSelect="true"   showNullItem="true"
								url="" onclick="loadsupplierPtr"
								textField="supplier_name" width="80%" valueField="id"  allowInput="true" /></td>
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
					<button type="button" class="bc_color" onclick="onOk()">
						<span class=""></span>确定
					</button>
					<button type="button" class="bc_color" onclick="calloff()">
						<span class=""></span>取消
					</button>
				</div>
			</div>
		</div>
		<!-- center begin -->
		<div class="mini-panel" title="查询结果" showCollapseButton="false"
			style="width: 100%; height: auto;">
			<div id="grid1" class="mini-datagrid" idField="id"
				 style="width: 100%; height: auto;"
				allowResize="false" pageSize="20" showReloadButton="flase" multiSelect="true"
				showPageSize="false" virtualScroll="true"
				allowResize="true" 
				url="${pageContext.request.contextPath}/encoding/getMaterielList.do">
				<div property="columns">
					<div type="checkcolumn"></div>
					<div field="prodCodeSellPtrStr" width="20%" headerAlign="center"
						align="center">物料小类</div> 
					<!-- <div field="invPartNumber" width="20%" headerAlign="center"
						align="center">物料编码</div> -->
					<div field="extraDesc" width="15%" headerAlign="center"
						align="center">禾川编码</div>
					<!-- <div field="invPartDescriptionC" width="33%" headerAlign="center" align="center">物料大类</div> -->
					<div field="prodSupperStr" width="15%" headerAlign="center"
						align="center">制造厂商</div>
					<div field="package_Str" width="17%" headerAlign="center"
						align="center">封装</div>
					<div field="invPartDescriptionC" width="45%" headerAlign="center"
						align="center">物料名称（描述）</div>
					<div field="supplierPtrStr" width="25%" headerAlign="center"
						align="center">供应商</div>
					<div field="custPartCode" width="25%" headerAlign="center"
						align="center">供应商料号</div>
					<div field="warehouse" width="10%" headerAlign="center"
						align="center">仓存</div>
				</div>
			</div>
			<!-- center end -->
		</div>
	</div>


</body>
</html>
<script type="text/javascript">
	mini.parse();
	var form = new mini.Form("form1");
	var grid = mini.get("grid1");
	var addmodel=[];
	grid.load({
		status : 9
	});
	
	function onOk() {
        closeWindow("ok");
    }
	function onButtonEdit(e) {
        var btnEdit = this;
        mini.open({
            url: "${pageContext.request.contextPath}/pages/material/BOMsys/product/product_type.jsp",
            showMaxButton: false,
            title: "选择产品类型",
            width: 350,
            height: 450,
            ondestroy: function (action) {                    
                if (action == "ok") {
                    var iframe = this.getIFrameEl();
                    var data = iframe.contentWindow.GetData();
                    data = mini.clone(data);
                    if (data) {
                        btnEdit.setValue(data.id);
                        btnEdit.setText(data.text);
                    }
                }
            }
        });            
    }   
	
	function calloff(){
		closeWindow("off");
	}
	
	function closeWindow(action) {
        if (window.CloseOwnerWindow)
            return window.CloseOwnerWindow(action);
        else
            window.close();
    }

	
	function getData(){
		return addmodel;
	}
	
	
	
	grid.on(
			"select",
			function(e) {
				var row =e.record;
				for(var i=0;i<addmodel.length;i++){
					if(addmodel[i].custPartCode==row.custPartCode){
						return;
					}
				}
				addmodel.push(row);
			});
	
	grid.on(
			"deselect",
			function(e) {
				var row =e.record;
				 for (var i = 0; i < addmodel.length; i++) {
					  if (addmodel[i].id == row.id) {
					       addmodel.splice(i, 1);
					  }
				}
			});
	
	grid.on(
			"load",
			function(e) {
				grid.selects(addmodel, false);
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
	
	function onSmallClassChanged(){
		var smallclassid=mini.get("prodCodeSellPtr").getValue();
		url="${pageContext.request.contextPath}/BrandSupplier/queryClassBrandPre.do?smallclassid="+smallclassid;
		mini.get("prodSupper").setUrl(url);
	}
	

	function search() {
		form.validate();
		if (form.isValid() == false) {
			return;
		}
		var data = form.getData(true);
		data.status=9;
		grid.load(data);
	}

	function resetForm() {
		form.reset();
	}
</script>