package edu.hsxy.bysj.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.hsxy.bysj.bean.Sdfxx;
import edu.hsxy.bysj.bean.Student;
import edu.hsxy.bysj.domain.DFInfo;
import edu.hsxy.bysj.domain.SFInfo;
import edu.hsxy.bysj.domain.SsInfo;
import edu.hsxy.bysj.domain.StuInfo;
import edu.hsxy.bysj.domain.User;
import edu.hsxy.bysj.repository.DfRepository;
import edu.hsxy.bysj.repository.SfRepository;
import edu.hsxy.bysj.repository.SsRepository;
import edu.hsxy.bysj.repository.StuRepository;
import edu.hsxy.bysj.repository.UserRepository;
import edu.hsxy.bysj.util.MathUtil;

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
	public String goStumain() {
		return "student/stumain";
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
		SFInfo sfInfo = sfRepository.findLastSfxx(ssInfo.getSsid()).get(0);
		DFInfo dfInfo = dfRepository.findLastDfxx(ssInfo.getSsid()).get(0);

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
	public String goStujf(String stuid, Model model) {
		StuInfo stuInfo = stuRepository.findOne(Integer.parseInt(stuid));
		SsInfo ssInfo = ssRepository.findBySsh(stuInfo.getSsh());
		SFInfo sfInfo = sfRepository.findLastSfxx(ssInfo.getSsid()).get(0);
		DFInfo dfInfo = dfRepository.findLastDfxx(ssInfo.getSsid()).get(0);

		Sdfxx sdfxx = new Sdfxx();
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
		model.addAttribute("sdfxx", sdfxx);
		model.addAttribute("ssinfo", ssInfo);
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
