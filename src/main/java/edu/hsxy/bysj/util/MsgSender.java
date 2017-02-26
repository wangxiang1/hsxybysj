package edu.hsxy.bysj.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * MsgSender
 *
 * @author renguangli
 * @since JDK 1.8
 */
public final class MsgSender {

	private static final Logger logger = LoggerFactory.getLogger(MsgSender.class);

	public static boolean sendMsg(String phoneNo, String content) {
		try {
			PostMethod postMethod = new PostMethod("http://utf8.sms.webchinese.cn");
			postMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");// 在头文件中设置转码
			NameValuePair uid = new NameValuePair("Uid", "qzva1215");
			NameValuePair key = new NameValuePair("Key", "2b34d1af59b640be5771");
			NameValuePair smsMob = new NameValuePair("smsMob", phoneNo);
			NameValuePair smsText = new NameValuePair("smsText", content);
			NameValuePair[] data = { uid, key, smsMob, smsText };
			postMethod.setRequestBody(data);
			new HttpClient().executeMethod(postMethod);
			postMethod.releaseConnection();
			return true;
		} catch (Exception e) {
			logger.error("failed to send msg,", e.getMessage());
			return false;
		}
	}

}
