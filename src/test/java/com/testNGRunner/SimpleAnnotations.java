package com.testNGRunner;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SimpleAnnotations {

	@BeforeSuite
	private void setUpProperty() {
		System.out.println("");
	}
}
