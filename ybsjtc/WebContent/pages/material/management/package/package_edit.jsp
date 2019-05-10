<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<head>
<title>大类编辑页面</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/resource/scripts/ajaxfileupload.js"></script>
<style type="text/css">
html,body {
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
</style>
</head>
<body>
    
    <div id="form1">
    <input class="mini-hidden" name="id" id="id" />
    <input class="mini-hidden" name="action" id="action" />
        <table class="table" border="0px" width="100%"  style="border-spacing: 0px 10px;">
            <tr>
                <th class="mini_title">封装名称：</th>
                <td><input id="packagename" name="packagename" class="mini-textbox"
                    required="true" width="80%" /></td>
            </tr>
            <tr>
                <th class="mini_title">工序：</th>
                <td><input class="mini-combobox" name="process"
							id="process" required="true" width="80%"
							data="[{text:'无',code:0},{text:'SMT',code:1},{text:'DIP',code:2}]"
							textField="text" valueField="code" /></td>
            </tr>
            <tr>
                <th class="mini_title">描述：</th>
                <td><input id="description" name="description"
                    class="mini-textarea" width="80%" /></td>
            </tr>
            <tr>
                <th class="mini_title">图片1：</th>
                <td id="con1" ><input class="mini-htmlfile" name="images" id="file1" limitType="*.jpeg;*.png;*.bmp;*.jpg" 
								width="80%" /></td>
            </tr>
            <tr>
                <th class="mini_title">图片2：</th>
                <td id="con2"><input class="mini-htmlfile" name="images" id="file2" limitType="*.jpeg;*.png;*.bmp;*.jpg" 
								width="80%"  /></td>
            </tr>
            <tr>
                <th class="mini_title">图片3：</th>
                <td id="con3"><input class="mini-htmlfile" name="images" id="file3" limitType="*.jpeg;*.png;*.bmp;*.jpg" 
								width="80%"  /></td>
            </tr>
            <tr>
                <th class="mini_title">图片4：</th>
                <td id="con4"><input class="mini-htmlfile" name="images" id="file4" limitType="*.jpeg;*.png;*.bmp;*.jpg" 
								width="80%" /></td>
            </tr>
            <tr>
                <th class="mini_title">图片5：</th>
                <td id="con5"><input class="mini-htmlfile" name="images" id="file5" limitType="*.jpeg;*.png;*.bmp;*.jpg" 
								width="80%" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <div class="operate">
                        <button id="saveBtn" type="button" class="bc_color"
                            onclick="save();">
                            <span class="bc"></span>保存
                        </button>
                    </div>
                </td>
            </tr>
        </table>
        </div>
        <script type="text/javascript">
            mini.parse();
            function setData(data) {
            	data = mini.clone(data);
            	console.log(data);
                var mode = data.action;
                if (mode == "add") {
                	mini.get("action").setValue("add");
                    return;
                }
                var form = new mini.Form("#form1");
                form.setData(data);
                showImages(data);
            }
            
            function showImages(data){
            	if(data.icon1){
            		$("#con1").append('<a target="_blank" href="${pageContext.request.contextPath}/resource/images/package/'+data.icon1+'">&nbsp&nbsp图&nbsp1</a>');
            	}
            	if(data.icon2){
            		$("#con2").append('<a target="_blank" href="${pageContext.request.contextPath}/resource/images/package/'+data.icon2+'">&nbsp&nbsp图&nbsp2</a>');
            	}
            	if(data.icon3){
            		$("#con3").append('<a target="_blank" href="${pageContext.request.contextPath}/resource/images/package/'+data.icon3+'">&nbsp&nbsp图&nbsp3</a>');
            	}
            	if(data.icon4){
            		$("#con4").append('<a target="_blank" href="${pageContext.request.contextPath}/resource/images/package/'+data.icon4+'">&nbsp&nbsp图&nbsp4</a>');
            	}
            	if(data.icon5){
            		$("#con5").append('<a target="_blank" href="${pageContext.request.contextPath}/resource/images/package/'+data.icon5+'">&nbsp&nbsp图&nbsp5</a>');
            	}
            	
            }

            function save() {
            	var form = new mini.Form("#form1");
                form.validate();
                if (form.isValid() == false) {
                    return;
                }
                var data = form.getData(true);
                var file1=mini.get("file1").getValue();
                if(data.action=="add"&&file1==''){
                	mini.alert("图片1必须选一张封装图!");
                	return;
                }
    			var fileids = [ 'file1','file2','file3','file4','file5' ];
    			$.ajaxFileUpload({
    						url : '${pageContext.request.contextPath}/package/editpackage.do',
    						secureuri : false,
    						fileElementId : fileids, //这里不在是以前的id了，要写成数组的形式哦！  数组内容是文件控件的ID名称
    						dataType : 'json',
    						data : data,//需要传输的数据  
    						success : function(data) {
    							if (data.success) {
									mini.alert("保存成功！", "成功",
											window.CloseOwnerWindow);
								} else {
									mini.alert(data.message, "失败",
											window.CloseOwnerWindow);
								}
    						},
    						error : function(data) {
    							var reg = /<pre.+?>(.+)<\/pre>/g;
    							var result = data.responseText.match(reg);
    							data.responseText = RegExp.$1;
    							var fun = jQuery
    									.parseJSON(data.responseXML.activeElement.innerText);
    							if (fun.success) {
    								if (fun.success) {
    									mini.alert("保存成功！", "成功",
    											window.CloseOwnerWindow);
    								} else {
    									mini.alert(fun.message, "失败",
    											window.CloseOwnerWindow);
    								}
    							} else if (fun.message) {
    								mini.alert(fun.message);
    							} else if (fun.message) {
    								mini.alert(fun.message);
    							} else {
    								mini.alert("服务器异常上传失败，请重新尝试！");
    							} //tomcat 使用
    							//mini.alert("服务器异常，请重新尝试！","失败",window.CloseOwnerWindow);
    						}
    					});
    		}

        </script>
</body>
</html>