package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.LoginPage;

public class LoginTest extends Base{
	
	LoginPage loginPage;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
	}
	
	@BeforeSuite
	public void getExtentReport()
	{
		extentReport();
	}
	
	@AfterSuite
	public void flush()
	{
		report.flush();
	}

	@Test(priority = 1)
	public void verifyClickOnLoginButton()
	{
		test = report.createTest("Verify Login Button");
		loginPage.click(loginPage.logInButton);
		test.info("Clicking on Log-In button");
		boolean expected = true;
		boolean actual = loginPage.verifyForgotPassLink();
		Assert.assertEquals(actual, expected);	
		test.pass("Clicked successfully");
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.quit();
	}
	
	@Test(priority = 0)
	public void verifyClickOnSignUpButton()
	{
		test = report.createTest("Verify Sign-Up button");
		loginPage.click(loginPage.signUpButton);
		test.info("Clicking on Sign-Up button");
		String currentURL = driver.getCurrentUrl();
		if(currentURL.contains("register"))
		{
			Assert.assertEquals(true, true);
		} else {
			Assert.assertEquals(true, false);
		}
		test.pass("Clicked successfully");
	}
	
	@Test(priority = 2)
	public void invalidLogin()
	{
		test = report.createTest("Check login with invalid credentials");
		loginPage.click(loginPage.logInButton);
		test.info("Click on Log-In button");
		loginPage.enterCredentials(config.getProperty("username"), config.getProperty("password"));
		test.info("Enter invalid credentials");
		loginPage.click(loginPage.loginBtn);
		test.info("Hit enter");
		if(loginPage.invalidLoginMsg.isDisplayed())
		{
			Assert.assertEquals(true, true);
		} else {
			Assert.assertEquals(true, false);
		}
		test.pass("Login failed");
	}
}
