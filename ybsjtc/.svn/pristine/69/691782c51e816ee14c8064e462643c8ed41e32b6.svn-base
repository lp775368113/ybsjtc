<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet" href="../assets/css/main.css" />
		<link rel="stylesheet" href="../assets/css/calendar.css" />
		<link rel="stylesheet" href="../assets/css/font.css" />
		<script src="../assets/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="../assets/js/echarts.common.js"></script>
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
					快捷事项
					<span class="backlog_check"><a href="">最近受理查看</a></span>
				</div>
				<div class="shortcut">
					<div class="shortcut_item">
						<div class="shortcut_icon_2">
							<i class="menu-icon icon-acceptance"></i>
						</div>
						<div class="shortcut_title_2">就医管理</div>
					</div>
					<div class="shortcut_item">
						<div class="shortcut_icon_2 bg_r_color">
							<i class="menu-icon icon-ylgl"></i>
						</div>
						<div class="shortcut_title_2">系统管理</div>
					</div>
					<div class="shortcut_item">
						<div class="shortcut_icon_2 bg_g_color">
							<i class="menu-icon icon-acceptance"></i>
						</div>
						
							<div class="shortcut_title_2">零星报销</div>
						
					</div>
					<div class="shortcut_item">
						<div class="shortcut_icon_2 bg_y_color">
							<i class="menu-icon icon-acceptance"></i>
						</div>
							<div class="shortcut_title_2">就医管理</div>
					</div>
				</div>
				<div class="weekly_trend">
					<div class="weekly">
					  <div class="collection_title">
						<div class="mybtns">一周趋势</div>
					  </div>
					  <div class="weekly_echarts" id="week"></div>
					</div>
				</div>
				<div class="weekly_type">
					<div class="weekly">
						<div class="collection_title">
						   <div class="mybtns">一周分类</div>
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
					<p>
						灯笼裤飞机啊来得及发卡经多方了解啦大家是酒店开房间啊减肥锻炼咯加分上看见分厘卡机说得来咖啡碱ask大家flak觉得浪费空间费口舌了觉得分厘卡机
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
			option = {
				title: {
					/*text: '一周趋势',*/
					left: '10px',
					textStyle: {
						color: '#788188',
						fontWeight: 'normal',
					},
					textAlign: 'left'
				},
				tooltip: { /*hover属性*/
					trigger: 'asix',
					axisPointer: {
						lineStyle: {
							color: '#ddd'
						}
					},
					/*backgroundColor: 'rgba(255,255,255,1)',*/
					padding: [5, 10],
					textStyle: {
						color: '#fff',
					},
					extraCssText: 'box-shadow: 0 0 5px rgba(0,0,0,0.3)'
				},
				legend: {
					top: '20px',
					data: ['已办', '未办'],
					textStyle: {
						color: '#788188',
					},
				},
				xAxis: {
					type: 'category',
					data: ['周一', '周二', '周三', '周四', '周五', '周六', '周日', ],
					boundaryGap: false,
					splitLine: {
						show: true,
						interval: 'auto',
						lineStyle: {
							color: ['#eaeef1'],
							/*横坐标line*/
						}
					},
					axisTick: {
						show: false
					},
					axisLine: {
						lineStyle: {
							color: '#788188'
						}
					},
					axisLabel: {
						margin: 10,
						textStyle: {
							fontSize: 12
						}
					}
				},
				yAxis: {
					type: 'value',
					splitLine: {
						lineStyle: {
							color: ['#eaeef1']
						}
					},
					axisTick: {
						show: false
					},
					axisLine: {
						lineStyle: {
							color: '#788188'
						}
					},
					axisLabel: {
						margin: 10,
						textStyle: {
							fontSize: 12
						}
					}
				},
				series: [{
					name: '已办',
					type: 'line',
					smooth: true,
					showSymbol: false,
					symbol: 'circle',
					symbolSize: 6,
					data: ['12', '14', '8', '11', '16', '12', '20'],
					areaStyle: {
						normal: {
							color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
								offset: 0,
								color: 'rgba(216, 244, 247,0.6)'
							}, {
								offset: 1,
								color: 'rgba(216, 244, 247,0.3)'
							}], false)
						}
					},
					itemStyle: {
						normal: {
							color: '#58c8da'
						}
					},
					lineStyle: {
						normal: {
							width: 1
						}
					}
				}, {
					name: '未办',
					type: 'line',
					smooth: true,
					showSymbol: false,
					symbol: 'circle',
					symbolSize: 6,
					data: ['10', '12', '15', '12', '13', '10', '6'],
					areaStyle: {
						normal: {
							color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
								offset: 0,
								color: 'rgba(243, 156, 18,0.4)'
							}, {
								offset: 1,
								color: 'rgba(243, 156, 18,0.2)'
							}], false)
						}
					},
					itemStyle: {
						normal: {
							color: 'rgba(243, 156, 18,1.0)'
						}
					},
					lineStyle: {
						normal: {
							width: 1
						}
					}
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

					/* data:['2D线','3D线','资源类','采集类'],
					         textStyle: {
					     color: '#fff'
					 }*/
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

						/* data:[
						     {value:435, name:''},
						     {value:679, name:''},
						     {value:848, name:''},
						      {value:348, name:''}
						 ]*/
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