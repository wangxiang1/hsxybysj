package edu.hsxy.bysj.service;
/**
 * Company:www.renguangli.com
 * Project Name:dormitory
 * File Name:ExcelUtil.java
 * Package Name:com.renguangli.dormitory.util
 * Create date:2017年2月21日 下午4:30:38 
 * Copyright (C) 2016-2017,renguangli. All Rights Reserved.
 */

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.util.DateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

/**
 * ExcelUtil
 *
 * @author renguangli
 * @since JDK 1.8
 */
@Service
public class ExcelService<T> {

	public void export(HttpServletResponse response, List<T> listObject, List<String> names) {
		if (listObject == null || listObject.isEmpty()) {
			// logger.info("{} is null or listObject.length = 0", listObject);
			return;
		}
		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wb = new HSSFWorkbook();
		// 建立sheet对象（excel的表单）
		HSSFSheet sheet = wb.createSheet();
		// 创建表头
		HSSFRow row1 = sheet.createRow(0);
		// Field[] declaredFields =
		// listObject.get(0).getClass().getDeclaredFields();
		// declaredFields = remove(declaredFields, "serialVersionUID");
		// for (int i = 0; i < declaredFields.length; i++) {
		// String fieldName = declaredFields[i].getName();
		// row1.createCell(i).setCellValue(fieldName);
		// }
		for (int i = 0; i < names.size(); i++) {
			row1.createCell(i).setCellValue(names.get(i));
		}

		for (int i = 0; i < listObject.size(); i++) {
			HSSFRow row = sheet.createRow(i + 1);
			Field[] fields = listObject.get(i).getClass().getDeclaredFields();
			fields = remove(fields, "serialVersionUID");
			for (int j = 0; j < fields.length; j++) {
				String value = getValue(listObject.get(i), fields[j]);
				row.createCell(j).setCellValue(value);
			}
		}
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
			response.setHeader("Content-disposition", "attachment; filename=" + System.currentTimeMillis() + ".xls");
			response.setContentType("application/msexcel");
			// 释放资源关闭连接
			wb.write(output);
			output.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * getValue
	 * 
	 * @auther renguangli
	 * @param object
	 * @param field
	 * @return
	 * @see ExcelServiceImpl#getValue()
	 */
	private String getValue(Object object, Field field) {
		try {
			String fieldName = field.getName();
			String fieldType = field.getGenericType().toString();
			String name = getMethodName(fieldName);
			// 拼接getter方法
			String methodName = "get" + name;
			Method method = object.getClass().getMethod(methodName);
			if ("class java.lang.String".equals(fieldType)) {
				return (String) method.invoke(object);
			} else if ("class java.util.Date".equals(fieldType)) {
				Date date = (Date) method.invoke(object);
				return DateUtil.formatDate(date, "yyyy-MM-dd");
			} else if ("char".equals(fieldType)) {
				char sex = (char) method.invoke(object);
				return String.valueOf(sex);
			} else if ("int".equals(fieldType)) {
				int sex = (int) method.invoke(object);
				return String.valueOf(sex);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * getMethodName
	 * 
	 * @auther renguangli
	 * @param fildeName
	 * @return
	 * @see ExcelService#getMethodName()
	 */
	private String getMethodName(String fildeName) {
		// 把一个字符串的第一个字母大写
		// return fieldName.substring(0, 1).toUpperCase() +
		// fieldName.substring(1);
		byte[] items = fildeName.getBytes();
		items[0] = (byte) ((char) items[0] - 'a' + 'A');
		return new String(items);
	}

	/**
	 * remove
	 * 
	 * @auther renguangli
	 * @param fields
	 * @param fieldName
	 * @return
	 * @see ExcelService#remove()
	 */
	private Field[] remove(Field[] fields, String fieldName) {
		for (int i = 0; i < fields.length; i++) {
			if (fieldName.equals(fields[i].getName())) {
				// 该元素被最后一个覆盖
				fields[i] = fields[fields.length - 1];
				// 数组缩容
				return Arrays.copyOf(fields, fields.length - 1);
			}
		}
		return fields;
	}

}
