package edu.hsxy.bysj.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.hsxy.bysj.bean.Pager;
import edu.hsxy.bysj.bean.Sdfxx;
import edu.hsxy.bysj.domain.DFInfo;
import edu.hsxy.bysj.domain.SFInfo;
import edu.hsxy.bysj.domain.SsInfo;
import edu.hsxy.bysj.repository.DfRepository;
import edu.hsxy.bysj.repository.SfRepository;
import edu.hsxy.bysj.repository.SsRepository;
import edu.hsxy.bysj.util.MathUtil;
import edu.hsxy.bysj.util.PageableTools;

@Controller
@RequestMapping("/hsxy/sdjf/admin")
@SessionAttributes({ "user", "user" })
public class XtAdminController {

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

		return "xtadmin/xtglymain";
	}

	@RequestMapping("/adduser")
	public String adduser() {
		return "xtadmin/adduser";
	}
}
