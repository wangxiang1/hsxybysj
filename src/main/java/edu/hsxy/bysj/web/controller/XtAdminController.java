package edu.hsxy.bysj.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.alibaba.fastjson.JSONObject;

import edu.hsxy.bysj.bean.Pager;
import edu.hsxy.bysj.bean.Sdfxx;
import edu.hsxy.bysj.bean.Sslxx;
import edu.hsxy.bysj.domain.DFInfo;
import edu.hsxy.bysj.domain.SFInfo;
import edu.hsxy.bysj.domain.SsInfo;
import edu.hsxy.bysj.repository.DfRepository;
import edu.hsxy.bysj.repository.SfRepository;
import edu.hsxy.bysj.repository.SsRepository;
import edu.hsxy.bysj.repository.StuRepository;
import edu.hsxy.bysj.util.MathUtil;
import edu.hsxy.bysj.util.PageableTools;

@Controller
@RequestMapping("/hsxy/sdjf/admin")
@SessionAttributes({ "user", "user" })
public class XtAdminController {

	@Autowired
	private StuRepository stuRepository;
	@Autowired
	private SsRepository ssRepository;
	@Autowired
	private SfRepository sfRepository;
	@Autowired
	private DfRepository dfRepository;

	@RequestMapping("/goxtgly")
	public String goXtAdmin() {
		return "xtadmin/xtglyindex";
	}

	@RequestMapping("/goxtglytop")
	public String goXttop() {
		return "xtadmin/xtglytop";
	}

	@RequestMapping("/goxtglyleft")
	public String goXtleft() {
		return "xtadmin/xtglyleft";
	}

	@RequestMapping("/gosdfsj")
	public String goXtsdfxj(Model model, Integer page, String sslh, String ssh, String sfjf, String date) {
		int size = 8;
		Pageable pageable = PageableTools.basicPage(page, size, "date");
		Page<SFInfo> sfInfos = null;
		List<Sdfxx> sdfxxs = new ArrayList<Sdfxx>();
		if (sfjf == "" && date == "") {
			sfInfos = sfRepository.findAll(pageable);
		} else if (sfjf != "" && date == "") {
			sfInfos = sfRepository.findSfxxBySfjf(sfjf, pageable);
		} else if (sfjf == "" && date != "") {
			sfInfos = sfRepository.findSfxxByDate(date, pageable);
		} else if (sfjf != "" && date != "") {
			sfInfos = sfRepository.findSfxxByDateAndSfjf(date, sfjf, pageable);
		}
		for (SFInfo sfInfo : sfInfos.getContent()) {
			SsInfo ssInfo = null;
			if (sslh == "" && ssh == "") {
				ssInfo = ssRepository.findOne(sfInfo.getSsid());
			} else if (sslh != "" && ssh == "") {
				ssInfo = ssRepository.findBySslhAndId(sfInfo.getSsid(), sslh);
			} else if (sslh == "" && ssh != "") {
				ssInfo = ssRepository.findBySshAndId(sfInfo.getSsid(), ssh);
			} else if (sslh != "" && ssh != "") {
				ssInfo = ssRepository.findBySslhAndSshAndId(sslh, ssh, sfInfo.getSsid());
			}

			if (null != ssInfo) {
				DFInfo dfInfo = dfRepository.findDfxxBydate(ssInfo.getSsid(), sfInfo.getDate());
				Sdfxx sdfxx = new Sdfxx();
				sdfxx.setSsid(ssInfo.getSsid());
				sdfxx.setSslh(ssInfo.getSslh());
				sdfxx.setSsh(ssInfo.getSsh());
				sdfxx.setSsye(Double.parseDouble(ssInfo.getSsye()));

				sdfxx.setSfid(sfInfo.getSfid());
				sdfxx.setYsl(sfInfo.getYsl());
				sdfxx.setSf(sfInfo.getSf());
				sdfxx.setSsfjf(sfInfo.getSfjf());
				sdfxx.setDate(sfInfo.getDate().substring(0, 19));
				if (null != dfInfo) {
					sdfxx.setDfid(dfInfo.getDfid());
					sdfxx.setYdl(dfInfo.getYdl());
					sdfxx.setDf(dfInfo.getDf());

					double zj = Double.parseDouble(sfInfo.getSf()) + Double.parseDouble(dfInfo.getDf());
					sdfxx.setZj(MathUtil.format(2, zj));
				}
				sdfxxs.add(sdfxx);
			}
		}
		Pager pager = new Pager();
		pager.setPage(sfInfos.getNumber());// 页码
		pager.setSize(sfInfos.getSize());// 页容量
		pager.setTotalPages(sfInfos.getTotalPages());// 总页数

		List<String> dates = sfRepository.findAllDate2();
		model.addAttribute("dates", dates);

		model.addAttribute("pager", pager);
		model.addAttribute("sdfxxs", sdfxxs);
		model.addAttribute("sslh", sslh);
		model.addAttribute("ssh", ssh);
		model.addAttribute("sfjf", sfjf);
		model.addAttribute("date", date);
		return "xtadmin/sdfsj";
	}

