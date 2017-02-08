package edu.hsxy.bysj.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wangxiang
 * @describe 学生信息
 * @data 2017年2月7日
 */
@Entity
@Table(name = "STU_INFO")
public class StuInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stuid", nullable = false)
	private int stuid;
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
	 * 学生专业
	 */
	private String zy;
	/**
	 * 学生宿舍id
	 */
	private String ssh;

	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
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

	public String getZy() {
		return zy;
	}

	public void setZy(String zy) {
		this.zy = zy;
	}

	public String getSsh() {
		return ssh;
	}

	public void setSsh(String ssh) {
		this.ssh = ssh;
	}

	@Override
	public String toString() {
		return "StuInfo [stuid=" + stuid + ", dlzh=" + dlzh + ", sex=" + sex + ", xb=" + xb + ", zy=" + zy + ", ssh="
				+ ssh + "]";
	}

}
