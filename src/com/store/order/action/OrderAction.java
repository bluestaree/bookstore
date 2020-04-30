package com.store.order.action;

import java.io.IOException;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.store.cart.domain.Cart;
import com.store.cart.domain.CartItem;
import com.store.order.domain.Order;
import com.store.order.domain.OrderItem;
import com.store.order.service.OrderService;
import com.store.user.domain.User;
import com.store.utils.PageBean;
import com.store.utils.PaymentUtil;

/**
 * 订单模块action
 * @author dhw
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order>{
	//模型驱动所需对象
	private Order order = new Order();
	public Order getModel() {
		return order;
	}

	//注入orderService
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//接收page页数
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//接收银行代码
	private String pd_FrpId;
	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}
	
	//接收付款成功后的响应数据
	private String r6_Order;	//订单号
	private String r3_Amt;	//金额
	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}
	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}
	
	//-------------------------------
	
	//生成订单
	public String save() {
		//补全订单数据
		order.setOrdertime(new Date());
		order.setState(1);	//状态：未付款（1）
		//获取购物车对象
		Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
		if(cart == null || cart.getCartItems().size() == 0) {
			return "cartEmpty";
		}
		order.setTotal(cart.getTotal());
		//将购物车的数据存储到订单项中
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setOrder(order);
			
			order.getOrderItems().add(orderItem);
		}
		//设置订单所属用户
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user == null) {
			this.addActionError("请求已被拒绝。原因：您还没有登录，暂时不能进行提交订单的操作哦！");
			return "msg";
		}
		order.setUser(user);
		order.setName(user.getName());
		order.setAddr(user.getAddr());
		order.setPhone(user.getPhone());
		//将订单保存至数据库
		orderService.save(order);
		//清空购物车
		cart.clearCart();
		return "save";
	}
	
	//根据用户id查询订单
	public String findByUid() {
		//获取用户uid
		User user = (User) ActionContext.getContext().getSession().get("user");
		//查询
		PageBean<Order> pageBean = orderService.findByPageUid(user.getUid(),page);
		//将数据存入值栈中
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "orderList";
	}
	
	//根据订单id查询订单
	public String findByOid() {
		order = orderService.findByOid(order.getOid());
		return "findByOid";
	}
	
	//订单付款
	public String payOrder() throws IOException {
		//修改订单信息
		Order _order = orderService.findByOid(order.getOid());
		_order.setName(order.getName());
		_order.setPhone(order.getPhone());
		_order.setAddr(order.getAddr());
		orderService.update(_order);
		//付款(使用第三方平台易宝与银行对接)
		// 付款需要的参数:
		String p0_Cmd = "Buy"; // 业务类型
		String p1_MerId = "10001126856";// 商户编号(测试用)
		String p2_Order = order.getOid().toString();// 订单编号
		String p3_Amt = "0.01"; // 付款金额
		String p4_Cur = "CNY"; // 交易币种
		String p5_Pid = ""; // 商品名称
		String p6_Pcat = ""; // 商品种类
		String p7_Pdesc = ""; // 商品描述
		String p8_Url = "http://localhost:8080/bookstore/order_callBack"; // 支付成功后跳转地址
		String p9_SAF = ""; // 送货地址
		String pa_MP = ""; // 商户扩展信息
		String pd_FrpId = this.pd_FrpId;// 支付通道编码
		String pr_NeedResponse = "1"; // 应答机制
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
					p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
					pd_FrpId, pr_NeedResponse, keyValue); // 生成hmac码
		// 向易宝发送请求:
		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		sb.append("hmac=").append(hmac);
				
		// 重定向:向易宝出发:
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
	}
	
	//付款成功后的处理操作
	public String callBack() {
		//修改订单状态
		Order _order = orderService.findByOid(Integer.parseInt(r6_Order));
		_order.setState(2);
		orderService.update(_order);
		//回显付款状态信息
		this.addActionMessage("订单付款成功！订单编号： "+r6_Order+"  支付金额：" + r3_Amt );
		return "msg";
	}
	
	//确认收货：修改订单状态
	public String updateState() {
		//查询订单
		Order _order = orderService.findByOid(order.getOid());
		//修改订单状态
		_order.setState(4);
		orderService.update(_order);
		return "updateState";
	}
}
