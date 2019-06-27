<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/scripts/buttonPremission.js"></script>
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
					<input class="mini-hidden" name="nottype" id="nottype" value="1" />
					<tr height="28px">
						<td class="mini_title" align="right" width="60px">大类名称：</td>
						<td><input id="maxclass" name="maxclass"
							class="mini-combobox"
							url="${pageContext.request.contextPath}/class/getAllbigclassPre.do?nottype=1"
							onvaluechanged="onClassChanged" showNullItem="true"
							textField="classname" width="80%" valueField="id" /></td>
						<td class="mini_title" align="right" width="80px">制造厂商：</td>
						<td><input id="prodSupper" name="prodSupper"
							onvaluechanged="onProdSupperChanged" class="mini-combobox"
							showNullItem="true" url="" valueFromSelect="true"
							textField="brandname" width="80%" valueField="id"
							allowInput="true" onclick="loadprodSupper" /></td>
						<td class="mini_title" align="right" width="110px">封装：</td>
						<td><input id="package_" name="package_"
							class="mini-combobox" valueFromSelect="true" allowInput="true"
							url="" textField="packagename" width="80%" valueField="id"
							onclick="loadpackage" /></td>
							<td class="mini_title" >产品类型：</td>
						<td><input name="productType" id="productType" width="80%"
							  class="mini-buttonedit"
							onbuttonclick="onButtonEdit" /></td>
					</tr>
					<tr height="28px">
						<td class="mini_title" align="right" width="60px">小类名称：</td>
						<td><input id="prodCodeSellPtr" name="prodCodeSellPtr"
							class="mini-combobox" url="" showNullItem="true"
							textField="classname" width="80%" valueField="id"
							onvaluechanged="onSmallClassChanged" /></td>
						<td class="mini_title" align="right" width="80px">供应商料号：</td>
						<td><input class="mini-textbox" id="custPartCode"
							name="custPartCode" width="80%" /></td>
						<td class="mini_title" align="right" width="110px">物料名称（描述）：</td>
						<td><input class="mini-textbox" id="ipdcSTR" name="ipdcSTR"
							width="80%" emptyText="多个关键词用空格隔开" /></td>
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
							class="mini-combobox" valueFromSelect="true" showNullItem="true"
							url="" onclick="loadsupplierPtr" textField="supplier_name"
							width="80%" valueField="id" allowInput="true" /></td>
						<td class="mini_title" align="right" width="80px">物料编码：</td>
						<td><input class="mini-textbox" id="invPartNumber"
							name="invPartNumber" width="80%" /></td>
						<td class="mini_title" align="right" width="110px">禾川编码：</td>
						<td><input class="mini-textbox" id="extraDesc"
							name="extraDesc" width="80%" /></td>

					</tr>

				</table>
			</form>
		</div>
		<div style="width: 100%;">
			<div class="mini-toolbar">
				<div class="operate" style="text-align: left !important">
					<button type="button" class="bc_color" onclick="add()"
						id="addProductInfo" style="display: none;">
						<span class=""></span>新增产品
					</button>
					<!-- <button type="button" class="bc_color" onclick="edit()"
						id="editProductInfo" style="display: none;">
						<span class=""></span>修改产品
					</button> -->
				</div>
			</div>
		</div>
		<!-- center begin -->
		<div class="mini-panel" title="查询结果" showCollapseButton="false"
			style="width: 100%; height: auto;">
			<div id="grid1" class="mini-datagrid" idField="id"
				multiSelect="false" style="width: 100%; height: auto;"
				allowResize="false" pageSize="20" showReloadButton="flase"
				showPageSize="false" virtualScroll="true" allowResize="true"
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
					<div field="stockPurch" width="10%" headerAlign="center"
						align="center">包装数量</div>
					<!-- <div field="warehouse" width="10%" headerAlign="center"
						align="center">仓存</div> -->
				</div>
			</div>
			<!-- center end -->
		</div>
		<div id="hid1" style="display: block"></div>
	</div>


</body>
</html>
<script type="text/javascript">
	mini.parse();
	var form = new mini.Form("form1");
	var grid = mini.get("grid1");
	grid.load({
		status : 9,
		nottype : 1
	});

	function onStatusChanged() {
		var data = form.getData(true);
		data.nottype = 1
		grid.load(data);
	}

	function loadprodSupper() {
		var url = mini.get("prodSupper").getUrl();
		if (!url) {
			url = "${pageContext.request.contextPath}/encoding/getProdSupper.do";
			mini.get("prodSupper").setUrl(url);
		}
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

	function onSmallClassChanged() {
		var smallclassid = mini.get("prodCodeSellPtr").getValue();
		url = "${pageContext.request.contextPath}/BrandSupplier/queryClassBrandPre.do?smallclassid="
				+ smallclassid;
		mini.get("prodSupper").setUrl(url);
	}

	function loadpackage() {
		var url = mini.get("package_").getUrl();
		if (!url) {
			var url = "${pageContext.request.contextPath}/package/getAllpackage.do";
			mini.get("package_").setUrl(url);
		}
	}

	function loadsupplierPtr() {
		var url = mini.get("supplierPtr").getUrl();
		if (!url) {
			var url = "${pageContext.request.contextPath}/encoding/getAllSupplier.do";
			mini.get("supplierPtr").setUrl(url);
		}
	}

	function onClassChanged() {
		var maxclass = mini.get("maxclass");
		var bigclassid = maxclass.getValue();
		var url = "${pageContext.request.contextPath}/class/getSmallClassPre.do?nottype=1&bigclassid="
				+ bigclassid;
		mini.get("prodCodeSellPtr").setUrl(url);
	}

	function search() {
		form.validate();
		if (form.isValid() == false) {
			return;
		}
		var data = form.getData(true);
		data.status = 9;
		data.nottype = 1;
		grid.load(data);
	}

	function resetForm() {
		form.reset();
	}

	function onProdSupperChanged() {
		var prodSupper = mini.get("prodSupper");
		var brandid = prodSupper.getValue();
		var url = "${pageContext.request.contextPath}/encoding/getSupplier.do?brandid="
				+ brandid;
		mini.get("supplierPtr").setUrl(url);
	}
	
	function add() {
		mini
				.open({
					targetWindow : window,
					url : "${pageContext.request.contextPath}/pages/material/BOMsys/product/product_add.jsp",
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
</script>