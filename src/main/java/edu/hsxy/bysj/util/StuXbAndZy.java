package edu.hsxy.bysj.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StuXbAndZy {

	public static Map<String, List<String>> getBkXbAndZy() {
		Map<String, List<String>> stuXbZy = new HashMap<String, List<String>>();
		// 文学传播
		List<String> wxcb = new ArrayList<String>();
		wxcb.add("汉语言文学专业");
		wxcb.add("广播电视学专业");
		wxcb.add("播音与主持艺术专业");
		wxcb.add("广告学专业");
		wxcb.add("广播电视编导");
		stuXbZy.put("文学传播学院", wxcb);
		// 外国语
		List<String> wgy = new ArrayList<String>();
		wgy.add("英语专业");
		wgy.add("汉语国际教育专业");
		wgy.add("日语专业");
		wgy.add("翻译");
		stuXbZy.put("外国语学院", wgy);
		// 法政
		List<String> fz = new ArrayList<String>();
		fz.add("思想政治教育专业");
		fz.add("政治学与行政学专业");
		stuXbZy.put("法政学院", fz);
		// 教育
		List<String> jy = new ArrayList<String>();
		jy.add("学前教育专业");
		jy.add("应用心理学专业");
		stuXbZy.put("教育学院", jy);
		// 化工
		List<String> hg = new ArrayList<String>();
		hg.add("化学专业");
		hg.add("应用化学专业");
		hg.add("高分子材料与工程");
		stuXbZy.put("化工学院", hg);
		// 电子信息工程
		List<String> dzxxgc = new ArrayList<String>();
		dzxxgc.add("电子信息工程专业");
		dzxxgc.add("数字媒体技术专业");
		dzxxgc.add("机械电子工程专业");
		stuXbZy.put("电子信息工程学院", dzxxgc);
		// 数学与计算机
		List<String> sxyjsj = new ArrayList<String>();
		sxyjsj.add("数学与应用数学专业");
		sxyjsj.add("应用统计专业");
		sxyjsj.add("计算机科学技术专业");
		sxyjsj.add("物联网工程");
		stuXbZy.put("数学与计算机学院", sxyjsj);
		// 生命科学
		List<String> smkx = new ArrayList<String>();
		smkx.add("生物科学专业");
		smkx.add("园林专业");
		smkx.add("环境生态工程");
		smkx.add("生物技术专业");
		smkx.add("食品质量与安全");
		stuXbZy.put("生命科学学院", smkx);
		// 体育
		List<String> ty = new ArrayList<String>();
		ty.add("体育教育专业");
		ty.add("社会体育指导与管理专业");
		stuXbZy.put("体育学院", ty);
		// 音乐
		List<String> yy = new ArrayList<String>();
		yy.add("音乐学专业");
		yy.add("音乐表演专业");
		yy.add("舞蹈学专业");
		yy.add("舞蹈表演专业");
		stuXbZy.put("音乐学院", yy);
		// 美术
		List<String> ms = new ArrayList<String>();
		ms.add("美术学专业");
		ms.add("视觉传达设计专业");
		ms.add("动画专业");
		ms.add("环境设计专业");
		stuXbZy.put("美术学院", ms);
		// 经济管理
		List<String> jjgl = new ArrayList<String>();
		jjgl.add("人力资源管理专业");
		jjgl.add("国际经济与贸易专业");
		jjgl.add("信息管理与信息系统专业");
		stuXbZy.put("经济管理学院", jjgl);
		return stuXbZy;
	}

	public static Map<String, List<String>> getZkXbAndZy() {
		Map<String, List<String>> stuXbZy = new HashMap<String, List<String>>();
		// 文学传播
		List<String> wxcb = new ArrayList<String>();
		wxcb.add("文秘专业");
		wxcb.add("新闻采编与制作专业");
		wxcb.add("主持与播音专业");
		wxcb.add("语文教育专业");
		stuXbZy.put("文学传播学院", wxcb);
		// 外国语
		List<String> wgy = new ArrayList<String>();
		wgy.add("应用英语专业");
		wgy.add("英语教育专业");
		wgy.add("旅游英语专业");
		stuXbZy.put("外国语学院", wgy);
		// 法政
		List<String> fz = new ArrayList<String>();
		fz.add("思想政治教育专业");
		fz.add("法律事务专业");
		stuXbZy.put("法政学院", fz);
		// 教育
		List<String> jy = new ArrayList<String>();
		jy.add("学前教育专业");
		jy.add("心理咨询专业");
		stuXbZy.put("教育学院", jy);
		// 化工
		List<String> hg = new ArrayList<String>();
		hg.add("化学教育专业");
		hg.add("应用化工技术专业(");
		hg.add("工业分析与检测专业");
		stuXbZy.put("化工学院", hg);
		// 电子信息工程
		List<String> dzxxgc = new ArrayList<String>();
		dzxxgc.add("机电一体化技术");
		dzxxgc.add("电气化铁道技术");
		dzxxgc.add("太阳能应用技术");
		dzxxgc.add("数控技术");
		dzxxgc.add("建筑工程技术专业");
		dzxxgc.add("通信技术专业");
		stuXbZy.put("电子信息工程学院", dzxxgc);
		// 数学与计算机
		List<String> sxyjsj = new ArrayList<String>();
		sxyjsj.add("数学教育专业");
		sxyjsj.add("计算机应用教育专业");
		sxyjsj.add("计算机网络技术专业");
		stuXbZy.put("数学与计算机学院", sxyjsj);
		// 生命科学
		List<String> smkx = new ArrayList<String>();
		smkx.add("食品生物技术");
		smkx.add("园林技术专业");
		stuXbZy.put("生命科学学院", smkx);
		// 体育
		List<String> ty = new ArrayList<String>();
		ty.add("体育教育专业");
		ty.add("社会体育专业");
		stuXbZy.put("体育学院", ty);
		// 音乐
		List<String> yy = new ArrayList<String>();
		yy.add("音乐教育专业");
		stuXbZy.put("音乐学院", yy);
		// 经济管理
		List<String> jjgl = new ArrayList<String>();
		jjgl.add("营销与策划专业");
		jjgl.add("物流管理专业");
		jjgl.add("会计与统计核算");
		jjgl.add("电子商务专业业");
		jjgl.add("国际经济与贸易专业");
		jjgl.add("房地产经营与估价");
		stuXbZy.put("经济管理学院", jjgl);
		return stuXbZy;
	}
}
