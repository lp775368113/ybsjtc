<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>菜单管理</title>

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
	<div class="mini-fit">
		<div class="mini-splitter" style="width:100%;height:100%;">
			<div size="30%" showCollapseButton="true" style="padding:5px;">
				<ul id="tree1" class="mini-tree"
					url="${pageContext.request.contextPath}/menu/listMenu.do"
					style="width:100%;height:100%;padding:5px;" showTreeIcon="true"
					textField="text" idField="id" parentField="pid"
					resultAsTree="false"
					imgPath="${pageContext.request.contextPath}/images/"
					contextMenu="#treeMenu" showArrow="true" expandOnNodeClick="false"
					expandOnLoad="false" onbeforeexpand="onBeforeExpand">
				</ul>
				<ul id="treeMenu" class="mini-contextmenu"
					onbeforeopen="onBeforeOpen">
					<li name="add" iconCls="icon-add" onclick="AddNodeOne">新增菜单</li>
					<li name="add" iconCls="icon-add" onclick="AddNodeTwo">新增子菜单</li>
					<li name="edit" iconCls="icon-edit" onclick="onEditNode">编辑菜单</li>
					<li name="remove" iconCls="icon-remove" onclick="onRemoveNode">删除菜单</li>
				</ul>
			</div>
			<div showCollapseButton="true">
				<fieldset id="fd1" style="width:600px;">
					<legend>
						<span>菜单信息</span>
					</legend>
					<div id="form1">
						<table  class="main-table" border="0" width="100%">
							<tr>
								<td class="mini_title">标识：</td>
								<td><input id="id" name="id"
									class="mini-textbox" allowInput="false" width="70%" /></td>
							</tr>
							<tr>
								<td class="mini_title">代码：</td>
								<td><input id="code" name="code"
									class="mini-textbox" width="70%" /></td>
							</tr>
							<tr>
								<td class="mini_title">名称：</td>
								<td><input id="name" name="name"
									class="mini-textbox" required="true" width="70%" /></td>
							</tr>
							<tr>
								<td class="mini_title">URL：</td>
								<td><input id="url" name="url"
									class="mini-textbox" width="70%" /></td>
							</tr>
							<tr>
								<td class="mini_title">图标1：</td>
								<td><input id="icon1" name="icon1"
									class="mini-textbox" width="70%" /></td>
							</tr>
							<tr>
								<td class="mini_title">图标2：</td>
								<td><input id="icon2" name="icon2"
									class="mini-textbox" width="70%" /></td>
							</tr>
							<tr>
								<td class="mini_title">图标3：</td>
								<td><input id="icon3" name="icon3"
									class="mini-textbox" width="70%" /></td>
							</tr>
							<tr>
								<td class="mini_title">描述：</td>
								<td><input id="description" name="description"
									class="mini-textbox" width="70%" /></td>
							</tr>
							<tr>
								<td class="mini_title">排序：</td>
								<td><input id="priority" name="priority"
									class="mini-textbox" width="70%" /></td>
							</tr>
						</table>
					</div>
				</fieldset>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		mini.parse();
		var tree = mini.get("tree1");
        tree.on("nodeclick", view);
        function onBeforeExpand(e) {
            var tree = e.sender;
            var nowNode = e.node;
            var root = tree.getRootNode();

            tree.cascadeChild(root, function (node) {
                if (tree.isExpandedNode(node)) {
                    if (node != nowNode && !tree.isAncestor(node, nowNode)) {
                        tree.collapseNode(node, true);
                    }
                }
            });

        }

    function AddNodeOne(e) {
        var node = tree.getSelectedNode();

        if (!node) {
            mini.alert("请选择一个菜单");
            return;
        }

        mini.open({
            url: "${pageContext.request.contextPath}/pages/premission/menu/menu_edit.jsp",
            title: "新增菜单", width: 420, height: 300,
            onload: function() {
                var iframe = this.getIFrameEl();
                //调用弹出页面方法进行初始化
                iframe.contentWindow.setData({mode:"addone",id:node.id,type:node.type});
            },
            ondestroy: function (action) {
            	tree.load ();
            }
        });
    }
    
    function AddNodeTwo(e) {
        var node = tree.getSelectedNode();

        if (!node) {
            mini.alert("请选择一个菜单");
            return;
        }
        if(node.type=="2"){
            mini.alert("最多只能建立二级菜单");
            return;
        }
        mini.open({
            url: "${pageContext.request.contextPath}/pages/premission/menu/menu_edit.jsp",
            title: "新增子菜单", width: 420, height: 300,
            onload: function() {
                var iframe = this.getIFrameEl();
                //调用弹出页面方法进行初始化
                iframe.contentWindow.setData({mode:"addtwo",id:node.id,type:node.type});
            },
            ondestroy: function (action) {
            	tree.load ();
            }
        });
    }

    function onEditNode(e) {
        var node = tree.getSelectedNode();

        if (!node) {
            mini.alert("请选择一个菜单");
            return;
        }
        

        mini.open({
            url: "${pageContext.request.contextPath}/pages/premission/menu/menu_edit.jsp",
            title: "编辑菜单", width: 420, height: 300,
            onload: function() {
                var iframe = this.getIFrameEl();
                //调用弹出页面方法进行初始化
                iframe.contentWindow.setData({mode:"edit",id:node.id});
            },
            ondestroy: function (action) {
            	tree.load ();
            }
        });
    }

    function upDateNode(options){
        var node = tree.getSelectedNode();
        options = mini.clone(options);
        tree.updateNode(node,options)
    }

    function addDateNode(options){
        var node = tree.getSelectedNode();
        options = mini.clone(options);
        var newNode = options;
        tree.addNode(newNode, "add", node);
    }
    

    function onRemoveNode(e) { 
        var node = tree.getSelectedNode();

        if (!node) {
            mini.alert("请选择要删除的菜单");
            return;
        }

        mini.confirm("确定删除选中菜单?", "确认删除", function(btn) {
            if(btn === 'ok') {
                $.ajax({
                    url: "${pageContext.request.contextPath}/menu/removeUaasMenu.do",
                    data: { id: node.id },
                    type: "post",
                    dataType:"json",
                    success: function (text) {
                        if(text.success) {
                            mini.showMessageBox({
                                title: "提示",
                                message: "提交成功",
                                buttons: ["确定"],
                                iconCls: "mini-messagebox-info",
                                callback: function(action){
                                tree.removeNode(node);
                                }
                            }); 
                        } else {
                            mini.alert(text.msg);
                        }
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        alert(jqXHR.responseText);
                    }
                });
            }
        });
    }

    function view() {
        var node = tree.getSelectedNode();
		
        if (!node) {
            return;
        }

        var form = new mini.Form("#form1");

        $.ajax({
            url: "${pageContext.request.contextPath}/menu/getMenu.do",
            data: {menuid: node.id },
            type: "post",
            dataType:"json",
            success: function (text) {
                if(text.success) {
                    var form = new mini.Form("#form1");
                    form.setData(text.data);
                } else {
                    mini.alert(text.msg);
                }
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
            }
        });
    }

    function onBeforeOpen(e) {
        var menu = e.sender;

        var node = tree.getSelectedNode();
        if (!node) {
            e.cancel = true;
            return;
        }
    }
	</script>

</body>
</html>