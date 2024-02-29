package com.generics;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class Excelllibrary implements AutoConstant {
	
	@DataProvider(name="logindata")
	public static Object[][]fetchData() throws IOException{
	
		FileInputStream fis=new FileInputStream(excel_path);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sheet = wb.getSheet(sheet_name);
			int rows = sheet.getLastRowNum();
			int cols=sheet.getRow(0).getLastCellNum();
			Object data[][]=new Object [rows][cols];
			
			for(int r=1;r<=rows;r++) {
				
				XSSFRow row = sheet.getRow(r);
				for(int j=0;j<cols;j++) {
					
					XSSFCell cell = row.getCell(j);
					data[r-1][j] = cell.getStringCellValue();
					}
			
	}
			return data;
	
	}
	
}


