<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>器件管理</title>

<style type="text/css">
html, body {
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
	<div class="mini-splitter" style="width: 100%; height: 100%;">
		<div size="20%" showCollapseButton="false">
			<div class="mini-panel" title="小类列表" showCollapseButton="false"
				style="width: 100%; height: auto;">
				<div id="smallForm">
					<table cellpadding="0" class="main-table" cellspacing="0"
						border="0" width="100%">
						<tr height="30px">
							<td width="95px" class="mini_title">大类名称：</td>
							<td><input id="bigclassid" name="bigclassid"
								class="mini-combobox"
								url="${pageContext.request.contextPath}/class/getAllbigclassPre.do"
								onvaluechanged="onClassChanged" showNullItem="true"
								textField="classname" width="120px" valueField="id" /></td>
						</tr>
						<tr>
							<td width="95px" class="mini_title">小类名称：</td>
							<td><input id="classname" name="classname"
								class="mini-textbox" style="width: 120px" /></td>
						</tr>
						<tr height="30px">
							<td colspan="6" style="padding-left: 20px" >
								<div style="width: 200px;" class="operate">
									<button type="button" class="cz_color" onclick="searchSmall()">
										<span class=""></span>查询
									</button>
									<button type="button" class="cz_color" onclick="changeBrand()">
											<span class=""></span>品牌维护
										</button>
								</div>
							</td>
						</tr>

					</table>
				</div>
				<div id="smallGrid" class="mini-datagrid"
					style="width: 100%; height: auto;" allowResize="false"
					showReloadButton="flase" showPageSize="false" pageSize="20"
					url="${pageContext.request.contextPath}/class/querysmallclass.do">
					<div property="columns">
						<div type="indexcolumn" headerAlign="center" align="center"
							width="7%">序号</div>
						<div field="classname" width="20%" headerAlign="center"
							align="center">小类名称</div>
					</div>
				</div>
			</div>
		</div>
		<div showCollapseButton="false">
			<div class="mini-panel" title="品牌列表" showCollapseButton="false"
				style="width: 100%; height: auto;">
				<div style="border-bottom: 0; padding: 0px;">
				</div>
				<div id="brandGrid" class="mini-datagrid" multiSelect="true"
					style="width: 100%; height: auto;" allowResize="false"
					showReloadButton="flase" showPageSize="false" pageSize="20"
					url="${pageContext.request.contextPath}/BrandSupplier/queryClassBrand.do">
					<div property="columns">
						<div type="indexcolumn" headerAlign="center" align="center"
							width="15%">序号</div>
						<div field="brandname" width="80%" headerAlign="center" align="center">品牌名称</div>
						<div field="remark" width="80%" headerAlign="center" align="center">备注</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<script type="text/javascript">
		mini.parse();
		var smallForm = new mini.Form("smallForm");
		var brandGrid = mini.get("brandGrid");
		var smallGrid = mini.get("smallGrid");
		searchSmall();
		function searchSmall() {
			var data = smallForm.getData(true);
			smallGrid.load(data);
		}

		smallGrid.on("rowclick", function(e) {
			var id = e.record.id;
			brandGrid.load({
				smallclassid : id
			});
		});
		
		function changeBrand(){
			var row = smallGrid.getSelected();
			if (!row) {
				mini.alert("请选择一个需要维护的小类");
				return;
			}
			mini.open({
						url : "${pageContext.request.contextPath}/pages/material/management/smallclasss-brand/brandChange.jsp",
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
							brandGrid.reload();
						}
					});
		}
		
	</script>
</body>
</html>