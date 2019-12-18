package com.automa.configurations;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.testng.annotations.DataProvider;

public class ExcelReader {
	
	ExcelConfig ex;
	String excelURL;
	
	private static Logger l1= LogManager.getLogger(ExcelReader.class.getName());
	
	public String getExcelPath() throws IOException {
		Properties p1 = TestConfigs.getEnvironmentProperties();
		excelURL = p1.getProperty("EXCEL");
		l1.info("Fetching Excel url from Property file");
		return excelURL;
		
	}

		public String[][] readLoginData() throws Exception{
		String[][] data;
		
			String sheet= "Login";
			int count;
			int column= 5;
			ex = new ExcelConfig(getExcelPath());
			count = ex.rowCount(sheet);
			 data= new String[count][column];
			for (int i= 0; i < count; i++) {
				for(int j=0; j<column; j++) {
				data[i][j]= ex.rowData(sheet, i+1, j);
				l1.info("Mapping row data to String array..");
			}
			}
				l1.info("Returning String array");
				System.out.println(data);
				return data;
	}
	
	
	
}
