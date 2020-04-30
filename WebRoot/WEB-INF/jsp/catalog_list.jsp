<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  uri="/struts-tags" prefix="s" %>    
<!DOCTYPE HTML>
<html>
<meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
  <meta charset="UTF-8">
  <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.html">
  <meta name="description" content="">
  <meta name="keywords" content="">

  <title>商品列表</title>

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
	  $('#list_banners').carouFredSel({
		prev: '#ban_prev',
		next: '#ban_next',
		scroll: 1,
		auto: false
	  });
      $('#list_product2').carouFredSel({
		prev: '#prev_c2',
		next: '#next_c2',
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
	      
	      //下拉动画
	      $("div.showcsdiv").click(function(){
		     var cid = $(this).attr("title1");
			  $("#div" + cid).toggle(500);
	      }); 
	      
	      //自定义每页商品显示数目
	      $("#limitByCid").change(function(){
		     location.href="${pageContext.request.contextPath}/product_findByCidList?cid="+$(this).attr("title")+"&page=1&limit="+$(this).val();
	      });   
	       $("#limitByCsid").change(function(){
		     location.href="${pageContext.request.contextPath}/product_findByCsidList?csid="+$(this).attr("title")+"&page=1&limit="+$(this).val();
	      });         
       })
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
	      <span class="current">图书列表</span><span>&#8250;</span>
	      <span class="current"><s:property value="cg.cname"/><s:property value="cgs.csname"/></span>
       </div><!-- .breadcrumbs -->
    </div><!-- .grid_12 -->
  </div><!-- .container_12 -->
  
  <div class="clear"></div>
  
  <section id="main">
    <div class="container_12">
       <div id="sidebar" class="grid_3">
	      <aside id="categories_nav">
		     <h3 style="margin-bottom: 0px;">图书分类</h3>
		     <nav class="left_menu">
		     <s:iterator var="c" value="#session.cList">
			    <s:set var="cscount" value="0" ></s:set>
		     	<s:iterator begin="1" end="#c.categorySeconds.size()">
		     		<s:set var="cscount" value="#cscount + 1" ></s:set>
		     	</s:iterator>
		     	<div class="showcsdiv" title1="<s:property value="#c.cid"/>" >
		     		<a  href="javascript:void(0)" style=" color: #59b7c2;"><s:property value="#c.cname"/><span style="padding-left: 10px;color: #777;">( <s:property value="#cscount" /> )</span><span style="padding-left: 145px;color: #777;font-weight: 700;background: url(${pageContext.request.contextPath}/images/select-button.png) no-repeat right top;"></span></a>
		     		  <div id="div<s:property value="#c.cid"/>"  style="display: none;height: 130px" >
		     			<s:iterator var="cs" value="#c.categorySeconds">
						   		<dl style="width:112px; float: left;" >
										<a href="${pageContext.request.contextPath}/product_findByCsidList?csid=<s:property value="#cs.csid"/>&page=1&limit=6"><s:property value="#cs.csname"/> </a>
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
	      <h1 class="page_title">商品列表<span style="padding-left: 20px;font-size: 12px;color: #e0e0e0;">Product List</span></h1>
	      
	      <div class="options">
		     <div class="grid-list">
		     <s:if test="cid != null">
				   <a class="grid curent" style="background: #ffffff;"  href="${pageContext.request.contextPath}/product_findByCid?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page"/>&limit=<s:property value="pageBean.limit"/>"><span>img</span></a>
			 </s:if>
			 <s:if test="csid != null">
				   <a class="grid curent" style="background: #ffffff;"  href="${pageContext.request.contextPath}/product_findByCsid?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page"/>&limit=<s:property value="pageBean.limit"/>"><span>img</span></a>
			 </s:if>
				<a class="list" style="background: #f5f7f9;opacity: unset;"><span>img</span></a>
				<div style="width: 180px;margin-top: 20px;margin-left: 140px;">按 <font color="red">  "<s:property value="cg.cname"/><s:property value="cgs.csname"/>" </font>分类</div>
		     </div><!-- .grid-list -->
		     
		     <div class="show">
			    	每页显示记录数
			    <s:if test="cid != null">	
			    <select id="limitByCid" title="<s:property value="cid"/>" name="limit" >
			    	<s:iterator begin="1" end="9" var="i">
			    		<s:if test="pageBean.limit != #i">
					   		<option><s:property value="#i" /></option>
					   </s:if>
					   <s:else>
					   		<option selected="selected"><s:property value="#i" /></option>
					   </s:else>
				   </s:iterator>
			     </select>
			  </s:if> 
			  <s:if test="csid != null">	
			    <select id="limitByCsid" title="<s:property value="csid"/>" name="limit" >
				  <s:iterator begin="1" end="8" var="i">
			    		<s:if test="pageBean.limit != #i">
					   		<option><s:property value="#i" /></option>
					   </s:if>
					   <s:else>
					   		<option selected="selected"><s:property value="#i" /></option>
					   </s:else>
				   </s:iterator>
			     </select>
			  </s:if>   
		     </div><!-- .show -->
		     
		     <div class="sort" style="margin-top: 19px;margin-right: 5px;">
		     	共查询到 <s:property value="pageBean.totalCount" /> 条符合条件的商品
		     </div><!-- .sort -->
	      </div><!-- .options -->
	      
	      <div class="listing_product">
	      <s:if test="pageBean.list == null">
	      	<div><img style="width: 730px;" src="${pageContext.request.contextPath}/image/not found.png" /></div>
	      	<div  align="center" style="margin-top: 10px;">没有查询到相关商品</div>
	      </s:if>
	      <s:else>
	      <s:iterator var="p" value="pageBean.list">
			<div class="product_li">
				<div class="grid_3">
					<img class="sale" src="${pageContext.request.contextPath}/images/sale.png" />
					<div class="prev">
						<a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#p.pid"/>"><img src="${pageContext.request.contextPath}/<s:property value="#p.image"/>" /></a>
					</div><!-- .prev -->
				</div><!-- .grid_3 -->
				
				<div class="grid_4">
					<div class="entry_content">
						<a href="${pageContext.request.contextPath}/product_findByPid?pid=<s:property value="#p.pid"/>"><h3 class="title" style="font-weight:  700;"><s:property value="#p.pname"/></h3></a>
						<div class="review">
						<s:if test="#p.reviews.size() != 0">
							<s:set var="count" value="0"></s:set>
							<s:set var="qualitys" value="0"></s:set>
								<s:iterator var="review" value="#p.reviews">
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
						</s:if>
						<s:else>
							<a></a><a></a><a></a><a></a><a></a>
							<span>暂无评论</span>
						</s:else>
						</div>
						<p><s:property value="#p.spoint"/></p>
					</div><!-- .entry_content -->
				</div><!-- .grid_4 -->
				
				<div class="grid_2">
					<div class="cart">
						<div class="price">
							<div class="price_new">￥:<s:property value="#p.shop_price"/>0</div>
							<div class="price_old" style="text-decoration:line-through;">￥:<s:property value="#p.market_price"/>0</div>
						</div>
						<a class="bay"><span title="添加到购物车" title1="<s:property value="#p.pid" />" style="width: 120px;height: 34px;padding-left: 0px;" class="alert-api-button alert-btn1">添加到购物车</span></a>
						<a title="同类书籍" href="${pageContext.request.contextPath}/product_related?pid=<s:property value="#p.pid"/>&csid=<s:property value="#p.categorySecond.csid"/>&page=1&limit=6" class="obn"></a>
						<a class="like"><span title="收藏"  title1="<s:property value="#session.user.uid" />" title2="<s:property value="#p.pid" />" style="width: 52px; height: 40px" class="alert-api-button alert-btn0"></span></a>
					</div><!-- .cart -->
				</div><!-- .grid_2 -->
				
				<div class="clear"></div>
			</div><!-- .article -->
			</s:iterator>
	      <div class="clear"></div>
	    </div><!-- .listing_product -->
	      
	    <div class="clear"></div>
	      
			<!-- 分页  -->
	      <div class="pagination">
		      <s:if test="cid != null">
			     <ul>
			     <s:if test="pageBean.page != 1">
			     	<li class="prev"><a href="${pageContext.request.contextPath}/product_findByCidList?cid=<s:property value="cid"/>&page=1&limit=<s:property value="pageBean.limit"/>">&lt;&lt;</a></li>
				    <li class="prev"><a href="${pageContext.request.contextPath}/product_findByCidList?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page - 1"/>&limit=<s:property value="pageBean.limit"/>">&lt;</a></li>
				 </s:if>   
				 <!-- 动态显示条 -->
	       		 <s:iterator begin="pageBean.start" end="pageBean.end" var="num">
	       		 	<s:if test="pageBean.page != #num">
	        	  		<li><a href="${pageContext.request.contextPath}/product_findByCidList?cid=<s:property value="cid"/>&page=<s:property value="#num"/>&limit=<s:property value="pageBean.limit"/>" ><s:property value="#num"/></a></li>
	        	  	</s:if>
	        	  	<s:else>
	        	  		<li class="curent"><a><s:property value="#num"/></a></li>
	        	  	</s:else>
	      		 </s:iterator>
				  <s:if test="pageBean.page != pageBean.totalPage">  
				    <li class="next"><a href="${pageContext.request.contextPath}/product_findByCidList?cid=<s:property value="cid"/>&page=<s:property value="pageBean.page + 1"/>&limit=<s:property value="pageBean.limit"/>">&gt;</a></li>
				    <li class="next"><a href="${pageContext.request.contextPath}/product_findByCidList?cid=<s:property value="cid"/>&page=<s:property value="pageBean.totalPage"/>&limit=<s:property value="pageBean.limit"/>">&gt;&gt;</a></li>
				  </s:if>  
			     </ul>
		      </s:if>
		      <s:if test="csid != null">
		      	 <ul>
			     <s:if test="pageBean.page != 1">
			     	<li class="prev"><a href="${pageContext.request.contextPath}/product_findByCsidList?csid=<s:property value="csid"/>&page=1&limit=<s:property value="pageBean.limit"/>">&lt;&lt;</a></li>
				    <li class="prev"><a href="${pageContext.request.contextPath}/product_findByCsidList?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page - 1"/>&limit=<s:property value="pageBean.limit"/>">&lt;</a></li>
				 </s:if>   
				 <!-- 动态显示条 -->
	       		 <s:iterator begin="pageBean.start" end="pageBean.end" var="num">
	       		 	<s:if test="pageBean.page != #num">
	        	  		<li><a href="${pageContext.request.contextPath}/product_findByCsidList?csid=<s:property value="csid"/>&page=<s:property value="#num"/>&limit=<s:property value="pageBean.limit"/>" ><s:property value="#num"/></a></li>
	        	  	</s:if>
	        	  	<s:else>
	        	  		<li class="curent"><a><s:property value="#num"/></a></li>
	        	  	</s:else>
	      		 </s:iterator>
				  <s:if test="pageBean.page != pageBean.totalPage">  
				    <li class="next"><a href="${pageContext.request.contextPath}/product_findByCsidList?csid=<s:property value="csid"/>&page=<s:property value="pageBean.page + 1"/>&limit=<s:property value="pageBean.limit"/>">&gt;</a></li>
				    <li class="next"><a href="${pageContext.request.contextPath}/product_findByCsidList?csid=<s:property value="csid"/>&page=<s:property value="pageBean.totalPage"/>&limit=<s:property value="pageBean.limit"/>">&gt;&gt;</a></li>
				  </s:if>  
			     </ul>
		      </s:if>
	      </div><!-- .pagination -->
	      <p class="pagination_info">第<s:property value="pageBean.page"/>页/共<s:property value="pageBean.totalPage"/>页</p>
	     </s:else>
       </div><!-- #content -->
       
      <div class="clear"></div>
      
    </div><!-- .container_12 -->
  </section><!-- #main -->
  
  <div class="clear"></div>
<%@ include file="foot.jsp" %>
</body>
</html>
