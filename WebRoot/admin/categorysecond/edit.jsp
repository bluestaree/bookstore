<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<title>二级分类管理</title>
<link href="${pageContext.request.contextPath}/css/manage/style.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/jquery.1.4.2-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/main.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#reset").click(function(){
			$("#csname").val("");
		});
		$("#back").click(function(){
			location.href = "${pageContext.request.contextPath}/adminCategorySecond_findAll?page=1";
		});
		
		$("#form1").submit(function(){
			if($("#csname").val().length < 1){
				$("#tip").css("display","inline").text("请输入二级分类名称");
				$("#csname").css("border-color","red").focus();
				return false;
			}
		});
	});
	
</script>
</head>
<body>
  <div style="background-color: #E7E7E7;border-radius: 20px;padding: 5px;margin-right: 5px;margin-top: 5px;margin-left: 5px;">
            <a href="${pageContext.request.contextPath}/admin/welcome.jsp" style="margin-left: 15px;margin-right: 15px;">主页</a>&gt;&gt;
            <a href="${pageContext.request.contextPath}/adminCategorySecond_findAll?page=1" style="margin-left: 15px;margin-right: 15px;">二级发分类管理</a>&gt;&gt;
            <a style="margin-left: 15px;margin-right: 15px;">编辑</a>
   </div>
	<form id="form1" action="${pageContext.request.contextPath}/adminCategorySecond_edit" method="post">
		<input type="hidden" name="csid" value="<s:property value="model.csid" />" />
	<table width="100%">
			<tbody>
				<tr>
				<td valign="top">
						<div class="title"><h2>编辑二级分类</h2></div>
						<div class="maincon">
					<table class="formtable" width="100%">
						<tr>
							<td width="180px" align="right">二级分类名称：</td>
							<td>
								<div class="stext"><input type="text" id="csname" name="csname" value="<s:property value="model.csname" />"  style="width:180px;" /><span id="tip" style="margin-left: 15px;display: none;color: red"></span></div>
							</td>
							<td width="180px" align="right">所属一级分类：</td>
							<td>
								<select name="category.cid">
									<s:iterator var="c" value="cList">
										<option value="<s:property value="#c.cid" />" <s:if test="model.category.cid == #c.cid">selected</s:if>><s:property value="#c.cname" /> </option>
									</s:iterator>
								</select>
							</td>
						</tr>
						 <tr align="center">
							<td style="border:0;" colspan="4">
								<input type="submit" value="确    定"class="btn-img"  style="margin-right: 50px;"/>
								<button type="reset" id="reset" class="btn-img" style="margin-right: 50px;" >重&nbsp;&nbsp;&nbsp;&nbsp;置</button>
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