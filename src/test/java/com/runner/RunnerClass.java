package com.runner;

import com.base.Base_Class;
import com.pageobjectmanager.PageObjectManager;

public class RunnerClass extends Base_Class{
	
	public static void main(String[] args) throws Exception {
		PageObjectManager pageObjectManager = new PageObjectManager();
		launchBrowser(pageObjectManager.getFileReader().getDataProperty("browser"));
		launchUrl(pageObjectManager.getFileReader().getDataProperty("url"));
		pageObjectManager.getLoginPage().validLogin();
		pageObjectManager.getSearchPage().searchProduct();
		pageObjectManager.getAddressPage().shippingPage();
		
	}

}
