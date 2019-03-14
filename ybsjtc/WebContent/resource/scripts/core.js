
/*
将object转换为数组，如果object是数组则直接返回
*/
function asArray(object){
	var array;
	if(typeof object=='undefined'){
		return new Array();
	}else if(typeof object["length"]=='undefined'){
		//array = new Array(object);
		array=new Array();
		array[0]=object;
	}else{
		array = object;
	}
	
	return array;
}

/**
 * 根据元素获取其所在元素组的索引

 * 参数：

 * element:元素
 * id:元素的标识

 */
function getElementIndex(element,id){
	var elements = asArray(document.all[id]);
	for(var i = 0; i < elements.length; i++){
		if(elements[i] == element){
			return i;
		}
	}
	return -1;	
}

/**
 * 根据某个元素获取与其处在相同索引的元素

 * 参数：

 * element:元素
 * id:元素的标识

 * otherElementIds...:其他元素的标识，动态参数

 * 返回：{id1:element1,id2:element2,...}
 */
function getSameIndexElements(element,id,otherElementIds){
	var index=getElementIndex(element,id);
	
	var result={};
	for(var i=2;i<arguments.length;i++){
		var eid=arguments[i];
		result[eid]=asArray(document.all[eid])[index];
	}
	return result;
}

/*
	复制table标签的行
*/
function copyRows(
		desTab/*目的表格*/,
		srcTab/*源表格*/,
		from/*源起始位置*/,
		size/*复制行数*/,
		to/*目的表格位置*/
	){
	if(arguments.length<3)
		from=0;	
	
	if(arguments.length<4)
		size=srcTab.rows.length-from;
					
	if(arguments.length<5)
		to=-1;
		
	if(isNaN(from)||isNaN(size)||isNaN(to))
		return;
		
	if(size<=0)
		return;
	if(from>=srcTab.rows.length)
		return;
	if(to>=desTab.rows.length)
		to=desTab.rows.length;			
	if(to<0)
		to=desTab.rows.length;

	var toIndex=to;
	var newrow;
	for(var i=0;i<size;i++){
	  newrow = desTab.insertRow(toIndex++);
	  newrow.replaceNode(srcTab.rows(from+i).cloneNode(true));	  
	}
}
/*
	删除table标签从from开始的size行

*/
function deleteRows(table,from,size){
	if(table.rows.length==0)
		return;
		
	if(arguments.length<3)
		size=-1;	
	
	if(arguments.length<2)
		from=0;
					
	if(from>=table.rows.length)
		from=table.rows.length-1;
		
	if(size<0)
		size = table.rows.length-from;
	
	if(table.rows.length-from<size)
		size = table.rows.length-from;
	
	for(var i=size-1;i>=0;i--){
		table.deleteRow(from+i);
	}
}
/*
	删除table标签的index行，table至少应该有minrows行

*/
function deleteRow(table,index,minrows){
	if(arguments.length<3)
		minrows=0;
	if(arguments.length<2)
		index=-1;
	if(index==-1)
		index = table.rows.length-1;
	if(minrows<0)
		minrows=0;
	if(index<0)
		return;
	if(table.rows.length<=minrows)
		return;
	table.deleteRow(index);		
}
/**
 * 删除当前行，参数：

 * obj：行内对象

 * marchLevel:父亲级别，默认为1，即第一个包含的TR
 */
function deleteCurrentRow(obj,marchLevel){
	var parent=obj;
	var level=1;
	if(marchLevel){
		level=marchLevel;
	}
	var hit=0;
	for(;true;){
		parent = parent.parentElement;
		if(parent==document.body){
			break;
		}
		if(parent.tagName.toLowerCase()=='tr'){
			hit=hit+1;
			if(hit==level){						
				parent.removeNode(true);
				break;
			}
		}
	}
}
