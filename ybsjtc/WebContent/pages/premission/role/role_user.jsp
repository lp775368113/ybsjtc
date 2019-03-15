<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>用户角色管理</title>

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
		<div size="55%" showCollapseButton="false">
			<div class="mini-panel" title="角色列表" showCollapseButton="false"
				style="width: 100%; height: auto;">
				<div style="border-bottom: 0; padding: 0px;">
					<div id="roleForm">
						<table cellpadding="0" class="main-table" cellspacing="0"
							border="0" width="100%">

							<tr height="30px">
								<td class="mini_title" width="95px">角色名称：</td>
								<td><input id="name" name="name" class="mini-textbox"
									style="width: 120px;" /></td>


							</tr>
							<tr height="30px">
								<td colspan="2" style="padding-left: 20px">
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
										<button type="button" class="cz_color" onclick="destroy()">
											<span class=""></span>删除
										</button>
										<button type="button" class="cz_color" onclick="addUser()">
											<span class=""></span>用户维护
										</button>
									</div>

								</td>
							</tr>
						</table>
					</div>
				</div>
				<div id="roleGrid" class="mini-datagrid" multiSelect="true"
					style="width: 100%; height: auto;" allowResize="false"
					showReloadButton="flase" showPageSize="false"
					url="${pageContext.request.contextPath}/role/queryRole.do">
					<div property="columns">
						<div type="indexcolumn" headerAlign="center" align="center"
							width="10%">序号</div>
						<div type="checkcolumn" headerAlign="center" align="center"
							width="10%"></div>
						<div field="name" width="80%" headerAlign="center" align="center">角色名称</div>
					</div>
				</div>
			</div>
		</div>
		<div showCollapseButton="false">
			<div class="mini-panel" title="用户列表" showCollapseButton="false"
				style="width: 100%; height: auto;">
				<div id="userForm">
					<table cellpadding="0" class="main-table" cellspacing="0"
						border="0" width="100%">

						<tr height="30px">
							<td width="95px" class="mini_title">用户名称：</td>
							<td><input id="name" name="name" class="mini-textbox"
								style="width: 120px" /></td>
						</tr>
						<tr height="30px">
							<td colspan="2" style="padding-left: 20px">
								<div style="width: 200px;" class="operate">
									<button type="button" class="cz_color" onclick="searchUser()">
										<span class=""></span>查询
									</button>

									<button type="button" class="cz_color" onclick="addRole()">
										<span class=""></span>角色维护
									</button>
								</div>
							</td>
						</tr>

					</table>
				</div>
				<div id="userGrid" class="mini-datagrid"
					style="width: 100%; height: auto;" allowResize="false"
					showReloadButton="flase" showPageSize="false"
					url="${pageContext.request.contextPath}/role/queryUser.do">
					<div property="columns">
						<div type="indexcolumn" headerAlign="center" align="center"
							width="20%">序号</div>
						<div field="vsername" width="40%" headerAlign="center" align="center">用户名称</div>
						<div field="loginname" width="40%" headerAlign="center"
							align="center">登录名称</div>
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
		var userForm = new mini.Form("userForm");
		var roleGrid = mini.get("roleGrid");
		var userGrid = mini.get("userGrid");
		search();
		function search(){
			var data = form.getData(true);
			roleGrid.load(data);
		}

		function searchUser() {
			var data = userForm.getData(true);
			userGrid.load(data);
		}

		roleGrid.on("rowclick", function(e) {
			var id = e.record.id;
			userGrid.load({
				roleid : id
			});
		});

		userGrid.on("rowclick", function(e) {
			var id = e.record.id;
			roleGrid.load({
				userid : id
			});
		});

		function add() {
			mini
					.open({
						url : "${pageContext.request.contextPath}/pages/premission/role/role_edit.jsp",
						title : "增加角色",
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
							roleGrid.reload();
						}
					});
		}

		function edit() {
			var row = roleGrid.getSelected();
			console.log(row);
			if (!row) {
				mini.alert("请选择一个需要修改的角色");
				return;
			}
			mini
					.open({
						url : "${pageContext.request.contextPath}/pages/premission/role/role_edit.jsp",
						title : "编辑角色",
						width : 420,
						height : 200,
						onload : function() {
							var iframe = this.getIFrameEl();
							//调用弹出页面方法进行初始化
							iframe.contentWindow.setData({
								mode : "edit",
								id : row.id,
								model:row
							});
						},
						ondestroy : function() {
							roleGrid.reload();
						}
					});
		}

		function destroy() {
			var rows = roleGrid.getSelecteds();
			if (!rows || rows == "" || rows == null) {
				mini.alert("请选择需要删除的角色");
				return;
			}
			var data = {};
			data.datalist = mini.encode(rows);
			roleGrid.loading("删除中，请稍后......");
			$
					.ajax({
						url : "${pageContext.request.contextPath}/role/removeUaasRole.do",
						data : data,
						type : "post",
						dataType : "json",
						success : function(text) {
							if (text.success) {
								mini.alert("删除成功");
							} else {
								mini.alert(text.msg);
							}
							roleGrid.reload();
							roleGrid.unmask();
						},
						error : function(jqXHR, textStatus, errorThrown) {
							mini.alert("删除失败");
							roleGrid.unmask();
						}
					});
		}

		function addUser() {
			var row = roleGrid.getSelected();
			if (!row) {
				mini.alert("请选择一个需要修改的角色");
				return;
			}
			mini
					.open({
						url : "${pageContext.request.contextPath}/pages/premission/role/userChange.jsp",
						title : "用户维护",
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
							userGrid.reload();
						}
					});
		}

		function addRole() {
			var row = userGrid.getSelected();
			if (!row) {
				mini.alert("请选择一个需要修改的角色");
				return;
			}
			mini
					.open({
						url : "${pageContext.request.contextPath}/pages/premission/role/roleChange.jsp",
						title : "角色维护",
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
							roleGrid.reload();
						}
					});
		}
	</script>

</body>
</html>