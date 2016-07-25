package com.zivame.common.scenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelReport {
	

	public static String dir;
//create excel file
	public   void CreateExcel(String dirName)
	{
		dir= dirName;
		FileInputStream file;
		try {
			String filename = dirName+"\\ExcelResult.xls" ;
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Results");  
            HSSFRow rowhead = sheet.createRow((short)0);
            rowhead.createCell(0).setCellValue("SlNo");
            rowhead.createCell(1).setCellValue("TestCase Number");
            rowhead.createCell(2).setCellValue("Result");
            rowhead.createCell(3).setCellValue("Comment");
            
            FileOutputStream fileOut = new FileOutputStream(filename);
            workbook.write(fileOut);
            fileOut.close();
            System.out.println("Your excel file has been generated!");

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
	}

	
	//get row count 
	public int  GetExcelRowCount()
	{
		int rowCount =0;
		
		try
		{
			FileInputStream fis = new FileInputStream(dir+"\\ExcelResult.xls");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet("Results");
			rowCount = s.getLastRowNum();
			
			
			
		}catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}catch(InvalidFormatException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return rowCount;
	}
	
	//Write into the Excell
	public void EnterDataINExcell(int rownum,String testcasenum,String res,String comment)
	{
		
		try {
			FileInputStream fis = new FileInputStream(dir+"\\ExcelResult.xls");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet s = wb.getSheet("Results");
			Row r = s.createRow(rownum);
			Cell c0 = r.createCell(0);
			c0.setCellValue(rownum);
			Cell c1 = r.createCell(1);
			c1.setCellValue(testcasenum);
			Cell c2 = r.createCell(2);
			c2.setCellValue(res);
			Cell c3 = r.createCell(3);
			c3.setCellValue(comment);
			
			FileOutputStream fos = new FileOutputStream(dir+"\\ExcelResult.xls");
			wb.write(fos);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}
