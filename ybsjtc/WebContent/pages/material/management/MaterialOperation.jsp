<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>物料编码</title>

<style type="text/css">
html, body {
	font-size: 13px;
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

#form1 table tr {
	height: 28px;
}
</style>


</head>
<body>
	<div class="mini-fit">
		<div class="mini-panel" title="查询条件" showCollapseButton="false"
			style="width: 100%; height: auto;">
			<form id="form1" name="form1" style="" action="#" method="post">
				<table width="99%" border="0" cellpadding="0" cellspacing="0px"
					style="padding-top: 8px;">
					<tr height="28px">
						<td class="mini_title" align="right">物料编码：</td>
						<td><input class="mini-textbox" id="invPartNumber"
							name="invPartNumber" style="width: 300px" /></td>
						<td class="mini_title" align="right">制造厂商：</td>
						<td><input class="mini-textbox" id="prodSupper"
							name="prodSupper" style="width: 300px" /></td>
						<td class="mini_title" align="right">封装：</td>
						<td><input class="mini-textbox" id="package_" name="package_"
							style="width: 300px" /></td>
					</tr>
					<tr height="28px">
						<td class="mini_title" align="right">禾川编码：</td>
						<td><input class="mini-textbox" id="extraDesc"
							name="extraDesc" style="width: 300px" /></td>
						<td class="mini_title" align="right">供应商料号：</td>
						<td><input class="mini-textbox" id="custPartCode"
							name="custPartCode" style="width: 300px" /></td>
						<td class="mini_title" align="right">物料名称（描述）：</td>
						<td><input class="mini-textbox" id="ipdcSTR"
							name="ipdcSTR" style="width: 300px" emptyText="多个关键词用空格隔开"/></td>
					</tr>
					<tr height="28px">
					<td colspan="6" align="right" valign="right">
							<div style="width: 150px; padding-right: 12px;" class="operate">
								<button type="button" class="cx_color" onclick="search()">
									<span class=""></span>查询
								</button>
								<button type="button" class="cz_color" onclick="resetForm()">
									<span class=""></span>重置
								</button>
							</div>
						</td>
					</tr>
					
				</table>
			</form>
		</div>
		<div style="width: 100%;">
			<div class="mini-toolbar">
				<div class="operate" style="text-align: left !important">
					<button type="button" class="bc_color" onclick="add()">
						<span class=""></span>新增物料
					</button>
					<!-- <button type="button" class="bc_color" onclick="modify()">
						<span class=""></span>修改物料
					</button> -->
					<button id="shixiao" type="button" class="bc_color" onclick="SD('S')">
						<span class=""></span>失效编码审批
					</button>
					<button id="zuofei" type="button" class="bc_color" onclick="SD('D')">
						<span class=""></span>作废编码审批
					</button>
				</div>
			</div>
		</div>
		<!-- center begin -->
		<div class="mini-panel" title="查询结果" showCollapseButton="false"
			style="width: 100%; height: auto;">
			<div id="grid1" class="mini-datagrid" idField="id" multiSelect="true"
				style="width: 100%; height: auto;" allowResize="false" pageSize="20"
				showReloadButton="flase" showPageSize="false" multiSelect="false"
				virtualScroll="true" allowResize="true"
				url="${pageContext.request.contextPath}/encoding/getMaterielList.do">
				<div property="columns">
					<div type="checkcolumn"></div>
					<div field="rkey" width="13%" headerAlign="center" align="center">RKEY</div> 
					<!-- <div field="ttype" width="20%" headerAlign="center" align="center">原料标识</div> -->
					<div field="invPartNumber" width="20%" headerAlign="center"
						align="center">物料编码</div>
					<div field="extraDesc" width="33%" headerAlign="center"
						align="center">禾川编码</div>
					<!-- <div field="invPartDescriptionC" width="33%" headerAlign="center" align="center">物料大类</div> -->
					<!-- <div field="prodCodeSellPtr" width="33%" headerAlign="center"
						align="center">物料小类</div> -->
					<div field="prodSupper" width="25%" headerAlign="center"
						align="center">制造厂商</div>
					<div field="package_" width="25%" headerAlign="center"
						align="center">封装</div>
					<!-- <div field="smtFlag" width="33%" headerAlign="center"
						align="center">SMT/DIP</div>  --> 
					<div field="invPartDescriptionC" width="40%" headerAlign="center"
						align="center">物料名称（描述）</div>
					<!-- <div field="custPartName" width="33%" headerAlign="center"
						align="center">供应商物料名称</div> -->
					<div field="custPartCode" width="25%" headerAlign="center"
						align="center">供应商料号</div>
						<div field="stockPurch" width="33%" headerAlign="center" align="center" >包装数量</div>
				</div>
			</div>
			<!-- center end -->
		</div>
		<div id="hid1" style="display: block">
			<!-- <table width="100%" border="0" cellpadding="0" cellspacing="0" >
		<tr align="center">
			<td>&nbsp;</td>
		</tr>
		<tr align="center">
			<td>导出内容：
				<input type="radio" name="exportcontent" id="exportcontent" value="all" checked/>导出全部
				<input type="radio" name="exportcontent" id="exportcontent" value="current"/>导出本页
				<input type="radio" name="exportcontent" id="exportcontent" value="selected" />导出选中项
			</td>
		</tr>
		<tr align="center">
			<td>&nbsp;</td>
		</tr>
		<tr align="center">
			<td>
			<div style="width: 200px" class="operate">
				<button type="button" class="cz_color" onclick="toexport()">
					<span class=""></span>导出
				</button>
				</div>
			</td>
		</tr>
	</table> -->
		</div>
	</div>


</body>
</html>
<script type="text/javascript">
	mini.parse();
	var form = new mini.Form("form1");
	var grid = mini.get("grid1");
	grid.load();
	function search() {
		form.validate();
		if (form.isValid() == false) {
			return;
		}
		var data = form.getData(true);
		grid.load(data);
	}

	function resetForm() {
		form.reset();
	}

	function ondayRenderer(e) {
		//var value = mini.get("utime").value;
		var dateValue = new Date(e.value);
		if (dateValue) {
			return mini.formatDate(dateValue, "yyyy-MM-dd HH:mm:ss");
		}
	}

	function add() {
		mini
				.open({
					targetWindow : window,
					url : "${pageContext.request.contextPath}/pages/material/management/material_add.jsp",
					title : "新增物料",
					width : 1100,
					height : 650,
					showMaxButton : true,
					allowResize : true,
					onload : function() {
						var iframe = this.getIFrameEl();
						iframe.contentWindow.SetData();
					},
					ondestroy : function(action) {
						grid.reload();
					}
				});
	}

	function SD(e) {
		console.log(e);
		var row=grid.getSelected ();
		if(row){
			row.SD=e;
			var title='';
			if('S'==e){
				title="失效编码";
			}else{
				title="作废编码";
			}
			console.log(row);
			mini.confirm("确定"+title+"？", "确定？", function(action) {
				if (action == "ok") {
					$.ajax({
						url : "${pageContext.request.contextPath}/encoding/SD.do",
						type : "post",
						dataType : "json",
						cache : false,
						data : row,
						success : function(data) {
							if (data.success) {
								mini.alert("成功发起审批！", "成功");
							} else {
								mini.alert(data.message, "失败");
							}
						}
					});
				} 
			});
		}else{
			mini.alert("请选择一条记录");
		}
		
	}
</script>