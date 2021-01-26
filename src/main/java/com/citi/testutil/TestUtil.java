package com.citi.testutil;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.citi.testBase.TestBase;

public class TestUtil extends TestBase {
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\DELL\\eclipse-workspace\\FreeCrmTest\\src\\main\\java\\com\\crm\\testdata\\CreateNewUserFreeCrM.xlsx";

	static JavascriptExecutor js;
	static JavascriptExecutor je = (JavascriptExecutor) driver;

	public void switchToFrame(String framename) {
		driver.switchTo().frame(framename);

	}

	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		System.out.println("MY SCREENSHOT AT ::::::::::" + currentDir);
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}

	public static void ElementWait(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
	}

	public static void WebElementWait(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	}


