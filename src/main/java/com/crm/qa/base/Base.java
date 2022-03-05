package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Base {
	
	// This is a base class.

	public static Properties config;
	public static WebDriver driver;
	public static ExtentReports report;
	public static ExtentTest test;
	
	
	public Base() {
		config = new Properties();
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
					+ "//src//main//java//com//crm//qa//configuration//config.properties");
			config.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void extentReport()
	{
		ExtentHtmlReporter extent = new ExtentHtmlReporter("C:\\Users\\vilas\\Documents\\Vilas\\Study\\FreeCRMTestAutomation\\Reports\\TestResult.html");
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	
	public static void initialization() {
		
		String browsername = config.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//src//main//java//com//crm//qa//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(config.getProperty("url"));

		} else {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "//src//main//java//com//crm//qa//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.get(config.getProperty("url"));
		}
	}
}
