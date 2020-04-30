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

  <title>购物车</title>

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
       });
  </script>

</head>
<body>
<%@ include file="menu.jsp" %>
  <div class="clear"></div>

  <section id="main" class="entire_width" style="margin-top: 30px;margin-bottom: 50px;">
    <div class="container_12">
       <div class="grid_12" style="height: auto;"> 
       <h1 class="page_title">购物车<span style="padding-left: 20px;font-size: 12px;color: #e0e0e0;">Shopping Cart</span></h1>
  	<s:if test="#session.cart.cartItems.size() != 0 ">
       <table class="cart_product">
	      <tr>
		     <th class="images">商品图片</th>
		     <th class="bg name">商品名称</th>
		     <th class="bg price" style="background: #fff;">单价</th>
		     <th class="qty" style="background: #f7f7f7;">数量</th>
		     <th class="bg subtotal" style="background: #fff;">小计</th>
		     <th class="close" style="background: #f7f7f7;">删除</th>
	      </tr>
	      <s:set var="sum" value="0"></s:set>
	      <s:iterator var="cartItem" value="#session.cart.cartItems">
		      <tr>
			     <td class="images" style="padding-bottom: 10px;"><a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#cartItem.product.pid"/>"><img src="${pageContext.request.contextPath}/<s:property value="#cartItem.product.image"/>"></a></td>
			     <td class="bg name" style="font-size: 14px;line-height: 34px;padding-bottom: 10px;"><s:property value="#cartItem.product.pname"/><br/>作者：<s:property value="#cartItem.product.author"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出版社：<s:property value="#cartItem.product.press"/></td>
			     <td class="bg price" style="background: #fff;font-size: 15px;padding-bottom: 10px;padding-top: 50px;" align="center">￥<s:property value="#cartItem.product.shop_price"/>0</td>
			     <td class="qty" style="background: #f7f7f7;padding-bottom: 10px;padding-top: 45px;" align="center">
			     	<input type="button" value='&lt;' title1="<s:property value="#cartItem.count - 1"/>"  title2="<s:property value="#cartItem.product.pid"/>" style="width:18px;height: 34px;color: black;font-weight: 700" class="alert-api-button alert-btn2">
			     	<input type="text"  name="count" title1="<s:property value="#cartItem.product.pid"/>" value="<s:property value="#cartItem.count"/>" style="width: 25px;padding-left: 5px;padding-right: 5px;" class="alert-api-button alert-btn3" />
			     	<input type="button" value='&gt;' title1="<s:property value="#cartItem.count + 1"/>" title2="<s:property value="#cartItem.product.pid"/>" style="width:18px;height: 34px;color: black;font-weight: 700" class="alert-api-button alert-btn2">
			     </td>
			     <td class="bg subtotal" style="background: #fff;font-size: 15px;padding-bottom: 10px;padding-top: 50px;" align="center">￥<s:property value="#cartItem.subtotal"/>0</td>
			     <td class="close" style="background: #f7f7f7;padding-bottom: 10px;padding-top: 55px;"><a title="删除" class="close" href="${pageContext.request.contextPath}/cart_removeCart?pid=<s:property value="#cartItem.product.pid"/>"></a></td>
		      </tr>
		     <s:set var="sum"  value="#sum + 1"></s:set>
	      </s:iterator>
	      <tr>
		     <td colspan="7" class="cart_but">
			    <a href="${pageContext.request.contextPath}/index"><button class="continue"><span>icon</span>继 续 购 物</button></a>
			    <a href="${pageContext.request.contextPath}/cart_clearCart"><button class="update"><span>icon</span>清 空 购 物 车</button></a>
		     </td>
	      </tr>
       </table>
       </div><!-- .grid_12 -->
		
       <div id="content_bottom">
        <div class="grid_4">
          <div class="bottom_block total" style=" width: 944px;padding-top: 10px;background-color: #fbfbfb;height: 100px;">
	      <table class="subtotal">
		     <tr class="grand_total">
		     	<td style="font-size: 15px;">已选择 <s:property value="#sum" /> 件商品</td>
			    <td style="width: 120px;font-size: 15px;" >赠送积分: <span style="color: red;font-size: 15px;"><s:property value="#session.cart.total" /></span></td>
			    <td style="width: 50px;font-size: 15px;">总计:</td><td class="price" style="color: red;width: 90px;">¥ <s:property value="#session.cart.total" />0</td>
		     </tr>
	      </table>
	      
	      <a href="${pageContext.request.contextPath}/order_save"><button class="checkout" style="margin-top: 5px;margin-bottom: 0px;">提交订单</button></a>
          </div><!-- .total -->
        </div><!-- .grid_4 -->

        <div class="clear"></div>
      </div><!-- #content_bottom -->
      <div class="clear"></div>
    </s:if>
    <s:else>
    	<div align="center" style="margin-top: 20px;"><img style="width: 400px;height: 500px;" src="${pageContext.request.contextPath}/image/no purchases.png"/></div>
    </s:else>
    </div><!-- .container_12 -->
  </section><!-- #main -->

  <div class="clear"></div>
<%@ include file="foot.jsp" %>
</body>
</html>
