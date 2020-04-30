<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<title>一级分类管理</title>
<link href="${pageContext.request.contextPath}/css/manage/style.css" type="text/css" rel="stylesheet" media="all" />

 <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js" ></script>
   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/js/SyntaxHighlighter/shCoreDefault.css">
  <!--弹出层样式-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/alert.css">
  
  <script src="${pageContext.request.contextPath}/js/SyntaxHighlighter/shCore.js"></script>
  <script src="${pageContext.request.contextPath}/js/SyntaxHighlighter/makeSy.js"></script>
  <!--弹出层代码-->
  <script src="${pageContext.request.contextPath}/js/alert.js"></script>
  <script src="${pageContext.request.contextPath}/js/alert-api.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		$("#add").click(function(){
			location.href = "${pageContext.request.contextPath}/admin/category/add.jsp";
		});
	});
</script>

</head>
<body>
  <div style="background-color: #E7E7E7;border-radius: 20px;padding: 5px;margin-right: 5px;margin-top: 5px;margin-left: 5px;">
            <a href="${pageContext.request.contextPath}/admin/welcome.jsp" style="margin-left: 15px;margin-right: 15px;">主页</a>&gt;&gt;
            <a style="margin-left: 15px;margin-right: 15px;">一级分类管理</a>
            
   </div>
	<table width="100%" height="100%" style="background:#EAEAEA;">
		<tr>
			<td height="100%" bgcolor="#ffffff">
				<table width="100%" height="100%" >
					<tbody>
						<tr> 
							<td valign="top">
								<div class="title"><h2>一级分类列表</h2></div>
								<div class="maincon">
									<div align="right"><button id="add" style="margin-bottom: 10px;margin-right: 20px;width: 89px;height: 35px; line-height: 35px; cursor: pointer; 
									background: url(${pageContext.request.contextPath}/images/manage/btn.gif) no-repeat; border: 0; font-size: 14px;">添&nbsp;&nbsp;&nbsp;加</button></div>
									<table class="tablelist" width="100%">
										<tr>
											<th>序号</th>
											<th>一级分类名称</th>
											<th>操作</th>
										</tr>
										<s:iterator var="c" value="cList" status="vs">
											<tr>
												<td><s:property value="#vs.count"/> </td>
												<td><s:property value="#c.cname"/></td>
												<td>
													<a style="color:#3366cc;" href="${pageContext.request.contextPath}/adminCategory_editPage?cid=<s:property value="#c.cid"/>">编辑</a><span class="lr10">|</span>
													<a style="color:#ff6600;" href="javascript:void(0);" title1="${pageContext.request.contextPath}/adminCategory_delete?cid=<s:property value="#c.cid"/>" class="alert-api-button alert-btn4">删除</a>
												</td>
											</tr>
										</s:iterator>
									</table>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>