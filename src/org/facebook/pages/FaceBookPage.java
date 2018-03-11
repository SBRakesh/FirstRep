package org.facebook.pages;

import org.facebook.generic.BasePage;
import org.facebook.generic.GenericUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class FaceBookPage extends BasePage
{
	@FindBy(xpath="//span[contains(text(),'Turn on')]/../../../../..//a[.='Not Now']")
	private WebElement notificationPopUp;
	
	@FindBy(name="composer_photo[]")
	private WebElement photoOrVideo;
	
	@FindBy(xpath="(//div[text()='Tag Friends'])[1]")
	private WebElement tagFriends;
	
	@FindBy(xpath="//input[@aria-label='Who were you with?']")
	private WebElement tagText;
	
	@FindBy(xpath="//div[contains(@class,'1mf _1mj')]")
	private WebElement aboutPic;
	
	public FaceBookPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTurnOff()
	{
		if(notificationPopUp.isDisplayed())
		{
			Reporter.log("notification popup has displayed and clicked on Not Now",true);
			notificationPopUp.click();
		}
		else
		{
			Reporter.log("notification pop up is not displayed..",true);
		}
	}
	
	public void uploadPhotoOrVideo(String picPath)
	{
		GenericUtils.clickOnElement(driver, photoOrVideo);
		GenericUtils.selectImage(picPath);
	}
	
	public void clickOnTagFriends()
	{
		try 
		{
			Thread.sleep(2000);
			GenericUtils.clickOnElement(driver, tagFriends);
		} catch (InterruptedException e) {
		}
	}
	
	public void enterFriendsToTag(String name)
	{
		
		try 
		{
			tagText.sendKeys(name);
			Thread.sleep(2000);
			GenericUtils.clickOnEnter(driver);
		}
		catch (InterruptedException e) 
		{
		}
	}
	
	public void saySomeThingAboutPic(String picDetails)
	{
		try 
		{
			Thread.sleep(2000);
			aboutPic.click();
			aboutPic.sendKeys(picDetails);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
