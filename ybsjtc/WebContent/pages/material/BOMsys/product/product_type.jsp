<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>物料新增</title>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resource/scripts/jquery-1.10.0.min.js"></script> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/scripts/ajaxfileupload.js"></script>
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

#form2 table tr {
	height: 10px;
}
</style>
</head>
<body>

	<div class="mini-fit">
		<div class="mini-toolbar" style="text-align:center;line-height:30px;" 
        borderStyle="border-left:0;border-top:0;border-right:0;">
          <label >名称：</label>
          <input id="key" class="mini-textbox" style="width:150px;" onenter="onKeyEnter"/>
          <a class="mini-button" style="width:60px;" onclick="search()">查询</a>
    </div>
    <div class="mini-fit">
        
        <ul id="tree1" class="mini-tree" style="width:100%;height:100%;" 
        	url="${pageContext.request.contextPath}/dictionaries/getProductType.do"
            showTreeIcon="true" textField="text" idField="id" parentField="pid" resultAsTree="false"  
            expandOnLoad="true" onnodedblclick="onNodeDblClick" expandOnDblClick="false" 
            >
        </ul>
    
    </div>                
    <div class="mini-toolbar" style="text-align:center;padding-top:8px;padding-bottom:8px;" 
        borderStyle="border-left:0;border-bottom:0;border-right:0;">
        <a class="mini-button" style="width:60px;" onclick="onOk()">确定</a>
        <span style="display:inline-block;width:25px;"></span>
        <a class="mini-button" style="width:60px;" onclick="onCancel()">取消</a>
    </div>

	</div>
	<script type="text/javascript">
		mini.parse();
		 var tree = mini.get("tree1");
		 //tree.load();

		    function GetData() {
		        var node = tree.getSelectedNode();
		        return node;
		    }
		    function search() {
		        var key = mini.get("key").getValue();
		        if(key == ""){
		            tree.clearFilter();
		        }else{
		            key = key.toLowerCase();
		            tree.filter(function (node) {
		                var text = node.text ? node.text.toLowerCase() : "";
		                if (text.indexOf(key) != -1) {
		                    return true;
		                }
		            });
		        }
		    }
		    function onKeyEnter(e) {
		        search();
		    }
		    function onNodeDblClick(e) {
		        onOk();
		    }
		    //////////////////////////////////
		    function CloseWindow(action) {
		        if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
		        else window.close();
		    }

		    function onOk() {
		        var node = tree.getSelectedNode();
		        if (node && tree.isLeaf(node) == false) {
		            alert("不能选中父节点");
		            return;
		        }

		        CloseWindow("ok");        
		    }
		    function onCancel() {
		        CloseWindow("cancel");
		    }
	</script>
</body>

</html>