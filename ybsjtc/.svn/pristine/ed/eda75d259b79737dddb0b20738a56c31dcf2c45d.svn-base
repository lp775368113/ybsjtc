/**
*** 文件上传工具 xieguojun
***/

Ext.namespace('Yzsb.file');

Yzsb.file.upload =function(formId,successFunc,errorFunc,timeout,cwFormId){
 		
 		var form =document.getElementById(formId);
 		
 		var url =form.action;
 		
 		var params ={};
 		
 		if(typeof url =='undefined'){
 			Ext.Msg.alert('提示','请设置form的action!');  
			return;
 		}
 		
 		var t =3000;
 		
 		if(typeof timeout !='undefined' && timeout)
 			t =timeout;
 			
 		
 		if(typeof cwFormId !='undefined' && cwFormId){
 			var cwForm =Ext.getCmp(cwFormId).getForm();
 			
 			params =cwForm.getValues();
 		}
		
		var conn =new Ext.data.Connection({
			autoAbort: false,  
		    disableCaching : false,  
		    method : 'POST',  
		    timeout : t,  
		    url :url,
		    extraParams:params
		});
		
		var myMask = new Ext.LoadMask(document.body, {msg:"正在处理，请等待..."});
		myMask.show();
		conn.request({
			form:formId,
			method:'POST',
			isUpload:true,
			success: function(options,response) {  
				myMask.hide();
			
				var form ={}; 
				var json=null;
				
				json =Ext.decode(options.responseText);
				
				form.response=options;
				form.exception=json.exception;
			 
				if(json.success){
					if(typeof successFunc =='function')
						successFunc(response,form);
					else
						Ext.Msg.alert('提示', '操作成功！');  	
				}else{
					if(typeof errorFunc =='function')
						errorFunc(response,form);
					else
						Ext.Msg.alert('提示', '操作失败！异常信息:['+json.exception[0].msg+']'); 					
				} 
		    },  
		    failure: function(options,response) {  
		    	myMask.hide();
		    	
		    	var form ={}; 
				form.response=options;
		        if(typeof errorFunc =='function')
					successFunc(response,form);
				else
					Ext.Msg.alert('提示', '操作失败！'); 
				
			}
		});
		 
}	