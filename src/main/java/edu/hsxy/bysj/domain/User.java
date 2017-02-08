package edu.hsxy.bysj.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wangxiang
 * @describe 用户信息
 * @data 2017年2月7日
 */
@Entity
@Table(name = "USER_INFO")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "yhid", nullable = false)
	private int yhid;

	/**
	 * 登录账号
	 */
	private String dlzh;
	/**
	 * 用户名
	 */
	private String yhm;
	/**
	 * 登录密码
	 */
	private String pwd;
	/**
	 * 身份标识 0:管理员；1：学生用户；2：宿舍管理员
	 */
	private String sfbz;
	/**
	 * 注册时间
	 */
	private String zcsj;
	/**
	 * 手机号码
	 */
	private String sjhm;

	public int getYhid() {
		return yhid;
	}

	public void setYhid(int yhid) {
		this.yhid = yhid;
	}

	public String getDlzh() {
		return dlzh;
	}

	public void setDlzh(String dlzh) {
		this.dlzh = dlzh;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSfbz() {
		return sfbz;
	}

	public void setSfbz(String sfbz) {
		this.sfbz = sfbz;
	}

	public String getZcsj() {
		return zcsj;
	}

	public void setZcsj(String zcsj) {
		this.zcsj = zcsj;
	}

	public String getSjhm() {
		return sjhm;
	}

	public void setSjhm(String sjhm) {
		this.sjhm = sjhm;
	}

	public String getYhm() {
		return yhm;
	}

	public void setYhm(String yhm) {
		this.yhm = yhm;
	}

	@Override
	public String toString() {
		return "User [yhid=" + yhid + ", dlzh=" + dlzh + ", yhm=" + yhm + ", pwd=" + pwd + ", sfbz=" + sfbz + ", zcsj="
				+ zcsj + ", sjhm=" + sjhm + "]";
	}

}
