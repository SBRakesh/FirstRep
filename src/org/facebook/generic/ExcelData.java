package org.facebook.generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
	public static String getData(String path, String sheet, int rn, int cn) 
	{
		try
		{
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			String data = wb.getSheet(sheet).getRow(rn).getCell(cn).toString();
			return data;
		}
		catch (Exception e) 
		{
			return "";
		}
	}
	
	public static int getRowCount(String path, String sheet)
	{
		try
		{
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			int rc = wb.getSheet(sheet).getLastRowNum();
			return rc;
		}
		catch (Exception e) 
		{
			return 0;
		}
	}
	
	public static short getCellCount(String path, String sheet, int rn)
	{
		try
		{
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			short cc = wb.getSheet(sheet).getRow(rn).getLastCellNum();
			return cc;
		}
		catch (Exception e) 
		{
			return 0;
		}
	}
}
