package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static String getParticularData(int rowVlaue,int columnValue)  {

		String data = null;

		try {

			File file = new File ("C:\\Users\\VIGNESHRAJ\\Desktop\\DataDriven\\DataDriven_TestData.xlsx");

			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheet("Sheet1");
			Row row = sheet.getRow(rowVlaue);
			Cell cell = row.getCell(columnValue);

			DataFormatter dataFormat = new DataFormatter();
			data = dataFormat.formatCellValue(cell);
			System.out.println(data);
			
			book.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public static void getMultipleCellData() {

		try {

			File file = new File("C:\\Users\\VIGNESHRAJ\\Desktop\\DataDriven\\DataDriven_TestData.xlsx");
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheet("Sheet1");
			Row row = sheet.getRow(1);

			for (int i = 0; i <row.getLastCellNum(); i++) {
				Cell cell = row.getCell(i);
				DataFormatter dataFormat = new DataFormatter();
				String data = dataFormat.formatCellValue(cell);
				System.out.println(data);
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getAllData() {

		try {
			File file = new File("C:\\Users\\VIGNESHRAJ\\Desktop\\DataDriven\\DataDriven_TestData.xlsx");
			Workbook book = new XSSFWorkbook(file);
			Sheet sheet = book.getSheet("Sheet1");

			Row row;
			for (int i = 1; i < sheet.getLastRowNum(); i++) {
				row = sheet.getRow(i);


				for (int j = 0; j <row.getLastCellNum(); j++) {
					Cell cell = row.getCell(j);
					DataFormatter dataFormat = new DataFormatter();
					String data = dataFormat.formatCellValue(cell);
					System.out.println(data);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void writeData() {


		try {
			File file = new File("C:\\Users\\VIGNESHRAJ\\Desktop\\DataDriven\\DataDriven_TestData.xlsx");
			FileInputStream fileInput = new FileInputStream(file);
			Workbook book = new XSSFWorkbook(fileInput);
//			book.createSheet("AprIPT").createRow(0).createCell(0).setCellValue("Vignesh");
			book.getSheet("AprIPT").createRow(1).createCell(0).setCellValue("raj");
			book.getSheet("AprIPT").createRow(2).createCell(0).setCellValue("raj");
			FileOutputStream fileOutput = new FileOutputStream(file);
			book.write(fileOutput);
			book.close();
			System.out.println("--Successfully created----");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		getParticularData(1, 0);
//		writeData();

	}
}
