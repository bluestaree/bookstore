<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<title>商品管理</title>
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
			location.href = "${pageContext.request.contextPath}/adminProduct_addPage";
		});
	});
</script>

</head>
<body>
  <div style="background-color: #E7E7E7;border-radius: 20px;padding: 5px;margin-right: 5px;margin-top: 5px;margin-left: 5px;">
            <a href="${pageContext.request.contextPath}/admin/welcome.jsp" style="margin-left: 15px;margin-right: 15px;">主页</a>&gt;&gt;
            <a style="margin-left: 15px;margin-right: 15px;">商品管理</a>
            
   </div>
	<table width="100%" height="100%" style="background:#EAEAEA;">
		<tr>
			<td height="100%" bgcolor="#ffffff">
				<table width="100%" height="100%" >
					<tbody>
						<tr> 
							<td valign="top">
								<div class="title"><h2>商品列表</h2></div>
								<div class="maincon">
									<div align="right"> 
									<span style="margin-right: 30px;font-size:  14px;">总记录数  ：  <s:property value="pageBean.totalCount"/></span><button id="add" style="margin-bottom: 10px;margin-right: 20px;width: 89px;height: 35px; line-height: 35px; cursor: pointer; 
									background: url(${pageContext.request.contextPath}/images/manage/btn.gif) no-repeat; border: 0; font-size: 14px;">添&nbsp;&nbsp;&nbsp;加</button></div>
									<table class="tablelist" width="100%">
										<tr>
											<th>序号</th>
											<th>商品图片</th>
											<th>商品名称</th>
											<th>作者</th>
											<th>出版社</th>
											<th>价格</th>
											<th>是否热门</th>
											<th>操作</th>
										</tr>
										<s:iterator var="p" value="pageBean.list" status="vs">
											<tr>
												<td><s:property value="#vs.count"/> </td>
												<td> <img width="40" height="40" src="${pageContext.request.contextPath}/<s:property value="#p.image"/>"> </td>
												<td><s:property value="#p.pname"/></td>
												<td><s:property value="#p.author"/></td>
												<td><s:property value="#p.press"/></td>
												<td><s:property value="#p.shop_price"/>0</td>
												<td>
													<s:if test="#p.is_hot == 1">
														<span style="color:#ff6600;">是</span>
													</s:if>
													<s:else>
														<span>否</span>
													</s:else>
												</td>
												<td>
													<a style="color:#3366cc;" href="${pageContext.request.contextPath}/adminProduct_editPage?pid=<s:property value="#p.pid"/>">编辑</a><span class="lr10">|</span>
													<a style="color:#ff6600;" href="javascript:void(0);" title1="${pageContext.request.contextPath}/adminProduct_delete?pid=<s:property value="#p.pid"/>" class="alert-api-button alert-btn4">删除</a>
												</td>
											</tr>
										</s:iterator>
									</table>
									<div class="pagination">
										 <s:if test="pageBean.page == 1">
											<a class="disabled">&lt;&lt; 首页</a>
											<a class="disabled">&lt; 上一页</a>
										 </s:if>
										 <s:else>
										 	<a href="${pageContext.request.contextPath}/adminProduct_findAll?page=1">&lt;&lt; 首页</a>
											<a href="${pageContext.request.contextPath}/adminProduct_findAll?page=<s:property value="pageBean.page - 1"/>">&lt; 上一页</a>
										 </s:else>
										 <!-- 动态显示条 -->
							       		 <s:iterator begin="pageBean.start" end="pageBean.end" var="num">
							       		 	<s:if test="pageBean.page != #num">
							        	  		<a href="${pageContext.request.contextPath}/adminProduct_findAll?page=<s:property value="#num"/>" ><s:property value="#num"/></a>
							        	  	</s:if>
							        	  	<s:else>
							        	  		<a class="current"><s:property value="#num"/></a>
							        	  	</s:else>
							      		 </s:iterator>
										<s:if test="pageBean.page == pageBean.totalPage">
											<a class="disabled">&gt; 下一页</a>
											<a class="disabled">&gt;&gt; 尾页</a>
										 </s:if>
										 <s:else>
										 	<a href="${pageContext.request.contextPath}/adminProduct_findAll?page=<s:property value="pageBean.page + 1"/>">下一页&gt;</a>
											<a href="${pageContext.request.contextPath}/adminProduct_findAll?page=<s:property value="pageBean.totalPage"/>">尾页&gt;&gt;</a>
										 </s:else>
									</div>
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