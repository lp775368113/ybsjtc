//jQuery time
var current_fs, next_fs, previous_fs; //fieldsets
var left, opacity, scale; //fieldset properties which we will animate
var animating; //flag to prevent quick multi-click glitches
var usable=false;//注册帐号是否可用

$(".next").click(function(){
	if(animating) return false;
	animating = true;
	current_fs = $(this).parent();
	next_fs = $(this).parent().next();
	$("#progressbar li").eq($("fieldset").index(next_fs)).addClass("active");
	next_fs.show(); 
	current_fs.animate({opacity: 0}, {
		step: function(now, mx) {
			scale = 1 - (1 - now) * 0.2;
			left = (now * 50)+"%";
			opacity = 1 - now;
			current_fs.css({'transform': 'scale('+scale+')'});
			next_fs.css({'left': left, 'opacity': opacity});
		}, 
		duration: 400, 
		complete: function(){
			current_fs.hide();
			animating = false;
		}, 
		easing: 'easeInOutBack'
	});
});

$(".previous").click(function(){
	if(animating) return false;
	animating = true;
	
	current_fs = $(this).parent();
	previous_fs = $(this).parent().prev();
	
	$("#progressbar li").eq($("fieldset").index(current_fs)).removeClass("active");
	
	previous_fs.show(); 
	current_fs.animate({opacity: 0}, {
		step: function(now, mx) {
			scale = 0.8 + (1 - now) * 0.2;
			left = ((1-now) * 50)+"%";
			opacity = 1 - now;
			current_fs.css({'left': left});
			previous_fs.css({'transform': 'scale('+scale+')', 'opacity': opacity});
		}, 
		duration: 400, 
		complete: function(){
			current_fs.hide();
			animating = false;
		}, 
		easing: 'easeInOutBack'
	});
});
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

function tj(){
	if(!usable&&loginname!=''){
		window.wxc.xcConfirm("用户名不可用！", window.wxc.xcConfirm.typeEnum.warning);
		return;
	}
	$(".submit").attr("disabled", true); 
	var loginname=$("#loginname").val();
	var password=$("#password").val();
	var cpassword=$("#cpassword").val();
	var vsername=$("#vsername").val();
	var uPattern = /^[a-zA-Z0-9_-]{4,50}$/;
	var pPattern = /^.*(?=.{6,})(?=.*\d)(?=.*[A-Z])(?=.*[a-z]).*$/;
	if(!uPattern.test(loginname)){
		window.wxc.xcConfirm("用户名4位以上，只能包含（字母，数字，下划线，减号）！", window.wxc.xcConfirm.typeEnum.warning);
		$(".submit").attr("disabled", false);
		return;
	}else if(!pPattern.test(password)){
		window.wxc.xcConfirm("密码必须包含英文字母大小写和数字，且长度最小6位！", window.wxc.xcConfirm.typeEnum.warning);
		$(".submit").attr("disabled", false); 
		return;
	}else if(password!=cpassword){
		window.wxc.xcConfirm("两次密码输入不相同。", window.wxc.xcConfirm.typeEnum.error);
		$(".submit").attr("disabled", false); 
		return;
	}else if($.trim(vsername)==''){
		window.wxc.xcConfirm("真实姓名不能为空！", window.wxc.xcConfirm.typeEnum.warning);
		$(".submit").attr("disabled", false); 
		return;
	}
	var d = {};
    var t = $('form').serializeArray();
    $.each(t, function() {
      d[this.name] = this.value;
    });
    var data =JSON.parse(JSON.stringify(d));;
    $.ajax({
		url:getRootPath_web()+"/user/signin.do",
		type:"post",
		dataType:"json",
		data:data,
		success : function(result){
			if(result.success){
				var txt=  "注册成功，请等待管理员分配权限。";
				var option = {
					title: "注册成功！",
					btn: parseInt("0001",2),
					onOk: function(){
						window.location.href=getRootPath_web()+"/login.jsp"; 
					}
				}
				window.wxc.xcConfirm(txt, "custom", option);
				
			}else if(result.error){
				window.wxc.xcConfirm("系统错误:"+result.error, window.wxc.xcConfirm.typeEnum.error);
				$(".submit").attr("disabled", false); 
			}
		}
	});
}

$("#loginname").blur(function(e){
	var loginname=$("#loginname").val();
	if(loginname==''){
		window.wxc.xcConfirm("请输入用户名！", window.wxc.xcConfirm.typeEnum.warning);
	}
	var data={};
	data.loginname=loginname;
	$.ajax({
		url:getRootPath_web()+"/user/getloginname.do",
		type:"post",
		dataType:"json",
		data:data,
		success : function(result){
			if(!result.usable){
				usable=false;
				window.wxc.xcConfirm("用户名已被注册！", window.wxc.xcConfirm.typeEnum.warning);
			}
			if(result.usable){
				usable=true;
			}
			else if(result.error){
				window.wxc.xcConfirm("系统错误:"+result.error, window.wxc.xcConfirm.typeEnum.error);
			}
		}
	});
}) 

 
