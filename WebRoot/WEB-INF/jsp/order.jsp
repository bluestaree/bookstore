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

  <title>订单详情</title>

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
	  $(window).resize();
	});
  </script>
  <script>
       $(document).ready(function(){
	      $("button").click(function(){
		     $(this).addClass('click')
	      });
       })
  </script>
  <script>
       $(document).ready(function() {
	      $("select").selectBox();
	      $("#checkout").click(function(){
	      	$("#orderForm").submit();
	      });
       });
  </script>

</head>
<body>
  <%@ include file="menu.jsp" %>

  <div class="clear"></div>

  <section id="main" class="entire_width" style="margin-top: 30px;margin-bottom: 50px;">
    <div class="container_12">
       <div class="grid_12" style="height: auto;"> 
       <h1 class="page_title">订单详情<span style="padding-left: 20px;font-size: 12px;color: #e0e0e0;">The Order Details</span></h1>

       <table class="cart_product">
       	   <tr>
				<th colspan="5" align="left">
					订单编号:<s:property value="model.oid"/>
				</th>
		  </tr>
	      <tr>
		     <th class="images">商品图片</th>
		     <th class="bg name">商品名称</th>
		     <th class="bg price" style="background: #fff;">单价</th>
		     <th class="qty" style="background: #f7f7f7;">数量</th>
		     <th class="bg subtotal" style="background: #fff;">小计</th>
	      </tr>
	      <s:iterator var="orderItem" value="model.orderItems">
  		  <tr>
		     <td class="images" style="padding-bottom: 10px;"><a href="product_page.html"><img src="${pageContext.request.contextPath}/<s:property value="#orderItem.product.image"/>" ></a></td>
		     <td class="bg name" style="font-size: 14px;line-height: 34px;padding-bottom: 10px;"><s:property value="#orderItem.product.pname"/><br/>作者：<s:property value="#orderItem.product.author"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出版社：<s:property value="#orderItem.product.press"/></td>
		     <td class="bg price" style="background: #fff;font-size: 15px;padding-bottom: 10px;padding-top: 50px;" align="center">￥<s:property value="#orderItem.product.shop_price"/>0</td>
		     <td class="qty" style="background: #f7f7f7;font-size: 15px;padding-top: 30px;padding-bottom: 10px;padding-top: 50px;" align="center"><s:property value="#orderItem.count"/></td>
		     <td class="bg subtotal" style="background: #fff;font-size: 15px;padding-bottom: 10px;padding-top: 50px;" align="center">￥<s:property value="#orderItem.subtotal"/>0</td>
	      </tr>
		 </s:iterator>
	      <tr>
		     <td colspan="7" class="cart_but">
		     	<a href="${pageContext.request.contextPath}/index"><button class="continue"><span>icon</span>返 回 首 页</button></a>
			    <a href="${pageContext.request.contextPath}/order_findByUid?page=1"><button class="update"><span>icon</span>返回订单列表</button></a>
		     </td>
	      </tr>
       </table>
       
       </div><!-- .grid_12 -->
	   <div style="font-size: 15px;width: 150px;margin-bottom: 10px;margin-left: 852px;">订单总金额：<span style="color: red;width: 90px;">¥ <s:property value="model.total"/>0</span></div>
       <div id="content_bottom">
        <div class="grid_4">
          <div class="bottom_block total" style=" width: 944px;padding-top: 15px;background-color: #fbfbfb;height: 530px;">
	      <table class="subtotal">
	      	<form  id="orderForm" action="${pageContext.request.contextPath}/order_payOrder" method="post">
				<input type="hidden" name="oid" value="<s:property value="model.oid"/>" />
					<div>
						<p align="left">
							<strong style="font-size: 20px;">填写收货地址信息:</strong><br>
							
							<span style="color: red">* </span>收货地址：<input name="addr" type="text" value="<s:property value="model.user.addr"/>" style="width:350px;margin-bottom: 10px;margin-top: 10px;" />
								<br />
							&nbsp;&nbsp;&nbsp;&nbsp;<span style="color: red">* </span>收货人：<input name="name" type="text" value="<s:property value="model.user.name"/>" style="width:350px;margin-bottom: 10px;margin-top: 10px;" />
								<br /> 
							<span style="color: red">* </span>联系方式：<input name="phone" type="text" value="<s:property value="model.user.phone"/>" style="width:350px;margin-bottom: 10px;margin-top: 10px;" />

						</p>
						<hr />
						<p >
							<div align="left">
							<p><strong style="font-size: 20px;">选择付款银行：</strong></p>
							
								<div style="float: left;margin-top: 10px;margin-right: 5px;margin-left: 95px;">
									<input type="radio" name="pd_FrpId" value="ICBC-NET-B2C" checked="checked"/>工商银行
								</div>
								<div style="float: left;margin-right: 20px;margin-bottom: 10px;">
									<img src="${pageContext.request.contextPath}/bank_img/icbc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
								</div>
								<div style="float: left;margin-top: 10px;margin-right: 5px;">
									<input type="radio" name="pd_FrpId" value="BOC-NET-B2C"/>中国银行
								</div>
								<div style="float: left;margin-right: 20px;margin-bottom: 10px;">
									<img src="${pageContext.request.contextPath}/bank_img/bc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
								</div>
								<div style="float: left;margin-top: 10px;margin-right: 5px;">
									<input type="radio" name="pd_FrpId" value="ABC-NET-B2C"/>农业银行
								</div>
								<div style="float: left;margin-right: 20px;margin-bottom: 10px;">
									<img src="${pageContext.request.contextPath}/bank_img/abc.bmp" align="middle"/>
								</div>
							<br/>
							<div class="clear"></div>
								<div style="float: left;margin-top: 10px;margin-right: 5px;margin-left: 95px;">
									<input type="radio" name="pd_FrpId" value="BOCO-NET-B2C"/>交通银行
								</div>
								<div style="float: left;margin-right: 20px;margin-bottom: 10px;">
									<img src="${pageContext.request.contextPath}/bank_img/bcc.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
								</div>
								<div style="float: left;margin-top: 10px;margin-right: 5px;">
									<input type="radio" name="pd_FrpId" value="PINGANBANK-NET"/>平安银行
								</div>
								<div style="float: left;margin-right: 20px;margin-bottom: 10px;">
									<img src="${pageContext.request.contextPath}/bank_img/pingan.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
								</div>
								<div style="float: left;margin-top: 10px;margin-right: 5px;">
									<input type="radio" name="pd_FrpId" value="CCB-NET-B2C"/>建设银行
								</div>
								<div style="float: left;margin-right: 20px;margin-bottom: 10px;">
									<img src="${pageContext.request.contextPath}/bank_img/ccb.bmp" align="middle"/>
								</div>
							<br/>
							<div class="clear"></div>
								<div style="float: left;margin-top: 10px;margin-right: 5px;margin-left: 95px;">
									<input type="radio" name="pd_FrpId" value="CEB-NET-B2C"/>光大银行
								</div>
								<div style="float: left;margin-right: 20px;margin-bottom: 10px;">
									<img src="${pageContext.request.contextPath}/bank_img/guangda.bmp" align="middle"/>&nbsp;&nbsp;&nbsp;&nbsp;
								</div>
								<div style="float: left;margin-top: 10px;margin-right: 5px;">
									<input type="radio" name="pd_FrpId" value="CMBCHINA-NET-B2C"/>招商银行
								</div>
								<div style="float: left;margin-right: 20px;margin-bottom: 10px;">
									<img src="${pageContext.request.contextPath}/bank_img/cmb.bmp" align="middle"/>
								</div>
								<div style="float: left;margin-top: 10px;margin-right: 5px;margin-left: 15px;">
									<input type="radio" name="pd_FrpId" value="POST-NET-B2C"/>中国邮政
								</div>
								<div style="float: left;margin-right: 20px;margin-bottom: 10px;">
									<img src="${pageContext.request.contextPath}/bank_img/post.bmp" align="middle"/>
								</div>
								<div class="clear"></div>
							</div>
						</p>
						<hr />
					</div>
			</form>
	      </table>
	    <button id="checkout" class="checkout" style="margin-top: 15px;margin-bottom: 0px;">确认付款</button>
       </div><!-- .total -->
      </div><!-- .grid_4 -->

       <div class="clear"></div>
      </div><!-- #content_bottom -->
      <div class="clear"></div>

      <div class="clear"></div>


    </div><!-- .container_12 -->
  </section><!-- #main -->

  <div class="clear"></div>
<%@ include file="foot.jsp" %>
</body>
</html>
