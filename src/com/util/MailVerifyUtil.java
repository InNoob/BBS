package com.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;


public class MailVerifyUtil {
	
	public static final void  sendMail(String reciver,String content) throws Exception{
		Properties prop =  new Properties();
		MailSSLSocketFactory sf = new MailSSLSocketFactory();
        sf.setTrustAllHosts(true);
        prop.put("mail.smtp.ssl.enable", "false");
        prop.put("mail.smtp.ssl.socketFactory", sf);
//		prop.put("mail.smtp.port","25");
        prop.put("mail.smtp.host","smtp.163.com");
        prop.setProperty("mail.smtp.connectiontimeout", "5000");
		prop.put("mail.smtp.auth","true");
		Session session = Session.getInstance(prop,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication(){
				return new PasswordAuthentication("innoob@163.com","jb71415");
			}				
		});
		session.setDebug(true);
		Message msg = new MimeMessage(session);
	    msg.setFrom(new InternetAddress("innoob@163.com","BoBoSi账户审查小组","UTF-8"));
	    msg.setRecipient(Message.RecipientType.TO,new InternetAddress(reciver));
	    msg.setSubject("注册验证");
	    msg.setContent(content,"text/html;charset=UTF-8");
	    Transport.send(msg);
	}
	
//	public static void main(String[] args) {
//		try {
//			MailVerifyUtil.sendMail("wp.1215@outlook.com","<h1>欢迎使用BoBoSi</h1></br>您的验证码是：5226");
//			System.out.println("send successful");
//		} catch (Exception e) {
//			e.printStackTrace();
//			// TODO: handle exception
//		}
//	}

}
