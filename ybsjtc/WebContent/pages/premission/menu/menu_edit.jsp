<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>菜单编辑页面</title>

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
	<input class="mini-hidden" name="mode" id="mode" />
	<div id="form1">
		<input class="mini-hidden" name="parentid" id="parentid" />
		<input class="mini-hidden" name="type" id="type" />
		<table class="main-table" border="0" width="100%">
			<tr>
				<td class="mini_title">标识：</td>
				<td><input id="id" name="id" class="mini-textbox"
					allowInput="false" width="70%" /></td>
			</tr>
			<tr>
				<td class="mini_title">代码：</td>
				<td><input id="code" name="code" class="mini-textbox"
					required="true" width="70%" /></td>
			</tr>
			<tr>
				<td class="mini_title">名称：</td>
				<td><input id="name" name="name" class="mini-textbox"
					required="true" width="70%" /></td>
			</tr>
			<tr>
				<td class="mini_title">URL：</td>
				<td><input id="url" name="url" class="mini-textbox" width="70%" />
				</td>
			</tr>
			<tr>
				<td class="mini_title">图标1：</td>
				<td><input id="icon1" name="icon1" class="mini-textbox"
					width="70%" /></td>
			</tr>
			<tr>
				<td class="mini_title">图标2：</td>
				<td><input id="icon2" name="icon2" class="mini-textbox"
					width="70%" /></td>
			</tr>
			<tr>
				<td class="mini_title">图标3：</td>
				<td><input id="icon3" name="icon3" class="mini-textbox"
					width="70%" /></td>
			</tr>
			<tr>
				<td class="mini_title">描述：</td>
				<td><input id="description" name="description"
					class="mini-textbox" width="70%" /></td>
			</tr>
			<tr>
				<td class="mini_title">排序：</td>
				<td><input id="priority" name="priority" class="mini-textbox"
					required="true" width="70%" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<div class="operate">
						<button id="saveBtn" type="button" class="bc_color"
							onclick="save();">
							<span class="bc"></span>保存
						</button>
					</div></td>
			</tr>
		</table>
		<script type="text/javascript">
			mini.parse();
			function setData(data) {
				var mode = data.mode;
				mini.get("mode").setValue(mode);
				if (mode == "addone") {
					mini.get("parentid").setValue(0);
					mini.get("type").setValue(1);
					return;
				}
				if (mode == "addtwo") {
					mini.get("parentid").setValue(data.id);
					mini.get("type").setValue(parseInt(data.type)+1);
					return;
				}
				var form = new mini.Form("#form1");
				$
						.ajax({
							url : "${pageContext.request.contextPath}/menu/getMenu.do",
							data : {
								menuid : data.id
							},
							type : "post",
							dataType:"json",
							success : function(text) {
								if (text.success) {
									var form = new mini.Form("#form1");
									form.setData(text.data);
								} else {
									mini.alert(text.msg);
								}
							},
							error : function(jqXHR, textStatus, errorThrown) {
								alert(jqXHR.responseText);
							}
						});
			}

			function save() {
				var form = new mini.Form("#form1");
				form.validate();
				if (form.isValid() == false) {
					return;
				}
				var mode = mini.get("mode").getValue();
				var url = "";
				if (mode == "addone"||mode == "addtwo") {
					url = "${pageContext.request.contextPath}/menu/saveUaasMenu.do"
				} else if (mode == "edit") {
					url = "${pageContext.request.contextPath}/menu/updateUaasMenu.do"
				} else {
					mini.alert("操作失败");
					return;
				}
				var data = form.getData();
				$.ajax({
					url : url,
					data : data,
					type : "post",
					dataType:"json",
					success : function(text) {
						if (text.success) {
							var id = mini.get("id");
							id.setValue(text.id);
							mini.alert("保存成功");
							CloseWindows(text.id);
						} else {
							mini.alert(text.msg);
						}
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR.responseText);
					}
				});
			}

			function CloseWindows(id) {
				var name = mini.get("name").getValue();
				var parentid = mini.get("parentid").getValue();
				var options = {
					text : name,
					id : id
				};
				var mode = mini.get("mode").getValue();
                var url = "";
                if (mode == "add") {
                    window.Owner.addDateNode(options);
                }
				window.CloseOwnerWindow();

			}
		</script>
</body>
</html>