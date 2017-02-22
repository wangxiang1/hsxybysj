package edu.hsxy.bysj.service.quartz;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {

	/**
	 * 读取excel中的数据,生成list
	 */
	String readExcelFile(MultipartFile file);

}
