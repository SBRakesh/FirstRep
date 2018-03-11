package org.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOrSignupPage 
{
	@FindBy(id="email")
	private WebElement emailTB;
	
	@FindBy(id="pass")
	private WebElement passwordTB;
	
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement loginBTN;
	
	public LoginOrSignupPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email)
	{
		emailTB.sendKeys(email);
	}
	
	public void enterPassword(String pwd)
	{
		passwordTB.sendKeys(pwd);
	}
	
	public void clickOnLogin()
	{
		loginBTN.click();
	}
}
