package edu.hsxy.bysj.bean;

/**
 * 
 * 功能描述:邮件实体类
 */
public class Mail {
	/**
	 * 邮件发送者
	 */
	private final String from = "18330822332@163.com";

	/**
	 * 邮件接受者
	 */
	private String to;

	/**
	 * 邮件主题
	 */
	private String subject;

	/**
	 * 邮件邮件内容
	 */
	private String text;

	public Mail() {
	}

	public Mail(String to, String subject, String text) {
		this.to = to;
		this.subject = subject;
		this.text = text;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Mail [from=" + from + ", to=" + to + ", subject=" + subject + ", text=" + text + "]";
	}

}
