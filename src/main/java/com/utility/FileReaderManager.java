package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {
	
	private static FileInputStream fileInputStream;
	private static Properties property;
	
	private static void setUpProperty() throws Exception {
		File file = new File("C:\\Users\\VIGNESHRAJ\\eclipse-workspace\\Maven_Project\\src\\main\\resources\\TestData.properties");
		try {
			fileInputStream = new FileInputStream(file);
			property = new Properties();
			property.load(fileInputStream);
		}catch (FileNotFoundException e) {
			Assert.fail("ERROR : OCCURE DURING FILE LOADING");
		}catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING FILE READING");
		}
	}
	public static String getDataProperty(String value) throws Exception {
		setUpProperty();
		String data = property.getProperty(value);
		return data;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(getDataProperty("browser"));
		System.out.println(getDataProperty("url"));
		System.out.println(getDataProperty("loginusername"));
	}

}
