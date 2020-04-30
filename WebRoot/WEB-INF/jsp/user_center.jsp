<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML>
<html>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
  <meta charset="UTF-8">
  <meta name="description" content="">
  <meta name="keywords" content="">

  <title>会员中心</title>
  <link href="${pageContext.request.contextPath}/css/style.css" media="screen" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/grid.css" media="screen" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/js/SyntaxHighlighter/shCoreDefault.css">
    <!-- 菜单栏样式 -->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/menu.css">
  <!--弹出层样式-->
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/alert.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
  
  <script src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js" ></script>
  <script src="${pageContext.request.contextPath}/js/html5.js" ></script>
  <script src="${pageContext.request.contextPath}/js/jflow.plus.js" ></script>
  <script src="${pageContext.request.contextPath}/js/jquery.carouFredSel-5.2.2-packed.js"></script>
  <script src="${pageContext.request.contextPath}/js/checkbox.js"></script>
  <script src="${pageContext.request.contextPath}/js/radio.js"></script>
  <script src="${pageContext.request.contextPath}/js/selectBox.js"></script>
  
  <script src="${pageContext.request.contextPath}/js/SyntaxHighlighter/shCore.js"></script>
  <script src="${pageContext.request.contextPath}/js/SyntaxHighlighter/makeSy.js"></script>
  <!--弹出层代码-->
  <script src="${pageContext.request.contextPath}/js/alert.js"></script>
  <script src="${pageContext.request.contextPath}/js/alert-api.js"></script>  
    <!-- 菜单栏动画 -->
  <script src="${pageContext.request.contextPath}/js/menu.js"></script>

  <script>
	$(document).ready(function() {
		$("select").selectBox();
	});
  </script>

  <script>
	$(document).ready(function(){
	    $("#myController").jFlow({
			controller: ".control", // must be class, use . sign
			slideWrapper : "#jFlowSlider", // must be id, use # sign
			slides: "#slider",  // the div where all your sliding divs are nested in
			selectedWrapper: "jFlowSelected",  // just pure text, no sign
			width: "984px",  // this is the width for the content-slider
			height: "480px",  // this is the height for the content-slider
			duration: 400,  // time in miliseconds to transition one slide
			prev: ".slidprev", // must be class, use . sign
			next: ".slidnext", // must be class, use . sign
			auto: true	
		});
	});
  </script>
  <script>
	$(function() {
	  $('#list_product').carouFredSel({
		prev: '#prev_c1',
		next: '#next_c1',
		auto: false
	  });
          $('#list_product2').carouFredSel({
		prev: '#prev_c2',
		next: '#next_c2',
		auto: false
	  });
	  $('#list_banners').carouFredSel({
		prev: '#ban_prev',
		next: '#ban_next',
		scroll: 1,
		auto: false
	  });
	  $(window).resize();
	});
  </script>
  <script>
       $(document).ready(function(){
	      $("button").click(function(){
		     $(this).addClass('click')
	      }); 
	      
	      $("#password").click(function(){
	      	var $value = $(this).attr("value");
	      	if($value == "" || $value == null) {
		      	$("#password_tip").css("display","inline").text("密码由3位以上数字和字母组成");
	      	}
		  });
		 
	      $("#form1").submit(function(){
				if($("#password").val().length < 3){
					$("#password_tip").css({display:"inline",color:"red"}).text("密码由3位以上数字和字母组成");
					$("#password").css("border-color","red").focus();
					return false;
				}
				if($("#repassword").val() != $("#password").val()){
					$("#repassword_tip").css("display","inline").text("两次输入的密码不一致");
					$("#repassword").css("border-color","red").focus();
					return false;
				}
			});
		
		$("#form1 input").change(function(){
	      	var $text = $(this).attr("name");
	      	$("#"+$text+"_tip").css("display","none");
	      	$(this).css("border-color","");
		 });
       })
  </script>
    
