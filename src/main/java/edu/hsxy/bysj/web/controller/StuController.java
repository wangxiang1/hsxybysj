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

import edu.hsxy.bysj.bean.Pager;
import edu.hsxy.bysj.bean.Sdfxx;
import edu.hsxy.bysj.bean.Sslxx;
import edu.hsxy.bysj.bean.Student;
import edu.hsxy.bysj.domain.DFInfo;
import edu.hsxy.bysj.domain.Ggxx;
import edu.hsxy.bysj.domain.SFInfo;
import edu.hsxy.bysj.domain.SsInfo;
import edu.hsxy.bysj.domain.StuInfo;
import edu.hsxy.bysj.domain.User;
import edu.hsxy.bysj.repository.DfRepository;
import edu.hsxy.bysj.repository.GgRepository;
import edu.hsxy.bysj.repository.SfRepository;
import edu.hsxy.bysj.repository.SsRepository;
import edu.hsxy.bysj.repository.StuRepository;
import edu.hsxy.bysj.repository.UserRepository;
import edu.hsxy.bysj.util.MathUtil;
import edu.hsxy.bysj.util.PageableTools;

@Controller
@RequestMapping("/hsxy/sdjf")
@SessionAttributes({ "user", "user" })
public class StuController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StuRepository stuRepository;

	@Autowired
	private SsRepository ssRepository;

	@Autowired
	private SfRepository sfRepository;

	@Autowired
	private DfRepository dfRepository;
	@Autowired
	private GgRepository ggRepository;

	@RequestMapping("/gostu")
	public String goStu() {
		return "student/stuindex";
	}

	@RequestMapping("/gostutop")
	public String goStutop() {
		return "student/stutop";
	}

	@RequestMapping("/gostuleft")
	public String goStuleft() {
		return "student/stuleft";
	}

	@RequestMapping("/gostumain")
	public String gostumain(Model model) {
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

		List<Ggxx> ggxxs = ggRepository.findAll();
		model.addAttribute("ggxxs", ggxxs);

		int ssgs = ssRepository.ssgs();
		int stunum = stuRepository.stunum();
		model.addAttribute("ssgs", ssgs);
		model.addAttribute("stunum", stunum);
		return "student/stumain";
	}

	@RequestMapping("/gostussxx")
	public String gostussxx(String stuid, String ssid, Model model, Integer page, Integer size) {
		size = 5;
		ArrayList<Sdfxx> sdfxxs = new ArrayList<Sdfxx>();
		Page<SFInfo> sfInfos = null;
		SsInfo ssInfo = null;
		Pageable pageable = PageableTools.basicPage(page, size, "date");
		if (null == ssid) {
			StuInfo stuInfo = stuRepository.findOne(Integer.parseInt(stuid));
			ssInfo = ssRepository.findBySsh(stuInfo.getSsh());
			sfInfos = sfRepository.findSfxx(ssInfo.getSsid(), pageable);

		} else {
			ssInfo = ssRepository.findOne(Integer.parseInt(ssid));
			sfInfos = sfRepository.findSfxx(Integer.parseInt(ssid), pageable);
		}

		for (SFInfo sfInfo : sfInfos.getContent()) {
			DFInfo dfInfo = dfRepository.findDfxxBydate(ssInfo.getSsid(), sfInfo.getDate());
			Sdfxx sdfxx = new Sdfxx();

			sdfxx.setSsid(ssInfo.getSsid());
			sdfxx.setSsh(ssInfo.getSsh());
			sdfxx.setSfid(sfInfo.getSfid());
			sdfxx.setYsl(sfInfo.getYsl());
			sdfxx.setSf(sfInfo.getSf());
			sdfxx.setSfdj(sfInfo.getSfdj());

			sdfxx.setDfid(dfInfo.getDfid());
			sdfxx.setYdl(dfInfo.getYdl());
			sdfxx.setDf(dfInfo.getDf());
			sdfxx.setDfdj(dfInfo.getDfdj());

			double zj = Double.parseDouble(sfInfo.getSf()) + Double.parseDouble(dfInfo.getDf());
			sdfxx.setZj(MathUtil.format(2, zj));
			sdfxx.setSsfjf(sfInfo.getSfjf());
			sdfxx.setDate(sfInfo.getDate().substring(0, 19));

			sdfxxs.add(sdfxx);
		}

		Pager pager = new Pager();
		pager.setPage(sfInfos.getNumber());// 页码
		pager.setSize(sfInfos.getSize());// 页容量
		pager.setTotalPages(sfInfos.getTotalPages());// 总页数

		model.addAttribute("pager", pager);
		model.addAttribute("sdfxxs", sdfxxs);
		return "student/stussxx";
	}

	@RequestMapping("/gostugrxx")
	public String goStugrxx(String stuid, Model model) {
		User user = userRepository.findOne(Integer.parseInt(stuid));
		StuInfo stuInfo = stuRepository.findOne(Integer.parseInt(stuid));
		SsInfo ssInfo = ssRepository.findBySsh(stuInfo.getSsh());
		Student student = new Student();
		student.setStuid(stuInfo.getStuid());
		student.setYhm(user.getYhm());
		student.setDlzh(user.getDlzh());
		student.setPwd(user.getPwd());
		student.setSex(stuInfo.getSex());
		student.setSslh(ssInfo.getSslh());
		student.setSsh(ssInfo.getSsh());
		student.setSsid(ssInfo.getSsid());
		student.setXl(stuInfo.getXl());
		student.setXb(stuInfo.getXb());
		student.setZy(stuInfo.getZy());
		student.setSjhm(user.getSjhm());
		student.setSslh(ssInfo.getSslh());

		model.addAttribute("student", student);
		return "student/stugrxx";
	}

	@RequestMapping("/gostuxgmm")
	public String goStuxgmm(String yhid, Model model) {
		return "student/stuxgmm";
	}

	@RequestMapping("/xiugaimima")
	@ResponseBody
	public int goxgmm(String yhid, String pwd, Model model) {
		return userRepository.updatePwd(Integer.parseInt(yhid), pwd);
	}

	@RequestMapping("/mimaqr")
	@ResponseBody
	public String mimaqr(String yhid, Model model) {
		User user = userRepository.findOne(Integer.parseInt(yhid));
		return user.getPwd();
	}

	@RequestMapping("/gostusdfxx")
	public String goStusdfxx(String stuid, Model model) {
		StuInfo stuInfo = stuRepository.findOne(Integer.parseInt(stuid));
		SsInfo ssInfo = ssRepository.findBySsh(stuInfo.getSsh());
		int s = sfRepository.findSfxx(ssInfo.getSsid()).size();
		Sdfxx sdfxx = new Sdfxx();
		if (s != 0) {
			SFInfo sfInfo = sfRepository.findSfxx(ssInfo.getSsid()).get(0);
			DFInfo dfInfo = dfRepository.findDfxx(ssInfo.getSsid()).get(0);

			sdfxx.setSsid(ssInfo.getSsid());
			sdfxx.setSslh(ssInfo.getSslh());
			sdfxx.setSsh(ssInfo.getSsh());
			sdfxx.setSsye(MathUtil.format(2, Double.parseDouble(ssInfo.getSsye())));

			sdfxx.setYslx(sfInfo.getYslx());
			sdfxx.setSbqm(sfInfo.getSbqm());
			sdfxx.setSbzm(sfInfo.getSbzm());
			sdfxx.setYsl(sfInfo.getYsl());
			sdfxx.setSfdj(sfInfo.getSfdj());
			sdfxx.setSf(sfInfo.getSf());
			sdfxx.setScbry(userRepository.findOne(Integer.parseInt(sfInfo.getCbry())).getYhm());

			sdfxx.setDate(sfInfo.getDate().substring(0, 19));

			sdfxx.setYdlx(dfInfo.getYdlx());
			sdfxx.setDbqm(dfInfo.getDbqm());
			sdfxx.setDbzm(dfInfo.getDbzm());
			sdfxx.setYdl(dfInfo.getYdl());
			sdfxx.setDfdj(dfInfo.getDfdj());
			sdfxx.setDf(dfInfo.getDf());
			sdfxx.setDcbry(userRepository.findOne(Integer.parseInt(dfInfo.getCbry())).getYhm());

		}

		List<String> dates = sfRepository.findAllDate(ssInfo.getSsid());
		model.addAttribute("dates", dates);
		model.addAttribute("sdfxx", sdfxx);
		return "student/stusdfxx";
	}

	@RequestMapping("/findSdfxxBydate")
	public String findSdfxxBydate(String date, String ssid, Model model) {
		SsInfo ssInfo = ssRepository.findOne(Integer.parseInt(ssid));
		SFInfo sfInfo = sfRepository.findSfxxBydate(Integer.parseInt(ssid), date);
		DFInfo dfInfo = dfRepository.findDfxxBydate(Integer.parseInt(ssid), date);
		Sdfxx sdfxx = new Sdfxx();
		sdfxx.setSsid(ssInfo.getSsid());
		sdfxx.setSslh(ssInfo.getSslh());
		sdfxx.setSsh(ssInfo.getSsh());
		sdfxx.setSsye(MathUtil.format(2, Double.parseDouble(ssInfo.getSsye())));

		sdfxx.setYslx(sfInfo.getYslx());
		sdfxx.setSbqm(sfInfo.getSbqm());
		sdfxx.setSbzm(sfInfo.getSbzm());
		sdfxx.setYsl(sfInfo.getYsl());
		sdfxx.setSfdj(sfInfo.getSfdj());
		sdfxx.setSf(sfInfo.getSf());
		sdfxx.setScbry(userRepository.findOne(Integer.parseInt(sfInfo.getCbry())).getYhm());

		sdfxx.setDate(sfInfo.getDate().substring(0, 19));

		sdfxx.setYdlx(dfInfo.getYdlx());
		sdfxx.setDbqm(dfInfo.getDbqm());
		sdfxx.setDbzm(dfInfo.getDbzm());
		sdfxx.setYdl(dfInfo.getYdl());
		sdfxx.setDfdj(dfInfo.getDfdj());
		sdfxx.setDf(dfInfo.getDf());
		sdfxx.setDcbry(userRepository.findOne(Integer.parseInt(dfInfo.getCbry())).getYhm());

		List<String> dates = sfRepository.findAllDate(ssInfo.getSsid());
		model.addAttribute("dates", dates);
		model.addAttribute("sdfxx", sdfxx);
		return "student/stusdfxx";
	}

	@RequestMapping("/gostujf")
	public String goStujf(String stuid, String date, Model model) {
		StuInfo stuInfo = stuRepository.findOne(Integer.parseInt(stuid));
		SsInfo ssInfo = ssRepository.findBySsh(stuInfo.getSsh());
		SFInfo sfInfo = null;
		DFInfo dfInfo = null;
		int s = sfRepository.findSfxx(ssInfo.getSsid()).size();
		Sdfxx sdfxx = new Sdfxx();
		if (s != 0) {
			if (null == date) {
				sfInfo = sfRepository.findSfxx(ssInfo.getSsid()).get(0);
				dfInfo = dfRepository.findDfxx(ssInfo.getSsid()).get(0);
			} else {
				sfInfo = sfRepository.findSfxxBydate(ssInfo.getSsid(), date);
				dfInfo = dfRepository.findDfxxBydate(ssInfo.getSsid(), date);
			}
			sdfxx.setSsid(ssInfo.getSsid());
			sdfxx.setSslh(ssInfo.getSslh());
			sdfxx.setSsh(ssInfo.getSsh());
			sdfxx.setSsye(MathUtil.format(2, Double.parseDouble(ssInfo.getSsye())));

			sdfxx.setSfid(sfInfo.getSfid());
			sdfxx.setYslx(sfInfo.getYslx());
			sdfxx.setSbqm(sfInfo.getSbqm());
			sdfxx.setSbzm(sfInfo.getSbzm());
			sdfxx.setYsl(sfInfo.getYsl());
			sdfxx.setSfdj(sfInfo.getSfdj());
			sdfxx.setSf(sfInfo.getSf());
			sdfxx.setScbry(userRepository.findOne(Integer.parseInt(sfInfo.getCbry())).getYhm());
			sdfxx.setSsfjf(sfInfo.getSfjf());

			sdfxx.setDate(sfInfo.getDate().substring(0, 19));

			sdfxx.setDfid(dfInfo.getDfid());
			sdfxx.setYdlx(dfInfo.getYdlx());
			sdfxx.setDbqm(dfInfo.getDbqm());
			sdfxx.setDbzm(dfInfo.getDbzm());
			sdfxx.setYdl(dfInfo.getYdl());
			sdfxx.setDfdj(dfInfo.getDfdj());
			sdfxx.setDf(dfInfo.getDf());
			sdfxx.setDcbry(userRepository.findOne(Integer.parseInt(dfInfo.getCbry())).getYhm());
			sdfxx.setDsfjf(dfInfo.getSfjf());

			double zj = Double.parseDouble(sfInfo.getSf()) + Double.parseDouble(dfInfo.getDf());
			sdfxx.setZj(MathUtil.format(2, zj));
		}

		List<String> dates = sfRepository.findAllDate(ssInfo.getSsid());
		model.addAttribute("dates", dates);
		model.addAttribute("sdfxx", sdfxx);
		return "student/stujf";
	}

	@RequestMapping("/gostuqrjf")
	@ResponseBody
	public Integer goStuQrJf(String stuid, String ssid, String jfje, String yjje, String sfid, String dfid,
			Model model) {
		Double ssye = Double.parseDouble(jfje) - Double.parseDouble(yjje);
		Double ssye1 = MathUtil.format(2, ssye);
		int i = ssRepository.updateYue(Integer.parseInt(ssid), ssye1.toString());
		int i1 = sfRepository.updateSfjf(Integer.parseInt(sfid));
		int i2 = dfRepository.updateSfjf(Integer.parseInt(dfid));
		if (i >= 1 && i1 >= 1 && i2 >= 1) {
			return 1;
		} else {
			return 0;
		}

	}

}
