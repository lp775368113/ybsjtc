<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>用servlet显示base64编码的图片</title>
</head>
<body>
<input value="1"  id ='errid' name='errid' />
<button id="btn" onclick="downloadPic()">展示截屏</button>
<br/>
<img  id="myimage" src="#" />

<script type="text/javascript">

function downloadPic(){
	var erridval = document.getElementById("errid").value;
	$.ajax({
		url : "${pageContext.request.contextPath}/common/DownPic.do",
		type : "post",
		data : {errid:erridval
		},
		dataType : "text",
		success : function(text) {
			o = mini.decode(text);
			var element = document.getElementById('myimage');
			element.src = o.BASE64;
		},
		error : function() {
			//mini.alert("调取存储过程失败");
		}
	});
}
</script>
</body>
</html>