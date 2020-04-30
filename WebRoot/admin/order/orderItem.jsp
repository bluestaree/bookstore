<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<h4 align="center">订  单  详  情</h4>
<hr style="margin-bottom: 10px;" />
<table boder="0" width="100%">
		<s:iterator var="orderItem" value="list">
			<tr >
				<td rowspan="4"><img width="100px" height="100px" style="margin-top: 10px;" src="${pageContext.request.contextPath}/<s:property value="#orderItem.product.image"/>" /></td>
			</tr>
			<tr>
				<td><h5 style="color: #000;margin-bottom: 5px;margin-left: 10px;font-weight: unset;margin-top: 15px;"><s:property value="#orderItem.product.pname"/></h5></td>
			</tr>
			<tr>
				<td><div style="font-size:12px;color: #777;margin-bottom: 10px;margin-left: 10px;margin-top: 10px;">作者：<s:property value="#orderItem.product.author"/>&nbsp;&nbsp;&nbsp;&nbsp;出版社：<s:property value="#orderItem.product.press"/></div></td>
			</tr>
			<tr>
				<td><div class="price" style="margin-top: 3px;margin-bottom: 15px;margin-left: 10px;"><font color="red" style="font-size: 15px"> <s:property value="#orderItem.count"/></font> x ¥ <s:property value="#orderItem.product.shop_price"/>0  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;    小计：¥<s:property value="#orderItem.subtotal"/>0</div></td>
			</tr>
		</s:iterator>
</table>
