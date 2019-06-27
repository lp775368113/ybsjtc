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
			<input class="mini-hidden" name="id" id="id" />
			<table width="100%">
				<tr>
					<td align="center">
					<input class="mini-htmlfile" name="myfiles"  id="file0" width="50%"  limitType="*.xlsx;*.xls"/>	
					</td>
				</tr>
				<tr>
					<td align="center">
						<div class="operate">
							<button id="button_save" type="button" class="bc_color"
								onclick="importBOM();">
								<span class="bc"></span>导入
							</button>
							<button id="button_reset" type="button" class="cz_color"
								onclick="resetForm()">
								<span class="cz"></span>重置
							</button>
						</div>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript">
		mini.parse();
		var form = new mini.Form("form2");
		function SetData(data) {
			//跨页面传递的数据对象，克隆后才可以安全使用
			data = mini.clone(data);
			form.setData(data);
		}
		
		function importBOM(){
			var file=mini.get("file0").getValue();
			if(file==""){
				mini.alert("请选择你需要导入的Excel文件！");
				return;
			}
			var data = form.getData(true);
			var fileids= ['file0'];
	         $.ajaxFileUpload({
	                    url:'${pageContext.request.contextPath}/bom/importBom.do',  
	                    secureuri:false,  
	                    fileElementId:fileids,     //这里不在是以前的id了，要写成数组的形式哦！  数组内容是文件控件的ID名称
	                    dataType: 'json',  
	                    data:data,//需要传输的数据  
	                    success:function(data){
	                    	if(data.success){
	                    		mini.alert("导入成功！","成功",window.CloseOwnerWindow);
	                    	}else{
	                    		mini.alert(fun.message,"失败",window.CloseOwnerWindow);
	                    	}
	                    		
	                    },
	                    error: function(data){
	                   	var reg = /<pre.+?>(.+)<\/pre>/g; 
							var result = data.responseText.match(reg);  	
							data.responseText= RegExp.$1;	
							var fun= jQuery.parseJSON(data.responseXML.activeElement.innerText); 	
							fun.success
	                    	if(fun.success){
	                    		mini.alert("导入成功！","成功",window.CloseOwnerWindow);
	                    	}else{
	                    		mini.alert(fun.message,"失败",window.CloseOwnerWindow);
	                  		}
	                    }  
	      });   
		}
		
		function resetForm() {
			form.reset();
		}
	</script>
</body>

</html>