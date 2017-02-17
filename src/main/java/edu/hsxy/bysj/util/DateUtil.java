package edu.hsxy.bysj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * JDK 1.8 <br/>
 * ClassName: DateUtil <br/>
 * author renguangli <br/>
 * date: 2016年11月21日 下午5:46:23 <br/>
 * 
 * 功能描述:时间工具类
 */
public final class DateUtil {

	/**
	 * 按格式yyyy-MM-dd HH:mm:ss获取当前时间
	 * 
	 * @see DateUtil#getNow
	 * @auther renguangli
	 * @return
	 */
	public static String getNow() {
		return getSdf("yyyy-MM-dd HH:mm:ss").format(new Date());
	}

	/**
	 * 按格式获取当前时间的字符串形式
	 *
	 * @see DateUtil#getNow
	 * @auther renguangli
	 * @param pattern
	 * @return
	 */
	public static String getNow(String pattern) {
		return getSdf(pattern).format(new Date());
	}

	/**
	 * 时间戳转换为yyyy-MM-dd HH:mm:ss格式
	 *
	 * @see DateUtil#format
	 * @auther renguangli
	 * @param date
	 * @return
	 */
	public static String format(Long date) {
		return getSdf("yyyy-MM-dd HH:mm:ss").format(date);
	}

	/**
	 * 时间戳转换为指定格式时间
	 * 
	 * @see DateUtil#format
	 */
	public static String format(Long date, String pattern) {
		return getSdf(pattern).format(date);
	}

	/**
	 * 时间戳转换为指定格式时间
	 * 
	 * @see DateUtil#format
	 */
	public static String format(String date, String pattern) {
		return format(Long.parseLong(date), pattern);
	}

	/**
	 * 将日期字符串由 旧格式 转为指定的 新格式
	 *
	 * @see DateUtil#format
	 * @auther renguangli
	 * @param dateStr
	 * @param newFmt
	 * @param oldFmt
	 * @return
	 */
	public static String format(String dateStr, String newFmt, String oldFmt) {
		try {
			Date date = getSdf(oldFmt).parse(dateStr);
			return getSdf(newFmt).format(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取时间转换格式器
	 * 
	 * @see DateUtil#getSdf
	 */
	private static SimpleDateFormat getSdf(String pattern) {
		return new SimpleDateFormat(pattern);
	}
}
