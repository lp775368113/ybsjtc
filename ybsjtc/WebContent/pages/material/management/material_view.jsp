<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>物料详细</title>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resource/scripts/jquery-1.10.0.min.js"></script> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/scripts/ajaxfileupload.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/scripts/buttonPremission.js"></script>
<style type="text/css">
html, body {
	font-size: 12px;
	padding: 0;
	margin: 0;
	border: 0;
	height: 100%;
	overflow: hidden;
}

#tb td {
	font-size: 15px;
	font-family: cursive;
}

#tb td input {
	font-size: 15px;
	font-family: cursive;
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
			<div class="mini-fit">
				<form id="form2" name="form2" style="padding-top: 10px" action="#"
					method="post">
					<table cellpadding="0" class="main-table" cellspacing="10px"
						border="0px" width="98%">

						<tr>
							<td width="16%" class="mini_title">大类名称：</td>
							<td width="16%"><input id="maxclass" name="maxclass"
								class="mini-combobox asLable" enabled="false"
								style="cursor: hand; width: 100%" borderStyle="border:0px;"
								textField="classname" width="100%" valueField="id" /></td>
							<td width="16%" class="mini_title">小类名称：</td>
							<td width="16%"><input id="prodCodeSellPtr"
								name="prodCodeSellPtr" class="mini-combobox asLable"
								enabled="false" style="cursor: hand; width: 100%"
								borderStyle="border:0px;"
								url="${pageContext.request.contextPath}/class/getAllSmallClass.do"
								textField="classname" width="100%" valueField="id"
								onvaluechanged="setWLMS" /></td>
							<td width="16%" class="mini_title">封装：</td>
							<td width="16%"><input id="package_Str" name="package_Str"
								style="cursor: hand; width: 100%" borderStyle="border:0px;"
								class="mini-textbox asLable" enabled="false" width="100%" /></td>
						</tr>
						<tr>
							<td class="mini_title" width="16%">厂商料号：</td>
							<td width="16%"><input class="mini-textbox asLable"
								enabled="false" style="cursor: hand; width: 100%"
								borderStyle="border:0px;" name="custPartCode" id="custPartCode"
								width="100%" /></td>
								<td class="mini_title" width="16%">SMT/DIP：</td>
								<td width="16%"><input class="mini-combobox asLable"
									enabled="false" name="smtFlag"
									style="cursor: hand; width: 100%" borderStyle="border:0px;"
									id="smtFlag" width="100%"
									data="[{text:'无',code:0},{text:'SMT',code:1},{text:'DIP',code:2}]"
									textField="text" valueField="code" /></td>
								<td class="mini_title" width="16%">制造商：</td>
								<td width="16%"><input id="prodSupperStr" name="prodSupperStr"
									class="mini-textbox asLable" enabled="false"
									style="cursor: hand; width: 100%" borderStyle="border:0px;"
									width="100%" /></td>
						</tr>
						<tr>
							<td class="mini_title" width="16%">供应商物料名称：</td>
							<td width="16%"><input class="mini-textbox asLable"
								enabled="false" style="cursor: hand; width: 100%"
								borderStyle="border:0px;" name="custPartName" id="custPartName"
								width="100%" /></td>
								<td class="mini_title" width="16%"></td>
								<td width="16%"></td>
								<td class="mini_title" width="16%"></td>
								<td width="16%"></td>
						</tr>
						<tr>
							<td class="mini_title" width="16%">物料名称(描述)：</td>
							<td width="100%" colspan="5" id="wlmc"><input
								class="mini-textbox asLable" enabled="false"
								name="invPartDescriptionC" style="cursor: hand; width: 100%"
								borderStyle="border:0px;" id="invPartDescriptionC"
								onvaluechanged="checkValue" width="100%" /></td>
						</tr>
						<tr>
							<td class="mini_title" width="16%">包装单位：</td>
							<td width="16%"><input id="purchUnitPtr" name="purchUnitPtr"
								style="cursor: hand; width: 100%" borderStyle="border:0px;"
								class="mini-combobox asLable" enabled="false"
								url="${pageContext.request.contextPath}/encoding/getUnit.do"
								textField="unit_name" width="100%" valueField="rkey" /></td>
							<td class="mini_title" width="16%">仓存单位：</td>
							<td width="16%"><input id="stockUnitPtr" name="stockUnitPtr"
								class="mini-combobox asLable" enabled="false"
								style="cursor: hand; width: 100%" borderStyle="border:0px;"
								url="${pageContext.request.contextPath}/encoding/getUnit.do"
								textField="unit_name" width="100%" valueField="rkey" /></td>
							<td class="mini_title" width="16%">优先供应商：</td>
							<td width="16%"><input id="supplierPtr" name="supplierPtr"
								class="mini-combobox asLable" enabled="false"
								valueFromSelect="true" style="cursor: hand; width: 100%"
								borderStyle="border:0px;"
								url="${pageContext.request.contextPath}/encoding/getAllSupplier.do"
								textField="supplier_name" width="100%" valueField="id"
								allowInput="true" /></td>
						</tr>
						<tr>
							<td class="mini_title" width="16%">包装数量：</td>
							<td width="16%"><input class="mini-textbox asLable" style="cursor: hand; width: 100%"
								borderStyle="border:0px;"
								enabled="false" name="stockPurch"
								style="cursor: hand; width: 100%" borderStyle="border:0px;"
								id="stockPurch" width="100%" vtype="float" value="1" /></td>
							<td class="mini_title" width="16%">核算单价：</td>
							<td width="16%"><input class="mini-textbox asLable"  style="cursor: hand; width: 100%;display:none;"
								borderStyle="border:0px;"
								enabled="false" name="stdCost"
								borderStyle="border:0px;" id="stdCost" width="100%" /></td>
							<td class="mini_title" width="16%">仓存：</td>
							<td width="16%"><input class="mini-textbox asLable"  style="cursor: hand; width: 100%;"
								borderStyle="border:0px;"
								enabled="false" name="warehouse"
								borderStyle="border:0px;" id="warehouse" width="100%" /></td>
						</tr>
						<tr>
					<td class="mini_title" width="16%"><span style="color: red">*</span>原理图封装：</td>
					<td width="16%"><input class="mini-textbox  asLable" borderStyle="border:0px;" 
								enabled="false" style="cursor: hand; width: 100%" name="schematic"
						id="schematic" width="100%" required="true"  
						 /></td>
					<td class="mini_title" width="16%"><span style="color: red">*</span>相关文件名称：</td>
					<td width="16%"><input class="mini-textbox asLable" borderStyle="border:0px;"  enabled="false" style="cursor: hand; width: 100%" name="filename"
						id="filename" width="100%" required="true"  /></td>
				</tr>
				<tr id="yinzhiban" >
				</tr>
						<tr>
							<td class="mini_title">备注：</td>
							<td colspan="5"><input class="mini-TextArea" enabled="false"
								name="remark" maxLength="250" id="remark" width="100%"
								height="100px" /></td>
						</tr>
						<tr>
							<td class="mini_title">相关文件：</td>
							<td colspan="5"><div id="fj"
									style="width: 100%; height: auto; word-wrap: break-word"></div></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div size="30%" showCollapseButton="false">
			<div class="mini-panel" title="封装图预览" showCollapseButton="false"
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

		function loadingImage(data){
			var json={};
			var package_Str=data.package_Str;
			if(package_Str==''){
				return;
			}
			json.packagename=package_Str;
			$.ajax({
				url : "${pageContext.request.contextPath}/package/getPackageByName.do",
				type : "post",
				dataType : "json",
				cache : false,
				data : json,
				success : function(data) {
					if(data!=''&&data!==null){
						showImages(data)
					}
				}
			});
			
		}
		
		function showImages(row) {
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
		}

		var form = new mini.Form("form2");
		function SetData(data) {
			//跨页面传递的数据对象，克隆后才可以安全使用
			data = mini.clone(data);
			form.setData(data);
			setBigclass(data.prodCodeSellPtr);
			lodingFiles(data.rkey);//加载文件
			lodingremark(data);//加载备注
			loadingImage(data);//加载封装图片
		}

		function setBigclass(smallclassid) {
			var maxclass = mini.get("maxclass");
			var url = "${pageContext.request.contextPath}/class/getBigClassBySmallclassid.do?smallclassid="
					+ smallclassid;
			maxclass.setUrl(url);
			maxclass.select(0);
			if(smallclassid==2541){//印制版
				html='<td class="mini_title"><span style="color: red">*</span>版本号：</td>'+
				'<td colspan="3" ><input class="mini-textbox asLable" borderStyle="border:0px;"  enabled="false" style="cursor: hand;" name="peVersion"  id="peVersion"   required="true" width="150px" height="100px" /><input class="mini-datepicker asLable" borderStyle="border:0px;"  enabled="false" style="cursor: hand;" name="peVersionDate"   required="true" id="peVersionDate" width="100px" height="100px" /></td>';
				$('#yinzhiban').append(html);
				mini.parse();
			}else{
				$('#yinzhiban').empty();
			}
		}
		function lodingremark(req) {
			var data = {};
			data.erpid = req.rkey;
			$
					.ajax({
						url : "${pageContext.request.contextPath}/encoding/lodingremark.do",
						type : "post",
						dataType : "json",
						cache : false,
						data : data,
						success : function(data) {
							mini.get("remark").setValue(data.remark);
						}
					});
		}

		function lodingFiles(rkey) {
			var data = {};
			data.erpid = rkey;
			$
					.ajax({
						url : "${pageContext.request.contextPath}/encoding/getFilesPre.do",
						type : "post",
						dataType : "json",
						cache : false,
						data : data,
						success : function(files) {
							showfiles(files);
						}
					});
		}

		function showfiles(files) {
			var htmlstr = "";
			for (var i = 0; i < files.length; i++) {
				htmlstr += "<a href='${pageContext.request.contextPath}/encoding/downloadFile.do?id="
						+ files[i].id
						+ "'>"
						+ files[i].filename
						+ "</a>&nbsp&nbsp&nbsp";
			}
			document.getElementById('fj').innerHTML = htmlstr;
		}
	</script>
</body>

</html>