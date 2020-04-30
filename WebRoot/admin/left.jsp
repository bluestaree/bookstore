<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>菜单</title>
<link href="${pageContext.request.contextPath}/css/manage/left.css" rel="stylesheet" type="text/css"/>
<link rel="StyleSheet" href="${pageContext.request.contextPath}/css/manage/dtree.css" type="text/css" />
</head>
<body>
<table width="100" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="12"></td>
  </tr>
</table>
<table width="100%" border="0" >
  <tr>
    <td id="frmtitle" >
<div class="dtree"  >

	<a href="javascript: d.openAll();">展开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/dtree.js"></script>
	<script type="text/javascript">
		<!--
		d = new dTree('d');
		d.add('01',-1,'系统菜单树');
		d.add('0101','01','用户管理','','','mainFrame');
		d.add('010101','0101','会员用户','${pageContext.request.contextPath}/adminGeneralUser_findAll?page=1','','mainFrame');
		d.add('010102','0101','管理员用户','${pageContext.request.contextPath}/adminUser_findAll','','mainFrame');
		d.add('0102','01','一级分类管理','','','mainFrame');
		d.add('010201','0102','一级分类管理','${pageContext.request.contextPath}/adminCategory_findAll','','mainFrame');
		d.add('0103','01','二级分类管理');
		d.add('010301','0103','二级分类管理','${pageContext.request.contextPath}/adminCategorySecond_findAll?page=1','','mainFrame');
		d.add('0104','01','商品管理');
		d.add('010401','0104','商品管理','${pageContext.request.contextPath}/adminProduct_findAll?page=1','','mainFrame');
		d.add('0105','01','订单管理');
		d.add('010501','0105','订单管理','${pageContext.request.contextPath}/adminOrder_findAll?page=1','','mainFrame');
		d.add('0106','01','销售统计');
		d.add('010601','0106','销售统计','${pageContext.request.contextPath}/adminUser_statistics?scop=1','','mainFrame');
		document.write(d);
		//-->
	</script>
</div>	
</td>
 </tr>
</table>
</body>
</html>