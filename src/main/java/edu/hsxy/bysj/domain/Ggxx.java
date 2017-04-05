package edu.hsxy.bysj.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author wangxiang
 * @describe 公告信息
 * @date 2017年4月5日
 */
@Entity
@Table(name = "GG_INFO")
public class Ggxx {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ggid", nullable = false)
	private int ggid;
	/**
	 * 公告主题
	 */
	private String ggzt;
	/**
	 * 公告内容
	 */
	private String ggnr;
	/**
	 * 公告日期
	 */
	private String ggrq;

	public int getGgid() {
		return ggid;
	}

	public void setGgid(int ggid) {
		this.ggid = ggid;
	}

	public String getGgzt() {
		return ggzt;
	}

	public void setGgzt(String ggzt) {
		this.ggzt = ggzt;
	}

	public String getGgnr() {
		return ggnr;
	}

	public void setGgnr(String ggnr) {
		this.ggnr = ggnr;
	}

	public String getGgrq() {
		return ggrq;
	}

	public void setGgrq(String ggrq) {
		this.ggrq = ggrq;
	}

	@Override
	public String toString() {
		return "Ggxx [ggid=" + ggid + ", ggzt=" + ggzt + ", ggnr=" + ggnr + ", ggrq=" + ggrq + "]";
	}

}
