<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s" %>    
<!DOCTYPE HTML>
<html>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
  <meta charset="UTF-8">
  <meta name="description" content="">
  <meta name="keywords" content="">

  <title>登录</title>

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
  <script src="${pageContext.request.contextPath}/js/jflow.plus.js"></script>
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
       $(document).ready(function(){
	      $("button").click(function(){
		     $(this).addClass('click')
	      });
       })
  </script>
    
</head>
<body>
  <%@ include file="menu.jsp" %>
  <div class="clear"></div>
  
  <section id="main" class="entire_width" style="margin-top: 30px;margin-bottom: 50px;">
    <div class="container_12">      
       <div id="content">
		<div class="grid_12">
			<h1 class="page_title">登录<span style="padding-left: 20px;font-size: 12px;color: #e0e0e0;">Login</span></h1>
		</div><!-- .grid_12 -->
		
		<div class="grid_6 new_customers" style="width: 200px;">
			<h2>还没有账号？</h2>
			<span style="color: #e64848;background-color: white;font-size: 20px;">新会员注册既享受：</span>
			<p style="margin-top: 20px;font-size: 16px;">正品保障、正规发票</p>
			<p style="font-size: 16px;">货到付款、会员服务</p>
			<p style="font-size: 16px;">自由退还、送货上门</p>
			<div class="clear"></div>
			<button class="account">立 即 注 册</button>
                </div><!-- .grid_6 -->
		<div style="width: 280px;float: left;"><img style="width: 280px;height: 220px;margin-top: 100px;" src="${pageContext.request.contextPath}/image/login1.png"/></div>
		<div class="grid_6">
			<form action="${pageContext.request.contextPath}/user_login" method="post" class="registed" style="box-shadow: 7px 9px #e0e0e0;margin-right: 7px;">
				<h2 style="padding-bottom: 13px;">会员登录<span style="padding-left: 20px;font-size: 12px;color: #e0e0e0;">User Login</span></h2>
				<hr/>
				<div style="margin-top: 0px;margin-bottom: 7px;color: red;"><s:actionerror/>  </div>
				<div class="email">
					<strong>用户名/E-mail:</strong><sup class="surely">*</sup><br/>
					<s:textfield  name="username" id="username"  placeholder="用户名/邮箱/手机号码"  />
				</div><!-- .email -->
							
				<div class="password">
					<strong>密码:</strong><sup class="surely">*</sup><br/>
					<s:password style="width: 255px;margin-top: 5px;margin-bottom: 5px;" name="password" placeholder="密码"/>
				</div><!-- .password -->
				
			
				<div class="submit">
					<input type="submit" value="登    录" style="width: 130px;margin-right: 0px;" />
				</div><!-- .submit -->
			</form><!-- .registed -->
                </div><!-- .grid_6 -->
       </div><!-- #content -->
       
      <div class="clear"></div>
    </div><!-- .container_12 -->
  </section><!-- #main -->
  
  <div class="clear"></div>
  <%@ include file="foot.jsp" %> 
</body>
</html>   