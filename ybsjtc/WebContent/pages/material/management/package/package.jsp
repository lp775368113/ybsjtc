<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>封装管理</title>

<style type="text/css">
html, body {
	font-size: 12px;
	padding: 0;
	margin: 0;
	border: 0;
	height: 100%;
	overflow: hidden;
}

.mini-panel-header {
	background-color: #E0EEEE;
}

.mini-panel-body {
	padding: 0px;
}

.Xcontent {
	width: 100%;
	height: 596px;
	min-width: 500px;
}

.Xcontent01 {
	width: 500px;
	height: 596px;;
	margin: auto;
	overflow: hidden;
}

.Xcontent02>a>p {
	font-family: "微软雅黑";
	font-size: 14px;
	color: #595959;
	margin-top: 30px;
	float: left;
}

.Xcontent02>a>p:hover {
	color: #cd2426;
}

.Xcontent03>p {
	font-family: "微软雅黑";
	font-size: 12px;
	color: #595959;
	margin-top: 32px;
	float: left;
	margin-left: 2px;
	cursor: pointer;
}

.Xcontent04>p {
	font-family: "微软雅黑";
	font-size: 12px;
	color: #595959;
	margin-top: 33px;
	float: left;
	margin-left: 2px;
	cursor: pointer;
}

.Xcontent05 {
	width: 500px;
	height: 484px;
	border: 1px solid #a4a4a4;
	margin-top: 70px;
}

.Xcontent06 {
	width: 429px;
	height: 430px;
	margin-top: 26px;
	margin-left: 40px;
	float: left;
}

.Xcontent08 {
	float: left;
	width: 500px;
	height: 78px;
	margin-top: 26px;
	margin-left: 20px;
}

.Xcontent07 {
	float: left;
	width: 76px;
	height: 76px;
	margin-top: 10px;
	margin-left: 10px;
}

.Xcontent07>img {
	float: left;
	width: 100%;
	height: 100%;
}

.Xcontent09 {
	float: left;
	width: 76px;
	height: 76px;
	margin-top: 10px;
	margin-left: 10px;
}

.Xcontent09>img {
	float: left;
	width: 100%;
	height: 100%;
}

.Xcontent10 {
	float: left;
	width: 76px;
	height: 76px;
	margin-left: 10px;
	margin-top: 10px;
}

.Xcontent10>img {
	float: left;
	width: 100%;
	height: 100%;
}

.Xcontent11 {
	float: left;
	width: 76px;
	height: 76px;
	margin-top: 10px;
	margin-left: 10px;
}

.Xcontent11>img {
	float: left;
	width: 100%;
	height: 100%;
}

.Xcontent12 {
	float: left;
	width: 76px;
	height: 76px;
	margin-left: 10px;
	margin-top: 10px;
}

.Xcontent12>img {
	float: left;
	width: 100%;
	height: 100%;
}

