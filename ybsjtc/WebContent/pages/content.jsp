<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../assets/css/main.css" />
		<link rel="stylesheet" href="../assets/css/calendar.css" />
		<script src="../assets/js/jquery-1.8.3.min.js"></script>
		<!--<script type="text/javascript" src="js/jQuery.rTabs.js"></script>-->
		<script type="text/javascript">
			$(document).ready(function() {
				var blw = $(".myscrollbox li").width();
				//获取单个子元素所需宽度
				var liArr = $(".myscrollbox ul").children("li");
				//获取子元素数量
				var mysw = $(".myscroll").width();
				//获取子元素所在区域宽度
				var mus = parseInt(mysw / blw);
				//计算出需要显示的子元素的数量
				var length = liArr.length - mus;
				//计算子元素可移动次数（被隐藏的子元素数量）
				var i = 0
				$("#right").click(function() {
					i++
					//点击i加1
					if(i < length) {
						$(".myscrollbox").css("left", -(blw));
						//子元素集合向左移动，距离为子元素的宽度乘以i。
					} else {
						i = length;
						$(".myscrollbox").css("left", -(blw * length));
						//超出可移动范围后点击不再移动。最后几个隐藏的元素显示时i数值固定位已经移走的子元素数量。
					}
				});
				$("#left").click(function() {
					i--
					//点击i减1
					if(i >= 0) {
						$(".myscrollbox").css("left", -(blw * i));
						//子元素集合向右移动，距离为子元素的宽度乘以i。
					} else {
						i = 0;
						$(".myscrollbox").css("left", 0);
						//超出可移动范围后点击不再移动。最前几个子元素被显示时i为0。
					}
				});
			});
		</script>

	</head>

	<body>
		<!--<div class="main_contenter">-->
		<div id="gray"></div>
		<div class="popup" id="popup2">
			<div class="top_nav" id='top_nav'>
				<div class="top_nav_title">添加应用</div>
				<div align="center">
					<a class="guanbi"></a>
				</div>
			</div>

			<div class="min">
				<div class="tc_login">
					<div class="appliance_popup">
						<div class="collection_item">
							<div class="collection_icon">
								<img src="../assets/images/dn.png">
							</div>
							<div class="collection_text">系统管理</div>
						</div>
						<div class="collection_item">
							<div class="collection_icon">
								<img src="../assets/images/dn.png">
							</div>
							<div class="collection_text">系统管理</div>
						</div>
						<div class="collection_item">
							<div class="collection_icon">
								<img src="../assets/images/dn.png">
							</div>
							<div class="collection_text">系统管理</div>
						</div>
					</div>
				</div>

			</div>

		</div>

      <!--办理-->
      <div class="handle_popup">
      	<div class="top_nav" id='top_nav'>
				<div class="top_nav_title">标题</div>
				<div align="center">
					<a class="guanbi"></a>
				</div>
			</div>

      	 <iframe src="flow.html"></iframe>
      </div>

		<div class="main_contenter_left">
			<div class="backlog">
				<div class="backlog_title">
					待办事项
					<div class="backlog_search">
						<input type="text" placeholder="请输入搜索关键词..." />
						<div class="backlog_search_icon"></div>
					</div>
				</div>
				<div class="backlog_content">
					<div class=" backlog_top">
						<div class="backlog_item">
							<div class="list_title">申请人</div>
							<!--<div class="list_id">身份证</div>-->
							<div class="list_content">待办内容</div>
							<div class="list_time">创建时间</div>
							<div class="list_time">逾期时间</div>
							<div class="list_operation">操作</div>
						</div>
						<div class="backlog_item2 ">
							<div class="item_people">李艺彤</div>
							<!--<div class="item_id">330221199806158796</div>-->
							<div class="item_content">阿拉山口大家flak京东客服</div>
							<div class="item_time">2017-08-16</div>
							<div class="item_time">2天</div>
							<div class="item_handle item_popup">办理</div>

						</div>
						<div class="backlog_item2 item_color">
							<div class="item_people">李艺彤</div>
							<!--<div class="item_id">330221199806158796</div>-->
							<div class="item_content">开始的剑法快乐建立的咖啡机</div>
							<div class="item_time">2017-08-16</div>
							<div class="item_time">2天</div>
							<div class="item_handle">办理</div>

						</div>
						<div class="backlog_item2 ">
							<div class="item_people">李艺彤</div>
							<!--<div class="item_id">330221199806158796</div>-->
							<div class="item_content">开始的剑法快乐建立的咖啡机</div>
							<div class="item_time">2017-08-16</div>
							<div class="item_time">2天</div>
							<div class="item_handle">办理</div>

						</div>
						<div class="backlog_item2 item_color">
							<div class="item_people">李艺彤</div>
							<!--<div class="item_id">330221199806158796</div>-->
							<div class="item_content">开始的剑法快乐建立的咖啡机</div>
							<div class="item_time">2017-08-16</div>
							<div class="item_time">22天</div>
							<div class="item_handle">办理</div>

						</div>
						<div class="backlog_item2 ">
							<div class="item_people">李艺彤</div>
							<!--<div class="item_id">330221199806158796</div>-->
							<div class="item_content">开始的剑法快乐建立的咖啡机</div>
							<div class="item_time">2017-08-16</div>
							<div class="item_time">2天</div>
							<div class="item_handle">办理</div>

						</div>
						<div class="backlog_item2 item_color">
							<div class="item_people">李艺彤</div>
							<!--<div class="item_id">330221199806158796</div>-->
							<div class="item_content">开始的剑法快乐建立的咖啡机</div>
							<div class="item_time">2017-08-16</div>
							<div class="item_time">2天</div>
							<div class="item_handle">办理</div>

						</div>

					</div>
					<div class="page_content">
						<div class="drop_down">
							<select class="drop_down_select">
								<option value="0">全部</option>
								<option value="1">紧急待办</option>
								<option value="2">慢条斯理</option>
							</select>
						</div>
						<div class="page">
							<button class="btn"><</button>
							<button class="btn">1</button>
							<button class="btn btn_active">2</button>
							<button class="btn">3</button>
							<button class="btn2">...</button>
							<button class="btn">8</button>
							<button class="btn">9</button>
							<button class="btn">></button>
						</div>
					</div>
				</div>
			</div>
			<div class="common_menu">
				
				<div class="common_menu_z">
					<div class="collection">
						<div class="collection_title">
							<div class="mybtns">我的收藏
								<!--<a href="javascript:;" id="right"></a>
								<a href="javascript:;" id="left"></a>-->
							</div>
						</div>
						<div class="collection_content">
							<div class="myscroll">
								<div class="myscrollbox">
									<ul>
										<li>
											<a href="#">
												<div class="collection_item">
													<div class="collection_icon">
														<img src="../assets/images/dn.png" />
													</div>
													<div class="collection_text">系统管理</div>
												</div>
											</a>
											<a href="#">
												<div class="collection_item">
													<div class="collection_icon color1">
														<img src="../assets/images/dn.png" />
													</div>
													<div class="collection_text">查询统计</div>
												</div>
											</a>
											<a href="#">
												<div class="collection_item">
													<div class="collection_icon color2">
														<img src="../assets/images/yl.png" />
													</div>
													<div class="collection_text">就医管理</div>
												</div>
											</a>

										</li>

									</ul>
								</div>
							</div>

						</div>
					</div>

					<div class="appliance">
						<div class="collection_title">
							常用应用
						</div>
						<div class="appliance_content">
							<div class="collection_item">
								<div class="collection_icon">
									<img src="../assets/images/dn.png" />
								</div>
								<div class="collection_text">系统管理</div>
							</div>
							<div class="collection_item">
								<div class="collection_icon color1">
									<img src="../assets/images/dn.png" />
								</div>
								<div class="collection_text">查询统计</div>
							</div>
							<div class="collection_item collection_item_add">
								<div class="collection_icon color_add">
									<img src="../assets/images/add.png" />
								</div>
								<div class="collection_text">添加应用</div>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
		<div class="main_contenter_right">
			<div id="calendar">

			</div>
			<div class="notepad">
				<div class="notepad_list">
					<div class="notepad_add">
						<div class="notepad_add_img"></div>
					</div>
					<p style="text-align: center;">
						金樽清酒斗十千，玉盘珍馐直万钱。<br/>
						停杯投箸不能食，拔剑四顾心茫然。<br/>
						欲渡黄河冰塞川，将登太行雪满山。<br/>
						闲来垂钓坐溪上，忽复乘舟梦日边。<br/>
						行路难，行路难，多歧路，今安在。<br/>
						长风破浪会有时，直挂云帆济沧海。	
					</p>
					<div class="arrow">
						<div class="arrow_left"></div>
						<!--<span>1</span>
						<span>2</span>-->
						<div class="arrow_right"></div>
					</div>
				</div>
			</div>
		</div>

		</div>
		<!--</div>-->
		<script type="text/javascript" src="../assets/js/simple-calendar.js"></script>
		<script>
			var myCalendar = new SimpleCalendar('#calendar');
		</script>
		
	</body>

</html>