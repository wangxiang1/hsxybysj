package edu.hsxy.bysj.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import edu.hsxy.bysj.bean.SsAadmin;
import edu.hsxy.bysj.bean.Sslxx;
import edu.hsxy.bysj.bean.Student;
import edu.hsxy.bysj.domain.DFInfo;
import edu.hsxy.bysj.domain.SFInfo;
import edu.hsxy.bysj.domain.SSAdmin;
import edu.hsxy.bysj.domain.SsInfo;
import edu.hsxy.bysj.domain.StuInfo;
import edu.hsxy.bysj.domain.User;
import edu.hsxy.bysj.repository.DfRepository;
import edu.hsxy.bysj.repository.SfRepository;
import edu.hsxy.bysj.repository.SsAdminRepository;
import edu.hsxy.bysj.repository.SsRepository;
import edu.hsxy.bysj.repository.StuRepository;
import edu.hsxy.bysj.repository.UserRepository;
import edu.hsxy.bysj.util.AllSslh;
import edu.hsxy.bysj.util.DateUtil;
import edu.hsxy.bysj.util.MathUtil;
import edu.hsxy.bysj.util.PageableTools;
import edu.hsxy.bysj.util.SortDto;
import edu.hsxy.bysj.util.StuXbAndZy;

@Controller
@RequestMapping("/hsxy/sdjf/admin")
@SessionAttributes({ "user", "user" })
public class XtAdminController {

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
	private SsAdminRepository ssAdminRepository;

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

	@RequestMapping("/adduser")
	public String adduser(String bz, Model model) {
		model.addAttribute("bz", bz);
		return "xtadmin/adduser";
	}

	@RequestMapping("/addstu")
	public String addstu(String studlzh, String stuyhm, String stusex, String stuxl, String stuxb, String stuzy,
			String stusslh, String stussh, String stusjhm) {
		User user = new User();
		StuInfo stuInfo = new StuInfo();
		String date = DateUtil.getNow();

		user.setDlzh(studlzh);
		user.setPwd("123456");
		user.setSfbz("1");
		user.setYhm(stuyhm);
		user.setZcsj(date);
		user.setSjhm(stusjhm);
		userRepository.save(user);

		User user1 = userRepository.findByDlzh(studlzh);
		stuInfo.setStuid(user1.getYhid());
		stuInfo.setSex(Integer.parseInt(stusex));
		stuInfo.setXl(stuxl);
		stuInfo.setXb(stuxb);
		stuInfo.setZy(stuzy);
		stuInfo.setSsh(stussh);
		stuRepository.save(stuInfo);
		return "xtadmin/adduser";
	}

	@RequestMapping("/addgly")
	public String addgly(String glydlzh, String glyyhm, Integer glysex, String glybz, String glysslh, String glysjhm) {
		User user = new User();
		String date = DateUtil.getNow();

		user.setDlzh(glydlzh);
		user.setPwd("123456");
		user.setSfbz(glybz);
		user.setYhm(glyyhm);
		user.setSjhm(glysjhm);
		user.setZcsj(date);
		userRepository.save(user);
		// 0：系统管理员 2:宿舍管理员
		if (glybz.equals("2")) {
			User user1 = userRepository.findByDlzh(glydlzh);
			SSAdmin ssAdmin = new SSAdmin();
			ssAdmin.setSsglyid(user1.getYhid());
			ssAdmin.setSex(glysex);
			ssAdmin.setSslh(glysslh);
			ssAdminRepository.save(ssAdmin);
		}
		return "xtadmin/adduser";
	}

	@RequestMapping("/stuxb")
	@ResponseBody
	public JSONObject stuxb(Model model, String stuxl) {
		JSONObject jsonObject = new JSONObject();
		Map<String, List<String>> maps = null;
		// 如果是本科
		if ("0".equals(stuxl)) {
			maps = StuXbAndZy.getBkXbAndZy();
		} else {
			maps = StuXbAndZy.getZkXbAndZy();
		}

		Set<String> keyset = maps.keySet();
		jsonObject.put("xbs", keyset);
		return jsonObject;
	}

