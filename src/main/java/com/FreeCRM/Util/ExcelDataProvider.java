package com.FreeCRM.Util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelDataProvider 
{
	Workbook wb;

	public ExcelDataProvider()
	{
		try {
		File src = new File("./FreeCRM/FreeCRMTestData.xlsx");
		FileInputStream fis = new FileInputStream(src);
		wb = WorkbookFactory.create(fis);
		}catch(Exception e)
		{
			System.out.println("unable to read excel file"+" "+e.getMessage());
		}
	}
	
	//getStringData method is overloaded here.. once with sheetIndex and once with sheetName
	//so this is the example for method overloading
	public String getStringData(int sheetIndex, int row, int cell)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(cell).getStringCellValue();
	}
	
	public String getStringData(String sheetname, int row, int cell)
	{
		String cellvalue = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return cellvalue;
	}
	
	public int getNumericData(String sheetname, int row, int cell)
	{
		double cellValue = wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
		//casting double to int
		int intCellValue=(int)cellValue;
		return intCellValue;
	}
	
}
