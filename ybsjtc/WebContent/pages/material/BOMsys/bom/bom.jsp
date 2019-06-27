<%@ page contentType="text/html; charset=utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="cw" uri="/widget-tags"%>
<%@ include file="/pages/include/header.jsp"%>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resource/scripts/buttonPremission.js"></script>
<head>
<title>物料编码</title>

<style type="text/css">
html, body {
	font-size: 13px;
	padding: 0;
	margin: 0;
	border: 0;
	height: 100%;
	overflow: hidden;
}

.mini-panel-header {
	background-color: #E0EEEE;
}

.Replace {
	background-color: #B9F6F8
}

.modify {
	background-color: #FFFF99
}

.mini-panel-body {
	padding: 0px;
}

#form1 table tr {
	height: 28px;
}
</style>


</head>
<body>
	<div class="mini-fit">
		<div class="mini-panel" title="查询条件" showCollapseButton="false"
			style="width: 100%; height: auto;">
			<div id="materialFormView">
				<form id="materialForm" name="materialForm" style="" action="#"
					method="post">
					<table width="99%" border="0" cellpadding="0" cellspacing="0px"
						style="padding-top: 8px;">
						<tr height="28px">
							<td class="mini_title" align="right" width="60px">大类名称：</td>
							<td><input id="maxclass" name="maxclass"
								class="mini-combobox"
								url="${pageContext.request.contextPath}/class/getAllbigclassPre.do?nottype=1"
								onvaluechanged="onClassChanged" showNullItem="true"
								textField="classname" width="80%" valueField="id" /></td>
							<td class="mini_title" align="right" width="80px">制造厂商：</td>
							<td><input id="prodSupper" name="prodSupper"
								class="mini-combobox" url="" valueFromSelect="true"
								textField="brandname" width="80%" valueField="id"
								allowInput="true" onclick="loadprodSupper" /></td>
							<td class="mini_title" align="right" width="110px">封装：</td>
							<td><input id="package_" name="package_"
								class="mini-combobox" valueFromSelect="true" allowInput="true"
								url="" textField="packagename" width="80%" valueField="id"
								onclick="loadpackage" /></td>
						</tr>
						<tr height="28px">
							<td class="mini_title" align="right" width="60px">小类名称：</td>
							<td><input id="prodCodeSellPtr" name="prodCodeSellPtr"
								class="mini-combobox" url="" showNullItem="true"
								textField="classname" width="80%" valueField="id" /></td>
							<td class="mini_title" align="right" width="80px">供应商料号：</td>
							<td><input class="mini-textbox" id="custPartCode"
								name="custPartCode" width="80%" /></td>
							<td class="mini_title" align="right" width="110px">物料名称（描述）：</td>
							<td><input class="mini-textbox" id="ipdcSTR" name="ipdcSTR"
								width="80%" emptyText="多个关键词用空格隔开" /></td>
							<td colspan="2" align="center" valign="right">
								<div style="width: 150px; padding-right: 12px;" class="operate">
									<button type="button" class="cx_color" onclick="search()">
										<span class=""></span>查询
									</button>
									<button type="button" class="cz_color" onclick="resetForm()">
										<span class=""></span>重置
									</button>
								</div>
							</td>
						</tr>
						<tr height="28px">
							<td class="mini_title" width="80px">供应商：</td>
							<td width="16%"><input id="supplierPtr" name="supplierPtr"
								class="mini-combobox" valueFromSelect="true" showNullItem="true"
								url="" onclick="loadsupplierPtr" textField="supplier_name"
								width="80%" valueField="id" allowInput="true" /></td>
							<td class="mini_title" align="right" width="80px">物料编码：</td>
							<td><input class="mini-textbox" id="invPartNumber"
								name="invPartNumber" width="80%" /></td>
							<td class="mini_title" align="right" width="110px">禾川编码：</td>
							<td><input class="mini-textbox" id="extraDesc"
								name="extraDesc" width="80%" /></td>

						</tr>

					</table>
				</form>
			</div>
			<div id="bomFormView" style="display: none">
				<form id="bomForm" name="bomForm" style="" action="#" method="post">
					<table width="99%" border="0" cellpadding="0" cellspacing="0px"
						style="padding-top: 8px;">
						<tr height="28px">
							<td class="mini_title" align="right" width="60px">版本号：</td>
							<td><input id="version" name="version" class="mini-combobox"
								onvaluechanged="searchBom" textField="version" width="150px"
								valueField="version" /></td>
						</tr>

					</table>
				</form>
			</div>
		</div>
		<div style="width: 100%;">
			<div class="mini-toolbar">
				<div id="materialBarView">
					<div class="operate" style="text-align: left !important">
						<button type="button" class="bc_color" onclick="importBOM()"
							id="importBOMInfo" style="display: none;">
							<span class=""></span>导入BOM表
						</button>
						<button type="button" class="bc_color" onclick="viewBOMInfo()"
							id="viewBOMInfo" style="display: none;">
							<span class=""></span>查看BOM表
						</button>
					</div>
				</div>
				<div id="bomBarView" style="display: none">
					<table style="width: 100%;">
						<tr>
							<td style="white-space: nowrap;"><div class="operate"
									style="text-align: left !important">
									<button type="button" class="bc_color" onclick="exportBom()"
										style="width: 117px">
										<span class=""></span>导出BOM表
									</button>
								</div></td>
							<td style="white-space: nowrap;"><div class="operate"
									id="startEdit" style="text-align: left !important">
									<button type="button" class="bc_color" onclick="startEdit()">
										<span class=""></span>开启BOM表编辑
									</button>
								</div>
								<div class="operate" id="endEdit" style="display: none"
									style="text-align: left !important">
									<button type="button" class="bc_color" onclick="endEdit()">
										<span class=""></span>关闭BOM表编辑
									</button>
								</div></td>
							<td style="width: 100%;">
								<div style="float: left; display: none" id="editView">
									<a class="mini-button" iconCls="icon-add" onclick="addRow()"
										plain="true" tooltip="增加...">添加物料</a> <a class="mini-button"
										iconCls="icon-add" onclick="addSonRow()" plain="true"
										tooltip="增加...">添加子物料</a> <a class="mini-button"
										iconCls="icon-add" onclick="addReplace()" plain="true"
										tooltip="增加...">增加替换料</a> <a class="mini-button"
										iconCls="icon-remove" onclick="removeRow()" plain="true">删除</a>
									<a class="mini-button" iconCls="icon-reload"
										onclick="reloadRow()" plain="true">重置</a> <span
										class="separator"></span> <a class="mini-button"
										iconCls="icon-user" onclick="saveData()" plain="true">发起变更审批</a>
								</div>
							</td>
							<td style="white-space: nowrap;"><div class="operate"
									style="text-align: left !important">
									<button type="button" class="bc_color" onclick="goback()">
										<span class=""></span>返回
									</button>
								</div></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<!-- center begin -->
		<div class="mini-panel" title="查询结果" showCollapseButton="false"
			style="width: 100%; height: auto;">
			<div id="materialGridView">
				<div id="material" class="mini-datagrid" idField="id"
					multiSelect="false" style="width: 100%; height: auto;"
					allowResize="false" pageSize="20" showReloadButton="flase"
					showPageSize="false" virtualScroll="true" allowResize="true"
					url="${pageContext.request.contextPath}/encoding/getMaterielList.do">
					<div property="columns">
						<div type="checkcolumn"></div>
						<div field="prodCodeSellPtrStr" width="20%" headerAlign="center"
							align="center">物料小类</div>
						<!-- <div field="rkey" width="13%" headerAlign="center" align="center">RKEY</div>  -->
						<!-- <div field="ttype" width="20%" headerAlign="center" align="center">原料标识</div> -->
						<div field="invPartNumber" width="20%" headerAlign="center"
							align="center">物料编码</div>
						<div field="extraDesc" width="15%" headerAlign="center"
							align="center">禾川编码</div>
						<!-- <div field="invPartDescriptionC" width="33%" headerAlign="center" align="center">物料大类</div> -->
						<div field="prodSupperStr" width="15%" headerAlign="center"
							align="center">制造厂商</div>
						<div field="package_Str" width="17%" headerAlign="center"
							align="center">封装</div>
						<div field="invPartDescriptionC" width="45%" headerAlign="center"
							align="center">物料名称（描述）</div>
						<div field="supplierPtrStr" width="25%" headerAlign="center"
							align="center">供应商</div>
						<div field="custPartCode" width="25%" headerAlign="center"
							align="center">供应商料号</div>
						<div field="stockPurch" width="10%" headerAlign="center"
							align="center">包装数量</div>
						<!-- <div field="warehouse" width="10%" headerAlign="center"
							align="center">仓存</div> -->
					</div>
				</div>
				<!-- center end -->
			</div>
			<div id="bomGridView" style="display: none">
				<div id="bom" class="mini-treegrid" ondrawcell="onDrawCell"
					style="width: 100%; height: auto;" showTreeIcon="true"
					allowResizeColumn="true"
					url="${pageContext.request.contextPath}/bom/queryBom.do"
					onbeforeload="onBeforeTreeLoad" treeColumn="taskname"
					idField="infoid" parentField="productid" resultAsTree="false">
					<div property="columns">
						<div type="checkcolumn" name="taskname">树形结构</div>
						<div field="prodCodeSellPtrStr" width="20%" headerAlign="center"
							align="center">物料小类</div>
						<div field="bomType" width="10%" headerAlign="center"
							renderer="onloadBomType" align="center">类型</div>
						<div name="how" field="how" headerAlign="center" allowSort="false"
							align="center" width="10%">
							<span style="color: #5ec8ce">用量</span> <input property="editor"
								class="mini-textbox" style="width: 100%;" minWidth="100" />
						</div>
						<div name="top" field="top" headerAlign="center" allowSort="false"
							align="center" width="10%">
							<span style="color: #5ec8ce">正面贴装参数</span> <input
								property="editor" class="mini-textarea" style="width: 100%;"
								minWidth="300" />
						</div>
						<div name="bottom" field="bottom" headerAlign="center"
							allowSort="false" align="center" width="10%">
							<span style="color: #5ec8ce">反面贴装参数</span> <input
								property="editor" class="mini-textarea" style="width: 100%;"
								minWidth="300" />
						</div>
						<div field="extraDesc" width="15%" headerAlign="center"
							align="center">禾川编码</div>
						<div field="prodSupperStr" width="15%" headerAlign="center"
							align="center">制造厂商</div>
						<div field="package_Str" width="17%" headerAlign="center"
							align="center">封装</div>
						<div field="smtFlagStr" width="12%" headerAlign="center"
							align="center">贴/装形式</div>
						<div field="invPartDescriptionC" width="45%" headerAlign="center"
							align="center">物料名称（描述）</div>
						<div field="custPartCode" width="25%" headerAlign="center"
							align="center">供应商料号</div>
					</div>
				</div>
				<!-- center end -->
			</div>
		</div>
	</div>
