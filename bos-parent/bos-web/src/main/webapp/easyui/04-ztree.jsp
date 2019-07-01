<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ztree</title>
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/easyui/themes/icon.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/js/ztree/zTreeStyle.css">

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/ztree/jquery.ztree.all.js"></script>
	</head>
	<body class="easyui-layout">
		<div title="XXX管理系统" style="height: 100px" data-options="region:'north'">北部区域</div>
		<div title="系统菜单" style="width: 200px" data-options="region:'west'">
			<div class="easyui-accordion" data-options="fit:true">
				<div title="面板二">
					<!-- 标准json数据构建 -->
					<ul id="zt1" class="ztree"></ul>
					<script type="text/javascript">
						$(function(){
							var setting = {
									
									
							}
						});
					</script>
				</div>
			
			</div>
		</div>
		<div style="width: 100px" data-options="region:'east'">东部区域</div>
		<div style="height: 50px" data-options="region:'south'">南部区域</div>
	</body>
</html>