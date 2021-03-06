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
		$("#reset").click(function(){
			location.reload();
		});
		$("#back").click(function(){
			location.href = "${pageContext.request.contextPath}/adminGeneralUser_findAll?page=1";
		});
		
		$("#form1").submit(function(){
			if($("#username").val().length < 3){
				$("#username_tip").css("display","inline").text("请输入用户名，且必须是3位以上数字或字母组成");
				$("#username").css("border-color","red").focus();
				return false;
			}
			if($("#password").val().length < 3){
				$("#password_tip").css("display","inline").text("请输入密码，且必须是3位以上数字或字母组成");
				$("#password").css("border-color","red").focus();
				return false;
			}
			if($("#repassword").val() != $("#password").val()){
				$("#repassword_tip").css("display","inline").text("两次输入的密码不一致");
				$("#repassword").css("border-color","red").focus();
				return false;
			}
			// 校验邮箱：
			if($("#email").val().length > 0){
				if(!$("#email").val().match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){
					$("#email_tip").css("display","inline").text("请输入正确的邮箱格式");
					$("#email").css("border-color","red").focus();
					return false;
				}
			}
			//重名修改提示
			if($("#username_tip").text().length < 8){
					$("#username").css("border-color","red").focus();
					return false;
			}
		});
		
		$("#form1 input").change(function(){
	      	var $text = $(this).attr("name");
	      	$("#"+$text+"_tip").css("display","none");
	      	$(this).css("border-color","");
		 });
		 
		// 校验用户名是否已存在
      	$("#username").change(function(){
      		if($(this).val().length > 2) {
	      		//设置请求路径
	      		var url = "${pageContext.request.contextPath}/user_findByName";
	      		//封装请求参数
	      		var params = {"username":$(this).val()};
	      		//ajax异步请求
	      		$.ajax({
					"url":url,		
					"data":params,
					"type":"post",
					"success":function(data){
						$("#username_tip").css("display","inline").html(data);
					},
					"error":function(){
						alert("服务器繁忙，请稍后再试!");
					},
					"dataType":"text"
				});
			}
      	});
	});
	
</script>
</head>
<body>
  <div style="background-color: #E7E7E7;border-radius: 20px;padding: 5px;margin-right: 5px;margin-top: 5px;margin-left: 5px;">
            <a href="${pageContext.request.contextPath}/admin/welcome.jsp" style="margin-left: 15px;margin-right: 15px;">主页</a>&gt;&gt;
            <a href="${pageContext.request.contextPath}/adminGeneralUser_findAll?page=1" style="margin-left: 15px;margin-right: 15px;">会员管理</a>&gt;&gt;
            <a style="margin-left: 15px;margin-right: 15px;">添加会员</a>
   </div>
	<form id="form1" action="${pageContext.request.contextPath}/adminGeneralUser_addUser" method="post">
	<table width="100%">
			<tbody>
				<tr>
				<td valign="top">
						<div class="title"><h2>添加会员</h2></div>
						<div class="maincon">
					<table class="formtable" width="100%">
						<tr>
							<td width="25%" align="right"><span style="color: red">* </span>用户名：</td>
							<td width="35%">
								<div class="stext"><input type="text" id="username" name="username" value=""  style="width:180px;" /><span id="username_tip" style="margin-left: 15px;display: none;color: red"></span></div>
							</td>
							<td width="10%" align="right">邮箱：</td>
							<td width="30%">
								<div class="stext"><input type="text" id="email" name="email" value=""  style="width:180px;" /><span id="email_tip" style="margin-left: 15px;display: none;color: red"></span></div>
							</td>
						</tr>
						<tr>
							<td width="25%" align="right"><span style="color: red">* </span>密码：</td>
							<td width="35%">
								<div class="stext"><input type="password" id="password" name="password" value=""  style="width:180px;" /><span id="password_tip" style="margin-left: 15px;display: none;color: red"></span></div>
							</td>
							<td width="10%" align="right">姓名：</td>
							<td width="30%">
								<div class="stext"><input type="text" id="name" name="name" value=""  style="width:180px;" /></div>
							</td>
						</tr>
						<tr>
							<td width="25%" align="right"><span style="color: red">* </span>确认密码：</td>
							<td width="35%">
								<div class="stext"><input type="password" id="repassword" name="repassword" value=""  style="width:180px;" /><span id="repassword_tip" style="margin-left: 15px;display: none;color: red"></span></div>
							</td>
							<td width="10%" align="right">电话：</td>
							<td width="30%">
								<div class="stext"><input type="text" id="phone" name="phone" value=""  style="width:180px;" /></div>
							</td>
						</tr>
						<tr>
							<td width="25%" align="right"><span style="color: red">* </span>用户状态：</td>
							<td width="35%">
								<select name="state">
									<option value="1">已激活</option>
									<option value="0">未激活</option>
								</select>
							</td>
							<td width="10%" align="right">地址：</td>
							<td width="30%">
								<div class="stext"><input type="text" id="addr" name="addr" value=""  style="width:180px;" /></div>
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