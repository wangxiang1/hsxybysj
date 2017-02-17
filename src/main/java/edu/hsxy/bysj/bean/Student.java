package edu.hsxy.bysj.bean;

public class Student {
	private int stuid;
	/**
	 * 用户名
	 */
	private String yhm;
	/**
	 * 登录密码
	 */
	private String pwd;
	/**
	 * 登录账号
	 */
	private String dlzh;
	/**
	 * 学生性别
	 */
	private int sex;
	/**
	 * 学生系别
	 */
	private String xb;
	/**
	 * 学历（0：本科 1：专科）
	 */
	private String xl;
	/**
	 * 学生专业
	 */
	private String zy;
	/**
	 * 手机号码
	 */
	private String sjhm;

	private int ssid;

	private String sslh;

	private String ssh;

	public String getYhm() {
		return yhm;
	}

	public void setYhm(String yhm) {
		this.yhm = yhm;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDlzh() {
		return dlzh;
	}

	public void setDlzh(String dlzh) {
		this.dlzh = dlzh;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getXb() {
		return xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public String getXl() {
		return xl;
	}

	public void setXl(String xl) {
		this.xl = xl;
	}

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getSjhm() {
		return sjhm;
	}

	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}

	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}

	public int getSsid() {
		return ssid;
	}

	public void setSsid(int ssid) {
		this.ssid = ssid;
	}

	public String getSslh() {
		return sslh;
	}

	public void setSslh(String sslh) {
		this.sslh = sslh;
	}

	public String getSsh() {
		return ssh;
	}

	public void setSsh(String ssh) {
		this.ssh = ssh;
	}

	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", yhm=" + yhm + ", pwd=" + pwd + ", dlzh=" + dlzh + ", sex=" + sex + ", xb="
				+ xb + ", xl=" + xl + ", zy=" + zy + ", sjhm=" + sjhm + ", ssid=" + ssid + ", sslh=" + sslh + ", ssh="
				+ ssh + "]";
	}

}