	@RequestMapping("/goxtglymain")
	public String goXtMain(Model model) {
		List<Sslxx> sslxxs = new ArrayList<Sslxx>();
		List<String> sslhs = ssRepository.findSslhs();
		for (String string : sslhs) {
			Sslxx sslxx = new Sslxx();
			sslxx.setSslh(string);
			int ssgs = ssRepository.findSsgs(string);
			List<String> sshs = ssRepository.findSshsBySslh(string);
			int ssrs = stuRepository.findSsrs(sshs);
			sslxx.setSsgs(ssgs);
			sslxx.setSsrs(ssrs);
			sslxxs.add(sslxx);
		}
		model.addAttribute("sslxxs", sslxxs);

		return "xtadmin/xtglymain";
	}

	@RequestMapping("/adduser")
	public String adduser() {
		return "xtadmin/adduser";
	}

	@RequestMapping("/gggl")
	public String gggl() {
		return "xtadmin/gggl";
	}

	@RequestMapping("/fytj")
	public String gofytj(Model model, String sslh, String ssh, String qssj, String jzsj) {
		List<String> sslhs = ssRepository.findSslhs();
		model.addAttribute("sslhs", sslhs);

		double zjysl = 0.0;
		double zjsf = 0.0;
		double zjydl = 0.0;
		double zjdf = 0.0;
		if ("" == sslh && "" == ssh) {
			zjysl = sfRepository.countYsl(qssj, jzsj);
			zjsf = sfRepository.countSf(qssj, jzsj);
			zjydl = dfRepository.countYdl(qssj, jzsj);
			zjdf = dfRepository.countDf(qssj, jzsj);
		} else if ("" != sslh && "" == ssh) {
			List<Integer> ssids = ssRepository.findSsidsBySslh(sslh);
			zjysl = sfRepository.countYslL(qssj, jzsj, ssids);
			zjsf = sfRepository.countSfL(qssj, jzsj, ssids);
			zjydl = dfRepository.countYdl(qssj, jzsj, ssids);
			zjdf = dfRepository.countDf(qssj, jzsj, ssids);
		} else if ("" != sslh && "" != ssh) {
			SsInfo ssInfo = ssRepository.findBySsh(ssh);
			int ssid = ssInfo.getSsid();
			List<Integer> ssids = new ArrayList<Integer>();
			ssids.add(ssid);
			zjysl = sfRepository.countYslL(qssj, jzsj, ssids);
			zjsf = sfRepository.countSfL(qssj, jzsj, ssids);
			zjydl = dfRepository.countYdl(qssj, jzsj, ssids);
			zjdf = dfRepository.countDf(qssj, jzsj, ssids);
		}
		model.addAttribute("zjysl", zjysl);
		model.addAttribute("zjsf", zjsf);
		model.addAttribute("zjydl", zjydl);
		model.addAttribute("zjdf", zjdf);
		return "xtadmin/fytj";
	}

	@RequestMapping("/fytj/findssh")
	@ResponseBody
	public JSONObject findssh(String sslh) {
		List<String> sshs = ssRepository.findSshsBySslh(sslh);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("sshs", sshs);
		return jsonObject;
	}

	@RequestMapping("/fytj/table")
	@ResponseBody
	public JSONObject getfytjTable(String sslh, String ssh, String qssj, String jzsj) {
		JSONObject jsonObject = new JSONObject();
		double zjysl = 0.0;
		double zjsf = 0.0;
		double zjydl = 0.0;
		double zjdf = 0.0;
		if ("" == sslh && "" == ssh) {
			zjysl = sfRepository.countYsl(qssj, jzsj);
			zjsf = sfRepository.countSf(qssj, jzsj);
			zjydl = dfRepository.countYdl(qssj, jzsj);
			zjdf = dfRepository.countDf(qssj, jzsj);
		} else if ("" != sslh && "" == ssh) {
			List<Integer> ssids = ssRepository.findSsidsBySslh(sslh);
			zjysl = sfRepository.countYslL(qssj, jzsj, ssids);
			zjsf = sfRepository.countSfL(qssj, jzsj, ssids);
			zjydl = dfRepository.countYdl(qssj, jzsj, ssids);
			zjdf = dfRepository.countDf(qssj, jzsj, ssids);
		} else if ("" != sslh && "" != ssh) {
			SsInfo ssInfo = ssRepository.findBySsh(ssh);
			int ssid = ssInfo.getSsid();
			List<Integer> ssids = new ArrayList<Integer>();
			ssids.add(ssid);
			zjysl = sfRepository.countYslL(qssj, jzsj, ssids);
			zjsf = sfRepository.countSfL(qssj, jzsj, ssids);
			zjydl = dfRepository.countYdl(qssj, jzsj, ssids);
			zjdf = dfRepository.countDf(qssj, jzsj, ssids);
		}
		jsonObject.put("zjysl", zjysl);
		jsonObject.put("zjsf", zjsf);
		jsonObject.put("zjydl", zjydl);
		jsonObject.put("zjdf", zjdf);
		return jsonObject;
	}

}
