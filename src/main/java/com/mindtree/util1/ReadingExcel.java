package com.mindtree.util1;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {
	private static  XSSFSheet ExcelSheet;
	private static XSSFWorkbook ExcelBook;
	private static XSSFCell Cell;
	
	public static void setExceFile(String SheetName)
	{
		try {
			FileInputStream ExcelFile = new FileInputStream(Constants1.File_TestData); 
			ExcelBook = new XSSFWorkbook(ExcelFile);
			ExcelSheet = ExcelBook.getSheet(SheetName);
		}
		catch(Exception e)
		
		{
			System.out.println(e);
		}
	}
	public static String getCellData(int RowNum,int ColNum,String SheetName)
	{
		try {
			setExceFile(SheetName);
			Cell = ExcelSheet.getRow(RowNum).getCell(ColNum);
			String cellData = Cell.getStringCellValue();
			return cellData;
			
		}
		catch(Exception e)
		{
		return "";
		}
		
		
	}

}
