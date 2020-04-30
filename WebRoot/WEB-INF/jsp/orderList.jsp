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

  <title>订单列表</title>

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
       <div class="grid_12" style="height: 508px;height: auto"> 
       <h1 class="page_title">订单列表<span style="padding-left: 20px;font-size: 12px;color: #e0e0e0;">Order List</span></h1>

       	<s:if test="pageBean.list == null">
	      	<div><img style="width: 850px;margin-left: 60px;margin-top: 50px;margin-bottom: 20px;" src="${pageContext.request.contextPath}/image/not found.png" /></div>
	      	<div  align="center" style="margin-bottom: 100px;font-size: 18px;">没有查询到相关信息</div>
	      </s:if>
	      <s:else>
       <table class="cart_product">
       	  <s:iterator var="order" value="pageBean.list">
	       	  <tr>
					<th colspan="5" align="left">
						订单编号:  <s:property value="#order.oid"/>
						&nbsp;&nbsp;&nbsp;&nbsp;订单总金额:<font color="red">  <s:property value="#order.total"/>0</font>
						&nbsp;&nbsp;&nbsp;&nbsp;订单状态：
						<s:if test="#order.state == 1">
							<font color="red">待付款</font>
						&nbsp;&nbsp;&nbsp;&nbsp;操作：
						<font>
							<a href="${pageContext.request.contextPath}/order_findByOid?oid=<s:property value="#order.oid"/>">付款</a>
						</font>
						</s:if>
						<s:if test="#order.state == 2">
							<font color="#FFC107">已付款
						&nbsp;&nbsp;&nbsp;&nbsp;等待发货</font>
						</s:if>
						<s:if test="#order.state == 3">
							<font color="blue">等待确认收货</font>
						&nbsp;&nbsp;&nbsp;&nbsp;操作：
						<font>
							<a href="${pageContext.request.contextPath}/order_updateState?oid=<s:property value="#order.oid"/>">确认收货</a>
						</font>
						</s:if>
						<s:if test="#order.state == 4">
	 						 <font color="#2dd334">交易完成</font>
						</s:if>
					</th>
			 </tr>	
		      <tr>
			     <th class="images">商品图片</th>
			     <th class="bg name">商品名称</th>
			     <th class="bg price" style="background: #fff;">单价</th>
			     <th class="qty" style="background: #f7f7f7;">数量</th>
			     <th class="bg subtotal" style="background: #fff;">小计</th>
		      </tr>
			 <s:iterator var="orderItem" value="#order.orderItems">
			  <tr>
				 <td class="images" style="padding-bottom: 10px;"><a href="product_page.html"><img src="${pageContext.request.contextPath}/<s:property value="#orderItem.product.image"/>"></a></td>
				 <td class="bg name" style="font-size: 14px;line-height: 34px;padding-bottom: 10px;"><s:property value="#orderItem.product.pname"/><br/>作者：<s:property value="#orderItem.product.author"/> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出版社：<s:property value="#orderItem.product.press"/></td>
				 <td class="bg price" style="background: #fff;font-size: 15px;padding-bottom: 10px;padding-top: 50px;" align="center">￥<s:property value="#orderItem.product.shop_price"/>0</td>
				 <td class="qty" style="background: #f7f7f7;font-size: 15px;padding-top: 30px;padding-bottom: 10px;padding-top: 50px;" align="center"><s:property value="#orderItem.count"/></td>
				 <td class="bg subtotal" style="background: #fff;font-size: 15px;padding-bottom: 10px;padding-top: 50px;" align="center">￥<s:property value="#orderItem.subtotal"/>0</td>
			  </tr>
		     </s:iterator>
	      </s:iterator>
       </table>
       <!-- 分页  -->
	      <div class="pagination">
		      	 <ul>
			     <s:if test="pageBean.page != 1">
			     	<li class="prev"><a href="${pageContext.request.contextPath}/order_findByUid?page=1">&lt;&lt;</a></li>
				    <li class="prev"><a href="${pageContext.request.contextPath}/order_findByUid?page=<s:property value="pageBean.page - 1"/>">&lt;</a></li>
				 </s:if>   
				 <!-- 动态显示条 -->
	       		 <s:iterator begin="pageBean.start" end="pageBean.end" var="num">
	       		 	<s:if test="pageBean.page != #num">
	        	  		<li><a href="${pageContext.request.contextPath}/order_findByUid?page=<s:property value="#num"/>" ><s:property value="#num"/></a></li>
	        	  	</s:if>
	        	  	<s:else>
	        	  		<li class="curent"><a><s:property value="#num"/></a></li>
	        	  	</s:else>
	      		 </s:iterator>
				  <s:if test="pageBean.page != pageBean.totalPage">  
				    <li class="next"><a href="${pageContext.request.contextPath}/order_findByUid?page=<s:property value="pageBean.page + 1"/>">&gt;</a></li>
				    <li class="next"><a href="${pageContext.request.contextPath}/order_findByUid?page=<s:property value="pageBean.totalPage"/>">&gt;&gt;</a></li>
				  </s:if>  
			     </ul>
	      </div><!-- .pagination -->
	      <p class="pagination_info">第<s:property value="pageBean.page"/>页/共<s:property value="pageBean.totalPage"/>页</p>
	      </s:else>
       </div><!-- .grid_12 -->
      <div class="clear"></div>
		
    </div><!-- .container_12 -->
  </section><!-- #main -->

  <div class="clear"></div>
<%@ include file="foot.jsp" %>
</body>
</html>
