<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>物料新增</title>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resource/scripts/jquery-1.10.0.min.js"></script> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/scripts/ajaxfileupload.js"></script>
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

#form2 table tr {
	height: 10px;
}
</style>
</head>
<body>

	<div class="mini-fit">
		<form id="form2" name="form2" style="padding-top: 10px" action="#"
			method="post">
			<table cellpadding="0" class="main-table" cellspacing="10px"
				border="0px" width="98%">

				<tr>
					<td width="16%" class="mini_title"><span style="color: red">*</span>大类名称：</td>
					<td width="16%"><input id="maxclass" name="maxclass"
						class="mini-combobox"
						url="${pageContext.request.contextPath}/class/getAllbigclassPre.do?nottype=1"
						onvaluechanged="onClassChanged" required="true"
						textField="classname" width="100%" valueField="id" /></td>
					<td width="16%" class="mini_title"><span style="color: red">*</span>小类名称：</td>
					<td width="16%"><input id="prodCodeSellPtr"
						name="prodCodeSellPtr" class="mini-combobox" url=""   
						required="true" textField="classname" width="100%" valueField="id"
						onvaluechanged="setWLMS" /></td>
					<td width="16%" class="mini_title"><span style="color: red">*</span>封装：</td>
					<td width="16%"><input id="package_" name="package_"
						class="mini-combobox" valueFromSelect="true" allowInput="true" onvaluechanged="onpackageChanged"
						url="${pageContext.request.contextPath}/package/getAllpackage.do" required="true"
						textField="packagename" width="100%" valueField="id" /></td>
				</tr>
				<tr>
					<td class="mini_title" width="16%"><span style="color: red">*</span>厂商料号：</td>
					<td width="16%"><input class="mini-textbox"
						name="custPartCode" id="custPartCode" required="true" width="100%" /></td>
						<td class="mini_title" width="16%">产品类型：</td>
						<td width="16%">
							<input name="productType" id="productType" width="100%" required="true" class="mini-buttonedit" onbuttonclick="onButtonEdit"/> 
						 </td>
					<td class="mini_title" width="16%"><span style="color: red">*</span>制造商：</td>
					<td width="16%"><input id="prodSupper" name="prodSupper" 
						class="mini-combobox"
						url="${pageContext.request.contextPath}/encoding/getProdSupper.do"
						onvaluechanged="onProdSupperChanged" required="true"
						valueFromSelect="true" textField="brandname" width="100%"
						valueField="id" allowInput="true" /></td>
				</tr>
				<tr>
					<td class="mini_title" width="16%">产品名称(描述)示列：</td>
					<td width="100%" colspan="5" id="ensample"></td>
				</tr>
				<tr>
					<td class="mini_title" width="16%"><span style="color: red">*</span>产品名称(描述)：
						<input class="mini-hidden" name="invPartDescriptionC"
						id="invPartDescriptionC" onvaluechanged="checkValue" /></td>
					<td width="100%" colspan="5" id="wlmc"></td>
				</tr>
				<tr>
					<td class="mini_title" width="16%"><span style="color: red">*</span>包装单位：</td>
					<td width="16%"><input id="purchUnitPtr" name="purchUnitPtr"
						class="mini-combobox"
						url="${pageContext.request.contextPath}/encoding/getUnit.do"
						required="true" textField="unit_name" width="100%"
						valueField="rkey" /></td>
					<td class="mini_title" width="16%"><span style="color: red">*</span>仓存单位：</td>
					<td width="16%"><input id="stockUnitPtr" name="stockUnitPtr"
						class="mini-combobox"
						url="${pageContext.request.contextPath}/encoding/getUnit.do"
						required="true" textField="unit_name" width="100%"
						valueField="rkey" /></td>
					<td class="mini_title" width="16%"><span style="color: red">*</span>优先供应商：</td>
					<td width="16%"><input id="supplierPtr" name="supplierPtr"
						class="mini-combobox" valueFromSelect="true" required="true"
						textField="supplier_name" width="100%" valueField="id"
						allowInput="true" /></td>
				</tr>
				<tr>
					<td class="mini_title" width="16%"><span style="color: red">*</span>包装数量：</td>
					<td width="16%"><input class="mini-textbox" name="stockPurch"
						id="stockPurch" width="100%" required="true" vtype="float"
						value="1" /></td>
					<td class="mini_title" width="16%"><span style="color: red">*</span>核算单价：</td>
					<td width="16%"><input class="mini-textbox" name="stdCost"
						id="stdCost" width="100%" required="true" vtype="float" /></td>
					<td class="mini_title" width="16%">相关文件：</td>
					<td width="16%"><div id="reload">
							<input class="mini-htmlfile" name="myfile" id="myfile"
								width="100%" onfileselect="upload" />
						</div></td>
				</tr>
				<tr>
					<td class="mini_title" width="16%"><span style="color: red">*</span>原理图封装：</td>
					<td width="16%"><input class="mini-textbox" name="schematic"
						id="schematic" width="100%" required="true"  
						 /></td>
					<td class="mini_title" width="16%"><span style="color: red">*</span>相关文件名称：</td>
					<td width="16%"><input class="mini-textbox" name="filename"
						id="filename" width="100%" required="true"  /></td>
				</tr>
				<tr id="yinzhiban" >
				</tr>
				<tr>
					<td class="mini_title">备注：</td>
					<td colspan="5"><input class="mini-TextArea" name="remark"
						maxLength="250" emptyText="备注系统产品出现的风险、问题等信息,最多250字。" id="remark"
						width="100%" height="100px" /></td>
				</tr>
				<tr>
					<td class="mini_title">已上传文件：</td>
					<td colspan="5"><div id="fj" style="width: 700px; height: auto; word-wrap: break-word"></div></td>
				</tr>
			</table>
			<table>
				<tr>
					<td colspan="2" width="40%"></td>
					<td colspan="1" width="20%">
						<div style="width: 300px" class="operate">
							<button id="button_save" type="button" class="bc_color"
								onclick="save();">
								<span class="bc"></span>保存
							</button>
							<button id="button_reset" type="button" class="cz_color"
								onclick="resetForm()">
								<span class="cz"></span>重置
							</button>
						</div>
					</td>
					<td colspan="2" width="40%"></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		mini.parse();
		var files = [];
		var fileidstr = "";
		var check = {}; 
		var canCheck=true;
		var form = new mini.Form("form2");
		var MS = 0;
		var product={};
		function SetData(data) {
			//跨页面传递的数据对象，克隆后才可以安全使用
			data = mini.clone(data);
		}
		
		function onpackageChanged(){
			mini.get("fz").setValue(mini.get("package_").getText());
		}
		
		 function onButtonEdit(e) {
	            var btnEdit = this;
	            mini.open({
	                url: "${pageContext.request.contextPath}/pages/material/BOMsys/product/product_type.jsp",
	                showMaxButton: false,
	                title: "选择产品类型",
	                width: 350,
	                height: 450,
	                ondestroy: function (action) {                    
	                    if (action == "ok") {
	                        var iframe = this.getIFrameEl();
	                        var data = iframe.contentWindow.GetData();
	                        data = mini.clone(data);
	                        if (data) {
	                        	product.id=data.id;
	                        	product.pid=data.pid;
	                            btnEdit.setValue(data.id);
	                            btnEdit.setText(data.text);
	                        }
	                    }
	                }
	            });            
	        }    
		
		function save() {
			form.validate();
			if (form.isValid() == false) {
				return;
			}
			if(!canCheck){
				mini.alert("文件正在上传，请上传后发起审批。");
				return;
			}
			$("#button_save").attr("disabled", true);
			$("#button_reset").attr("disabled", true);
			var data = form.getData(true);
			var invPartDescriptionC = '';
			for (var i = 0; i < MS; i++) {
				var key = 'MS' + i;
				if (i == 0) {
					invPartDescriptionC = data[key];
				} else {
					invPartDescriptionC = invPartDescriptionC + '-' + data[key];
				}
			}
			mini.get("invPartDescriptionC").setValue(invPartDescriptionC);
			var data = form.getData(true);
			data.fileidstr = fileidstr;
			checkValue(data);
			if (!check.countCustPartCode) {
				mini.alert("厂商料号系统已存在！");
				$("#button_save").attr("disabled", false);
				$("#button_reset").attr("disabled", false);
				return;
			} else if (!check.conutInvPartDescriptionC) {
				mini.alert("物料名称(描述)系统已存在！");
				$("#button_save").attr("disabled", false);
				$("#button_reset").attr("disabled", false);
				return;
			}
			if(product.pid="-2"){
				data.ttype=2
			}else if(product.pid="-9"){
				data.ttype=9
			}else if(product.pid="-10"){
				data.ttype=10
			}
			$
					.ajax({
						url : "${pageContext.request.contextPath}/encoding/saveProduct.do",
						type : "post",
						dataType : "json",
						cache : false,
						data : data,
						success : function(data) {
							if (data.success) {
								mini.alert("保存成功！", "成功",
										window.CloseOwnerWindow);
							} else {
								mini.alert(data.message, "失败",
										window.CloseOwnerWindow);
							}
						}
					});
		}
		function checkValue(data) {
			$
					.ajax({
						url : "${pageContext.request.contextPath}/encoding/checkValue.do",
						type : "post",
						async : false,
						dataType : "json",
						cache : false,
						data : data,
						success : function(get) {
							check = get;
						}
					});
		}

		function onClassChanged() {
			var maxclass = mini.get("maxclass");
			var bigclassid = maxclass.getValue();
			var url = "${pageContext.request.contextPath}/class/getSmallClassPre.do?nottype=1&bigclassid="
					+ bigclassid;
			mini.get("prodCodeSellPtr").setUrl(url);
		}

		function onProdSupperChanged() {
			var prodSupper = mini.get("prodSupper");
			var brandid = prodSupper.getValue();
			var url = "${pageContext.request.contextPath}/encoding/getSupplier.do?brandid="
					+ brandid;
			mini.get("supplierPtr").setUrl(url);
		}
		
		function onSmallClassChanged(){
			var smallclassid=mini.get("prodCodeSellPtr").getValue();
			url="${pageContext.request.contextPath}/BrandSupplier/queryClassBrandPre.do?smallclassid="+smallclassid;
			mini.get("prodSupper").setUrl(url);
		}

		function resetForm() {
			form.reset();
			files = [];
			showfiles();
		}

		function setWLMS() {
			var prodCodeSellPtr = mini.get("prodCodeSellPtr");
			var id = prodCodeSellPtr.getValue();
			var html='';
			if(id==2541){//印制版
				html='<td class="mini_title"><span style="color: red">*</span>版本号：</td>'+
				'<td colspan="3" ><input class="mini-textbox" name="peVersion"  id="peVersion"  required="true" width="150px" height="100px" /><input class="mini-datepicker" name="peVersionDate" required="true" id="peVersionDate" width="100px" height="100px" /></td>';
				$('#yinzhiban').append(html);
				mini.parse();
			}else{
				$('#yinzhiban').empty();
			}
				
				
			
			$
					.ajax({
						url : "${pageContext.request.contextPath}/encoding/getSmallclass.do",
						type : "post",
						dataType : "json",
						cache : false,
						data : {
							"id" : id
						},
						success : function(data) {
							var html = '';
							var btname = 'MS'
							var ensampleValue=data.ensample;
							$('#ensample').html(ensampleValue);
							var smallinformation = data.rules;
							var mss = smallinformation.split("-");
							MS = mss.length;
							for (var i = 0; i < mss.length; i++) {
								var box = mss[i].split("|");
								if (box.length > 1) {
									var data = "";
									for (var j = 0; j < box.length; j++) {
										if (j == 0) {
											data = "[{text:'" + box[j]
													+ "',code:'" + box[j]
													+ "'}";
										} else if (j == box.length - 1) {
											data = data + ",{text:'" + box[j]
													+ "',code:'" + box[j]
													+ "'}]";
										} else {
											data = data + ",{text:'" + box[j]
													+ "',code:'" + box[j]
													+ "'}";
										}
									}
									if (i == 0) {
										html = '<input class="mini-combobox" name="'+btname+i+'" required="true" width="130px"  data="'+data+'"  textField="text"  valueField="code" />';
									} else {
										html = html
												+ ' 一 <input class="mini-combobox" name="'+btname+i+'" required="true" width="130px"  data="'+data+'"  textField="text"  valueField="code" />';
									}
								} else {
									if (i == 0) {
										html = '<input class="mini-textbox"  name="'+btname+i+'"  width="100px" required="true" value="'+mss[i]+'" emptyText="'+mss[i]+'" />';
									} else {
										if(mss[i] == "封装"){
											var package_=mini.get("package_").getText();
											html = html + ' 一  <input class="mini-textbox" id=fz name="'+btname+i+'"  width="100px" required="true" emptyText="'+mss[i]+'"  value="'+package_+'" />';
										}else{
											html = html + ' 一  <input class="mini-textbox"  name="'+btname+i+'"  width="100px" required="true" emptyText="'+mss[i]+'" />';
										}
									}
								}
							}
							$('#wlmc').html(html);
							mini.parse();
						}
					});
		}

		function upload() {
			canCheck=false;
			var data = {};
			var fileids = [ 'myfile' ];
			$.ajaxFileUpload({
						url : '${pageContext.request.contextPath}/encoding/uploadfile.do',
						secureuri : false,
						fileElementId : fileids, //这里不在是以前的id了，要写成数组的形式哦！  数组内容是文件控件的ID名称
						dataType : 'json',
						data : data,//需要传输的数据  
						success : function(data) {
							if (data.success) {
								files.push(mini.decode(data.file, true));
								$("#reload")
										.empty()
										.html(
												"<input class='mini-htmlfile' name='myfile'  id='myfile' width='100%' onfileselect='upload' />");
								mini.parse();
								showfiles();
								canCheck=true;
							} else {
								mini.alert(data.error);
								canCheck=true;
							}
						},
						error : function(data) {
							var reg = /<pre.+?>(.+)<\/pre>/g;
							var result = data.responseText.match(reg);
							data.responseText = RegExp.$1;
							var fun = jQuery
									.parseJSON(data.responseXML.activeElement.innerText);
							if (fun.success) {
								files.push(mini.decode(fun.file, true));
								$("#reload")
										.empty()
										.html(
												"<input class='mini-htmlfile' name='myfile'  id='myfile' width='100%' onfileselect='upload' />");
								mini.parse();
								showfiles();
								canCheck=true;
							} else if (fun.error) {
								mini.alert(fun.error);
								canCheck=true;
							} else if (fun.error) {
								mini.alert(fun.error);
								canCheck=true;
							} else {
								mini.alert("服务器异常上传失败，请重新尝试！");
								canCheck=true;
							} //tomcat 使用
							//mini.alert("服务器异常，请重新尝试！","失败",window.CloseOwnerWindow);
						}
					});
		}

		function showfiles() {
			if (files.length > 0) {
				var tids = "";
				for (var i = 0; i < files.length; i++) {
					if (i == 0) {
						tids = files[0].id;
					} else {
						tids = tids + "," + files[i].id;
					}
				}
				fileidstr = tids;
			}
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