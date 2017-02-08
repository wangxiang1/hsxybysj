package edu.hsxy.bysj.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ssglyid", nullable = false)
	private int ssglyid;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 宿舍楼id
	 */
	private String sslid;

	public int getSsglyid() {
		return ssglyid;
	}

	public void setSsglyid(int ssglyid) {
		this.ssglyid = ssglyid;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSslid() {
		return sslid;
	}

	public void setSslid(String sslid) {
		this.sslid = sslid;
	}

	@Override
	public String toString() {
		return "SSAdmin [ssglyid=" + ssglyid + ", sex=" + sex + ", sslid=" + sslid + "]";
	}

}
