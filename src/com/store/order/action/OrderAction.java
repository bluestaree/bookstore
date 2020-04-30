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
 * ����ģ��action
 * @author dhw
 *
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order>{
	//ģ�������������
	private Order order = new Order();
	public Order getModel() {
		return order;
	}

	//ע��orderService
	private OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	//����pageҳ��
	private int page;
	public void setPage(int page) {
		this.page = page;
	}
	
	//�������д���
	private String pd_FrpId;
	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}
	
	//���ո���ɹ������Ӧ����
	private String r6_Order;	//������
	private String r3_Amt;	//���
	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}
	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}
	
	//-------------------------------
	
	//���ɶ���
	public String save() {
		//��ȫ��������
		order.setOrdertime(new Date());
		order.setState(1);	//״̬��δ���1��
		//��ȡ���ﳵ����
		Cart cart = (Cart) ActionContext.getContext().getSession().get("cart");
		if(cart == null || cart.getCartItems().size() == 0) {
			return "cartEmpty";
		}
		order.setTotal(cart.getTotal());
		//�����ﳵ�����ݴ洢����������
		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setCount(cartItem.getCount());
			orderItem.setProduct(cartItem.getProduct());
			orderItem.setSubtotal(cartItem.getSubtotal());
			orderItem.setOrder(order);
			
			order.getOrderItems().add(orderItem);
		}
		//���ö��������û�
		User user = (User) ActionContext.getContext().getSession().get("user");
		if(user == null) {
			this.addActionError("�����ѱ��ܾ���ԭ������û�е�¼����ʱ���ܽ����ύ�����Ĳ���Ŷ��");
			return "msg";
		}
		order.setUser(user);
		order.setName(user.getName());
		order.setAddr(user.getAddr());
		order.setPhone(user.getPhone());
		//���������������ݿ�
		orderService.save(order);
		//��չ��ﳵ
		cart.clearCart();
		return "save";
	}
	
	//�����û�id��ѯ����
	public String findByUid() {
		//��ȡ�û�uid
		User user = (User) ActionContext.getContext().getSession().get("user");
		//��ѯ
		PageBean<Order> pageBean = orderService.findByPageUid(user.getUid(),page);
		//�����ݴ���ֵջ��
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "orderList";
	}
	
	//���ݶ���id��ѯ����
	public String findByOid() {
		order = orderService.findByOid(order.getOid());
		return "findByOid";
	}
	
	//��������
	public String payOrder() throws IOException {
		//�޸Ķ�����Ϣ
		Order _order = orderService.findByOid(order.getOid());
		_order.setName(order.getName());
		_order.setPhone(order.getPhone());
		_order.setAddr(order.getAddr());
		orderService.update(_order);
		//����(ʹ�õ�����ƽ̨�ױ������жԽ�)
		// ������Ҫ�Ĳ���:
		String p0_Cmd = "Buy"; // ҵ������
		String p1_MerId = "10001126856";// �̻����(������)
		String p2_Order = order.getOid().toString();// �������
		String p3_Amt = "0.01"; // ������
		String p4_Cur = "CNY"; // ���ױ���
		String p5_Pid = ""; // ��Ʒ����
		String p6_Pcat = ""; // ��Ʒ����
		String p7_Pdesc = ""; // ��Ʒ����
		String p8_Url = "http://localhost:8080/bookstore/order_callBack"; // ֧���ɹ�����ת��ַ
		String p9_SAF = ""; // �ͻ���ַ
		String pa_MP = ""; // �̻���չ��Ϣ
		String pd_FrpId = this.pd_FrpId;// ֧��ͨ������
		String pr_NeedResponse = "1"; // Ӧ�����
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // ��Կ
		String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
					p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
					pd_FrpId, pr_NeedResponse, keyValue); // ����hmac��
		// ���ױ���������:
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
				
		// �ض���:���ױ�����:
		ServletActionContext.getResponse().sendRedirect(sb.toString());
		return NONE;
	}
	
	//����ɹ���Ĵ������
	public String callBack() {
		//�޸Ķ���״̬
		Order _order = orderService.findByOid(Integer.parseInt(r6_Order));
		_order.setState(2);
		orderService.update(_order);
		//���Ը���״̬��Ϣ
		this.addActionMessage("��������ɹ���������ţ� "+r6_Order+"  ֧����" + r3_Amt );
		return "msg";
	}
	
	//ȷ���ջ����޸Ķ���״̬
	public String updateState() {
		//��ѯ����
		Order _order = orderService.findByOid(order.getOid());
		//�޸Ķ���״̬
		_order.setState(4);
		orderService.update(_order);
		return "updateState";
	}
}
