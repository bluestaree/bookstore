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
 * �����ʼ�������
 * @author dhw
 *
 */
public class MailUitls {
	/**
	 * �����ʼ��ķ���
	 * @param to	:�ռ���
	 * @param code	:������
	 */
	public static void sendMail(String to,String code){
		/**
		 * 1.���һ��Session����.
		 * 2.����һ�������ʼ��Ķ���Message.
		 * 3.�����ʼ�Transport
		 */
		// 1.������Ӷ���
		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.debug", "true");
		props.setProperty("mail.host", "smtp.163.com");	//���������ַ
		props.setProperty("mail.transport.protocol", "smtp");	//��������Э������
		Session session = Session.getInstance(props, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("18750515830", "qq1013393078");
			}
			
		});
		// 2.�����ʼ�����:
		Message message = new MimeMessage(session);
		try {
			// ���÷�����:
			message.setFrom(new InternetAddress("18750515830@163.com"));
			// �����ռ���:
			message.addRecipient(RecipientType.TO, new InternetAddress(to));
			// ���ñ���
			message.setSubject("����BookStore����ͼ�鹺���̳ǵĹٷ������ʼ�");
			// �����ʼ�����:
			message.setContent("<table><tr><td><h3>���ã���ӭ������BookStoreͼ�鹺���̳�!</h3></td></tr>" +
					"<tr><td><h4>����������������·���</h4>" +
					"<ul> <li>��Ʒ���ϡ����淢Ʊ</li><li>���������Ա����</li><li>�����˻����ͻ�����</li></ul></td></tr>" +
					"<tr><td><h4>�����������������û��������!</h4></td></tr>" +
					"<tr><td><h4><a href='http://localhost:8080/bookstore/user_active?code="+code+"'>����˴���ɼ��http://localhost:8080/bookstore/user_active?code="+code+"</a></h4></td></tr>" +
							"<tr><td>BookStore</td></tr></table>", "text/html;charset=UTF-8");
			// 3.�����ʼ�:
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	//������
	public static void main(String[] args) {
		sendMail("924201320@qq.com","11111111111111");
	}

}
