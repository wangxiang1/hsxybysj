package edu.hsxy.bysj.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wangxiang
 * @describe 电费信息
 * @data 2017年2月7日
 */
@Entity
@Table(name = "DF_INFO")
public class DFInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dfid", nullable = false)
	private int dfid;
	/**
	 * 宿舍id
	 */
	private String ssid;
	/**
	 * 宿舍管理员id
	 */
	private String ssglyid;
	/**
	 * 日期
	 */
	private String date;
	/**
	 * 用电类型
	 */
	private String ydlx;
	/**
	 * 用电量
	 */
	private String ydl;
	/**
	 * 电费单价
	 */
	private String dfdj;
	/**
	 * 电费
	 */
	private String df;
	/**
	 * 是否缴费
	 */
	private String sfjf;
	/**
	 * 电表起码
	 */
	private String dbqm;
	/**
	 * 电表止码
	 */
	private String dbzm;
	/**
	 * 查表人员
	 */
	private String cbry;

	public int getDfid() {
		return dfid;
	}

	public void setDfid(int dfid) {
		this.dfid = dfid;
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	public String getSsglyid() {
		return ssglyid;
	}

	public void setSsglyid(String ssglyid) {
		this.ssglyid = ssglyid;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getYdlx() {
		return ydlx;
	}

	public void setYdlx(String ydlx) {
		this.ydlx = ydlx;
	}

	public String getYdl() {
		return ydl;
	}

	public void setYdl(String ydl) {
		this.ydl = ydl;
	}

	public String getDfdj() {
		return dfdj;
	}

	public void setDfdj(String dfdj) {
		this.dfdj = dfdj;
	}

	public String getDf() {
		return df;
	}

	public void setDf(String df) {
		this.df = df;
	}

	public String getSfjf() {
		return sfjf;
	}

	public void setSfjf(String sfjf) {
		this.sfjf = sfjf;
	}

	public String getDbqm() {
		return dbqm;
	}

	public void setDbqm(String dbqm) {
		this.dbqm = dbqm;
	}

	public String getDbzm() {
		return dbzm;
	}

	public void setDbzm(String dbzm) {
		this.dbzm = dbzm;
	}

	public String getCbry() {
		return cbry;
	}

	public void setCbry(String cbry) {
		this.cbry = cbry;
	}

	@Override
	public String toString() {
		return "DFInfo [dfid=" + dfid + ", ssid=" + ssid + ", ssglyid=" + ssglyid + ", date=" + date + ", ydlx=" + ydlx
				+ ", ydl=" + ydl + ", dfdj=" + dfdj + ", df=" + df + ", sfjf=" + sfjf + ", dbqm=" + dbqm + ", dbzm="
				+ dbzm + ", cbry=" + cbry + "]";
	}

}
