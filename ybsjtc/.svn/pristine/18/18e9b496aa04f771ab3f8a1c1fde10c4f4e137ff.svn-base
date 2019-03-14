/**
*** 表格相关的JS
*** author:xieguojun
***
**/

/**
*** 获取grid表格当前页的json数据
*** gridid:grid标签设置的id属性值
*** selectedOnly:只获取选中行标识
*** dicTransAble:是否转换字典代码,暂不提供支持
**/
function getGridJosnData(gridid,selectedOnly,dicTransAble){
	var grid =Ext.getCmp(gridid);
	
	if(!isNull(gridid))
		return "";
		
	var records;
	
	if(!isNull(selectedOnly)){
		//按照选中行
		records = grid.getSelectionModel().getSelections();
	}else{
	   //按照全部
		var store =grid.getStore();
	
		if(!isNull(store))
			return "";
			
		records=store.getRange();
	}
	
	var json="";
		
	return json;
}
/** 
*** 编码store record，不对字典值进行转换
***
**/
function encode(records){
	var json="";
	for(var i=0;i<records.length;++i){
		if(i==0)
			json =Ext.util.JSON.encode(records[i].data);
		else
			json+=","+Ext.util.JSON.encode(records[i].data);
	}
	
	return json;
}

/**
*** 编码store record，对字典值进行转换
***
**/
function encode2(records){
	var json="";
	for(var i=0;i<records.length;++i){
		if(i==0)
			json =Ext.util.JSON.encode(records[i].data);
		else
			json+=","+Ext.util.JSON.encode(records[i].data);
	}
	
	return json; 
}

function isNull(v){
	return typeof v =='undefined' || v;
}