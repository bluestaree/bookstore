$(function(){	
	$('.alert-api-list').css('height',$(window).height());
   	$(window).scroll(function(){

   		if($(window).scrollTop() >= 224){
   			$('.alert-api-list').css({
   				'top' : $(window).scrollTop() - 224
   			})
   		}else{
   			$('.alert-api-list').css({
   				'top' : 0
   			})
   		}
   	})

   	$(document).delegate('.alert_list a','click',function(){
   		$('.alert_list a').removeClass('alert-api-hover');
   		$(this).addClass('alert-api-hover');
   	})

	SyntaxHighlighter.all();

	var M = {

	}

	// 提示框样式一(实现购物车功能)
	$(document).delegate(".alert-btn1",'click',function(){
	
		//设置请求路径
  		var url = "${pageContext.request.contextPath}/cart_ajaxAddCart";
  		//封装请求参数
  		var params = {"pid":$(this).attr("title1"),"count":"1"};
  		//ajax异步请求
  		$.ajax({
			"url":url,		
			"data":params,
			"type":"post",
			"success":function(data){
				M.dialog1 = jqueryAlert({
					'content' : '加入购物车成功',
					'closeTime' : 1000
				})
			},
			"error":function(){
				M.dialog1 = jqueryAlert({
					'content' : '服务器繁忙，请稍后再试！！！',
					'closeTime' : 1000
				})
			},
			"dataType":"text"
		});
  		M.dialog1.destroy();
  		
	})
	
	// 提示框样式一(实现收藏功能)
	$(document).delegate(".alert-btn0",'click',function(){
		//设置请求路径
  		var url = "${pageContext.request.contextPath}/user_like";
  		//封装请求参数
  		var params = {"uid":$(this).attr("title1"),"pid":$(this).attr("title2")};
  		if($(this).attr("title1").length > 1) {
  		//ajax异步请求
	  		$.ajax({
				"url":url,		
				"data":params,
				"type":"post",
				"success":function(data){
					M.dialog1 = jqueryAlert({
						'content' : '已添加收藏',
						'closeTime' : 1000
					})
				},
				"error":function(){
					M.dialog1 = jqueryAlert({
						'content' : '服务器繁忙，请稍后再试！！！',
						'closeTime' : 1000
					})
				},
				"dataType":"text"
			});
	  		M.dialog1.destroy();
  		}else {
  			M.dialog1 = jqueryAlert({
				'content' : '请先登录',
				'closeTime' : 1000
			})
			M.dialog1.destroy();
  		}
  		
	})
	
	// 提示框样式二(购物车操作提示)
	$(document).delegate(".alert-btn2",'click',function(){
		var num = parseInt($(this).attr("title1"));
		var pid = $(this).attr("title2");
		//首先判断是否满足触发条件
		if(num < 1) {
			M.dialog2 = jqueryAlert({
				'title'   : '提示信息',
				'content' : '是否需要删除该商品',
				'modal'   : true,
				'animateType' : '',
				'buttons' :{
					'确    定' : function(){
						M.dialog2.close();
						M.dialog2.destroy();
						location.href="${pageContext.request.contextPath }/cart_removeCart?pid=" + pid;
					},
					'取    消' : function(){
						M.dialog2.close();
						M.dialog2.destroy();
					}
				}
			})
		}
		else {
			location.href="${pageContext.request.contextPath }/cart_updateCart?pid="+ pid +"&count=" + num;
		}
	})
	
	// 提示框样式二(购物车操作提示)
	$(document).delegate(".alert-btn3",'change',function(){
		var num = parseInt($(this).val());
		var pid = $(this).attr("title1");
		//首先判断是否满足触发条件
		if(num < 1) {
			M.dialog2 = jqueryAlert({
				'title'   : '提示信息',
				'content' : '是否需要删除该商品',
				'modal'   : true,
				'animateType' : '',
				'buttons' :{
					'确    定' : function(){
						M.dialog2.close();
						M.dialog2.destroy();
						location.href="${pageContext.request.contextPath }/cart_removeCart?pid=" + pid;
					},
					'取    消' : function(){
						M.dialog2.close();
						M.dialog2.destroy();
						location.reload();
					}
				}
			})
		}
		else {
			location.href="${pageContext.request.contextPath }/cart_updateCart?pid="+ pid +"&count=" + num;
		}
	})
	
	// 提示框样式二(后台删除提示)
	$(document).delegate(".alert-btn4",'click',function(){
		var url = $(this).attr("title1");
		//提示
		M.dialog2 = jqueryAlert({
			'title'   : '提示信息',
			'content' : "是否执行删除操作<br/><font color='red'>注意：删除后将不能复原</font>",
			'modal'   : true,
			'height'   : '140px',
			'animateType' : '',
			'buttons' :{
				'确    定' : function(){
					M.dialog2.close();
					M.dialog2.destroy();
					location.href= url;
				},
				'取    消' : function(){
					M.dialog2.close();
					M.dialog2.destroy();
				}
			}
		})
	})
	
	// 提示框样式五(订单详情的显示)
	$(document).delegate(".alert-btn5",'click',function(){
		//设置请求路径
  		var url = "${pageContext.request.contextPath}/adminOrder_findOrderItem";
  		//封装请求参数
  		var params = {"oid":$(this).attr("title1")};
  	//ajax异步请求
  		$.ajax({
			"url":url,		
			"data":params,
			"type":"post",
			"success":function(data){
				M.dialog5 = jqueryAlert({
					'content' : data ,
					'modal'   : true,
					'contentTextAlign' : 'left',
					'width'   : '450px',
					'animateType' : 'linear',
					'buttons' :{
						'关闭' : function(){
							M.dialog5.close();
						}
					}
				})
			},
			"error":function(){
				M.dialog5 = jqueryAlert({
					'content' : '服务器繁忙，请稍后再试！！！',
					'closeTime' : 1000
				})
			},
			"dataType":"html"
		});
	})
	
	
	// 提示框样式五(购物指南)
	$(document).delegate(".alert-btn6",'click',function(){
		M.dialog6 = jqueryAlert({
			'style'   : 'pc',
			'title'   : '购  物  指  南',
			'content' :  "<img src='/bookstore/image/lc_t.jpg' style='height: 230px;width: 600px'>",
			'modal'   : true,
			'contentTextAlign' : 'left',
			'width'   : 'auto',
			'animateType' : 'linear',
			'buttons' :{
				'关  闭' : function(){
					M.dialog6.close();
					M.dialog6.destroy();
				},
			}
		})
	})
	
})