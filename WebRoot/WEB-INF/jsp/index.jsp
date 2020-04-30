<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
  <meta charset="UTF-8">
  <meta name="description" content="">
  <meta name="keywords" content="">

  <title>首页</title>

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

</head>
<body>
 <%@ include file="menu.jsp" %>

  <div class="clear"></div>

  <div class="container_12">
    <div class="grid_12">
        <div class="slidprev"><span>Prev</span></div>
        <div class="slidnext"><span>Next</span></div>
        <div id="slider">
          <div id="slide1">
            <a href="${pageContext.request.contextPath}/product_findByCid?cid=3&page=1&limit=6"><img src="${pageContext.request.contextPath}/images/content/slide6.jpg" title="励志" /></a>
          </div>

          <div id="slide2">
             <a href="${pageContext.request.contextPath}/product_findByCid?cid=1&page=1&limit=6"><img src="${pageContext.request.contextPath}/images/content/slide4.jpg" title="童书" /></a>
          </div>

          <div id="slide3">
             <a href="${pageContext.request.contextPath}/product_findByCid?cid=2&page=1&limit=6"><img src="${pageContext.request.contextPath}/images/content/slide5.jpg"  title="小说" /></a>
          </div>
        </div><!-- .slider -->
        <div id="myController">
          <div class="control"><span>1</span></div>
          <div class="control"><span>2</span></div>
          <div class="control"><span>3</span></div>
        </div>
    </div><!-- .grid_12 -->
  </div><!-- .container_12 -->
  
  <div class="clear"></div>

  <section id="main" class="home">
    <div class="container_12">
      <div id="top_button">
        <div class="grid_4">
          <a href="${pageContext.request.contextPath}/product_findByCid?cid=3&page=1&limit=6" class="button_block best_price">
            <img src="${pageContext.request.contextPath}/images/banner1.jpg" width="312px" height="101px" title="励志"/>
          </a><!-- .best_price -->
        </div><!-- .grid_4 -->

        <div class="grid_4">
          <a href="${pageContext.request.contextPath}/product_findByPid?pid=8001" class="button_block new_smells">
            <img src="${pageContext.request.contextPath}/images/banner2.jpg" width="312px" height="101px" title="历史"/>
          </a><!-- .new smells -->
        </div><!-- .grid_4 -->

        <div class="grid_4">
          <a href="${pageContext.request.contextPath}/product_findByCid?cid=1&page=1&limit=6" class="button_block only_natural">
            <img src="${pageContext.request.contextPath}/images/banner3.jpg" width="312px" height="101px" title="童书"/>
          </a><!-- .only_natural -->
        </div><!-- .grid_4 -->

        <div class="clear"></div>
      </div><!-- #top_button -->

      <div class="clear"></div>

      <div class="carousel">
        <div class="c_header" style="border-bottom: 5px solid #e0e0e0;">
          <div class="grid_10" style="width: 220px;margin-right: 0px;">
            <h2 style="color: #000000;background-color: #e0e0e0;width: 218px;padding-left: 10px;padding-bottom: 8px;
            padding-top: 15px;margin-top: 0px;height: 32px;"><span style="margin-left: 40px;">热  门  推  荐</span>
            </h2>
          </div><!-- .grid_10 -->
		  <div class="grid_2" style="font-size: 36px;color: #e0e0e0;width: 300px;margin-top: 16px;margin-right: 286px;margin-left: 22px;">Top Sales</div>
          <div class="grid_2">
            <a id="next_c1" class="next arows" href="#"><span>Next</span></a>
            <a id="prev_c1" class="prev arows" href="#"><span>Prev</span></a>
           </div><!-- .grid_2 -->
        </div><!-- .c_header -->
        <div class="list_carousel">

        <ul id="list_product" class="list_product">
        <s:iterator var="p" value="hList">
          <li>
            <div class="grid_3 product">
              <img class="sale" src="${pageContext.request.contextPath}/images/sale.png" alt="Sale"/>
              <div class="prev">
                <a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#p.pid" /> "><img src="${pageContext.request.contextPath}/<s:property value="#p.image" />"  /></a>
              </div><!-- .prev -->
              <h3 class="title"><div style="font-weight: 700;color: black;" align="center"><s:property value="#p.pname"/> </div><p align="center"> <s:property value="#p.press"/> </p></h3>
              <div class="cart">
                <div class="price">
                <div class="vert">
                  <div class="price_new"><s:property value="#p.shop_price"/>0</div>
                  <div class="price_old"><s:property value="#p.market_price"/>0</div>
                </div>
                </div>
                <a title="同类书籍" href="${pageContext.request.contextPath}/product_related?pid=<s:property value="#p.pid"/>&csid=<s:property value="#p.categorySecond.csid"/>&page=1&limit=6" class="obn"></a>
                <a class="like"><span title="收藏"  title1="<s:property value="#session.user.uid" />" title2="<s:property value="#p.pid" />" style="width: 42px; height: 40px" class="alert-api-button alert-btn0"></span></a>
                <a class="bay"><span title="添加到购物车"  title1="<s:property value="#p.pid" />" style="width: 42px; height: 40px" class="alert-api-button alert-btn1"></span></a>
              </div><!-- .cart -->
            </div><!-- .grid_3 -->
          </li>
		</s:iterator>
        </ul><!-- #list_product -->
        </div><!-- .list_carousel -->
      </div><!-- .carousel -->

      <div class="carousel">
        <div class="c_header" style="border-bottom: 5px solid #e0e0e0;">
          <div class="grid_10"  style="width: 220px;margin-right: 0px;">
            <h2 style="color: #000000;background-color: #e0e0e0;width: 218px;padding-left: 10px;padding-bottom: 8px;
            padding-top: 15px;margin-top: 0px;height: 32px;margin-bottom: 8px;"><span  style="margin-left: 40px;">新 书 上 架</span>
            </h2>
          </div><!-- .grid_10 -->
		  <div class="grid_2" style="font-size: 36px;color: #e0e0e0;width: 300px;margin-top: 16px;margin-right: 286px;margin-left: 22px;">New Products</div>
          <div class="grid_2">
            <a id="next_c2" class="next arows" href="#"><span>Next</span></a>
            <a id="prev_c2" class="prev arows" href="#"><span>Prev</span></a>
          </div><!-- .grid_2 -->
        </div><!-- .c_header -->

        <div class="list_carousel">
        <ul id="list_product2" class="list_product">
         <s:iterator var="p" value="nList">
          <li>
            <div class="grid_3 product">
              <img class="sale" src="${pageContext.request.contextPath}/images/new.png" alt="Sale"/>
              <div class="prev">
                <a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#p.pid" /> "><img src="${pageContext.request.contextPath}/<s:property value="#p.image" />"/></a>
              </div><!-- .prev -->
              <h3 class="title"><div style="font-weight: 700;color: black;" align="center"><s:property value="#p.pname"/> </div><p align="center"> <s:property value="#p.press"/> </p></h3>
              <div class="cart">
                <div class="price">
                <div class="vert">
				  <div class="price_new"><s:property value="#p.shop_price"/>0</div>
                  <div class="price_old"><s:property value="#p.market_price"/>0</div>
                </div>
                </div>
                <a title="同类书籍" href="${pageContext.request.contextPath}/product_related?pid=<s:property value="#p.pid"/>&csid=<s:property value="#p.categorySecond.csid"/>&page=1&limit=6" class="obn"></a>
                <a class="like"><span title="收藏"  title1="<s:property value="#session.user.uid" />" title2="<s:property value="#p.pid" />" style="width: 42px; height: 40px" class="alert-api-button alert-btn0"></span></a>
                <a class="bay"><span title="添加到购物车" title1="<s:property value="#p.pid" />" style="width: 42px; height: 40px" class="alert-api-button alert-btn1"></span></a>
              </div><!-- .cart -->
            </div><!-- .grid_3 -->
          </li>
		</s:iterator>
        </ul><!-- #list_product2 -->
        </div><!-- .list_carousel -->
      </div><!-- .carousel -->

      <div id="content_bottom">
        <div class="grid_4">
          <div class="bottom_block about_as">
            <h2>作家大咖 <span style="padding-left: 10px;font-size: 14px;color: #e0e0e0;">Writer</span></h2>
            <img alt="" src="${pageContext.request.contextPath}/images/111.png" align="left"  style="padding-right: 20px">
            <span style="font-size: 18px;font-weight: bold;font-family: Arial;">卢思浩</span><br/><br/>
            <p>百万畅销书作家、编剧、作词人、电台主播。多年以来，他都以一个“老朋友”的身份，用文字的形式时刻陪伴、温暖着他的千万读者。出版作品：《你要去相信，没有到不了的明天》《愿有人陪你颠沛流离》《离开前请叫醒我》《你也走了很远的路吧》等。</p>
          </div><!-- .about_as -->
        </div><!-- .grid_4 -->

        <div class="grid_4">
          <div class="bottom_block news" style="height: 324px;">
            <h2>最新动态<span style="padding-left: 10px;font-size: 14px;color: #e0e0e0;">News</span></h2>
            <ul>
              <li>
                <time style="height: 22px;">2018-1-2</time>
                <a href="${pageContext.request.contextPath}/product_findByCsid?csid=32&page=1&limit=6">生命不息，学习不止。即日起计算机类图书开展大促销活动，还没涨工资，先来涨技能。在这里没有里找不到的书。。</a>
              </li>

              <li>
                <time style="height: 22px;">2017-12-1</time>
                <a href="${pageContext.request.contextPath}/product_findByCsid?csid=7&page=1&limit=6">小说类图书促销月。最低9.9元秒杀。注：本活动不支持团购，且同一IP，同一收货地址或同一收货电话账户只能购买一次。</a>
              </li>

              <li>
                <time style="height: 22px;">2017-8-30</time>
                <a href="${pageContext.request.contextPath}/product_findByCsid?csid=27&page=1&limit=6">开学季，中小学辅导图书全场满99减10，各类教育类图书满100减10，欢迎广大书友进场选购。</a>
              </li>
            </ul>
          </div><!-- .news -->
        </div><!-- .grid_4 -->

        <div class="grid_4">
          <div class="bottom_block newsletter" style="height: 324px;">
            <h2 style="padding-bottom: 0px;">畅销排行榜<span style="padding-left: 10px;font-size: 14px;color: #e0e0e0;">Sales Ranking</span></h2>
            	<table    style="font-size:  16px;">
	            	<tr>
	            		<td style="width: 60px;color: #ff0202;">
	            			1.
	            		</td>
	            		<td style="padding-right: 20px;">
	            		<a href="${pageContext.request.contextPath}/product_findByPid?pid=2001" style="text-decoration:none;color: black;">我们一无所有</a>
	            		</td>
	            	</tr>
	            	<tr>
	            		<td style="width: 60px;color: #ff0202;">
	            			2.
	            		</td>
	            		<td style="padding-right: 20px;">
	            		<a href="${pageContext.request.contextPath}/product_findByPid?pid=3003" style="text-decoration:none;color: black;">为生命而阅读</a>
	            		</td>
	            	</tr>
	            	<tr>
	            		<td style="width: 60px;color: #ff0202;">
	            			3.
	            		</td>
	            		<td style="padding-right: 20px;">
	            		  <a href="${pageContext.request.contextPath}/product_findByPid?pid=1014" style="text-decoration:none;color: black;">帕丁顿熊经典电影小说</a>
	            		</td>
	            	</tr>
	            	<tr>
	            		<td style="width: 60px;">
	            			4.
	            		</td>
	            		<td style="padding-right: 20px;">
	            		  <a href="${pageContext.request.contextPath}/product_findByPid?pid=3005" style="text-decoration:none;color: black;">学会表达懂得沟通</a>
	            		</td>
	            	</tr>
	            	<tr>
	            		<td style="width: 60px;">
	            			5.
	            		</td>
	            		<td style="padding-right: 20px;">
	            		  <a href="${pageContext.request.contextPath}/product_findByPid?pid=8003" style="text-decoration:none;color: black;">中国历史地理十五讲</a>
	            		</td>
	            	</tr>
              	</table>
          </div><!-- .newsletter -->
        </div><!-- .grid_4 -->

        <div class="clear"></div>
      </div><!-- #content_bottom -->
      <div class="clear"></div>

    </div><!-- .container_12 -->
  </section><!-- #main -->
  <div class="clear"></div>
<%@ include file="foot.jsp" %>
	
</body>
</html>
    