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
			<div class="mini-panel" title="菜单列表" showCollapseButton="false"
				style="width: 100%; height: 100%;"> 
				<div class="mini-toolbar">
                <table cellpadding="0" class="main-table" cellspacing="0" border="0"
                    width="50%">

                    <tr>
                        <td>
                            <div class="operate">
                                <button id="button_save" style="margin-right:200px"
                                    type="button" class="cx_color" onclick="save();">
                                    <span class="bc"></span>授权
                                </button>
                            </div>
                        </td>
                    </tr>
                </table>
            </div>
			<div class="mini-fit">  
					<%--<ul id="tree1" class="mini-treegrid"
						url="${pageContext.request.contextPath}/uaasMenu/listMenuPermission.do"
						style="width:100%;height:100%;padding:5px;" showTreeIcon="true"
						textField="text" idField="id" parentField="pid"
						resultAsTree="false" allowSelect="false" enableHotTrack="true"
						expandOnLoad="false" showCheckBox="true" checkRecursive="false"
						autoCheckParent="true">
					</ul>
					--%>
					<div id="grid1" class="mini-treegrid" 
						style="width:100%;height:84%;" showTreeIcon="true"
						treeColumn="name" idField="id" parentField="parentid"
						resultAsTree="false" expandOnLoad="false" allowCellEdit="true"
						url="${pageContext.request.contextPath}/menu/listMenuPermission.do">
						<div property="columns">
							<%--<div type="indexcolumn">序号</div>--%>
							<div field="id" visible="false"></div>
							<div field="parentid" visible="false"></div>
							<div type="checkboxcolumn" field="ischecked" trueValue="1"
								falseValue="0" width="10%" headerAlign="center"></div>
							<div name="name" field="name" width="90%" headerAlign="left"
								align="left">菜单名称</div>
						</div>
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
		var tree = mini.get("grid1");
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
			tree.load({
				roleid : id
			});
		});

		tree.on("load", function(e) {
			mini.unmask();
		});

		tree.on("cellcommitedit", function(e) {
			var field = e.field;
			if (field == "ischecked") {
				var id = e.record.id;
				var parentid = e.record.parentid;
				var ischecked = e.record.ischecked;
				if ("0" == ischecked) {
					selectParentRow(parentid, "1");
				} else if ("1" == ischecked) {
					cancelParentRow(id, parentid, "0");
				}
				changeChildRow(id, ischecked == "0" ? "1" : "0");
			}
		});
		//取消选择父节点
		function cancelParentRow(id, parentid, ischecked) {
			var parentrow = tree.findRow(function(row) {
				if (row.id == parentid)
					return true;
			});
			if (parentrow == null) {
				return;
			}
			var childrows = tree.findRows(function(row) {
				if (row.parentid == parentid)
					return true;
			});
			var cancelFlag = true;
			$.each(childrows, function(i, obj) {
				if (obj.ischecked == "1" && obj.id != id) {
					cancelFlag = false;
				}
			});
			if (cancelFlag) {
				tree.updateRow(parentrow, {
					ischecked : ischecked
				});
				cancelParentRow(parentrow.id, parentrow.parentid, ischecked);
			}
		}

		//选中父节点
		function selectParentRow(parentid, ischecked) {
			var parentrow = tree.findRow(function(row) {
				if (row.id == parentid)
					return true;
			});
			if (parentrow == null) {
				return;
			}
			tree.updateRow(parentrow, {
				ischecked : ischecked
			});
			selectParentRow(parentrow.parentid, ischecked);
		}

		function changeChildRow(id, ischecked) {
			var childrows = tree.findRows(function(row) {
				if (row.parentid == id)
					return true;
			});
			if (!childrows) {
				return;
			}
			$.each(childrows, function(i, obj) {
				tree.updateRow(obj, {
					ischecked : ischecked
				});
				changeChildRow(obj.id, ischecked)
			});
			return;
		}

		function save() {
			var data = tree.getChanges();
			for (var i = 0;i<data.length;i++){
				delete data[i]._id;
			}
			var json = mini.encode(data);
			var row = roleGrid.getSelected();
			if (row == null) {
				mini.alert("请先勾选一个角色");
				return;
			}
			var roleid = row.id;
			tree.loading("保存中，请稍后......");
			$
					.ajax({
						url : "${pageContext.request.contextPath}/rolePermission/saveRoleMenu.do",
						data : {
							data : json,
							roleid : roleid
						},
						type : "post",
						dataType:"json",
						success : function(text) {
							if (text.success) {
								mini.alert("授权成功");
							} else {
								mini.alert(text.msg);
							}
							tree.unmask();
						},
						error : function(jqXHR, textStatus, errorThrown) {
							mini.alert("授权失败");
							tree.unmask();
						}
					});
		}
	</script>

</body>
</html>