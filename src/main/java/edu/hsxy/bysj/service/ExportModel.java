package edu.hsxy.bysj.service;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ExportModel {
	public void exportModel(HttpServletResponse response) {
		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet();

		// 创建表头
		HSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("宿舍楼号");
		row1.createCell(1).setCellValue("宿舍号");
		row1.createCell(2).setCellValue("水表起码");
		row1.createCell(3).setCellValue("水表止码");
		row1.createCell(4).setCellValue("水费单价(吨/元)");
		row1.createCell(5).setCellValue("电表起码");
		row1.createCell(6).setCellValue("电表止码");
		row1.createCell(7).setCellValue("电费单价(千瓦时/元)");

		// 下载excel文件
		download(response, wb);
	}

	/**
	 * download
	 * 
	 * @auther renguangli
	 * @param response
	 * @param wb
	 * @see ExcelService#download()
	 */
	private void download(HttpServletResponse response, HSSFWorkbook wb) {
		try {
			// 输出Excel文件
			OutputStream output = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename=" + toUtf8String("水电信息录入模板") + ".xls");
			response.setContentType("application/msexcel");
			// 释放资源关闭连接
			wb.write(output);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String toUtf8String(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0) {
						k += 256;
					}
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}

}
