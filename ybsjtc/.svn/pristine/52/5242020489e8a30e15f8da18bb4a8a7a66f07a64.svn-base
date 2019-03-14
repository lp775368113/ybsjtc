/* 公用小型插件函数包
 * author Chenpw
 * */


/**标签所用的全局变量
 *******************************/
var iconCshName = ''; //初始化grid函数名
var iconSetJsonName = '' //赋值grid
var iconGridID //grid的id
var iconDivID //grid所在div的id，用于复制innerHtml 
var iconDivJson; //grid的json
var iconDivDom //grid所在的dom
var iconCXBM; //grid查询参数
var iconGridHeight //grid放大高度  

/**表格与日期 json格式为'[{"text":"2012年01月","value":"0"}]' 
 *  value--0---错号
 *  value--1---对号
 *  id为目标DIV-ID
 *  json
 *  x为一排所显示的行
 *  (预计增加逐步展开特效)
 **********************************/
	function TableAndDate(id, json, x) {

		var jsonStr = (new Function('return' + json))();
		var tablenum = parseInt(jsonStr.length / x);
		var endNum = parseInt(jsonStr.length % x);
		if (jsonStr.length < x) {
			x = jsonStr.length;
		}
		for (var i = 0; i < tablenum; i++) {
			EachTableData(id, i, x, x, json); //满员情况下的循环
		}
		if (endNum != 0) {
			EachTableData(id, tablenum, x, endNum, json);
		}

	}

	/*
	 * id--目标Div id
	 * i--循环遍历第i个table
	 * x--一排显示几个项
	 * l--余数循环
	 * json---json
	 */
	function EachTableData(id, i, x, l, json) {
		var jsonStr = (new Function('return' + json))();
		$('#' + id).append('<table  cellpadding="0" cellspacing="0" style="margin-top:2px;"><tr></tr><tr></tr></table>');
		for (var n = 0; n < l; n++) {
			$('#' + id + ' table').eq(i).find('tr').eq(0).append('<td>' + jsonStr[n + x * i].text + '</td>');
			if (jsonStr[n + x * i].value == '1') {
				$('#' + id + ' table').eq(i).find('tr').eq(1).append('<td><div class="icon-right"></div></td>')
					.find('div').css({
						'margin-left': '30%'
					});
			} else if (jsonStr[n + x * i].value == '0') {
				$('#' + id + ' table').eq(i).find('tr').eq(1).append('<td><div class="icon-error"></div></td>')
					.find('div').css({
						'margin-left': '30%'
					});
			} else {
				$('#' + id + ' table').eq(i).find('tr').eq(1).append('<td><div>— — —</div></td>');
			}
		}

		tableThemes(id, i);

	}
	/*
	 * 边遍历table主题样式
	 * i为目标DIvid，n为遍历第n个table
	 */
	function tableThemes(id, n) {
		$('#' + id + ' table').eq(n).find('tr').eq(0).find('td').addClass('ui-widget-bg1')
			.addClass('ui-widget-header-1')
			.addClass('ui-widget-border-1')
			.addClass('ui-text');
		$('#' + id + ' table').eq(n).find('tr').eq(0).find('td:last-child').addClass('ui-widget-end');
		$('#' + id + ' table').eq(n).find('tr').eq(1).find('td').addClass('ui-widget-bg2')
			.addClass('ui-widget-body')
			.addClass('ui-body-boder').css({
				'font-size': '14px'
			});
		$('#' + id + ' table').eq(n).find('tr').eq(1).find('td:last-child').addClass('ui-body-end');

	}



	/*@ 提示气泡 
	 * 参数 1.最小宽度
	 *    2.最小高度
	 *    3.样式编号
	 *    4.气泡内文本
	 * */

	function nbybBubble(w, h, state, text) {
		var m_block = '';
		var divs = getElementsByClassName("nbybBubble");
		for (var i = 0; i < divs.length; i++) {
			var obj = divs[i];
			//td标签通用样式
			var norepeat = "background-repeat:no-repeat;";
			var width_add, height_add, nbyb_value;
			//bubble的9个区图片
			var bg_img_l_t, bg_img_l_m, bg_img_l_b;
			var bg_img_m_t, bg_img_m_m, bg_img_m_b;
			var bg_img_r_t, bg_img_r_m, bg_img_r_b;
			var bg_image_b_b, bg_img_t_t;

			var point_style_b = "";
			var point_style_m = "";
			var point_style_t = "";
			width_add = "width:" + w;
			height_add = "height:" + h;

			m_block = text;
			if (state == 1) {
				width_add = "width:" + w + "px;";
				height_add = "height:" + h + "px;";
				bg_img_l_t = "bg_img1_l_t";
				bg_img_l_m = "bg_img1_l_m";
				bg_img_l_b = "bg_img1_l_b";

				bg_img_m_t = "bg_img1_m_t";
				bg_img_m_m = "bg_img1_m_m";
				bg_img_m_b = "bg_img1_m_b";

				bg_img_r_t = "bg_img1_r_t";
				bg_img_r_m = "bg_img1_r_m";
				bg_img_r_b = "bg_img1_r_b";

				bg_img_t_t = "bg_img1_t_t";
				bg_img_b_b = "bg_img1_b_b";
				nbyb_value = '1';
			} else if (state == 2) {

				bg_img_l_t = "bg_img2_l_t";
				bg_img_l_m = "bg_img2_l_m";
				bg_img_l_b = "bg_img2_l_b";

				bg_img_m_t = "bg_img2_m_t";
				bg_img_m_m = "bg_img2_m_m";
				bg_img_m_b = "bg_img2_m_b";

				bg_img_r_t = "bg_img2_r_t";
				bg_img_r_m = "bg_img2_r_m";
				bg_img_r_b = "bg_img2_r_b";

				bg_img_t_t = "bg_img2_t_t";
				bg_img_b_b = "bg_img2_b_b";
				width_add = "width:" + w + 'px;';
				height_add = "height:" + h + 'px;';
				nbyb_value = '2';
			} else if (state == 3) {
				bg_img_l_t = "bg_img1_l_t";
				bg_img_l_m = "bg_img1_l_m";
				bg_img_l_b = "bg_img1_l_b";

				bg_img_m_t = "bg_img1_m_t";
				bg_img_m_m = "bg_img1_m_m";
				bg_img_m_b = "bg_img1_m_b";

				bg_img_r_t = "bg_img1_r_t";
				bg_img_r_m = "bg_img1_r_m";
				bg_img_r_b = "bg_img1_r_b";

				bg_img_t_t = "bg_img1_t_t";
				bg_img_b_b = "bg_img1_b_b";

			} else if (state == 4) {
				bg_img_l_t = "bg_img1_l_t";
				bg_img_l_m = "bg_img1_l_m";
				bg_img_l_b = "bg_img1_l_b";

				bg_img_m_t = "bg_img1_m_t";
				bg_img_m_m = "bg_img1_m_m";
				bg_img_m_b = "bg_img1_m_b";

				bg_img_r_t = "bg_img1_r_t";
				bg_img_r_m = "bg_img1_r_m";
				bg_img_r_b = "bg_img1_r_b";

				bg_img_t_t = " ";
				bg_img_b_b = " ";
				width_add = "";
				height_add = "";
			} else {
				window.alert("bubble样式" + state + "不存在,目前就这么几个样式");
			}

			//组装样式
			/*================================================================================*/
			var rDivStr = " <div class='" + bg_img_t_t + "' ></div> ";
			rDivStr += "<table cellpadding='0' cellspacing='0' class='tBubble' value=" + nbyb_value + ">";
			rDivStr += "<tr> <td class='" + bg_img_l_t + " '></td>";
			rDivStr += "<td class='" + bg_img_m_t + " '></td>";
			rDivStr += "<td class='" + bg_img_r_t + " '></td></tr>";
			/*----------------------bubble的上半部分，下面是grid的中间部分-------------------------------*/
			rDivStr += "<tr><td class='" + bg_img_l_m + " '></td>";
			rDivStr += "<td class='" + bg_img_m_m + "' style='" + width_add + height_add + "'>"; //中间板块颜色 
			rDivStr += "<div class='bubble_nr' id='bubble_m'>"; //内部div 暂时无用
			rDivStr += m_block;
			rDivStr += "</div></td>";
			rDivStr += "<td class='" + bg_img_r_m + " '></td></tr>";
			/*----------------------下面是bubble的下半部分-------------------------------*/
			rDivStr += "<tr><td class='" + bg_img_l_b + " '></td>";
			rDivStr += "<td class='" + bg_img_m_b + " '></td>";
			rDivStr += "<td class='" + bg_img_r_b + " '></td></tr>";
			rDivStr += "</table>";
			rDivStr += "<div class='" + bg_img_b_b + "'  ></div> ";
			rDivStr += "<iframe scrolling='no' frameborder='0' scrolling='no' id='bubble-Iframe'></iframe>";
			/*================================================================================*/

			divs[i].innerHTML = rDivStr;
		}
	}
	/*新版个帐查询二级展示板*/
	function nbybTable(name, w, h, state, text) {
		var m_block;
		var divs = getElementsByClassName(name);
		for (var i = 0; i < divs.length; i++) {
			var obj = divs[i];
			//td标签通用样式
			var norepeat = "background-repeat:no-repeat;";
			var width_add, height_add;
			//bubble的9个区图片
			var bg_img_l_t, bg_img_l_m, bg_img_l_b, bg_img_l_s;
			var bg_img_m_t, bg_img_m_m, bg_img_m_b, bg_img_m_s;
			var bg_img_r_t, bg_img_r_m, bg_img_r_b, bg_img_r_s;

			width_add = "width:" + w + "px;";
			height_add = "height:" + h + "px;";
			m_block = text;
			if (state == 1) {
				bg_img_l_t = "table2_l_t";
				bg_img_l_m = "table2_l_m";
				bg_img_l_b = "table2_l_b";

				bg_img_m_t = "table2_m_t";
				bg_img_m_m = "table2_m_m";
				bg_img_m_b = "table2_m_b";

				bg_img_r_t = "table2_r_t";
				bg_img_r_m = "table2_r_m";
				bg_img_r_b = "table2_r_b";
			} else if (state == 2) {

				bg_img_l_t = "ui-bd-4-lt";
				bg_img_l_m = "ui-bd-4-lm";
				bg_img_l_b = "ui-bd-4-lb";

				bg_img_m_t = "ui-bd-4-mt";
				bg_img_m_m = "ui-bd-4-mm";
				bg_img_m_b = "ui-bd-4-mb";

				bg_img_r_t = "ui-bd-4-rt";
				bg_img_r_m = "ui-bd-4-rm";
				bg_img_r_b = "ui-bd-4-rb";

				bg_img_l_s = "ui-bd-shadown-l";
				bg_img_m_s = "ui-bd-shadown-m";
				bg_img_r_s = "ui-bd-shadown-r";

				if (text == '' || typeof(text) == 'undefind') {
					m_block = $('.' + name).html();
				} else {
					m_block = text;
				}
			} else if (state == 5) {
				bg_img_l_t = "ui-bd-5-lt";
				bg_img_l_m = "ui-bd-5-lm";
				bg_img_l_b = "ui-bd-5-lb";

				bg_img_m_t = "ui-bd-5-mt";
				bg_img_m_m = "ui-bd-5-mm";
				bg_img_m_b = "ui-bd-5-mb";

				bg_img_r_t = "ui-bd-5-rt";
				bg_img_r_m = "ui-bd-5-rm";
				bg_img_r_b = "ui-bd-5-rb";
				m_block = $('.' + name).html();
			} else {
				window.alert("bubble样式" + state + "不存在,目前就这么几个样式");
			}

			//组装样式
			/*================================================================================*/
			var rDivStr = "<table cellpadding='0' cellspacing='0' >";
			rDivStr += "<tr> <td class='" + bg_img_l_t + " '></td>";
			rDivStr += "<td class='" + bg_img_m_t + " '></td>";
			rDivStr += "<td class='" + bg_img_r_t + " '></td></tr>";
			/*----------------------bubble的上半部分，下面是grid的中间部分-------------------------------*/
			rDivStr += "<tr><td class='" + bg_img_l_m + " '></td>";
			rDivStr += "<td class='" + bg_img_m_m + "' style='" + width_add + height_add + "'>"; //中间板块颜色 


			rDivStr += "<div >"; //内部div 暂时无用
			rDivStr += m_block;
			rDivStr += "</div>";

			rDivStr += "</td>";
			rDivStr += "<td class='" + bg_img_r_m + " '></td></tr>";
			/*----------------------下面是bubble的下半部分-------------------------------*/
			if (state == 2) {
				rDivStr += "<tr> <td rowspan='2' class='" + bg_img_l_b + " '></td>";
				rDivStr += "<td class='" + bg_img_m_b + " '>   </td>";
				rDivStr += "<td rowspan='2' class='" + bg_img_r_b + " ' ></td> </tr>";
				rDivStr += "<tr>  <td class='" + bg_img_m_s + " '></td>  </tr> ";
			} else if (state != 2) {
				rDivStr += "<tr><td class='" + bg_img_l_b + " '></td>";
				rDivStr += "<td class='" + bg_img_m_b + " '></td>";
				rDivStr += "<td class='" + bg_img_r_b + " '></td></tr>";
				/*----------------------下面是阴影的下半部分-------------------------------*/
				rDivStr += "<tr><td class='" + bg_img_l_s + " '></td>";
				rDivStr += "<td class='" + bg_img_m_s + " '></td>";
				rDivStr += "<td class='" + bg_img_r_s + " '></td></tr>";
			}

			rDivStr += "</table>";

			/*================================================================================*/
			divs[i].innerHTML = rDivStr;
		}
	}


	/*新版弹出框*/
	/*
	 * name -> 目标id变更会alert
	 * w->宽  h->高
	 * state->样式
	 * text->提示文字，当state==3时，text为目标div内部的html集合
	 * title1->alert标题
	 * foo->确定按钮的预留函数
	 * btn->是否有确定按钮
	 * */
	function nbybAlert(name, w, h, state, text, title1, foo, btn) {
		var m_block, t_block;
		var divs = getElementsByClassName(name);
		for (var i = 0; i < divs.length; i++) {
			var obj = divs[i];
			//td标签通用样式
			var norepeat = "background-repeat:no-repeat;";
			var width_add, height_add;
			//bubble的9个区图片
			var bg_img_l_t, bg_img_l_w, bg_img_l_b, bg_img_l_l, bg_img_l_s;
			var bg_img_m_t, bg_img_m_w, bg_img_m_b, bg_img_m_l, bg_img_m_s;
			var bg_img_r_t, bg_img_r_w, bg_img_r_b, bg_img_r_l, bg_img_r_s;

			width_add = "width:" + w + "px;";
			height_add = "height:" + h + "px;";
			if (w == '') {
				width_add = '';
			}
			if (h == '') {
				height_add = '';
			}

			m_block = text;
			t_block = title1;
			if (state == 1 || state == 2 || state == 3 || state == 4) {
				bg_img_l_t = 'ui-alert-l-t';
				bg_img_m_t = 'ui-alert-l-m';
				bg_img_r_t = 'ui-alert-l-r';

				bg_img_l_w = 'ui-alert-l-w';
				bg_img_m_w = 'ui-alert-m-w';
				bg_img_r_w = 'ui-alert-r-w';

				bg_img_l_b = 'ui-alert-l-b';
				bg_img_m_b = 'ui-alert-m-b';
				bg_img_r_b = 'ui-alert-r-b';

				bg_img_l_l = 'ui-alert-l-l';
				bg_img_m_l = 'ui-alert-m-l';
				bg_img_r_l = 'ui-alert-r-l';

				bg_img_l_s = 'ui-alert-l-s';
				bg_img_m_s = 'ui-alert-m-s';
				bg_img_r_s = 'ui-alert-r-s';
			} else {
				window.alert("Alert样式" + state + "不存在,目前就这么几个样式");
			}

			//组装样式
			/*================================================================================*/

			var rDivStr = " <table class='ui-alert-1' cellpadding='0' cellspacing='0' style='margin-top:0px;position:absolute;'>";
			/*顶部*/
			rDivStr += " <tr><td class='ui-alert-l-t'></td> <td class='ui-alert-m-t'></td> <td class='ui-alert-r-t'></td></tr>";
			/* title栏*/
			rDivStr += " <tr class='ui-alert-tr'><td class='ui-alert-l-w'></td> <td class='ui-alert-m-w' style='height:15px;'>";
			rDivStr += "<div class='ui-alert-title'>" + t_block + "</div>";
			if (state != 4) {
				rDivStr += "<ul class='ui-alert-menu'><li class='ui-alert-close' onclick='closeAlert(this)'>X</li></ul>";
			}
			rDivStr += "</td> <td class='ui-alert-r-w'></td> </tr>";
			/*蓝色板块*/
			rDivStr += "  <tr> <td class='ui-alert-l-l'></td>";
			rDivStr += "  <td class='ui-alert-m-l' style='" + width_add + height_add + "'>";
			if (state == 1) {
				rDivStr += "<ul class='ui-blue-m'><li class='ui-alert-icon-1'></li><li>" + m_block + "</li></ul>";
			} else if (state == 2) {
				rDivStr += "<div class='ui-blue-text'>" + m_block + "</div>";
			} else if (state == 3) {
				m_block = $('.' + name).html();
				rDivStr += m_block;
			}
			rDivStr += "</td>";
			rDivStr += "  <td class='ui-alert-r-l'></td></tr>";
			/*无意义的蓝色板块悬浮阴影*/
			rDivStr += " <tr> <td class='ui-alert-l-s'></td> <td class='ui-alert-m-s'></td> <td class='ui-alert-r-s'></td> </tr>";
			/*底部按钮提示区*/
			rDivStr += "<tr> <td class='ui-alert-l-w '></td>";
			rDivStr += " <td class='ui-alert-m-w block-3' style='height:40px;' >";
			rDivStr += "<div  class='ui-btn-1 ui-btn-format-1'></div>";
			rDivStr += "</td>";
			rDivStr += " <td class='ui-alert-r-w'></td></tr>";
			/*无意义的底部, 圆角，阴影，以及等等*/
			rDivStr += "<tr> <td class='ui-alert-l-b'></td> <td class='ui-alert-m-b'></td> <td class='ui-alert-r-b'></td> </tr>";
			rDivStr += " </table>";
			// rDivStr +="<iframe scrolling='no' frameborder='0' scrolling='no' id='alert-Iframe'></iframe>";
			/*================================================================================*/
			divs[i].innerHTML = rDivStr;
			/*按钮居中特效*/
		}
		if (btn == 1) {
			$('.' + name).find('.block-3').css({
				'display': 'block'
			});
			$('.' + name).find('.ui-alert-close').css({
				'display': 'block'
			});
		} else if (btn == 0) {
			$('.' + name).find('.block-3').css({
				'display': 'none'
			});
			$('.' + name).find('.ui-alert-close').css({
				'display': 'none'
			});
		}

		nbybButtonAction('.' + name + ' .ui-btn-format-1', 'ui-btn-1', 'ui-btn-qd-0', 'ui-btn-qd-1', 'ui-btn-qd-2', 'ui-btn-qd-1', foo);
		// $('.'+name).css({'width':$('.'+name).find('.ui-alert-1').width()+'px','height':$('.'+name).find('.ui-alert-1').height()+'px'})   ;
	}
	/*alert用按钮样式加载*/
	function nbybButtonAction(o, csfromat, csout, csover, csdown, csup, foo) {
		$(o).addClass(csfromat).addClass(csout);
		$(o).hover(
			function() {
				$(this).removeClass(csout).addClass(csover)
			},
			function() {
				$(this).removeClass(csover).addClass(csout)
			});
		$(o).bind('mousedown', function() {
			$(this).removeClass(csover).addClass(csdown);
		});
		$(o).bind('mouseup', function() {
			$(this).removeClass(csdown).addClass(csover);
			// alertMin(o);
			if (typeof(foo) != 'undefined') {
				eval(foo)();
			}
		});
	}
	/*alert出现特效*/
	function alertShow(o) {
		$('.ui-alert-1').closest('div').hide();
		var h = document.documentElement.clientHeight;
		var w = document.documentElement.clientWidth;
		$(o).css({
			'display': 'block'
		});
		var www = $(o).find('.ui-alert-1').width();
		$(o).css({
			'position': 'absolute',
			'width': www + 'px'
		});
		alertCarton(o, w, h);
	}

	function alertHide() {
		$(o).css({
			'display': 'none'
		});
	}

	function alertCarton(o, w, h) {

		var alert_w = $(o).find('.block-3').width();
		var btn_w = $(o).find('.ui-btn-format-1').width();
		var alertW = $(o).find('table').eq(0).width();
		var alertH = $(o).find('table').eq(0).height();

		$(o).css({
			'left': (w - alertW) / 2 + 'px',
			'top': (h - alertH) / 2 + 'px'
		})

		.find('.ui-btn-format-1').animate({
			'margin-left': (alert_w - btn_w) / 2 + 'px'
		}, 100, function() {
			var objAlert = $(o).find('.ui-alert-1');
			//shack(o,(w-alertW)/2,(h-alertH)/2,10,70);
			shack(o, '', '', 10, 70);
		});
	}
	/*全屏抖动*/
	/*
	 * o->需要抖动目标
	 * w->当前absolute后的left值(若为空，则屏幕中水平居中)
	 * h->当前absolute后的top值（若为空，则屏幕垂直居中）
	 * n->震动幅度
	 * time->振幅时间
	 * */
	function shack(o, w, h, n, time) {
		var obj;
		if (typeof(o) == 'string') {
			obj = $(o);
		} else {
			obj = o;
		}
		var n = 10,
			time = 70;
		if (w == '') {
			var w = parseInt($(o).css('left'));
		}
		if (h == '') {
			var h = parseInt($(o).css('top'));
		}


		obj.stop(true)
			.animate({
				top: h + parseInt(Math.random() * n) + 'px',
				left: w + parseInt(Math.random() * n) + 'px'
			}, time)
			.animate({
				top: h + parseInt(Math.random() * n) + 'px',
				left: w - parseInt(Math.random() * n) + 'px'
			}, time)
			.animate({
				top: h - parseInt(Math.random() * n) + 'px',
				left: w + parseInt(Math.random() * n) + 'px'
			}, time)
			.animate({
				top: h - parseInt(Math.random() * n) + 'px',
				left: w + parseInt(Math.random() * n) + 'px'
			}, time)
			.animate({
				top: h + parseInt(Math.random() * n) + 'px',
				left: w + parseInt(Math.random() * n) + 'px'
			}, time)
			.animate({
				top: h + parseInt(Math.random() * n) + 'px',
				left: w - parseInt(Math.random() * n) + 'px'
			}, time)
			.animate({
				top: h - +parseInt(Math.random() * n) + 'px',
				left: w - parseInt(Math.random() * n) + 'px'
			}, time)
			.animate({
				top: h + 'px',
				left: w + 'px'
			}, time);
	}
	/*抖动-纵向*/
	function shackH(o, h) {
		var obj;
		if (typeof(o) == 'string') {
			obj = $(o);
		} else {
			obj = o;
		}
		obj.animate({
			top: h + 10 + 'px'
		}, 100)
			.animate({
				top: h + 'px'
			}, 100)
			.animate({
				top: h + 10 + 'px'
			}, 100)
			.animate({
				top: h + 'px'
			}, 100);
	}
	/*抖动-横向*/
	function shackW(o, w) {
		var obj;
		if (typeof(o) == 'string') {
			obj = $(o);
		} else {
			obj = o;
		}
		obj.animate({
			left: w + 15 + 'px'
		}, 100)
			.animate({
				left: w + 5 + 'px'
			}, 100)
			.animate({
				left: w + 15 + 'px'
			}, 100)
			.animate({
				left: w + 5 + 'px'
			}, 100)
			.animate({
				left: w + 'px'
			}, 100);
	}
	/*隐藏alert*/
	function closeAlert(o) {
		var objAlert = $(o).closest('.ui-alert-1').parent();
		objAlert.stop(true).animate({
			'margin-left': '0px',
			'margin-top': '0px'
		}, 'fast', function() {
			objAlert.hide();
		})
	}
	/*alert回到中央*/
	function alertMin(o) {
		var objAlert = $(o).closest('.ui-alert-1').parent();
		var h = document.documentElement.clientHeight;
		var alertH = objAlert.find('table').eq(0).height();
		objAlert.animate({
			top: (h - alertH) / 2 + 'px'
		}, 'fast', function() {
			shackH(objAlert, (h - alertH) / 2);
		});
	}

	/*以上是新版提示框的全部相关代码*/


	function nbybProgram(name, w, h, state, text) {
		var m_block = '';
		var divs = getElementsByClassName(name);
		for (var i = 0; i < divs.length; i++) {
			var obj = divs[i];
			//td标签通用样式
			var norepeat = "background-repeat:no-repeat;";
			var width_add, height_add;
			//bubble的9个区图片
			var bg_img_l, bg_img_m, bg_img_r;


			width_add = "width:" + w + "px;";
			height_add = "height:" + h + "px;";
			if (w == '') {
				width_add = '';
			} else if (h == '') {
				height_add = '';
			}
			m_block = text;

			if (state == 1 || state == 2 || state == 3 || state == 4) {
				bg_img_l = 'ui-' + state + '-l';
				bg_img_m = 'ui-' + state + '-m';
				bg_img_r = 'ui-' + state + '-r';

			} else {
				window.alert("bubble样式" + state + "不存在,目前就这么几个样式");
			}

			//组装样式
			/*================================================================================*/
			var rDivStr = "<table cellpadding='0' cellspacing='0' >";
			rDivStr += "<tr> <td class='" + bg_img_l + " '></td>";
			rDivStr += "<td class='" + bg_img_m + " '>" + m_block + "</td>";
			rDivStr += "<td class='" + bg_img_r + " '></td></tr>";
			rDivStr += "</table>";

			/*================================================================================*/
			divs[i].innerHTML = rDivStr;
		}
	}

	/*根据类名获得对象
调用方法：var topicnum=getElementsByClassName("classname");
*/
	function getElementsByClassName(searchClass, node, tag) {
		if (document.getElementsByClassName) {
			return document.getElementsByClassName(searchClass)
		} else {
			node = node || document;
			tag = tag || "*";
			var classes = searchClass.split(" "),
				elements = (tag === "*" && node.all) ? node.all : node.getElementsByTagName(tag),
				patterns = [],
				returnElements = [],
				current,
				match;
			var i = classes.length;
			while (--i >= 0) {
				patterns.push(new RegExp("(^|\\s)" + classes[i] + "(\\s|$)"));
			}
			var j = elements.length;
			while (--j >= 0) {
				current = elements[j];
				match = false;
				for (var k = 0, kl = patterns.length; k < kl; k++) {
					match = patterns[k].test(current.className);
					if (!match) break;
				}
				if (match) returnElements.push(current);
			}
			return returnElements;
		}
	}
	/*默认事件触发方式，参数事件触发标识*/
	function nbybmouseHover(name, n) {

		if ($('.nbybBubble').length > 0) {
			$('.nbybBubble').empty();
		} else {
			$("body").append("<div class='nbybBubble' style='display:none'> </div> ");
		}

		//$('.nbybBubble').after("<iframe scrolling='no' frameborder='0' scrolling='no' class='bubbleIframe'></iframe>");


		$(name).mousemove(function() {
			// id = $(this).attr("id");   

			nbybmouseover(n);
		});
		$(name).mouseout(function() {
			nbybmouseout();
		});
	}
