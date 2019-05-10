<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>小类编辑页面</title>

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
	<input class="mini-hidden" name="mode" id="mode" />
	<div id="form1">
		<table class="table" border="0" width="100%" cellspacing="10px">
			<tr>
				<th class="mini_title">标识：</th>
				<td><input id="id" name="id" class="mini-textbox"
					allowInput="false" width="100%" /></td>
				<th class="mini_title">编码：</th>
				<td><input id="code" name="code" class="mini-textbox"
					required="true" width="100%" /></td>
			</tr>
			<tr>
				<th class="mini_title">小类名称：</th>
				<td><input id="classname" name="classname" class="mini-textbox"
					required="true" width="100%" /></td>
				<td class="mini_title">所属大类：</td>
				<td ><input id="bigclassid" name="bigclassid"
					class="mini-combobox"
					url="${pageContext.request.contextPath}/class/getAllbigclass.do"
					required="true" valueFromSelect="true" textField="classname"
					width="100%" valueField="id" allowInput="true" /></td>
			</tr>
			<tr>
				<th class="mini_title">物料名称（描述）规则：</th>
				<td><input id="rules" name="rules" class="mini-textarea"
					width="100%" required="true" /></td>
				<th class="mini_title">备注：</th>
				<td><input id="remark" name="remark" width="100%"
                    class="mini-textarea"  /></td>
			</tr>
			<tr>
				<th class="mini_title">物料名称（描述）示列：</th>
				<td><input id="ensample" name="ensample" class="mini-textarea"
					width="100%" required="true" /></td>
				<th class="mini_title"></th>
				<td></td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<div class="operate">
						<button id="saveBtn" type="button" class="bc_color"
							onclick="save();">
							<span class="bc"></span>保存
						</button>
					</div>
				</td>
			</tr>
		</table>
		<script type="text/javascript">
			mini.parse();
			function setData(data) {
				var mode = data.mode;
				mini.get("mode").setValue(mode);
				if (mode == "add") {
					return;
				} else {
					mini.get("classname").setAllowInput(false);
				}
				var form = new mini.Form("#form1");
				form.setData(data.model);
			}

			function save() {
				var form = new mini.Form("#form1");
				form.validate();
				if (form.isValid() == false) {
					return;
				}
				var mode = mini.get("mode").getValue();
				var url = "";
				var title = "";
				if (mode == "add") {
					title = "新增";
					url = "${pageContext.request.contextPath}/class/savesmallclass.do"
				} else if (mode == "edit") {
					title = "修改";
					url = "${pageContext.request.contextPath}/class/updatesmallclass.do"
				} else {
					mini.alert("操作失败");
					return;
				}
				var data = form.getData();
				$.ajax({
					url : url,
					data : data,
					type : "post",
					dataType : "json",
					success : function(text) {
						if (text.success) {
							var id = mini.get("id");
							id.setValue(text.id);
							mini.alert(title + "成功！", "成功",
									window.CloseOwnerWindow);
						} else {
							mini.alert(text.message);
						}
					},
					error : function(jqXHR, textStatus, errorThrown) {
						alert(jqXHR.responseText);
					}
				});
			}
		</script>
</body>
</html>