package edu.hsxy.bysj.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wangxiang
 * @describe 宿舍管理员
 * @data 2017年2月7日
 */
@Entity
@Table(name = "SSADMIN_INFO")
public class SSAdmin {
	@Id
	@Column(name = "ssglyid", nullable = false)
	private int ssglyid;
	/**
	 * 性别
	 */
	private int sex;
	/**
	 * 宿舍楼号
	 */
	private String sslh;

	public SSAdmin() {
		super();
	}

	public SSAdmin(int ssglyid, int sex, String sslh) {
		super();
		this.ssglyid = ssglyid;
		this.sex = sex;
		this.sslh = sslh;
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

	@Override
	public String toString() {
		return "SSAdmin [ssglyid=" + ssglyid + ", sex=" + sex + ", sslh=" + sslh + "]";
	}

}
