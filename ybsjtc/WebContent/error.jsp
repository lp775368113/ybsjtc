<%@ page contentType="text/html; charset=utf-8"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/resource/images/login/logo.ico"
	type="image/x-icon" />
<link rel="icon"
	href="${pageContext.request.contextPath }/resource/images/login/logo.ico"
	type="image/x-icon" />
<title>错误信息提示</title>

<script src="scripts/boot.js" type="text/javascript"></script> 
</head>
<body>
<br/><br/><br/><br/><br/><br/><br/><br/><br/>        
                
<div id="form1">
    <table align="center" >
        <tr>
            <td align="left">
            	<font color="red">
            		${requestScope.ERRORMSG}
				</font>
            </td>    
        </tr>
       
    </table>
</div>
<br/>
<p align="center">&copy; 禾川科技v1.0</p>
</body>
</html>