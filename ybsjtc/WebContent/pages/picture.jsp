<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/main.css" />
		

	</head>

	<body>
		<div class="search-picture">
			<div class="search-p">
				<input type="text" placeholder="请输入关键词">
				<div class="search-icon"></div>
			</div>
		</div>
		<div class="featured">
			<div class="container">
				<div class="slide active"> <img src="${pageContext.request.contextPath}/resource/assets/images/1.jpg" width='500' height='335' />
					<div class="additional">
						<a class="featured-zoom fancybox" href="${pageContext.request.contextPath}/resource/assets/images/1.jpg" rel="featured">放大</a>
					</div>
				</div>
				<div class="slide"> <img src="${pageContext.request.contextPath}/resource/assets/images/2.jpg" width='500' height='335' />
					<div class="additional">
						<a class="featured-zoom fancybox" href="${pageContext.request.contextPath}/resource/assets/images/2.jpg" rel="featured">放大</a>
					</div>
				</div>
				<div class="slide"> <img src="${pageContext.request.contextPath}/resource/assets/images/3.jpg" width='500' height='335' />
					<div class="additional">
						<a class="featured-zoom fancybox" href="${pageContext.request.contextPath}/resource/assets/images/3.jpg" rel="featured">放大</a>
					</div>
				</div>
				<div class="slide"> <img src="${pageContext.request.contextPath}/resource/assets/images/1.jpg" width='500' height='335' />
					<div class="additional">
						<a class="featured-zoom fancybox" href="${pageContext.request.contextPath}/resource/assets/images/1.jpg" rel="featured">放大</a>
					</div>
				</div>
				<div class="slide"> <img src="${pageContext.request.contextPath}/resource/assets/images/2.jpg" width='500' height='335' />
					<div class="additional">
						<a class="featured-zoom fancybox" href="${pageContext.request.contextPath}/resource/assets/images/2.jpg" rel="featured">放大</a>
					</div>
				</div>
				<div class="slide"> <img src="${pageContext.request.contextPath}/resource/assets/images/3.jpg" width='500' height='335' />
					<div class="additional">
						<a class="featured-zoom fancybox" href="${pageContext.request.contextPath}/resource/assets/images/3.jpg" rel="featured">放大</a>
					</div>
				</div>
				<div class="slide"> <img src="${pageContext.request.contextPath}/resource/assets/images/3.jpg" width='500' height='335' />
					<div class="additional">
						<a class="featured-zoom fancybox" href="${pageContext.request.contextPath}/resource/assets/images/3.jpg" rel="featured">放大</a>
					</div>
				</div>
			</div>
			<div id="slider-left-overlay">
				<a class="prevslide" href="#">Previous</a>
			</div>
			<div id="slider-right-overlay">
				<a class="nextslide" href="#">Next</a>
			</div>
		</div>
		<div class="picture">
			<div class="picture_top">
				<div class="picture_name">图片名称</div>
				<div class="picture_size">图片大小</div>
				<div class="picture_dpi">图片分辨率</div>
				<div class="picture_type">图片类型</div>
				<div class="picture_people">创建人</div>
				<div class="picture_time">创建时间</div>
				<div class="picture_operation">图片操作</div>
			</div>
			<div class="picture_content">
				<div class="picture_content_item">
				  <div class="picture_name_1">数据的空间发快递jfk京东方</div>
				  <div class="picture_size_1">66kb</div>
				  <div class="picture_dpi_1">72dpi</div>
				  <div class="picture_type_1">gif</div>
				  <div class="picture_people_1">李艺彤</div>
				  <div class="picture_time_1">2017-08-23</div>
				  <div class="picture_operation_1">图片操作</div>
				</div>
				<div class="picture_content_item picture_content_item2 ">
				  <div class="picture_name_1">数据的空间jfk京东方</div>
				  <div class="picture_size_1">6kb</div>
				  <div class="picture_dpi_1">72dpi</div>
				  <div class="picture_type_1">jpg</div>
				  <div class="picture_people_1">李艺彤</div>
				  <div class="picture_time_1">2017-08-22</div>
				  <div class="picture_operation_1">图片操作</div>
				</div>
				
				<div class="picture_content_item">
				  <div class="picture_name_1">数据的空间发快递jfk京东方</div>
				  <div class="picture_size_1">66kb</div>
				  <div class="picture_dpi_1">72dpi</div>
				  <div class="picture_type_1">png</div>
				  <div class="picture_people_1">李艺彤</div>
				  <div class="picture_time_1">2017-08-21</div>
				  <div class="picture_operation_1">图片操作</div>
				</div>
				
				<div class="picture_content_item picture_content_item2 ">
				  <div class="picture_name_1">数据的空快方</div>
				  <div class="picture_size_1">666kb</div>
				  <div class="picture_dpi_1">72dpi</div>
				  <div class="picture_type_1">jpg</div>
				  <div class="picture_people_1">李艺彤</div>
				  <div class="picture_time_1">2017-08-20</div>
				  <div class="picture_operation_1">图片操作</div>
				</div>
				
				<div class="picture_content_item">
				  <div class="picture_name_1">数据的空间发快递</div>
				  <div class="picture_size_1">10kb</div>
				  <div class="picture_dpi_1">72dpi</div>
				  <div class="picture_type_1">png</div>
				  <div class="picture_people_1">李艺彤</div>
				  <div class="picture_time_1">2017-08-13</div>
				  <div class="picture_operation_1">图片操作</div>
				</div>
			
			</div>
		</div>
		
		
        <script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/js/jquery-1.8.3.min.js"></script>
		<script type='text/javascript' src='${pageContext.request.contextPath}/resource/assets/js/jquery.fancybox-1.3.4.pack.js'></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/js/custom.js"></script>
	</body>

</html>