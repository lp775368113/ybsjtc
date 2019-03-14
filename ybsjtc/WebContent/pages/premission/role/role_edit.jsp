<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>角色编辑页面</title>

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
        <table class="table" border="0" width="100%">
            <tr>
                <th class="mini_title">标识：</th>
                <td><input id="id" name="id" class="mini-textbox"
                    allowInput="false" width="80%" /></td>
            </tr>
            <tr>
                <th class="mini_title">名称：</th>
                <td><input id="name" name="name" class="mini-textbox"
                    required="true" width="80%" /></td>
            </tr>
            <tr>
                <th class="mini_title">描述：</th>
                <td><input id="description" name="description"
                    class="mini-textarea" width="80%" /></td>
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
                if (mode == "add") {
                    return;
                }
                var form = new mini.Form("#form1");
                $
                        .ajax({
                            url : "${pageContext.request.contextPath}/uaasRole/getUaasRole.do",
                            data : {
                                id : data.id
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
                if (mode == "add") {
                    url = "${pageContext.request.contextPath}/uaasRole/saveUaasRole.do"
                } else if (mode == "edit") {
                    url = "${pageContext.request.contextPath}/uaasRole/updateUaasRole.do"
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
                            window.CloseOwnerWindow();
                        } else {
                            mini.alert(text.msg);
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