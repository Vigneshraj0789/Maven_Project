package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.LoginPageInterFaceElement;
import com.utility.FileReaderManager;

public class LoginPage extends Base_Class implements LoginPageInterFaceElement{

	@FindBy(xpath =  signIn_xpath)
	private WebElement signin;
	
	@FindBy(id = email_id)
	private WebElement email;
	
	@FindBy(css = password_css)
	private WebElement password;
	
	@FindBy(xpath = login_xpath)
	private WebElement login;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public  void validLogin() throws Exception {
		
		FileReaderManager data = new FileReaderManager();
		
		clickOnElement(signin);
		loginInput(email,data.getDataProperty("loginusername"));
		loginInput(password, data.getDataProperty("loginpassword"));
		clickOnElement(login);
		Thread.sleep(5000);
		dynamicScreenShot();

	}
	

}