</body>
</html>
<script type="text/javascript">
	mini.parse();
	var materialForm = new mini.Form("materialForm");
	var bomForm = new mini.Form("bomForm");
	var material = mini.get("material");
	var bom = mini.get("bom");
	var productid = '';//产品id
	var maxVersion = '';//最新版本
	var nowVersion = '';//当前版本
	
	function onDrawCell(e){ 
		if("replace"==e.node.operation){
			e.rowStyle="background-color: #B9F6F8";
		}
	} 
	
	function onBeforeTreeLoad(e) {
		var tree = e.sender; //树控件
		var node = e.node; //当前节点
		var params = e.params; //参数对象
		//可以传递自定义的属性
		if(e.node.infoid){
			params.productid = e.node.infoid; //后台：request对象获取"myField"
			params.version='';
		}else{
			params.productid=productid;
		}
	}

	function onloadBomType(e) {
		var grid = e.sender;
		var record = e.record;
		var bomType = record.bomType;
		if (bomType == 1) {
			return "物料";
		} else if (bomType == 2) {
			return "成品";
		} else if (bomType == 10) {
			return "虚拟产品";
		} else if (bomType == 9) {
			return "半成品";
		}

	}

	function exportBom() {
		document.bomForm.action = "${pageContext.request.contextPath}/bom/exportBom.do?productid="
				+ productid;
		document.bomForm.submit();
	}

	function saveData() {
		var editDate = bom.getChanges(null, false);
		if (editDate.length == 0) {
			mini.alert("未修改任何数据，无需发起审批！");
			return;
		}
		var model={};
		for(var i=0;i<editDate.length;i++){
			var flag=true;
					for(var j=0;j<editDate.length;j++){
						if(editDate[j]._state=="removed"&&editDate[i].productid==editDate[j].infoid){
							flag=false;
						}
					}
			if(editDate[i].replacecode!=""&&editDate[i].replacecode!=null){
				editDate[i].operation="replace";
			}else{
				editDate[i].operation=editDate[i]._state;
			}
			if(!model[editDate[i].productid]&&flag){
				model[editDate[i].productid]=[];
				model[editDate[i].productid].push(editDate[i]);
			}else if(model[editDate[i].productid]&&flag){
				model[editDate[i].productid].push(editDate[i]);
			}
		}
		model.productid=productid;
		mini.open({
			targetWindow : window,
			url :  "${pageContext.request.contextPath}/pages/material/BOMsys/bom/bom_ecn.jsp",
			title : "生成ECN",
			width : 1200,
			height : 804,
			showMaxButton : true,
			allowResize : true,
			onload : function() {
				var iframe = this.getIFrameEl();
				iframe.contentWindow.SetData(model);
			},
			ondestroy : function(action) {
				if (action == "ok") { //如果点击“确定”
					var iframe = this.getIFrameEl();
					loadVersionDate();
					var data = bomForm.getData(true);
					data.productid = productid;
					bom.load(data);
				}
			}
		}); 
	}

	function addReplace() {
		var row = bom.getSelectedNode();
		if (!row) {
			mini.alert("请选择要添加替换料的物料！");
			return;
		}
		if (row.operation == "replace") {
			mini.alert("请选择主料进行替换料新增！");
			return;
		}
		mini
				.open({
					targetWindow : window,
					url : "${pageContext.request.contextPath}/pages/material/BOMsys/bom/bom_edit.jsp",
					title : "添加物料",
					width : 1200,
					height : 817,
					showMaxButton : true,
					allowResize : true,
					onload : function() {
						var iframe = this.getIFrameEl();
					},
					ondestroy : function(action) {
						if (action == "ok") { //如果点击“确定”
							var iframe = this.getIFrameEl();
							//获取选中、编辑的结果
							var data = iframe.contentWindow.getData();
							var data = mini.clone(data); //必须。克隆数据。
							var hava = bom.getChildNodes ( bom.getParentNode ( row ) );
							var index = bom.indexOf(row);
							for (var i = 0; i < data.length; i++) {
								data[i].replacecode = row.custPartCode;
								data[i].bomType = data[i].ttype;
								data[i].infoid = data[i].id;
								data[i].productid=row.productid;
								if("1"==data[i].bomType) {
									data[i].isLeaf=true;
								}else {
									data[i].isLeaf=false;
									data[i].expanded=false;
								}
								var flag = false;
								for (var j = 0; j < hava.length; j++) {
									if (data[i].custPartCode == hava[j].custPartCode) {
										mini.alert('料号："'
												+ data[i].custPartCode
												+ '"已存在于该层BOM，无需重复添加！');
										flag = true;
									}
								}
								if (data[i].custPartCode == null
										|| data[i].custPartCode == "") {
									mini.alert('物料描述："'
											+ data[i].invPartDescriptionC
											+ '"该物料无厂商料号,不能添加为替换料！');
									flag = true;
								}
								if (!flag) {
									bom.addNode(data[i], "after", row);
									bom.addRowCls(data[i], 'Replace');
								}
								bom.addRowCls(row, 'Replace');
							}

						}
					}
				});

	}
	
	function addRow(e){
		  var node = bom.getSelectedNode();
	         if(!node){
	        	 mini.alert("请选择要添加物料的同级物料！");
	        	 return;
	         }
	         mini.open({
					targetWindow : window,
					url : "${pageContext.request.contextPath}/pages/material/BOMsys/bom/bom_edit.jsp",
					title : "添加物料",
					width : 1200,
					height : 817,
					showMaxButton : true,
					allowResize : true,
					onload : function() {
						var iframe = this.getIFrameEl();
					},
					ondestroy : function(action) {
						if (action == "ok") { //如果点击“确定”
							var iframe = this.getIFrameEl();
							//获取选中、编辑的结果
							var data = iframe.contentWindow.getData();
							data = mini.clone(data); //必须。克隆数据。
							var hava = bom.getChildNodes ( bom.getParentNode ( node ) );
							for (var i = 0; i < data.length; i++) {
								data[i].bomType = data[i].ttype;
								data[i].infoid = data[i].id;
								data[i].productid=node.productid;
								if("1"==data[i].bomType) {
									data[i].isLeaf=true;
								}else {
									data[i].isLeaf=false;
									data[i].expanded=false;
								}
								var flag = false;
								for (var j = 0; j < hava.length; j++) {
									if (data[i].custPartCode == hava[j].custPartCode) {
										mini.alert('料号："'
												+ data[i].custPartCode
												+ '"已存在于BOM，无需重复添加！');
										flag = true;
									}
								}
								if (!flag) {
									bom.addNode(data[i], "after", node);
									bom.addRowCls(data[i], 'modify');
								}
							}

						}
					}
				});
	}

	function addSonRow(e) {
         var node = bom.getSelectedNode();
         if(!node){
        	 mini.alert("请选择要添加子物料的产品");
        	 return;
         }
		mini.open({
					targetWindow : window,
					url : "${pageContext.request.contextPath}/pages/material/BOMsys/bom/bom_edit.jsp",
					title : "添加物料",
					width : 1200,
					height : 817,
					showMaxButton : true,
					allowResize : true,
					onload : function() {
						var iframe = this.getIFrameEl();
					},
					ondestroy : function(action) {
						if (action == "ok") { //如果点击“确定”
							var iframe = this.getIFrameEl();
							//获取选中、编辑的结果
							var data = iframe.contentWindow.getData();
							data = mini.clone(data); //必须。克隆数据。
							var hava = bom.getChildNodes ( node );
							for (var i = 0; i < data.length; i++) {
								data[i].bomType = data[i].ttype;
								data[i].infoid = data[i].id;
								data[i].productid=node.infoid;
								if("1"==data[i].bomType) {
									data[i].isLeaf=true;
								}else {
									data[i].isLeaf=false;
									data[i].expanded=false;
								}
								var flag = false;
								for (var j = 0; j < hava.length; j++) {
									if (data[i].custPartCode == hava[j].custPartCode) {
										mini.alert('料号："'
												+ data[i].custPartCode
												+ '"已存在于BOM，无需重复添加！');
										flag = true;
									}
								}
								if (!flag) {
									bom.addNode(data[i], "add", node);
									bom.addRowCls(data[i], 'modify');
								}
							}

						}
					}
				});
	}

	function removeRow() {
		var row = bom.getSelectedNode();
		if (!row) {
			mini.alert("请选择要删除的物料");
			return;
		}
		if (confirm("确定删除？")) {
			bom.removeNode(row);
		}
	}

	function onStatusChanged() {
		var data = form.getData(true);
		material.load(data);
	}

	function startEdit() {
		if (nowVersion == maxVersion) {
			$("#startEdit").hide();
			$("#endEdit").show();
			$("#editView").slideDown("slow");
			bom.setAllowCellSelect(true);
			bom.setAllowCellEdit(true);
		} else {
			mini.alert("历史版本不允许编辑！");
		}
	}

	function reloadRow() {
		if (bom.getChanges().length > 0) {
			if (confirm("有增删改的数据未保存，确定重置？")) {
				var data = bomForm.getData(true);
				data.productid = productid;
				bom.load(data);
			}
		}
	}

	function endEdit() {
		if (bom.getChanges().length > 0) {
			if (!confirm("有增删改的数据未保存，确定继续操作？")) {
				mini.get("version").setValue(maxVersion);
				return;
			}
		}
		$("#startEdit").show();
		$("#editView").hide();
		$("#endEdit").hide();
		bom.setAllowCellSelect(false);
		bom.setAllowCellEdit(false);
		var data = bomForm.getData(true);
		data.productid = productid;
		bom.load(data);
	}

	function viewDate(e) {
		if (e.value) {
			return mini.formatDate(new Date(e.value), 'yyyy-MM-dd HH:mm:ss');
		}
	}

	function loadprodSupper() {
		var url = mini.get("prodSupper").getUrl();
		if (!url) {
			url = "${pageContext.request.contextPath}/encoding/getProdSupper.do";
			mini.get("prodSupper").setUrl(url);
		}
	}

	function loadpackage() {
		var url = mini.get("package_").getUrl();
		if (!url) {
			var url = "${pageContext.request.contextPath}/package/getAllpackage.do";
			mini.get("package_").setUrl(url);
		}
	}

	function loadsupplierPtr() {
		var url = mini.get("supplierPtr").getUrl();
		if (!url) {
			var url = "${pageContext.request.contextPath}/encoding/getAllSupplier.do";
			mini.get("supplierPtr").setUrl(url);
		}
	}

	function onClassChanged() {
		var maxclass = mini.get("maxclass");
		var bigclassid = maxclass.getValue();
		var url = "${pageContext.request.contextPath}/class/getSmallClassPre.do?nottype=1&bigclassid="
				+ bigclassid;
		mini.get("prodCodeSellPtr").setUrl(url);
	}

	function search() {
		materialForm.validate();
		if (materialForm.isValid() == false) {
			return;
		}
		var data = materialForm.getData(true);
		data.status = 9;
		data.nottype = 1;
		material.load(data);
	}

	function searchBom() {
		var data = bomForm.getData(true);
		nowVersion = data.version;
		endEdit();
	}

	function resetForm() {
		bomForm.reset();
	}

	function resetForm() {
		materialForm.reset();
	}

	function viewBOMInfo() {
		var row = material.getSelected();
		if (!row) {
			mini.alert("请选择要查看BOM表的产品");
			return;
		}
		$("#materialGridView").hide();
		$("#materialBarView").hide();
		$("#materialFormView").hide();
		$("#bomGridView").show();
		$("#bomBarView").show();
		$("#bomFormView").show();
		var data = {};
		data.productid = row.id;
		productid = row.id;
		bom.load(data);
		loadVersionDate();
	}

	function loadVersionDate() {
		var url = "${pageContext.request.contextPath}/bom/getAllVersion.do?productid="
				+ productid;
		mini.get("version").setUrl(url);
		mini.get("version").select(0);
		maxVersion = mini.get("version").getValue();
		nowVersion = mini.get("version").getValue();
	}

	function goback() {
		if (bom.getChanges().length > 0) {
			if (!confirm("有增删改的数据未保存，确定继续操作？")) {
				return;
			}
		}
		$("#materialGridView").show();
		$("#materialBarView").show();
		$("#bomGridView").hide();
		$("#bomBarView").hide();
		$("#startEdit").show();
		$("#editView").hide();
		$("#endEdit").hide();
		$("#materialFormView").show();
		$("#bomFormView").hide();
		bom.setAllowCellSelect(false);
		bom.setAllowCellEdit(false);
		bom.clearRows();
	}

	function importBOM() {
		var row = material.getSelected();
		if (!row) {
			mini.alert("请选择要导入BOM表的产品");
			return;
		}
		//BOM基础版是否存在如存在则提醒不能导入
		var para = {};
		para.productid = row.id;
		var can = true;
		$.ajax({
			url : "${pageContext.request.contextPath}/bom/canImportBom.do",
			type : "post",
			dataType : "json",
			data : para,
			async : false,
			success : function(data) {
				if (data.success) {
					if (!data.can) {
						mini.alert("该产品基础BOM已存在，请确认。");
						can = false;
					}
				} else {
					mini.alert("系统异常：" + data.message);
					can = false;
				}
			}
		});
		if (!can) {
			return;
		}
		mini
				.open({
					targetWindow : window,
					url : "${pageContext.request.contextPath}/pages/material/BOMsys/bom/product_import.jsp",
					title : "导入BOM表",
					width : 394,
					height : 222,
					showMaxButton : true,
					allowResize : true,
					onload : function() {
						var iframe = this.getIFrameEl();
						iframe.contentWindow.SetData(row);
					},
					ondestroy : function(action) {
						material.reload();
					}
				});
	}
</script>