	@RequestMapping("/stuzy")
	@ResponseBody
	public JSONObject stuzy(Model model, String stuxl, String stuxb) {
		JSONObject jsonObject = new JSONObject();
		Map<String, List<String>> maps = null;
		List<String> zys = new ArrayList<String>();
		// 如果是本科
		if (!"".equals(stuxb)) {
			if ("0".equals(stuxl)) {
				maps = StuXbAndZy.getBkXbAndZy();
			} else {
				maps = StuXbAndZy.getZkXbAndZy();
			}
			zys = maps.get(stuxb);
		}
		jsonObject.put("zys", zys);
		return jsonObject;
	}

	@RequestMapping("/glysslh")
	@ResponseBody
	public JSONObject glysslh() {
		JSONObject jsonObject = new JSONObject();
		List<String> sslhs = new ArrayList<String>();
		sslhs = AllSslh.getSslhs();
		jsonObject.put("sslhs", sslhs);
		return jsonObject;
	}

	@RequestMapping("/finddlzh")
	@ResponseBody
	public boolean finddlzh(String dlzh) {
		boolean ret = true;
		User user = userRepository.findByDlzh(dlzh);
		if (null == user) {
			ret = false;
		}
		return ret;
	}

	@RequestMapping("/yhxx")
	public String yhxx(Model model, Integer page, String bz) {
		List<Student> students = new ArrayList<Student>();
		List<SsAadmin> ssAadmins = new ArrayList<SsAadmin>();
		int size = 5;
		SortDto sort = new SortDto("asc", "dlzh");
		Pageable pageable = PageableTools.basicPage(page, size, sort);
		if (bz.equals("1")) {
			Page<User> users = userRepository.findBySfbz("1", pageable);
			for (User user : users.getContent()) {
				Student student = new Student();
				student.setStuid(user.getYhid());
				student.setYhm(user.getYhm());
				student.setDlzh(user.getDlzh());
				student.setSjhm(user.getSjhm());
				StuInfo stuInfo = stuRepository.findOne(user.getYhid());
				student.setSex(stuInfo.getSex());
				student.setXl(stuInfo.getXl());
				student.setXb(stuInfo.getXb());
				student.setZy(stuInfo.getZy());
				student.setSsh(stuInfo.getSsh());
				SsInfo ssInfo = ssRepository.findBySsh(stuInfo.getSsh());
				student.setSslh(ssInfo.getSslh());

				students.add(student);
			}
			Pager pager = new Pager();
			pager.setPage(users.getNumber());// 页码
			pager.setSize(users.getSize());// 页容量
			pager.setTotalPages(users.getTotalPages());// 总页数
			model.addAttribute("pager", pager);
		} else {
			Collection<String> userlist = new ArrayList<String>();
			userlist.add("0");
			userlist.add("2");
			Page<User> users = userRepository.findBySfbzIn(userlist, pageable);
			for (User user : users.getContent()) {
				SsAadmin ssAadmin = new SsAadmin();
				ssAadmin.setSsglyid(user.getYhid());
				ssAadmin.setDlzh(user.getDlzh());
				ssAadmin.setPwd(user.getPwd());
				ssAadmin.setSjhm(user.getSjhm());
				ssAadmin.setYhm(user.getYhm());
				ssAadmin.setSsglyid(user.getYhid());
				ssAadmin.setSfbz(user.getSfbz());
				if (user.getSfbz().equals("2")) {
					SSAdmin ssAdmin1 = ssAdminRepository.findOne(user.getYhid());
					ssAadmin.setSex(ssAdmin1.getSex());
					ssAadmin.setSslh(ssAdmin1.getSslh());
				} else {
					ssAadmin.setSex(3);
					ssAadmin.setSslh("all");
				}

				ssAadmins.add(ssAadmin);
				Pager pager1 = new Pager();
				pager1.setPage(users.getNumber());// 页码
				pager1.setSize(users.getSize());// 页容量
				pager1.setTotalPages(users.getTotalPages());// 总页数
				model.addAttribute("pager1", pager1);
			}
		}
		model.addAttribute("students", students);
		model.addAttribute("ssAadmins", ssAadmins);
		model.addAttribute("bz", bz);
		return "xtadmin/yhxx";
	}

	@RequestMapping("/delallstu")
	@ResponseBody
	public boolean delallstu(String ids) {
		boolean ret = false;
		String[] idarry = ids.split(",");
		List<Integer> listid = new ArrayList<Integer>();
		for (int i = 0; i < idarry.length; i++) {
			listid.add(Integer.parseInt(idarry[i]));
		}

		int delsum = userRepository.deleteById(listid);
		int delstu = stuRepository.deleteById(listid);
		if (delsum != 0 && delstu != 0) {
			ret = true;
		}
		return ret;
	}

