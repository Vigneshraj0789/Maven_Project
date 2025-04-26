package com.interfaceelements;

public interface AddressPageInterFaceElement {
	
	String nextBtn_xpath = "//button[@class='button action continue primary']";
	
	String placeOrder_xpath = "//button[@class='action primary checkout']";
	
	String ordernum_xpath = "//a[@class='order-number']";
	
	String accBtn_xpath = "(//button[@class='action switch'])[1]";
	
	String signOut_xpath = "(//a[normalize-space()='Sign Out'])[1]";

}
