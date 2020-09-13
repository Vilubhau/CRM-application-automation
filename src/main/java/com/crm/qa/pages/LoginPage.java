package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class LoginPage extends Base {
	
	// Page objects or Object repository
	
	@FindBy (xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	public WebElement logInButton;
	
	@FindBy (xpath="//a[@class='btn btn-sm btn-white btn-icon btn-icon-left btn-shadow btn-border btn-rect offset-sm-top-60 offset-top-30']")
	public WebElement signUpButton;
	
	@FindBy (xpath="//a[contains(text(),'Forgot your password?')]")
	public WebElement forgotPasswordLink;
	
	@FindBy (xpath="//*[@name='email']")
	public WebElement username;
	
	@FindBy (xpath="//*[@name='password']")
	public WebElement password;
	
	@FindBy (xpath="//div[@class='ui fluid large blue submit button']")
	public WebElement loginBtn;
	
	@FindBy (xpath="//p[contains(text(),'Invalid login')]")
	public WebElement invalidLoginMsg;
	
	// Initializing objects
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyForgotPassLink()
	{
		return forgotPasswordLink.isDisplayed();
	}
	
	public void click(WebElement buttonname)
	{
		buttonname.click();
	}
	
	public void enterCredentials(String uname, String pass)
	{
		username.sendKeys(uname);
		password.sendKeys(pass);
	}

}
