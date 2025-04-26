package com.pageobjectmodel;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.AddressPageInterFaceElement;

public class AddressPage extends Base_Class implements AddressPageInterFaceElement{
	
	@FindBy(xpath = nextBtn_xpath)
	private WebElement nextBtn;
	
	@FindBy(xpath = placeOrder_xpath)
	private WebElement placeorderBtn;
	
	@FindBy(xpath = ordernum_xpath)
	private WebElement value;
	
	@FindBy(xpath = accBtn_xpath)
	private WebElement accBtn;
	
	@FindBy(xpath = signOut_xpath)
	private WebElement signOut;
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void shippingPage() throws InterruptedException, IOException {
		Thread.sleep(6000);
		clickOnElement(nextBtn);
		Thread.sleep(8000);
		clickOnElement(placeorderBtn);
		Thread.sleep(4000);
		System.out.println("Your Order id :" + value.getText());
		
		dynamicScreenShot();
		
		clickOnElement(accBtn);
		
		clickOnElement(signOut);
		
		

	}

}
