/***
*** 查看分析报告
*101.231.159.187
**/

/**
*** 参保人报告
***/
function viewPerson(param){
	window.open('../../pages/report/geren.jsp?ybh='+param,'分析报告');	
}
/**
*** 医生报告
***/
function viewDoctor(param){
	window.open('../../pages/report/yishi.jsp?ysgh='+param,'分析报告');	
}
/**
*** 医院报告
***/
function viewHospital(param){
	window.open('../../pages/report/yiyuan.jsp?yydm='+param,'分析报告');	

}

/**通用**********************************/
function Map() {
	var struct = function(key, value) {
		this.key = key;
		this.value = value;
	}

	var put = function(key, value) {
		for ( var i = 0; i < this.arr.length; i++) {
			if (this.arr[i].key === key) {
				this.arr[i].value = value;
				return;
			}
		}
		this.arr[this.arr.length] = new struct(key, value);
	}

	var get = function(key) {
		for ( var i = 0; i < this.arr.length; i++) {
			if (this.arr[i].key.toString() === key.toString()) {
				return this.arr[i].value;
			}
		}
		return null;
	}

	var remove = function(key) {
		var v;
		for ( var i = 0; i < this.arr.length; i++) {
			v = this.arr.pop();
			if (v.key === key) {
				continue;
			}
			this.arr.unshift(v);
		}
	}

	var size = function() {
		return this.arr.length;
	}

	var isEmpty = function() {
		return this.arr.length <= 0;
	}
	this.arr = new Array();
	this.get = get;
	this.put = put;
	this.remove = remove;
	this.size = size;
	this.isEmpty = isEmpty;
}

/**异地**********************************/
//单据类型
var YD_zw=[{
		id : 1,
		text : '全部'
		
	}, {
		id : 0,
		text : '违规'
	},
	 {
		id : 2,
		text : '正常'
	}
	];

//单据状态
var YD_KC63_BAZ031=[{
		id : '00',
		text : '全部'
	},{
		id : '01',
		text : '待初审'
	},{
		id : '02',
		text : '已初审'
	},{
		id : '03',
		text : '正在复审'
	},{
		id : '04',
		text : '已复审'
	},{
		id : '05',
		text : '复议不通过'
	},	{
		id : '06',
		text : '完成申诉'
	},{
		id : '07',
		text : '正在复议'
	},{
		id : '08',
		text : '完成复议'
	},{
		id : '09',
		text : '送医院确认'
	},{
		id : '10',
		text : '医院已确认'
	}
	];

//AKE003三大目录类别
function getAke003(ake003){
	if (ake003 == 1) {
		return "药品";
	} else if (ake003 == 2) {
		return "服务项目";
	} else if (ake003 == 3) {
		return "服务项目";
	} else if(ake003 == 4){
		return "医用材料";
	}
	return "";
}

//AKA065收费项目等级
function getAka065(aka065){
	if (aka065 == 1) {
		return "甲类";
	} else if (aka065 == 2) {
		return "乙类";
	} else if (aka065 == 3) {
		return "丙类";
	}
	return "";
}

//详情
function getMore(s){
	s = unescape(s);
	mini.showMessageBox({
        width: 350,
        height: 150,
        title: "详情",
        buttons: [],
        message: "",
        html: s,
        showModal: true,
        callback: function (action) {
            
        }
    });
}

