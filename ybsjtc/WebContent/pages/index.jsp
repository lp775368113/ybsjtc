<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 
<%@page import="com.wondersgroup.permission.user.vo.User"%>
<%@page import="com.wondersgroup.framework.comwork.controller.SessionConstants"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/pages/include/header.jsp"%>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta/>
		<title>禾川科技</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/bootstrap.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/ace.css" class="ace-main-stylesheet" id="main-ace-style" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/main.css" />
		<link href="${pageContext.request.contextPath}/resource/assets/css/style.css" type="text/css" rel="stylesheet" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/font.css" />
		<!-- 截图功能js引入 -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/crx/jquery-3.2.1.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/crx/nbwdCapture.js"></script>
	<%
	User loginUser = ( User)request.getSession().getAttribute(SessionConstants.CW_LOGINUSER);
	%>	
		
	<script type="text/javascript" >
		  $(document).ajaxComplete(function (evt, request, settings) {
		      var text = request.responseText;
		      
		      if( text.substring(0,2) != '[{' && text.substring(0,1) != '{'){
		    	   
		      	return ;
		      }
		     
		      var ret = mini.decode(text);
		      // alert(text);
		      if (ret.sessionstatus == "timeout") {
		       top.location = '${pageContext.request.contextPath}/login.jsp';
		      }
		      
		      
		      if (ret.code == '500') {
		          alert(ret.msg);
		          return;
		      }
		  });
		 
		  </script>	
	
	</head>



	<body class="no-skin">
		<!-- <button type="button" id="jietu" class="cx_color" onclick="capture(1)"><span class="cx"></span>截屏</button> -->
		<div id="navbar" class="navbar navbar-default">
			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left" title="禾川科技">
					<a href="#" class="navbar-brand">
						<small>
							<img  src="${pageContext.request.contextPath}/resource/assets/images/logo.png" width="40px" height="40px" />
							<span style="position: relative;top: -10px;">禾川科技</span>
						</small>
					</a>

				</div>
				
				<div class="navbar-buttons navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li class="purple">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon icon-notice icon-animated-bell"></i>
								<span class="badge badge-important">8</span>
							</a>

						</li>

						<li class="green">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="ace-icon icon-news icon-animated-vertical"></i>
								<span class="badge badge-success">5</span>
							</a>

						</li>

						<!-- #section:basics/navbar.user_menu -->
						<li class="light-blue">
							<a data-toggle="dropdown" href="#" class="dropdown-toggle">
								<span class="user-info">
									<%=loginUser.getLoginname()%>
								</span>
								<i class="ace-icon icon-drop-down"></i>
								<span class="user_head">
									<!--<img class="nav-user-photo" src="../assets/images/member1.jpg"  />-->
									<div><%=loginUser.getVsername().substring(0,1)%></div>
								</span>

							</a>

							<div class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<div class="user_content">
									<div class="head_bg"></div>
									<div class="head_content">
										<div class="user_head_z">
											<!--<img src="images/member1.jpg" style="width: 100%;">-->
											<div class=""><%=loginUser.getVsername().substring(0,1)%></div>
										</div>
										<div class="user_head_text">
											<div>欢迎，<span><%=loginUser.getVsername()%></span>
											</div>
										</div>
									</div>
									<div class="apply">
										<div class="latest_apply">
											常用应用
										</div>
										<div class="apply_content">
											<div class="apply_item">
												<div class="apply_icon">
													<img src="${pageContext.request.contextPath}/resource/assets/images/NBSJZX_UAS.png" style="width:22px;" />
												</div>
												<div class="apply_icon_text">权限管理</div>
											</div>

										</div>
									</div>
									<div class="bottom">
										<div class="latest_apply">待办事项</div>
										<div class="weui_broken_line" id="insured"></div>
									</div>
                                  
									<div class="exit">
										<a href="javascript:" onClick="pwdmodify()">
										<div class="exit_item"><i class="bj"></i>密码修改</div>
										</a>
										<a href="${pageContext.request.contextPath}/login/doLoginout.do" style="text-decoration: none;">
										<div class="exit_item"><i class="exit_icon"></i> 立即注销</div>
										 </a>
									</div>
								  
								</div>
							</div>
						</li>

					</ul>
				</div>

			</div>
		</div>
		<div class="main-container" id="main-container">
			<div id="sidebar" class="sidebar  responsive">
				<ul class="nav nav-list">
					<li class="active">
						<a class=""></a>
						<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
							<i class="ace-icon icon-list2" data-icon1="ace-icon icon-list2" data-icon2="ace-icon icon-list"></i>
						</div>
					</li>
					
					
					<c:forEach items="${topMenuList}" var="topMenu"> 
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon icon-acceptance"></i>
							<span class="menu-text">
								${topMenu.name}
							</span>

							<b class="arrow icon-more-unfold"></b>
						</a>
						<b class="arrow"></b>
						<ul class="submenu">
						<c:forEach items="${topChildMenuList}" var="topChildMenu">
							<c:if test="${ topChildMenu.key == topMenu.id}">
								<c:forEach items="${topChildMenu.value}" var="topChildMenuValue"> 
									<li class="" onclick='showTab("${topChildMenuValue.id}","${pageContext.request.contextPath}/${topChildMenuValue.url}","${topChildMenuValue.name}");'>
										<a href="javascript:void(0);">
											<i class="menu-icon fa fa-caret-right"></i>${topChildMenuValue.name} 
										</a>
										<b class="arrow"></b>
									</li>
								 </c:forEach>
							</c:if>
						</c:forEach>
						</ul>
					</li>
				</c:forEach>

				</ul>

				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'collapsed')
					} catch(e) {}
				</script>
			</div>
	
			<!-- /section:basics/sidebar -->

			<div class="main-content-inner">
				<div class="tabs tabs-style-tzoid">
					<nav>
						<ul id="menu-box">
							<li id="menu-box-sy">
								<a href="#section-tzoid-sy" class="icon icon-home"><span>首页</span></a>
							</li>
						</ul>
						<!-- <span id="tabs_more" class="tabs_more">[+]</span> 
						<div id="tabs_more_content" class="tabs_more_content">
							<div id="tabs_more_content-sy" class="more_item">首页</div>
						</div>
						-->
						<div class="tool">
							<div class="tool_line"></div>
							<div class="close icon-close1" title="关闭"></div>
						</div>
					</nav>
					<div class="content-wrap" id="menu-section">
						<iframe src="../pages/warning.jsp" class="warning_iframe"></iframe>
						<iframe src="../pages/picture.jsp" class="picture_iframe"></iframe>
						<section id="section-tzoid-sy">
							<iframe src="../pages/leader.jsp"></iframe>
						</section>
					</div>
					<!-- /content -->
				</div>
				<!-- /tabs -->
			</div>
		</div>

			<!--[if !IE]> -->
			<script type="text/javascript">
				window.jQuery || document.write("<script src='${pageContext.request.contextPath}/resource/assets/js/jquery.js'>" + "<" + "/script>");
			</script>

			<script src="${pageContext.request.contextPath}/resource/assets/js/bootstrap.js"></script>
			<script src="${pageContext.request.contextPath}/resource/assets/js/ace/ace.js"></script>
			<script src="${pageContext.request.contextPath}/resource/assets/js/ace/ace.sidebar.js"></script>
			<script src="${pageContext.request.contextPath}/resource/assets/js/jquery-1.8.3.min.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/js/cbpFWTabs.js"></script>
			<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/js/echarts.common.js"></script>
			<script>
			/*顶层中的ctrl+s 截屏事件*/
			document.onkeydown = function(e) {
		        var keyCode = e.keyCode || e.which || e.charCode;
		        var ctrlKey = e.ctrlKey || e.metaKey;
		        if(ctrlKey) {
		        	if(keyCode == 83){
		            	capture(1);
		            	return false;
		        	}
		        }else {
		            	return true;
		        }
		    };
			
				(function() {

					[].slice.call(document.querySelectorAll('.tabs')).forEach(function(el) {
						new CBPFWTabs(el);
					});

				})();
			</script>
			<script>
				top["mini.jsp"]=window;
				$("#menu-box-sy").click(function() {
					$(".tabs-style-tzoid li").not("#menu-box-sy").removeClass("tab-current");
					$(".content-wrap section").not("#section-tzoid-sy").removeClass("content-current");
					$("#menu-box-sy").addClass("tab-current");
					$("#section-tzoid-sy").addClass("content-current");
				});
				$("#tabs_more_content-sy").click(function() {
					$(".tabs-style-tzoid li").not("#menu-box-sy").removeClass("tab-current");
					$(".content-wrap section").not("#section-tzoid-sy").removeClass("content-current");
					$("#menu-box-sy").addClass("tab-current");
					$("#section-tzoid-sy").addClass("content-current");
					document.getElementById("tabs_more_content").style.display="none";
					document.getElementById("tabs_more").innerHTML="[+]";
					tabs_moreX=0;
				});
			
				function showTab(menuid,url,menuname) {
					$("#menu-box-"+menuid).remove();
					$("#menu-box-sy").after('<li id="menu-box-'+menuid+'" style="display: none;"><a href="#section-tzoid-'+menuid+'" class="icon icon-box"><span>'+menuname+'</span></a></li>');
					if(document.getElementById("section-tzoid-"+menuid)==null||typeof(document.getElementById("section-tzoid-"+menuid))=="undefined"){
						$("#section-tzoid-sy").after('<section id="section-tzoid-'+menuid+'" style="display: none;"><iframe src="'+url+'"></iframe></section>');
					}
					[].slice.call(document.querySelectorAll('.tabs')).forEach(function(el) {
						new CBPFWTabs(el);
					});
					$("#menu-box-"+menuid).click(function() {
						$(".tabs-style-tzoid li").not("#menu-box-"+menuid).removeClass("tab-current");
						$(".content-wrap section").not("#section-tzoid-"+menuid).removeClass("content-current");
						$("#menu-box-"+menuid).addClass("tab-current");
						$("#section-tzoid-"+menuid).addClass("content-current");
					});
					$(".tabs-style-tzoid li").removeClass("tab-current");
					$("#menu-box-"+menuid).addClass("tab-current");
					$(".content-wrap section").removeClass("content-current");
					$("#section-tzoid-"+menuid).addClass("content-current");
					$("#menu-box-"+menuid).show();
					$("#section-tzoid-"+menuid).show();
					
					$("#tabs_more_content-"+menuid).remove();
					$("#tabs_more_content").append('<div id="tabs_more_content-'+menuid+'" class="more_item">'+menuname+'</div>');
					$("#tabs_more_content-"+menuid).click(function() {
						$("#menu-box-"+menuid).remove();
						$("#menu-box-sy").after('<li id="menu-box-'+menuid+'" style="display: none;"><a href="#section-tzoid-'+menuid+'" class="icon icon-box"><span>'+menuname+'</span></a></li>');
						[].slice.call(document.querySelectorAll('.tabs')).forEach(function(el) {
							new CBPFWTabs(el);
						});
						$("#menu-box-"+menuid).click(function() {
							$(".tabs-style-tzoid li").not("#menu-box-"+menuid).removeClass("tab-current");
							$(".content-wrap section").not("#section-tzoid-"+menuid).removeClass("content-current");
							$("#menu-box-"+menuid).addClass("tab-current");
							$("#section-tzoid-"+menuid).addClass("content-current");
						});
						$(".tabs-style-tzoid li").removeClass("tab-current");
						$("#menu-box-"+menuid).addClass("tab-current");
						$(".content-wrap section").removeClass("content-current");
						$("#section-tzoid-"+menuid).addClass("content-current");
						$("#menu-box-"+menuid).show();
						$("#section-tzoid-"+menuid).show();
						document.getElementById("tabs_more_content").style.display="none";
						document.getElementById("tabs_more").innerHTML="[+]";
						tabs_moreX=0;
					});
				}
				
				$(".icon-close1").click(function() {
					var index = $('.tabs-style-tzoid li.tab-current').index();
					$(".tabs-style-tzoid li.tab-current").not(".tabs-style-tzoid li:nth-child(1)").remove();
					var removeMenuId = $(".content-current").attr("id").substring(14);
					$("#tabs_more_content-"+removeMenuId).remove();
					$(".content-current").not("#section-tzoid-sy").remove();
					$(".tabs-style-tzoid li:nth-child("+index+")").addClass("tab-current");
					if(index >1){
						 var beforeMenuId = $(".tabs-style-tzoid li:nth-child("+index+")").attr("id").substring(9);
						 $("#section-tzoid-"+beforeMenuId).addClass("content-current");
					}else{
						 $("#section-tzoid-sy").addClass("content-current");
					 }
		 
			 
				});
				$(document).ready(function() {
					$(".history2").click(function() {
						$(this).toggleClass('blue');
						$(".picture_iframe").animate({
							width: 'toggle',
						}, 500);
						
					});
				});
				$(document).ready(function() {
					$(".warning2").click(function() {
						$(this).toggleClass('red');
						$(".warning_iframe").animate({
							width: 'toggle'
						}, 500);
					});
				});
				var tabs_moreX=0;
				$(document).ready(function() {
					$("#tabs_more").click(function() {
						$("#tabs_more_content").toggle({
							width: 'toggle'
						},0);
						if(tabs_moreX==0){
							document.getElementById("tabs_more").innerHTML="[-]";
							tabs_moreX=1;
						}else{
							document.getElementById("tabs_more").innerHTML="[+]";
							tabs_moreX=0;
						}
						
					});
				});
			</script>
            <script type="text/javascript">
			var myChart = echarts.init(document.getElementById('insured'));
			option = {
				title: {
					text: '',
					subtext: '',
					x: 'center'
				},
				tooltip: {
					trigger: 'item',
					formatter: "{a} <br/>{b} : {c} ({d}%)"
				},
				series: [{
					name: '工作情况',
					type: 'pie',
					radius: '55%',
					center: ['50%', '60%'],
					data: [{
							value: 835,
							name: '管理',
							itemStyle: {
								normal: {
									color: '#3498db',
								}
							},
						}, {
							value: 310,
							name: '报销',
							itemStyle: {
								normal: {
									color: '#11CD6E',
								}
							},
						}, {
							value: 234,
							name: '事项',
							itemStyle: {
								normal: {
									color: '#e74c3c',
								}
							},
						}, {
							value: 135,
							name: '考勤',
							itemStyle: {
								normal: {
									color: '#e67e22',
								}
							},
						},

					],
					itemStyle: {
						emphasis: {
							shadowBlur: 10,
							shadowOffsetX: 0,
							shadowColor: 'rgba(0, 0, 0, 0.5)'
						}
					}
				}]
			};
			myChart.setOption(option);
			
		</script>
		<script type="text/javascript">
		 mini.parse();
			function capture(menuid) {
				nbwd.captureAsSave();
				return ;
			}
			function pwdmodify() {
				mini.open({
							url : "${pageContext.request.contextPath}/pages/premission/user/pwdmodify.jsp",
							title : "修改密码",
							width : 420,
							height : 200,
							onload : function() {
								var iframe = this.getIFrameEl();
								//调用弹出页面方法进行初始化
								iframe.contentWindow.setData({
									mode : "edit",
									id : <%=loginUser.getId() %>,
								});
							}
						});
			}
		</script>
	</body>

</html>