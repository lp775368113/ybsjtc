<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/main.css" />
		<script src="${pageContext.request.contextPath}/resource/assets/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/js/jQuery.rTabs.js"></script>

		<script type="text/javascript">
			$(function() {

				$("#tab2").rTabs({
					bind: 'click',
					animation: 'left'
				});

			})
		</script>
		<style>
			.tabs {
				position: relative;
				overflow: hidden;
				margin: 0 auto;
				width: 100%;
				font-weight: 300;
				font-size: 1.25em;
				height: 100%;
			}
			/* Nav */
			
			.tabs nav {
				text-align: center;
				border-bottom: none;
			}
			
			.tabs nav ul {
				position: relative;
				display: -ms-flexbox;
				display: -webkit-flex;
				display: -moz-flex;
				display: -ms-flex;
				display: block;
				margin: 0 auto;
				padding: 0;
				top: 0;
				list-style: none;
				-ms-box-orient: horizontal;
				-ms-box-pack: center;
				-webkit-flex-flow: row wrap;
				-moz-flex-flow: row wrap;
				-ms-flex-flow: row wrap;
				flex-flow: row wrap;
				-webkit-justify-content: center;
				-moz-justify-content: center;
				-ms-justify-content: center;
				justify-content: center;
			}
			
			.tabs nav ul li {
				width: 100px;
				height: 80px;
				position: relative;
				z-index: 1;
				display: block;
				margin: 0;
				text-align: center;
				/*-webkit-flex: 1;
	-moz-flex: 1;
	-ms-flex: 1;
	flex: 1;*/
			}
			
			.tabs nav a {
				position: relative;
				display: block;
				overflow: hidden;
				text-overflow: ellipsis;
				white-space: nowrap;
				line-height: 2.5;
				top: 0;
			}
			
			.tabs nav a span {
				vertical-align: middle;
				font-size: 0.75em;
			}
			
			.tabs nav li.tab-current a {
				color: #1d80b7;
			}
			
			.tabs nav a:focus {
				outline: none;
			}
			/* Content */
			
			.content-wrap {
				position: relative;
				height: 100%;
				width: calc(100% - 101px);
				float: right;
			}
			
			.content-wrap section {
				display: none;
				margin: 0 auto;
				height: 100%;
				text-align: center;
			}
			
			.content-wrap section.content-current {
				display: block;
			}
			
			.content-wrap section p {
				margin: 0;
				padding: 0.75em 0;
				color: rgba(40, 44, 42, 0.05);
				font-weight: 900;
				font-size: 4em;
				line-height: 1;
			}
			/* Fallback */
			
			.no-js .content-wrap section {
				display: block;
				padding-bottom: 2em;
				border-bottom: 1px solid rgba(255, 255, 255, 0.6);
			}
			
			.no-flexbox nav ul {
				display: block;
			}
			
			.no-flexbox nav ul li {
				min-width: 15%;
				display: inline-block;
			}
			
			@media screen and (max-width: 58em) {
				.tabs nav a.icon span {
					display: none;
				}
				.tabs nav a:before {
					margin-right: 0;
				}
			}
			
			.tabs-style-iconbox nav {
				background: #f9f9f9;
				width: 100px;
				height: 100%;
				border-right: 1px solid #e0eaea;
				float: left;
			}
			
			.tabs-style-iconbox nav ul li a {
				overflow: visible;
				/*padding: 1em 0;*/
				line-height: 1;
				-webkit-transition: color 0.2s;
				transition: color 0.2s;
				text-decoration: none;
				height: 80px;
				    color: #666;
			}
			
			.tabs-style-iconbox nav ul li a span {
				font-weight: 700;
				font-size: 0.7em;
			}
			
			.tabs-style-iconbox nav ul li.tab-current {
				z-index: 100;
			}
			
			.tabs-style-iconbox nav ul li.tab-current a {
				background: #e4f5f5;
				box-shadow: -1px 0 0 #fff;
				text-decoration: none;
			}
			
			.tabs-style-iconbox nav ul li.tab-current a::after {
				position: absolute;
				top: 50%;
				right: -20px;
				margin-top: -10px;
				width: 0;
				height: 0;
				border: solid transparent;
				border-width: 10px;
				border-top-color: #e4f5f5;
				content: '';
				pointer-events: none;
				transform: rotate(-90deg);
			}
			
			.tabs-style-iconbox nav ul li:first-child::before,
			.tabs-style-iconbox nav ul li::after {
				position: absolute;
				z-index: -1;
				width: 60%;
				height: 1px;
				background: rgba(0, 0, 0, 0.03);
				content: '';
				left: 50%;
				margin-left: -30%;
			}
			
			.tabs-style-iconbox nav ul li:first-child::before {
				right: auto;
				left: 0;
			}
			
			.tabs-style-iconbox .icon::before {
				display: block;
				margin: 0 0 0.25em 0;
			}
			
			.step_iframe {
				position: absolute;
				right: 0;
				top: 0;
				bottom: 0;
				width: 100%;
				height: 100%;
				z-index: 101;
				border: none;
				display: none;
			}
			.step-back{
				position: absolute;
				z-index: 102;
				display: none;
				animation: xx 0.6s;
			}
			@keyframes xx{
				from{left: 100%;}
				to{left: 0;}
			}
		</style>
	</head>

	<body>
		<div class="step-back">
			<img src="${pageContext.request.contextPath}/resource/assets/images/back.png" />
		</div>
		<iframe src="../pages/step.jsp" class="step_iframe"></iframe>
		<div class="tabs tabs-style-iconbox" style="position: absolute;">
			<nav>
				<ul>
					<li>
						<a href="#section-iconbox-1" class="">
							<div class="">
								<img src="${pageContext.request.contextPath}/resource/assets/images/system.png" />
							</div>
							<span>就医管理备案</span></a>
					</li>
					<li>
						<a href="#section-iconbox-2" class="">
							<div class="">
								<img src="${pageContext.request.contextPath}/resource/assets/images/system.png" />
							</div>
							<span>系统2</span></a>
					</li>

					<li>
						<a href="#section-iconbox-3" class="">
							<div class="">
								<img src="${pageContext.request.contextPath}/resource/assets/images/system.png" />
							</div>
							<span>系统3</span></a>
					</li>

				</ul>
			</nav>
			<div class="content-wrap">
				<section id="section-iconbox-1">
					<div class="iconbox-left-1">
						<div class="iconbox-search">
							<div class="search-q">
								<input type="text" placeholder="请输入关键词" />
								<div class="search-icon"></div>
							</div>
						</div>
						<div class="search_list">
							<div class="search_list_content">
								<div class="search_content">
									<ul>
										<li class="search_content_active">
											<a href="javascript:void(0);">
												1.基本医疗保险参保人员享受规定（特殊慢性）病种待遇备案
											</a>
										</li>
										<li>
											<a href="javascript:void(0);">
												2. 基本医疗保险参保人员异地就医备案
											</a>
										</li>
										<li>
											<a href="javascript:void(0);">
												3.基本医疗保险参保人员特治特药备案
											</a>
										</li>
										<li>
											<a href="javascript:void(0);">
												4.基本医疗保险参保人员转外就医备案
											</a>
										</li>
										<li>
											<a href="javascript:void(0);">
												5. 基本医疗保险参保人员出国（境）带药备案
											</a>
										</li>
										<li>
											<a href="javascript:void(0);">
												6. 基本医疗保险参保人员家庭病床备案
											</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>
					<div class="iconbox-right-1">
						<div class="tab" id="tab2">

							<div class="tab-nav j-tab-nav">

								<a href="javascript:void(0);" class="current">说明</a>
								<a href="javascript:void(0);">材料</a>
                                <a href="javascript:void(0);">流程</a>
							</div>

							<div class="tab-con">
								<div class="j-tab-con">
									<div class="tab-con-item" style="display:block;">
										<div class="content-right">1111</div>
										<div class="content-right-bottom">
											<button type="button" class="right-bottom">受理</button>
										</div>
									</div>
									<div class="tab-con-item">
										222222
									</div>
                                    <div class="tab-con-item">
                                    	
                                      <div class="chart">
										<div class="begin">
								            <span>开始</span>
							            </div>
							            <div class="arrow_triangle">
								            <div class="line_arrow"></div>
								           <span class="triangle_arrow"></span>
							            </div>
							            
							            <div class="step_1">
								            <span>零星报销</span>
							            </div>
							             <div class="arrow_triangle">
								            <div class="line_arrow"></div>
								           <span class="triangle_arrow"></span>
							            </div>
							             <div class="step_1">
								            <span>结算报销</span>
							            </div>
							            <div class="arrow_triangle">
								            <div class="line_arrow"></div>
								           <span class="triangle_arrow"></span>
							            </div>
							            <div class="begin">
								            <span>结束</span>
							            </div>
							            </div>
									</div>
								</div>
							</div>

						</div>
					</div>
				</section>
				<section id="section-iconbox-2">
					<p>2</p>
				</section>
				<section id="section-iconbox-3">
					<p>3</p>
				</section>

			</div>
			<!-- /content -->
		</div>
		<!-- /tabs -->

		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/js/cbpFWTabs.js"></script>
		<script>
			(function() {

				[].slice.call(document.querySelectorAll('.tabs')).forEach(function(el) {
					new CBPFWTabs(el);
				});

			})();

            /*展示效果写写的，记得重写*/
			$(document).ready(function() {
				$(".right-bottom").click(function() {
					$(".step_iframe").animate({
						width: 'toggle'
					}, 500);
					$(".step-back").css("display","block");
					$(".step-back").css("left","0");
				});
				$(".step-back").click(function() {
					$(".step_iframe").css("display","none");
					$(".step-back").css("display","none");
				});
				
			});
			
		</script>

	</body>

</html>