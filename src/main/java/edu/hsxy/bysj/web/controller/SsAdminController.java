package edu.hsxy.bysj.web.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import edu.hsxy.bysj.bean.Pager;
import edu.hsxy.bysj.bean.Sdfxx;
import edu.hsxy.bysj.bean.SsAadmin;
import edu.hsxy.bysj.bean.Sslxx;
import edu.hsxy.bysj.bean.Student;
import edu.hsxy.bysj.domain.DFInfo;
import edu.hsxy.bysj.domain.Ggxx;
import edu.hsxy.bysj.domain.SFInfo;
import edu.hsxy.bysj.domain.SSAdmin;
import edu.hsxy.bysj.domain.SsInfo;
import edu.hsxy.bysj.domain.StuInfo;
import edu.hsxy.bysj.domain.User;
import edu.hsxy.bysj.repository.DfRepository;
import edu.hsxy.bysj.repository.GgRepository;
import edu.hsxy.bysj.repository.SfRepository;
import edu.hsxy.bysj.repository.SsAdminRepository;
import edu.hsxy.bysj.repository.SsRepository;
import edu.hsxy.bysj.repository.StuRepository;
import edu.hsxy.bysj.repository.UserRepository;
import edu.hsxy.bysj.service.ExcelService;
import edu.hsxy.bysj.service.ExportModel;
import edu.hsxy.bysj.service.ImportExcelService;
import edu.hsxy.bysj.util.DateUtil;
import edu.hsxy.bysj.util.MathUtil;
import edu.hsxy.bysj.util.PageableTools;
import edu.hsxy.bysj.util.SortDto;

@Controller
@RequestMapping("/hsxy/sdjf/ssadmin")
@SessionAttributes({ "user", "user" })
public class SsAdminController {
	@Autowired
	private ImportExcelService importExcelService;

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

	@Autowired
	private ExportModel excelModel;

	@Autowired
	private ExcelService<SFInfo> excelServiceS;

	@Autowired
	private GgRepository ggRepository;

	/*
	 * @Autowired private ExcelService<DFInfo> excelServiceD;
	 */

	@RequestMapping("/gossgly")
	public String goXtAdmin() {
		return "ssadmin/ssglyindex";
	}

	@RequestMapping("/gossglytop")
	public String goXttop() {
		return "ssadmin/ssglytop";
	}

	@RequestMapping("/gossglyleft")
	public String goXtleft() {
		return "ssadmin/ssglyleft";
	}

	@RequestMapping("/gosdfsj")
	public String goXtsdfxj(Model model, Integer page, String sslh, String ssh, String sfjf, String date) {
		int size = 8;
		Pageable pageable = PageableTools.basicPage(page, size, "date");
		Page<SFInfo> sfInfos = null;
		List<Sdfxx> sdfxxs = new ArrayList<Sdfxx>();

		List<Integer> ssids = new ArrayList<Integer>();
		if (sslh == "" && ssh == "") {
			ssids = ssRepository.findAllSsids();
		} else if (sslh != "" && ssh == "") {
			ssids = ssRepository.findAllSsidsBySslh(sslh);
		} else if (sslh == "" && ssh != "") {
			ssids = ssRepository.findAllSsidsBySsh(ssh);
		} else if (sslh != "" && ssh != "") {
			ssids = ssRepository.findAllSsidsBySslhAndSsh(sslh, ssh);
		}

		if (sfjf == "" && date == "") {
			sfInfos = sfRepository.findAllInSsids(ssids, pageable);
		} else if (sfjf != "" && date == "") {
			sfInfos = sfRepository.findSfxxBySfjf(sfjf, ssids, pageable);
		} else if (sfjf == "" && date != "") {
			sfInfos = sfRepository.findSfxxByDate(date, ssids, pageable);
		} else if (sfjf != "" && date != "") {
			sfInfos = sfRepository.findSfxxByDateAndSfjf(date, sfjf, ssids, pageable);
		}
		for (SFInfo sfInfo : sfInfos.getContent()) {
			SsInfo ssInfo = null;
			ssInfo = ssRepository.findOne(sfInfo.getSsid());
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
		return "ssadmin/sdfsj";
	}

	@RequestMapping("/gossglymain")
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

		List<Ggxx> ggxxs = ggRepository.findAll();
		model.addAttribute("ggxxs", ggxxs);

		int ssgs = ssRepository.ssgs();
		int stunum = stuRepository.stunum();
		model.addAttribute("ssgs", ssgs);
		model.addAttribute("stunum", stunum);
		return "ssadmin/ssglymain";
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
		return "ssadmin/yhxx";
	}

