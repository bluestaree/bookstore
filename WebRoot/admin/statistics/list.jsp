<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<title>销售统计</title>
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
		$("#changeSchedule").change(function(){
			location.href = "${pageContext.request.contextPath}/adminUser_statistics?scop="+$(this).val();
		});
 	});
  </script>
</head>
<body>
  <div style="background-color: #E7E7E7;border-radius: 20px;padding: 5px;margin-right: 5px;margin-top: 5px;margin-left: 5px;">
            <a href="${pageContext.request.contextPath}/admin/welcome.jsp" style="margin-left: 15px;margin-right: 15px;">主页</a>&gt;&gt;
            <a style="margin-left: 15px;margin-right: 15px;">销售统计</a>
            
   </div>
	<table width="100%" height="100%" style="background:#EAEAEA;">
		<tr>
			<td height="100%" bgcolor="#ffffff">
				<table width="100%" height="100%" >
					<tbody>
						<tr> 
							<td valign="top">
								<div class="title"><h2>销售统计</h2></div>
								<div class="maincon">
									<div align="left" style="margin-bottom: 20px;"> 
										<span style="margin-left: 40px;font-size:  14px;">
											统计区间  ：
											<select name="schedule" id="changeSchedule">
												<option value="1" <s:if test="scop == 1">selected</s:if>>每日</option>
												<option value="2" <s:if test="scop == 2">selected</s:if>>每月</option>
												<option value="3" <s:if test="scop == 3">selected</s:if>>每年</option>
											</select>
										</span>
									</div>
									<table class="tablelist" width="100%">
										<tr>
											<th>序号</th>
											<th>时间段</th>
											<th>订单总数</th>
											<th>成交订单</th>
											<th>成交额</th>
											<th>利润</th>
											<th>订单总金额</th>
										</tr>
										<s:set var="num1" value="0" ></s:set>
										<s:set var="num2" value="0" ></s:set>
										<s:set var="num3" value="0" ></s:set>
										<s:set var="num4" value="0" ></s:set>
										<s:set var="num5" value="0" ></s:set>
										<s:iterator var="s" value="list" status="vs">
											<tr>
												<td><s:property value="#vs.count"/> </td>
												<s:if test="scop == 1">
													<td><s:date name="#s.schedule" format="yyyy-MM-dd" /></td>
												</s:if>
												<s:else>
													<td><s:property value="#s.schedule"/></font></td>
												</s:else>
												<td><font><s:property value="#s.count"/></font> </td>
												<td><font color="blue"><s:property value="#s.deal"/>&nbsp;&nbsp;(<s:property value="#s.deal *10 / #s.count * 10"/>%)</font></td>
												<td><font color="#2dd334"><s:property value="#s.dealtotal"/></font> </td>
												<s:if test="#s.dealtotal != 0">
													<td><font color="#2dd334"><s:property value="#s.dealtotal - #s.dealtotal * 0.1"/></font> </td>
													<s:set var="num5" value="#num5 + #s.dealtotal - #s.dealtotal * 0.1" ></s:set>
												</s:if>
												<s:else>
													<td><font color="#2dd334">0</font></td>
												</s:else>
												<td><font color="red"><s:property value="#s.total"/></font> </td>
											</tr>
											<s:set var="num1" value="#num1 + #s.count" ></s:set>
											<s:set var="num2" value="#num2 + #s.total" ></s:set>
											<s:set var="num3" value="#num3 + #s.deal" ></s:set>
											<s:set var="num4" value="#num4 + #s.dealtotal" ></s:set>
										</s:iterator>
										<tr>
											<td colspan="2"><font ><b>总&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 计</b></font></td>
											<td><s:property value="#num1"/></td>
											<td><font color="blue"><s:property value="#num3"/>&nbsp;&nbsp;(<s:property value="#num3 *10/ #num1 *10" />%)</font> </td>
											<td><font color="#2dd334"><s:property value="#num4"/></font> </td>
											<td><font color="#2dd334"><s:property value="#num5"/></font> </td>
											<td><font color="red"><s:property value="#num2"/></font></td>
										</tr>
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