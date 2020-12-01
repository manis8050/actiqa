package com.qa.actitime.Utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.qa.actitime.Base.DriverScript;

public class ExcelLib extends DriverScript {
	
	XSSFWorkbook wb;
	public ExcelLib()
	{
		
		try {
			System.out.println("Inside the excel sheet before");
			File src=new File("./actiTestData/actiData.xlsx");
			//File src=new File("./TestData/TestData.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		//	XSSFSheet sheetname = wb.getSheet("sheet1");
			System.out.println("Inside the excel sheet after");
			}
		catch(Exception e)
		{
			System.out.println("Excel sheet is not found");
			
		}
		
	}
	
	public XSSFSheet getSheetName(String sheet)
	{
		XSSFSheet sheetname = wb.getSheet(sheet);
		return sheetname;
	}
	
	public int getRowCount(XSSFSheet sheetname)
	{
		int rowcount=sheetname.getPhysicalNumberOfRows();
		return rowcount;
		
	}
	
	public int getColumnCount(XSSFSheet sheetname)
	{
		int colCount=sheetname.getRow(0).getLastCellNum();
	    return colCount;
	}
	
	public String[][] getCellData(XSSFSheet sheetName,int rownum,int colnum)
	{
		String[][] data=new String[rownum][colnum];
		for(int i=0;i<rownum;i++)
		{
			for(int j=0;j<colnum;j++)
			{
				data[i][j]=sheetName.getRow(i).getCell(j).toString();
				System.out.print(data[i][j]);
				System.out.print("    ");
			}
			System.out.println();
		}
		return data;
	}
	
	

}
