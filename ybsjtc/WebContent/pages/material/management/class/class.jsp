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
		<div size="35%" showCollapseButton="false">
			<div class="mini-panel" title="大类列表" showCollapseButton="false"
				style="width: 100%; height: auto;">
				<div style="border-bottom: 0; padding: 0px;">
					<div id="bigForm">
						<table cellpadding="0" class="main-table" cellspacing="0"
							border="0" width="100%">

							<tr height="30px">
								<td class="mini_title" width="95px">编码：</td>
								<td><input id="code" name="code" class="mini-textbox"
									style="width: 120px;" /></td>
								<td class="mini_title" width="95px">器件名称：</td>
								<td><input id="classname" name="classname"
									class="mini-textbox" style="width: 120px;" /></td>
							</tr>
							<tr height="30px">
								<td colspan="4" style="padding-left: 20px">
									<div style="width: 440px;" class="operate">
										<button type="button" class="cz_color" onclick="search()">
											<span class=""></span>查询
										</button>
										<button type="button" class="cz_color" onclick="add()">
											<span class=""></span>增加
										</button>
										<button type="button" class="cz_color" onclick="edit()">
											<span class=""></span>修改
										</button>
									</div>

								</td>
							</tr>
						</table>
					</div>
				</div>
				<div id="bigGrid" class="mini-datagrid" multiSelect="true"
					style="width: 100%; height: auto;" allowResize="false"
					showReloadButton="flase" showPageSize="false" pageSize="20"
					url="${pageContext.request.contextPath}/class/querybigclass.do">
					<div property="columns">
						<div type="indexcolumn" headerAlign="center" align="center"
							width="7%">序号</div>
						<div type="checkcolumn" headerAlign="center" align="center"
							width="7%"></div>
						<div field="code" width="15%" headerAlign="center" align="center">编码</div>
						<div field="classname" width="20%" headerAlign="center"
							align="center">大类名称</div>
						<div field="remark" width="30%" headerAlign="center"
							align="center">备注</div>
					</div>
				</div>
			</div>
		</div>
		<div showCollapseButton="false">
			<div class="mini-panel" title="小类列表" showCollapseButton="false"
				style="width: 100%; height: auto;">
				<div id="smallForm">
					<table cellpadding="0" class="main-table" cellspacing="0"
						border="0" width="100%">
						<tr height="30px">
							<td class="mini_title" width="95px">编码：</td>
							<td><input id="code" name="code" class="mini-textbox"
								style="width: 120px;" /></td>
							<td width="95px" class="mini_title">小类名称：</td>
							<td><input id="classname" name="classname"
								class="mini-textbox" style="width: 120px" /></td>
						</tr>
						<tr height="30px">
							<td colspan="4" style="padding-left: 20px" >
								<div style="width: 200px;" class="operate">
									<button type="button" class="cz_color" onclick="searchUser()">
										<span class=""></span>查询
									</button>
									<button type="button" class="cz_color" onclick="addsmallclass()">
										<span class=""></span>新增
									</button>
									<button type="button" class="cz_color" onclick="editsmallclass()">
										<span class=""></span>修改
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
						<div field="code" width="10%" headerAlign="center" align="center">编码</div>
						<div field="classname" width="20%" headerAlign="center"
							align="center">小类名称</div>
						<div field="rules" width="40%" headerAlign="center" align="center">物料名称（描述）规则</div>
						<div field="remark" width="40%" headerAlign="center"
							align="center">备注</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<script type="text/javascript">
		mini.parse();
		var form = new mini.Form("bigForm");
		var smallForm = new mini.Form("smallForm");
		var bigGrid = mini.get("bigGrid");
		var smallGrid = mini.get("smallGrid");
		search();
		function search() {
			var data = form.getData(true);
			bigGrid.load(data);
		}

		function searchUser() {
			var data = smallForm.getData(true);
			smallGrid.load(data);
		}

		bigGrid.on("rowclick", function(e) {
			var id = e.record.id;
			smallGrid.load({
				bigclassid : id
			});
		});
		
		smallGrid.on("rowclick", function(e) {
			var id = e.record.bigclassid;
			bigGrid.load({
				bigclassid : id
			});
		});

		function add() {
			mini
					.open({
						url : "${pageContext.request.contextPath}/pages/material/management/class/bigclass_edit.jsp",
						title : "添加大类",
						width : 420,
						height : 300,
						onload : function() {
							var iframe = this.getIFrameEl();
							//调用弹出页面方法进行初始化
							iframe.contentWindow.setData({
								mode : "add"
							});
						},
						ondestroy : function() {
							bigGrid.reload();
						}
					});
		}

		function edit() {
			var row = bigGrid.getSelected();
			console.log(row);
			if (!row) {
				mini.alert("请选择一个需要修改的大类");
				return;
			}
			mini
					.open({
						url : "${pageContext.request.contextPath}/pages/material/management/class/bigclass_edit.jsp",
						title : "编辑大类",
						width : 420,
						height : 250,
						onload : function() {
							var iframe = this.getIFrameEl();
							//调用弹出页面方法进行初始化
							iframe.contentWindow.setData({
								mode : "edit",
								id : row.id,
								model : row
							});
						},
						ondestroy : function() {
							bigGrid.reload();
						}
					});
		}

		
		function addsmallclass() {
			mini
					.open({
						url : "${pageContext.request.contextPath}/pages/material/management/class/smallclass_edit.jsp",
						title : "添加小类",
						width : 800,
						height : 307,
						onload : function() {
							var iframe = this.getIFrameEl();
							//调用弹出页面方法进行初始化
							iframe.contentWindow.setData({
								mode : "add"
							});
						},
						ondestroy : function() {
							smallGrid.reload();
						}
					});
		}
		
		function editsmallclass() {
			var row = smallGrid.getSelected();
			if (!row) {
				mini.alert("请选择一个需要修改的小类");
				return;
			}
			mini
					.open({
						url : "${pageContext.request.contextPath}/pages/material/management/class/smallclass_edit.jsp",
						title : "编辑小类",
						width : 800,
						height :307,
						onload : function() {
							var iframe = this.getIFrameEl();
							//调用弹出页面方法进行初始化
							iframe.contentWindow.setData({
								mode : "edit",
								id : row.id,
								model : row
							});
						},
						ondestroy : function() {
							smallGrid.reload();
						}
					});
		}
	</script>

</body>
</html>