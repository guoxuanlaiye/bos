<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ztree</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/easyui/jquery.easyui.min.js"></script> 
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ztree/zTreeStyle.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ztree/jquery.ztree.all-3.5.js"></script>
	</head>
	<body class="easyui-layout">
		<div title="XXX管理系统" style="height: 100px" data-options="region:'north'">北部区域</div>
		<!-- 左侧区域，菜单栏 -->
		<div title="系统菜单" style="width: 200px" data-options="region:'west'">
			<div class="easyui-accordion" data-options="fit:true">
				<div title="面板一">
					<!-- 标准json数据构建 -->
					<ul id="zt1" class="ztree"></ul>
					<script type="text/javascript">
						$(function(){
							// 页面加载完成后加载
							// setting 配置
							var setting = {};
							var zNodes = [
								{"name":"节点1","children":[
									{"name":"节点11"},
									{"name":"节点12"},
									{"name":"节点13"}
									]},
								{"name":"节点2"},
								{"name":"节点3"}
							];
							// 调用api初始化ztree
							$.fn.zTree.init($("#zt1"),setting,zNodes);
							
						});
					</script>
				</div>
				<div title="面板二">
					<ul id="zt2" class="ztree"></ul>
					<script type="text/javascript">
						$(function(){
							var setting2 = {
								data:{
									/* 确定层级的key */
									simpleData:{
										enable:true
										/* idKey:"id",
										pIdKey:"pId",
										rootPId:"0" */
									}
								}
							};
							var zNodes2 = [
								{"id":"1","pId":"0","name":"节点1"},
								{"id":"2","pId":"1","name":"节点2"},
								{"id":"3","pId":"2","name":"节点3"}
							];
							$.fn.zTree.init($("#zt2"),setting2,zNodes2);
						});
					</script>
				</div>
				<!-- ajax请求数据 -->
				<div title="面板三">
					<ul id="zt3" class="ztree"></ul>
					<script type="text/javascript">
						$(function(){
							var setting3 = {
								data:{
									/* 确定层级的key */
									simpleData:{
										enable:true
										/* idKey:"id",
										pIdKey:"pId",
										rootPId:"0" */
									}
								},
								callback:{
									/* 绑定双击事件 */
									/* onDblClick: */
									onClick:function(event,treeId,treeNode){
										// page存在
										if(treeNode.page != undefined){
											var e = $("#mytabs").tabs("exists",treeNode.name);
											if (e) {
												$("#mytabs").tabs("select",treeNode.name);
											} else {
												// 动态添加选项卡
												$("#mytabs").tabs("add",{
													title:treeNode.name,
													closable:true,
													content:'<iframe frameborder="0" width="100%" height="100%" src="'+treeNode.page+'"></iframe>'
												});
											}
										} 
									}
								}
							};
							var url = "${pageContext.request.contextPath}/json/menu.json";
							$.post(url,{},function(data){
								$.fn.zTree.init($("#zt3"),setting3,data);
							},'json');
							
						});
					</script>
				</div>
			</div>
		</div>
		<!-- 中心区域 -->
		<div data-options="region:'center'">
		<!-- 制作一个tabs选项卡面板 -->
			<div id="mytabs" class="easyui-tabs" data-options="fit:true">
				<!-- 使用子div表示每个面板 -->
				<div data-options="iconCls:'icon-cut'" title="面板一">1111</div>
				<div data-options="closable:true" title="面板二">2222</div>
				<div title="面板三">3333</div>
			</div>
		</div>
		<div style="width: 100px" data-options="region:'east'">东部区域</div>
		<div style="height: 50px" data-options="region:'south'">南部区域</div>
	</body>
</html>