</head>
<body>
<%@ include file="menu.jsp" %>
  
  <div class="clear"></div>
  
  <section id="main" class="entire_width" style="margin-top: 30px;">
    <div class="container_12">      
       <div id="content">
		<div class="grid_12">
			<h1 class="page_title">会员中心<span style="padding-left: 20px;font-size: 12px;color: #e0e0e0;">Member Center</span></h1>
		</div><!-- .grid_12 -->
		
		<div class="grid_3" id="sidebar_right">
			<aside id="checkout_progress">
				<h3>我的账户<span style="padding-left: 20px;font-size: 12px;color: #e0e0e0;">My Account</span></h3>
				<ul id="myaccount">
					<li style="background-color: #f5f7f9;box-shadow: 6px 0px #000000;"><a style="float: none;background: none;padding-left: 0px;" href="#">修改个人信息<span style="padding-left: 94px;"><img src="images/edit.png"> Edit</span></a></li>
					<li><a href="${pageContext.request.contextPath}/order_findByUid?page=1" style="float: none;background: none;padding-left: 0px;">查询订单<span style="padding-left: 115px;"><img src="images/bg_cart_nav.png"> Order</span></a></li>
					<li><a href="${pageContext.request.contextPath}/user_findLikeByUid?page=1&limit=6" style="float: none;background: none;padding-left: 0px;">我的收藏<span style="padding-left: 115px;"><img src="images/bg_like.png"> Like</span></a></li>
					<li><a href="${pageContext.request.contextPath}/user_quit" style="float: none;background: none;padding-left: 0px;">退出登录<span style="padding-left: 115px;"><img src="images/close.png"> Quit</span></a></li>
				</ul>
			</aside>
                </div><!-- #sidebar_right -->
       </div><!-- #content -->
       
		<div class="grid_9" id="checkout_info" style="box-shadow: 7px 7px #e0e0e0;height: 639px;">
			<ul class="checkout_list">
				<li class="active">
					<div class="list_header" style="box-shadow: inset 10px 0px black;">修改个人信息<div class="number">📑</div></div>
					<div class="list_body" style="padding-left: 50px;">
						<form id="form1" action="${pageContext.request.contextPath}/user_edit" method="post" class="login" style="float: none;width: 600px;">
							<input type="hidden" name="uid" value="<s:property value="#session.user.uid"/>"/>
							<input type="hidden" name="username" value="<s:property value="#session.user.username"/>"/>
							<input type="hidden" name="email" value="<s:property value="#session.user.email"/>"/>
							<input type="hidden" name="state" value="<s:property value="#session.user.state"/>"/>
							<div style="color: #777;font-size: 16px;font-weight:700 ">基本信息：</div>
							<table style="border: 0">
								<tr>
									<td width="30%" style="border-bottom: 0" align="right"><strong>用户名:</strong></td>
									<td style="border-bottom: 0" align="left"><span style="margin-left: 15px;"><s:property value="#session.user.username"/></span></td>
								</tr>
								<tr>
									<td width="30%"  style="border-bottom: 0" align="right"><strong>邮箱:</strong></td>
									<td style="border-bottom: 0" align="left"><span style="margin-left: 15px;"><s:property value="#session.user.email"/></span></td>
								</tr>
								<tr>
									<td  width="30%" style="border-bottom: 0" align="right"><strong>修改密码:</strong><sup class="surely">*</sup></td>
									<td style="border-bottom: 0" align="left"><input id="password" style="width: 200px;margin-left: 10px;" type="password" name="password" value="" /><span id="password_tip" style="margin-left: 15px;display: none;"></span></td>
								</tr>
								<tr>	
									<td  width="30%" style="border-bottom: 0" align="right"><strong>确认密码:</strong><sup class="surely">*</sup></td>
									<td style="border-bottom: 0" align="left"><input id="repassword" style="width: 200px;margin-left: 10px;" type="password" name="repassword" value="" /><span id="repassword_tip" style="margin-left: 15px;display: none;"></span></td>
								</tr>
								</table>
								<hr style="border-top:2px dotted #185598;" />
								<div style="color: #777;font-size: 16px;font-weight:700;padding-top: 20px;">收货信息：</div>
								<table style="border: 0">
								<tr>
									<td  width="30%" style="border-bottom: 0" align="right"><strong>姓名:</strong></td>
									<td style="border-bottom: 0" align="left"><input style="width: 200px;margin-left: 10px;" type="text" name="name"  value="<s:property value="#session.user.name"/>" /></td>
								</tr>
								<tr>
									<td  width="30%" style="border-bottom: 0" align="right"><strong>电话:</strong></td>
									<td style="border-bottom: 0" align="left"><input style="width: 200px;margin-left: 10px;" type="text" name="phone"  value="<s:property value="#session.user.phone"/>" /></td>
								</tr>
								<tr>
									<td  width="30%" style="border-bottom: 0" align="right"><strong>地址:</strong></td>
									<td style="border-bottom: 0" align="left"><input style="width: 200px;margin-left: 10px;" type="text" name="addr" value="<s:property value="#session.user.addr"/>" /></td>
								</tr>
								<tr>
									<td colspan="2" style="border-bottom: 0" align="center">
									<div class="submit" style="margin-top: 10px;">										
										<input type="submit" style="margin-left: 240px;" value="确  认" />
									</div><!-- .submit -->
									</td>
								</tr>
							</table>
						</form>
						<div class="clear"></div>
					</div>
				</li>
			</ul>
         </div><!-- .grid_9 -->
       
      <div class="clear"></div>
    </div><!-- .container_12 -->
  </section><!-- #main -->
  
  <div class="clear"></div>
<%@ include file="foot.jsp" %>
</body>
</html>