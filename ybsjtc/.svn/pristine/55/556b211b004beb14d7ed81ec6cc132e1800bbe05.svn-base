/**
*** 表格相关的JS
*** author:xieguojun
***
**/

/**
*** 表格相关的JS
*** author:xieguojun
***
**/

/**
*** 设置表单域为只读
*** fieldId:表单域id
*** flag:默认为true,设置为false时，可以设置表单域为非只读
**/
function setReadOnly(fieldId,flag){
	
	var obj =Ext.getCmp(fieldId);
	
	if(typeof(flag) !='undefined' && flag ==false)
		obj.setReadOnly(false);
	else
		obj.setReadOnly(true);
}

/**
*** 解析Wonders.util.formLoad的回调函数的action参数
**/
function getJsonDataFromAction(action){
	
	return action.response.responseText;
}

/**
*** 解析Wonders.util.formLoad的回调函数的action的数据
*** action:对应回调函数的action参数
**/
function getFormValues(action){
	var jsonData =getJsonDataFromAction(action);
	var json=Ext.decode(jsonData);
	if(typeof(json) != 'undefined'){
		if(typeof(json.result) != 'undefined'){
			return json.result[0];
		}
	}
}
/**
 *  解析Wonders.util.formLoad的回调函数的action的数据
 *  返回类似于:result:[{},{},{}] 中所有的{},{},{}
 * @param action
 * @return
 */
function getFormAllValues(action){
	var jsonData =getJsonDataFromAction(action);
	var json=Ext.decode(jsonData);
	if(typeof(json) != 'undefined'){
		if(typeof(json.result) != 'undefined'){
			return json.result;
		}
	}
}

/**
*** 解析Wonders.util.formLoad的回调函数的action的数据
*** action:对应回调函数的action参数
*** key：对应property
**/
function getFormValue(action,key){
	
	return getFormValues(action)[key];
	
}

/**
*** 进行combobox数据的动态加载
***	
**/
function loadCombobox(comboboxId,url,urlParams,value){

	var combobox =Ext.getCmp(comboboxId);	
	
	if(typeof(combobox) =='undefined' ||combobox===null){
		return;
	}
	
	var co_store =combobox.getStore();
	var fields =co_store.fields;
	
	//为了不改变combobox的store,新增store获取数据
	var store = new Ext.data.JsonStore({
	    url: url,
	    root: 'result',
	    fields: fields,
	    baseParams :urlParams
	});
	
	var data =store.getRange();	
	
	co_store.loadData(data);
	
	combobox.serValue(value);
}


/**
*** 改变grid combobox的store urlParams(baseParams)
*** id:grid的id或者 combobox的id
*** params:json, {'aac001':'0000','aab001',' '}
**/
function changeStoreParams(id,params,reload){
	var obj =Ext.getCmp(id);
	
	if(typeof(obj) =='undefined'){
		Wonders.Msg.info('错误的id[changeStoreParams]','错误');
		return;
	}
	
	if(typeof(params) =='undefined'){
		Wonders.Msg.info('错误的params[changeStoreParams]','错误');
		return;
	}
	
	var store =obj.store;
	
	params.limit =store.baseParams.limit;
	
	store.baseParams =params;	
	
	if(reload ===true)
		store.load();	
}


function disable(id,flag){
	var obj =Ext.getCmp(id);
	
	if(typeof(obj) ==='undefined'){
		Wonders.Msg.info('错误的id[disable]','错误');
		return;
	}
	
	if(flag ===false)
		obj.enable();
	else
		obj.disable();
}	

function disableButton(btnId,flag){
	disable(btnId,flag);
}

function enable(id,flag){
	var obj =Ext.getCmp(id);
	
	if(typeof(obj) ==='undefined'){
		Wonders.Msg.info('错误的id[enable]','错误');
		return;
	}
	
	if(flag ===false)
		obj.disable();
	else
		obj.enable();
}

/**
**  获取combobox的全部记录
**
**/
function getRecordsFromCombobox(comboboxId){
	
	var obj =Ext.getCmp(comboboxId);
	
	if(typeof(obj) ==='undefined'){
		Wonders.Msg.info('错误的id[getRecordsFromCombobox]','错误');
		return;
	}
	
	var store =obj.store;
	
	return store.getRange();
}

/**
*** 
**/
function getRecordByKeyValue(records,key,value){
	
	if(!Ext.isArray(records)){
		Wonders.Msg.info('错误的records对象[getRecordByKeyValue]','错误');
		return;		
	}
	
	for(var i=0;i<records.length;++i){
		
		var record =records[i];
		
		if(record[key] ==value)
			return record;
	}	
}

function setCheckBoxReaOnly(id,flag){
	
	var obj =Ext.getCmp(id);
	
	if(check ===true)
		obj.on('check',function(){return false;});
	else
		obj.un('check');
}