var bubbletext = "";
/*默认的气泡出现事件，因为所用图片有透明阴影的存在，所以取消原有的过渡动画*/
function nbybmouseover(n) {


	if (typeof(bubbleText()) != "undefined") {
		bubbletext = bubbleText();
	} else {
		bubbletext = "bubbleText()函数没有调用"
	}
	nbybBubble("200", "", n, bubbletext);
	nbybBubbleShow();
}
/*移动气泡*/

function nbybBubbleShow() {

	var l = event.clientX + window.document.documentElement.scrollLeft - 50;
	var t = event.clientY + window.document.documentElement.scrollTop + 10;
	var win_h = document.documentElement.clientHeight;
	var win_w = document.documentElement.clientWidth;


	var b_h = $('.nbybBubble').height() + 100;
	var pointT, pointB;
	var iframe_w = $(".nbybBubble").width();
	var iframe_h = $(".nbybBubble").height() - 20;
	var iframe_mh = 0 - iframe_h;
	var obj_pb = '.bg_img' + $('.tBubble').attr('value') + '_b_b';
	var obj_pt = '.bg_img' + $('.tBubble').attr('value') + '_t_t';
	if (event.clientY + b_h > win_h) {
		pointT = 'none';
		pointB = 'block';
		t = t - $('.nbybBubble').height() - 10;
		iframe_mh = iframe_mh - 20;
	} else {
		pointT = 'block';
		pointB = 'none';
	}
	$(obj_pb).css({
		'display': pointB
	});
	$(obj_pt).css({
		'display': pointT
	});
	// $(".nbybBubble").css({ position:"absolute",  display:"block"});
	// $(".nbybBubble").stop().animate({ top: t+'px', left:l+'px'});
	$(".nbybBubble").css({
		top: t + 'px',
		left: l + 'px',
		position: "absolute",
		display: "block"
	});
	$('#bubble-Iframe').css({
		'width': iframe_w + 'px',
		'height': iframe_h + 'px',
		'margin-top': iframe_mh + 'px',
		'display': 'block'
	});

}

function nbybBubbleShow3() {
	var t = '100',
		l = '100';
	$(".nbybBubble").css({
		top: t + 'px',
		left: l + 'px',
		position: "absolute",
		display: "block"
	});
	$('.bg_img1_t_t').css({
		'display': 'block'
	});
	$('.bg_img1_b_b').css({
		'display': 'block'
	});
}
/*移动版*/
function nbybBubbleShow2() {

	var l = event.clientX + window.document.documentElement.scrollLeft
	var t = event.clientY + window.document.documentElement.scrollTop + 20;
	var win_h = document.documentElement.clientHeight;
	var win_w = document.documentElement.clientWidth;


	if ($('.nbybBubble').height() > 150) {
		var width_b = $('.nbybBubble').width();
		$('.bubble_nr').css({
			"overflow-y": "scroll",
			"height": "150px",
			'width': width_b + 20 + 'px'
		});
		$('.bg_img1_m_m').css({
			"overflow": "hidden"
		});
	}
	if ($('.nbybBubble').width() > 900) {
		$('.bubble_nr').css({
			"overflow-x": "scroll",
			"width": "800px"
		});
		$('.bg_img1_m_m').css({
			"overflow": "hidden"
		});
	}
	var h_nr = $('.nbybBubble').height() + 50;
	var w_nr = $('.nbybBubble').width();
	var tb_nr = $('.tBubble').width();

	if (event.clientY + h_nr > win_h) {
		t = t - $('.nbybBubble').height() - 20;
	}
	var iframe_w = $(".nbybBubble").width();
	var iframe_h = $(".nbybBubble").height();
	var iframe_mh = 0 - iframe_h;
	if (event.clientX + w_nr < win_w) {
		$(".nbybBubble").css({
			top: t + 'px',
			left: l + 'px',
			position: "absolute",
			display: "block"
		});
		$('#bubble-Iframe').css({
			'width': iframe_w + 'px',
			'height': iframe_h + 'px',
			'display': 'block',
			'margin-top': iframe_mh + 'px'
		});

	} else {
		if (w_nr > 500) {
			l = (win_w - w_nr) / 2;
		} else {
			l = win_w - w_nr - 100;
		}
		$(".nbybBubble").css({
			top: t + 'px',
			left: l + 'px',
			position: "absolute",
			display: "block"
		});
		$('#bubble-Iframe').css({
			'width': iframe_w + 'px',
			'height': iframe_h + 'px',
			'display': 'block',
			'margin-top': iframe_mh + 'px'
		});
	}


}



/*默认的气泡隐藏事件*/
function nbybmouseout() {
	$(".nbybBubble").css({
		display: "none"
	});
}
/*icon第一版*/
var json_icon = '[{"value":"1","classname":"icon-left-","id":"iconleft"},' +
	'{"value":"2","classname":"icon-up-","id":"iconup"},' +
	'{"value":"3","classname":"icon-right-","id":"iconright"},' +
	'{"value":"4","classname":"icon-down-","id":"icondown"},' +
	'{"value":"5","classname":"icon-refresh-","id":"iconrefresh"},' +
	'{"value":"6","classname":"icon-add-","id":"iconadd"},' +
	'{"value":"7","classname":"icon-reduce-","id":"iconreduce"},' +
	'{"value":"8","classname":"icon-ok-","id":"iconok"},' +
	'{"value":"9","classname":"icon-close-","id":"iconclose"},' +
	'{"value":"10","classname":"icon-notice-","id":"iconnotice"},' +
	'{"value":"11","classname":"icon-help-","id":"iconhelp"},' +
	'{"value":"12","classname":"icon-cancel-","id":"iconcancel"},' +
	'{"value":"13","classname":"icon-download-","id":"icondownload"},' +
	'{"value":"14","classname":"icon-stop-","id":"iconstop"},' +
	']';



var js_icon = (new Function('return' + json_icon))();


function iconShow(id) {
	$('#iconbtn_' + id).show();
} //指定id的图标按钮显示
function iconHide(id) {
	$('#iconbtn_' + id).hide();
} //指定id的图标按钮隐藏
/*
 * id1->iconbtn的id
 * id2->可点icon
 * id3->不可点icon
 * n->icon编号
 * onclick->点击事件
 * text->提示信息
 * flg->当前状态（1：可点||0：不可点）
 * */
function shiftIconBtn(id1, id2, id3, n, onclick, text, flg) {

	var cssover = js_icon[(n - 1)].classname + 'over',
		csson = js_icon[(n - 1)].classname + 'on',
		cssoff = js_icon[(n - 1)].classname + 'off';
	if (flg == '1') {
		if ($('#' + id3).length > 0) {
			$('#' + id3).remove();
		}
		$('#' + id1).append('<div id=' + id2 + ' onclick=' + onclick + '(this) ></div>');
		mouseHover('#' + id2, csson, cssover, cssoff, text, '1');
	} else if (flg == '0') {
		if ($('#' + id2).length > 0) {
			$('#' + id2).remove();
		}
		$('#' + id1).append('<div id=' + id3 + '></div>');
		mouseHover('#' + id3, csson, cssover, cssoff, text, '0');
	} else {}
}

/*图标的切换
 * 目标id
 * 默认classname
 * over的classname
 * title 提示
 * */
function mouseHover(id, css1, css2, css3, title, thisflg) {
	$(id).addClass('icon-format').attr('title', title);

	if (thisflg == 1 || thisflg == 2) {
		$(id).addClass(css1);
		$(id).hover(
			function() {
				$(this).removeClass(css1).addClass(css2);
			},
			function() {
				$(this).removeClass(css2).addClass(css1);
			}
		);
	} else if (thisflg == 0) {
		$(id).addClass(css3);
		//$(id).attr('onclick',''); 
	} else {
		alert(thisflg);
		alert(id + '的value错误');
	}

}

/*清楚指定Icon的相关class ,20140404更新判断机制 */
function cleanIconCss(id, v) {
	var o_css = $(id).attr('class');
	var arr = new Array();
	var css_end = '';
	if (judgeStr(o_css) == true) {
		arr = o_css.split(' ');

		for (var i = 0; i < arr.length; i++) {
			if (arr[i].indexOf('icon-') < 0) {
				css_end += arr[i] + ' ';
			}
		}

		$(id).attr('class', css_end).unbind("mouseleave mouseenter");
	}
}
/*
 * id-> 目标id
 * style-> 样式
 * cssNum->icon编号
 * title->title提示内容
 * thisflg-> 1==可点  0==不可点 
 
 * */
function mouseHover2(id, style, cssNum, title, thisflg) {

	if (judgeStr(id) == true) {
		if (id.substring(0, 1) == '#') {
			cleanIconCss(id, 'i');
		}
	}

	var iformat = 'icon-format-';
	var icon_position = 'icon-' + style + '-i' + cssNum;
	var css_out, css_over, css_off;
	if (style != 4) {
		if (style == 8 || style == 9 || style == 7 || style == 14) {
			var icon_position = 'icon-mini-i' + cssNum;
		}

		iformat += style;
		css_out = 'icon-' + style + '-out';
		css_over = 'icon-' + style + '-over';
		css_off = 'icon-' + style + '-off';
	} else if (style == 4) { //特殊用途
		iformat += '4';
		css_out = js_menu[cssNum].css + '0';
		css_over = js_menu[cssNum].css + '1';
		css_off = js_menu[cssNum].css + '0';
	}
	$(id).addClass(iformat).addClass(icon_position);
	if (title != '') {
		$(id).attr('title', title);
	}

	if (thisflg == 1 || thisflg == 2) {
		$(id).removeClass(css_off).addClass(css_out);
		$(id).hover(
			function() {
				$(this).removeClass(css_out).addClass(css_over);
			},
			function() {
				$(this).removeClass(css_over).addClass(css_out);

			}
		);
	} else if (thisflg == 0) {
		$(id).removeClass(css_out).removeClass(css_over).addClass(css_off);
	} else {
		alert(thisflg);
		alert(id + '的thisflg错误');
	}
}


function btnmouseHover(id, csson, cssover, cssdown, cssoff, text, thisflg) {
	if (thisflg != 3 && thisflg != 4) {
		$(id).addClass(csson);
		$(id).hover(
			function() {
				$(this).removeClass(csson).addClass(cssover);
			},
			function() {
				$(this).removeClass(cssover).addClass(csson);
			}
		)
	} else if (thisflg == 3) {
		$(this).removeClass(csson).removeClass(cssover).removeClass(cssdown).addClass(cssoff);
	} else if (thisflg == 4) {
		$(this).css({
			'display': 'none'
		});
	}
}
/*
 * object 外包装
 *
 */
function objectBorder(id) {
	$(id).find('tr').eq(0).addClass('ui-widget-bg1')
		.find('td').eq(0).addClass('ui-widget-header').addClass('ui-widget-border-1')
		.find('font').addClass('ui-text1');
	$(id).find('tr').eq(0).find('td').eq(1).addClass('ui-widget-header').addClass('ui-widget-end2');
	$(id).find('tr').eq(1).find('td').addClass('ui-widget-body').addClass('ui-body-end');
}

function objectBorder2(id) {
	$(id).find('tr').eq(0).addClass('ui-widget-bg1')
		.find('td').eq(0).addClass('ui-widget-header-1').addClass('ui-widget-border-1')
		.find('font').addClass('ui-text1');
	$(id).find('tr').eq(0).find('td').eq(1).addClass('ui-widget-header-1').addClass('ui-widget-end2');
	$(id).find('tr').eq(1).find('td').addClass('ui-widget-body').addClass('ui-body-end');
}
/*
 *@chenpw
 *@参数：1.表单table的类名（".name"）/ID名("#name")，
 *        2.所需要控制的符号
 *        3.所需要的颜色
 *@调用方法 fillSymbol("","","");
 */
function fillSymbol(name, f, color) {
	var a = $(name + " tr td:first-child");
	var i = 0;
	for (i; i < a.length; i++) {
		var b = a.eq(i);
		if (b.text() == f) {
			b.css({
				"color": color
			});
		}
	}
}

/*对象在鼠标周围出现
 * o->目标对象
 * style->显示方式
 * n->是否指定坐标 1->获取鼠标坐标 x，y则为偏移量
 * n->2  x,y为指定坐标
 * */
function mouseOpen(o, style, n, x, y) {
	if (n == 1) {
		var l = event.clientX + window.document.documentElement.scrollLeft + x + "px";
		var t = event.clientY + window.document.documentElement.scrollTop + y + "px";
	} else if (n == 2) {
		var l = x + 'px';
		var t = y + 'px';
	} else {}
	if (style == 1) {
		$(o).css({
			top: t,
			left: l,
			position: "absolute",
			display: "block"
		});
	} else if (style == 2) {
		$(o).stop().animate({
			'top': t,
			'left': l
		}, 500);
	}
}
/*
 * id->需要移动的目标id
 * maxL->目标最大移动范围，不能带单位
 * nuitL->单位移动距离,不能带单位
 * o->当前按钮对象
 * btn_l->左按钮的id
 * btn_r->右按钮的id
 * time->单位完成时间
 * */
function objectMove(id, maxL, nuitL, o, btn_l, btn_r, time) {

	var moveL = parseInt($(id).css('margin-left'));
	var nuitL = parseInt(nuitL);
	if ($(o).attr('id') == btn_r) {
		if (moveL <= maxL) {} else {
			moveL -= nuitL;
		}
	}
	if ($(o).attr('id') == btn_l) {
		if (moveL >= 0) {} else {
			moveL += nuitL;
		}
	}
	$(id + ":not(:animated)").animate({
		"margin-left": moveL + "px"
	}, 600);
}
/*
 * 磁贴的hover事件
 * */
function citieHover(id, cssstyle, cssover) {
	$(id).addClass(cssstyle);
	$(id).hover(
		function() {
			$(this).addClass(cssover);
		},
		function() {
			$(this).removeClass(cssover);
		}
	);
}
/*创建进程
 * o->在目标内插入进程
 *json->进程json 格式 json='[{"text":"进程1","value":"3"}]'  value->1 未进行 || value->2正在进行并可以通过 ||value->3 已通过 || value->4 正在进行并不允许通过
 *title 进程名称
 *cartom->自动是否加载动画  1->自动 0->手动（使用programAction(jlength,time)函数）
 *style->1->红色遇到不中断， 2->红色中断
 */
function bulidprogram(o, json, title, carton, style) {
	$(o).children().remove();
	var jStr = (new Function('return' + json))();
	var str_title = '',
		str_nr = '';
	str_title = "<tr class='p-title-1'>" +
		"<td class='p1'> <div class='p-tb-star p-tb-format-1'></div> <div class='p-line-3 p-line-format-1'></div>  </td>" +
		"<td  colspan='2'><div class='p-title'>" + title + "</div></td>" +
		"<td><div class='p-count'>共 <font class='p-num'>" + jStr.length + "</font> 项</div></td>" +
		"<td style='width:20px;'><div class='zk_btn p-btn-up '></div></td>" +
		"</tr>";

	for (var i = 0; i < jStr.length; i++) {
		var p_line_1 = '';
		if (i < jStr.length - 1) {
			p_line_1 = "<div class='p-line-3 p-line-format-1'> </div>";
		}
		str_nr += "<tr value='" + jStr[i].value + "'>" +
			"<td class='p1'> <div class='p-icon p-tb-gray p-tb-format-2'></div> " + p_line_1 + " </td>" +
			"<td class='p2'><div class='p-line-4 p-line-format-2'></div></td> " +
			"<td class='p3'><div class='p-txt'>" + jStr[i].text + " </div><div class='load-line'></div></td>" +
			"<td class='p4' colspan='2'>" +
			"<div class='p-state-format p-state-ok' style='display:none'></div>" +
			"<div class='p-state-format p-state-error' style='display:none'></div>" +
			"<div class='p-state-format p-state-exceptions' style='display:none'></div>" +
			"</td>" +
			"</tr>";
	}
	str = "<table class='p-form' cellpadding='0' cellspacing='0' >" + str_title + str_nr + "</table>";
	$(o).append(str);

	zkButton(o);
	proHover(o);

	if (carton == '1' || carton == 1) {
		clearInterval(pro_time1);
		pro_time1 = null;
		programAction(jStr.length, 500, style);
	}

}

function bulidProgram2(o, json) {
	var jStr = (new Function('return' + json))();
	var str_tr = '',
		p_state = '',
		p_icon = '';
	for (var i = 0; i < jStr.length; i++) {
		if (jStr[i].value == '0') {
			p_state = 'p-state-error';
			p_icon = 'p-tb-red';
		} else if (jStr[i].value == '1') {
			p_state = 'p-state-ok';
			p_icon = 'p-tb-green';
		} else if (jStr[i].value == '2') {
			p_state = 'p-state-exceptions';
			p_icon = 'p-tb-yellow';
		}

		str_tr += '<tr value=' + jStr[i].value + '> ' +
			'<td style=" " ><div   class="p-icon ' + p_icon + ' p-tb-format-3"></div></td> ' +
			'<td><div class="p-txt" style="line-height:20px;">' + jStr[i].text + ' </div></td> ' +
			'<td style=" "> <div class="p-state-format ' + p_state + '"  ></div> </td> </tr>'
	}

	var str_table = "<div class='prog2'  style='display:none;' ><table style='margin:0px;' class='p-form2' cellpadding='0' cellspacing='0'>" + str_tr + "</table></div>";
	$(o).append(str_table);
	$('.prog2').css({
		'height': '20px',
		'overflow': 'hidden',
		'padding': '0px'
	});
}
/*创建浮动滚动条*/
function fixedProgram(o, json, title, carton, style) {
	bulidprogram(o, json, title, carton, style);
	bulidProgram2(o, json);

}
/*改变进程*/
function changeProgram(n) {
	if (n == 0) {
		$('.prog2').hide();
		clearInterval(programTime3);
	} else if (n == 1) {
		$('.prog2').show();
		programAction2()
	}
}
var programTime3 = null

	function programAction2() {
		clearInterval(programTime3);
		$('.p-form2').css({
			'margin-top': '0px'
		});
		var maxH = $('.prog2 table').height(),
			margin_T = 0;
		programTime3 = setInterval(function() {
			if (maxH + margin_T > 0) {
				margin_T = margin_T - 20;
				$('.p-form2').animate({
					'margin-top': margin_T + 'px'
				}, 1000);
			} else if (maxH + margin_T == 0) {
				margin_T = 0;
				$('.p-form2').css({
					'margin-top': '20px'
				}).animate({
					'margin-top': margin_T + 'px'
				}, 1000);
			}
		}, 2000);
	}
	/*进程动画(伪)
	 *jlength->进程动画的进程数
	 *time->执行一行所需时间
	 */
var pro_time1 = null;

function programAction(jlength, time, style) {
	var pro_i = 1;
	$('.p-icon').removeClass('p-tb-gif').removeClass('p-tb-red').removeClass('p-tb-green').addClass('p-tb-format-2').addClass('p-tb-gray');
	$('.p-state-ok').hide();
	$('.p-state-error').hide();
	$('.load-line').css({
		'display': 'block',
		'width': '0px'
	});

	if (style == 1) {
		pro_time1 = setInterval(function() {
			if (pro_i < jlength + 2) {
				trAction(pro_i, style);
				pro_i++;
			} else {
				clearInterval(pro_time1);
				$('.load-line').hide();
				if (typeof(programEnd) != 'undefined') {
					programEnd();
				} /*动画完成后的预留函数*/
			}
		}, time);
	} else if (style == 2) {
		var trNum1 = null;
		//判定在第几行停止
		for (var a = 1; a < jlength + 2; a++) {
			var tr_value = $('.p-form tr').eq(a).attr('value');
			if (tr_value == 0 && trNum1 == null) {
				trNum1 = a;
			} //当值为不通过，且第一次记录时
			else if (typeof(tr_value) == 'undefined' && trNum1 == null) {
				trNum1 = jlength;
			} //当不通过项不存在时，且第一次记录时
		}
		pro_time1 = setInterval(function() {
			if (pro_i < trNum1 + 2) {
				trAction(pro_i, style);
				pro_i++;
			} else {
				$('.load-line').hide();
				clearInterval(pro_time1);
				if (typeof(programEnd) != 'undefined') {
					programEnd();
				} /*动画完成后的预留函数*/
			}
		}, time);
	}
}

/*每一条进程的动画*/

function trAction(n, style, time) {
	var ok_dis = '',
		error_dis = '',
		p_tb_icon = '',
		exceptions_dis = '';
	var tr_value = $('.p-form tr').eq(n - 1).attr('value');
	var p_ago = 0; //判断是否中断的标识
	if (style == 2 && tr_value != 0) {
		p_ago = 1;
	} else if (style == 1) {
		p_ago = 1;
	}
	if (p_ago == 1) {
		$('.p-form tr').eq(n).find('.p-icon').removeClass('p-tb-gray').removeClass('p-tb-red').removeClass('p-tb-green').removeClass('p-tb-yellow').removeClass('p-tb-format-2').addClass('p-tb-gif');
		$('.p-form tr').eq(n).find('.load-line').stop().animate({
			'width': '200px'
		}, 1000).fadeOut(time);
	}

	if (n > 0) {
		if (tr_value == '1') {
			ok_dis = 'block', error_dis = 'none';
			exceptions_dis = 'none';
			p_tb_icon = 'p-tb-green';
		}
		if (tr_value == '0') {
			ok_dis = 'none', error_dis = 'block';
			exceptions_dis = 'none';
			p_tb_icon = 'p-tb-red';
		}
		if (tr_value == '2') {
			ok_dis = 'none', error_dis = 'none';
			exceptions_dis = 'block';
			p_tb_icon = 'p-tb-yellow';
		}
		$('.p-form tr').eq(n - 1).find('.p-icon').removeClass('p-tb-gif').removeClass('p-tb-gray').addClass(p_tb_icon).addClass('p-tb-format-2');

		$('.p-form tr').eq(n - 1).find('.p-state-ok').css({
			'display': ok_dis
		});
		$('.p-form tr').eq(n - 1).find('.p-state-error').css({
			'display': error_dis
		});
		$('.p-form tr').eq(n - 1).find('.p-state-exceptions').css({
			'display': exceptions_dis
		});
	}
}
/*展开和收缩进程*/
function zkButton(o) {
	$('.p-title-1').click(function() {
		programChoose(this);
	});
}
//判定滚动条收起与展开
function programChoose(o) {
	var obj = $(o).closest('.p-form').parent();
	if (obj.height() > 50) {
		upProgram(o);
	} else {
		downProgram(o);
	}

}
//滚动条收起
function upProgram(o) {
	$(o).find('.zk_btn').removeClass('p-btn-up').addClass('p-btn-down');
	var obj = $(o).closest('.p-form').parent();
	obj.css({
		'overflow': 'hidden'
	}).animate({
		'height': '17px'
	});

}
//滚动条展开
function downProgram(o) {

	$(o).find('.zk_btn').removeClass('p-btn-down').addClass('p-btn-up');
	var obj = $(o).closest('.p-form').parent();
	var h = $('.p-form').height();
	obj.animate({
		'height': h + 'px'
	});

}

