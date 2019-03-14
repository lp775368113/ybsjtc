function CheckLodop(url){
   var oldVersion=LODOP.Version;
       newVerion="4.4.4.2";	
   if (oldVersion==null){
	document.write("<h3><font color='#FF00FF'>打印控件未安装!点击这里<a href='"+url+"/resource/scripts/install_lodop.exe'>执行安装</a>,安装后请刷新页面。</font></h3>");
	if (navigator.appName=="Netscape")
	document.write("<h3><font color='#FF00FF'>（Firefox浏览器用户需先点击这里<a href='"+url+"/resource/scripts/npActiveXFirefox4x.xpi'>安装运行环境</a>）</font></h3>");
   } else if (oldVersion<newVerion)
	document.write("<h3><font color='#FF00FF'>打印控件需要升级!点击这里<a href='"+url+"/resource/scripts/install_lodop.exe'>执行升级</a>,升级后请重新进入。</font></h3>");
}


var PAGE1={
		width :3760,
		height:2100,
		arg1:[10, 10,'280mm',150],
		arg2:[160,5,'280mm',410],
		arg3:[700,10,'280mm',90]
}



function insertRowsInto(colname,data,tablename,head){
	var table = document.getElementById(tablename);
	/*var row = table.insertRow(4);
	var cell = row.insertCell(0);
	cell.innerHTML = data;*/
	for(var i=0;i<data.length;i+=1){
		var row = document.createElement("tr");
		var no = document.createElement("td");
		no.appendChild(document.createTextNode(i+1));
		row.appendChild(no);
		for(var j=0;j<colname.length;j+=1){
			var cell = document.createElement("td");
			
			cell.appendChild(document.createTextNode(data[i][colname[j]]));
			row.appendChild(cell);
		}
		table.appendChild(row);
	}
	if(data.length%10!=0){
	for(var i=0;i<(10-(data.length%10));i+=1){
		var row = document.createElement("tr");
		var no = document.createElement("td");
		row.appendChild(no);
		for(var j=0;j<colname.length;j+=1){
			var cell = document.createElement("td");
			row.appendChild(cell);
		}
		table.appendChild(row);
	}
	}
/*	for(var i=0;i<data.length;i+=1){
		var row = table.insertRow(i+head);
		insertedRowNumber += 1;
		var no = row.insertCell(0);
		no.innerHTML = (i+1);
		for(var j=0;j<colname.length;j+=1){
			var cell = row.insertCell(j+1);
			cell.innerHTML = data[i][colname[j]];
		}
	}*/
	/*for(var i=0;i<(20-(data.length%20));i+=1){
		var row = table.insertRow(data.length+i+head);
		insertedRowNumber += 1;
		row.insertCell(0);
		for(var j=0;j<colname.length;j+=1){
			row.insertCell(j+1);
		}
	}*/
}

function insertRowsIntoWithoutNo(colname,data,tablename,head){
	var table = document.getElementById(tablename);
	/*var row = table.insertRow(4);
	var cell = row.insertCell(0);
	cell.innerHTML = data;*/
	for(var i=0;i<data.length;i+=1){
		var row = document.createElement("tr");
		for(var j=0;j<colname.length;j+=1){
			var cell = document.createElement("td")
			cell.appendChild(document.createTextNode(data[i][colname[j]]));
			row.appendChild(cell);
		}
		table.appendChild(row);
	}
	if(data.length%20!=0){
	for(var i=0;i<(20-(data.length%20));i+=1){
		var row = document.createElement("tr");
		var no = document.createElement("td");
		row.appendChild(no);
		for(var j=0;j<colname.length;j+=1){
			var cell = document.createElement("td");
			row.appendChild(cell);
		}
		table.appendChild(row);
	}
	}

}

//指定打印那几行
function insertRowsIntoStartEnd(colname,data,tablename,head,start,end){
	var table = document.getElementById(tablename);
	/*var row = table.insertRow(4);
	var cell = row.insertCell(0);
	cell.innerHTML = data;*/
	var css1 = "font-size: 11px;text-align:left";
	var css2 = "font-size: 15px;text-align:center";
	var css3 = "font-size: 10px;text-align:left";
	for(var i=start;i<end;i+=1){
		var row = document.createElement("tr");
		var no = document.createElement("td");
		no.appendChild(document.createTextNode(i+1));
		row.appendChild(no);
		for(var j=0;j<colname.length;j+=1){
			var cell = document.createElement("td");
			var css = "word-break:break-all;font-family:仿宋_GB2312;font-size:12pt";
			cell.appendChild(document.createTextNode(data[i][colname[j]]));
			cell.style.cssText = css;
			if(j==1){
				cell.style.cssText = css1;
			}else if(j==0){
				cell.style.cssText = css3;
			}
			row.appendChild(cell);
		}
		table.appendChild(row);
	}

	if((end-start)%10!=0){
	for(var i=0;i<(10-((end-start)%10));i+=1){
		var row = document.createElement("tr");
		for(var j=0;j<colname.length;j+=1){
			var cell = document.createElement("td");
			row.appendChild(cell);
		}
		table.appendChild(row);
	}
	}

}


function deleteRowsFrom(tablename){
	var table = document.getElementById(tablename);
	
	var children = table.childNodes;
	var len = children.length
	for(i=0;i<len;i++){
		table.removeChild(children[0]);
	}
}

function insertSum(colname,data,tablename,head){
	var td = document.getElementById(tablename).getElementsByTagName("td");
	for(var i=1; i<colname.length;i+=1){
		td[i+head].innerHTML = data[colname[i]];
	}
}

function insertDiv(data){
	for(var divname in data){
		var div = document.getElementById(divname);
		
		if(div!=undefined && div.tagName=='DIV'){
			div.innerHTML = data[divname];
		}
	}
}

function insertRowsIntoSpace(colname,data,tablename,head){
	var table = document.getElementById(tablename);
	/*var row = table.insertRow(4);
	var cell = row.insertCell(0);
	cell.innerHTML = data;*/
	for(var i=0;i<data.length;i+=1){
		var row = document.createElement("tr");
		var no = document.createElement("td");
		no.appendChild(document.createTextNode(i+1));
		row.appendChild(no);
		for(var j=0;j<colname.length;j+=1){
			var cell = document.createElement("td");
			
			cell.appendChild(document.createTextNode(data[i][colname[j]]));
			row.appendChild(cell);
		}
		table.appendChild(row);
	}
	//卷内文件目录打印，添加数据信息方法
	
}

