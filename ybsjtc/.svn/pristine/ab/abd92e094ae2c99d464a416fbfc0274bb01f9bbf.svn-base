<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title>工作区</title>
		<script type="text/javascript">
	function init() {
		document.contentForm.submit();
		//document.titleForm.submit();
	}	 
	  function changeScreen(){
		  parent.expandScreen();
      }
	 
</script>
	<link rel="stylesheet" href="<c:url value="/resource/css/style.css"/>" type="text/css" />
	</head>

	<body onload="init();"  style="overflow:hidden;margin:0;">
	    <em class="fR" style="padding:4px 5px 0 0;cursor:pointer;position: absolute;right: 0px;top: 1px;"> 
			  <img src="${pageContext.request.contextPath}/images/expand.gif" height="20" width="20" alt="全屏" onclick="changeScreen();" /> 
			</em>
		<FRAMESET frameborder="no" border="0" framespacing="0" rows="40,*" 	scrolling="no" style="overflow:hidden" noresize="noresize">
		 <!-- 	<iframe width="100%" height="30" name="t_titleFrame" frameborder="0"
				scrolling="no"  style="overflow:auto"></iframe>    -->
			<iframe width="100%" height="100%" name="t_contentFrame"
				frameborder="0" noresize="noresize"  style="overflow-y:auto"></iframe>
		</FRAMESET>
	 <!-- 	<form name="titleForm" action="<c:out value='${param.titleUrl}'/>"
			method="post" target="t_titleFrame"></form>   -->
		<form name="contentForm" action="<c:out value='${param.contentUrl}'/>"
			method="post" target="t_contentFrame"></form>
	</body>
</html>
