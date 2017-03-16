package edu.hsxy.bysj.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import edu.hsxy.bysj.bean.Sdfxx;

public interface ImportExcelService {

	/**
	 * 读取excel中的数据,生成list
	 */
	List<Sdfxx> readExcelFile(MultipartFile file);

}
