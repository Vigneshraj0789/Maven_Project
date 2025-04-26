package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public abstract class Base_Class {

	public static WebDriver driver;

	public static JavascriptExecutor javascriptExecutor;

	protected static WebDriver launchBrowser(String browser) {
		try {
			if (browser.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING BROWSER LAUNCH");
		}
		driver.manage().window().maximize();
		return driver;
	}

	protected static void launchUrl(String url) {
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING URl LAUNCH");
		}
	}

	protected static void closeBrowser() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING BROWSER CLOSING");
		}
	}

	protected static void browserTermination() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING BROWSER TERMINATION");
		}
	}

	protected static void loginInput(WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING VALUE PASSING");
		}
	}

	protected static void clickOnElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING ELEMENT CLICK");
		}
	}

	protected static void windowsHandling(int num) {
		try {
			List<String> allWindow = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window(allWindow.get(num));
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING WINDOWS HANDLING");
		}
	}

	protected static void selectOptions(WebElement element, String type, String value) {
		try {
			Select select = new Select(element);
			if (type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);
			} else if (type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("value")) {
				select.selectByValue(value);
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING VALUE SELECTION");
		}
	}

	protected static void deSelectOptions(WebElement element, String type, String value) {
		try {
			Select select = new Select(element);
			if (type.equalsIgnoreCase("text")) {
				select.deselectByVisibleText(value);
			} else if (type.equalsIgnoreCase("index")) {
				select.deselectByIndex(Integer.parseInt(value));
			} else if (type.equalsIgnoreCase("value")) {
				select.deselectByValue(value);
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING VALUE DESELECTION");
		}
	}

	protected static void implicitWait(String type, int num) {
		try {
			if (type.equalsIgnoreCase("sec")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
			} else if (type.equalsIgnoreCase("min")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(num));
			} else if (type.equalsIgnoreCase("mills")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofMillis(num));
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING ELEMENT WAIT");
		}
	}

	protected static void navigateCommand(String command) {
		try {
			if (command.equalsIgnoreCase("back")) {
				driver.navigate().back();
			} else if (command.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			} else if (command.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING NAVIGATING PAGE");
		}
	}

	protected static void navigatePage(String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING NAVIGATING URL");
		}
	}

	protected static void verifyElement(WebElement element, String type) {
		try {
			switch (type.toLowerCase()) {
			case "enabled":
				element.isEnabled();
			case "displayed":
				element.isDisplayed();
			case "selected":
				element.isSelected();
			default:
				Assert.fail("ERROR : USING VERIFICATION");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING VERIFYING ELEMENT");
		}
	}

	protected static void getOptions(WebElement element) {
		try {
			Select select = new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement option : options) {
				System.out.println(option.getText());
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING GETTING OPTIONS");
		}
	}

	protected static String getInfo(WebElement element, String action) {
		try {
			switch (action.toLowerCase()) {
			case "title":
				return driver.getTitle();

			case "url":
				return driver.getCurrentUrl();

			case "text":
				if (element != null) {
					return element.getText();
				} else {
					Assert.fail("ERROR : NO WEBELEMENT IS FOUND");
				}
			default:
				Assert.fail("ERROR : ELEMENT NOT FOUND");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING GETTING INFORMATION");
		}
		return null;
	}

	protected static void performActions(WebElement element, String action) {
		try {
			Actions actions = new Actions(driver);
			switch (action.toLowerCase()) {
			case "click":
				actions.click(element).perform();
				break;
			case "doubleclick":
				actions.doubleClick(element).perform();
				break;
			case "rightclick":
				actions.contextClick(element).perform();
				break;
			case "movetoelement":
				actions.moveToElement(element).perform();
				break;
			default:
				Assert.fail("ERROR : INVALID ACTIONS");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING PERFORMING ACTIONS");
		}
	}

	protected static void handleAlert(String action) {
		try {
			switch (action.toLowerCase()) {
			case "accept":
				driver.switchTo().alert().accept();
				break;
			case "dismiss":
				driver.switchTo().alert().dismiss();
				break;
			case "gettext":
				driver.switchTo().alert().getText();
			default:
				Assert.fail("INVALID ALERT ACTION");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING HANDLING ALERT");
		}
	}

	protected static void switchToFrame(WebElement element, String frameType,int num) {
		try {
			if (frameType.equalsIgnoreCase("index")) {
				driver.switchTo().frame(Integer.parseInt(frameType));
			} else if (frameType.equalsIgnoreCase("name")) {
				driver.switchTo().frame(element);
			} else if (frameType.equalsIgnoreCase("element")) {
				driver.switchTo().frame(element);
			} else {
				Assert.fail("INVALID FRAME TYPE");
			}
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING SWITCHING FRAME");
		}
	}

	protected static void checkBox(WebElement checkBox) {
		try {
			checkBox.click();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING CLICKING CHECKBOX");
		}
	}

	protected static void radioButton(WebElement radioBtn) {
		try {
			radioBtn.click();
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING CLICKING RADIOBUTTON");
		}
	}
	protected static void keyPress(int keyCode) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(keyCode);
	}
	protected static void dynamicScreenShot() throws IOException {
		try {
			Date currentDate = new Date();
			System.out.println(currentDate);
			String dateFile = currentDate.toString().replace(" ", "_").replace(":", "_");
			File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(screenShot,new File(".//ScreenShot//"+dateFile+".png"));   
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING TAKING SCREENSHOT");
		}     
	}
	protected static void javaScriptSendKeys(WebElement element, String value) {
		try {
			javascriptExecutor = (JavascriptExecutor)driver;
			javascriptExecutor.executeScript("arguments[0].value=arguments[1];",element,value);
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING PASSING VALUE");
		}
	}
	protected static void javaScriptClick(WebElement element) {
		try {
			javascriptExecutor = (JavascriptExecutor)driver;
			javascriptExecutor.executeScript("arguments[0].click();",element);	
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING CLICK ON ELEMENT");
		}
	}
	protected static  void scrollDown(int pixels) {
		try {
			javascriptExecutor = (JavascriptExecutor)driver;
			javascriptExecutor.executeScript("window.scrollBy(0," + pixels + ")","");	
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING SCROLLING DOWN");
		}
	}
	protected static void scrollUp(int pixels) { 
		try {
			javascriptExecutor = (JavascriptExecutor)driver;
			javascriptExecutor.executeScript("window.scrollBy(0,-" + pixels + ")","");	
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING SCROLLING UP");
		}
	}
	protected static void horizontalRight(int pixels) {
		try {
			javascriptExecutor = (JavascriptExecutor)driver;
			javascriptExecutor.executeScript("window.scrollBy(arguments[0], 0)", pixels);	
		} catch (Exception e) {
			Assert.fail("ERROR : OCCURE DURING MOVING RIGHT");
		}
	}
}