/**
 * 获取combobox的显示文本
 * @param id
 * @return
 */
function getComboText(id){
	
	var combo =Ext.getCmp(id);
	return combo.lastSelectionText	
}

/**
 * 加载combobox
 * @param comboid
 * @param data
 * @return
 */
function loadData2Combo(comboid,data){
	var combo =Ext.getCmp(comboid);
	
	combo.store.removeAll(); 
	combo.store.loadData(data);
}

/**
** 从store 获取data
**/
var defaultFormExceptionHanlder =function(form,action){
	Wonders.utils.handleError(action.response.responseText,false,false);
	return false;
};


Ext.namespace('Yzsb.form');

Yzsb.form.removeStoreData =function(objid){
	var obj =Ext.getCmp(objid);
	
	if(typeof obj =='undefined'){
		return;
	}
	
	var store =obj.store;
	
	if(typeof store =='undefined'){
		return;
	}
	
	store.removeAll();	
}

/**
 * 进行form重置
 * formid:cw:form的id
 */
Yzsb.form.reset=function(formid){
	
	if(typeof formid =='undefined'){
		Wonders.Msg.info('必须指明Yzsb.form.reset重置的form id！','错误');
		return;
	}
	
	var obj =Ext.getCmp(formid).getForm();
	
	if(typeof obj =='undefined'){
		Wonders.Msg.info('指定的formid['+formid+']不存在！','错误');
		return;
	}
	
	obj.reset(); 
}

function cleanComboData(comboId){

	var grid =Ext.getCmp(comboId);
	 
	grid.store.removeAll();
	
}

/**
 * 将传入的linkage重置
 * 
 * 入参:linkage的id
 * 实例：resetLinkage('linkage id1','linkage id2','linkage id3',...'linkage idn');
 * @return
 */
function resetLinkage(){
	
	var count =arguments.length;
	var objCmp=null;
	for(var i=0;i<count;++i){
		objCmp =Ext.getCmp(arguments[i]);
		
		if(objCmp){
			objCmp.disable();
		}
	}
}

/**
*** 进行Linkage数据的动态加载
****重载Wonders.Combo.loadLinkage

***	
**/
Wonders.Combo.loadLinkage = function(form, comboName, comboName1,comboName2) {

    if (typeof(form)=='string'){

        form = Ext.getCmp(form).getForm();

    } 

    var loadFlag = true;

    var combo,combo1,combo2;

    combo = form.findField(comboName);

    if (comboName2 != undefined){

    combo1 = form.findField(comboName1);

        combo2 = form.findField(comboName2);

    }else{

     combo1 = form.findField(comboName2);

        combo2 = form.findField(comboName1);

    }    

    var value = combo.getValue();

    var value1 = combo1.getValue();

    var value2 = combo2.getValue();


    combo.store.on('load',function(store,records){

      if (loadFlag){

        combo.setValue(value);

        var valueField = combo.valueField;

        var i;

        var hasValue = false;

        for (i=0;i<records.length;i++){

            if (records[i].get(valueField) == value && records[i].get(valueField)!=''){

                hasValue = true;

                break;

            }

        }

        if (!hasValue){

           // combo.setValue('');

           // combo1.setValue('');

           // combo2.setValue('');
            

            loadFlag = false;

        }else{

           combo.fireEvent('select',combo,records[i]);  

        }

        if (comboName2 != undefined){

            combo1.store.load();

        }else{

            combo2.store.load();

        }

      }

    });

    if (comboName2 != undefined){

        combo1.store.on('load',function(store,records){

          if (loadFlag){

            combo1.setValue(value1);

            combo1.setDisabled(false);

            

            var valueField = combo1.valueField;

            var i;

            var hasValue = false;

            for (i=0;i<records.length;i++){ 

                if (records[i].get(valueField) == value1 && records[i].get(valueField)!=''){

                    hasValue = true;

                    break;

                }

            }            

            if (!hasValue){

                //combo1.setValue('');                

                if (combo1.parentField != combo2.parentField){

               loadFlag = false;

            }

            }else{

               combo1.fireEvent('select',combo1,records[i]);

           }

           combo2.store.load();

         }

        });

    }

    combo2.store.on('load',function(store,records){

      if (loadFlag){

        combo2.setDisabled(false);

        combo2.setValue(value2);

        

        var valueField = combo2.valueField;

        var i;

        var hasValue = false;

        for (i=0;i<records.length;i++){ 

            if (records[i].get(valueField) == value2 && records[i].get(valueField)!=''){

                hasValue = true;

                break;

            }

        }

        

        if (!hasValue){

            //combo2.setValue('');

        }

        loadFlag = false;

      }  

    });

    // 

    

    combo.store.load(); 

}

 



