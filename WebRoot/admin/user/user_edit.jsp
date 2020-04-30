<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<title>会员管理</title>
<link href="${pageContext.request.contextPath}/css/manage/style.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/jquery.1.4.2-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/main.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#back").click(function(){
			location.href = "${pageContext.request.contextPath}/adminGeneralUser_findAll?page=1";
		});
	});
</script>
</head>
<body>
  <div style="background-color: #E7E7E7;border-radius: 20px;padding: 5px;margin-right: 5px;margin-top: 5px;margin-left: 5px;">
            <a href="${pageContext.request.contextPath}/admin/welcome.jsp" style="margin-left: 15px;margin-right: 15px;">主页</a>&gt;&gt;
            <a href="${pageContext.request.contextPath}/adminGeneralUser_findAll?page=1" style="margin-left: 15px;margin-right: 15px;">会员管理</a>&gt;&gt;
            <a style="margin-left: 15px;margin-right: 15px;">编辑</a>
   </div>
	<form id="form1" action="${pageContext.request.contextPath}/adminGeneralUser_edit" method="post">
		<input type="hidden" name="uid" value="<s:property value="model.uid"/>"/>
	<table width="100%">
			<tbody>
				<tr>
				<td valign="top">
						<div class="title"><h2>编辑</h2></div>
						<div class="maincon">
						<div align="left" style="margin-bottom: 20px;"> 
								<span style="margin-left: 40px;font-size:  14px;">修改对象  ：  <s:property value="model.username"/></span>
						</div>
					<table class="formtable" width="100%">
						<tr>
							<td  width="180px" align="right"><span style="color: red">* </span>用户状态：</td>
							<td>
								<select name="state" style="width: 60px">
									<option value="1" <s:if test="model.state == 1">selected</s:if>>正常</option>
									<option value="0" <s:if test="model.state == 0">selected</s:if>>冻结</option>
								</select>
							</td>
						</tr>
						 <tr align="center">
							<td style="border:0;" colspan="4">
								<input type="submit" value="确    定"class="btn-img"  style="margin-right: 50px;"/>
								<input type="button" value="返   回" id="back"  class="btn-img"  />
							</td>
						</tr>
					</table>
				</div>
		   </td>
		   </tr>
		</tbody>
	</table>
</form>
</body>
</html>