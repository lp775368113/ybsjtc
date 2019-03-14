/**
*** 表格相关的JS
*** author:xieguojun
***
**/

/**
*** 获取grid表格当前页的json数据,xieguoking
*** gridid:grid标签设置的id属性值
*** selectedOnly:只获取选中行 标志,设置true为选择选中行，选择全部不需要设置
*** dicTransAble:是否转换字典代码,暂不提供支持
**/
function getGridJsonData(gridid,selectedOnly,dicTransAble){
	
	if(!isNull(gridid)){
		return "";
	}
	var records;

	if(selectedOnly === true){
		//按照选中行
		records = getGridSelectRows(gridid);
	}else{
	   //按照全部
		records=getGridRecords(gridid); 
	}
	var json=encode(records);
	return json;
}

function getGridJosnData(gridid,selectedOnly,dicTransAble){
	return  getGridJsonData(gridid,selectedOnly,dicTransAble);	
}
/** 
*** 编码store record，不对字典值进行转换,xieguoking
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
*** 编码store record，对字典值进行转换,xieguoking
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

/**
***  进行grid加载，url通过cw:grid标签的url设置,xieguoking
***   gridId :cw:grid 的id属性
***   params:参数列表,json结构 例如：{aac001:'00010021',aac002:aac002,name:myname}
***/
function loadGrid(gridId,params){
	var grid=Ext.getCmp(gridId);
	
	params.limit = grid.getStore().baseParams.limit;
	grid.getStore().baseParams = params;
	 
	grid.getStore().load({
		start : 0
	});
}



/**
**   获取grid的行记录
**/
function getGridRecords(gridId){
	var grid =Ext.getCmp(gridId);
	
	if(!isNull(grid)){
		return null;
	}
	
	var store =grid.getStore();
	
	if(!isNull(store)){
		return null;
	}	
	records=store.getRange();

	return records;
}

/**
***  获取选中行，返回record对象,xieguoking
***  gridId:cw:grid 对应的id
**/
function getGridSelectRows(gridId){
	
	var grid =Ext.getCmp(gridId);
	
	if(!isNull(gridId))
		return null;
		
	var records =grid.getSelectionModel().getSelections();
	
	return records;  
}

/**
***  获取record记录,xieguoking
***  recordId ：对应的属性值
**/
function getRecordValue(record,recordId){
	return record.get(recoredId);	
}

function isNull(v){
	return (typeof v =='undefined' || v);
}

/**
** 删除grid记录,xieguoking
** gridId:
** dataIndex:
**/
function gridRecordRemove(gridId,dataIndex){
	var records =getGridSelectRows(gridId);
	var store =Ext.getCmp(gridId).store;
	for(var i =0;i<records.length;++i){
		
		if(typeof(records[i].get(dataIndex))=='undefined'){
			store.remove(records[i]);
		}else{
		
		}
	}
 
}

/**
**  清空grid数据
**/
function cleanGridData(gridId){

	var grid =Ext.getCmp(gridId);
	
	grid.getStore().removeAll();
	
}

/**
***  为grid动态加载jsonData
***  gridId：grid的id
***  jsonData:json数据
***  append:是否增加,true:不清空已有数据
**/
function loadGridData(gridId,jsonData,append){

	var grid =Ext.getCmp(gridId);
	
	if(typeof grid =='undefined'){
		Wonders.Msg.info('对应的'+gridId+'找不到!','错误');
		return;
	}
	
	var store =grid.getStore();
	
	if(typeof store =='undefined'){
		Wonders.Msg.info('对应的'+gridId+'的grid.Store有误!','错误');
		return;
	}
	
	var fields=store.fields;
	
	var TopicRecord = Ext.data.Record.create(fields); 
	var records =[];
	
	for(var i=0;i<jsonData.length;++i){
		var data =jsonData[i];
		//进行日期类数据的转换
		for(var j=0;j<fields.length;++j){
			var fieldType =fields.items[j].type;
			var fieldName =fields.items[j].name;
			 if( fieldType=='date'){
			 	var date=data[fieldName];
			 	
			 	if(typeof(date) !='undefined' && date.length ==19)
			 		data[fieldName] =Date.parseDate(date,'Y-m-d H:i:s');	
			 }		
		}
		var record =new TopicRecord(data);
		records[i] =record;
	}
	
	if(append !==true)
		store.removeAll(); 
	
	store.add(records);
}

