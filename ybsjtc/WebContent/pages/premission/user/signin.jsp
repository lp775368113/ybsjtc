<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/resource/css/signin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/xcConfirm.css"/>
<html xmlns="http://www.w3.org/1999/xhtml">


</head>
<form id="msform">
	<!-- progressbar -->
	<ul id="progressbar">
		<li class="active">第一步</li>
		<li>第二步</li>
		<li>第三步</li>
	</ul>
	<!-- fieldsets -->
	<fieldset>
		<h2 class="fs-title">创建您的帐号</h2>		
		<input type="text" id="loginname" name="loginname" placeholder="用户名" />
		<input type="password" id="password" name="password" placeholder="密码" />
		<input type="password" id="cpassword" name="cpassword" placeholder="确认密码" />
		<input type="button" name="next" class="next action-button" value="下一步" />
	</fieldset>
	<fieldset>
		<h2 class="fs-title">填写信息</h2>		
		<input type="text" name="email" placeholder="邮箱" />
		<input type="text" name="mininame" placeholder="昵称" />
		<input type="text" name="mobilephone" placeholder="手机号" />
		<input type="button" name="previous" class="previous action-button" value="上一步" />
		<input type="button" name="next" class="next action-button" value="下一步" />
	</fieldset>
	<fieldset>
		<h2 class="fs-title">填写信息</h2>		
		<input type="text"  id="vsername" name="vsername" placeholder="真实姓名" />
		<textarea name="address" placeholder="通讯住址"></textarea>
		<input type="button" name="previous" class="previous action-button" value="上一步" />
		<input type="button" name="submit"  onclick="tj()" class="submit action-button" value="提交" />
	</fieldset>
</form>
<script src="${pageContext.request.contextPath}/resource/scripts/jquery-1.10.0.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/scripts/xcConfirm.js" type="text/javascript" charset="utf-8"></script>
<script src="${pageContext.request.contextPath}/resource/scripts/jquery.easing.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resource/scripts/jQuery.time.js" type="text/javascript"></script>
<br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br>

</body>
</html>