/*对目标表格进行鼠标Hover事件*/
function proHover(o) {
	$(o).find('table tr').hover(
		function() {
			$(this).addClass('tr-over');
		},
		function() {
			$(this).removeClass('tr-over');
		});
}
/*简易导航栏*/
function bulidMenuAddress(ObjDiv, jSon, state, obj1) {
	var jstr = (new Function('return' + jSon))();
	var str_count = '';
	var n_max = jstr.length;
	var moveObj = '\'' + obj1 + '\'';
	for (var i = 0; i < jstr.length; i++) {
		var txt_color = 'num-color-',
			icon_color = 'num-1-';
		if (i == n_max - 1) {
			txt_color += 2;
			icon_color = 'num-2-' + (i + 1);
		} else {
			txt_color += 1;
			icon_color += (i + 1);
		}
		str_count += '<td class="ui-jymenu-td" onmouseup="webDhClick(this,' + moveObj + ')" id="' + jstr[i].id + '" title="' + jstr[i].title + '">' +
			'<div class="' + icon_color + ' num-format"></div>' +
			'<div class="num-text ' + txt_color + '">' + jstr[i].text + '</div></td>';
	}
	var str_point = '';
	if (state == 1) {
		for (var i = 0; i < jstr.length; i++) {
			str_point += '<td style="height:3px;"><div class="dh_point" style="display:none;"></div></td>';
		}
	} else if (state == 2) {
		str_point += '<td style="height:3px;" colspan="' + jstr.length + '"><div class="dh_point" style="width:0px;"></div></td>';
	} else if (state == 0) {
		str_point = '';
	}
	var str = '<table class="menuAddress" cellpadding="0" cellspacing="0"><tr>' + str_count + '</tr><tr>' + str_point + '</tr></table>';
	$(ObjDiv).append(str);
	if (state == 0) {
		MenuAddressHover(ObjDiv);
	} else if (state == 1) {
		MenuAddressHover1(ObjDiv);
	} else if (state == 2) {
		MenuAddressHover2(ObjDiv);
	}
	$('.num-text').addClass('tm-5');

}
/*指针特效0*/
function MenuAddressHover(obj) {
	var td_obj2 = $(obj).find('.menuAddress tr').eq(0).find('td');
	$(obj).find('.menuAddress tr:eq(0) td').hover(
		function() {
			var num = $(this).index();
			td_obj2.eq(num).find('.num-text').removeClass('tm-5').addClass('tm-7');
		},
		function() {
			var num = $(this).index();
			td_obj2.eq(num).find('.num-text').removeClass('tm-7').addClass('tm-5');
		}
	);
}

/*指针特效1*/
function MenuAddressHover1(obj) {
	var td_obj = $(obj).find('.menuAddress tr').eq(1).find('td');
	var td_obj2 = $(obj).find('.menuAddress tr').eq(0).find('td');
	$(obj).find('.menuAddress tr:eq(0) td').hover(
		function() {
			var num = $(this).index();
			td_obj.eq(num).find('div').stop(true, true).fadeIn(500);
			td_obj2.eq(num).find('.num-text').removeClass('tm-5').addClass('tm-7');
		},
		function() {
			var num = $(this).index();
			td_obj.eq(num).find('div').fadeOut(400);
			td_obj2.eq(num).find('.num-text').removeClass('tm-7').addClass('tm-5');
		}
	);
}
/*指针特效2*/
function MenuAddressHover2(obj) {
	var td_obj = $(obj).find('.menuAddress tr').eq(1).find('td');
	var td_obj2 = $(obj).find('.menuAddress tr').eq(0).find('td');
	$(obj).find('.menuAddress tr:eq(0) td').hover(
		function() {
			var num = $(this).index();
			var td_w = $(this).closest('td').width(),
				ml;
			if (num > 0) {
				ml = 0;
				for (var i = 0; i < num; i++) {
					ml = ml + $(obj).find('.menuAddress tr').eq(0).find('td').eq(i).width();
				}
			} else if (num == 0) {
				ml = 0;
			}
			td_obj2.eq(num).find('.num-text').removeClass('tm-5').addClass('tm-7');
			$(obj).find('.dh_point').stop(true).animate({
				'width': td_w + 'px',
				'margin-left': ml + 'px'
			});

		},
		function() {
			var num = $(this).index();
			$(obj).find('.dh_point').animate({
				'margin-left': '0px'
			}, 500).animate({
				'width': '0px'
			}, 300);
			td_obj2.find('.num-text').removeClass('tm-7').addClass('tm-5');
		}
	);
}
/*
 * 对指定导航栏进行当前选定样式设定
 * obj-》目标对象
 * n-》第n个目标进行更正
 * */
function setMenuAddress(obj, n) {
	var obj_td = $(obj).find('.menuAddress tr').eq(0).find('td').eq(n - 1);
	var obj_tr = $(obj).find('.menuAddress tr').eq(0).find('td');
	var td_length = $(obj).find('.menuAddress tr').eq(0).find('td').size();
	for (var i = 0; i < td_length; i++) {
		obj_tr.eq(i).find('.num-format').removeClass('num-2-' + (i + 1)).addClass('num-1-' + (i + 1));
		obj_tr.eq(i).find('.num-text').removeClass('num-color-2').addClass('num-color-1');
	}
	obj_td.find('.num-format').removeClass('num-1-' + n).addClass('num-2-' + n);
	obj_td.find('.num-text').removeClass('num-color-1').addClass('num-color-2');
}

/*导航点击后，页面移动特效*/
/*
 * o->移动目标
 * style-> 0->左边消失   1->右边移出现
 * id->当前点击项的id
 * */
function webMove(o, style, id, time) {
	var win_w = document.documentElement.clientWidth; //window.brower.width
	var m_start = parseInt($(o).css('margin-left')); //obj.marginLeft 
	if (style == '0') {
		$(o).stop().animate({
			'margin-left': -win_w + 'px'
		}, time, function() {
			if (typeof(moveDhEnd) != 'undefined') {
				moveDhEnd(id);
			}
		});
	} else if (style == '1') {
		$(o).css({
			'margin-left': win_w + 'px'
		}).animate({
			'margin-left': '8px'
		}, time, function() {
			if (typeof(moveDhEnd2) != 'undefined') {
				moveDhEnd2(id);
			}
		});
	}
}
/*将目标对象进行窗体式横向移动，作用于一体式页面不切换
 * obj->移动目标
 * n->点击序列
 * time->速度
 * end->是否移动后执行预留方法  yes->执行 no->不执行
 * */
function windowMove(obj, n, time, end) {
	//var n=$(o).index();
	var win_w = document.documentElement.clientWidth;
	var goto_m = -n * win_w + 8;
	$(obj).animate({
		'margin-left': goto_m + 'px'
	}, time, function() {
		if (end == 'yes') {
			if (typeof(winMoveEnd) != 'undefined') {
				winMoveEnd(obj, n);
			}
		} else if (end == 'no') {}
	});
}
/*将目标对象进行窗体式横向移动，作用于一体式页面不切换
 * obj->移动目标
 * n->点击序列
 * time->速度
 * end->是否移动后执行预留方法  yes->执行 no->不执行
 * p -> 移动偏差值
 * */
function windowMove2(obj, n, time, end, p) {
	//var n=$(o).index();
	var win_w = document.documentElement.clientWidth;
	var goto_m = -n * win_w + p;
	$(obj + ':not(:animated)').animate({
		'margin-left': goto_m + 'px'
	}, time, function() {
		if (end == 'yes') {
			if (typeof(winMoveEnd) != 'undefined') {
				winMoveEnd(obj, n);
			}
		} else if (end == 'no') {}
	});
}

function windowMove3(obj, n, time, end, p, style) {
	//var n=$(o).index();
	var win_w = document.documentElement.clientWidth;
	var goto_m = -n * win_w + p;
	if (style == '' || typeof(style) == 'undefined') {
		style = 'easeInQuad';
	} else {
		$(obj).animate({
			'margin-left': goto_m + 'px'
		}, {
			duration: time,
			easing: style,
			complete: function() {
				if (end == 'yes') {
					if (typeof(winMoveEnd) != 'undefined') {
						winMoveEnd(obj, n);
					}
				} else if (end == 'no') {}
			}
		});
	}
}

/*此方法为将目标移出屏幕外，作用与页面刷新中无任何明显特增的移动*/
function setOBjMargin(o, style) {
	var win_w = document.documentElement.clientWidth; //window.brower.width
	if (style == 'r') {
		$(o).css({
			'margin-left': win_w + 'px'
		});
	} else if (style == 'l') {
		$(o).css({
			'margin-left': -win_w + 'px'
		});
	}
}
/*点击空白执行的方法*/
function haveBlock(foo) {
	$(document).bind('click', function(e) {
		var target = $(e.target);
		if (target.closest('.haveblock').length == 0) {
			if (typeof(foo) != 'undefined') {
				eval(foo)();
			}
		} else {}
	});
}



/*************************************灰色圆角边框，考虑合并**************************************************/
/*仿苹果圆角边框*/
function bulidAppleBlock(name, w, h, state, text, vertical) {
	var m_block = '',
		va;
	var obj_name = name.substr(1, name.length);
	var divs = getElementsByClassName(obj_name);
	if (judgeStr(vertical) == false) {
		va = 'middle';
	} else {
		va = 'top';
	}
	for (var i = 0; i < divs.length; i++) {
		var obj = divs[i];
		//td标签通用样式

		var width_add = '',
			height_add = '',
			nbyb_value;
		//bubble的9个区图片
		var bg_img_l_t, bg_img_l_m, bg_img_l_b;
		var bg_img_m_t, bg_img_m_m, bg_img_m_b;
		var bg_img_r_t, bg_img_r_m, bg_img_r_b;

		if (w != '' || w != null) {
			width_add = "width:" + w + "px;";
		}
		if (h != '' || h != null) {
			height_add = "height:" + h + "px;";
		}
		if (text == '') {
			m_block = $(name).html();
		} else {
			m_block = text;
		}
		bg_img_l_t = "apple-block" + state + "-l-t";
		bg_img_l_m = "apple-block" + state + "-l-m";
		bg_img_l_b = "apple-block" + state + "-l-b";
		bg_img_m_t = "apple-block" + state + "-m-t";
		bg_img_m_m = "apple-block" + state + "-m-m";
		bg_img_m_b = "apple-block" + state + "-m-b";
		bg_img_r_t = "apple-block" + state + "-r-t";
		bg_img_r_m = "apple-block" + state + "-r-m";
		bg_img_r_b = "apple-block" + state + "-r-b";
		//组装样式
		/*================================================================================*/
		var rDivStr = "<table cellpadding='0' cellspacing='0'  value=" + nbyb_value + ">";
		rDivStr += "<tr> <td class='" + bg_img_l_t + " '></td>";
		rDivStr += "<td class='" + bg_img_m_t + " '></td>";
		rDivStr += "<td class='" + bg_img_r_t + " '></td></tr>";
		/*----------------------bubble的上半部分，下面是grid的中间部分-------------------------------*/
		rDivStr += "<tr><td class='" + bg_img_l_m + " '></td>";
		rDivStr += "<td class='" + bg_img_m_m + "' style='vertical-align:" + va + ";" + width_add + height_add + "'>"; //中间板块颜色 
		rDivStr += "<div class='blcok_nr'   >"; //内部div 暂时无用
		rDivStr += m_block;
		rDivStr += "</div></td>";
		rDivStr += "<td class='" + bg_img_r_m + " '></td></tr>";
		/*----------------------下面是bubble的下半部分-------------------------------*/
		rDivStr += "<tr><td class='" + bg_img_l_b + " '></td>";
		rDivStr += "<td class='" + bg_img_m_b + " '></td>";
		rDivStr += "<td class='" + bg_img_r_b + " '></td></tr>";
		rDivStr += "</table>";
		/*================================================================================*/
		divs[i].innerHTML = rDivStr;

	}
}
/*此方法为应对含有csCombox插件*/
function bulidAppleBlockForCs(name, w, h, state) {
	var obj_name = name.substr(1, name.length);
	var divs = getElementsByClassName(obj_name);
	for (var i = 0; i < divs.length; i++) {
		var obj = divs[i];
		var width_add = '',
			height_add = '',
			nbyb_value;
		//bubble的9个区图片
		var bg_img_l_t, bg_img_l_m, bg_img_l_b;
		var bg_img_m_t, bg_img_m_m, bg_img_m_b;
		var bg_img_r_t, bg_img_r_m, bg_img_r_b;

		if (w != '' || w != null) {
			width_add = "width:" + w + "px;";
		}
		if (h != '' || h != null) {
			height_add = "height:" + h + "px;";
		}
		bg_img_l_t = "apple-block" + state + "-l-t";
		bg_img_l_m = "apple-block" + state + "-l-m";
		bg_img_l_b = "apple-block" + state + "-l-b";
		bg_img_m_t = "apple-block" + state + "-m-t";
		bg_img_m_m = "apple-block" + state + "-m-m";
		bg_img_m_b = "apple-block" + state + "-m-b";
		bg_img_r_t = "apple-block" + state + "-r-t";
		bg_img_r_m = "apple-block" + state + "-r-m";
		bg_img_r_b = "apple-block" + state + "-r-b";
		//组装样式
		/*================================================================================*/
		var rDivStr = "<table cellpadding='0' cellspacing='0'  value=" + nbyb_value + ">";
		rDivStr += "<tr> <td class='" + bg_img_l_t + " '></td>";
		rDivStr += "<td class='" + bg_img_m_t + " '></td>";
		rDivStr += "<td class='" + bg_img_r_t + " '></td></tr>";
		/*----------------------bubble的上半部分，下面是grid的中间部分-------------------------------*/
		rDivStr += "<tr><td class='" + bg_img_l_m + " '></td>";
		rDivStr += "<td class='" + bg_img_m_m + "' style='" + width_add + height_add + "'>"; //中间板块颜色 
		rDivStr += "<div class='blcok_nr' id='m_block' >"; //内部div 暂时无用 
		rDivStr += "</div></td>";
		rDivStr += "<td class='" + bg_img_r_m + " '></td></tr>";
		/*----------------------下面是bubble的下半部分-------------------------------*/
		rDivStr += "<tr><td class='" + bg_img_l_b + " '></td>";
		rDivStr += "<td class='" + bg_img_m_b + " '></td>";
		rDivStr += "<td class='" + bg_img_r_b + " '></td></tr>";
		rDivStr += "</table>";
		/*================================================================================*/
		$(obj).after(rDivStr);
		$("#m_block").replaceWith(obj);
	}
}
/*目标移动到相对其父级的居中位置
 *o->目标对象
 *styleL->'yes' 水平居中  'no'->水平不居中
 *styleT->'yes' 垂直居中  'no'->垂直不居中
 */
function cssCenter(o, styleL, styleT) {
	var wo = $(o).width();
	var ho = $(o).height();
	var wf = $(o).parent().width();
	var hf = $(o).parent().height();
	if (styleL == 'yes') {
		$(o).css({
			'margin-left': (wf - wo) / 2 + 'px'
		});
	}
	if (styleT == 'yes') {
		$(o).css({
			'margin-top': (hf - ho) / 2 + 'px'
		});
	}
}
/*绝对定位居中*/
function cssCenter2(o, styleL, styleT) {
	var wo = $(o).width();
	var ho = $(o).height();
	var wf = getWinWidth();
	var hf = getWinHeight();

	$(o).css({
		'position': 'absolute'
	});
	if (styleL == 'yes') {
		$(o).animate({
			'left': (wf - wo) / 2 + 'px'
		});
	}
	if (styleT == 'yes') {
		$(o).animate({
			'top': (hf - ho) / 2 + 'px'
		});
	}

}
/*横向进程轴 
 * o->目标对象
 * json txt->预留说明，value->0未完成灰色||value->1正在进行红色||value->2已完成绿色
 *
 * */
function bulidProgramLine(o, json) {
	var jStr = (new Function('return' + json))();
	var str_td = '',
		str_txt = '',
		s_icon = '',
		line_color = '',
		line_icon = 'program-state-line ';
	for (var i = 0; i < jStr.length; i++) {
		if (jStr[i].value == '0') {
			s_icon = 'p-s-gray';
			line_color = 'p-line-gray';
		} else if (jStr[i].value == '1') {
			s_icon = 'p-s-red';
			line_color = 'p-line-red';
		} else if (jStr[i].value == '2') {
			s_icon = 'p-s-green';
			line_color = 'p-line-green';
		}

		if (i == jStr.length - 1) {
			line_icon = '';
		}
		str_td += '<td>  <div id="' + jStr[i].id + '" class="program-state-1 ' + s_icon + '" style="float:left;" name="' + jStr[i].text + '"></div> <div style="float:left;" class=" ' + line_icon + line_color + '"></div>  </td>';
		str_txt += '<td><div class="program-txt">' + jStr[i].text + ' </div></td>';
	}
	var str = '<table cellpadding="0" cellspacing="0"><tr>' + str_td + ' </tr><tr>' + str_txt + '</tr></table>';

	$(o).append(str);
	chooseBubble();
	nbybBubble('', '', 2, '');
	progBubble('.program-state-1');
}

function chooseBubble() {

	if ($('.nbybBubble').length > 0) {} else {
		$('body').append("<div class='nbybBubble' style='position:absolut;display:none;'  ></div>");
	}

}


/*气泡*/
var ft = false,
	ft2 = false;

function progBubble(o) {

	$(o).hover(
		function() {
			///  var bubbleText=$(this).attr('name'); 
			var thisID = $(this).attr('id'),
				bubbleText;
			if (typeof(getProgText) != 'undefined') {
				bubbleText = getProgText(thisID);
			}
			if (bubbleText == '' || bubbleText == null) {} else {
				nbybBubble('', '', 2, bubbleText);
				nbybBubbleShow();
				ft = true;
			}
		},
		function() {
			ft = false;
			var bubble_time = setTimeout(function() {
				if (ft == false) {
					if (ft2 == false) {
						nbybmouseout();
						ft = false;
						bubble_time = null;
					}
				} else if (ft == true) {}
			}, 1000);
		});
	$('.nbybBubble').hover(
		function() {
			$('.nbybBubble').show();
			ft2 = true;
		}, function() {
			$('.nbybBubble').hide();
			ft2 = false;
		});
}


/*创建回到顶部图标
 * o->回到顶部按钮对象
 * */
function bulidGoTop(o) {
	$(window).bind("scroll", function() {
		var scrHeight = $(document).scrollTop();
		if (scrHeight > 50) {
			$(o).show();
		} else if (scrHeight < 50) {
			$(o).fadeOut();
		}
	});
	$(o).attr('onmouseup', 'GoTopAction(this)');
}
/*回到顶部的动态特效*/
function GoTopAction(o) {
	$("html,body").animate({
		"scrollTop": "0"
	}, 200);
}
//锚点间移动
function gotoObjDiv(o) {
	var li_name = $(o).attr('name');
	$('body,html').animate({
		scrollTop: $('#' + li_name).offset().top - 20 + 'px'
	}, 200);
}


/*创建圆点点击按钮 的框架 n创建多少个*/
function bulidPointBtn(obj, n) {
	var str_li = '';
	for (var i = 0; i < n; i++) {
		str_li += '<li value="' + i + '"></li>';
	}
	var str = '<ul class="apple-ul">' + str_li + '</ul>';
	$(obj).append(str);
	circleOfCss('clickLi(this)');
}
/*圆点按钮的样式和事件加载
 * foo->点击后执行的函数
 * */
function circleOfCss(foo) {
	$('.apple-ul').css({
		'width': 20 * $('.apple-ul li').size() + 'px'
	});
	$('.apple-ul li').attr('onclick', foo).addClass('ui-point-btn-1').addClass('point-btn-2');
}

/*按钮的切换 
 * n->当前点击按钮序号*/
function shiftUlBtn(n) {
	$('.apple-ul li').removeClass('point-btn-1').addClass('point-btn-2');
	$('.apple-ul li').eq(n).removeClass('point-btn-2').addClass('point-btn-1');
}
/*圆点按钮点击后的事件*/
function clickLi(o) {
	var btn_num = $(o).index();
	shiftUlBtn(btn_num);
	if (typeof(circleOfBtn) != 'undefined') {
		circleOfBtn(o);
	}
}

/*目标被滚动到顶部时*/
function nbybTopJudge(f_obj) {
	$(window).bind('scroll', function() {
		var wd = window.document.documentElement.scrollTop;
		var fh = $(f_obj).offset().top;

		if (fh - wd < 0) {
			if (typeof(nbybToFixed) != 'undefined') {
				nbybToFixed();
			}
		} else if (fh - wd > 0) {
			if (typeof(nbybToStatic) != 'undefined') {
				nbybToStatic();
			}
		}
	});
}

/*以下为对目标对象拖拽功能*/
var isDrag = false;

function nbybObjDrag(name, style) {
	var obj = $(name)[0];
	var ac = 'mousedown',
		foo = drag;
	if (style == 'yes') {
		if ($.browser.version >= 8.0) {
			$(name).addClass('mouse-move');
			obj.attachEvent("on" + ac, foo);
		}
	} else if (style == 'no') {
		$(name).removeClass('mouse-move');
		obj.detachEvent("on" + ac, foo);
	}
}

function noDrag(e) {}

function drag(e) {
	var e = e || window.event;
	var element = e.srcElement || e.target;
	if (e.preventDefault) e.preventDefault();
	else e.returnvalue = false;
	isDrag = true;
	var obj = $(e.srcElement).closest('.mouse-move');
	var relLeft = e.clientX - parseInt(obj.css('left'));
	var relTop = e.clientY - parseInt(obj.css('top'));
	var z_index = obj.css('z-index');
	element.onmouseup = function() {
		isDrag = false;
		obj.css({
			'z-index': z_index
		});
	}
	document.onmousemove = function(e_move) {
		var e_move = e_move || window.event;
		if (isDrag) {
			obj.css({
				'left': e_move.clientX - relLeft + 'px',
				'top': e_move.clientY - relTop + 'px',
				'z-index': '99999'
			});
			return false;
		}
	}
}


function bulidPersonCard(name, w, h, state, text) {
	var obj_div = $(name);
	for (var i = 0; i < obj_div.size(); i++) {
		var obj = obj_div[i];
		//td标签通用样式
		var bg_l, bg_m, bg_r, bg_m_arrow;
		var bg_flg;
		var wStyle = '',
			hStyle = '';
		if (w != '') {
			wStyle = 'width:' + w + 'px;';
		}
		if (h != '') {
			hStyle = 'height:' + h + 'px;';
		}
		var m_block = text;
		if (state > 0 && state <= 1) {
			state = parseInt(state);
			bg_l = 'person-block' + state + '-l person-border' + state;
			bg_m = 'person-block' + state + '-m person-border' + state;
			bg_r = 'person-block' + state + '-r person-border' + state;
			bg_m_arrow = 'person-arrow-' + state;
			bg_flg = 'person-photo-' + state;
			var f_format = ' person-format' + state + '-txt';
		} else {
			window.alert("bulidPersonCard样式" + state + "不存在,目前就这么几个样式");
		}
		//组装样式
		/*================================================================================*/
		var rDivStr = '<table  class="per-crad" cellpadding="0" cellspacing="0"><tr>';
		rDivStr += '<td  class="' + bg_l + '">' +
			'<div class="' + bg_flg + '"  ></div>' +
			'</td>';
		rDivStr += '<td  class="' + bg_m + '">' +
			'<div class="' + bg_m_arrow + '"></div>'
		' </td> ';
		rDivStr += '<td  class="' + bg_r + '">';
		rDivStr += '<div class="' + f_format + '" style="' + wStyle + hStyle + '">' + m_block + '</div>';
		rDivStr += '</td> </tr>';
		rDivStr += '</table>';
		/*================================================================================*/
		obj_div[i].innerHTML = rDivStr;
	}
}

function personUp(o) {
	var obj = $(o).closest('.per-crad').find('td:eq(2)>div');
	obj.animate({
		'width': '0px'
	});
	//obj.fadeOut(500,function(){ obj.animate({'width':'0px'}); });
}



/*将目标div变更为标签*/
function bulidTabName(id, state, w) {
	if (state == 1) {
		bulidTabName1(id, w);
	} else {
		alert('bulidTabName的state参数错误');
	}

}
/*标签1号样式*/
function bulidTabName1(id, w) {
	var txt, obj;
	for (var i = 0; i < $(id).length; i++) {
		obj = $(id).eq(i);
		txt = obj.html();
		obj.html('');
		obj.append(setTabTxt1(txt, w));
	}
}
/*拼装样式*/
function setTabTxt1(txt, w) {
	var str_tr1 = "<tr  > <td><div  class='tabName_l'></div></td> ";
	str_tr1 += "<td><div  class='tabName_m'>" + txt + "</div></td>";
	str_tr1 += "<td style='vertical-align: top '><div class='tabName_r arrow_rb'></div></td>";
	str_tr1 += "<td style='width:" + w + "px;'></td> </tr>";
	var str_tr2 = "<tr><td colspan='4'><div class='tabName-line-1'></div></td> </tr>";
	var str_table = '<table cellpadding="0" cellspacing="0">' + str_tr1 + str_tr2 + '</table>';
	return str_table;
}
/*仿苹果按钮*/
function BulidAppleBtn(id, style, title, thisflg) {
	var iformat = 'apple-format-btn-',
		btnBG = 'apple-btn-';
	var css_out, css_over, css_off;
	if (style == '' || typeof(style) == 'undefined') {
		style = 2;
	}


	iformat += style;
	btnBG += style;
	css_out = 'apple-btn-' + style + '-out';
	css_over = 'apple-btn-' + style + '-over';
	css_off = 'apple-btn-' + style + '-off';
	$(id).addClass(iformat).addClass(btnBG).attr('title', title);
	if (thisflg == 'yes') {
		$(id).removeClass(css_off).addClass(css_out);
		$(id).hover(
			function() {
				$(this).removeClass(css_out).addClass(css_over);
			},
			function() {
				$(this).removeClass(css_over).addClass(css_out);
			}
		);
	} else if (thisflg == 'no') {
		$(id).removeClass(css_out).removeClass(css_over).addClass(css_off);
	} else {
		alert(id + '的thisflg错误,其值不能为：' + thisflg);
	}
}

