package edu.hsxy.bysj.util;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

public class SendMsg {
	private final static Logger LOG = LoggerFactory.getLogger(SendMsg.class);

	public static boolean sendHtmlMail(String subject, String content, String receiver) {

		boolean result = true;

		try {
			JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

			// 设定mail server
			senderImpl.setHost("smtp.qq.com");
			senderImpl.setPort(345);
			senderImpl.setUsername(""); // 根据自己的情况,设置发件邮箱地址
			senderImpl.setPassword(""); // 根据自己的情况,
										// 设置password
			senderImpl.setDefaultEncoding("UTF-8");
			Properties prop = new Properties();
			prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
			prop.put("mail.smtp.ssl.enable", "true");
			prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			senderImpl.setJavaMailProperties(prop);

			// 建立邮件消息,发送简单邮件和html邮件的区别
			MimeMessage mailMessage = senderImpl.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage);

			// 设置收件人，寄件人
			messageHelper.setTo(receiver);
			messageHelper.setFrom("");
			messageHelper.setSubject(subject);
			// true 表示启动HTML格式的邮件
			messageHelper.setText(content, true);

			// 发送邮件
			senderImpl.send(mailMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			result = false;
			LOG.info("EmailUtils.method [sendHtmlMail]: email send result-" + result + ",error message-" + e);
		}

		return result;
	}
}
