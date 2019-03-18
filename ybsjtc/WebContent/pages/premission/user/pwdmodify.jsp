<%@page contentType="text/html; charset=utf-8"%>
<%@page import="com.wondersgroup.framework.util.StringUtil"%>
<head>
<title>密码面板</title>
<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<%@ include file="/pages/include/header.jsp"%>
<style type="text/css">
html,body {
	font-size: 12px;
	padding: 0;
	margin: 0;
	border: 0;
	height: 100%;
	overflow: hidden;
	background-image: linear-gradient(rgba(196, 102, 0, 0.2), rgba(155, 89, 182, 0.2)), 
		url('${pageContext.request.contextPath}/images/gs.png');
}
</style>
</head>
<body>
	<form id="form1" method="post">
		<input name="id" class="mini-hidden" />
		<div style="padding-left: 5px; padding-bottom: 5px;">
			<table style="text-align: center;table-layout: fixed;width:100%;" >
				<tr height="40" class="operate">
				    <td width="80px"></td>
					<td style="width: 80px;color: #3399FF" align="center">新密码：</td>
					<td style="width: 150px;" align="left"><input name="password1"
						class="mini-password" required="true" autocomplete="off" /></td>
				</tr>
				<tr height="25" class="operate">
				    <td width="80px"></td>
					<td style="width: 80px;color: #3399FF" align="center">确认密码：</td>
					<td style="width: 150px;" align="left"><input name="password2"
						class="mini-password" required="true" autocomplete="off" /></td>
				</tr>
			</table>
		</div>
		<div class="operate" >
	   <button type="button" class="qd_color" onclick="onOk()"><span class="qd"></span>确定</button>
	   <button type="button" class="zh_z_color" onclick="onCancel()"><span class="zh_z"></span>取消</button>
	</div>
	</form>
	<script type="text/javascript">
        mini.parse();
        var form = new mini.Form("form1");
        var userid=null;
        function setData(data) {
           userid = data.id;
        }
        function SaveData() {
            var o = form.getData();            
            form.validate();
            if (form.isValid() == false) return;
            var  password1=mini.getbyName("password1").getValue().trim();
            var  password2=mini.getbyName("password2").getValue().trim();
            if(password1!=password2){
            mini.alert("两次密码输入不一致！");
            return  false;
            }
            //var json = mini.encode([o]);
            //alert(json);
            $.ajax({
                url: "${pageContext.request.contextPath}/login/doUpdatePwd.do",
				type: 'post',
                //data: { data: json },
                 data: { 
                  			userid:userid,
							password1 : password1,
							password2 : password2
						},
						cache : false,
						success : function(text) {
							console.log(text);
							if(text.success){
								mini.alert("密码修改成功！","成功",window.CloseOwnerWindow);
							}else if(!text.success){
								mini.alert(text.errors,"失败",window.CloseOwnerWindow);
							}
						},
						error : function(jqXHR, textStatus, errorThrown) {
							alert(jqXHR.responseText);
							CloseWindow();
						}
					});
		}

		function GetData() {
			var o = form.getData();
			return o;
		}
		function CloseWindow(action) {
			if (action == "close" && form.isChanged()) {
				if (confirm("数据被修改了，是否先保存？")) {
					return false;
				}
			}
			if (window.CloseOwnerWindow)
				return window.CloseOwnerWindow(action);
			else
				window.close();
		}
		function onOk(e) {
			SaveData();
		}
		function onCancel(e) {
			CloseWindow("cancel");
		}
	</script>
</body>
</html>
