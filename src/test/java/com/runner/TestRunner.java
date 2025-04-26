package com.runner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.ReadExcelData;

public class TestRunner {
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.youtube.com/");
//		
//		String userName = ReadExcelData.getParticularData(1, 0);
//		driver.findElement(By.id("email")).sendKeys(userName);
//		
//		String password = ReadExcelData.getParticularData(1,1);
//		driver.findElement(By.id("pass")).sendKeys(password);
		
		String search = ReadExcelData.getParticularData(0, 0);
		
		driver.findElement(By.xpath("//input[@name='search_query']")).sendKeys(search);
		
		driver.findElement(By.xpath("(//button[@title='Search'])[1]")).click();
		
		
	}
	

}