	@RequestMapping("/delallgly")
	@ResponseBody
	public boolean delallgly(String ids) {
		boolean ret = false;
		String[] idarry = ids.split(",");
		List<Integer> listid = new ArrayList<Integer>();
		for (int i = 0; i < idarry.length; i++) {
			listid.add(Integer.parseInt(idarry[i]));
		}

		int delsum = userRepository.deleteById(listid);
		int delgly = ssAdminRepository.deleteById(listid);
		if (delsum != 0 && delgly != 0) {
			ret = true;
		}
		return ret;
	}

	@RequestMapping("/xgxx")
	public String xgxx(Integer id, String sdbz, Model model) {
		User user = userRepository.findOne(id);
		if (sdbz.equals("1")) {
			Student student = new Student();
			student.setStuid(user.getYhid());
			student.setYhm(user.getYhm());
			student.setDlzh(user.getDlzh());
			student.setSjhm(user.getSjhm());
			StuInfo stuInfo = stuRepository.findOne(id);
			student.setSex(stuInfo.getSex());
			student.setXl(stuInfo.getXl());
			student.setXb(stuInfo.getXb());
			student.setZy(stuInfo.getZy());
			student.setSsh(stuInfo.getSsh());
			SsInfo ssInfo = ssRepository.findBySsh(stuInfo.getSsh());
			student.setSslh(ssInfo.getSslh());
			model.addAttribute("student", student);
		} else {
			SsAadmin ssAadmin = new SsAadmin();
			ssAadmin.setSsglyid(user.getYhid());
			ssAadmin.setDlzh(user.getDlzh());
			ssAadmin.setPwd(user.getPwd());
			ssAadmin.setSjhm(user.getSjhm());
			ssAadmin.setYhm(user.getYhm());
			ssAadmin.setSsglyid(user.getYhid());
			ssAadmin.setSfbz(user.getSfbz());
			if (user.getSfbz().equals("2")) {
				SSAdmin ssAdmin1 = ssAdminRepository.findOne(user.getYhid());
				ssAadmin.setSex(ssAdmin1.getSex());
				ssAadmin.setSslh(ssAdmin1.getSslh());
			}
			model.addAttribute("ssAadmin", ssAadmin);
		}
		model.addAttribute("bz", sdbz);
		return "xtadmin/xgxx";
	}

	@RequestMapping("/updatestu")
	@ResponseBody
	public boolean updatestu(String studlzh, String stuyhm, String stusex, String stuxl, String stuxb, String stuzy,
			String stussh, String stusjhm) {
		int stuid = userRepository.findByDlzh(studlzh).getYhid();
		int upuser = userRepository.updateUser(stuid, stuyhm, stusjhm, "1");
		int upstu = stuRepository.updateStu(stuid, Integer.parseInt(stusex), stuxl, stuxb, stuzy, stussh);
		if (upstu == 1 && upuser == 1) {
			return true;
		}
		return false;
	}

	@RequestMapping("/updategly")
	@ResponseBody
	public boolean updategly(String glydlzh, String glyyhm, String glysex, String glybz, String glysslh,
			String glysjhm) {
		int ssglyid = userRepository.findByDlzh(glydlzh).getYhid();
		int upuser = userRepository.updateUser(ssglyid, glyyhm, glysjhm, glybz);
		if (glybz.equals("2")) {
			SSAdmin ssAdmin = ssAdminRepository.findOne(ssglyid);
			if (null == ssAdmin) {
				SSAdmin ssAdmin1 = new SSAdmin();
				ssAdmin1.setSsglyid(ssglyid);
				ssAdmin1.setSex(Integer.parseInt(glysex));
				ssAdmin1.setSslh(glysslh);
				SSAdmin ssAdmin2 = ssAdminRepository.save(ssAdmin1);
				if (null != ssAdmin2 && upuser == 1) {
					return true;
				}
			} else {
				int upadmin = ssAdminRepository.updateAdmin(ssglyid, Integer.parseInt(glysex), glysslh);
				if (upadmin == 1 && upuser == 1) {
					return true;
				}
			}
		}

		return false;
	}

	@RequestMapping("/goglyxgmm")
	public String goglyxgmm(String yhid, Model model) {
		return "xtadmin/xtxgmm";
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
}
