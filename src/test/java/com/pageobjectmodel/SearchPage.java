package com.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.Base_Class;
import com.interfaceelements.SearchPageInterFaceElement;

public class SearchPage extends Base_Class implements SearchPageInterFaceElement{
	
	@FindBy(xpath = men_xpath)
	private WebElement men;
	
	@FindBy(xpath = jackets_xpath)
	private WebElement jackets;
	
	@FindBy(xpath = montana_xpath)
	private WebElement montana;
	
	@FindBy(xpath = size_xpath)
	private WebElement size;
	
	@FindBy(xpath = color_xpath)
	private WebElement color;
	
	@FindBy(xpath = addCart_xpath)
	private WebElement addCart;
	
	@FindBy(xpath = cartbtn_xpath)
	private WebElement cartBtn;
	
	@FindBy(xpath = proceedcheck_xpath)
	private WebElement proceedCheck;
	
	public SearchPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void searchProduct() throws InterruptedException {
		clickOnElement(men);
		clickOnElement(jackets);
		clickOnElement(montana);
		clickOnElement(size);
		clickOnElement(color);
		clickOnElement(addCart);
		Thread.sleep(5000);
		clickOnElement(cartBtn);
		Thread.sleep(6000);
        clickOnElement(proceedCheck);
	}

}