/*设定指定目标为屏宽*/
function setObjWH(obj, styleX, styleY, x, y) {
	var win_w = document.documentElement.clientWidth;
	var win_h = document.documentElement.clientHeight;

	x = parseInt(x);
	y = parseInt(y);
	if (x) {
		win_w = win_w + x;
	}
	if (y) {
		win_h = win_h + y
	}

	$(obj).css({
		'width': win_w + 'px',
		'height': win_h + 'px'
	});
	//  if(styleX!=''){$(obj).css({'overflow-x':'hidden'});}
	//  if(styleY!=''){$(obj).css({'overflow-y':'hidden'});} 

}
/*获取屏幕宽*/
function getWinWidth() {
	return document.documentElement.clientWidth;
}
/*获取屏幕高*/
function getWinHeight() {
	return document.documentElement.clientHeight;
}
/*获取鼠标当前X坐标*/
function getX(ev) {
	var x;
	if( $.browser.msie == true ||$.browser.webkit == true ){
		x=event.clientX + window.document.documentElement.scrollLeft;
		
	}
	else{
		/*兼容除ie外的其他浏览器*/
		 x=0;
	 
		 
	}
	
	return x;
}
/*获取鼠标当前Y坐标*/
function getY() {
	return event.clientY + window.document.documentElement.scrollTop;
}

function getMousePosition() {
	var a = {};
	a.x = event.clientX + window.document.documentElement.scrollLeft;
	a.y = event.clientY + window.document.documentElement.scrollTop;
	return a;
}

/*判断不重复加载滚动条*/
function setGDT(o, n, css, p) {
	if (p == false || typeof(p) == 'undefined' || p == '') {
		p = false;
	}
	var scroll = $(o).find('.mCustomScrollBox').length;
	if (scroll > 0) {
		shiftGDT(o, 'no', n, css, p);
	} else if (scroll <= 0) {
		shiftGDT(o, 'yes', n, css, p);
	}

}

/*滚动条
 * o->目标对象
 * style->是否重新加载
 * n->传参
 * css->样式
 * */
function shiftGDT(o, style, n, css, p) {
	if (style == 'yes') {
		$(o).mCustomScrollbar({
			scrollButtons: {
				enable: p
			},
			callbacks: {
				whileScrolling: function() {
					if (n != '' || typeof(n) != 'undefined') {
						WhileScrolling(n);
					}
				}
			},
			theme: css
		});
	} else if (style == 'no') {
		$(o).mCustomScrollbar("update");
	} else {
		alert('是否初始化参数错误，请修正后调试');
	}
}

function WhileScrolling(n) {
	if (mcs.topPct >= n) {
		if (typeof(scrollEnd) != 'undefined') {
			scrollEnd();
		}
	}
}

/*是否进行提示文字的激活*/
function inputMsg(o, style, text1, text2) {
	if (style == 'yes') {
		if (text1 == '') {} else {
			if (text2 == '') {
				text2 = text1;
			}
			InputFocus(o, text1, text2);
		}
	} else if (sytle = 'no') {} else {}
}
/*对指定对象进行提示信息，
 * o->目标对象
 * text1->初始化提示文字
 * text2->点击后提示文字
 * 2014-01-03 新增内容颜色的变更判断
 * */
function InputFocus(o, text1, text2) {

	var t_color_out = '#808080',
		t_color_on = '#000',
		inStyle = $(o).css('color');
	if (inStyle != '#000000' || inStyle != '#808080') {
		t_color_on = inStyle;
		t_color_out = inStyle;
	}

	$(o).val(text1).css({
		'color': t_color_out
	});
	$(o).focusin(function() {
		if (this.value == text1) {
			this.value = '';
			$(o).css({
				'color': t_color_on
			});
		} else {}
	});
	$(o).focusout(function() {
		var txt = this.value;
		txt = txt.replace(/(^\s*)|(\s*$)/g, '');
		if (this.value == ' ' || this.value == null || txt == '') {
			this.value = text2;
			$(o).css({
				'color': t_color_out
			});
		} else if (this.value) {
			$(o).css({
				'color': t_color_on
			});
		}
	});
}
/*select*/
function selectSize(style, id, num) {
	var obj = chooseHtml(style, id);
	if (num != '' || typeof(num) != 'undefined') {
		$(obj).attr('size', num).attr('height', '');
	}
}

function chooseHtml(style, id) {
	var obj = '';
	obj = '#' + style + '_' + id;
	return obj;
}


/*对指定select标签进行传值*/
function selectJson(id, json, empty) {
	var jStr = (new Function('return' + json))();
	var obj = '#select_' + id;
	if (empty == 'yes') {
		$(obj).empty();
	}
	if (empty == 'no') {} else {
		alert('selectJson参数错误');
	}

	var str = ''
	for (var n = 0; n < jStr.length; n++) {
		str += '<option value="' + jStr[n].value + '">' + jStr[n].text + '</option>';
	}
	$(obj).append(str);
}
/*对指定Textarea标签规格参数判断*/
function textareaNorms(id, c, r, x, y) {
	var x_w = '',
		y_h = '',
		style = '';
	if (c != '' && r != '' && x != '' && y != '') {
		alert('参数设置错误，宽高规格有冲突');
	} else {
		if (c != '' && r != '') {
			style = 'cr';
			x_w = c;
			y_h = r;
		} else if (x != '' && y != '') {
			style = 'wh';
			x_w = x;
			y_h = y;
		}
	}
	textareaWH(id, style, x_w, y_h);
}
/*对指定Textarea标签规格设置*/
function textareaWH(id, style, x, y) {
	var xx = '',
		yy = '',
		obj = '#textarea_' + id;
	if (style == 'cr') {
		$(obj).attr('rows', x).attr('cols', y);
	} else if (style == 'wh') {
		$(obj).css({
			'width': x,
			'height': y
		});
	}
}



function setTagProperty(style, id, pro, value) {
	var obj = chooseHtml(style, id);
	$(obj).attr(pro, value);
}

function setAction(style, id, foo, act) {
	var obj = chooseHtml(style, id);
	if (foo != '' || typeof(foo) != 'undefined') {
		$(obj).attr(act, foo + '(this)');
	} else if (foo == '') {
		$(obj).attr(act, foo);
	}
}

function getTagVal(style, id) {
	var obj = chooseHtml(style, id);
	return $(obj).val();
}

function setTagVal(style, id, val) {
	var obj = chooseHtml(style, id);
	$(obj).val(val);
}

function setProForTag(style, obj, pro, value) {
	$(obj).attr(pro, value);
}

function setCssForTag(style, obj, c, v) {
	if (c == 'height') {
		$(obj).css({
			'height': v
		});
	} else if (c == 'width') {
		$(obj).css({
			'width': v
		});
	}
}
/*以下对table进行参数设定*/
function setTable(id, tr, td, empty) {
	var style = 'table';
	var obj = chooseHtml(style, id);
	var str_tr = '',
		str_td = '';

	if (empty == '' || typeof(empty) == 'undefined' || empty == 'yes') {
		$(obj).empty();
	} else if (empty == 'no') {} else {
		alert('setTable参数错误');
	}
	for (var i = 0; i < tr; i++) {
		str_td = '';
		for (var m = 0; m < td; m++) {
			str_td += '<td id="' + id + '_' + i + '_' + m + '"></td> ';
		}
		str_tr += '<tr id="' + id + '_' + i + '">' + str_td + '</tr>';
	}
	$(obj).append(str_tr);
}

function setUl(id, liNum, cssNum, empty) {
	var style = 'ul';
	var obj = chooseHtml(style, id);
	var str_li = '';
	var css = 'class=" li-format-' + cssNum + '"';

	if (empty == 'yes') {
		$(obj).empty();
	} else if (empty == 'no') {} else {
		alert('setUl参数错误');
	}

	for (var i = 0; i < liNum; i++) {
		str_li += '<li id="' + id + '_' + i + '" ' + css + ' >' + i + '</li>';
	}
	$(obj).append(str_li);
}


function setBorder(obj, bool, style, w, c) {
	if (bool == 0) {} else if (bool == 1) {
		$(obj).css({
			'border-color': c,
			'border-style': style,
			'border-width': w
		});
	}
}
/*对table赋值
 * id=table的标签id
 * tr 第几行
 * td 第几列
 * str 需要放入的内容 type=string
 * r 是否放入前清空
 * */

function setTableStr(id, tr, td, str, r) {
	var style = 'table';
	var obj = chooseHtml(style, id);
	var obj_td = $(obj).find('tr').eq(tr).find('td').eq(td);
	if (r == 'yes') {
		obj_td.empty();
	} else if (r == 'no') {}
	obj_td.append(str);
}
/*将指定目标的html放入*/
/* 
 *getObj ->  需要获取 目标内对象
 *setObj   ->  需要放入的目标的对象
 *r    ->  是否在放入前清空目标内部
 */
function setObjstr(getObj, setObj, r) {
	var getStr = $(getObj).html();
	if (r == 'yes') {
		obj_td.empty();
	} else if (r == 'no') {}
	$(setObj).append(getStr);
}


/*
 * 验证码
 * */
