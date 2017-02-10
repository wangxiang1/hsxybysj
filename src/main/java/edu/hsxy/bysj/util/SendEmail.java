package edu.hsxy.bysj.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import edu.hsxy.bysj.bean.Mail;

public class SendEmail {
	/**
	 * 发送邮件
	 * 
	 * @see MailUtil#sendmail
	 */
	public static final void sendmail(Mail mail) {
		try {
			Properties prop = new Properties();
			prop.setProperty("mail.host", "smtp.163.com");
			prop.setProperty("mail.transport.protocol", "smtp");
			prop.setProperty("mail.smtp.auth", "true");
			prop.setProperty("mail.smtp.starttls.enable", "true");
			prop.setProperty("mail.smtp.starttls.required", "true");

			// 使用JavaMail发送邮件的5个步骤
			// 1、创建session
			Session session = Session.getInstance(prop);
			// 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
			session.setDebug(true);
			// 2、通过session得到transport对象
			Transport ts = session.getTransport();
			// 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
			ts.connect("smtp.163.com", mail.getFrom(), "1120233911");
			// 4、创建邮件
			Message message = createSimpleMail(session, mail);
			// 5、发送邮件
			ts.sendMessage(message, message.getAllRecipients());
			ts.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 描述: 创建一封只包含文本的邮件
	 */
	public static MimeMessage createSimpleMail(Session session, Mail mail) throws Exception {
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 指明邮件的发件人
		message.setFrom(new InternetAddress(mail.getFrom()));
		// 指明邮件的收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(mail.getTo()));
		// 邮件的标题
		message.setSubject(mail.getSubject());
		// 邮件的文本内容
		message.setContent(mail.getText(), "text/html;charset=UTF-8");
		// 返回创建好的邮件对象
		return message;
	}

	public static void main(String[] args) {
		sendmail(new Mail("1120233911@qq.com", "ceshi", "ceshi"));
	}

}
