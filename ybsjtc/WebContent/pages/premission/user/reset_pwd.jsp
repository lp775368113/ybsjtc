<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>用户菜单权限管理</title>

<style type="text/css">
html, body {
	font-size: 22px;
	padding: 0;
	margin: 0;
	border: 0;
	height: 100%;
	overflow: hidden;
}

#tb td{
	font-size: 15px;
	font-family: cursive;
}
#tb td input{
	font-size: 15px;
	font-family: cursive;
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
			<div class="mini-panel" title="用户列表" showCollapseButton="false"
				style="width: 100%; height: 100%;">
				<div class="mini-toolbar" style="border-bottom: 0; padding: 0px;">
					<div id="roleForm">
						<table cellpadding="0" class="main-table" cellspacing="0"
							border="0" width="100%">

							<tr>
								<td class="mini_title">用户名称：</td>
								<td><input id="name" name="name" class="mini-textbox"
									style="width: 120px" /></td>
								<td>
									<div style="width: 100px" class="operate" align="right">
										<button type="button" class="bc_color" onclick="search()">
											<span class=""></span>查询
										</button>
									</div>
								</td>
								<td>
									<div style="width: 100px" class="operate" align="left">
										<button type="button" class="bc_color" onclick="resetpwd()">
											<span class=""></span>重置密码
										</button>
									</div>
								</td>
							</tr>
						</table>
					</div>
				</div>
				<div id="userGrid" class="mini-datagrid"
					style="width: 100%; height: 84%;" allowResize="false"
					showReloadButton="false" showPageSize="false"
					url="${pageContext.request.contextPath}/user/queryUser.do">
					<div property="columns">
						<div type="indexcolumn" headerAlign="center" align="center"
							width="20%">序号</div>
						<div field="vsername" width="80%" headerAlign="center"
							align="center">用户名称</div>
						<div field="loginname" width="80%" headerAlign="center"
							align="center">登录帐号</div>
					</div>
				</div>
			</div>
		</div>
		<div showCollapseButton="false">
		<div id="userForm">
			<table id="tb" cellpadding="0" class="main-table" cellspacing="20" border="0"
				width="100%">
				<tr>
					<td colspan="4" align="center"><h2 style="color: #3498db;font-family: cursive;font-size: 20px">用户基本信息</h2></td>
				</tr>
				<tr>
					<td class="mini_title">用户名称：</td>
					<td><input class="mini-textbox asLable" enabled="false"  style="cursor: hand; width: 100%" borderStyle="border:0px;" id="loginname"
						name="loginname" /></td>
					<td class="mini_title">邮箱：</td>
					<td><input class="mini-textbox asLable" enabled="false"  style="cursor: hand; width: 100%" borderStyle="border:0px;" name="email" /></td>
				</tr>
				<tr>
					<td class="mini_title">真实姓名：</td>
					<td><input class="mini-textbox asLable" enabled="false" style="cursor: hand; width: 100%" borderStyle="border:0px;" id="vsername" name="vsername" /></td>
					<td class="mini_title">手机号：</td>
					<td><input class="mini-textbox asLable" enabled="false"  style="cursor: hand; width: 100%" borderStyle="border:0px;" name="mobilephone" /></td>
				</tr>
				<tr>
					<td class="mini_title">通讯住址：</td>
					<td colspan="3"><input class="mini-textbox asLable" enabled="false" style="cursor: hand; width: 100%"  borderStyle="border:0px;" name="address"/></td>
				</tr>
				<tr>
					<td class="mini_title">昵称：</td>
					<td><input class="mini-textbox asLable" enabled="false"  style="cursor: hand; width: 100%" borderStyle="border:0px;" name="mininame" /></td>
				</tr>
			</table>
			</div>
		</div>
	</div>
	</div>
	</div>
	<script type="text/javascript">
		mini.parse();
		var form = new mini.Form("roleForm");
		var userForm=new mini.Form("userForm");
		var userGrid = mini.get("userGrid");
		var tree = mini.get("grid1");
		search();
		function search() {
			form.validate();
			if (form.isValid() == false) {
				return;
			}
			var data = form.getData(true);
			userGrid.load(data);
		}

		userGrid.on("rowclick", function(e) {
			var data = e.record;
			userForm.setData(data);
		});

		tree.on("load", function(e) {
			mini.unmask();
		});

		

		function resetpwd() {
			var row = userGrid.getSelected();
	        if (!row) {
	            mini.alert("请选择要重置密码的用户！");
	            return;
	        }
	        console.log(row);

	        mini.confirm("确定重置该用户密码?", "确认重置", function(btn) {
	            if(btn === 'ok') {
	                $.ajax({
	                    url: "${pageContext.request.contextPath}/user/resetpwd.do",
	                    data: { userid: row.id },
	                    type: "post",
	                    dataType:"json",
	                    success: function (text) {
	                        if(text.success) {
	                            mini.showMessageBox({
	                                title: "成功",
	                                message: "新密码："+text.password,
	                                buttons: ["确定"],
	                                iconCls: "mini-messagebox-info",
	                                callback: function(action){
	                                }
	                            }); 
	                        } else {
	                            mini.alert(text.error);
	                        }
	                    },
	                    error: function (jqXHR, textStatus, errorThrown) {
	                        alert(jqXHR.responseText);
	                    }
	                });
	            }
	        });
		}
	</script>

</body>
</html>