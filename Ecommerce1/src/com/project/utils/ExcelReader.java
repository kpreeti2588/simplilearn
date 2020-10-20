package com.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public Object[][] ReadExcelToArray(String filepath, String filename, String sheetname) throws IOException{
		
		File file = new File(filepath + "/"+filename);
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet= workbook.getSheet(sheetname);
		
		int rowCount = sheet.getLastRowNum();
		System.out.println("Actual Row count  "+ rowCount); // Excludes the header row, count will be 3 in case of 4 rows excluding header
		
		Object [][] data = new Object [rowCount][1];
		Row keyrow = sheet.getRow(0);  // key row or header row
		Hashtable<String, String> rec = null; 
		 DataFormatter formatter = new DataFormatter();
		for(int r=1; r<=rowCount; r++) {
			rec = new Hashtable<String, String>();
			Row datarow = sheet.getRow(r);   // current row
			
			int Columncount = datarow.getLastCellNum();			
			for(int c=0; c<Columncount;c++) {
				String key = keyrow.getCell(c).getStringCellValue();
				String value =formatter.formatCellValue(datarow.getCell(c));
				rec.put(key,value);
				}						
			data[r-1][0] = rec;
		}
		return data;
	}

}