	@RequestMapping("/goglyxgmm")
	public String goglyxgmm(String yhid, Model model) {
		return "ssadmin/ssxgmm";
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

	@RequestMapping("/loadmodel")
	public void loadmodel(HttpServletResponse response) {
		excelModel.exportModel(response);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public boolean loadFile(@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, HttpServletResponse response) {
		boolean a = false;
		List<Sdfxx> lists = importExcelService.readExcelFile(file);
		String date = DateUtil.getNow();
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		for (Sdfxx sdfxx : lists) {
			SFInfo sfInfo = new SFInfo();
			DFInfo dfInfo = new DFInfo();
			SsInfo ssInfo = ssRepository.findBySsh(sdfxx.getSsh());
			if (ssInfo != null) {
				int ssid = ssInfo.getSsid();

				sfInfo.setSsid(ssid);
				sfInfo.setSbqm(sdfxx.getSbqm());
				sfInfo.setSbzm(sdfxx.getSbzm());
				sfInfo.setSfdj(sdfxx.getSfdj());
				int ysl = Integer.parseInt(sdfxx.getSbzm()) - Integer.parseInt(sdfxx.getSbqm());
				sfInfo.setYsl(String.valueOf(ysl));
				double sf = ysl * Double.parseDouble(sdfxx.getSfdj());
				sfInfo.setSf(String.valueOf(sf));
				sfInfo.setYslx("0");
				sfInfo.setDate(date);
				sfInfo.setSfjf("0");
				sfInfo.setCbry(String.valueOf(user.getYhid()));
				SFInfo sfInfo2 = sfRepository.save(sfInfo);

				dfInfo.setSsid(ssid);
				dfInfo.setDbqm(sdfxx.getDbqm());
				dfInfo.setDbzm(sdfxx.getDbzm());
				dfInfo.setDfdj(sdfxx.getDfdj());
				int ydl = Integer.parseInt(sdfxx.getDbzm()) - Integer.parseInt(sdfxx.getDbqm());
				dfInfo.setYdl(String.valueOf(ydl));
				double df = ydl * Double.parseDouble(sdfxx.getDfdj());
				dfInfo.setDf(String.valueOf(df));
				dfInfo.setYdlx("1");
				dfInfo.setDate(date);
				dfInfo.setSfjf("0");
				dfInfo.setCbry(String.valueOf(user.getYhid()));
				DFInfo dfInfo2 = dfRepository.save(dfInfo);

				if (sfInfo2 != null && dfInfo2 != null) {
					a = true;
				}
			}
		}
		return a;
	}

	@RequestMapping("/exportexcels")
	public void exportexcels(HttpServletResponse response) {
		String sfnames[] = { "水费信息id", "宿舍id", "水表起码", "水表止码", "用水类型", "用水量", "水费单价", "水费", "是否缴费", "日期", "测表人员id" };
		List<SFInfo> listObjects = new ArrayList<SFInfo>();
		listObjects = sfRepository.findAll();
		excelServiceS.export(response, listObjects, sfnames);

	}

	/*
	 * @RequestMapping("/exportexceld") public void
	 * exportexceld(HttpServletResponse response) { String dfnames[] = {
	 * "电费信息id", "宿舍id", "电表起码", "电表止码", "用电类型", "用电量", "电费单价", "电费", "是否缴费",
	 * "日期", "测表人员id" }; List<DFInfo> listObjectd = new ArrayList<DFInfo>();
	 * listObjectd = dfRepository.findAll(); excelServiceD.export(response,
	 * listObjectd, dfnames); }
	 */
	@RequestMapping("/goaddgg")
	public String goaddgg() {
		return "xtadmin/addgg";
	}

	@RequestMapping("/addgg")
	public String addgg(String ggbt, String ggnr) {
		Ggxx ggxx = new Ggxx();
		ggxx.setGgzt(ggbt);
		ggxx.setGgnr(ggnr);
		ggxx.setGgrq(DateUtil.getNow());
		ggRepository.save(ggxx);
		return "xtadmin/addgg";
	}

	@RequestMapping("/gggl")
	public String gggl(Model model, Integer page) {
		int size = 8;
		Pageable pageable = PageableTools.basicPage(page, size, "ggrq");
		Page<Ggxx> ggxxs = ggRepository.findAll(pageable);
		System.out.println(ggxxs.getContent());

		Pager pager = new Pager();
		pager.setPage(ggxxs.getNumber());// 页码
		pager.setSize(ggxxs.getSize());// 页容量
		pager.setTotalPages(ggxxs.getTotalPages());// 总页数

		model.addAttribute("ggxxs", ggxxs.getContent());
		model.addAttribute("pager", pager);
		return "xtadmin/gggl";
	}

}
