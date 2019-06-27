<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>物料新增</title>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/resource/scripts/jquery-1.10.0.min.js"></script> --%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/scripts/ajaxfileupload.js"></script>
<script type="text/javascript" src="http://g.alicdn.com/dingding/open-develop/1.6.9/dingtalk.js"></script>
    <script type="text/javascript" src="http://g.alicdn.com/dingding/dingtalk-pc-api/2.3.1/index.js"></script>
<style type="text/css">
html, body {
	font-size: 20px;
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
		<p style="text-align: center;">
		<form id="form2" name="form2" style="padding-top: 10px" action="#"
			method="post">
			<table border="0px" cellpadding="0" cellspacing="0" width="804" 
				align="center"
				style="border-collapse: collapse; width: 603.02pt; margin: 0 auto;"
				class="ke-zeroborder">
				<tr>
					<td colspan="4" class="et2" width="804" style="text-align: center;"><span
						style="font-size: 40px;">工程变更通知</span></td>
				</tr>
			</table>
		<table border="1px" cellpadding="0" cellspacing="0" width="804" id="tab"
			align="center" 
			style="border-collapse: collapse; width: 603.02pt; margin: 0 auto;"
			class="ke-zeroborder">
			<tr>
				<td class="et7" class="mini_title" align="right" height="35px"  >工程变更主题：</td>
				<td colspan="3" class="et8"><input class="mini-textbox" id="theme" required="true" name="theme" width="100%"   /></td>
			</tr>
			<tr>
				<td class="et3" class="mini_title" align="right" height="35px" >工程变更编号：</td>
				<td class="et4"><input class="mini-textbox asLable" borderStyle="border:0px;"  enabled="false" style="cursor: hand; width: 100%" id="id"  name="id" width="100%"   /></td>
				<td class="et5" class="mini_title" align="right">要求切入日期：</td>
				<td class="et6"><input class="mini-datepicker" id="cutDate" required="true" name="cutDate" width="100%"   /></td>
			</tr>
			<tr>
				<td class="et7" class="mini_title" align="right" height="35px"  >变更适用机种：</td>
				<td colspan="3" class="et8"><input class="mini-textbox" id="tryto"  name="tryto" required="true" width="100%"   /></td>
			</tr>
			<tr>
				<td class="et14" class="mini_title" align="right" height="35px"  >变更原因：</td>
				<td class="et15" colspan="3" width="228"><input class="mini-textbox" id="why"  name="why" required="true" width="100%"   /></td>
			</tr>
			<tr>
				<td class="et14" class="mini_title" align="right" height="200px"  >变更内容概述：</td>
				<td colspan="3" class="et18" width="653">
					<input class="mini-textarea" id="summarize"  name="summarize" required="true" width="100%" height="200px"  />
				</td>
			</tr>
			<tr>
				<td class="et14" class="mini_title" align="right" height="60px"  >备注：</td>
				<td colspan="3" class="et18" width="653">
					<input class="mini-textarea" id="remark"  name="remark"   width="100%" height="100px"  />
				</td>
			</tr>
			<!-- <tr>
				<td class="et34" width="151" align="center"  height="60px"  >关联的BOM</td>
				<td class="et34" width="228" class="mini_title" align="right" >厂商料号：</td>
				<td class="et34" width="228"colspan="2" ></td>
			</tr>
			<tr>
				<td class="et23" colspan="2" align="center"  height="60px" >物料料号</td>
				<td colspan="2" class="et24" align="center" >修改内容</td>
			</tr>
			<tr height="30px" >
				<td colspan="4">&nbsp</td>
			</tr> -->
			</tbody>
		</table>
		<table>
				<tr>
					<td colspan="2" width="40%"></td>
					<td colspan="1" width="20%">
						<div style="width: 300px" class="operate">
							<button id="button_save" type="button" class="bc_color"
								onclick="save();">
								<span class="bc"></span>发起审批
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
		</p>
	</div>
	<script type="text/javascript">
		mini.parse();
		var form = new mini.Form("form2");
		var material={};
		var demo={};
		var lodecn={};
		function SetData(model) {
			//跨页面传递的数据对象，克隆后才可以安全使用
			model = mini.clone(model);
			lodecn=model;
			setEcnValue(model);
		}
		function setEcnValue(model){
			console.log(model);
			var data={};
			getOneMaterial(model.productid);
			data.tryto=material.invPartDescriptionC;
			var whyArray=[];//变更原因数组
			var summarize="";//概述
			var html="";//
			for(let key  in model){
				if(key!="productid"){
					getOneMaterial(key);
					summarize+="变更【"+material.custPartCode+"】BOM:\n      将";
					html+='<tr><td class="et34" width="151" align="center"  height="60px"  >关联的BOM</td>'+
						  '<td class="et34" width="228" class="mini_title" align="right" >厂商料号：</td>'+
					      '<td class="et34" width="228"colspan="2" >'+material.custPartCode+'</td></tr>'+
					      '<tr><td class="et23" colspan="2" align="center"  height="60px" >物料料号</td>'+
					      '<td colspan="2" class="et24" align="center" >修改内容</td></tr>';
					for(var i=0;i<model[key].length;i++){
						var j=i+1;
						whyArray.pushNoRepeat(model[key][i].operation);
						if(model[key][i].operation=="replace"){
							summarize+=j+":【"+model[key][i].custPartCode+"】做为【"+model[key][i].replacecode+"】代替料。";
							html+='<tr><td class="et23" colspan="2" align="center"  height="60px" >'+model[key][i].replacecode+'</td>'+
								'<td colspan="2" class="et24" align="center" >'+model[key][i].custPartCode+'做为'+model[key][i].replacecode+'的替代料'+'</td></tr>';
						}else if(model[key][i].operation=="added"){
							summarize+=j+":"+"该BOM新增【"+model[key][i].custPartCode+"】物料。";
							html+='<tr><td class="et23" colspan="2" align="center"  height="60px" >'+model[key][i].custPartCode+'</td>'+
							'<td colspan="2" class="et24" align="center" >'+'新增物料'+model[key][i].custPartCode+'</td></tr>';
						}else if(model[key][i].operation=="removed"){
							summarize+=j+":"+"该BOM删除【"+model[key][i].custPartCode+"】物料。";
							html+='<tr><td class="et23" colspan="2" align="center"  height="60px" >'+model[key][i].custPartCode+'</td>'+
							'<td colspan="2" class="et24" align="center" >'+'删除物料'+model[key][i].custPartCode+'</td></tr>';
						}else if(model[key][i].operation=="modified"){
							summarize+=j+":"+"该BOM修改【"+model[key][i].custPartCode+"】物料贴装参数。";
							html+='<tr><td class="et23" colspan="2" align="center"  height="60px" >'+model[key][i].custPartCode+'</td>'+
							'<td colspan="2" class="et24" align="center" >'+'修改物料'+model[key][i].custPartCode+'贴装参数'+'</td></tr>';
						}
						if(i==model[key].length-1){
							summarize+="\n";
							html+='<tr height="30px" ><td colspan="4">&nbsp</td></tr>';
						}
					} 
				}
		  	}
			var why="";
			for(var i=0;i<whyArray.length;i++){
				if(i==0){
					if(whyArray[i]=="added"){
						why="新增物料";
					}else if(whyArray[i]=="removed"){
						why="删除物料";
					}else if(whyArray[i]=="modified"){
						why="修改物料贴装参数";
					}else if(whyArray[i]=="replace"){
						why="新增替换料";
					}
				}else{
					if(whyArray[i]=="added"){
						why=why+",新增物料";
					}else if(whyArray[i]=="removed"){
						why=why+",删除物料";
					}else if(whyArray[i]=="modified"){
						why=why+",修改物料贴装参数";
					}else if(whyArray[i]=="replace"){
						why=why+",新增替换料";
					}
				}
			}
			$("#tab").append(html);
			data.why=why;
			data.summarize=summarize;
			demo=data;
			form.setData(data);
		}
		Array.prototype.pushNoRepeat = function(){
		    for(var i=0; i<arguments.length; i++){
		      var ele = arguments[i];
		      if(this.indexOf(ele) == -1){
		          this.push(ele);
		      }
		  }
		};
		
		function getOneMaterial(id){
			var data={};
			data.id=id;
			$.ajax({
				url : "${pageContext.request.contextPath}/encoding/getOneMaterial.do",
				type : "post",
				dataType : "json",
				cache : false,
				data : data,
				async:false,
				success : function(data) {
					material=data;
				}
			});
		}
		
		function resetForm(){
			form.setData(demo);
		}
		
		function save(){
			form.validate();
			if (form.isValid() == false) {
				return;
			}
			var data = form.getData(true);
			var allData={};
			allData.ecn=mini.encode( data );
			allData.edit=mini.encode( lodecn );
			$.ajax({
				url : "${pageContext.request.contextPath}/bom/editBom.do",
				type : "post",
				dataType : "json",
				cache : false,
				data : allData,
				success : function(data) {
					if (data.success) {
						mini.alert("成功发起审批！", "成功",
								window.CloseOwnerWindow);
					} else {
						mini.alert(data.message, "失败",
								window.CloseOwnerWindow);
					}
				}
			});  
		}
		
		
	</script>
</body>

</html>