var code; //在全局 定义验证码
function createCode(n) {
	code = new Array();
	var codeLength = 4; //验证码的长度
	var checkCode = document.getElementById("checkCode");
	checkCode.value = "";
	alert(n);
	if (n == '1') {
		var selectChar = new Array(2, 3, 4, 5, 6, 7, 8, 9, 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
	} else if (n == '2') {
		var selectChar = new Array('一', '二', '三', '四', '五', '六', '七', '八', '九', '十');
	}

	for (var i = 0; i < codeLength; i++) {
		var charIndex = Math.floor(Math.random() * 10);
		code += selectChar[charIndex];
	}
	if (code.length != codeLength) {
		createCode();
	}
	checkCode.value = code;
}

function validate() {
	var inputCode = document.getElementById("pwd").value.toUpperCase();
	if (inputCode.length <= 0) {
		alert("请输入验证码！");
		return false;
	} else if (inputCode != code) {
		alert("验证码输入错误！");
		createCode();
		return false;
	} else {
		alert("成功！");
		return true;
	}
}

/***************************************对Tag的Dom进行外包装，选项卡*/
function bulidTag(name, num) {
	setTag(name);
	chooseTagBox(name, num);
}
/*对tag添加事件*/
function setTag(o) {
	$(o).find('tr').eq(0).find('ul>li').addClass('ui-tag-li-1').addClass('tb_out').attr('onmouseup', 'tagliClick(this)')
	$(o).find('tr').eq(0).find('li').hover(
		function() {
			pointPosition(o, $(this).index(), '1');
		},
		function() {
			pointPosition(o, '', '0');
		}
	);
	var w = $(o).find('tr .tagbox').width();
	$('.point-td').css({
		'width': w + 'px'
	});

}

/*选择哪个tag的哪个项*/
function chooseTagBox(o, n) {
	var obj = $(o).find('tr').eq(0).find('li');
	obj.removeClass('tb_over').addClass('tb_out');
	obj.eq(n).removeClass('tb_out').addClass('tb_over');
	$(o).find('.tagbox').find('ul li').hide().eq(n).show();
	pointPosition(o, n, 1);
}
/*指针移动*/
function pointPosition(obj, n, style) {
	var w = $('.tb_over').width() + 4;
	if (style == 0) {
		n = $(obj).find('tr').eq(0).find('ul').find('.tb_over').index();
	}
	$(obj).find('.point-move').stop().animate({
		'margin-left': n * w + 'px',
		'width': w + 'px'
	}, {
		duration: 800,
		easing: 'easeOutQuart'
	});
}

/****************************************打字机效果***************************/
(function(jQuery) {
	var name = "ticker"; // Name of the plugin

	// FUNCTIONS

	function indexify(i, length) {
		return (i >= length) ? indexify(i - length, length) : ((i < 0) ? indexify(i + length, length) : i);
	}

	function advanceItem(elem) {
		var data = elem.data(name);
		var length;
		for (var i = 0; i < 200; i++) {
			if (!data.content[i]) {
				length = i;
				break;
			}
		}
		data.nextItem = indexify((data.nextItem || 0), length);
		data.currentItem = data.nextItem;
		data.elemIndex = [data.currentItem];
		data.charIndex = 0;
		data.nextItem++;
	}

	function makeFamily(elem) {
		var obj = {
			elem: elem.clone().empty()
		};
		var children = elem.children();
		if (children.length) {
			children.each(function(i) {
				obj[i] = makeFamily($(this));
			});
			return obj;
		} else {
			obj.text = elem.text()
			return obj;
		}
	}

	function checkFamily(content, index) {
		var newIndex;
		if (content[index[0]]) {
			if (content[index[0]].text) {
				return content[index[0]];
			} else if (index.length == 1) {
				return true;
			} else {
				newIndex = $.makeArray(index);
				return checkFamily(content[newIndex[0]], newIndex.splice(1, newIndex.length));
			}
		} else {
			return false;
		}
	}

	function incrementIndex(index) {
		if (index.length > 1) {
			index[index.length - 1]++;
			return index;
		} else {
			return false;
		}
	}

	function buildIndex(content, index) {
		if (index === false) {
			return false;
		}
		var obj = checkFamily(content, index);
		if (obj === false) {
			return buildIndex(content, incrementIndex(index.slice(0, index.length - 1)));
		} else if (obj === true) {
			index[index.length] = 0;
			return buildIndex(content, index);
		} else {
			return index;
		}
	}

	function buildFamily(elem, content, index, data) {
		var newIndex, newElem;
		var child = elem.children().eq(index[0]);

		if (!index.length) {
			return {
				readout: elem,
				text: content.text
			};
		} else if (child.length) {
			newElem = child;
		} else {
			newElem = content[index[0]].elem.appendTo(elem);
		}

		newIndex = $.makeArray(index).slice(1, index.length);
		return buildFamily(newElem, content[index[0]], newIndex, data);
	}

	function initElem(elem) {
		var data = elem.data(name);
		$("*", elem).empty();
		elem.empty();
		data.start = 0;
		data.sum = 0;
		if (data.cursorIndex) {
			cursorIndex = 0;
		}
	}

	function initChild(elem) {
		var data = elem.data(name);
		data.start = data.sum;
	}

	function ticker(elem, threadIndex, data) {
		var index, letter;

		// Switch cursor
		if (data.cursorIndex !== false) {
			data.cursorIndex = indexify(data.cursorIndex + 1, data.cursorList.length);
			data.cursor.html(data.cursorList[data.cursorIndex]);
		} else {
			data.cursor.html(data.cursorList);
		}

		// Add character to readout
		index = data.charIndex - data.start;
		letter = data.text.charAt(index - 1);
		data.cursor.before(letter);

		if (data.charIndex >= data.sum) {
			data.cursor.remove();
			data.elemIndex = incrementIndex(data.elemIndex);
			return tape(elem, threadIndex);
		} else {
			return setTimeout(function() {
				if (data.eventIndex == threadIndex) {
					data.charIndex++;
					ticker(elem, threadIndex, data);
				}
				threadIndex = null;
			}, data.rate);
		}
	}

	function tape(elem, threadIndex) {
		var data = elem.data(name);

		if (data.eventIndex == threadIndex) {

			data.elemIndex = buildIndex(data.content, data.elemIndex);
			//console.log('INDEX '+data.elemIndex);

			if (data.elemIndex === false) {
				return setTimeout(function() {
					if (data.running && (data.eventIndex == threadIndex)) {
						advanceItem(elem);
						return tape(elem, threadIndex);
					}
					threadIndex = null;
				}, data.delay);
			} else if (!data.charIndex) {
				initElem(elem);
			} else {
				initChild(elem);
			}

			$.extend(data, buildFamily(elem, data.content, data.elemIndex));
			data.sum = data.sum + data.text.length;
			data.readout.append(data.cursor);
			return ticker(elem, threadIndex, data);
		}
	}

	// PLUGIN DEFINITION

	$.fn[name] = function(options) {

		// Add or overwrite options onto defaults
		var o = $.extend({}, $.fn.ticker.defaults, options);

		// Iterate matched elements
		return this.each(function() {

			var elem = $(this);

			elem
				.data(name, {
					rate: o.rate,
					delay: o.delay,
					content: makeFamily(elem),
					cursor: o.cursor,
					cursorList: o.cursorList,
					cursorIndex: (typeof(o.cursorList) == "object") ? 0 : false,
					nextItem: 0,
					eventIndex: 0
				})
				.bind("stop", function(e) {
					var data = elem.data(name);
					data.running = false;
				})
				.bind("play", function(e) {
					var data = elem.data(name);
					data.eventIndex++;
					data.running = true;
					data.nextItem = (e.item || data.nextItem);
					advanceItem(elem);
					tape(elem, data.eventIndex);
				})
				.bind("control", function(e) {
					var data = elem.data(name);
					$().extend(data, {
						nextItem: e.item,
						rate: e.rate,
						delay: e.delay
					});
				})
				.children()
				.remove();
		});
	};

	// PLUGIN DEFAULTS

	$.fn[name].defaults = {
		rate: 40, // Speed to print message.
		delay: 2000, // Pause to read message.
		cursorList: "_", // A string or an array of strings or jQuery objects. If an array, the cursor loops through the array.
		cursor: $('<span class="cursor" />')
	}

})(jQuery);
/********************************************windows-Aero***********************/
(function($) {
	$.fn.extend({
		//plugin name - Aero Window (like Windows7 Style) 
		chinaz: function(options) {

			//Identify clearly this window ----------------------------------------
			WindowID = $(this).attr('id');
			if (($('body').data(WindowID)) == null) {
				var $WindowAllwaysRegistered = false;
				//Register this Window
				$('body').data(WindowID, 1);
			} else {
				//Window exists
				var $WindowAllwaysRegistered = true;
			}
			//If the window is registered, just show it and set focus ---------------     
			if ($WindowAllwaysRegistered == true) {
				Window = $(this).find(".chinaz");
				$(this).find(".chinaz").css('display', 'block');
				$(".chinaz").removeClass('active');
				if (Window.hasClass('chinaz')) Window.addClass('active');
				if (($('body').data('chinazMaxZIndex')) == null) {
					$('body').data('chinazMaxZIndex', Window.css('z-index'));
				}
				i = $('body').data('chinazMaxZIndex');
				i++;
				Window.css('z-index', i);
				$('body').data('chinazMaxZIndex', Window.css('z-index'));
				return;
			}

			//Settings Window and the default values---------------------------------
			var defaults = {
				WindowTitle: null,
				WindowPositionTop: 60,
				/* Posible are pixels or 'center' */
				WindowPositionLeft: 10,
				/* Posible are pixels or 'center' */
				WindowWidth: 300,
				/* Only pixels */
				WindowHeight: 300,
				/* Only pixels */
				WindowMinWidth: 250,
				/* Only pixels */
				WindowMinHeight: 0,
				/* Only pixels */
				WindowResizable: true,
				/* true, false*/
				WindowMaximize: true,
				/* true, false*/
				WindowMinimize: true,
				/* true, false*/
				WindowClosable: true,
				/* true, false*/
				WindowDraggable: true,
				/* true, false*/
				WindowStatus: 'regular',
				/* 'regular', 'maximized', 'minimized' */
				WindowAnimationSpeed: 500,
				WindowAnimation: 'easeOutElastic'
			};

			/*-----------------------------------------------------------------------
          Posible WindowAnimation:
          - easeInQuad
          - easeOutQuad
          - easeInOutQuad
          - easeInCubic
          - easeOutCubic
          - easeInOutCubic
          - easeInQuart
          - easeOutQuart
          - easeInOutQuart
          - easeInQuint
          - easeOutQuint
          - easeInOutQuint
          - easeInSine
          - easeOutSine
          - easeInOutSine
          - easeInExpo
          - easeOutExpo
          - easeInOutExpo
          - easeInCirc
          - easeOutCirc
          - easeInOutCirc
          - easeInElastic
          - easeOutElastic
          - easeInOutElastic
          - easeInBack
          - easeOutBack
          - easeInOutBack
          - easeInBounce
          - easeOutBounce
          - easeInOutBounce      
          -----------------------------------------------------------------------*/

			//Assign current element to variable, in this case is UL element
			var options = $.extend(defaults, options);

			return this.each(function() {
				var o = options;

				//Generate the new Window ---------------------------------------------     
				var WindowContent = $(this).html();

				//BTN --- 
				if (o.WindowMinimize) {
					if (o.WindowMaximize || o.WindowClosable) {
						var WinMinBtn = '<a href="#" class="win-min-btn"></a><div class="win-btn-spacer"></div>';
					} else {
						var WinMinBtn = '<a href="#" class="win-min-btn"></a>';
					}
				} else {
					var WinMinBtn = '';
				}
				//BTN ---
				if (o.WindowMaximize) {
					if (o.WindowClosable) {
						var WinMaxBtn = '<div class="WinBtnSet winmax"><a href="#" class="win-max-btn"></a><div class="win-btn-spacer"></div></div>';
						var WinRegBtn = '<div class="WinBtnSet winreg"><a href="#" class="win-reg-btn"></a><div class="win-btn-spacer"></div></div>';
					} else {
						var WinMaxBtn = '<div class="WinBtnSet winmax"><a href="#" class="win-max-btn"></a></div>';
						var WinRegBtn = '<div class="WinBtnSet winreg"><a href="#" class="win-reg-btn"></a></div>';
					}
				} else {
					var WinMaxBtn = '';
					var WinRegBtn = '';
				}
				//BTN ---
				if (o.WindowClosable) {
					var WinCloseBtn = '<a href="#" class="win-close-btn"></a>';
				} else {
					var WinCloseBtn = '';
				}

				if (o.WindowMinimize || o.WindowMaximize || o.WindowClosable) {
					var WinBtnLeftedge = '<div class="win-btn-leftedge"></div>';
					var WinBtnRightedge = '<div class="win-btn-rightedge"></div>';
				} else {
					var WinBtnLeftedge = '';
					var WinBtnRightedge = '';
				}
				$(this).html(
					'<div class="chinaz">' +
					'  <table cellpadding="0" cellspacing="0" border="0">' +
					'    <tr>' +
					'      <td class="table-tl"></td>' +
					'      <td class="table-tm"></td>' +
					'      <td class="table-tr"></td>' +
					'    </tr>' +
					'    <tr>' +
					'      <td class="table-lm"></td>' +
					'      <td class="table-mm" align="right">' +
					'        <div class="title"><nobr>' + o.WindowTitle + '</nobr></div>' +
					'        <div class="buttons">' +
					WinBtnLeftedge +
					WinMinBtn +
					WinMaxBtn +
					WinRegBtn +
					WinCloseBtn +
					WinBtnRightedge +
					'        </div>' +
					'        <div class="table-mm-container" align="left">' +
					'          <div class="table-mm-content" style="width: ' + o.WindowWidth + 'px; height: ' + o.WindowHeight + 'px;">' +
					WindowContent +
					'          </div>' +
					'        </div>' +
					'      </td>' +
					'      <td class="table-rm"></td>' +
					'    </tr>' +
					'    <tr>' +
					'      <td class="table-bl"></td>' +
					'      <td class="table-bm"></td>' +
					'      <td class="table-br"></td>' +
					'    </tr>' +
					'  </table>' +
					'</div>'
				);

				//Display hidden Containers -------------------------------------------
				$(this).css('display', 'block');

				//Window Objects ------------------------------------------------------
				var Window = $(this).find(".chinaz");
				var WindowContainer = $(this).find(".table-mm-container");
				var WindowContent = $(this).find(".table-mm-content");
				var BTNMin = $(this).find(".win-min-btn");
				var BTNMax = $(this).find(".WinBtnSet.winmax");
				var BTNReg = $(this).find(".WinBtnSet.winreg");
				var BTNClose = $(this).find(".win-close-btn");

				//Initial Configuration -----------------------------------------------
				BTNReg.css('display', 'none');
				FocusWindow(Window);

				//Set Window Position
				if (o.WindowPositionTop == 'center') {
					o.WindowPositionTop = ($(window).height() / 2) - o.WindowHeight / 2 - 37;
				}
				if (o.WindowPositionLeft == 'center') {
					o.WindowPositionLeft = ($(window).width() / 2) - o.WindowWidth / 2 - 17;
				}

				switch (o.WindowStatus) {
					case 'regular':
						RegularWindow();
						break;
					case 'maximized':
						MaximizeWindow();
						break;
					case 'minimized':
						MinimizeWindow();
						break;
					default:
						break;
				}
				//Window Functions ----------------------------------------------------
				function MaximizeWindow() {
					WindowContainer.css('visibility', 'visible');
					BTNMax.css('display', 'none');
					BTNReg.css('display', 'block');
					WindowContent.animate({
						width: $(window).width() - 32,
						height: $(window).height() - 77
					}, {
						queue: false,
						duration: o.WindowAnimationSpeed,
						easing: o.WindowAnimation
					});
					//Set new Window Position
					Window.animate({
						width: $(window).width(),
						height: $(window).height(),
						top: 0,
						left: 0
					}, {
						duration: o.WindowAnimationSpeed,
						easing: o.WindowAnimation
					});
					o.WindowStatus = 'maximized';
					return (false);
				}

				function MinimizeWindow() {
					BTNReg.css('display', 'block');
					BTNMax.css('display', 'none');
					WindowContainer.css('visibility', 'hidden');
					WindowContent.animate({
						width: o.WindowMinWidth,
						height: o.WindowMinHeight
					}, {
						queue: true,
						duration: o.WindowAnimationSpeed,
						easing: o.WindowAnimation
					});
					//Set new Window Position
					Window.animate({
						width: o.WindowMinWidth + 32,
						height: o.WindowMinHeight + 72,
						top: $(window).height() - 77,
						left: 0
					}, {
						duration: o.WindowAnimationSpeed,
						easing: o.WindowAnimation
					});
					o.WindowStatus = 'minimized';
					return (false);
				}

				function RegularWindow() {
					BTNMax.css('display', 'block');
					BTNReg.css('display', 'none');
					WindowContainer.css('visibility', 'visible');
					WindowContent.animate({
						width: o.WindowWidth,
						height: o.WindowHeight
					}, {
						queue: false,
						duration: o.WindowAnimationSpeed,
						easing: o.WindowAnimation
					});
					Window.animate({
						width: o.WindowWidth + 32,
						height: o.WindowHeight + 72
					}, {
						queue: false,
						duration: o.WindowAnimationSpeed,
						easing: o.WindowAnimation
					});
					//Set new Window Position
					//Error handling, if the left position is negative.
					if ((typeof(o.WindowPositionLeft) == 'string') && (o.WindowPositionLeft.substring(0, 1) == '-')) o.WindowPositionLeft = 0;
					Window.animate({
						top: o.WindowPositionTop,
						left: o.WindowPositionLeft
					}, {
						duration: o.WindowAnimationSpeed,
						easing: o.WindowAnimation
					});
					o.WindowStatus = 'regular';
					return (false);
				}

				function FocusWindow(Window) {
					$(".chinaz").removeClass('active');
					if (Window.hasClass('chinaz')) Window.addClass('active');
					if (($('body').data('chinazMaxZIndex')) == null) {
						$('body').data('chinazMaxZIndex', Window.css('z-index'));
					}
					i = $('body').data('chinazMaxZIndex');
					i++;
					Window.css('z-index', i);
					$('body').data('chinazMaxZIndex', Window.css('z-index'));
				}

				//Attach user events to the Window ------------------------------------
				if (o.WindowMaximize) {
					$(this).dblclick(function() {
						switch (o.WindowStatus) {
							case 'regular':
								MaximizeWindow();
								break;
							case 'maximized':
								RegularWindow();
								break;
							case 'minimized':
								RegularWindow();
								break;
							default:
								break;
						}
					});
				} else {
					$(this).dblclick(function() {
						switch (o.WindowStatus) {
							case 'maximized':
								RegularWindow();
								break;
							case 'minimized':
								RegularWindow();
								break;
							default:
								break;
						}
					});
				}

				//User Interaction - Minimize Button
				BTNMin.click(function() {
					FocusWindow(Window);
					MinimizeWindow();
					return false;
				});
				//User Interaction - Maximize Button
				BTNMax.click(function() {
					FocusWindow(Window);
					MaximizeWindow();
					return false;
				});
				//User Interaction - Regular Button
				BTNReg.click(function() {
					FocusWindow(Window);
					RegularWindow();
					return false;
				});
				//Close Button
				BTNClose.click(function() {
					//Unregister this Window
					Window.css('display', 'none');
					return (false);
				});

				//Support Dragging ----------------------------------------------------
				if (o.WindowDraggable) {
					Window.draggable({
						distance: 3,
						cancel: ".table-mm-content",
						start: function() {
							FocusWindow(Window);
							$(".chinaz").find('#iframeHelper').css({
								'display': 'block'
							});
							$(".chinaz").removeClass('active');
							$(this).addClass('active');
							$('body').data('chinazMaxZIndex', $(this).css('z-index'));
						},
						drag: function() {
							WindowTop = -1 * $(this).offset().top;
							WindowLeft = -1 * $(this).offset().left;
							$(this).css({
								backgroundPosition: WindowLeft + 'px ' + WindowTop + 'px'
							});
						},
						stop: function() {
							//alert(Window.css('top'));
							o.WindowPositionTop = Window.css('top');
							o.WindowPositionLeft = Window.css('left');
							$(".chinaz").find('#iframeHelper').css({
								'display': 'none'
							});
						}
					});
				}

				//Support Focus on Window by Click ------------------------------------
				Window.click(function() {
					FocusWindow(Window);
				});

				//Support Window Resizing ---------------------------------------------
				if (o.WindowResizable) {
					Window.resizable({
						minHeight: o.WindowMinHeight + 72,
						minWidth: o.WindowMinWidth,
						alsoResize: WindowContent,
						start: function() {
							WindowContainer.css('visibility', 'visible');
							$(".chinaz").find('#iframeHelper').css({
								'display': 'block'
							});
							$(".chinaz").removeClass('active');
							Window.addClass('active');
							if (($('body').data('chinazMaxZIndex')) == null) {
								$('body').data('chinazMaxZIndex', Window.css('z-index'));
							}
							i = $('body').data('chinazMaxZIndex');
							i++;
							Window.css('z-index', i);
							$('body').data('chinazMaxZIndex', Window.css('z-index'));
						},
						stop: function() {
							o.WindowWidth = WindowContent.width();
							o.WindowHeight = WindowContent.height();
							$(".chinaz").find('#iframeHelper').css({
								'display': 'none'
							});
						}
					});
				}
			});
		}
	});
})(jQuery);

/*
 * 替换字符串内的自付
 * obj-原字符串
 * str1-替换规则
 *str2->替换为什么
 */
function replaceAll(obj, str1, str2) {
	var result = obj.replace(eval('/' + str1 + '/gi'), str2);
	return result;
}


/**
 *   Unslider
 */
(function($, f) {
	var Unslider = function() {
		//  Object clone
		var _ = this;

		//  Set some options
		_.o = {
			speed: 500, // animation speed, false for no transition (integer or boolean)
			delay: 3000, // delay between slides, false for no autoplay (integer or boolean)
			init: 0, // init delay, false for no delay (integer or boolean)
			pause: !f, // pause on hover (boolean)
			loop: !f, // infinitely looping (boolean)
			keys: f, // keyboard shortcuts (boolean)
			dots: f, // display ••••o• pagination (boolean)
			arrows: f, // display prev/next arrows (boolean)
			prev: '←', // text or html inside prev button (string)
			next: '→', // same as for prev option
			fluid: f, // is it a percentage width? (boolean)
			complete: f, // invoke after animation (function with argument)
			items: '>ul', // slides container selector
			item: '>li', // slidable items selector
			easing: 'swing' // easing function to use for animation
		};

		_.init = function(el, o) {
			//  Check whether we're passing any options in to Unslider
			_.o = $.extend(_.o, o);

			_.el = el;
			_.ul = el.find(_.o.items);
			_.max = [el.outerWidth() | 0, el.outerHeight() | 0];
			_.li = _.ul.find(_.o.item).each(function(index) {
				var me = $(this),
					width = me.outerWidth(),
					height = me.outerHeight();

				//  Set the max values
				if (width > _.max[0]) _.max[0] = width;
				if (height > _.max[1]) _.max[1] = height;
			});


			//  Cached vars
			var o = _.o,
				ul = _.ul,
				li = _.li,
				len = li.length;

			//  Current indeed
			_.i = 0;

			//  Set the main element
			el.css({
				width: _.max[0],
				height: li.first().outerHeight(),
				overflow: 'hidden'
			});

			//  Set the relative widths
			ul.css({
				position: 'relative',
				left: 0,
				width: (len * 100) + '%'
			});
			li.css({
				'float': 'left',
				width: (100 / len) + '%'
			});

			//  Autoslide
			setTimeout(function() {
				if (o.delay | 0) {
					_.play();

					if (o.pause) {
						el.on('mouseover mouseout', function(e) {
							_.stop();
							e.type == 'mouseout' && _.play();
						});
					};
				};
			}, o.init | 0);

			//  Keypresses
			if (o.keys) {
				$(document).keydown(function(e) {
					var key = e.which;

					if (key == 37)
						_.prev(); // Left
					else if (key == 39)
						_.next(); // Right
					else if (key == 27)
						_.stop(); // Esc
				});
			};

			//  Dot pagination
			o.dots && nav('dot');

			//  Arrows support
			o.arrows && nav('arrow');

			//  Patch for fluid-width sliders. Screw those guys.
			if (o.fluid) {
				$(window).resize(function() {
					_.r && clearTimeout(_.r);

					_.r = setTimeout(function() {
						var styl = {
							height: li.eq(_.i).outerHeight()
						},
							width = el.outerWidth();

						ul.css(styl);
						styl['width'] = Math.min(Math.round((width / el.parent().width()) * 100), 100) + '%';
						el.css(styl);
					}, 50);
				}).resize();
			};

			//  Swipe support
			if ($.event.special['swipe'] || $.Event('swipe')) {
				el.on('swipeleft swiperight swipeLeft swipeRight', function(e) {
					e.type.toLowerCase() == 'swipeleft' ? _.next() : _.prev();
				});
			};

			return _;
		};

		//  Move Unslider to a slide index
		_.to = function(index, callback) {
			var o = _.o,
				el = _.el,
				ul = _.ul,
				li = _.li,
				current = _.i,
				target = li.eq(index);

			//  To slide or not to slide
			if ((!target.length || index < 0) && o.loop == f) return;

			//  Check if it's out of bounds
			if (!target.length) index = 0;
			if (index < 0) index = li.length - 1;
			target = li.eq(index);

			var speed = callback ? 5 : o.speed | 0,
				easing = o.easing,
				obj = {
					height: target.outerHeight()
				};

			if (!ul.queue('fx').length) {
				//  Handle those pesky dots
				el.find('.dot').eq(index).addClass('active').siblings().removeClass('active');

				el.animate(obj, speed, easing) && ul.animate($.extend({
					left: '-' + index + '00%'
				}, obj), speed, easing, function(data) {
					_.i = index;

					$.isFunction(o.complete) && !callback && o.complete(el);
				});
			};
		};

		//  Autoplay functionality
		_.play = function() {
			_.t = setInterval(function() {
				_.to(_.i + 1);
			}, _.o.delay | 0);
		};

		//  Stop autoplay
		_.stop = function() {
			_.t = clearInterval(_.t);
			return _;
		};

		//  Move to previous/next slide
		_.next = function() {
			return _.stop().to(_.i + 1);
		};

		_.prev = function() {
			return _.stop().to(_.i - 1);
		};

		//  Create dots and arrows
		function nav(name, html) {
			if (name == 'dot') {
				html = '<ol class="dots">';
				$.each(_.li, function(index) {
					html += '<li class="' + (index == _.i ? name + ' active' : name) + '">' + ++index + '</li>';
				});
				html += '</ol>';
			} else {
				html = '<div class="';
				html = html + name + 's">' + html + name + ' prev">' + _.o.prev + '</div>' + html + name + ' next">' + _.o.next + '</div></div>';
			};

			_.el.addClass('has-' + name + 's').append(html).find('.' + name).click(function() {
				var me = $(this);
				me.hasClass('dot') ? _.stop().to(me.index()) : me.hasClass('prev') ? _.prev() : _.next();
			});
		};
	};

	//  Create a jQuery plugin
	$.fn.unslider = function(o) {
		var len = this.length;

		//  Enable multiple-slider support
		return this.each(function(index) {
			//  Cache a copy of $(this), so it
			var me = $(this),
				key = 'unslider' + (len > 1 ? '-' + ++index : ''),
				instance = (new Unslider).init(me, o);

			//  Invoke an Unslider instance
			me.data(key, instance).data('key', key);
		});
	};
})(jQuery, false);
/*翻页插件*/
(function($) {
	$.fn.paginate = function(options) {
		var opts = $.extend({}, $.fn.paginate.defaults, options);
		return this.each(function() {
			$this = $(this);
			var o = $.meta ? $.extend({}, opts, $this.data()) : opts;
			var selectedpage = o.start;
			$.fn.draw(o, $this, selectedpage);
		});
	};
	var outsidewidth_tmp = 0;
	var insidewidth = 0;
	var bName = navigator.appName;
	var bVer = navigator.appVersion;
	if (bVer.indexOf('MSIE 7.0') > 0)
		var ver = "ie7";
	$.fn.paginate.defaults = {
		count: 5,
		start: 12,
		display: 5,
		border: true,
		border_color: '#fff',
		text_color: '#8cc59d',
		background_color: 'black',
		border_hover_color: '#fff',
		text_hover_color: '#fff',
		background_hover_color: '#fff',
		rotate: true,
		images: true,
		mouse: 'slide',
		onChange: function() {
			return false;
		}
	};
	$.fn.draw = function(o, obj, selectedpage) {
		if (o.display > o.count)
			o.display = o.count;
		$this.empty();
		if (o.images) {
			var spreviousclass = 'jPag-sprevious-img';
			var previousclass = 'jPag-previous-img';
			var snextclass = 'jPag-snext-img';
			var nextclass = 'jPag-next-img';
		} else {
			var spreviousclass = 'jPag-sprevious';
			var previousclass = 'jPag-previous';
			var snextclass = 'jPag-snext';
			var nextclass = 'jPag-next';
		}
		var _first = $(document.createElement('a')).addClass('jPag-first').html('First');

		if (o.rotate) {
			if (o.images) var _rotleft = $(document.createElement('span')).addClass(spreviousclass);
			else var _rotleft = $(document.createElement('span')).addClass(spreviousclass).html('&laquo;');
		}

		var _divwrapleft = $(document.createElement('div')).addClass('jPag-control-back');
		_divwrapleft.append(_first).append(_rotleft);

		var _ulwrapdiv = $(document.createElement('div')).css('overflow', 'hidden');
		var _ul = $(document.createElement('ul')).addClass('jPag-pages')
		var c = (o.display - 1) / 2;
		var first = selectedpage - c;
		var selobj;
		for (var i = 0; i < o.count; i++) {
			var val = i + 1;
			if (val == selectedpage) {
				var _obj = $(document.createElement('li')).html('<span class="jPag-current">' + val + '</span>');
				selobj = _obj;
				_ul.append(_obj);
			} else {
				var _obj = $(document.createElement('li')).html('<a>' + val + '</a>');
				_ul.append(_obj);
			}
		}
		_ulwrapdiv.append(_ul);

		if (o.rotate) {
			if (o.images) var _rotright = $(document.createElement('span')).addClass(snextclass);
			else var _rotright = $(document.createElement('span')).addClass(snextclass).html('&raquo;');
		}

		var _last = $(document.createElement('a')).addClass('jPag-last').html('Last');
		var _divwrapright = $(document.createElement('div')).addClass('jPag-control-front');
		_divwrapright.append(_rotright).append(_last);

		//append all:
		$this.addClass('jPaginate').append(_divwrapleft).append(_ulwrapdiv).append(_divwrapright);

		if (!o.border) {
			if (o.background_color == 'none') var a_css = {
				'color': o.text_color
			};
			else var a_css = {
				'color': o.text_color,
				'background-color': o.background_color
			};
			if (o.background_hover_color == 'none') var hover_css = {
				'color': o.text_hover_color
			};
			else var hover_css = {
				'color': o.text_hover_color,
				'background-color': o.background_hover_color
			};
		} else {
			if (o.background_color == 'none') var a_css = {
				'color': o.text_color,
				'border': '1px solid ' + o.border_color
			};
			else var a_css = {
				'color': o.text_color,
				'background-color': o.background_color,
				'border': '1px solid ' + o.border_color
			};
			if (o.background_hover_color == 'none') var hover_css = {
				'color': o.text_hover_color,
				'border': '1px solid ' + o.border_hover_color
			};
			else var hover_css = {
				'color': o.text_hover_color,
				'background-color': o.background_hover_color,
				'border': '1px solid ' + o.border_hover_color
			};
		}

		$.fn.applystyle(o, $this, a_css, hover_css, _first, _ul, _ulwrapdiv, _divwrapright);
		//calculate width of the ones displayed:
		var outsidewidth = outsidewidth_tmp - _first.parent().width() - 3;
		if (ver == 'ie7') {
			_ulwrapdiv.css('width', outsidewidth + 72 + 'px');
			_divwrapright.css('left', outsidewidth_tmp + 6 + 72 + 'px');
		} else {
			_ulwrapdiv.css('width', outsidewidth + 'px');
			_divwrapright.css('left', outsidewidth_tmp + 6 + 'px');
		}

		if (o.rotate) {
			_rotright.hover(
				function() {
					thumbs_scroll_interval = setInterval(
						function() {
							var left = _ulwrapdiv.scrollLeft() + 1;
							_ulwrapdiv.scrollLeft(left);
						},
						20
					);
				},
				function() {
					clearInterval(thumbs_scroll_interval);
				}
			);
			_rotleft.hover(
				function() {
					thumbs_scroll_interval = setInterval(
						function() {
							var left = _ulwrapdiv.scrollLeft() - 1;
							_ulwrapdiv.scrollLeft(left);
						},
						20
					);
				},
				function() {
					clearInterval(thumbs_scroll_interval);
				}
			);
			if (o.mouse == 'press') {
				_rotright.mousedown(
					function() {
						thumbs_mouse_interval = setInterval(
							function() {
								var left = _ulwrapdiv.scrollLeft() + 5;
								_ulwrapdiv.scrollLeft(left);
							},
							20
						);
					}
				).mouseup(
					function() {
						clearInterval(thumbs_mouse_interval);
					}
				);
				_rotleft.mousedown(
					function() {
						thumbs_mouse_interval = setInterval(
							function() {
								var left = _ulwrapdiv.scrollLeft() - 5;
								_ulwrapdiv.scrollLeft(left);
							},
							20
						);
					}
				).mouseup(
					function() {
						clearInterval(thumbs_mouse_interval);
					}
				);
			} else {
				_rotleft.click(function(e) {
					var width = outsidewidth - 10;
					var left = _ulwrapdiv.scrollLeft() - width;
					_ulwrapdiv.animate({
						scrollLeft: left + 'px'
					});
				});

				_rotright.click(function(e) {
					var width = outsidewidth - 10;
					var left = _ulwrapdiv.scrollLeft() + width;
					_ulwrapdiv.animate({
						scrollLeft: left + 'px'
					});
				});
			}
		}

		//first and last:
		_first.click(function(e) {
			_ulwrapdiv.animate({
				scrollLeft: '0px'
			});
			_ulwrapdiv.find('li').eq(0).click();
		});
		_last.click(function(e) {
			_ulwrapdiv.animate({
				scrollLeft: insidewidth + 'px'
			});
			_ulwrapdiv.find('li').eq(o.count - 1).click();
		});

		//click a page
		_ulwrapdiv.find('li').click(function(e) {
			selobj.html('<a>' + selobj.find('.jPag-current').html() + '</a>');
			var currval = $(this).find('a').html();
			$(this).html('<span class="jPag-current">' + currval + '</span>');
			selobj = $(this);
			$.fn.applystyle(o, $(this).parent().parent().parent(), a_css, hover_css, _first, _ul, _ulwrapdiv, _divwrapright);
			var left = (this.offsetLeft) / 2;
			var left2 = _ulwrapdiv.scrollLeft() + left;
			var tmp = left - (outsidewidth / 2);
			if (ver == 'ie7')
				_ulwrapdiv.animate({
					scrollLeft: left + tmp - _first.parent().width() + 52 + 'px'
				});
			else
				_ulwrapdiv.animate({
					scrollLeft: left + tmp - _first.parent().width() + 'px'
				});
			o.onChange(currval);
		});

		var last = _ulwrapdiv.find('li').eq(o.start - 1);
		last.attr('id', 'tmp');
		var left = document.getElementById('tmp').offsetLeft / 2;
		last.removeAttr('id');
		var tmp = left - (outsidewidth / 2);
		if (ver == 'ie7') _ulwrapdiv.animate({
			scrollLeft: left + tmp - _first.parent().width() + 52 + 'px'
		});
		else _ulwrapdiv.animate({
			scrollLeft: left + tmp - _first.parent().width() + 'px'
		});
	}

	$.fn.applystyle = function(o, obj, a_css, hover_css, _first, _ul, _ulwrapdiv, _divwrapright) {
		obj.find('a').css(a_css);
		obj.find('span.jPag-current').css(hover_css);
		obj.find('a').hover(
			function() {
				$(this).css(hover_css);
			},
			function() {
				$(this).css(a_css);
			}
		);
		obj.css('padding-left', _first.parent().width() + 5 + 'px');
		insidewidth = 0;

		obj.find('li').each(function(i, n) {
			if (i == (o.display - 1)) {
				outsidewidth_tmp = this.offsetLeft + this.offsetWidth;
			}
			insidewidth += this.offsetWidth;
		})
		_ul.css('width', insidewidth + 'px');
	}
})(jQuery);



var csrqAndSex = ''; //出生日期与性别组合
function validateIdCard(value) {
	if (typeof value == 'undefined' || !value || value == '') {
		return "身份证号码为空!";
	}
	if (value.length != 15 && value.length != 18) {
		return '身份证号码长度应该为15位或者18位!';
	}
	var patten1 = "^\\d{15}$";
	var patten2 = "^\\d{17}[0123456789Xx]$";
	if (!new RegExp(patten1, "g").test(value) && !new RegExp(patten2, "g").test(value)) {
		return '身份证号码只能包含数字和X';
	}
	var id18 = change15to18(value);
	var csrqstr = id18.substr(6, 8);
	var year = parseInt(csrqstr.substr(0, 4), 10);
	var month = parseInt(csrqstr.substr(4, 2), 10) - 1;
	var date = parseInt(csrqstr.substr(6, 2), 10);
	var csrq = new Date(year, month, date);
	if (year != csrq.getFullYear() || month != csrq.getMonth() || date != csrq.getDate()) {
		return '身份证中的出生日期[' + csrqstr + ']非法!';
	}
	if (value != id18) {
		return "身份证不正确，正确的身份证号码为:[" + id18 + "]";
	}
	var sexInt = parseInt(id18.substr(16, 1));
	if (sexInt % 2 == 0)
		csrqAndSex = 2;
	else
		csrqAndSex = 1;
	//获取出生日期
	var sCsrq = csrq.getFullYear();
	if ((csrq.getMonth() + 1) < 10)
		sCsrq += '-0' + (csrq.getMonth() + 1);
	else
		sCsrq += '-' + (csrq.getMonth() + 1);
	if (date < 10)
		sCsrq += '-0' + csrq.getDate();
	else
		sCsrq += '-' + csrq.getDate();
	csrqAndSex += ',' + sCsrq;
	return true;
}
//身份证号15位转18位
function change15to18(idcard) {
	var arrInt = new Array(7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2);
	var arrCh = new Array('1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2');
	var sum = 0;

	if (idcard.length != 15 && idcard.length != 18) {
		return idcard;
	}

	if (idcard.length == 15) {
		idcard = idcard.substr(0, 6) + '19' + idcard.substr(6, idcard.length - 6);
	} else {
		idcard = idcard.substr(0, 17);
	}

	for (var i = 0; i < idcard.length; i++) {
		sum += idcard.substr(i, 1) * arrInt[i];
	}

	idcard += arrCh[sum % 11];

	return idcard;
}
//校验输入框中输入特殊字符 
function doVidateTszf(e) {
	var keynum;
	if (window.event) // IE
	{
		keynum = e.keyCode;
	} else if (e.which) // Netscape/Firefox/Opera
	{
		keynum = e.which;
	}
	var keychar = String.fromCharCode(keynum);
	var numcheck = new RegExp("[ ,\\`,\\~,\\!,\\@,\#,\\$,\\%,\\^,\\+,\\*,\\&,\\\\,\\/,\\?,\\|,\\:,\\.,\\<,\\>,\\[,\\],\\{,\\},\\(,\\),\\',\\;,\\=,\"]");
	return !numcheck.test(keychar);
}



/*创建色块  setGDT(o,n,css)*/
function bulidTxtBox(o, num, W, H) {
	$(o).wrap('<div  class="ui-txtbox ui-block-' + num + '"></div>');
	$(o).after('<div class="box-cover"></div>')
	var obj = $(o).closest('div');
	$(o).css({
		'background': 'transparent',
		'border': 'medium none',
		'overflow': 'auto',
		'position': 'relative',
		'z-index': '30',
		'padding': '5px',
		'width': (W - 10) + 'px',
		'height': (H - 10) + 'px'
	});
	var w = $(o).width(),
		h = $(o).height(),
		p = parseInt($(o).css('padding'));
	obj.css({
		'width': W + 'px',
		'height': H + 'px',
		'overflow': 'hidden'
	})
		.find('.box-cover')
		.css({
			'width': W + 'px',
			'height': H + 'px',
			'margin-top': -(h + 5 * 2) + 'px',
			'background': '#000',
			'display': 'none',
			'position': 'relative',
			'z-index': '20'
		});
	zzDis(o, 1);
	var obj = $(o).closest('div');
	hoverBox(o);
}
/*目标对象的鼠标Hover事件*/
function hoverBox(o) {
	var obj = $(o).closest('div');
	obj.mouseenter(function() {
		zzDis(o, 0);
	});
	obj.mouseleave(function() {
		zzDis(o, 1);
	});
}
/*遮罩层的显隐控制*/
function zzDis(o, style) {
	var obj = $(o).closest('div').find('.box-cover');
	var w = $(o).width(),
		h = $(o).height();
	if (style == '1') {
		obj.stop().fadeTo(2500, 0.20);
		$(o).css({
			'color': '#fff'
		});
	} else if (style == '0') {
		obj.stop().fadeTo(800, 0);
		$(o).css({
			'color': '#000'
		});
	}
}
/*转变色板颜色*/
function shiftBoxSkip(o, num) {
	var obj = $(o).closest('div');
	var c = obj.attr('class').substring(10);
	obj.removeClass(c).addClass('ui-block-' + num);
}


/*******************************select多选框*********************************/
function bulidSelect(o, json, num, w, h) {

	if (w == '' || typeof(w) == 'undefined') {
		w = '200';
	}
	if (h == '' || typeof(h) == 'undefined') {
		h = '25';
	}

	$(o).attr('value', num);
	var str_input = '<table class="input" cellpadding="0" cellspacing="0">' +
		'<tr class="ui-block-1">' +
		'<td ><input class="inputSel inputTM"  readonly="readonly"/></td>' +
		'<td class="arrSel"></td>' +
		'</tr>' +
		'<tr><td><div class="list"> </div> </td></tr>' +
		' </table> ';
	var str_list = '';
	$(o).append(str_input + str_list);
	$(o).addClass('haveblock');
	haveBlock('listHide1'); /*空白关闭*/
	$(o).find('.inputSel').css({
		'width': (w - 25) + 'px',
		'height': h + 'px',
		'line-height': h + 'px'
	});


	setSelectJson(o, json); /*传值*/


	if (num != '' || typeof(num) != 'undefined') {
		changeSelectColor(o, num);
	} else {
		$(o).css({
			'border': 'solid 1px #f00;'
		});
	}
	selectbtn(o, 8); //设置按钮



	var lh = $(o).find('.list').height();
	str_iframe = "<iframe class='SIframe' scrolling='no' frameborder='0' scrolling='no'   ></iframe>";
	$(o).find('.list').after(str_iframe);
	$(o).find('.SIframe').css({
		'width': w + 'px',
		'height': lh + 'px',
		'margin-top': 0 + 'px',
		'position': 'absolute',
		'z-index': '10'
	}).hide();
	$(o).find('.list').hide();
}
/*对list进行样式特效加载*/
function bulidList(o) {
	$(o).find('.list').find('table tr')
		.hover(
			function() {
				$(this).addClass('ui-block-1');
			},
			function() {
				$(this).removeClass('ui-block-1');
			})
		.find('td:eq(1)').click(function() {
			checkClick(o, this);
		});
	if ($.browser.version == 8) {
		setGDT('.list', '', 'blue');
	} else {
		$(o).find('.list').css({
			'overflow-x': 'hidden',
			'overflow-y': 'auto',
			'height': '200px'
		});
	}

}
/*select下拉按钮部分*/
function selectbtn(o, style) {
	$(o).find('.arrSel')
		.css({
			'width': '25px',
			'height': '25px'
		})
		.append('<div class="down"  onmousedown="selectClick(this)"  ></div><div class="up" onmousedown="selectClick(this)"  ></div>');
	mouseHover2(o + ' .down', style, 86, '点击展开下拉框', 1);
	mouseHover2(o + ' .up', style, 87, '点击收回下拉框', 1);
	$(o + ' .up').hide();
}
/*选中指定目标
 * o->目标select对象
 * n->行序列号
 * */
function selectChecked(o, n) {
	var obj_tr = $(o).find('.list').find('table tr')
	if (obj_tr.length > n) {
		var obj_input = obj_tr.eq(n).find('td:eq(0)').find('input');
		if (obj_input.attr('checked') == 'checked') {
			obj_input.attr('checked', false);
		} else {
			obj_input.attr('checked', true);
		}
		refreshInput(o);
	}

}

/*select配套使用*/
function checkClick(obj, obj_this) {
	var n = $(obj_this).closest('tr').index();
	selectChecked(obj, n);
	if (typeof(selectCheckBox) != 'undefined') {
		eval(selectCheckBox)(obj_this);
	}
}
/*刷新input框内值*/
function refreshInput(o) {
	var str_all = '',
		num = $(o).find('input:checked').length;
	if (num > 0) {
		str_all = $(o).find('input:checked').eq(0).closest('tr').find('.ctxt').text();
		for (var i = 1; i < num; i++) {
			str_all += ',' + $(o).find('input:checked').eq(i).closest('tr').find('.ctxt').text();
		}
	} else { /*当前值为空*/ }

	$(o).find('.inputSel').val(str_all);
}
/*获得所选项目的value值--总*/
function getSelectValue(o) {
	var str_all = '',
		num = $(o).find('input:checked').length;
	if (num > 0) {
		str_all = $(o).find('input:checked').eq(0).val();
		for (var i = 1; i < num; i++) {
			str_all += ',' + $(o).find('input:checked').eq(i).val();
		}
	} else { /*当前值为空*/ }
	return str_all;
}
/*空白隐藏*/
function listHide1() {
	$('.list').hide();
	$('.SIframe').hide();
	$('.down').show();
	$('.up').hide();
}
/*下拉框的展开与收缩*/
function selectClick(o) {
	var obj_all = $(o).closest('table').closest('div');
	var enable = obj_all.val();
	if (enable != '13' && enable != '10') {
		var obj = $(o).closest('table').closest('div').find('.list');
		if (obj.css('display') == 'none') {
			obj.show();
			$(o).closest('table').closest('div').find('.SIframe').show();
			$('.up').show();
			$('.down').hide();
		} else if (obj.css('display') == 'block') {
			obj.hide();
			$(o).closest('table').closest('div').find('.SIframe').hide();
			$('.down').show();
			$('.up').hide();
		}
	}
}

/*批量选择，按json.value*/
function setSelectValue(o, arr) {
	var str = arr.split(",");
	for (var i = 0; i < str.length; i++) {
		var obj = $(o).find('.list').find('input[value="' + str[i] + '"]');

		obj.each(function(event) {
			selectChecked(o, $(this).closest('tr').index());
		});
	}
}
/*向目标内传json*/
function setSelectJson(o, j) {
	var jStr = (new Function('return' + j))();
	var str_tr = '';
	for (var i = 0; i < jStr.length; i++) {
		str_tr += '<tr><td class="cbox"> <input type="checkbox" id="l-' + i + '" value="' + jStr[i].value + '"  name="' + o.substring(1) + '" onclick="refreshInput(\'' + o + '\')"  /> </td><td  id="txt-' + i + '" class="ctxt" >' + jStr[i].text + '</td></tr>';
	}
	$(o).find('.list').empty()
		.append('<table cellpadding="0" cellspacing="0">' + str_tr + '</table>');

	$(o).find('.list table').css({
		'width': $(o).width() + 'px'
	}).find('.cbox').css({
		'width': '25px',
		'height': '25px'
	});
	$(o).find('.list table input').css({
		'vertical-align': 'middle',
		'margin-left': '5px'
	});
	var w = $(o).find('.inputSel').width();
	$(o).find('.list').css({
		'width': w + 25 + 'px',
		'max-height': '200px',
		'position': 'absolute',
		'overflow': 'auto',
		'background': '#f5f5f5',
		'font-size': '12px',
		'z-index': '20',
		'cursor': 'pointer',
		'margin-top': '2px',
		'border': 'solid 1px #bbbbbb'
	}).find('table').css({
		'width': w + 'px'
	});


	bulidList(o);
}



/*对目标select可编辑进行控制*/
function selectAble(o, style) {
	$(o).val(style);
	if (style != '13' && style != '10') {
		$(o).find('.inputSel').attr('disabled', false);
		changeSelectColor(o, style);
	} else if (style == '13' || style == '13') {
		$(o).find('.inputSel').attr('disabled', true);
		changeSelectColor(o, style);
	}

}
/*对select的颜色控制*/
function changeSelectColor(o, num) {
	var obj = $(o).find('.input tr:eq(0)');
	obj.removeClass().addClass('ui-block-' + num);
}
/******************************************Select 单选型************************************/
/*创建单选select
 * o->目标对象
 * json->json对象
 * w->宽
 * h->高
 * css1->input框样式
 * css2->下拉列表样式
 * */
function bulidSelect2(o, json, w, h, css1, css2) {
	var str_tr = "<tr><td ><input /></td>   <td><div class='up'></div><div class='down'></div></td></tr>";
	var str_table = '<table class="input"  cellpadding="0" cellspacing="0">' + str_tr + '</table>';
	$(o).append(str_table);
	if (w == '' || typeof(w) == 'undefined') {
		w = '200';
	}
	if (h == '' || typeof(h) == 'undefined') {
		h = '25';
	}
	if (css1 == '' || typeof(css1) == 'undefined') {
		css1 = '1';
	}
	if (css2 == '' || typeof(css2) == 'undefined') {
		css2 = '4';
	}
	setStyle(o, w, h, css1);
	bulidList2(o, json, w, css2); //创建样式并确定内容
	haveBlock('listHide2');

	str_iframe = "<iframe class='SIframe' scrolling='no' frameborder='0' scrolling='no'   ></iframe>";
	$(o).find('.list').after(str_iframe);
	$(o).find('.SIframe').css({
		'width': w + 'px',
		'height': '0px',
		'margin-top': 0 + 'px',
		'position': 'absolute',
		'z-index': '10'
	}).hide();


}
/*样式建立*/
function setStyle(o, w, h, css1, css2) {
	$(o).css({
		'width': w + 'px',
		'height': h + 'px'
	}).addClass('haveblock');
	mouseHover2(o + ' .up', 8, 86, '展开', 1);
	mouseHover2(o + ' .down', 8, 87, '收缩', 1);
	$(o + ' .down').hide();
	$(o).find('.input tr').addClass('ui-block-' + css1).find('input').addClass('inputTM').css({
		'width': (w - 25) + 'px',
		'height': h + 'px',
		'line-height': h + 'px'
	});
}
/*创建下拉列表*/
function bulidList2(o, json, w, css2) {
	$(o + ' .input').append('<tr><td colspan="2"><div class="list"></div></td></tr>');
	$(o).find('.list').css({
		'width': w + 'px',
		'max-height': 200 + 'px',
		'overflow': 'auto'
	}).addClass('ui-block-' + css2);
	setSelectJson2(o, json);
	$(o).find('.input tr:eq(0) td:eq(1)').click(function() {
		if ($(o).find('.list').css('display') == 'none') {
			listDisplay2(o, 1);
		} else {
			listDisplay2(o, 0);
		}
	});
}
/*传值*/
function setSelectJson2(o, j) {
	var obj = $(o + ' .list');
	var jStr = (new Function('return' + j))();
	var str_li = '';
	for (var i = 0; i < jStr.length; i++) {
		str_li += '<li>' + jStr[i].text + '</li>';
	}
	var str_ul = '<ul class="list-ul">' + str_li + '</ul>'
	obj.empty();
	obj.append(str_ul);
	obj.css({
		'position': 'relative',
		'z-index': '110'
	});
	obj.find('.list-ul').addClass('ul-format-1').css({
		'margin': '0px;'
	}).find('li').css({
		'height': '20px',
		'cursor': 'pointer',
		'padding-left': '8px'
	}).hover(
		function() {
			$(this).addClass('ui-block-7');
		},
		function() {
			$(this).removeClass('ui-block-7');
		}
	).click(function() {
		var s = $(this).text();
		$(o).find('input').val(s);
	}).attr('title', '123');
	setGDT(o + ' .list', '', 'drak-2');
	$(o).find('.list').hide();
}
/*收缩*/
function listHide2() {
	listDisplay2('#select', 0);
}
/*确定展开收缩*/
function listDisplay2(o, style) {
	if (style == '1') {
		$(o).find('.list , .down').show();
		$(o).find('.up').hide();
		iframeDisplay(o, style);
	} else if (style == '0') {
		$(o).find('.list , .down').hide();
		$(o).find('.up').show();
		iframeDisplay(o, style);
	}
}
/*获取当前值*/
function getSelectValue2(o) {
	return $(o).find('input').val();
}

function iframeDisplay(o, style) {
	var obj = $(o).find('.SIframe');
	var h = $(o).find('.list').height();

	if (style == '1') {
		obj.css({
			'height': (h + 2) + 'px',
			'display': 'block',
			'margin-top': (0 - h) + 'px',
			'z-index': '100'
		});
	} else if (style == '0') {
		obj.hide();
	}

}


/*********************************************滑动按钮*/
function setPButton(o, num, on, off) {
	$(o).addClass('p-btnbg-' + num).append("<ul class='moveBtn-" + num + "'> <li ><div >" + on + "</div></li> <li><div class='p-btn-" + num + "' ></div></li> <li><div>" + off + "</div></li> </ul>");
	$('.p-btn-' + num).attr('onmousedown', 'pBtnDown(this)');
	$(o).find('ul').css({
		'width': ($(o).find('ul li').length * $(o).find('ul li').width() + 5) + 'px',
		'height': $(o).find('ul li').height() + 'px',
		'color': '#505050'
	});
}

function pBtnDown(o) {
	var obj = $(o).closest('ul');
	var ml = parseInt(obj.css('margin-left'));
	if (ml >= 0) {
		changePbtn(o, 'l');
	} else if (ml < 0) {
		changePbtn(o, 'r');
	}
}

function changePbtn(o, style) {
	var obj = $(o).closest('ul');
	var w = $(o).closest('li').width(),
		gotoml;

	if (style == 'r') {
		gotoml = 0;
	} else if (style == 'l') {
		gotoml = 0 - w;
	}
	$(o).closest('ul').stop().animate({
		'margin-left': gotoml + 'px'
	}, 500, '');
}

/**********建议添加型活动标签*******************/
/*
 * o->目标对象
 * num->样式编号
 * txt->显示内容
 * val->添加的value值
 * id->需要传递的关联特征
 * */
function bulidStripe(o, num, txt, val, id) {
	var str_table = '<table cellpadding="0" cellspacing="0"  class="stripe-box" value="' + id + '"><tr><td  value="' + val + '">' + txt + '</td><td><div class="ui-close-1"   onclick="stripeRemove(this)"></div></td></tr></table>';
	$(o).append(str_table);
	$(o).find('.stripe-box').addClass('ui-block-' + num)
		.css({
			'height': '20',
			'font-size': '12px',
			'margin-left': '2px',
			'display': 'inline'
		})
		.find('td').css({
			'padding': '2px 5px 2px 5px'
		});
	$(o).find('table').hover(
		function() {
			$(this).removeClass('ui-block-' + num).addClass('ui-block-2');
		},
		function() {
			$(this).addClass('ui-block-' + num).removeClass('ui-block-2');
		});
}

function bulidStripe2(o, num, txt, val, id) {
	var str_table = '<table cellpadding="0" cellspacing="0" class="stripe-nr"  ><tr><td  value="' + val + '">' + txt + '</td><td><div class="ui-close-1" onclick="stripeRemove(this)"></div></td></tr></table>';
	var str_box = " <table cellpadding='0' cellspacing='0' class='stripe-box' value='" + id + "' > <tr> <td class='ui-stripe-l-f stripe '></td> <td class='ui-stripe-m-f  stripe '>" + str_table + "</td> <td class='ui-stripe-r-f  stripe'  ></td> </tr>  </table>";
	$(o).append(str_box);
	$(o).find('.stripe-box')
		.css({
			'height': '22',
			'font-size': '12px',
			'margin-left': '0px',
			'display': 'inline'
		})
		.find('.stripe-nr td').css({
			'padding': '2px 5px 2px 5px'
		});
	$(o).find('.stripe').addClass('ui-stripe-' + num);

	$(o).find('.stripe-box').hover(
		function() {
			$(this).find('.stripe').removeClass('ui-stripe-' + num).addClass('ui-stripe-2');
			$(this).find('.ui-close-1').show();
		},
		function() {
			$(this).find('.stripe').addClass('ui-stripe-' + num).removeClass('ui-stripe-2');
			$(this).find('.ui-close-1').hide();
		});
	$(o).find('.ui-close-1').hide();
}


/*磁贴的移除方法，预留函数参数会当前磁贴对象*/
function stripeRemove(o) {
	var obj = $(o).closest('.stripe-box');
	obj.remove();
	if (typeof(stripeClose) != 'undefined') {
		eval(stripeClose)(obj);
	}
}

function getStripe(o, style) {
	var n = $(o).find('table').length;
	var str = '';
	for (var i = 0; i < n; i++) {
		if (style == 'val') {
			str += $(o).find('table').eq(i).find('tr td').eq(0).attr('value') + ',';
		} else if (style == 'text') {
			str += $(o).find('table').eq(i).find('tr td').eq(0).text() + ',';
		}
	}
	return str;
}


/******************评价星星样式1*****************************/
/*创建样式1*/
function bulidPoint(o, n, out, over, on) {
	var str_li = '';
	for (var i = 0; i < n; i++) {
		str_li += "<li class='icon-format-11 icon-11 icon-11-i" + out + "' value='1'></li>";
	}
	var str_ul = '<ul class="ul-format-1">' + str_li + '</ul>'
	$(o).append(str_ul);
	$(o).find('li').css({
		'width': '20px',
		'height': '20px',
		'margin-left': '5px',
		'float': 'left'
	});
	$(o).find('ul').css({
		'width': $(o).find('li').width() * ($(o).find('li').length + 5) + 10 + 'px',
		'height': $(o).find('li').height() + 5 + 'px',
		'overflow': 'hidden',
		'margin': '0px'
	});
	$(o).css({
		'width': $(o).find('li').width() * $(o).find('li').length + 'px',
		'overflow': 'hidden'
	});
	pointHover(o, out, over, on);
}
/*样式1的hover*/
function pointHover(o, out, over, on) {
	$(o).find('li').hover(function() {
		choosePoint(o, $(this).index(), 1, over, over);
	}, function() {
		$(o).find('li').removeClass('icon-11-i' + over);
	});

	$(o).find('li').mousedown(function() {
		var num = $(this).index();
		choosePoint(o, num, out, over, on);
		setPoint(o, num)
	});
}
/*指定样式*/
function choosePoint(o, n, out, over, on) {
	var obj = $(o).find('li').eq(n);
	obj.prevAll('li').removeClass('icon-11-i' + out).removeClass('icon-11-i' + over).addClass('icon-11-i' + on);
	obj.removeClass('icon-11-i' + out).removeClass('icon-11-i' + over).addClass('icon-11-i' + on);
	obj.nextAll().addClass('icon-11-i' + out).removeClass('icon-11-i' + over).removeClass('icon-11-i' + on);
}
/*指定分数*/
function setPoint(o, n) {
	var obj = $(o).find('li').eq(n);
	obj.prevAll('li').attr('value', '2');
	obj.attr('value', '2')
	obj.nextAll().attr('value', '1');
}
/*获取分数*/
function getPoint(o) {
	var n = $(o).find('li[value=2]').length;
	return n;
}
/*******评价星星样式2************/

/*评价 星星样式2*/
function bulidPoint2(o, n, style, c) {

	var str_li = '';
	for (var i = 0; i < n; i++) {
		str_li += '<li class="icon-star-2" ></li>';
	}
	$(o).append('<ul>' + str_li + '</ul>');
	$(o).find('ul').addClass('ul-format-1').css({
		'width': $(o).find('li').width() * $(o).find('li').length + 'px',
		'height': $(o).find('li').height() + 'px',
		'overflow': 'hidden',
		'margin': '0px',
		'position': 'absolute',
		'z-index': '10'
	}).find('li')
		.css({
			'float': 'left'
		});
	setPointToggle(o);
	$(o).append('<div id="move"></div>').find('#move').css({
		'height': $(o).find('li').height() + 'px'
	})
		.addClass('apple-tm-out').addClass('ui-block-t' + style);
	$(o).css({
		'background': '#dfdfdf',
		'width': $(o).find('li').width() * $(o).find('li').length + 'px',
		'overflow': 'hidden'
	});

	setPoint2(o, c);
}
/*指定分数*/
function setPoint2(o, n) {
	var obj = $(o).find('move'),
		num = $(o).find('li').size(),
		li_w = $(o).find('li').width();
	if (n <= num && n >= 0) {
		if (n % parseInt(n) != 0 && n != 0) {
			n = parseInt(n) + 0.5;
		}
		var gotoW = n * li_w;

		$(o).find('#move').stop().animate({
			'width': gotoW + 'px'
		}, 300);
	}
}
/*对指定目标取消点击事件*/
function disPoint2(o) {
	$(o).find('li').unbind();
}
/*对指定目标创建toggle事件*/
function setPointToggle(o) {
	$(o).find('li').toggle(
		function() {
			pointMoveAction(o, $(this).index(), true);
		},
		function() {
			pointMoveAction(o, $(this).index(), '');
		});
}
/*获取指定目标 2号样式的返回结果*/
function getPoint2(o) {
	return parseInt($(o).find('#move').width() * 10 / $(o).find('ul li').width()) / 10;
}
/*2号样式，进行指针移动*/
function pointMoveAction(o, n, b) {
	var w = (n + 1) * 26;
	if (b == true) {
		w -= 13;
	}
	$(o).find('#move').stop().animate({
		'width': w + 'px'
	}, 1000, 'easeOutBounce');
}
/*************************对fullCld控件进行功能性扩展************************************/
/*对指定颜色的选项进行确认阴影的添加与取消
 * style颜色类名
 * */
function fullCldCheckDate(id, style, dis) {

	var w = $(id).find('.ui-widget-content').width(),
		h = $(id).find('.ui-widget-content').height();
	$(id).find('.fc-event-skin-' + style).each(function() {
		var t = parseInt($(this).css('top')),
			l = parseInt($(this).css('left'));
		var x = parseInt(l / w),
			y = parseInt(t / h);

		var obj = $(id).find('.fc-border-separate').find('tr').eq(y + 1).find('td').eq(x).find('.icon-shadow');
		if (dis == 'block') {
			obj.show();
		} else if (dis == 'none') {
			obj.hide();
		}
	});
}
/*创建下拉栏按钮
 *num-样式编号
 *foo 点击事件
 *gotoT 下拉到位置
 *style1-下拉动画样式
 *style2-上拉动画样式
 */
function bulidPush(o, num, foo, gotoT, style1, style2) {
	var w = $(o).width();

	var str = "<td><div class='ui-push-l-" + num + "' style='height:20px'></div></td>" +
		"<td onmousedown='" + foo + "(this)'><div class='ui-push-m-" + num + " ui-push-m'  style='width:105px;height:30px'></div></td>" +
		"<td><div class='ui-push-r-" + num + "' style='height:20px'></div></td>";
	$(o).append('<table cellpadding="0" cellspacing="0" class="pushBtn" ><tr>' + str + '</tr></table>');
	$(o).find('.pushBtn td').css({
		'vertical-align': 'top'
	});
	for (var i = 0; i < 3; i++) {
		if (i != 1) {
			$(o).find('.pushBtn tr td').eq(i).css({
				'width': (w - $(o).find('.ui-push-m').width()) / 2 + 'px'
			});
		}
	}

	if (style1 == '' || typeof(style1) == 'undefined') {
		style1 = 'easeOutBounce';
	}
	if (style2 == '' || typeof(style2) == 'undefined') {
		style2 = 'easeInQuart';
	}
	$(o).toggle(
		function() {
			movePush(o, gotoT, style1);
		},
		function() {
			movePush(o, 0, style2);
		}
	);
}
/*下拉动画*/
function movePush(o, gotoT, style) {
	if (typeof(easMove) != 'undefined') {
		var style = eval(easMove)();
	}
	$(o).stop().animate({
		'margin-top': gotoT + 'px'
	}, 1000, style);
}

/************************
 * 仿苹果样式制作的意见表格
 * o->目标对象
 * style-样式编号
 * str->要插入的内容
 * w->整体宽度
 * 内容请根据情况联合cssCenter(o,styleL,styleT);使用
 * ********************/
function bulidYjb(o, style, str, w) {
	var str_td_l = "<td><div class='ui-yjb-" + style + " ui-yjb-l-" + style + "'></div></td>";
	var str_td_m = "<td class='ui-yjb-m-" + style + "' > " + str + " </td>";
	var str_td_r = "<td><div class='ui-yjb-" + style + " ui-yjb-r-" + style + "'></div></td>";
	var str_table = '<table cellpadding="0" cellspacing="0"><tr>' + str_td_l + str_td_m + str_td_r + '</tr></table>';

	$(o).append(str_table).css({
		'width': w + 'px'
	});
	var wm = w - (2 * $('.ui-yjb-' + style).width());
	$(o).find('.ui-yjb-m-' + style).css({
		'width': wm + 'px'
	});
}

/***************************第三版时间轴***********************************/
/*创建时间轴框架 
 * o->目标对象
 * j->json
 * num->显示几个
 * */
function bulidTimeLine(o, j, num) {
	if (num == '' || typeof(num) == 'undefined') {
		num = 6;
	}
	$(o).attr('value', num);
	var str_all = '',
		str_pre = '',
		str_line = '',
		str_min = '';
	str_pre = "<div class='preBox' style='width:" + 60 * num + "px;' >  " +
		"<table class='time-move' cellpadding='0' cellspacing='0'>" +
		"<tr class='r-txt'> </tr> <tr class='r-pic'> </tr>" +
		"</table> </div>";
	str_line = "<div class='time-bgline'></div>";
	str_min = " <div class='miniBox'    >" +
		"<table class='map-min' cellpadding='0' cellspacing='0' ><tr style='border-collapse: collapse;'></tr></table>" +
		"<div  class='p-hand '></div>" +
		"</div> ";
	str_input = "<input class='time-register'   />"
	str_all = "  <div class='time-box'  style='width:" + 60 * num + "px;'>" + str_pre + str_line + str_min + str_input + "</div>";
	$(o).append(str_all);

	setTimeJson(o, j);

}
/*对指定目标对象的时间轴进行初始化*/
function timeEmpty(o) {
	$(o).find('.time-move .r-txt').empty();
	$(o).find('.time-move .r-pic').empty();
	$(o).find('.map-min tr').eq(0).empty();
	$(o).find('.time-register').val('');
	timeLineMove(o, '', 0);
}

/*加载时间参数
 * o->目标对象
 * j->json
 * */
function setTimeJson(o, j) {
	timeEmpty(o);
	var str_p = '',
		str_t = '',
		str_map = '',
		json = changeJsonToStr(j),
		num = $(o).attr('value'),
		a, b;
	for (var i = 0; i < json.length; i++) {
		str_t += '<td ><div class="r-font">' + json[i].value + '</div></td>';
		str_p += '<td  ><div    class="r-points " value="' + json[i].value + '" title="' + json[i].text + '"> </div></td>';
		a = parseInt(i / num) * num;
		b = num * (parseInt(i / num) + 1) - 1;
		if (b > json.length) {
			b = json.length - 1;
		}
		str_map += '<td    class=" date-' + json[i].value + '  " title="' + json[a].value + '~' + json[b].value + '"  >●</td>';
	}
	$(o).find('.time-move .r-txt').append(str_t);
	$(o).find('.time-move .r-pic').append(str_p);
	$(o).find('.map-min tr').eq(0).append(str_map);
	$(o).find('.r-points').attr('onclick', 'choosePoint("' + o + '", this)'); //圆点点击事件加载
	$(o).find('.map-min tr').eq(0).find('td').attr('onclick', 'chooseHand("' + o + '",this)'); //缩略图点击事件加载 
	$(o).find('.map-min   td').css({
		'width': parseInt($(o).find('.time-box').width() / json.length) + 'px'
	});
	$(o).find('.p-hand').css({
		'width': parseInt($(o).find('.time-box').width() / json.length) * num + 'px'
	});

	setTimeSkip(o);
}


/*点击圆点 加载预留方法
 * obj->目标对象
 * o->当前点击对象this
 * */
function choosePoint(obj, o) {
	var t = $(o).attr('value');
	chooseTime(obj, t);
	if (typeof(gotoTime) != 'undefined') {
		eval(gotoTime)(o);
	}
}

/*点击缩略图 点击缩略图
 * obj->目标对象
 * o->当前点击对象this
 * */
function chooseHand(obj, o) {
	var n = $(o).index(),
		num = $(obj).attr('value');
	pageSize = parseInt(n / (num));
	timeLineMove(obj, '', pageSize);
}
/*选择时间点
 * o->目标对象
 * t->指定时间
 * */
function chooseTime(o, t) {
	var obj = $(o).find('.map-min .date-' + t),
		l = $(o).find('.map-min td').size(),
		n = obj.index(),
		num = $(o).attr('value');
	pageSize = parseInt(n / num);
	$(o).find('.time-register').val(t);
	changeMiniMap(o, n);
	/*根据所选时间确定目标在第几组后进行滑动翻页*/
	timeLineMove(o, '', pageSize);
}
/*改变缩略图
 * o->目标对象
 * n->缩略图目标序列号
 * */
function changeMiniMap(o, n) {
	$(o).find('.map-min td').removeClass('map-min-in').eq(n).addClass('map-min-in');
}
/*时间轴的移动事件
 * o->目标对象
 * arr->方向  r-right l-left 为空按pageSize进行翻页
 * pageSize->向arr方向翻多少页，若arr为空，则翻到第几页
 * */
function timeLineMove(o, arr, pageSize) {
	var w = $(o).find('.time-move  .r-font').width(),
		num = $(o).attr('value');
	ml = parseInt($(o).find('.preBox  .time-move').css('margin-Left')),
	hand_w = parseInt($(o).find('.p-hand').width()),
	hand_ml = parseInt($(o).find('.p-hand').css('margin-Left'));
	//根据arr来判断移动方式       
	if (arr == 'r') {
		ml -= w * num * pageSize;
		hand_ml += hand_w * pageSize;
	} else if (arr == 'l') {
		ml += w * num * pageSize;
		hand_ml -= hand_w * pageSize;
	} else if (arr == '') {
		ml = -w * num * pageSize;
		hand_ml = hand_w * pageSize;
	}
	//当左端到顶，不能继续向左移动
	if (ml > 0) {
		ml = 0;
	}
	if (hand_ml < 0) {
		hand_ml = 0;
	}
	//当右边无数据，不能继续向右移动

	if ($(o).find('.time-move').width() + ml > 0) {
		$(o).find('.time-move:not(:animated)').animate({
			'margin-left': ml + 'px'
		}, 1000);
	}
	if (hand_ml < $(o).find('.map-min').width()) {
		$(o).find('.p-hand:not(:animated)').animate({
			'margin-left': hand_ml + 'px'
		}, 1000, 'easeOutExpo');
	}


}
/*时间获取*/
function getTimer(o) {
	return $(o).find('.time-register').attr('value');
}
/*样式选择编辑器*/
function setTimeSkip(o) {
	var obj = $(o).find('.map-min tr').eq(0).find('td'),
		num = $(o).attr('value');
	$(o).find('.p-hand').addClass('ui-block-7');
	$(o).find('.time-bgline').addClass('t-blue');
	obj.attr('onclick', 'chooseHand("' + o + '",this)').addClass('ui-block-3');

	for (var i = 0; i < obj.length; i++) {
		if (i % num == 0) {
			obj.eq(i).addClass('border').addClass('border-l');
		} else if ((i + 1) == obj.length) {
			obj.eq(i).addClass('border').addClass('border-r');
		}

	}
	mouseHover2('.r-points', 13, 1, '', 1);
	cssCenter('.r-points', 'yes', 'no');
}


/***********************************以上代码，已对多项目全部同步，除非修改，不允许再对分界线上进行代码添加*********************************************/
/*针对IE6的版本所需判断函数*/
function IEstyle() {
	var browser = navigator.appName
	var b_version = navigator.appVersion
	var version = b_version.split(";");
	var trim_Version = version[1].replace(/[ ]/g, "");
	if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE6.0") {
		return "6";
	} else if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE7.0") {
		return "7";
	} else if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE8.0") {
		return "8";
	}
	if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE9.0") {
		return "9";
	}
	if (browser == "Microsoft Internet Explorer" && trim_Version == "MSIE1.0") {
		return "10";
	}
}
/*******************************************************以下为2013-11-05后开发的代码*****************************************************************************************/


