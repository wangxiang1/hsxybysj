package edu.hsxy.bysj.bean;

/**
 * @author wangxiang
 * @describe 宿舍楼信息
 * @data 2017年3月4日
 */
public class Sslxx {

	private String sslh;
	private int ssgs;
	private int ssrs;

	public String getSslh() {
		return sslh;
	}

	public void setSslh(String sslh) {
		this.sslh = sslh;
	}

	public int getSsgs() {
		return ssgs;
	}

	public void setSsgs(int ssgs) {
		this.ssgs = ssgs;
	}

	public int getSsrs() {
		return ssrs;
	}

	public void setSsrs(int ssrs) {
		this.ssrs = ssrs;
	}

	@Override
	public String toString() {
		return "Sslxx [sslh=" + sslh + ", ssgs=" + ssgs + ", ssrs=" + ssrs + "]";
	}

}
