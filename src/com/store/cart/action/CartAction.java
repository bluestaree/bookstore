package com.store.cart.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.store.cart.domain.Cart;
import com.store.cart.domain.CartItem;
import com.store.product.domain.Product;
import com.store.product.service.ProductService;

/**
 * ���ﳵaction
 * @author dhw
 *
 */
public class CartAction extends ActionSupport{

	//������Ʒpid
	private Integer pid;
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	//��������count
	private Integer count;
	public void setCount(Integer count) {
		this.count = count;
	}
	//ע��productService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	//----------------------------------

	// �ڹ��ﳵ�������Ʒ
	public String addCart() {
		//��װһ��cartitem����
		CartItem cartItem = new CartItem();
		//��������
		cartItem.setCount(count);
		//��װ��Ʒ��Ϣ
		Product product = productService.findByPid(pid);	//����pid��ѯ
		cartItem.setProduct(product);
		//��ȡ���ﳵ����
		Cart cart = getCart();
		cart.addCart(cartItem);
		return "addCart";
	}

	// ajax�첽���� ��ӹ��ﳵ(����Ҫ���ؽ����ͼ)
	public String ajaxAddCart() {
		//��װһ��cartitem����
		CartItem cartItem = new CartItem();
		//��������
		cartItem.setCount(count);
		//��װ��Ʒ��Ϣ
		Product product = productService.findByPid(pid);	//����pid��ѯ
		cartItem.setProduct(product);
		//��ȡ���ﳵ����
		Cart cart = getCart();
		cart.addCart(cartItem);
		return NONE;
	}

	// ���¹��ﳵ
	public String updateCart() {
		// ��ù��ﳵ����
		Cart cart = getCart();
		cart.updateCart(pid, count);
		return "updateCart";
	}

	// ��չ��ﳵ
	public String clearCart() {
		// ��ù��ﳵ����
		Cart cart = getCart();
		cart.clearCart();
		return "clearCart";
	}

	// �Ƴ�������
	public String removeCart() {
		// ��ù��ﳵ����
		Cart cart = getCart();
		cart.removeCart(pid);
		return "removeCart";
	}

	// ��ת�����ﳵҳ��
	public String cartPage() {
		return "cartPage";
	}

	/**
	 * ��session�������л�ù��ﳵ����
	 * @return
	 */
	public Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if(cart == null) {	//�ж��Ƿ���ڹ��ﳵ
			cart = new Cart();	//�����Զ�㹺�ﳵ ������session
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}
}