/*创建二维码
 * o->目标对象
 * str->转义字符串
 * w->宽
 * h->高
 * */
function setTwoCode(o, str, w, h) {
	if (judgeStr(w) == false) {
		w = '100';
	}
	if (judgeStr(h) == false) {
		h = '100';
	}
	$(o).empty();
	$(o).qrcode({
		render: "table",
		text: str,
		width: h,
		height: h
	});
}


/************************************time-txt-box***********************************************/
function bulidTimeTxtBox(o, json, w, h) {

	var str = '';
	str = "<table  class='time-txt-box' cellpadding='0' cellspacing='0'><tr>" +
		"<td valign='top' class='date-td'> <div class='date-picker'>  </div></td>" +
		"<td valign='top' class='event-td'>  <div class='event-box'>  </div></td>"
	"</tr> </table>";

	$(o).append(str);


	bulidTimeBox('.date-picker', json);
	bulidEventBox('.event-box', json);

	if (judgeStr(w) == false) {
		w = getWinWidth() - $('.date-td').width() - 10;
	}

	$('.event-box').width(w).height(h);


	if (typeof($(o).mCustomScrollbar) != 'undefined') {
		setGDT('.event-box', '', 'dark'); //创建滚动条，考虑是否需要加载
	} else {
		$(o).find('.event-box').css({
			'overflow-y': 'scroll'
		});
	}



}