/**
***  为grid动态更新jsonData
***  gridId：grid的id
***  jsonData:json数据
***  records:页面选中数据
**/
function updateGridData(gridId,jsonData,records){
	var grid =Ext.getCmp(gridId);	
	if(typeof grid =='undefined'){
		Wonders.Msg.info('对应的'+gridId+'找不到!','错误');
		return;
	}	
	var store =grid.getStore();	
	if(typeof store =='undefined'){
		Wonders.Msg.info('对应的'+gridId+'的grid.Store有误!','错误');
		return;
	}
		
	var fields=store.fields;	
	var TopicRecord = Ext.data.Record.create(fields); 
	var json_records =[];
	
	for(var i=0;i<jsonData.length;++i){
		var data =jsonData[i];
		//进行日期类数据的转换
		for(var j=0;j<fields.length;++j){
			var fieldType =fields.items[j].type;
			var fieldName =fields.items[j].name;
			 if( fieldType=='date'){
			 	var date=data[fieldName];
			 	
			 	if(typeof(date) !='undefined' && date.length ==19)
			 		data[fieldName] =Date.parseDate(date,'Y-m-d H:i:s');	
			 }		
		}
		var json_record =new TopicRecord(data);
		json_records[i] =json_record;
	}	
	
	for(var i =0;i<records.length;i++){
		var index=store.indexOf(records[i])
		store.remove(records[i]);
	    store.insert(index,json_records[i]);
					
	}
	
}



/**
** 重新设置gridComlun的rendererData,用于渲染
** 需要在store.load前调用
**
**/
function setGridColumnData(gridId,columnName,data){

	var grid =Ext.getCmp(gridId);
	
	if(typeof(grid) =='undefined')
		return;
	
	var colModel =grid.getColumnModel();
	
	if(typeof(colModel) =='undefined')
		return;
				
	var configs_old =colModel.config;
	var configs =[];
				
	for(var i=0;i<configs_old.length;++i){
	var c =configs_old[i];
					
	if(c.dataIndex ==columnName)
		if(typeof c.dicBind !='undefined')
			delete c.dicBind;
			
		c.dicBind =data;
		configs.push(c);
	}
	colModel.setConfig(configs);
}

/**
 * 获取当前编辑行的record
 * @param gridid
 * @return
 */
function getCurrEditRecord(gridId){

	var grid =Ext.getCmp(gridId);
	
	if(typeof(grid) =='undefined')
		return ;

	var activeEditor =grid.activeEditor;
	
	if(typeof activeEditor !='undefined'){
		
		return activeEditor.record;
	}
	
}

/***
*** 默认的grid异常处理
***/
var defautlLoadException =function(obj, options, response,e){
	var errors =e.message;
	for(var i=0;i<errors.length;++i)
		Wonders.Msg.info(errors[i].msg,'错误');
};

/**
 * 默认的处理
 * @param obj
 * @param options
 * @param response
 * @param e
 * @return
 */
var defautlLoadHanlder =function(obj, options, response,e){
	
	var errors =e.message;
	for(var i=0;i<errors.length;++i){
		Wonders.Msg.info(errors[i].msg,'错误');
		return;
	}
	
	//判断是否有数据
	var jsonData =response.responseText;
	var json=Ext.decode(jsonData);
	
	if(typeof json.results !=='undefined' || json.results.length ==0)
		Wonders.Msg.info('没有查询到数据！','提示');
	 
};
 