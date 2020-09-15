package com.skillrary.skillkart.generic;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary
{
	
	// Use this for normal data reading - standard way
	public static String getExcelData(String filePath, String sheetName, int row, int cell)
	{
		String data=null;
		try
		{
			FileInputStream file = new FileInputStream(filePath);
			Sheet sheet=WorkbookFactory.create(file).getSheet(sheetName);
			data = sheet.getRow(row).getCell(cell).toString();
			//System.out.println("From ExcelLib "+ data);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return data;
	}
	
	// Use this for data provider
	public static Object[][] getExcelData(String filePath, String sheetName)
	{
		Object[][] arr=null;
		try
		{
			FileInputStream file = new FileInputStream(filePath);
			Sheet sheet=WorkbookFactory.create(file).getSheet(sheetName);
			int rowsCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			arr = new Object[rowsCount-1][colCount];
			for(int i=1,k=0;i<=rowsCount-1;i++,k++)
			{
				int cellCount=sheet.getRow(i).getPhysicalNumberOfCells();
				for(int j=0;j<=cellCount-1;j++)
				{
					//arr[k][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					arr[k][j]=sheet.getRow(i).getCell(j).toString();
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return arr;
	}
}
