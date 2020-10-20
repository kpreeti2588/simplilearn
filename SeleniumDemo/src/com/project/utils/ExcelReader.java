package com.project.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Hashtable;

import org.apache.poi.ss.usermodel.Cell;
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
		System.out.println("Row count  "+ rowCount); // Excludes the header row, count will be 3 in case of 4 rows excluding header
		
		Object [][] data = new Object [rowCount][1];
		Row keyrow = sheet.getRow(0);  // key row or header row
		Hashtable<String, String> rec = null; 
		
		for(int r=1; r<=rowCount; r++) {
			rec = new Hashtable<String, String>();
			Row datarow = sheet.getRow(r);   // current row
			int Columncount = datarow.getLastCellNum();
			for(int c=0; c<Columncount;c++) {
				String key = keyrow.getCell(c).getStringCellValue();
				String value = datarow.getCell(c).getStringCellValue();
				rec.put(key,value);			
			}
			data[r-1][0] = rec;
		}
		return data;
	}
	
	public void ReadExcel(String filepath, String filename, String sheetname) throws IOException {
		File file = new File(filepath + "/"+filename);
		FileInputStream inputStream = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet= workbook.getSheet(sheetname);
		
		int rowCount = sheet.getLastRowNum();
		System.out.println("Row count  "+ rowCount); // Excludes the header row, count will be 3 in the row and it will exclude header 
		
		for(int r =0; r<=rowCount; r++) {
			Row row = sheet.getRow(r);   // current row
			int Columncount = row.getLastCellNum();
			for(int c=0; c<Columncount;c++) {
				Cell cell = row.getCell(c);
				System.out.print(cell.getStringCellValue().toString()+ "\t");
			}
			System.out.println("");
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		ExcelReader reader = new ExcelReader();
		
		String ProjectPath = System.getProperty("user.dir");
		String filepath = ProjectPath +"/src/com/project/testdata";
		String filename = "CalorieData.xlsx";
		String sheetname = "CalorieTestSet";
		
		reader.ReadExcelToArray(filepath, filename, sheetname);
	}
}
