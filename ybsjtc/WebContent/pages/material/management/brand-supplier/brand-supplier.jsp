<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>品牌管理</title>

<style type="text/css">
html,body {
	font-size: 12px;
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
</style>
</head>
<body>
	<div class="mini-splitter" style="width: 98%; height: 100%;">
		<div size="20%" showCollapseButton="false">
			<div class="mini-panel" title="品牌列表" showCollapseButton="false"
				style="width: 100%; height: auto;">
				<div style="border-bottom: 0; padding: 0px;">
					<div id="brandForm">
						<table cellpadding="0" class="main-table" cellspacing="0"
							border="0" width="100%">

							<tr height="30px">
								<td class="mini_title" width="95px">品牌名称：</td>
								<td><input id="brandname" name="brandname" class="mini-textbox"
									style="width: 120px;" /></td>


							</tr>
							<tr height="30px">
								<td colspan="2">
									<div style="width: 440px;" class="operate">
										<button type="button" class="cz_color" onclick="search()">
											<span class=""></span>查询
										</button>
										<button type="button" class="cz_color" onclick="addbrand()">
											<span class=""></span>增加
										</button>
										<button type="button" class="cz_color" onclick="changeSupplier()">
											<span class=""></span>品牌维护
										</button>
									</div>

								</td>
							</tr>
						</table>
					</div>
				</div>
				<div id="brandGrid" class="mini-datagrid" multiSelect="true"
					style="width: 100%; height: auto;" allowResize="false"
					showReloadButton="flase" showPageSize="false" pageSize="20"
					url="${pageContext.request.contextPath}/BrandSupplier/queryBrand.do">
					<div property="columns">
						<div type="indexcolumn" headerAlign="center" align="center"
							width="15%">序号</div>
						<div field="brandname" width="80%" headerAlign="center" align="center">品牌名称</div>
					</div>
				</div>
			</div>
		</div>
		<div showCollapseButton="false">
			<div class="mini-panel" title="代理商列表" showCollapseButton="false"
				style="width: 100%; height: auto;">
				<div id="supplierForm">
					<table cellpadding="0" class="main-table" cellspacing="0"
						border="0" width="100%">

						<tr height="30px">
							<td width="95px" class="mini_title">代理商名称：</td>
							<td><input id="supplierName" name="supplierName" class="mini-textbox"
								style="width: 120px" /></td>
						</tr>
						<tr height="30px">
							<td colspan="2" style="padding-left: 20px">
								<div style="width: 440px;" class="operate">
									<button type="button" class="cz_color" onclick="searchSupplier()">
										<span class=""></span>查询
									</button>
									<button type="button" class="cz_color" onclick="addSupplier()">
											<span class=""></span>增加
									</button>
									<button type="button" class="cz_color" onclick="changeBrand()">
										<span class=""></span>代理商维护
									</button>
								</div>
							</td>
						</tr>

					</table>
				</div>
				<div id="supplierGrid" class="mini-datagrid"
					style="width: 100%; height: auto;" allowResize="false"
					showReloadButton="flase" showPageSize="false"
					url="${pageContext.request.contextPath}/BrandSupplier/querySupplier.do">
					<div property="columns">
						<div type="indexcolumn" headerAlign="center" align="center"
							width="20%">序号</div>
						<div field="supplierName" width="40%" headerAlign="center" align="center">代理商名称</div>
						<div field="remark" width="40%" headerAlign="center"
							align="remark">备注</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<script type="text/javascript">
		mini.parse();
		var form = new mini.Form("brandForm");
		var supplierForm = new mini.Form("supplierForm");
		var brandGrid = mini.get("brandGrid");
		var supplierGrid = mini.get("supplierGrid");
		search();
		function search(){
			var data = form.getData(true);
			brandGrid.load(data);
		}

		function searchSupplier() {
			var data = supplierForm.getData(true);
			supplierGrid.load(data);
		}

		brandGrid.on("rowclick", function(e) {
			var id = e.record.id;
			supplierGrid.load({
				brandid : id
			});
		});

		/* supplierGrid.on("rowclick", function(e) {
			var id = e.record.id;
			brandGrid.load({
				supplierid : id
			});
		}); */

		function addbrand() {
			mini
					.open({
						url : "${pageContext.request.contextPath}/pages/material/management/brand-supplier/brand_edit.jsp",
						title : "增加品牌",
						width : 420,
						height : 200,
						onload : function() {
							var iframe = this.getIFrameEl();
							//调用弹出页面方法进行初始化
							iframe.contentWindow.setData({
								mode : "add"
							});
						},
						ondestroy : function() {
							brandGrid.reload();
						}
					});
		}
		function addSupplier() {
			mini.open({
						url : "${pageContext.request.contextPath}/pages/material/management/brand-supplier/supplier_edit.jsp",
						title : "增加代理商",
						width : 420,
						height : 200,
						onload : function() {
							var iframe = this.getIFrameEl();
							//调用弹出页面方法进行初始化
							iframe.contentWindow.setData({
								mode : "add"
							});
						},
						ondestroy : function() {
							supplierGrid.reload();
						}
					});
		}

		function changeSupplier() {
			var row = brandGrid.getSelected();
			if (!row) {
				mini.alert("请选择一个需要维护的品牌");
				return;
			}
			mini.open({
						url : "${pageContext.request.contextPath}/pages/material/management/brand-supplier/SupplierChange.jsp",
						title : "品牌维护",
						width : 750,
						height : 450,
						top : 0,
						onload : function() {
							var iframe = this.getIFrameEl();
							//调用弹出页面方法进行初始化
							iframe.contentWindow.setData({
								id : row.id
							});
						},
						ondestroy : function() {
							supplierGrid.reload();
						}
					});
		}

		function changeBrand() {
			var row = supplierGrid.getSelected();
			if (!row) {
				mini.alert("请选择一个需要维护的代理商");
				return;
			}
			mini.open({
						url : "${pageContext.request.contextPath}/pages/material/management/brand-supplier/brandChange.jsp",
						title : "品牌维护",
						width : 750,
						height : 450,
						onload : function() {
							var iframe = this.getIFrameEl();
							//调用弹出页面方法进行初始化
							iframe.contentWindow.setData({
								id : row.id
							});
						},
						ondestroy : function() {
							brandGrid.reload();
						}
					});
		}
	</script>

</body>
</html>