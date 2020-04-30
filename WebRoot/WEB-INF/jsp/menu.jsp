<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
  <div class="container_12">
    <div id="top">
      <div class="grid_3">
        <div class="phone_top">
         客服电话  : 99547/002145
        </div><!-- .phone_top -->
      </div><!-- .grid_3 -->

      <div class="grid_6">
        <div class="welcome" style="width: 530px;">
        <s:if test="#session.user == null">
          	欢迎光临网上图书商城！！！你可以单击此处<a href="${pageContext.request.contextPath}/user_loginPage">登录</a>或 <a href="${pageContext.request.contextPath}/user_registPage">注册账号</a>.
        </s:if>
        <s:else>
        	尊敬的会员：<font color="red"><s:property value="#session.user.username"/></font> 你好，欢迎光临BookStore网上图书购物商城！！！<a href="${pageContext.request.contextPath}/user_userCenterPage" style="color: red;margin-left: 10px;">前往会员中心.</a>
        </s:else>
        </div><!-- .welcome -->
      </div><!-- .grid_6 -->

      <div class="grid_3">
        <div class="valuta">
          <ul>
          <li><a href="${pageContext.request.contextPath}/index"><img width="18px" height="18px" style="padding-top: 8px;" src="${pageContext.request.contextPath}/images/home.png" title="主页"/></a></li>
            <li><a><img width="30px" height="25px" style="padding-top: 5px;" src="${pageContext.request.contextPath}/images/truck.png" title="运输保证"/></a></li>
            <li><a><img width="30px" height="27px" style="padding-top: 4px;" src="${pageContext.request.contextPath}/images/fair.png" title="公平公正"/></a></li>
            <li><a><img width="30px" height="30px" style="padding-top: 3px;" src="${pageContext.request.contextPath}/images/true.png" title="正品保证"/></a></li>
            <li><a><img width="30px" height="28px" style="padding-top: 5px;" src="${pageContext.request.contextPath}/images/cube.png" title="免运费"/></a></li>
            <li><a><img width="30px" height="28px" style="padding-top: 4px;" src="${pageContext.request.contextPath}/images/time.png" title="7天退款"/></a></li>
          </ul>
        </div><!-- .valuta -->
      </div><!-- .grid_3 -->
    </div><!-- #top -->

    <div class="clear"></div>
    
    <header id="branding" style="height: 45px;margin-top: 10px;">
      <div class="grid_3">
        <hgroup>
          <h1 id="site_logo" style="height: 60px;"><a href="${pageContext.request.contextPath}/index" title=""><img width="180px" src="${pageContext.request.contextPath}/images/logo.png" title="首页"/></a></h1>
          <h2 id="site_description" style="padding-bottom: 20px;padding-left: 30px;">www.bookstore123.com</h2>
        </hgroup>
      </div><!-- .grid_3 -->

      <div class="grid_3">
        <form name="search" id="search" style="width: 350px;" action="${pageContext.request.contextPath}/product_search?page=1&limit=6" class="search" method="post">
          <input type="text" style="margin-top: 10px;width: 240px; background: url(${pageContext.request.contextPath}/images/bg_search.png) no-repeat 245px center;" name="searchkey" class="entry_form" value="" placeholder="在此输入搜索关键词..."/>
           <input type="submit" style="display: inline;width: 50px;height: 34px" value="搜  索">
		</form>
      </div><!-- .grid_3 -->

      <div class="grid_6" style="margin-top: 10px;margin-left: 92px;width: 400px;">
        <ul id="cart_nav">
          <li>
            <a class="cart_li" href="${pageContext.request.contextPath}/cart_cartPage" style="width: 80px;">购物车 <span>¥:<s:property value="#session.cart.total"/>0</span></a>
            <s:if test="#session.cart.cartItems.size() != 0 ">
            <ul class="cart_cont">
              <li class="no_border"><p>最近添加的商品</p></li>
              <s:iterator var="cartItem" value="#session.cart.cartItems">
	              <li>
	                <a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#cartItem.product.pid"/>" class="prev_cart"><div class="cart_vert"><img src="${pageContext.request.contextPath}/<s:property value="#cartItem.product.image"/>" /></div></a>
	                <div class="cont_cart">
	                  <h4 style="color: #000;"><s:property value="#cartItem.product.pname"/></h4>
	                 	<div style="font-size:10px;color: #777;">作者：<s:property value="#cartItem.product.author"/></div>
	                  <div class="price" style="margin-top: 3px;"><s:property value="#cartItem.count"/> x ¥ <s:property value="#cartItem.product.shop_price"/>0</div>
	                </div>
	                <a title="close" class="close" href="${pageContext.request.contextPath}/cart_removeCart?pid=<s:property value="#cartItem.product.pid"/>"></a>
	                <div class="clear"></div>
	              </li>
             </s:iterator>
		      <li class="no_border">
				<a href="${pageContext.request.contextPath}/cart_cartPage" class="view_cart">查看购物车</a>
				<a href="${pageContext.request.contextPath}/order_save" class="checkout">提交订单</a>
		      </li>
          </ul>
          </s:if> 
          <s:else>
          	<ul class="cart_cont">
          		<div align="center"><img style="width: 300px;height: 360px;" src="${pageContext.request.contextPath}/image/no purchases.png"/></div>
          	</ul>
          </s:else>
          </li>
        </ul>

        <nav class="private">
          <ul>
          <s:if test="#session.user == null">
            <li><a href="${pageContext.request.contextPath}/user_loginPage">会员登录</a></li>
			<li class="separator">|</li>
            <li><a href="${pageContext.request.contextPath}/user_registPage">会员注册</a></li>
			<li class="separator">|</li>
		  </s:if>
		  <s:else>
            <li><a href="${pageContext.request.contextPath}/order_findByUid?page=1">我的订单</a></li>
			<li class="separator">|</li>
		  	<li><a href="${pageContext.request.contextPath}/user_findLikeByUid?page=1&limit=6">我的收藏 </a></li>
			<li class="separator">|</li>
			<li><a href="${pageContext.request.contextPath}/user_quit">注销</a></li>
			<li class="separator">|</li>
		  </s:else>
            <li><a class="alert-api-button alert-btn6" style="padding-right: 20px;">购物指南</a></li>
          </ul>
        </nav><!-- .private -->
      </div><!-- .grid_6 -->
    </header><!-- #branding -->
  </div><!-- .container_12 -->
  
  <div class="clear"></div>

  <div id="block_nav_primary"  class="menu" style="background-color: #f5f7f9;">
    <div class="container_12">
      <div class="grid_12" id="menu1" >
        <nav class="primary">
          <ul>
            <li><a href="${pageContext.request.contextPath}/index">首页</a></li>
            <s:iterator var="c" value="#session.cList">
            	<li><a href="${pageContext.request.contextPath}/product_findByCid?cid=<s:property value="#c.cid"/>&page=1&limit=6"><s:property value="#c.cname"/> </a></li>
			</s:iterator>
            <li><a href="${pageContext.request.contextPath}/product_findAll?page=1&limit=6">全部商品</a></li>
          </ul>
        </nav><!-- .primary -->
      </div><!-- .grid_12 -->
    </div><!-- .container_12 -->
  </div><!-- .block_nav_primary -->