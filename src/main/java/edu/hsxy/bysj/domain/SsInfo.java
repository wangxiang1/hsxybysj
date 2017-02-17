package edu.hsxy.bysj.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wangxiang
 * @describe 宿舍信息
 * @data 2017年2月13日
 */
@Entity
@Table(name = "SS_INFO")
public class SsInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ssid", nullable = false)
	private int ssid;
	/**
	 * 宿舍号
	 */
	private String ssh;
	/**
	 * 宿舍楼号
	 */
	private String sslh;
	/**
	 * 宿舍管理员id
	 */
	private String ssglyid;
	/**
	 * 宿舍余额
	 */
	private String ssye;

	public SsInfo() {
		super();
	}

	public SsInfo(String ssh, String sslh, String ssglyid, String ssye) {
		super();
		this.ssh = ssh;
		this.sslh = sslh;
		this.ssglyid = ssglyid;
		this.ssye = ssye;
	}

	public int getSsid() {
		return ssid;
	}

	public void setSsid(int ssid) {
		this.ssid = ssid;
	}

	public String getSsh() {
		return ssh;
	}

	public void setSsh(String ssh) {
		this.ssh = ssh;
	}

	public String getSslh() {
		return sslh;
	}

	public void setSslh(String sslh) {
		this.sslh = sslh;
	}

	public String getSsglyid() {
		return ssglyid;
	}

	public void setSsglyid(String ssglyid) {
		this.ssglyid = ssglyid;
	}

	public String getSsye() {
		return ssye;
	}

	public void setSsye(String ssye) {
		this.ssye = ssye;
	}

	@Override
	public String toString() {
		return "SsInfo [ssid=" + ssid + ", ssh=" + ssh + ", sslh=" + sslh + ", ssglyid=" + ssglyid + ", ssyh=" + ssye
				+ "]";
	}

}