.kuangkuang {
	border: 1px solid #e8e8e8;
}
</style>
</head>
<body>
	<div class="mini-splitter" style="width: 100%; height: 100%;">
		<div size="70%" showCollapseButton="false">
			<div class="mini-panel" title="封装列表" showCollapseButton="false"
				style="width: 100%; height: auto;">
				<div style="border-bottom: 0; padding: 0px;">
					<div id="packageForm">
						<table cellpadding="0" class="main-table" cellspacing="0"
							border="0" width="100%">

							<tr height="30px">
								<td class="mini_title" width="95px">封装名称：</td>
								<td><input id="packagename" name="packagename"
									class="mini-textbox" style="width: 120px;" /></td>
								<td colspan="4" style="padding-left: 20px">
									<div style="width: 100%;text-align: center;" class="operate">
										<button style="margin-left: 30px" type="button" class="cz_color" onclick="search()">
											<span class=""></span>查询
										</button>
										<button style="margin-left: 30px" type="button" class="cz_color" onclick="add()">
											<span class=""></span>增加
										</button>
										<button style="margin-left: 30px" type="button" class="cz_color" onclick="edit()">
											<span class=""></span>修改
										</button>
										<button style="margin-left: 30px" type="button" class="cz_color" onclick="del()">
											<span class=""></span>删除
										</button>
									</div>

								</td>
							</tr>
						</table>
					</div>
				</div>
				<div id="packageGrid" class="mini-datagrid"
					style="width: 100%; height: auto;" allowResize="false" multiSelect="false" virtualScroll="true"
					showReloadButton="flase" showPageSize="false" pageSize="20"
					url="${pageContext.request.contextPath}/package/querypackage.do">
					<div property="columns">
						<div type="checkcolumn" headerAlign="center" align="center"
							width="7%"></div>
						<div field="packagename" width="15%" headerAlign="center"
							align="center">封装名称</div>
						<div type="comboboxcolumn" name="process" field="process"
							headerAlign="center" width="10%" align="center">
							工序</span> <input property="editor" class="mini-combobox"
								style="width: 100%;" minWidth="200" textField="text"
								valueField="code"
								data="[{text:'无',code:0},{text:'SMT',code:1},{text:'DIP',code:2}]" />
						</div>
						<div field="description" width="30%" headerAlign="center"
							align="center">描述</div>
					</div>
				</div>
			</div>
		</div>
		<div size="30%" showCollapseButton="false">
			<div class="mini-panel" title="图片预览" showCollapseButton="false"
				style="width: 100%; height: auto;">
				<div class="Xcontent">
					<ul class="Xcontent01">
						<div class="Xcontent06" id="icon0"></div>
						<ol class="Xcontent08">
							<div class="Xcontent07" id="icon1"></div>
							<div class="Xcontent09" id="icon2"></div>
							<div class="Xcontent10" id="icon3"></div>
							<div class="Xcontent11" id="icon4"></div>
							<div class="Xcontent12" id="icon5"></div>
						</ol>
					</ul>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
	<script type="text/javascript">
		mini.parse();
		/**  图片预览  **/
		var $miaobian = $('.Xcontent08>div');
		var $huantu = null;
		var $miaobian1 = $('.Xcontent26>div');
		$miaobian.mousemove(function() {
			miaobian(this);
		});
		function miaobian(thisMb) {
			for (var i = 0; i < $miaobian.length; i++) {
				$miaobian[i].style.borderColor = '#dedede';
			}
			thisMb.style.borderColor = '#cd2426';

			$huantu[0].src = thisMb.children[0].src;
		}
		/**  图片预览  **/

		var form = new mini.Form("packageForm");
		var packageGrid = mini.get("packageGrid");
		search();
		function search() {
			var data = form.getData(true);
			packageGrid.load(data);
		}

		packageGrid
				.on(
						"rowclick",
						function(e) {
							var row = e.row;
							var html0 = '<img width="429px" height="430px" src="${pageContext.request.contextPath}/resource/images/package/'+row.icon1+'" />';
							var html1 = '<img width="429px" height="430px" src="${pageContext.request.contextPath}/resource/images/package/'+row.icon1+'" />';
							var html2 = '<img width="429px" height="430px" src="${pageContext.request.contextPath}/resource/images/package/'+row.icon2+'" />';
							var html3 = '<img width="429px" height="430px" src="${pageContext.request.contextPath}/resource/images/package/'+row.icon3+'" />';
							var html4 = '<img width="429px" height="430px" src="${pageContext.request.contextPath}/resource/images/package/'+row.icon4+'" />';
							var html5 = '<img width="429px" height="430px" src="${pageContext.request.contextPath}/resource/images/package/'+row.icon5+'" />';
							$("#icon0").empty();
							$("#icon1").empty();
							$("#icon2").empty();
							$("#icon3").empty();
							$("#icon4").empty();
							$("#icon5").empty();
							$('#icon1').removeClass("kuangkuang");
							$('#icon2').removeClass("kuangkuang");
							$('#icon3').removeClass("kuangkuang");
							$('#icon4').removeClass("kuangkuang");
							$('#icon5').removeClass("kuangkuang");
							if (row.icon1 != '' && row.icon1 != null) {
								$('#icon0').html(html0);
								$('#icon1').html(html1);
								$('#icon1').addClass("kuangkuang");
								$huantu = $('.Xcontent06>img');
							}
							if (row.icon2 != '' && row.icon2 != null) {
								$('#icon2').html(html2);
								$('#icon2').addClass("kuangkuang");
							}
							if (row.icon3 != '' && row.icon3 != null) {
								$('#icon3').html(html3);
								$('#icon3').addClass("kuangkuang");
							}
							if (row.icon4 != '' && row.icon4 != null) {
								$('#icon4').html(html4);
								$('#icon4').addClass("kuangkuang");
							}
							if (row.icon5 != '' && row.icon5 != null) {
								$('#icon5').html(html5);
								$('#icon5').addClass("kuangkuang");
							}
						});

		function add() {
			var data = {};
			data.action = "add";
			mini
					.open({
						url : "${pageContext.request.contextPath}/pages/material/management/package/package_edit.jsp",
						title : "添加封装",
						width : 450,
						height : 385,
						onload : function() {
							var iframe = this.getIFrameEl();
							//调用弹出页面方法进行初始化
							iframe.contentWindow.setData(data);
						},
						ondestroy : function() {
							packageGrid.reload();
						}
					});
		}

		function edit() {
			var row = packageGrid.getSelected();
			if (!row) {
				mini.alert("请选择一个需要修改的封装记录");
				return;
			}
			row.action = "edit";
			mini
					.open({
						url : "${pageContext.request.contextPath}/pages/material/management/package/package_edit.jsp",
						title : "修改封装",
						width : 450,
						height : 380,
						onload : function() {
							var iframe = this.getIFrameEl();
							//调用弹出页面方法进行初始化
							iframe.contentWindow.setData(row);
						},
						ondestroy : function() {
							packageGrid.reload();
						}
					});
		}

		function del() {
			var row = packageGrid.getSelected();
			if (!row) {
				mini.alert("请选择需要删除的封装记录");
				return;
			}
			var data = {};
			data.id = row.id;
			mini.confirm(
							"确定删除吗？",
							"确定？",
							function(action) {
								if (action == "ok") {
									$.ajax({
												url : "${pageContext.request.contextPath}/package/delete.do",
												type : "post",
												dataType : "json",
												cache : false,
												data : data,
												success : function(data) {
													if (data.success) {
														packageGrid.reload();
														mini.alert("删除成功！",
																"成功");
													} else {
														mini.alert(
																data.message,
																"失败");
													}
												}
											});
								}
							});
		}
	</script>
</body>
</html>