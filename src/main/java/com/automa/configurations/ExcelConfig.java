package com.automa.configurations;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {

	XSSFWorkbook wb;
	XSSFSheet sheet;
		
	public ExcelConfig(String path) {
		try {
			File src = new File(path);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			isSheetEmpty();
		
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void isSheetEmpty() {
		int sheetCount= wb.getNumberOfSheets();
		System.out.println("number of sheets in the workbook: " + sheetCount);
	}
	
	
	public String rowData(String sheetName, int row, int column) {
		sheet = wb.getSheet(sheetName);
		
		XSSFCell cell = sheet.getRow(row).getCell(column);
		cell.setCellType(CellType.STRING);
		System.out.println(cell);
		String data = cell.getStringCellValue();
		System.out.println(data);
		return data;
	}
	
	public String getSheetName() {
		String ws= sheet.toString(); 
		return ws;
	}
	
	// Gets Rowcount
	
		public int rowCount(String sh) {
			int rowCount = wb.getSheet(sh).getLastRowNum();
			//int rowCount = sheet.getLastRowNum();
			return rowCount;
		}
	
}
