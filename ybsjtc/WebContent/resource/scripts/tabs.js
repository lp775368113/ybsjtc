var TABS=[];
function Tab(divname,linkname,classsuffix){
	TABS[TABS.length]=this;
	this.divname=divname;
	this.linkname=linkname;
	this.classsuffix=classsuffix;
	this.divs=this.asArray(document.all[this.divname]);
	this.links=this.asArray(document.all[this.linkname]);
	this.tabnum=Math.max(this.divs.length,this.links.length);
	
	this.initMenu();
	this.showMenuByIndex(0);
}
Tab.prototype.asArray=function(e){
	if(typeof(e.length)=="undefined"){
		return new Array(e);
	}else{
		return e;
	}
};

Tab.prototype.initMenu=function(){
	for(var i=0; i<this.tabnum; i=i+1){
		if(i<this.divs.length){
			this.divs[i].style.display="none";
		}
		
		if(i<this.links.length){
			this.links[i].className="dialogtab"+this.classsuffix;
		}
	}
};

Tab.prototype.getTabIndex=function(link){
	for(var i=0;i<this.links.length;i=i+1){
		if(this.links[i]==link){
			return i;
		}
	}
};

Tab.prototype.showMenu=function(link){
	this.hideAllmenu();	
	var index=this.getTabIndex(link);
	this.divs[index].style.display="";
	this.links[index].className="dialogtabactive"+this.classsuffix;
};

Tab.prototype.showMenuByIndex=function(index){
	this.hideAllmenu();	
	this.divs[index].style.display="";
	this.links[index].className="dialogtabactive"+this.classsuffix;
};


Tab.prototype.showAllmenu=function(link){
	this.hideAllmenu();
	var index=this.getTabIndex(link);
	this.links[index].className="dialogtabactive"+this.classsuffix;
	for(var i=0;i<this.divs.length;i=i+1){
		this.divs[i].style.display="";
	}	
};

Tab.prototype.showAllmenuByIndex=function(index){
	this.hideAllmenu();
	this.links[index].className="dialogtabactive"+this.classsuffix;
	for(var i=0;i<this.divs.length;i=i+1){
		this.divs[i].style.display="";
	}	
};

Tab.prototype.hideAllmenu=function(){
	var i;
	for(i=0;i<this.divs.length;i=i+1){
		this.divs[i].style.display="none";
	}
	for(i=0;i<this.links.length;i=i+1){
		this.links[i].className="dialogtab"+this.classsuffix;
	}	 
};

Tab.prototype.getTabIndexByElement=function(element){
	var index=-1;
	
	for(var i=0;i<this.divs.length;i++){
		if(this.divs[i].contains(element)){
			return i;
		}
	}
	
	return index;
};

function showTabByElement(element){
	for(var i=0;i<TABS.length;i++){
		var tab=TABS[i];
		var index=tab.getTabIndexByElement(element);
		if(index!=-1){
			tab.showMenuByIndex(index);
			return;
		}
	}
}
