<%@page contentType="text/html" pageEncoding="UTF-8"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	
		
		<script language="JavaScript" type="text/javascript">
		$(function() {
			$('.menuNav li').click(function() {
				$(this).addClass('cur').siblings().removeClass('cur');
			});
			$('.menuNav li:last').addClass('lastnobg');
			$(".menuNav").find("li").each(function(i){
				$(this).find("span").addClass("icon_0" + (i+1));
			});

		});
		function logoff() {
			 
				 
				if(confirm("是否真的注销？")){
					window.location.href = "${pageContext.request.contextPath}/login/doLoginout.do";
				}	
				
				 
		}

		function changePassword() {
			mini.open({
				url : "${pageContext.request.contextPath}/pages/pwdmodify.jsp",
				title : '修改密码',
				width : 380,
				height : 240,
				onload : function() {
					
				},
				ondestroy : function(action) {
					
				}
			});
			//top.selectLevel4Menu('password','${pageContext.request.contextPath}/pages/pwdModify.jsp','修改密码');
		}
		
		
		//getLevel2Menu();
	</script>
	</head>

	<body>

		<div class="header">
			<div class="headBox">
				 
				
						<ul class="menuNav fR">
						   <c:forEach items="${topMenuList}"  var="topMenu">
								<li>
									<a href="javascript:void(0)" onclick='getLevel2Menu("${topMenu.menu_id }")'>
										<span>
										    <em>   ${topMenu.menuname }   </em>  
										</span>
									</a>
								</li>
							</c:forEach>
						</ul>
					 
			 
				<h1 class="logo fL"></h1>
			</div>
		</div>		
		
		 
	</body>
</html>

