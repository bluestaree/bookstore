<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<title>订单管理</title>
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
</head>
<body>
  <div style="background-color: #E7E7E7;border-radius: 20px;padding: 5px;margin-right: 5px;margin-top: 5px;margin-left: 5px;">
            <a href="${pageContext.request.contextPath}/admin/welcome.jsp" style="margin-left: 15px;margin-right: 15px;">主页</a>&gt;&gt;
            <a style="margin-left: 15px;margin-right: 15px;">订单管理</a>
            
   </div>
	<table width="100%" height="100%" style="background:#EAEAEA;">
		<tr>
			<td height="100%" bgcolor="#ffffff">
				<table width="100%" height="100%" >
					<tbody>
						<tr> 
							<td valign="top">
								<div class="title"><h2>订单列表</h2></div>
								<div class="maincon">
									<div align="right" style="margin-bottom: 20px;"> 
										<span style="margin-right: 40px;font-size:  14px;">总记录数  ：  <s:property value="pageBean.totalCount"/></span>
									</div>
									<table class="tablelist" width="100%">
										<tr>
											<th>序号</th>
											<th>订单编号</th>
											<th>用户</th>
											<th>收货人</th>
											<th>收货地址</th>
											<th>联系电话</th>
											<th>总金额</th>
											<th>订单状态</th>
											<th>操作</th>
										</tr>
										<s:iterator var="o" value="pageBean.list" status="vs">
											<tr>
												<td><s:property value="#vs.count"/> </td>
												<td><s:property value="#o.oid"/> </td>
												<td><s:property value="#o.user.username"/> </td>
												<td><s:property value="#o.name"/></td>
												<td><s:property value="#o.addr"/></td>
												<td><s:property value="#o.phone"/></td>
												<td><font color="red"><s:property value="#o.total"/>0</font></td>
												<td>
													<s:if test="#o.state == 1">
														<font color="blue">未付款</font>
													</s:if>
													<s:if test="#o.state == 2">
														<a  href="${pageContext.request.contextPath}/adminOrder_updateState?oid=<s:property value="#o.oid"/>" style="color: red">确认发货</a>
													</s:if>
													<s:if test="#o.state == 3">
														<font color="#FFC107">等待确认收货</font>
													</s:if>
													<s:if test="#o.state == 4">
														<font color="#2dd334">交易完成</font>
													</s:if>
												</td>
												<td align="center">
													<button title1="<s:property value="#o.oid"/>"  class="alert-api-button alert-btn5" style="width: 89px;height: 35px;margin-bottom: 10px; line-height: 35px; cursor: pointer; 
									background: url(${pageContext.request.contextPath}/images/manage/btn.gif) no-repeat; border: 0;"><span style="width: 89px;height: 35px;">查看订单详情</span></button>
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
										 	<a href="${pageContext.request.contextPath}/adminOrder_findAll?page=1">&lt;&lt; 首页</a>
											<a href="${pageContext.request.contextPath}/adminOrder_findAll?page=<s:property value="pageBean.page - 1"/>">&lt; 上一页</a>
										 </s:else>
										 <!-- 动态显示条 -->
							       		 <s:iterator begin="pageBean.start" end="pageBean.end" var="num">
							       		 	<s:if test="pageBean.page != #num">
							        	  		<a href="${pageContext.request.contextPath}/adminOrder_findAll?page=<s:property value="#num"/>" ><s:property value="#num"/></a>
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
										 	<a href="${pageContext.request.contextPath}/adminOrder_findAll?page=<s:property value="pageBean.page + 1"/>">下一页&gt;</a>
											<a href="${pageContext.request.contextPath}/adminOrder_findAll?page=<s:property value="pageBean.totalPage"/>">尾页&gt;&gt;</a>
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