package edu.hsxy.bysj.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name = "stuid", nullable = false)
	private int stuid;

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
	 * 学生宿舍号
	 */
	private String ssh;

	public StuInfo() {
		super();
	}

	public StuInfo(int stuid, int sex, String xb, String xl, String zy, String ssh) {
		super();
		this.stuid = stuid;
		this.sex = sex;
		this.xb = xb;
		this.xl = xl;
		this.zy = zy;
		this.ssh = ssh;
	}

	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
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

	public String getXl() {
		return xl;
	}

	public void setXl(String xl) {
		this.xl = xl;
	}

	@Override
	public String toString() {
		return "StuInfo [stuid=" + stuid + ", sex=" + sex + ", xb=" + xb + ", xl=" + xl + ", zy=" + zy + ", ssh=" + ssh
				+ "]";
	}

}
