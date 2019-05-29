<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>角色事项权限管理</title>

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
	<div class="mini-splitter" style="width:98%;height:100%;">
		<div size="40%" showCollapseButton="false">
			<div class="mini-panel" title="角色列表" showCollapseButton="false"
				style="width: 100%; height: 100%;">
				<div class="mini-toolbar" style="border-bottom:0;padding:0px;">
					<div id="roleForm">
						<table cellpadding="0" class="main-table" cellspacing="0"
							border="0" width="100%">

							<tr>
								<td class="mini_title">角色名称：</td>
								<td><input id="name" name="name" class="mini-textbox"
									style="width: 120px" /></td>
								<td>
									<div style="width: 100px" class="operate">
										<button type="button" class="cx_color" onclick="search()">
											<span class=""></span>查询
										</button>
									</div></td>
								<td>
									<div style="width: 100px" class="operate">
										<button type="button" class="cz_color" onclick="addButton()">
											<span class=""></span>角色维护
										</button>
									</div></td>
							</tr>
						</table>
					</div>
				</div>
				<div id="roleGrid" class="mini-datagrid"
					style="width: 100%; height: 84%;" allowResize="false"
					showReloadButton="false" showPageSize="false"
					url="${pageContext.request.contextPath}/role/queryRole.do">
					<div property="columns">
						<div type="indexcolumn" headerAlign="center" align="center"
							width="20%">序号</div>
						<div field="name" width="80%" headerAlign="center" align="center">角色名称</div>
					</div>
				</div>
			</div>
		</div>
		<div showCollapseButton="false">
			<div class="mini-panel" title="拥有按钮权限" showCollapseButton="false"
				style="width: 100%; height: auto;">
				<div id="buttonGrid" class="mini-datagrid"
					style="width: 100%; height: auto;" allowResize="false"
					showReloadButton="flase" showPageSize="false"
					url="${pageContext.request.contextPath}/button/queryButton.do">
					<div property="columns">
						<div type="indexcolumn" headerAlign="center" align="center"
							width="20%">序号</div>
						<div field="buttonname" width="40%" headerAlign="center" align="center">按钮名称</div>
						<div field="description" width="40%" headerAlign="center"
							align="center">按钮描述</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<script type="text/javascript">
		mini.parse();
		var form = new mini.Form("roleForm");
		var roleGrid = mini.get("roleGrid");
		var buttonGrid = mini.get("buttonGrid");
		search();
		function search() {
			form.validate();
			if (form.isValid() == false) {
				return;
			}
			var data = form.getData(true);
			roleGrid.load(data);
		}

		roleGrid.on("rowclick", function(e) {
			var id = e.record.id;
			buttonGrid.load({
				roleid : id
			});
		});
		
		function addButton() {
			var row = roleGrid.getSelected();
			if (!row) {
				mini.alert("请选择一个需要维护的角色");
				return;
			}
			mini.open({
						url : "${pageContext.request.contextPath}/pages/premission/button/rolebuttonChange.jsp",
						title : "角色按钮维护",
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
							buttonGrid.reload();
						}
					});
		}


	</script>

</body>
</html>