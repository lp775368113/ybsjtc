<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html lang="en">

	<head>
		<meta charset="UTF-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<script src="${pageContext.request.contextPath}/resource/assets/js/jquery-1.8.3.min.js"></script>
		<link rel="stylesheet" media="screen" href="${pageContext.request.contextPath}/resource/assets/css/main.css" />
		<title></title>
	</head>

	<body>

		
			<div class="divTop">
				<div class="msform">
					<ul id="progressbar">
						<li class="active">选择列表</li>
						<li>xxxx</li>
						<li>xxxx</li>
					</ul>
					
					<fieldset>
						<div class="search_content">
									<ul>
										<li>
											<a href="#">
												社会保险参保登记   
											</a>
										</li>
										<li>
											<a href="#">
												  基本医疗保险参保人员就医管理备案
											</a>
										</li>
										<li>
											<a href="#">
												定点医药机构协议管理申请登记
											</a>
										</li>
										<li>
											<a href="#">
												申请办理基本医疗保险关系转移接续
											</a>
										</li>
										<li>
											<a href="#">
												 基本医疗保险待遇核准支付
											</a>
										</li>
									</ul>
								</div>
						<input type="button" class="next action-button" value="下一步" />
					</fieldset>
					<fieldset>
						<div class="search_content">
									<ul>
										<li>
											<a href="#">
												社会保险参保登记   
											</a>
										</li>
										<li>
											<a href="#">
												  基本医疗保险参保人员就医管理备案
											</a>
										</li>
										<li>
											<a href="#">
												定点医药机构协议管理申请登记
											</a>
										</li>
										<li>
											<a href="#">
												申请办理基本医疗保险关系转移接续
											</a>
										</li>
										<li>
											<a href="#">
												 基本医疗保险待遇核准支付
											</a>
										</li>
									</ul>
								</div>
						<input type="button" class=" action-button previous" value="上一步" />
						<input type="button" class="next action-button" value="下一步" />
					</fieldset>
					<fieldset>
						<div class="search_content">
									<ul>
										<li>
											<a href="">
												社会保险参保登记   
											</a>
										</li>
										<li>
											<a href="">
												  基本医疗保险参保人员就医管理备案
											</a>
										</li>
										<li>
											<a href="">
												定点医药机构协议管理申请登记
											</a>
										</li>
										<li>
											<a href="">
												申请办理基本医疗保险关系转移接续
											</a>
										</li>
										<li>
											<a href="">
												 基本医疗保险待遇核准支付
											</a>
										</li>
									</ul>
								</div>
						<input type="button" class=" action-button previous" value="上一步" />
						<input type="button" class=" action-button" value="提交" />

					</fieldset>
				</div>
			</div>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/js/jquery.easing.min.js"></script>
		<script>
			var current_fs, next_fs, previous_fs;
			var left, opacity, scale;
			var animating;

			$(".next").click(function() {
				if(animating) return false;
				animating = true;

				current_fs = $(this).parent();
				next_fs = $(this).parent().next();

				$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");

				next_fs.show();

				current_fs.animate({
					opacity: 0
				}, {
					step: function(now, mx) {

						scale = 1 - (1 - now) * 0.2;

						left = (now * 50) + "%";

						opacity = 1 - now;
						current_fs.css({
							'transform': 'scale(' + scale + ')'
						});
						next_fs.css({
							'left': left,
							'opacity': opacity
						});
					},
					duration: 800,
					complete: function() {
						current_fs.hide();
						animating = false;
					},

					easing: 'easeInOutBack'
				});
			});

			$(".previous").click(function() {
				if(animating) return false;
				animating = true;

				current_fs = $(this).parent();
				previous_fs = $(this).parent().prev();

				$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");

				previous_fs.show();

				current_fs.animate({
					opacity: 0
				}, {
					step: function(now, mx) {

						scale = 0.8 + (1 - now) * 0.2;

						left = ((1 - now) * 50) + "%";

						opacity = 1 - now;
						current_fs.css({
							'left': left
						});
						previous_fs.css({
							'transform': 'scale(' + scale + ')',
							'opacity': opacity
						});
					},
					duration: 800,
					complete: function() {
						current_fs.hide();
						animating = false;
					},

					easing: 'easeInOutBack'
				});
			});

			$(".submit").click(function() {
				return false;
			});
			
			
		</script>
	</body>

</html>