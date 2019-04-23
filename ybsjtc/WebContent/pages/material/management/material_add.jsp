<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>物料新增</title>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resource/scripts/jquery-1.10.0.min.js"></script> --%>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/scripts/ajaxfileupload.js"></script>
<style type="text/css">
html, body {
	font-size: 12px;
	padding: 0;
	margin: 0;
	border: 0;
	height: 100%;
	overflow: hidden;
}
.mini-panel-header{
	background-color:#E0EEEE;
}
.mini-panel-body{
padding:0px;
}
#form2 table tr {
	height:10px;
}
</style>
</head>
<body>

	  <div class="mini-fit">
			<form id="form2" name="form2" style="padding-top:10px" action="#" method="post">
				<table cellpadding="0" class="main-table" cellspacing="10px" border="0px"
					width="98%">
					
					<tr >
						<td  width="16%" class="mini_title"><span style="color: red">*</span>大类名称：</td>
						<td  width="16%"><input id="maxclass" name="maxclass" class="mini-combobox"  
						  url="${pageContext.request.contextPath}/encoding/getMaxClass.do"  onvaluechanged="onClassChanged" required="true"  textField="largeclassname"  width="100%"  valueField="largeclass" /></td>
						<td width="16%" class="mini_title"><span style="color: red">*</span>小类名称：</td>
						<td  width="16%"><input id="prodCodeSellPtr" name="prodCodeSellPtr" class="mini-combobox"  
						  url="" 	 required="true"  textField="smallclassname" width="100%" valueField="rkey" onvaluechanged="setWLMS" />
					    </td>
					    <td width="16%" class="mini_title">封装：</td>
					    <td  width="16%"><input id="package_" name="package_" class="mini-textbox"   width="100%"/></td>					
					</tr>	
					<tr>
					    <td class="mini_title" width="16%"><span style="color: red">*</span>厂商料号：</td>
						<td  width="16%"><input class="mini-textbox" name="custPartCode"  id="custPartCode" required="true"  width="100%" />
						<td class="mini_title" width="16%"><span style="color: red">*</span>SMT/DIP：</td>
						<td  width="16%"><input class="mini-combobox" name="smtFlag"  id="smtFlag" required="true" width="100%"  data="[{text:'---',code:0},{text:'SMT',code:1},{text:'DIP',code:2}]"  textField="text"  valueField="code" />
					    </td>
					    <td class="mini_title" width="16%">制造商：</td>
						<td  width="16%"><input class="mini-textbox" name="prodSupper"  id="prodSupper" width="100%" />
					    </td>
					</tr>
					<tr>
					    <td class="mini_title" width="16%">供应商物料名称：</td>
						<td  width="16%"><input class="mini-textbox" name="custPartName"  id="custPartName"   width="100%" />
						<td class="mini_title" width="16%"></td>
						<td  width="16%">
					    </td>
					    <td class="mini_title" width="16%"></td>
						<td  width="16%">
					    </td>
					</tr>
					<tr>
					    <td class="mini_title" width="16%"><span style="color: red">*</span>物料名称(描述)：
					    <input class="mini-hidden" name="invPartDescriptionC" id="invPartDescriptionC"  /> 
					    </td>
						<td  width="100%" colspan="5" id="wlmc">
						
					    </td>
					</tr>
					<tr>
					    <td class="mini_title" width="16%"><span style="color: red">*</span>包装单位：</td>
						<td  width="16%"><input id="purchUnitPtr" name="purchUnitPtr" class="mini-combobox"  
						  url="${pageContext.request.contextPath}/encoding/getUnit.do"  required="true"  textField="unit_name" width="100%" valueField="rkey"/>
					    </td>
					    <td class="mini_title" width="16%"><span style="color: red">*</span>仓存单位：</td>
						<td  width="16%"><input id="stockUnitPtr" name="stockUnitPtr" class="mini-combobox"  
						  url="${pageContext.request.contextPath}/encoding/getUnit.do"  required="true"  textField="unit_name" width="100%" valueField="rkey"/>
					    </td>
					    <td class="mini_title" width="16%"><span style="color: red">*</span>优先供应商：</td>
						<td  width="16%"><input id="supplierPtr" name="supplierPtr" class="mini-combobox"  valueFromSelect="true"
						  url="${pageContext.request.contextPath}/encoding/getSupplier.do"  required="true"  textField="supplier_name" width="100%" valueField="rkey" allowInput="true" value="1"  readonly="true"/>
					    </td>
					</tr>
					<tr>
					    <td class="mini_title" width="16%"><span style="color: red">*</span>包装数量：</td>
						<td  width="16%"><input class="mini-textbox" name="stockPurch"  id="stockPurch" width="100%" required="true" vtype="float" value="1"  readonly ="true"/>
					    </td>
					    <td class="mini_title" width="16%"><span style="color: red">*</span>核算单价：</td>
						<td  width="16%"><input class="mini-textbox" name="stdCost"  id="stdCost" width="100%" required="true" vtype="float" />
					    </td>
					</tr>
					<tr>
					    <td class="mini_title" width="16%"><span style="color: red">*</span>IQC检查：</td>
						<td  width="16%">
						<input class="mini-combobox" name="iqcFlag"  id="iqcFlag" required="true" width="100%"  value="N" data="[{text:'否',code:'N'},{text:'是',code:'Y'}]"   textField="text"  valueField="code" />
					    </td>
					    <td class="mini_title" width="16%"><span style="color: red">*</span>安全库存：</td>
						<td  width="16%"><input class="mini-textbox" name="stockPakQty"  required="true" id="stockPakQty" value=0 width="100%" vtype="float"/>
					    </td> 
					    <td class="mini_title" width="16%"><span style="color: red">*</span>停止采购：</td>
						<td  width="16%"><input class="mini-combobox" name="stopPurch"  id="stopPurch" required="true" width="100%"  value="N"data="[{text:'否',code:'N'},{text:'是',code:'Y'}]"   textField="text"  valueField="code" />
					    </td>
					</tr>
					<tr>
					    <td class="mini_title" width="16%">重量（kg）：</td>
						<td  width="16%"><input class="mini-textbox" name="qtyPerK"  id="qtyPerK" width="100%"  value=0 vtype="float"/>
					    </td>
					    <td class="mini_title" width="16%">宽度（cm）：</td>
						<td  width="16%"><input class="mini-textbox" name="mwidth"  id="mwidth" width="100%" value=0 vtype="float"/>
					    </td>
					    <td class="mini_title" width="16%">长度（cm）：</td>
						<td  width="16%"><input class="mini-textbox" name="mlength"  id="mlength" width="100%" value=0 vtype="float"/>
					    </td>
					</tr>
					<tr>
					    <td class="mini_title" width="16%">采购间隔：</td>
						<td  width="16%"><input class="mini-textbox" name="restIqcDate"  id="restIqcDate" width="100%" value=0 vtype="float"/>
					    </td>
					    <td class="mini_title" width="16%">标准机器工时（s）：</td>
						<td  width="16%"><input class="mini-textbox" name="machH"  id="machH" width="100%" value=0 vtype="float"/>
					    </td>
					    <td class="mini_title" width="16%">标准人工工时（s）：</td>
						<td  width="16%"><input class="mini-textbox" name="workManH"  id="workManH" width="100%" value=0  vtype="float"/>
					    </td>
					</tr>
					</table>
					<table>
					<tr>
						<td colspan="2" width="40%"></td>
					    <td colspan="1"  width="20%">
							<div style="width: 300px" class="operate">
								<button id="button_save" type="button" class="bc_color" onclick="save();" >
									<span class="bc"></span>审批
								</button>
								<button type="button" class="cz_color" onclick="resetForm()">
									<span class="cz"></span>重置
								</button>
							</div>
						</td>
						<td colspan="2"  width="40%"></td>
					</tr>
				</table>
			</form>
	  </div>
	<script type="text/javascript">
		mini.parse();
		var form = new mini.Form("form2");
		var MS=0;
		function SetData(data) {
		 	//跨页面传递的数据对象，克隆后才可以安全使用
			data = mini.clone(data);
        }
		function save(){
			mini.get("button_save")
			 form.validate();
			if (form.isValid() == false) {
				return;
			} 
			var data = form.getData(true);
			var invPartDescriptionC='';
			for(var i=0;i<MS;i++){
				var key='MS'+i;
				if(i==0){
					invPartDescriptionC=data[key];
				}else{
					invPartDescriptionC=invPartDescriptionC+'-'+data[key];
				}
			}
			mini.get("invPartDescriptionC").setValue(invPartDescriptionC);
			var data = form.getData(true);
			$.ajax({
				url : "${pageContext.request.contextPath}/encoding/saveData0017.do",
				type : "post",
				dataType : "json",
				cache : false,
				data :data, 
				success : function(data) {
					if(data.success){
						mini.alert("成功发起审批！","成功",window.CloseOwnerWindow);
					}else{
						mini.alert(data.message,"失败",window.CloseOwnerWindow);
					}
				}
			});
		}
		
		function onClassChanged(){
			var maxclass=mini.get("maxclass");
			var largeclass=maxclass.getValue();
			var url = "${pageContext.request.contextPath}/encoding/getMinClass.do?LargeClass=" + largeclass;
            mini.get("prodCodeSellPtr").setUrl(url);
		}
		
		function resetForm() {
			form.setData(model);
		}
		
		function setWLMS(){
			var prodCodeSellPtr=mini.get("prodCodeSellPtr");
			var rkey=prodCodeSellPtr.getValue();
			console.log(rkey);
			$.ajax({
				url : "${pageContext.request.contextPath}/encoding/getWLMS.do",
				type : "post",
				dataType : "json",
				cache : false,
				data : {"key":rkey},
				success : function(data) {
					var html='';
					var btname='MS'
					var smallinformation=data.smallinformation;
					var mss=smallinformation.split("-");
					MS=mss.length;
					for(var i=0;i<mss.length;i++){
						var box=mss[i].split("|");
						console.log(box.length);
						if(box.length>1){
							var data="";
							for(var j=0;j<box.length;j++){
								if(j==0){
									data="[{text:'"+box[j]+"',code:'"+box[j]+"'}";
								}else if(j==box.length-1){
									data=data+",{text:'"+box[j]+"',code:'"+box[j]+"'}]";
								}else{
									data=data+",{text:'"+box[j]+"',code:'"+box[j]+"'}";
								}
							}
							if(i==0){
								html='<input class="mini-combobox" name="'+btname+i+'" required="true" width="130px"  data="'+data+'"  textField="text"  valueField="code" />';
							}else{
								html=html+' 一 <input class="mini-combobox" name="'+btname+i+'" required="true" width="130px"  data="'+data+'"  textField="text"  valueField="code" />';
							}
						}else{
							if(i==0){
								html='<input class="mini-textbox"  name="'+btname+i+'"  width="100px" required="true" value="'+mss[i]+'" />';
							}else{
								html=html+' 一  <input class="mini-textbox"  name="'+btname+i+'"  width="100px" required="true" value="'+mss[i]+'" />';
							}
						}
					}
					$('#wlmc').html(html);
					mini.parse();
				}
			});
		}

	</script>
</body>

</html>