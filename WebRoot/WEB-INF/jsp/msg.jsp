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

  <title>系统信息</title>
  
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
	       
	      function jump(count) {    
                window.setTimeout(function(){    
                    count--;    
                    if(count > 0) {    
                        $("#time").text(" "+count+" ");    
                        jump(count);    
                    } else {    
                        location.href="${pageContext.request.contextPath}/index";    
                    }    
                }, 1000);    
            }    
            jump(6);       
       });
  </script>
</head>
<body>
<%@ include file="menu.jsp" %>  
  <div class="clear"></div>
  
  <section id="main" class="entire_width page-404">
    <div class="container_12">      
       <div id="content">
		
		<div class="grid_4 left_404">
			<h1 class="text_404"><img src="${pageContext.request.contextPath}/image/message.png"></h1>
			<h6 style="font-size: 18px">message</h6>
                </div><!-- .adress -->
		
		<div class="grid_8" style="font-family: Arial">
			<h2>操作完成:</h2>
			<p><strong>服务器已成功处理您的请求，状态：<font color="red" style="font-size: 18px"><s:actionmessage/><s:actionerror/> </font></strong></p>
			<p><strong>您还可以进行以下操作：</strong></p>
			<s:if test="#session.user == null">
				<ul style="list-style: circle;">
					<li>▪&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/user_loginPage"> 登录</a></li>
					<li>▪&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/user_registPage"> 注册</a></li>
					<li>▪&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index"> 返回首页</a></li>
				</ul>
			</s:if>
			<s:else>
				<ul style="list-style: circle;">
					<li>▪&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/order_findByUid?page=1"> 我的订单</a></li>
					<li>▪&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/user_findLikeByUid?page=1&limit=6"> 我的收藏</a></li>
					<li>▪&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/index"> 返回首页</a></li>
				</ul>
			</s:else>
			<p>此页面将于<span id="time" style="color: red;"> 6 </span>秒后，自动跳转至首页。如果您的浏览器不能进行跳转，请手动点击前往<a href="${pageContext.request.contextPath}/index">首页</a>。<br/></p>
         </div><!-- .grid_8 -->
       </div><!-- #content -->
       
      <div class="clear"></div>
    </div><!-- .container_12 -->
  </section><!-- #main -->
  
  <div class="clear"></div>
  
  <%@ include file="foot.jsp" %>
</body>
</html>