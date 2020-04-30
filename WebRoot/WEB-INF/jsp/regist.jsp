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

  <title>注册</title>

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
	      
	      //注册提示信息显示
	    $("form.registed input").click(function(){
	      	var $value = $(this).attr("value");
	      	if($value == "" || $value == null) {
		      	var $text = $(this).attr("name");
		      	$("#"+$text+"_tip").css("display","inline");
	      	}
		  });
		  
		   //注册提示信息隐藏
	      $("form.registed input").change(function(){
	      	var $text = $(this).attr("name");
	      	$("#"+$text+"_tip").css("display","none");
	      	$(this).css("border-color","");
		  });
		  
		  //前端表单提交验证
		 $("form.registed").submit(function(){
			    // 校验用户名:
				// 获得用户名文本框的值:
				if($("#username").val().length < 3){
					$("#username_tip").css("display","inline").text("用户名由3位以上字母数字组成");
					$("#username").css("border-color","red").focus();
					return false;
				}	//重名修改提示
				if($("#username_tip").text().length < 8){
					$("#username").css("border-color","red").focus();
					return false;
				}
				// 校验密码:
				// 获得密码框的值:
				if($("#password").val().length < 3){
					$("#password_tip").css("display","inline");
					$("#password").css("border-color","red").focus();
					return false;
				}
				// 校验确认密码:
				if($("#repassword").val() != $("#password").val()){
					$("#repassword_tip").css("display","inline").text("两次输入的密码不一致");
					$("#repassword").css("border-color","red").focus();
					return false;
				}
				// 校验邮箱：
				if(!$("#email").val().match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)){
					$("#email_tip").css("display","inline");
					$("#email").css("border-color","red").focus();
					return false;
				}
				// 校验验证码是否为空：
				if($("#checkcode").val() == "" || $("#checkcode").val().length < 4){
					$("#checkcode_tip").css("display","inline");
					$("#checkcode").css("border-color","red").focus();
					return false;
				}
				// 校验是否同意注册条款
				if($("#ck_agreement").attr("checked") != "checked"){
					$("#agreement_tip").css("display","inline");
					return false;
				}
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
      	
      	// 更换验证码
      	$("#checkImg").click(function(){
      		$(this).attr("src","${pageContext.request.contextPath}/checkImg?time=" + new Date().getTime() );
      	});
      	$("#changeCheckImg").click(function(){
      	    $("#checkImg").attr("src","${pageContext.request.contextPath}/checkImg?time=" + new Date().getTime() );
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
			<h1 class="page_title">注册<span style="padding-left: 20px;font-size: 12px;color: #e0e0e0;">Regist</span></h1>
		</div><!-- .grid_12 -->
		<div class="grid_6 new_customers" align="left" style="background-image: url('${pageContext.request.contextPath}/image/regist1.png');background-position:0px 160px;background-repeat:no-repeat;height: 540px;width: 348px;margin-top: 50px;">
			<span style="color: #e64848;background-color: white;font-size: 20px;">新会员注册既可享受：</span>
			<p style="margin-top: 20px;font-size: 16px;">✔ 正品保障、正规发票</p>
			<p style="font-size: 16px;">✔ 货到付款、会员服务</p>
			<p style="font-size: 16px;">✔ 自由退换、送货上门</p>
			<div class="clear"></div>
         </div><!-- .grid_6 -->
         
		
		<div class="grid_6">
			<form action="${pageContext.request.contextPath}/user_regist.action " method="post" class="registed" style="height: 550px;width:570px;box-shadow: 7px 7px #e0e0e0;height: auto;">
				<h2 style="padding-bottom: 0px;">会员注册<span style="padding-left: 20px;font-size: 12px;color: #e0e0e0;">User Regist</span></h2>
				<div style="height: 40px;">
					<hr style="margin-top: 10px;"/>
					<span style="margin-left: 10px;color: red;display:inline;"><s:actionerror/>
				</span></div>
				<div>
					&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: red">* </span><strong>用户名:</strong>
					<s:textfield  style="margin-left: 10px;" id="username" name="username" class="text" maxlength="20" placeholder="请输入用户名"></s:textfield>
					<span id="username_tip" style="margin-left: 10px;color: #666; display:none; ">用户名由3位以上字母数字组成</span>
					<span style="margin-left: 10px;color: #666;display:inline;"><s:fielderror fieldName="username"/> </span>
				</div>
							
				<div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: red">* </span><strong>密  码:</strong>
					<s:password name="password" style="width: 255px;margin-top: 5px;margin-bottom: 13px;margin-left: 11px;" id="password"  class="text" maxlength="20" autocomplete="off"/>
					<span id="password_tip" style="margin-left: 10px;color: #666;display: none">密码长度必须在3位以上</span>
					<span style="margin-left: 10px;color: #666;display:inline;"><s:fielderror fieldName="password"/> </span>
				</div>
				
				<div>
					<span style="color: red">* </span><strong>确认密码:</strong>
					<s:password id="repassword" style="width: 255px;margin-top: 5px;margin-bottom: 13px;margin-left: 10px;" name="repassword" class="text" maxlength="20" autocomplete="off"/>
					<span id="repassword_tip" style="margin-left: 10px;color: #666;display: none">请输入确认密码</span>
					<span style="margin-left: 10px;color: #666;display:inline;"><s:fielderror fieldName="repassword"/> </span>
				</div>
				
				<div >
					&nbsp;<span style="color: red">* </span><strong>E-mail:</strong>
					<s:textfield style="width: 255px;margin-top: 5px;margin-bottom: 13px;margin-left: 12px;" id="email" name="email" class="text" maxlength="200" placeholder="请输入常用邮箱地址"/>
					<span id="email_tip" style="margin-left: 10px;color: #666;display: none">请填写正确的邮箱格式</span>
				</div>
				
				<div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>姓 名:</strong>
					<s:textfield style="width: 255px;margin-top: 5px;margin-bottom: 13px;margin-left: 10px;" name="name" class="text" maxlength="200"/>
				</div>
				
				<div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>电 话:</strong>
					<s:textfield style="width: 255px;margin-top: 5px;margin-bottom: 13px;margin-left: 10px;" name="phone" class="text" />
				</div>
				
				<div>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<strong>地 址:</strong>
					<s:textfield style="width: 255px;margin-top: 5px;margin-bottom: 13px;margin-left: 10px;" name="addr" class="text" maxlength="200"/>
				</div>
				
				<div >
					&nbsp;&nbsp;&nbsp;<span style="color: red">* </span><strong>验证码:</strong>
					<s:textfield style="width: 100px;margin-top: 5px;margin-bottom: 13px;margin-left: 10px;" id="checkcode" name="checkcode" class="text captcha" maxlength="4" autocomplete="off" placeholder="请输入验证码"/>
					<span>
						<img id="checkImg" class="captchaImage" src="${pageContext.request.contextPath}/checkImg" title="点击更换验证码">
						<a style="margin-left: 5px;color: #777;" href="javascript:void(0);" id="changeCheckImg" >看不清？换一张</a>
						<span id="checkcode_tip" style="margin-left: 20px;color: #666;display: none">填写4位验证码</span>
					</span>
				</div>
				
				<div><input id="ck_agreement" type="checkbox" style="width: 30px;margin-top: 5px;margin-bottom: 13px;margin-left: 140px;" checked="checked"><strong>我已同意注册条款</strong><span id="agreement_tip" style="margin-left: 15px;color: red;display: none">您必须同意此条款，才能提交注册</span></div>
				<div class="submit" style="margin-top: 10px;">	
					<input type="submit" value="注      册" style="margin-left: 135px;width: 150px;height: 40px;margin-right: 150px;"/>
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