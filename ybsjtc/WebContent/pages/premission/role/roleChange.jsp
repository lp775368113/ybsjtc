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
    <input class="mini-hidden" id="userid" name="userid" />
    <table>
        <tr>
            <td>
                <div id="grid1" class="mini-datagrid"
                    style="width:350px;height:350px;" multiSelect="true"
                    showReloadButton="false"
                    url="${pageContext.request.contextPath}/role/queryRole.do"
                    resultAsData="true">
                    <div property="columns">
                        <div type="checkcolumn"></div>
                        <div field="name" width="80%" headerAlign="center" align="center">角色名称</div>
                    </div>
                </div>
            </td>
            <td align="center"><input type="button" 
				value=">" onclick="adds()" style="width:40px;" /><br /> <br /> <input
				type="button" value="&lt;" onclick="removes()" style="width:40px;" /> 
				<br /> <br /> <input
				type="button" value="保存" onclick="saveData()" style="width:40px;" /> 
			</td> 
            <td>
                <div id="grid2" class="mini-datagrid"
                    style="width:350px;height:350px;" multiSelect="true"
                    showReloadButton="false" 
                    url="${pageContext.request.contextPath}/role/queryRole.do"
                    allowCellEdit="true" allowCellSelect="true">
                    <div property="columns">
                        <div type="checkcolumn"></div>
                        <div field="name" width="80%" headerAlign="center" align="center">角色名称</div>
                    </div>
                </div>
            </td>
        </tr>

    </table>
    <script type="text/javascript">
        mini.parse();
        var grid1 = mini.get("grid1");
        var grid2 = mini.get("grid2");

        function setData(data) {
            grid1.load();
            grid2.load({
                userid : data.id
            });
            mini.get("userid").setValue(data.id);
        }

        function doAddItems(items) {
            items = mini.clone(items);

            //根据id判断，去除重复的item
            for ( var i = items.length - 1; i >= 0; i--) {
                var item = items[i];
                var item2 = grid2.findRow(function(row) {
                    if (row.id == item.id)
                        return true;
                });
                if (item2) {
                    items.removeAt(i);
                }
            }

            grid2.addRows(items,0);
        }

        function adds() {
            var items = grid1.getSelecteds();
            doAddItems(items);
        }
        function addAll() {
            var items = grid1.getData();
            doAddItems(items);
        }
        function removes() {
            var items = grid2.getSelecteds();
            grid2.removeRows(items);
        }
        function removeAll() {
            var items = grid2.getData();
            grid2.removeRows(items);
        }
        function saveData() {
            var data = grid2.getChanges();
            for (var i = 0;i<data.length;i++){
				delete data[i]._id;
			}
            var json = mini.encode(data);
            var userid = mini.get("userid").getValue();
            mini.mask({
                el: document.body,
                cls: 'mini-mask-loading',
                html: '保存中，请稍候...'
            });
            $
                    .ajax({
                        url : "${pageContext.request.contextPath}/role/changeUserRole.do",
                        data : {
                            data : json,
                            userid : userid
                        },
                        type : "post",
                        dataType:"json",
                        success : function(text) {
                            if (text.success) {
                            	mini.showMessageBox(	
        								{
        								    title: '提示',    
        								    message: '保存成功',
        								    buttons: ["确定"],    
        								    iconCls: "mini-messagebox-info",
        								    callback: function(action){
        								    	window.CloseOwnerWindow();
        								    }
        								});
                            } else {
                                mini.alert(text.msg);
                            }
                            mini.unmask();
                        },
                        error : function(jqXHR, textStatus, errorThrown) {
                            mini.alert("保存失败");
                            mini.unmask();
                        }
                    });
        }
    </script>

</body>
</html>