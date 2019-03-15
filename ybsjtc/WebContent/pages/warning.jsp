<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<meta charset="utf-8" />
		<title>禾川科技</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/xcConfirm.css"/>
		<script src="${pageContext.request.contextPath}/resource/scripts/jquery-1.10.0.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/resource/scripts/xcConfirm.js" type="text/javascript" charset="utf-8"></script>
		<style type="text/css">
			.sgBtn{width: 135px; height: 35px; line-height: 35px; margin-left: 10px; margin-top: 10px; text-align: center; background-color: #0095D9; color: #FFFFFF; float: left; border-radius: 5px;}
		</style>
		<script type="text/javascript">
		$(function(){
					var txt=  "您的账户当前没有权限，请联系管理员分配相关权限！";
					var option = {
						title: "登录警告",
						btn: parseInt("0001",2),
						onOk: function(){
							window.location.href="${pageContext.request.contextPath}/login.jsp"; 
						}
					}
					window.wxc.xcConfirm(txt, "custom", option);});
		</script>
	</head>
	<body>
	</body>
</html>
