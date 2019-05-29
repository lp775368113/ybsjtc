$(document).ready(function() { 
	function getRootPath_web() {
	    //获取当前网址，如： http://localhost:8083/uimcardprj/share/meun.jsp
	    var curWwwPath = window.document.location.href;
	    //获取主机地址之后的目录，如： uimcardprj/share/meun.jsp
	    var pathName = window.document.location.pathname;
	    var pos = curWwwPath.indexOf(pathName);
	    //获取主机地址，如： http://localhost:8083
	    var localhostPaht = curWwwPath.substring(0, pos);
	    //获取带"/"的项目名，如：/uimcardprj
	    var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
	    return (localhostPaht + projectName);
	}
	
	$.ajax({
		url : getRootPath_web()+"/button/buttonPer.do",
		type : "post",
		dataType : "json",
		cache : false,
		success : function(data) {
			if (data.success) {
				var buttons=data.buttons;
				for (var i = 0; i < buttons.length; i++) {
					$("#"+buttons[i].buttonid).attr("style","display:inline;");
				}
			} else {
				mini.alert("按钮权限出现异常，请关闭后重试，或联系管理员。", "出错啦！");
			}
		}
	});
	
	
}); 