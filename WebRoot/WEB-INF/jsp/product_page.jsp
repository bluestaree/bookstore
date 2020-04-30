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

  <title>商品详情页面</title>

  <link href="${pageContext.request.contextPath}/css/style.css" media="screen" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/css/grid.css" media="screen" rel="stylesheet" type="text/css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.jqzoom.css" type="text/css">
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
  <script src="${pageContext.request.contextPath}/js/jquery.jqzoom-core.js" ></script>
  
  <script src="${pageContext.request.contextPath}/js/SyntaxHighlighter/shCore.js"></script>
  <script src="${pageContext.request.contextPath}/js/SyntaxHighlighter/makeSy.js"></script>
  <!--弹出层代码-->
  <script src="${pageContext.request.contextPath}/js/alert.js"></script>
  <script src="${pageContext.request.contextPath}/js/alert-api.js"></script>
      <!-- 菜单栏动画 -->
  <script src="${pageContext.request.contextPath}/js/menu.js"></script>
  <script>
	$(document).ready(function() {
		$('.jqzoom').jqzoom({
			zoomType: 'standard',
			lens:true,
			preloadImages: true,
			alwaysOn:false
		});
	});
  </script>

  <script>
	$(document).ready(function() {
		$("select").selectBox();
	});
  </script>

  <script>
	$(document).ready(function() {
		$('#wrapper_tab a').click(function() {
			if ($(this).attr('class') != $('#wrapper_tab').attr('class') ) {
				$('#wrapper_tab').attr('class',$(this).attr('class'));
			}
			return false;
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
          $('#list_banners').carouFredSel({
		prev: '#ban_prev',
		next: '#ban_next',
		scroll: 1,
		auto: false
	  });
	  $('#thumblist').carouFredSel({
		prev: '#img_prev',
		next: '#img_next',
		scroll: 1,
		auto: false,
		circular: false,
	  });
	  $(window).resize();
	});
  </script>
  <script>
       $(document).ready(function(){
	      $("button").click(function(){
		     $(this).addClass('click')
	      });
	      //动态指标等级文本显示
	      $("span.niceRadio").click(function(){
	      	var rank = $("span.niceRadio.radioChecked>input").val();
		   	if(rank == 1) {
		   		$("#strong1").text("不推荐");
		   	}
		   	if(rank == 2) {
		   		$("#strong1").text("差强人意");
		   	}
		   	if(rank == 3) {
		   		$("#strong1").text("一般");
		   	}
		   	if(rank == 4) {
		   		$("#strong1").text("推荐");
		   	}
		   	if(rank == 5) {
		   		$("#strong1").text("神作");
		   	}
	      });
	     //表单提交验证
		 $("form.add_comments").submit(function(){
				if($("#rname").val().length < 1){
					$("#rname_tip").css("display","inline").text("请输入评论人");
					$("#rname").css("border-color","red").focus();
					return false;
				}	
				if($("#rtext").val().length < 1){
					$("#rtext_tip").css("display","inline").text("请输入评论的内容");
					$("#rtext").css("border-color","red").focus();
					return false;
				}
	      });
	       //提示信息隐藏
	      $("form.add_comments input").change(function(){
	      	var cid = $(this).attr("title1");
			  $("#div" + cid).toggle(500);
		  });
		  //下拉动画
	      $("div.showcsdiv").click(function(){
		     var cid = $(this).attr("title1");
			  $("#div" + cid).toggle(500);
	      }); 
	   });   
  </script>
  <script type="text/javascript">
		function saveCart() {
			document.getElementById("cartForm").submit();
		}
  </script>
</head>
<body>
  <%@ include file="menu.jsp" %>
  <div class="clear"></div>

  <div class="container_12">
    <div class="grid_12">
       <div class="breadcrumbs">
	      <span class="current">首页</span><span>&#8250;</span>
	      <span class="current">目录</span><span>&#8250;</span>
	      <span class="current">商品详情</span>
       </div><!-- .breadcrumbs -->
    </div><!-- .grid_12 -->
  </div><!-- .container_12 -->

  <div class="clear"></div>

  <section id="main">
    <div class="container_12">
       <div id="sidebar" class="grid_3">
	      <aside id="categories_nav">
		     <h3>图书分类</h3>
		     <nav class="left_menu">
		     	<s:iterator var="c" value="#session.cList">
		     	<s:set var="cscount" value="0" ></s:set>
		     	<s:iterator begin="1" end="#c.categorySeconds.size()">
		     		<s:set var="cscount" value="#cscount + 1" ></s:set>
		     	</s:iterator>
		     	<div class="showcsdiv" title1="<s:property value="#c.cid"/>">
		     		<a  href="javascript:void(0)" style=" color: #59b7c2;"><s:property value="#c.cname"/><span style="padding-left: 10px;color: #777;">( <s:property value="#cscount" /> )</span><span style="padding-left: 145px;color: #777;font-weight: 700;background: url(${pageContext.request.contextPath}/images/select-button.png) no-repeat right top;"></span></a>
		     		  <div id="div<s:property value="#c.cid"/>"  style="display: none;height: 130px" >
		     			<s:iterator var="cs" value="#c.categorySeconds">
						   		<dl style="width:112px; float: left;" >
										<a href="${pageContext.request.contextPath}/product_findByCsid?csid=<s:property value="#cs.csid"/>&page=1&limit=6"><s:property value="#cs.csname"/> </a>
								</dl>
						</s:iterator>
					</div>	
					<div class="clear"></div>
		     	</div>
		     <hr/>
		     </s:iterator>
		     </nav><!-- .left_menu -->
	      </aside><!-- #categories_nav -->


	    <aside id="banners">
		<a id="ban_next" class="next arows" href="#"><span>Next</span></a>
		<a id="ban_prev" class="prev arows" href="#"><span>Prev</span></a>

		<h3>好书推荐</h3>

		<div class="list_carousel">
			<ul id="list_banners">
				<li class="banner">
					<a href="${pageContext.request.contextPath}/product_findByPid?pid=2006">
						<div class="prev">
							<img src="${pageContext.request.contextPath}/image/banner1.jpg" height="150px" width="180px"  alt="老人与海" title="老人与海" />
						</div><!-- .prev -->
						<h2>老人与海</h2>
						<p>The Old Man And the Sea</p>
	 			     </a>
 			     </li>

				<li class="banner">
					<a href="${pageContext.request.contextPath}/product_findByPid?pid=7002">
						<div class="prev">
							<img src="${pageContext.request.contextPath}/image/banner2.jpg" height="160px" width="180px"  alt="java编程思想" title="java编程思想" />
						</div><!-- .prev -->
						<h2>java编程思想</h2>
						<p>Think in Java</p>
 			        </a>
 			    </li>

				<li class="banner">
					<a href="${pageContext.request.contextPath}/product_findByPid?pid=2007">
						<div class="prev">
							<img src="${pageContext.request.contextPath}/image/banner3.jpg" height="150px" width="180px" alt="海底两万里" title="海底两万里" />
						</div><!-- .prev -->
						<h2>海底两万里</h2>
						<p>Vingt mille lieues sous les mers</p>
	 			    </a>
 			    </li>
			</ul>
		</div><!-- .list_carousel -->
	      </aside><!-- #banners -->

	      <aside id="tags">
		     <h3>标签传送门</h3>
		     <a class="t1" href="${pageContext.request.contextPath}/product_findByCsid?csid=12&page=1&limit=6">成功/励志</a>
		     <a class="t2" href="${pageContext.request.contextPath}/product_findByCsid?csid=8&page=1&limit=6">文学</a>
		     <a class="t3" href="${pageContext.request.contextPath}/product_findByCsid?csid=9&page=1&limit=6">艺术</a>
		     <a class="t4" href="${pageContext.request.contextPath}/product_findByCid?cid=6&page=1&limit=6">学习</a>
		     <a class="t5" href="${pageContext.request.contextPath}/product_findByCsid?csid=30&page=1&limit=6">外语</a>
		     <a class="t7" href="${pageContext.request.contextPath}/product_findByCid?cid=6&page=1&limit=6">教育</a>
		     <a class="t8" href="${pageContext.request.contextPath}/product_findByCsid?csid=13&page=1&limit=6">心灵修养</a>
		     <a class="t9" href="${pageContext.request.contextPath}/product_findByCid?cid=1&page=1&limit=6">儿童</a>
		     <a class="t10" href="${pageContext.request.contextPath}/product_findByCsid?csid=11&page=1&limit=6">动漫/幽默</a>
		     <a class="t11" href="${pageContext.request.contextPath}/product_findByCsid?csid=10&page=1&limit=6">青春文学</a>
		     <a class="t12" href="${pageContext.request.contextPath}/product_findByCsid?csid=32&page=1&limit=6">计算机/网络</a>
		     <a class="t13" href="${pageContext.request.contextPath}/product_findByCsid?csid=38&page=1&limit=6">历史</a>
		     <a class="t14" href="${pageContext.request.contextPath}/product_findByCsid?csid=14&page=1&limit=6">人生哲学</a>
		     <a class="t15" href="${pageContext.request.contextPath}/product_findByCsid?csid=33&page=1&limit=6">科普读物</a>
		     <a class="t16" href="${pageContext.request.contextPath}/product_findByCsid?csid=4&page=1&limit=6">婴儿读物</a>
		     <a class="t17" href="${pageContext.request.contextPath}/product_findByCsid?csid=7&page=1&limit=6">小说</a>
	      </aside><!-- #community_poll -->
       </div><!-- .sidebar -->

       <div id="content" class="grid_9">
	      <h1 class="page_title"><s:property value="model.pname"/> </h1>

		<div class="product_page">
			<div class="grid_4 img_slid" id="products">
				<img class="sale" src="${pageContext.request.contextPath}/images/sale.png" alt="Sale"/>
				<div class="preview slides_container">
					<div class="prev_bg">
						<a href="${pageContext.request.contextPath}/<s:property  value="model.image"/>" class="jqzoom" rel='gal1' >
							<img src="${pageContext.request.contextPath}/<s:property  value="model.image"/>" />
						</a>
					</div>
				</div><!-- .prev -->

				<ul class="pagination clearfix" id="thumblist">
					<li><a class="zoomThumbActive" href='javascript:void(0);' rel="{gallery: 'gal1', smallimage: '<s:property  value="model.image"/>',largeimage: '<s:property  value="model.image"/>'}"><img src='${pageContext.request.contextPath}/<s:property  value="model.image"/>' ></a></li>
				</ul>
			</div><!-- .grid_4 -->

			<div class="grid_5">
				<div class="entry_content">
					<div class="review">
					<s:if test="model.reviews.size() != 0">
						<s:set var="count" value="0"></s:set>
						<s:set var="qualitys" value="0"></s:set>
							<s:iterator var="review" value="model.reviews">
									<s:set var="count" value="#count + 1"></s:set>
									<s:set var="qualitys" value="#qualitys + #review.quality"></s:set>
							</s:iterator>
						<s:set var="rave" value="#qualitys / #count"></s:set>	
							<s:iterator begin="1" end="#rave">
								<a class="plus"></a>
							</s:iterator>
							
							<s:if test="#rave != 5">
								<s:iterator begin="#rave" end="4">
									<a></a>
								</s:iterator>
							</s:if>
						<span><s:property value="#count" />条评论</span>
						<a class="add_review" href="#review">添加评论</a>
					</s:if>
					<s:else>
						<a></a><a></a><a></a><a></a><a></a>
						<span>暂无评论</span>
						<a class="add_review" href="#review">添加评论</a>
					</s:else>
					</div>
					<p>&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="model.spoint"/></p>
					
					<div class="ava_price" style="padding-bottom: 45px;padding-top: 10px;">
						<div class="availability_sku">
							<div class="sku">
								作者: <span><s:property value="model.author"/></span><span style="padding-left: 20px;">出版社:<s:property value="model.press"/></span>
							</div>
							<div class="availability">
								商品状态: <span>在售</span>
							</div>
							<div class="sku">
								编号: <span><s:property value="model.pid"/></span>
							</div>
							<div class="sku">
								促销方式: <span style="background-color: #ec5364;text-shadow: inset 0px 0px 0px black;padding-left: 5px;padding-bottom: 3px;padding-right: 5px;padding-top: 2px;color:  #fff;">限时折扣</span>
							</div>
						</div><!-- .availability_sku -->

						<div class="price">
							<div class="price_new">￥:<s:property value="model.shop_price"/>0</div>
							<div class="price_old">￥:<s:property value="model.market_price"/>0</div>
						</div><!-- .price -->
					</div><!-- .ava_price -->

					<div class="block_cart" style="margin-top: 15px;">
						<div class="obn_like">
							<div class="like"> <a class="alert-api-button alert-btn0" title1="<s:property value="#session.user.uid" />" title2="<s:property value="model.pid" />" >收藏该商品</a></div>
						</div>
						<form name="cartForm" id="cartForm" action="${pageContext.request.contextPath}/cart_addCart" method="post">
							<input type="hidden" name="pid" value="<s:property value="model.pid"/>" />
							<div class="cart">
								<a href="javascript:void(0);" onclick="saveCart()" class="bay">添加到购物车</a>
								<input type="text" name="count"  id="count" class="number" value="1" />
								<span>数量:</span>
							</div>
						</form>
						<div class="clear"></div>
					</div><!-- .block_cart -->
				</div><!-- .entry_content -->

			</div><!-- .grid_5 -->

			<div class="clear"></div>

			<div class="grid_9" >
				<div id="wrapper_tab" class="tab1">
					<a href="#" class="tab1 tab_link">商品详情</a>
					<a name="review" href="#" class="tab2 tab_link">商品评论</a>

					<div class="clear"></div>

					<div class="tab1 tab_body">
						<h3 style="padding-bottom: 5px;box-shadow: 9px 9px #f1f3f5;">内 容 简 介</h3>
						<hr style="height:1px;border:none;border-top:1px solid #e0e0e0;margin-bottom: 10px;">
						<p style="line-height: 2;font-size: 14px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="model.pdesc"/></p>
						
					<div class="clear"></div>
					</div><!-- .tab1 .tab_body -->
					
					<div class="tab1 tab_body">
						<h3 style="padding-bottom: 5px;box-shadow: 9px 9px #f1f3f5;">作 者 简 介</h3>
						<hr style="height:1px;border:none;border-top:1px solid #e0e0e0;margin-bottom: 10px;">
						<p style="line-height: 2;font-size: 14px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s:property value="model.adesc"/></p>
						<hr/>
						<div>
							<img style="margin-top: 20px;" src="${pageContext.request.contextPath}/<s:property  value="model.image"/>">
						</div>
					<div class="clear"></div>
					</div><!-- .tab1 .tab_body -->

					<div class="tab2 tab_body">
						<h4 style="padding-bottom: 5px;box-shadow: 9px 9px #f1f3f5;">读者评论</h4>
						<hr style="height:1px;border:none;border-top:1px solid #e0e0e0;margin-bottom: 10px;">
						<s:if test="model.reviews.size() != 0">
							<ul class="comments">
								<s:iterator var="r" value="model.reviews">
								<li>
									<div class="autor" style="font-family: Arial">评论者：<s:property value="#r.rname"/></div><time style="margin-left: 30px;font-family: Arial; font-size: 14px;">评论时间： <s:property value="#r.reviewtime.toLocaleString()"/></time>
	
									<div class="evaluation">
										<div class="quality">
											<strong>推荐指数：</strong>
											<s:iterator begin="1" end="#r.quality">
												<a class="plus"></a>
											</s:iterator>
											<s:if test="#r.quality != 5">
												<s:iterator begin="#r.quality" end="4">
													<a></a>
												</s:iterator>
											</s:if>
										</div>
										<div class="price">
											<strong>
											<s:if test="#r.quality == 1">不推荐</s:if>
											<s:if test="#r.quality == 2">差强人意</s:if>
											<s:if test="#r.quality == 3">一般</s:if>
											<s:if test="#r.quality == 4">推荐</s:if>
											<s:if test="#r.quality == 5">神作</s:if>
											</strong>
										</div>
										<div class="clear"></div>
									</div><!-- .evaluation -->
	
									<p><s:property value="#r.rtext"/></p>
								</li>
							  </s:iterator>
							</ul><!-- .comments -->
						</s:if>
						<s:else>
							<div align="center" style="margin-top: 60px;font-size: 16px;margin-bottom: 60px;">该书还没有评论，在下面添加你的评论吧(oﾟvﾟ)ノ</div>
						</s:else>
						<hr/>
						<form id="add_comments" name="add_comments" class="add_comments" action="${pageContext.request.contextPath}/product_addReview?pid=<s:property value="model.pid"/>" method="post">
							<h4 style="padding-bottom: 5px;box-shadow: 9px 9px #f1f3f5;margin-top: 30px;">添加你的评论</h4>
							<hr style="height:1px;border:none;border-top:1px solid #e0e0e0;margin-bottom: 10px;">
							<div class="evaluation" id="divquality">
								<div class="quality" >
									<strong>推荐指数</strong><sup class="surely">*</sup>
									<input class="niceRadio" type="radio" name="quality" value="1" /><span class="eva_num">1</span>
									<input class="niceRadio" type="radio" name="quality" value="2" /><span class="eva_num">2</span>
									<input class="niceRadio" type="radio" name="quality" value="3" /><span class="eva_num">3</span>
									<input class="niceRadio" type="radio" name="quality" value="4" /><span class="eva_num">4</span>
									<input class="niceRadio" type="radio" name="quality" value="5" checked="checked" /><span class="eva_num">5</span>
								</div>
								<div class="price">
									<strong id="strong1">神作</strong>
								</div>
								<div class="clear"></div>
							</div><!-- .evaluation -->

							<div class="nickname">
								<strong>评论者：</strong><sup class="surely">*</sup><br/>
								<input type="text" id="rname" name="rname" class="" value=""  />
								<span id="rname_tip" style="margin-left: 10px;color: red;display: none"></span>
							</div><!-- .nickname -->

							<div class="clear"></div>

							<div class="text_review">
								<strong>评论</strong><sup class="surely">*</sup><br/>
								<textarea name="rtext" id="rtext" placeholder="在此输入你的评论..."></textarea>
								<span id="rtext_tip" style="margin-left: 10px;color: red;display: none"></span>
							</div><!-- .text_review -->

							<input type="submit"  value="提   交" />
						</form><!-- .add_comments -->
					<div class="clear"></div>
					</div><!-- .tab2 .tab_body -->

					<div class="clear"></div>
				</div>​<!-- #wrapper_tab -->
				<div class="clear"></div>
			</div><!-- .grid_9 -->
			<div class="clear"></div>
		</div><!-- .product_page -->
		<div class="clear"></div>

       </div><!-- #content -->

      <div class="clear"></div>

    </div><!-- .container_12 -->
  </section><!-- #main -->

  <div class="clear"></div>
<%@ include file="foot.jsp" %>
</body>
</html>
