package com.pageobjectmanager;


import com.pageobjectmodel.AddressPage;
import com.pageobjectmodel.LoginPage;
import com.pageobjectmodel.SearchPage;
import com.utility.FileReaderManager;

public class PageObjectManager {
	
	private LoginPage loginPage;
	
	private FileReaderManager fileReader;
	
	private SearchPage searchPage;
	
	private AddressPage addressPage;
	
	public AddressPage getAddressPage() {
		if (addressPage == null) {
			addressPage = new AddressPage();
		}
		return addressPage;
	}

	public SearchPage getSearchPage() {
		if (searchPage == null) {
			searchPage = new SearchPage();
		}
		return searchPage;
	}
	
	public LoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
		}
	public FileReaderManager getFileReader() {
		if (fileReader == null) {
			fileReader = new FileReaderManager();
		}
		return fileReader;
		
	}
	

}
