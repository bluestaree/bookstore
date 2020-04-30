<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>    
<html>
<head>
<meta http-equiv=Content-Type content="text/html; charset=utf-8">
<title>商品管理</title>
<link href="${pageContext.request.contextPath}/css/manage/style.css" type="text/css" rel="stylesheet" media="all" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/jquery.1.4.2-min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/manage/main.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#reset").click(function(){
			location.reload();
		});
		$("#back").click(function(){
			location.href = "${pageContext.request.contextPath}/adminProduct_findAll?page=1";
		});
		
		$("#form1").submit(function(){
			if($("#pname").val().length < 1){
				$("#pname_tip").css("display","inline").text("请输入图书名");
				$("#pname").css("border-color","red").focus();
				return false;
			}
			if($("#author").val().length < 1){
				$("#author_tip").css("display","inline").text("请输入作者名称");
				$("#author").css("border-color","red").focus();
				return false;
			}
			if($("#press").val().length < 1){
				$("#press_tip").css("display","inline").text("请填写出版社名称");
				$("#press").css("border-color","red").focus();
				return false;
			}
			if($("#market_price").val().length < 1){
				$("#market_price_tip").css("display","inline").text("请输入市场价");
				$("#market_price").css("border-color","red").focus();
				return false;
			}
			if($("#shop_price").val().length < 1){
				$("#shop_price_tip").css("display","inline").text("请输入商城价");
				$("#shop_price").css("border-color","red").focus();
				return false;
			}
		});
		
		$("#form1 input").change(function(){
	      	var $text = $(this).attr("name");
	      	$("#"+$text+"_tip").css("display","none");
	      	$(this).css("border-color","");
		 });
	});
	
</script>
</head>
<body>
  <div style="background-color: #E7E7E7;border-radius: 20px;padding: 5px;margin-right: 5px;margin-top: 5px;margin-left: 5px;">
            <a href="${pageContext.request.contextPath}/admin/welcome.jsp" style="margin-left: 15px;margin-right: 15px;">主页</a>&gt;&gt;
            <a href="${pageContext.request.contextPath}/adminProduct_findAll?page=1" style="margin-left: 15px;margin-right: 15px;">商品管理</a>&gt;&gt;
            <a style="margin-left: 15px;margin-right: 15px;">添加</a>
   </div>
	<form id="form1" action="${pageContext.request.contextPath}/adminProduct_save" method="post" enctype="multipart/form-data">
	<table width="100%">
			<tbody>
				<tr>
				<td valign="top">
						<div class="title"><h2>添加商品</h2></div>
						<div class="maincon">
					<table class="formtable" width="100%">
						<tr>
							<td width="180px" align="right"><span style="color: red">* </span>商品名称：</td>
							<td width="210px">
								<div class="stext"><input type="text" id="pname" name="pname" value=""  style="width:180px;" /><span id="pname_tip" style="margin-left: 15px;display: none;color: red"></span></div>
							</td>
							<td width="180px" align="right"><span style="color: red">* </span>所属二级分类：</td>
							<td>
								<select name="categorySecond.csid">
									<s:iterator var="cs" value="csList">
										<option value="<s:property value="#cs.csid" />"><s:property value="#cs.csname" /> </option>
									</s:iterator>
								</select>
							</td>
						</tr>
						<tr>
							<td width="180px" align="right"><span style="color: red">* </span>作者：</td>
							<td width="210px">
								<div class="stext"><input type="text" id="author" name="author" value=""  style="width:120px;" /><span id="author_tip" style="margin-left: 15px;display: none;color: red"></span></div>
							</td>
							<td width="180px" align="right"><span style="color: red">* </span>出版社：</td>
							<td>
								<div class="stext"><input type="text" id="press" name="press" value=""  style="width:120px;" /><span id="press_tip" style="margin-left: 15px;display: none;color: red"></span></div>
							</td>
						</tr>
						<tr>
							<td width="180px" align="right"><span style="color: red">* </span>市场价格：</td>
							<td width="210px">
								<div class="stext"><input type="text" id="market_price" name="market_price" value=""  style="width:100px;" /><span id="market_price_tip" style="margin-left: 15px;display: none;color: red"></span></div>
							</td>
							<td width="180px" align="right"><span style="color: red">* </span>商城价格：</td>
							<td>
								<div class="stext"><input type="text" id="shop_price" name="shop_price" value=""  style="width:100px;" /><span id="shop_price_tip" style="margin-left: 15px;display: none;color: red"></span></div>
							</td>
						</tr>
						<tr>
							<td width="180px" align="right">商品图片：</td>
							<td width="210px">
							<input type="file" name="upload" style="width:180px;"><span id="shop_price_tip" style="margin-left: 15px;color: red"><s:fielderror /></span>
							</td>
							<td width="180px" align="right"><span style="color: red">* </span>是否热门：</td>
							<td>
								<select name="is_hot">
									<option value="1">是</option>
									<option value="0">否</option>
								</select>
							</td>
						</tr>
						<tr>
							<td width="180px" align="right"><span style="color: red">* </span>商品简介：</td>
							<td colspan="3">
								<div class="stext"><input type="text" id="spoint" name="spoint" value=""  style="width: 580px;" /><span id="tip" style="margin-left: 15px;display: none;color: red"></span></div>
							</td>
						</tr>
						<tr>
							<td width="180px" align="right">内容简介：</td>
							<td width="210px">
								<textarea rows="6" cols="40" name="pdesc"></textarea>
							</td>
							<td width="180px" align="right">作者简介：</td>
							<td>
								<textarea rows="6" cols="40" name="adesc"></textarea>
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