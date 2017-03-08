package edu.hsxy.bysj.bean;

public class SsAadmin {
	private int ssglyid;
	private int sex;
	private String sslh;
	private String dlzh;
	private String yhm;
	private String sjhm;
	private String pwd;
	private String sfbz;

	public String getSfbz() {
		return sfbz;
	}

	public void setSfbz(String sfbz) {
		this.sfbz = sfbz;
	}

	public String getSjhm() {
		return sjhm;
	}

	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getSsglyid() {
		return ssglyid;
	}

	public void setSsglyid(int ssglyid) {
		this.ssglyid = ssglyid;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getSslh() {
		return sslh;
	}

	public void setSslh(String sslh) {
		this.sslh = sslh;
	}

	public String getDlzh() {
		return dlzh;
	}

	public void setDlzh(String dlzh) {
		this.dlzh = dlzh;
	}

	public String getYhm() {
		return yhm;
	}

	public void setYhm(String yhm) {
		this.yhm = yhm;
	}

	@Override
	public String toString() {
		return "SsAadmin [ssglyid=" + ssglyid + ", sex=" + sex + ", sslh=" + sslh + ", dlzh=" + dlzh + ", yhm=" + yhm
				+ ", sjhm=" + sjhm + ", pwd=" + pwd + ", sfbz=" + sfbz + "]";
	}

}