/******** ***********event-box***********/
/*创建time-box*/
function bulidTimeBox(o, json) {

	var str_timebox = '';
	str = "<ul>" +
		"<li class='up border' onclick='datePage(this)'><div  class='btn-t' ></div> </li>" +
		"<li class='time-box '>  </li>" +
		"<li class='down border' onclick='datePage(this)'> <div class='btn-b'></div></li>" +
		"</ul>";
	$(o).append(str);
	bulidDateBox('.time-box', json);

	mouseHover2('.btn-t', 8, 1, '', 1);
	mouseHover2('.btn-b', 8, 3, '', 1);
	$('.border').find('div').css({
		'margin-left': '5px'
	});
}
/*创建时间容器*/
function bulidDateBox(o, json) {
	var jStr = changeJsonToStr(json);
	var str_tr = '',
		str_table = '';
	for (var i = 0; i < jStr.length; i++) {
		var year = "<td onclick='chooseDate(this)'>" + jStr[i].year + "</td>";
		if (i == 0) {
			str_tr += "<tr>" + year + "<td rowspan='" + jStr.length + "' valign='top'> <div class='time-point'>＜</div> </td></tr>";
		} else {
			str_tr += "<tr>" + year + "</tr>";
		}
	}
	str_table = "<table cellpadding='0' cellspacing='0' class='date-box'> " + str_tr + "</table>";
	$(o).append(str_table);
	createTimeBoxStyle(o);
}
/*创建time-box的动态样式及事件*/
function createTimeBoxStyle(o) {
	var obj_td = $(o).find('tr').find('td:first');
	obj_td.hover(
		function() {
			$(this).addClass('date-over');
		},
		function() {
			$(this).removeClass('date-over');
		}
	);

}
//选取当前日期的点击事件
function chooseDate(o) {
	var obj = $(o).closest('tr');
	var n = obj.index();
	selectDate(n);

}
//选择第几个
function selectDate(n) {
	var obj = $('.time-box').find('tr').eq(n);
	moveTPoint(n);
	eventBoxShow(n);
	/*选中样式变化*/
	obj.siblings().removeClass('date-out');
	obj.addClass('date-out');

}
/*指针的移动*/
function moveTPoint(n) {
	var gotoMt = parseInt(n * $('.date-box tr td:first').height());
	$('.time-point:not(:animated)').animate({
		'margin-top': gotoMt + 'px'
	});

}

function eventBoxShow(n) {
	var o = '.event-box';


	$(o).find('.year-box:lt(' + n + ')').slideUp(500, function() {});
	$(o).find('.year-box:gt(' + n + ')').slideDown(500, function() {});
	$(o).find('.year-box').eq(n).slideDown(500, function() {});


	if (typeof($(o).mCustomScrollbar) != 'undefined') {
		setTimeout("EventScrollbar()", 400); //延迟执行
	} else {
		$(o).css({
			'overflow-y': 'auto'
		});
	}

}

function EventScrollbar() {
	var o = '.event-box';
	if (!$(o).is(':animated')) {
		$(o).mCustomScrollbar("update"); //无法确定slidUp与sllidDown事件的完结点，故暂时取消
		$(o).mCustomScrollbar("scrollTo", "top", {
			scrollInertia: 200
		});
	}
}
/*** ***********event-box************************/


function bulidEventBox(o, json) {
	var str = '',
		jStr = changeJsonToStr(json);
	for (var i = 0; i < jStr.length; i++) {
		str += bulidYearBox(i, json);

	}
	$(o).append(str);
	mouseHover2('.month-point', 13, 2, '', 1);

	$('.year-point').each(function() {
		mouseHover2(this, 15, $(this).parent().attr('value'), '', 1);
	});
	cssCenter('.month-point', 'yes', 'no');

	$('.year-box').find('tr:odd').find('.txt-box').addClass('border-1'); //根据奇偶来增加底色
	$('.year-box').find('tr:odd').find('.txt-point').addClass('txt-point-1');
	$('.year-box').find('tr:even').find('.txt-box').addClass('border-2');
	$('.year-box').find('tr:even').find('.txt-point').addClass('txt-point-2');
}
/*创建y年的event-box*/
function bulidYearBox(y, json) {
	var jStr = changeJsonToStr(json);
	var str_box = '',
		str_tr = '',
		txt = '',
		year = '',
		fj='',
		fjurl='',
		//baz010='',
		flg;

	for (var i = 0; i < jStr[y].child.length; i++) {
		txt = jStr[y].child[i].txt; //事件
		fj = jStr[y].child[i].fj; //附件名
		//fjurl = jStr[y].child[i].fjurl; //附件url
		fjurl = jStr[y].child[i].baz010;
		year = jStr[y].year; //年度
 
		month = jStr[y].child[i].month; //月份
		flg = jStr[y].flg
		if (judgeStr(txt) == false) {
			txt = '当前时间节点内容为空.';
		}
		if (i == 0) {
			str_tr += "<tr> <td></td> <td value='" + flg + "'><div class='year-point' title=" + year + "></div></td>  <td><div class='year'>" + year + "</div></td></tr>";
		}
		str_tr += "<tr id='event-" + year + '-' + month + "'> <td class='td-month' valign='top' ><div class='month'  >" + month + "</div></td> <td valign='top'><div class='month-point'></div></td>  <td><div class='txt-point'></div> <div class='txt-box' id='txt-" + year + '-' + month + "'>" + txt;
		if(fj!=''){
			str_tr +="附件：<a href='javascript:filedownload(\""+fjurl+"\",\""+fj+"\");' >"+fj+"</a>";
		}
		str_tr +="</div></td></tr>";
	}
	str_box = "<div class='year-box' id='year-box-" + year + "'><table cellpadding='0' cellspacing='0' class='year-box-table'>" + str_tr + "</table></div>";
	return str_box;
}


//按钮点击控制time-box的移动
function datePage(o) {
	var arr = $(o).attr('class').indexOf('up');
	// var flg=arr; 
	if (arr == 0) {
		moveDateBox('up', 10);
	} else {
		moveDateBox('down', 10);
	}
}
//time-box移动
function moveDateBox(arr, n) {
	var mt = parseInt($('.date-box').css('margin-top'));
	var h = parseInt($('.date-box').height());
	if (arr == 'up') {
		mt += n * 30;
		if (mt >= 0) {
			mt = 0;
		} //防止下移超出
	} else if (arr == 'down') {
		if (30 * n - mt < h) {
			mt -= n * 30;
		} //防止上移超出 
	}
	$('.date-box:not(:animated)').animate({
		'margin-top': mt + 'px'
	}, 1000);
}

/**********************************搜 索 框********************************************************************/

/*创建联想搜索框
 *o->目标对象
 *w->宽
 *doAc->执行的事件
 *arry->联想内容的数组
 */
function bulidSearch(o, arry) {

	var doAc = $(o).attr('value');

	var style = $(o).attr('name');
	if (judgeStr(style) == false) {
		style = 1;
	}
	var id = o.substring(1, o.length) + '_input';

	var strl = "<td class='ui-search-" + style + "-l'></td>";
	var strm = "<td class='ui-search-" + style + "-m' valign='top'> <input style='margin:4px 4px 0px 4px;' class='inputTM' id='" + id + "' onkeydown='if(event.keyCode==13)" + doAc + "(this);' /></td>";
	var strr = "<td class='ui-search-" + style + "-r'  onclick='" + doAc + "(this)'></td> ";
	$(o).append(" <table cellpadding='0' cellspacing='0'> <tr>" + strl + strm + strr + " </tr></table>");
	var w = $(o).width() - $(o).find('td').eq(0).width() - $(o).find('td').eq(2).width();
	$(o).find('input').css({
		'width': w + 'px'
	});

	if (judgeStr(arry) != false) {

		$("#" + id).autocomplete({
			source: arry
		}); //创建联想input框
		$('.ui-autocomplete').css({
			'height': '200px',
			'overflow': 'auto',
			'font-size': '12px'
		});
	}

}
/*获取搜索框内的值
 *o->obj
 *flg->截取方式
 *n->截取位数
 */
function getSearchVal(o, flg, n) {
	if (!$(o)) return false;

	var str = getObjValue($(o).find('input')),
		val;
	if (flg == 1) {
		return str.substring(0, n);
	} else if (flg == 2) {
		return str.substring(n + 1, str.length);
	} else {
		return str;
	}

}
/*将目标变更为搜索框*/
function bulidFlatSearch(o, w, foo, num, style) {
	if (!$(o)) return false;
	var s = '';
	if (judgeStr(style) == false) {
		s = 1;
	} else {
		s = style;
	}

	var str_input = '<td><input class="searchTxt inputTM" onkeydown="if(event.keyCode==13)' + foo + '(this)" /></td>';
	var str_ico = '<td><div class="searchIco" onclick="' + foo + '(this)"> </div></td>';
	var str_table = '<table class="search-table"  cellpadding="0" cellspacing="0"><tr>' + str_input + str_ico + '</tr> </table>';

	$(o).append(str_table);
	mouseHover2(o + ' .searchIco', 8, 166, '搜 索', 1);


	$(o).find('.searchTxt').css({
		'width': w + 'px',
		'padding-left': '8px',
		'color': '#39607e',
		'font-family': '微软雅黑'
	});
	var w_table = $(o).find('.search-table').width();

	if (s == 1) {
		$(o).addClass('ui-block-' + num);
	} else {
		$(o).css({
			'border-bottom': 'solid 1px #' + s
		});
	}
	$(o).css({
		'height': '25px',
		'width': w_table + 'px'
	});

}
/*获取指定目标内搜索框的值*/
function getSearchValue(o) {
	return getObjValue($(o).find('.searchTxt'));
}
/**********************************创建树节点******************************************************/

/*
 *创建节点树结构
 *o->目标对象
 *j->json
 */
function bulidTree(o, j) {
	var json = changeJsonToStr(j),
		str = '',
		obj, str_li = '',
		id, pid, num, btnNum = 0;
	$(o).addClass('base').empty();
	for (var i = 0; i < json.length; i++) {
		obj = $('.' + json[i].pid); //父节点对象
		pid = json[i].pid; //父节点标记
		id = json[i].id; //当前节点标记

		if (obj.find('.' + pid + '-ul').length == 0) {
			obj.append('<ul class="' + pid + '-ul " style="display:none" > </ul>');
		}
		var str_point = "<div  class='tree-point' ></div>";
		var str_span = "<span>" + id + "</span>";
		str_li = "<div  class='txt-" + id + "' onclick='treeClick(this)' value='" + pid + "'  >" + str_point + str_span + " <span class='new'></span><div>";
		obj.find('.' + pid + '-ul').append("<li class='" + id + " tree-line' value='" + id + "'>" + str_li + " </li>");
	}
	listNodeHide($('.base')); //从根节点开始所有收缩
	//遍历所有节点，根据子的存在来决定节点样式

	$('.tree-point').each(function() {
		if ($(this).closest('li').find('>ul').length > 0) {
			btnNum = 7;
		} else if ($(this).closest('li').find('>ul').length == 0) {
			btnNum = 1;
		}
		mouseHover2(this, 13, btnNum, '', 1);
	});
	//展开根节点
	$(o).find('>ul').show(); //展示第一节点
}
/*
 *节点点解事件
 *o->当前对象
 */
function treeClick(o) {
	listControl($(o));
}
/**************************************************************/
/*节点list控制*/
function listControl(obj) {
	var name = obj.attr('class');
	if (obj.parent().find('>ul').length > 0) { //有子菜单
		if (obj.parent().find('>ul').css('display') == 'none') {
			listNodeShow(obj);
		} //子菜单隐藏时 
		else if (obj.parent().find('>ul').css('display') == 'block') {
			listNodeHide(obj);
		} //当子菜单显示时
	} else {
		listNodeShow(obj);
		pointAll(name);
	} //没有子菜单     
}
/* list显示，显示当前，关闭其他
 *o->当前对象
 */
function listNodeShow(obj) {
	var name = obj.attr('class');
	var obj_p = obj.parent();
	if (obj_p.find('>ul').length > 0) { //如果有子菜单 
		obj_p.find('>ul').slideDown(function() {
			pointAll(name);
		});
		listSiblings(obj);
	} else {
		listNodeHide(obj);
		obj_p.siblings().find('ul').find('.choose-p').remove();
	}
}
/*当前节点的兄弟级
 *obj->当前对象$(obj)
 */
function listSiblings(obj) {
	var obj_p = obj.parent();
	//遍历所有兄弟节点，如果有打开的，则关闭。
	obj_p.siblings().find('ul').each(function() {
		if ($(this).css('display') == 'block') {
			$(this).slideUp(function() {
				$(this).find('.choose-p').remove();
			});
		}
	});
}
/*list隐藏
 *o->当前对象
 */
function listNodeHide(obj) {
	var name = obj.attr('class');
	var obj_p = obj.parent().find('>ul'); //当前点击条目的list合集
	obj_p.slideUp(function() {
		obj.find('ul').hide();
		pointAll(name);
		obj_p.find('.choose-p').remove();
	});
}

/*根据选择的类名，来遍历到根节点，加载选中标记
 *name->标记要移动到的类名
 **/
function pointAll(name) {
	var name_p = '',
		obj;
	do {
		movePoint(name);
		obj = $('.' + name).closest('li').find('>div')
		name = getObjValue(obj);
	}
	while (name != 'base');
	mouseHover2('.choose-p', 15, 4, '', 1); //选中标识样式选择器  
}
//选中标识的移动
function movePoint(name) {
	var o = '.' + name;
	var obj = $(o).closest('ul');
	//如果当前项目没有标识，则动态添加
	if (obj.find('>.choose-p').length == 0) {
		obj.prepend('<div class="choose-p"></div>');
		//    obj.append('<div class="choose-p"></div>');     //向后插入取消
	}

	var n = $(o).closest('li').index();
	var l = $(o).closest('ul').find('>li:last').index(),
		h = 0;

	//取消向后插入的对应方法  
	//  for(var i=n;i<=l;i++){   h-=$(o).closest('ul').find('>li:eq('+i+')').height()+  parseInt( $(o).closest('ul').find('>li:eq('+i+')').css('padding-top') );  } 
	for (var i = 0; i < (n - 1); i++) {
		h += $(o).closest('ul').find('>li:eq(' + i + ')').height() + parseInt($(o).closest('ul').find('>li:eq(' + i + ')').css('padding-top'));
	}
	h += 1;
	obj.find('>.choose-p:not(:animated)').animate({
		'margin-top': h + 'px'
	});
}

/*动态创建子集集合*/
function getNodeAll(o) {
	var menuAll = new Array(),
		i = 0;
	$(o).find('li').each(function() {
		if ($(this).find('>ul').length == 0) {
			menuAll[i] = $(this).find('>div').text();
			i++;
		}
	});
	return menuAll;
}
/*从根节向指定节点打开，待启用后修正参数
 *v->搜索标识
 */
function openTree(v) {

	var name = 'txt-' + v;
	if ($('.' + name).length != 0) {
		do {
			$('.' + name).find('>ul').show();
			$('.' + name).siblings().find('>ul').hide().find('.choose-p').remove();
			name = getObjValue($('.' + name).closest('li').find('>div'));
		}
		while (name != 'base');
		listControl($('.txt-' + v));
	}
}


/*********************************扁平 文字 图标 按钮*********************************************/
/*
 *o->目标对象
 *style->按钮样式编号，默认样式为1
 *txt->按钮内文字
 *num->图标编号
 *w * h=宽*高
 */
function setFlatBtn(o, style, txt, num, act, w, h) {
	var v = $(o).text();
	$(o).empty();
	var str_table = '<table cellpadding="0" cellspacing="0" style="position:absolute;z-index:100;"><tr> <td></td> <td></td> <td></td> </tr></table>';
	$(o).append(str_table).attr('value', 1);
	if (judgeStr(v) == false) {
		v = '';
	}
	var str_txt = "<div class='f-txt' style='text-align: center' name='txt'>" + v + "</div>";
	var str_ico = "<div class='f-btn' name='btn'></div>"
	var str_b = "<div class='f-block' name='block' style='text-align: right;padding-right:6px;font-family:黑体;font-size:14px;'></div>"

	if (style == 1 || judgeStr(style) == false) {
		$(o).find('table td').eq(0).append(str_txt);
		$(o).find('table td').eq(1).append(str_b);
		$(o).find('table td').eq(2).append(str_ico);
	}
	if (style == 2) {
		$(o).find('table td').eq(0).append(str_ico);
		$(o).find('table td').eq(1).append(str_txt);
		$(o).find('table td').eq(2).append(str_b);
	}
	buildFlatBtn(o, style, txt, num, act, w, h);
	setFlatStyle(o, style, w);
}

/*
 *o->目标对象
 *style->按钮样式编号
 *txt->按钮内文字
 *num->图标编号
 *w * h=宽*高
 */
function buildFlatBtn(o, style, txt, num, act, w, h) {
	/*判断并加载内容*/
	var obj_ico = $(o).find('.f-btn'),
		obj_txt = $(o).find('.f-txt');
	choiceTxt(o + ' .f-txt', txt, '默认按钮');
	$(o).append('<div class="f-cover" ></div>');
	$(o).attr('onmouseup', ' changeFlat(this,2)'); //绑定onmousedown事件为状态改变
	/*初始化图标*/
	var out = 8,
		over = 9;
	var icon_out = 'icon-' + out + '-out',
		icon_over = 'icon-' + over + '-over',
		icon_p = 'icon-mini-i' + num,
		icon_f = 'icon-format-8';
	obj_ico.addClass(icon_f).addClass(icon_p).addClass(icon_out);
	/*根据当前内容进行样式调整*/


	if (judgeStr(act) == false) {
		act = 1;
	}
	if (act == 1) {
		$(o).hover(
			function() {
				if (getObjValue($(o)) == 1) {
					changeFlatState(o, 2);
				}
			},
			function() {
				if (getObjValue($(o)) == 1) {
					changeFlatState(o, 1);
				}
			}
		);
	}
	/*    
    else if(act==2){
        $(o).hover(
                 function(){ 
                     $(this).css({'color':'#fff'})
                            .find('.f-cover').stop( ).animate({'margin-left':'0px'},500,'easeOutQuad');
                      obj_ico.removeClass(icon_out).addClass(icon_over);
                     },
                 function(){
                     $(this).css({'color':'#5c88ba'})
                          .find('.f-cover').stop( ).animate({'margin-left':$(o).width()+10+'px'},1500,'easeOutQuad');
                     obj_ico.removeClass(icon_over).addClass(icon_out);
                     }
             );
    }
    */
}

