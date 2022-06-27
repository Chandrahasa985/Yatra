package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XL {
	
	FileInputStream file;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	
	String path = null;
	public XL ( String path) {
		this.path = path;
	}
	public int getrowcount ( String sheetname) throws IOException {
		file = new FileInputStream (path);
		wb = new XSSFWorkbook(file);
		sheet = wb.getSheet(sheetname);
		int rowcount = sheet.getLastRowNum();
		wb.close();
		file.close();
		
		return rowcount;
		}
	
	public int getcolcount ( String sheetname, int rownum) throws IOException {
		file = new FileInputStream (path);
		wb = new XSSFWorkbook(file);
		sheet = wb.getSheet(sheetname);
		row = sheet.getRow(rownum);
		int columncount = row.getLastCellNum();
		wb.close();
		file.close();
		
		return columncount;
		
	}
	
	public String getCellData (String sheetname, int rownum, int column) throws IOException {
		

		file=new FileInputStream(path);
		wb = new XSSFWorkbook(file);
		sheet = wb.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cell = row.getCell(column); 
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);
		}
		catch ( Exception e) {
			data="";
		}
		wb.close();
		file.close();
		return data;
	}
	
	
	
	
	

}
