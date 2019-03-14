<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/main.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/calendar.css" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/assets/css/font.css" />
		<script src="${pageContext.request.contextPath}/resource/assets/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/js/echarts.common.js"></script>
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
								<img class="img_item" src="${pageContext.request.contextPath}/resource/assets/images/dn.png">
							</div>
							<div  class="collection_text">系统管理</div>
						</div>
						<div class="collection_item">
							<div class="collection_icon">
								<img class="img_item" src="${pageContext.request.contextPath}/resource/assets/images/dn.png">
							</div>
							<div class="collection_text">系统管理</div>
						</div>
						<div class="collection_item">
							<div class="collection_icon">
								<img class="img_item" src="${pageContext.request.contextPath}/resource/assets/images/dn.png">
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
				<div class=" shortcut_b">
					<div class="backlog_title2">
					今日动态
				   </div>
					<div class="leader_item">
						<div class="shortcut_icon">
							<i class="menu-icon icon-acceptance"></i>
						</div>
						<div class="shortcut_text">
							<div class="shortcut_number">10</div>
							<div class="shortcut_title">未受理就医管理</div>
						</div>
					</div>
					<div class="leader_item">
						<div class="shortcut_icon bg_r_color">
							<i class="menu-icon icon-ylgl"></i>
						</div>
						<div class="shortcut_text">
							<div class="shortcut_number text_r_color">26</div>
							<div class="shortcut_title">未受理就医管理</div>
						</div>
					</div>
				  </div>
				  <div class=" shortcut_y" style="float: right;">
				  	<div class="backlog_title2">
					        预警信息
				    </div>
					<div class="leader_item">
						<div class="shortcut_icon bg_g_color">
							<i class="menu-icon icon-acceptance"></i>
						</div>
						<div class="shortcut_text">
							<div class="shortcut_number text_g_color">6</div>
							<div class="shortcut_title">未受理就医管理</div>
						</div>
					</div>
					<div class="leader_item">
						<div class="shortcut_icon bg_y_color">
							<i class="menu-icon icon-acceptance"></i>
						</div>
						<div class="shortcut_text">
							<div class="shortcut_number text_y_color">16</div>
							<div class="shortcut_title">未受理就医管理</div>
						</div>
					</div>
				</div>
				<div class="weekly_trend">
					<div class="weekly">
						<div class="collection_title">
							<div class="mybtns">全部趋势</div>
						</div>
						<div class="weekly_echarts" id="week"></div>
					</div>
				</div>
				<div class="weekly_type">
					<div class="weekly">
						<div class="collection_title">
							<div class="mybtns">全部分类</div>
						</div>
						<div class="weekly_echarts" id="week_type"></div>
					</div>
				</div>
			</div>
			<div class="common_menu">

				<div class="common_menu_z">
					<div class="collection">
						<div class="collection_title">
							<div class="mybtns">我的收藏
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
														<img class="img_item" src="${pageContext.request.contextPath}/resource/assets/images/dn.png" />
													</div>
													<div class="collection_text">系统管理</div>
												</div>
											</a>
											<a href="#">
												<div class="collection_item">
													<div class="collection_icon color1">
														<img class="img_item" src="${pageContext.request.contextPath}/resource/assets/images/dn.png" />
													</div>
													<div class="collection_text">查询统计</div>
												</div>
											</a>
											<a href="#">
												<div class="collection_item">
													<div class="collection_icon color2">
														<img class="img_item" src="${pageContext.request.contextPath}/resource/assets/images/yl.png" />
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
									<img class="img_item" src="${pageContext.request.contextPath}/resource/assets/images/dn.png" />
								</div>
								<div class="collection_text">系统管理</div>
							</div>
							<div class="collection_item">
								<div class="collection_icon color1">
									<img class="img_item" src="${pageContext.request.contextPath}/resource/assets/images/dn.png" />
								</div>
								<div class="collection_text">查询统计</div>
							</div>
							<div class="collection_item collection_item_add">
								<div class="collection_icon color_add">
									<img class="img_item" src="${pageContext.request.contextPath}/resource/assets/images/add.png" />
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
						<div class="arrow_right"></div>
					</div>
				</div>
			</div>
		</div>

		</div>
		<!--</div>-->
		<script type="text/javascript" src="${pageContext.request.contextPath}/resource/assets/js/simple-calendar.js"></script>
		<script>
			var myCalendar = new SimpleCalendar('#calendar');
		</script>
		<script type="text/javascript">
			$(".collection_item_add").click(function() {
				$("#gray").show();
				$("#popup2").show();
			});
			$(".item_popup").click(function() {
				$("#gray").show();
				$(".handle_popup").show();
			});
			//点击关闭按钮
			$("a.guanbi").click(function() {
				$("#gray").hide();
				$("#popup").hide();
				$(".handle_popup").hide();
			})
			$("a.guanbi").click(function() {
				$("#gray").hide();
				$("#popup2").hide();
			})
		</script>
		<script type="text/javascript">
			var myChart = echarts.init(document.getElementById('week'));
			var timeData = ['0:00', '0:30',
				'1:00', '1:30',
				'2:00', '2:30',
				'3:00', '3:30',
				'4:00', '4:30',
				'5:00', '5:30',
				'6:00', '6:30',
				'7:00', '7:30',
				'8:00', '8:30',
				'9:00', '9:30',
				'10:00', '10:30',
				'11:00', '11:30',
				'12:00', '12:30',
				'13:00', '13:30',
				'14:00', '14:30',
				'15:00', '15:30',
				'16:00', '16:30',
				'17:00', '17:30',
				'18:00', '18:30',
				'19:00', '19:30',
				'20:00', '20:30',
				'21:00', '21:30',
				'22:00', '22:30',
				'23:00', '23:30'
			];

			option = {
				title: {
					text: '',
					x: 'left',
				},
				tooltip: {
					trigger: 'axis',
					axisPointer: {
						animation: false
					}
				},
				axisPointer: {
					link: {
						xAxisIndex: 'all'
					}
				},
				dataZoom: [{
					show: true,
					realtime: true,
					start: 30,
					end: 50,
				}, {
					type: 'inside',
					realtime: true,
					start: 30,
					end: 50,
				}],
				grid: [{
					
					left: 40,
					right: 40,
				}, {
					left: 40,
					right: 40,
				}],
				xAxis: [{
					type: 'category',
					boundaryGap: false,
					axisLine: {
						onZero: true
					},
					data: timeData
				}, ],
                legend: {
					top: '20px',
					data: ['待办', '已办'],
					textStyle: {
						color: '#788188',
					},
				},
				yAxis: [{
					type: 'value',
					max: 500,
					name: '数量:',
					min: 0,
					interval: 100,

				}, ],
				series: [{
					name: '待办',
					type: 'line',
					smooth: true,
					symbol: 'circle',
					symbolSize: 9,
					showSymbol: false,
					lineStyle: {
						normal: {
							width: 1
						}
					},
					markPoint: {
						data: [{
							type: 'max',
							name: '最大值'
						}, {
							type: 'min',
							name: '最小值'
						}]
					},
					markArea: {
						silent: true,
						label: {
							normal: {
								position: ['10%', '50%']
							}
						},
						data: [
							[{
								name: '优',
								yAxis: 100,
								itemStyle: {
									normal: {
										color: 'rgba(0,153,153,0.27)'
									}
								},
							}, {
								yAxis: 200
							}],
							[{
								name: '良',
								yAxis: 200,
								itemStyle: {
									normal: {
										color: 'rgba(153,204,51,0.2)'
									}
								},
							}, {
								yAxis: 300,
							}],
							[{
								name: '差',
								yAxis: 300,
								itemStyle: {
									normal: {
										color: 'rgba(250,250,51,0.2)'
									}
								}
							}, {
								yAxis: 400,
							}]
						],

					},
					data: [113, 132, 123, 122, 132, 132, 123, 225, 223, 232, 223, 222, 223, 312, 223, 222, 223, 222, 232, 262, 232, 232, 223, 222, 223, 332, 223, 232, 223, 322, 123, 222, 231, 322, 233, 122, 223, 232, 232, 222, 223, 232, 232, 222, 232, 132, 123, 212],


				},
				{
					name: '已办',
					type: 'line',
					smooth: true,
					symbol: 'circle',
					symbolSize: 9,
					showSymbol: false,
					lineStyle: {
						normal: {
							width: 1
						}
					},
					markPoint: {
						data: [{
							type: 'max',
							name: '最大值'
						}, {
							type: 'min',
							name: '最小值'
						}]
					},
					itemStyle: {
						normal: {
							color: '#2ECC71'
						}
					},
					data: [13, 132, 123, 122, 132, 132, 123, 225, 223, 32, 223, 122, 223, 12, 23, 322, 223, 22, 32, 22, 232, 22, 223, 22, 223, 332, 223, 232, 223, 22, 123, 222, 231, 322, 233, 122, 23, 232, 232, 22, 223, 32, 232, 322, 32, 132, 123, 12],


				}]
			};
			myChart.setOption(option);
		</script>
		<script>
			var myChart = echarts.init(document.getElementById('week_type'));
			option = {
				title: {
					/*text: '一周分类',*/
					left: '10px',
					textStyle: {
						color: '#788188',
						fontWeight: 'normal',
					},
					textAlign: 'left'
				},
				tooltip: {
					trigger: 'item',
					formatter: "{a} <br/>{b}: {c} ({d}%)",

				},
				legend: {

					orient: 'vertical',
					x: 'right',
					itemWidth: 14,
					itemHeight: 14,
					align: 'left',
				},
				series: [{
						name: '分类',
						type: 'pie',
						hoverAnimation: false,
						legendHoverLink: false,
						radius: ['40%', '42%'],
						color: ['#915872', '#3077b7', '#9a8169', '#3f8797'],
						label: {
							normal: {
								position: 'inner'
							}
						},
						labelLine: {
							normal: {
								show: false
							},

						},
						tooltip: {
							show: false,

						},
					},
					{
						name: '分类',
						type: 'pie',
						radius: ['35%', '55%'],
						color: ['#d74e67', '#0092ff', '#eba954', '#21b6b9'],
						label: {
							normal: {
								formatter: '{b}\n{d}%'
							},

						},
						data: [{
								value: 435,
								name: '就医管理'
							},
							{
								value: 679,
								name: '零星报销'
							},
							{
								value: 848,
								name: '受理事项'
							},
							{
								value: 348,
								name: '系统管理'
							},

						]
					}
				]
			};

			myChart.setOption(option);
		</script>
	</body>

</html>