/*更改目标状态*/
function changeFlatState(o, state, event) {
	changeFIcon(o, state);
	changeFBg(o, state);
	if (event == 'yes') {
		setObjValue($(o), state);
	}

}
/*改变图标状态*/
function changeFIcon(o, state) {
	var icon_out = 'icon-8-out',
		icon_over = 'icon-9-over';
	if (state == 1) {
		$(o).find('.f-btn').removeClass(icon_over).addClass(icon_out);
	} else if (state == 2) {
		$(o).find('.f-btn').removeClass(icon_out).addClass(icon_over);
	}
}
/*改变背景状态*/
function changeFBg(o, state) {
	var over = 'flat-btn-over',
		out = 'flat-btn-out';
	if (state == 1) {
		$(o).removeClass(over).addClass(out);
	} else if (state == 2) {
		$(o).removeClass(out).addClass(over);
	}
}

/*对flat进行样式设定*/
function setFlatStyle(o, style, w, h) {
	var obj, w_b = 30;

	for (var i = 0; i < 3; i++) {
		var obj = $(o).find('table td').eq(i).find('div');
		if (obj.attr('name') == 'txt') {
			obj.css({
				'width': 16 + obj.width() + 'px'
			});
		} else if (obj.attr('name') == 'btn') {
			obj.parent().css({
				'width': 10 + obj.width() + 'px'
			});
		}

	}

	var w_table = $(o).find('table').width();
	if (judgeStr(h) == false) {
		h = 25;
	} //若w为设定，则暂时赋值
	if (judgeStr(w) == false) {
		w = w_table + w_b;
	} //若w为设定，则暂时赋值
	if (w_table + w_b < w) {
		w_b = w - w_table;
	} else {
		w = w_table + w_b;
	}

	var max_2 = 40;
	if (style == 1) {} else if (style == 2 && w_b < max_2) {
		w_b = max_2;
		w += 30;
	}

	$(o).css({
		'font-size': '12px',
		'width': w + 'px',
		'height': h + 'px',
		'overflow': 'hidden',
		'cursor': 'pointer'
	}).addClass('flat-btn-out');
	$(o).find('.f-block').css({
		'width': w_b + 'px'
	});
	$(o).find('.f-cover').css({
		'margin-left': w + 50 + 'px'
	});
}
/*更改状态,排他*/
function changeFlat(o, s) {
	$('.flat-btn[value="' + s + '"]').each(function() {
		changeFlatState(this, 1, 'yes');
	});
	changeFlatState(o, 2, 'yes');
}

function setFlatValue(o, v) {
	$(o).find('.f-block').text(v);
}

function getFlatValue(o) {
	return $(o).find('.f-block').text();
}
/*********第二版********/
/* 将目标对象创建为，图标-文字 按钮
 * o->目标对象
 * w->宽度
 * */
function miniFlatBtn(o, style, num, title, flg, w) {
	var str_ico = '<td style="width:30px"><div class="flat-btn-ico"></div></td>';
	var str_txt = '<td style="padding:0 4px 0 4px;"><div >' + title + '</div></td>';
	var str_tr = '<tr>' + str_ico + str_txt + '</tr>';
	var str_table = ' <table class="flat-btn-table" cellpadding="0" cellspacing="0" style="font-size:12px;">' + str_tr + '</table>';
	$(o).append(str_table);
	mouseHover2(o + ' .flat-btn-ico', style, num, title, 1);

	$(o).width(w - 24).find('table').width(w - 24);
}
/********************************************************创建checkbox*/
/*
 * o->目标对象
 * v->1未勾选，2勾选
 * */
function bulidCheckBox(o, v) {
	setObjValue($(o), v);

	if (v == 1) {
		num = 60;
	} else if (v == 2) {
		num = 61;
	}
	mouseHover2(o, 8, num, 'checkbox', 1);

	$(o).attr('onmouseup', 'checkbox("' + o + '")');
}
/*checkBox绑定事件,作用在icon*/
function checkbox(o) {
	if (getObjValue($(o)) == 1) {
		checkBoxVal(o, true);
	} else if (getObjValue($(o)) == 2) {
		checkBoxVal(o, false);
	} else {}
}
/*手动对checkbox进行设置，o为总容器div*/
function checkBoxVal(o, bool) {

	var id = o.substr(1, o.length),
		obj, v;
	if ($(o).find('#' + id + '-cb').length > 0) {
		obj = $(o).find('#' + id + '-cb');
	} else {
		obj = $(o);
	}
	var name = '#' + obj.attr('id');
	if (bool == true) {
		mouseHover2(name, 8, 61, 'checkbox', 1);
		v = 2;
	} else if (bool == false) {
		mouseHover2(name, 8, 60, 'checkbox', 1);
		v = 1;
	}
	setObjValue(obj, v);
}


/*获取目标状态*/
function getCheckBoxVal(o) {
	var id = '#' + $(o).find('.btn-checkbox');
	return getObjValue($(id));
}
/*将目标变更为带文字的checkbox*/
function bulidCheckGroup(o, txt, v) {
	var id = o.substring(1);
	var str_check = "<td><div id='" + id + "-cb'  ></div></td>";
	var str_font = "<td><div style='font-size:12px;margin-left:10px;color:#5c88ba;'>" + txt + "</div></td>";
	var str_table = '<table cellpadding="0" cellspacing="0"><tr>' + str_check + str_font + '</tr></table>';
	$(o).append(str_table);
	bulidCheckBox(o + ' #' + id + '-cb', v); //创建checkbox 1->没有被勾选||2->被勾选 ，点击事件自定义 
}

/*判断目标checkbox是否被选中*/
function judgeCheckBoxIco(o, b) {
	var v;
	if (b == true) {
		v = getObjValue($(o).find(o + '-cb'));
	} else {
		v = getObjValue($(o));
	}
	return v
}
/*******************************************表格样式的基本封装组件*************************************************************************************/

/*创建数据主体*/
function creatList(o, s, h, end) {
	var str_tr = '',
		str_td = '';
	$(o).find('.table tr').append('<td class="table-block" style="width:18px;"></td>'); //插入滚动条预留白
	$(o).find('.table tr td').addClass('Td-center');
	var td_max = $(o).find('.table tr').eq(0).find('td').length;
	//字符串拼接
	var str_date = '<table cellpadding="0" cellspacing="0"> ' + str_tr + ' </table>'; //数据列表
	var str_end = '<tr class="Tr-count"><td colspan="' + (td_max) + '"> ' +
		'<table cellpadding="0" cellspacing="0"> <tr><td class="table-count-txt"> </td> <td class="table-count Td-right"> </td> </tr> </table> ' +
		'</td> </tr>'; //总结行
	var str_list = '<tr><td colspan="' + td_max + '"><div class="date-list ">     </div> </td></tr> '; //中间数据组装


	$(o).find('.table').append(str_list); //插入数据，总计栏另算
	/*样式更正*/
	if (judgeStr(end) == true) {
		$(o).find('.table').append(str_end);
	}
	// if( judgeStr(w)==false ){  }
	if (judgeStr(h) == false) {
		h = 200;
	}
	$(o).find('.date-list').css({
		'height': h + 'px',
		'overflow': 'auto'
	});
	//加载表格总体样式（表头）
	$(o).find('.table tr:eq(0) td').addClass('list-border-' + s);
	$(o).find('.table tr:eq(0) td').last().css({
		'border': '',
		'background': ''
	});
	$(o).find('.table tr:eq(0) td').each(function() {
		var type = $(this).attr('type');
		if (type == 'button') {
			$(this).width(60);
		} else if (type == 'checkbox') {
			$(this).width(15);
			var check_str = '<input class="check_all " type="checkbox" title="全选" />';
			$(this).empty().append(check_str);
			tableCheckboxAll(o);
		}
	});
	setTableStyle(o, s);
}



/*加载数据，根据已有参数自动选择样式
 *o->目标对象
 *json
 
 */
function setTableList(o, json) {

	var jsonStr = changeJsonToStr(json);

	var str_tr = '',
		str_td = '',
		obj_list = '.date-list',
		title = '',
		foo;
	var td_max = $(o).find('.table tr').eq(0).find('td').length;
	//循环创建数据列表
	for (var i = 0; i < jsonStr.length; i++) {
		str_td = '';
		for (var a = 0; a < (td_max - 1); a++) { //实际列数应删去滚动条留白
			var obj = $(o).find('tr').eq(0).find('td').eq(a),
				title = '';
			var value = obj.attr('value'); //通过value对应json属性名称
			var dis = obj.css('display'); //隐藏域
			var type = obj.attr('type'); //根据类型创建列类型
			var name = obj.attr('name'); //用于按钮的点击事件
			var btnValue = obj.text();
			if (judgeStr(value) == true) {
				var m = jsonStr[i][value];
				if (judgeStr(m) == false) {
					m = '';
				}
			} else {
				m = '';
				value = '';
			}

			if (type == 'button') {
				if (judgeStr(name) == false) {
					btnValue = 'Check';
				}
				m = '<input type="button" value="' + btnValue + '" class="btn6_mouseout" name="' + name + '"    />';

			} else if (type == 'checkbox') {
				m = '<input class="check-' + i + ' table-list-checkbox" type="checkbox"    />';
			} else if (type == 'defined') {
				m = getHtmlStr(name);
			} else {
				title = m;
			}
			str_td += '<td class="' + value + '" style="display:' + dis + '; "  title="' + title + '" value="' + value + '">' + m + '</td>'; //没个单元格的ClassName为json键，与表头value对应
		}
		str_tr += '<tr   class="table-list-tr table-font" > ' + str_td + ' </tr>';
	}
	//字符串拼接
	var str_date = '<table cellpadding="0" cellspacing="0"> ' + str_tr + ' </table>'; //数据列表
	$(o).find(obj_list).append(str_date);



	var ss = $(o).attr('class');

	var styleNum = ss.substr(ss.indexOf('table-style-') + 12, 2);

	addCrossLine(o, styleNum);
	addMouseEvent(o);
	setTableBtnCss(o);


	for (var i = 0; i < (td_max - 1); i++) {
		setTableListWidth(o, i);
	}
	tableMouseUp(o, styleNum);
	/*或数据条数少，则无需撑大表格*/
	var h_p = $(o).find(obj_list).height();
	var h_o = $(o).find(obj_list).find('table').height();
	if (h_o < h_p) {
		// $(o).find(obj_list).height(h_o); //补白
		$(o).find('.table-block').width(0);
	}
}



function setTableBtnCss(o) {
	var obj = $(o).find('.date-list').find('input[type="button"]')
	var out = 'btn6_mouseout',
		over = 'btn6_mouseover';
	obj.hover(
		function(event) {
			if (obj.attr('class')) {
				if (obj.attr('class').indexOf(out) >= 0 || obj.attr('class').indexOf(over) >= 0) {
					$(this).removeClass(out).addClass(over);
				}
			}

		},
		function(event) {
			if (obj.attr('class')) {
				if (obj.attr('class').indexOf(out) >= 0 || obj.attr('class').indexOf(over) >= 0) {
					$(this).addClass(out).removeClass(over);
				}
			}
		}
	);

}


/*checkbox全选绑定事件*/
function tableCheckboxAll(o) {
	var obj_list = '.date-list';
	$(o).find('tr').eq(0).find('input[type="checkbox"]').click(function(event) {
		if ($(this).attr('checked') == 'checked' || $(this).attr('checked') == true) {
			$(o).find(obj_list).find('input[type="checkbox"]').each(function(event) {
				$(this).attr('checked', true);
				controlCheckboxColor($(this));
			});
		} else {
			$(o).find(obj_list).find('input[type="checkbox"]').each(function(event) {
				$(this).attr('checked', false);
				controlCheckboxColor($(this));
			});
		}
	});
}



/*行点击事件的绑定*/
function tableMouseUp(o, s) {
	$(o).find('.table-list-tr').mouseup(function(event) {
		if ($(this).find('input[type="checkbox"]').length > 0) {
			judgeCheckBox($(this).find('.table-list-checkbox'));

		} else {
			controlTableColor($(this), s);
		}
		return false;
	});
	tableCheckboxClick(o);
	tableButtonClick(o);
}
/*checkbox点击事件*/
function tableCheckboxClick(o) {
	if ($(o).find('input[type="checkbox"]').length > 0) {
		$(o).find('.table-list-checkbox').click(function(event) {
			return false;
		});
	}
}
/*button 点击事件*/
function tableButtonClick(o) {
	if ($(o).find('input[type="button"]').length > 0) {
		$(o).find('input[type="button"]').click(function(event) {
			var foo = $(this).attr('name');
			if (typeof(foo) != 'undefined') {
				eval(foo)($(this).closest('tr'));
			}
			stopBubble(event);
		});
		$(o).find('input[type="button"]').dblclick(function(event) {
			stopBubble(event);
		});
	}

}


/*获取列表中选中栏，区分checkbox的存在与否状态*/
function getTableListStr(o, key) {
	var obj = $(o).find('.date-list').find('input[checked="checked"]');
	var obj_c = $(o).find('.date-list').find('input[type="checkbox"]');

	str_tr = '';

	if (obj_c.length > 0) {
		if (obj.length > 0) {
			for (var i = 0; i < obj.length; i++) {
				var obj_tr = obj.eq(i).closest('tr');
				if (str_tr != '') {
					str_tr += ',';
				}
				str_tr += getGrounpStr(obj_tr, key);
			}
		} else { /*未选中*/ }

	} else {
		var obj_tr = $(o).find('.date-list').find('tr[value=2]');
		if (obj_tr.length > 0) {
			str_tr += getGrounpStr(obj_tr, key);
		}
	}
	return "[" + str_tr + "]";
}


/*指定行返回的json结果
 *obj->目标行的整体对象$(o)
 *n->目标列的集合 'a,b,c'
 */
function getTrJsonStr(obj, n) {
	var str = getGrounpStr(obj, n);
	return "[" + str + "]";
}

/*给定目标返回结果 {}
 *目标行对象->$(o)
 *n->若没有，则获取当前行所有td的value值，以此组合为目标组
 */
function getGrounpStr(obj, n) {
	var arry = '',
		str = '';
	if (judgeStr(n) == false) {
		for (var i = 0; i < obj.find('td').length; i++) {
			var value = getObjValue(obj.find('td').eq(i));
			if (judgeStr(value) != false) {
				if (str != '') {
					str += ',';
				}
				str += value;
			}
		}
		arry = str.split(",");
		str = getTrStr(obj, arry);
	} else {
		arry = n.split(",");
		str = getTrStr(obj, arry);
	}
	return "{" + str + "}";
}
/*获取当前行指定列的参数*/
function getTrStr(obj, arry) {
	var str = '',
		key = '',
		value = '';
	for (var i = 0; i < arry.length; i++) {
		key = arry[i];
		value = getTdStr(obj, key);
		if (str != '') {
			str += ','
		}
		str += '"' + key + '":"' + value + '"';
	}
	return str;
}
/*获取指定单元格内数据*/
function getTdStr(obj, key) {
	return obj.find('.' + key).text();
}

//获取对象table内的全部字符串
function getTableStr(o, n) {
	var arr = new Array();
	var obj = $(o).find('.date-list').find('tr');
	for (var i = 0; i < obj.length; i++) {
		var obj_tr = obj.eq(i);
		arr[i] = getGrounpStr(obj_tr, n);
	}
	var jsonStr = '[' + arr.toString() + ']';
	var json = changeJsonToStr(jsonStr);
	return json;

}

/*选中样式*/
function trChecked(s) {

	return css = 'ui-block-' + s;
}
/*选中为2，未选中为1*/
function controlTableColor(obj, s) {
	if (s == 3) {
		s = 8;
	}
	var css = trChecked(s);
	obj.siblings().attr('value', 1).find('td').removeClass(css);
	obj.attr('value', 2).find('td').addClass(css);
}
/*控制操作checkbox后，table选中状态的变更*/
function controlCheckboxColor(obj) {
	var b = obj.attr('checked');
	var css = trChecked(7);
	if (b == 'checked') {
		obj.closest('tr').attr('value', 2).find('td').addClass(css)
	} else {
		obj.closest('tr').attr('value', 1).find('td').removeClass(css);
	}

}
/*判断checkbox，来更改当前状态*/
function judgeCheckBox(obj) {
	var v = obj.attr('checked'),
		color = '';
	if (v == 'checked') {
		changeAttr(obj, 'checked', false);
		color = false
	} else {
		changeAttr(obj, 'checked', true);
		color = true;
	}
	controlCheckboxColor(obj);
}



/*对某一列增加样式
 *o->目标对象
 *n->列classname
 *s->增加的样式 classname
 */
function addTableClass(o, n, s) {
	var obj = $(o).find('.date-list').find('.' + n);
	if (!s) {
		s = 'Td-center';
	}
	obj.addClass(s);

}
/*设定tableList某列的宽度，与表头一致*/
function setTableListWidth(o, n) {
	var td_w = $(o).find('.table tr').eq(0).find('td').eq(n).width() + 1;
	if (judgeStr($(o).find('.table tr').eq(0).find('td').eq(n).text()) == false) {} else {
		$(o).find('.date-list tr').find('td').eq(n)
			.css({
				'width': td_w + 'px',
				'max-width': td_w + 'px',
				'word-break': 'break-all',
				'overflow': 'hidden'
			}); //设置数据列宽度   
	}
}
/*斑马线*/
function addCrossLine(o, s) {
	$(o).find('.date-list table tr:odd').addClass('list-bg-' + s);
	$(o).find('.date-list td').addClass('dashed');

	if ($(o).find('.Tr-count')) {
		$(o).find('.Tr-count td ').addClass('list-end-' + s);
	}
}
/*table-grid鼠标 事件*/
function addMouseEvent(o) {
	var obj = $(o).find('.date-list table tr');
	var obj_name = o.substr(1, o.length);
	obj.hover(
		function(event) {
			$(this).closest('tr').addClass('mouse-p');
		},
		function(event) {
			$(this).closest('tr').removeClass('mouse-p');
		}
	);

	obj.click(function(event) {
		if (typeof(tableListClick) != 'undefined') {
			eval(tableListClick)(obj_name, this);
		}
	});
	obj.dblclick(function(event) {
		if (typeof(tableListDbClick) != 'undefined') {
			eval(tableListDbClick)(obj_name, this);
		}
	});
}



/***************************table扩展方法***********************************/
/*对某一列进行ClassName操作
 *o->目标对象
 *a->add=增加|remove=删除
 *n->列明
 *s->样式名称
 */
function alterTableClass(o, a, n, s) {
	var obj = $(o).find('.date-list').find('table tr');
	if (a == 'add') {
		obj.find('.' + n).addClass(s);
	} else if (a == 'remove') {
		obj.find('.' + n).removeClass(s);
	}
}
/*清除目标内数据*/
function cleanTableList(o) {
	$(o).find('.date-list').empty();
}
/*总计栏内容的赋值*/
function setTableCount(o, txt, v) {
	$(o).find('.table-count-txt').text(txt);
	$(o).find('.table-count').text(v);
}
/*获得总计栏内值*/
function getTableCount(o) {
	return $(o).find('.table-count').text();
}

/*对表格外的样式设置*/
function setTableStyle(o, s) {
	$(o).addClass('table-style-' + s).find('.table-font');
	$(o).find('.table').addClass('fSize-12').addClass('table-format-2').css({
		'margin': '2px 1px 2px 1px'
	});
}
/*预留自定义列*/
function getHtmlStr(o) {
	var str = $('.user-defined').find('.' + o).html();
	return str;

}

/*新版图标控件，ios7极简主义风格*/
var bulidIosIcon = function(o, s, n, title, flg, w, h) {
	var obj = $(o);
	var ico_w = w,
		ico_h = h,
		style = s,
		num = n,
		txt = title,
		alt = title,
		v = flg;
	if (obj.length < 1) {
		return false;
	}
	if (judgeStr(flg) == false) {
		v = 64;
	}
	if (judgeStr(ico_w) == false) {
		ico_w = 64;
	}
	if (judgeStr(ico_h) == false) {
		ico_h = 64;
	}
	if (judgeStr(s) == false) {
		style = 1;
	}
	if (judgeStr(n) == false) {
		num = 1;
	}
	if (judgeStr(title) == false) {
		txt = '';
		alt = '';
	}
	var pathName = getProjectName(2);
	var path = pathName + '/resource/images/ico/ios7_' + style + '/';
	var ico_num = num + '.png';
	var opation_0 = 'iso7_0_' + ico_num;
	var opation_1 = 'iso7_1_' + ico_num;

	var alt = '123';

	var str_img = '<img src="' + path + opation_0 + '"  alt="' + alt + '" style="width:' + ico_w + 'px;height:' + ico_h + 'px;" title="' + title + '" value="' + v + '" />';

	obj.css({
		'width': ico_w + 'px',
		'height': ico_h + 'px',
		'overflow': 'hidden'
	}).empty().append(str_img)
		.unbind('mouseenter').mouseenter(function() {
			$(this).find('img').attr('src', path + opation_1);
		})
		.unbind('mouseleave').mouseleave(function() {
			$(this).find('img').attr('src', path + opation_0);
		});
}


/*****************************************由于浏览器版本的不同，Jquery方法兼容性也不同，特进行以下封装***************************************************/

/*判断所传字符是否为空或未定义*/
	function judgeStr(str) {

		if (typeof(str) == 'undefined' || str == '' || str == 'undefined' || str == null) {
			return false;
		} else {
			if (typeof(str) == 'object') {
				return 'object';
			} else {
				return true;
			}
		}
	}
	/*根据IE版本来选择方法获取value值*/
	function getObjValue(obj) {
		var val;
		if ($.browser.version == 6) {
			val = obj.val();
		} else {
			val = obj.attr('value');
		}
		return val;
	}
	/*根据IE版本来选择方法对目标设定value值*/
	function setObjValue(obj, v) {
		if ($.browser.version == 6) {
			obj.val(v);
		} else {
			obj.attr('value', v);
		}

	}
	/*获取指定iframe->src 关键字后的字符串*/
	function getIframeSrc(o, v) {
		var str = $(o).attr('src');
		var a = str.indexOf(v) + 1;
		return str.substring(a);
	}
	/*用于生僻字控件*/
	function controlIframe(o, v) {

		$(o).css({
			'display': v
		});
	}
	/**
	 *判断v是否存在，若存在则替换对象o内的值为v，若不存在，则判断o对象内是否有值，若则用，若没有则用默认m
	 */
	function choiceTxt(o, v, m) {
		if (judgeStr(v) == true) {
			$(o).text(v);
		} else {
			if (judgeStr($(o).text()) == false) {
				$(o).text(m);
			}
		}
	}
	/*获取项目当前工程名称*/
	function getProjectName(s) {
		var url;
		var pathName = window.document.location.pathname;
		var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
		if (s == 1) {
			url = pathName;
		} else if (s == 2) {
			url = projectName;
		}

		return url;
	}
	/*将json转换成字符串*/
	function changeJsonToStr(j) {
		var json = (new Function('return' + j)());
		return json;
	}
	/*获取json内指定对象内包含多少个属性*/
	function getJsonValueNum(j) {
		var jsonstr = changeJsonToStr(j);
		var c = 0;
		for (i in jsonstr[0]) {
			c++;
		}
		return c;
	}

	function changeAttr(obj, p, v) {
		obj.attr(p, v);
	}
	/*根据浏览器机制自行判断阻止冒泡机制*/
	function stopBubble(e) {
		if (e.stopPropagation) {
			e.stopPropagation();
		} else {
			e.cancelBubble = true;
		}
	}
	//处理键盘事件 禁止后退键（Backspace）密码或单行、多行文本框除外
	function forbidBackSpace(e) {
		var ev = e || window.event; //获取event对象    
		var obj = ev.target || ev.srcElement; //获取事件源    
		var t = obj.type || obj.getAttribute('type'); //获取事件源类型    
		var vReadOnly = obj.readOnly;   //获取作为判断条件的事件类型  
		var vDisabled = obj.disabled; //处理undefined值情况    
		vReadOnly = (vReadOnly == undefined) ? false : vReadOnly;
		vDisabled = (vDisabled == undefined) ? true : vDisabled; //当敲Backspace键时，事件源类型为密码或单行、多行文本的，    //并且readOnly属性为true或disabled属性为true的，则退格键失效   
		var flag1 = ev.keyCode == 8 && (t == "password" || t == "text" || t == "textarea") && (vReadOnly == true || vDisabled == true); //当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效    
		var flag2 = ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea"; //判断   
		if (flag2 || flag1) return false;
	} //禁止后退键 作用于Firefox、Opera

	document.onkeypress = forbidBackSpace; //禁止后退键  作用于IE、Chrome
	document.onkeydown = forbidBackSpace;