package com.store.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 * 发送邮件工具类
 * @author dhw
 *
 */
public class MailUitls {
	/**
	 * 发送邮件的方法
	 * @param to	:收件人
	 * @param code	:激活码
	 */
	public static void sendMail(String to,String code){
		/**
		 * 1.获得一个Session对象.
		 * 2.创建一个代表邮件的对象Message.
		 * 3.发送邮件Transport
		 */
		// 1.获得连接对象
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.debug", "true");
		props.setProperty("mail.host", "smtp.163.com");	//发送邮箱地址
		props.setProperty("mail.transport.protocol", "smtp");	//发送邮箱协议名称
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("18750515830", "qq1013393078");
			}
			
		});
		// 2.创建邮件对象:
		Message message = new MimeMessage(session);
		try {
			// 设置发件人:
			message.setFrom(new InternetAddress("18750515830@163.com"));
			// 设置收件人:
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// 设置标题
			message.setSubject("来自BookStore网上图书购物商城的官方激活邮件");
			// 设置邮件正文:
			message.setContent("<table><tr><td><h3>您好，欢迎您加入BookStore图书购物商城!</h3></td></tr>" +
					"<tr><td><h4>现在你可以享受以下服务</h4>" +
					"<ul> <li>正品保障、正规发票</li><li>货到付款、会员服务</li><li>自由退还、送货上门</li></ul></td></tr>" +
					"<tr><td><h4>请点击下面的链接完成用户激活操作!</h4></td></tr>" +
					"<tr><td><h4><a href='http://localhost:8080/bookstore/user_active?code="+code+"'>点击此处完成激活。http://localhost:8080/bookstore/user_active?code="+code+"</a></h4></td></tr>" +
							"<tr><td>BookStore</td></tr></table>", "text/html;charset=UTF-8");
			// 3.发送邮件:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	//测试用
	public static void main(String[] args) {
		sendMail("924201320@qq.com","11111111111111");
	}

}
