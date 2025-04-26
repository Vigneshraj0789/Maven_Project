package com.interfaceelements;

public interface LoginPageInterFaceElement {
	
	String signIn_xpath = "//a[normalize-space()='Sign In']";
	
	String email_id = "email";
	
	String password_css = "input#pass";
	
	String login_xpath = "//*[text()='Sign In']";
	
	String title_xpath  = "(//span[@class='logged-in'])[1]";

}
