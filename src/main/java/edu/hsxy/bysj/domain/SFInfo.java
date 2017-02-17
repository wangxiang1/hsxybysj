package edu.hsxy.bysj.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wangxiang
 * @describe 水费信息
 * @data 2017年2月7日
 */
@Entity
@Table(name = "SF_INFO")
public class SFInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sfid", nullable = false)
	private int sfid;
	/**
	 * 宿舍id
	 */
	private int ssid;
	/**
	 * 日期
	 */
	private String date;
	/**
	 * 用水类型
	 */
	private String yslx;
	/**
	 * 用水量
	 */
	private String ysl;
	/**
	 * 水费单价
	 */
	private String sfdj;
	/**
	 * 水费
	 */
	private String sf;
	/**
	 * 是否缴费
	 */
	private String sfjf;
	/**
	 * 水表起码
	 */
	private String sbqm;
	/**
	 * 水表止码
	 */
	private String sbzm;
	/**
	 * 查表人员
	 */
	private String cbry;

	public SFInfo() {
		super();
	}

	public SFInfo(int ssid, String date, String yslx, String ysl, String sfdj, String sf, String sfjf, String sbqm,
			String sbzm, String cbry) {
		super();
		this.ssid = ssid;
		this.date = date;
		this.yslx = yslx;
		this.ysl = ysl;
		this.sfdj = sfdj;
		this.sf = sf;
		this.sfjf = sfjf;
		this.sbqm = sbqm;
		this.sbzm = sbzm;
		this.cbry = cbry;
	}

	public int getSfid() {
		return sfid;
	}

	public void setSfid(int sfid) {
		this.sfid = sfid;
	}

	public int getSsid() {
		return ssid;
	}

	public void setSsid(int ssid) {
		this.ssid = ssid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getYslx() {
		return yslx;
	}

	public void setYslx(String yslx) {
		this.yslx = yslx;
	}

	public String getYsl() {
		return ysl;
	}

	public void setYsl(String ysl) {
		this.ysl = ysl;
	}

	public String getSfdj() {
		return sfdj;
	}

	public void setSfdj(String sfdj) {
		this.sfdj = sfdj;
	}

	public String getSf() {
		return sf;
	}

	public void setSf(String sf) {
		this.sf = sf;
	}

	public String getSfjf() {
		return sfjf;
	}

	public void setSfjf(String sfjf) {
		this.sfjf = sfjf;
	}

	public String getSbqm() {
		return sbqm;
	}

	public void setSbqm(String sbqm) {
		this.sbqm = sbqm;
	}

	public String getSbzm() {
		return sbzm;
	}

	public void setSbzm(String sbzm) {
		this.sbzm = sbzm;
	}

	public String getCbry() {
		return cbry;
	}

	public void setCbry(String cbry) {
		this.cbry = cbry;
	}

	@Override
	public String toString() {
		return "SFInfo [sfid=" + sfid + ", ssid=" + ssid + ", date=" + date + ", yslx=" + yslx + ", ysl=" + ysl
				+ ", sfdj=" + sfdj + ", sf=" + sf + ", sfjf=" + sfjf + ", sbqm=" + sbqm + ", sbzm=" + sbzm + ", cbry="
				+ cbry + "]";
	}

}
