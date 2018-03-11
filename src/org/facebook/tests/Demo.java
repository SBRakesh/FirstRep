package org.facebook.tests;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Demo {

	public static void main(String[] args) throws Exception {
		FileInputStream fis = new FileInputStream("./data/input.xlsx");
		
		XSSFWorkbook s = new XSSFWorkbook(fis);
		XSSFSheet sh = s.getSheet("tags");
		XSSFRow r = sh.createRow(5);
		XSSFCell c = r.createCell(5);
		c.setCellValue("hiiiiii");
		FileOutputStream fos = new FileOutputStream("./data/input.xlsx");
		s.write(fos);
		s.close();
	}

}
