package com.citi.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.citi.listener.WebEventListener;
import com.citi.testutil.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
/*
 * This is a Parent class of page and test classes--> 
 * Define common browser properties here
 */
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\citi\\testConfig\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("my 1st error :" + e);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("my 2st error :" + e);
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		System.out.println("BrowserName:" + browserName);
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			
			driver = new ChromeDriver();
			System.out.println("instanxce created: "+ driver.getCurrentUrl());
		} else if (browserName.equals("FireFox")) {
			
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		String url = prop.getProperty("url");
		System.out.println(url);
		driver.get(url);
		driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Save my preferences')]")).click();

	}
}
