package org.facebook.tests;

import org.facebook.generic.BaseTest;
import org.facebook.generic.ExcelData;
import org.facebook.pages.FaceBookPage;
import org.facebook.pages.LoginOrSignupPage;
import org.testng.annotations.Test;

public class LoignTest extends BaseTest 
{
	@Test
	public void testLogin() throws Exception
	{
		LoginOrSignupPage l = new LoginOrSignupPage(driver);
		FaceBookPage f = new FaceBookPage(driver);
		String un = ExcelData.getData(file_path, "credentials", 1, 0);
		String pw = ExcelData.getData(file_path, "credentials", 1, 1);
		l.enterEmail(un);
		l.enterPassword(pw);
		Thread.sleep(2000);
		l.clickOnLogin(); 
		f.clickOnTurnOff();
		Thread.sleep(4000);
		
		int imageCount=0;
		int imageRc = ExcelData.getRowCount(file_path, "images");
		for(int i=1;i<=imageRc+1;i++)
		{
			short cc = ExcelData.getCellCount(file_path, "images", i);
			for(int j=0;j<cc;j++)
			{
				String imagePath = ExcelData.getData(file_path, "images", i, j);
				f.uploadPhotoOrVideo(imagePath);		
				Thread.sleep(3000);
				imageCount++;
			}
		}
		
		
		
		if(imageCount>1)
		{
			int rc = ExcelData.getRowCount(file_path, "tags");
			for(int i=1;i<=rc+1;i++)
			{
				short cc = ExcelData.getCellCount(file_path, "tags", i);
				for(int j=0;j<cc;j++)
				{
					String name = ExcelData.getData(file_path, "tags", i, j);
					Thread.sleep(1000);
					f.enterFriendsToTag(name);
				}
			}
		}
		else
		{
			Thread.sleep(4000);
			f.clickOnTagFriends();
			
			int rc = ExcelData.getRowCount(file_path, "tags");
			for(int i=1;i<=rc+1;i++)
			{
				short cc = ExcelData.getCellCount(file_path, "tags", i);
				for(int j=0;j<cc;j++)
				{
					String name = ExcelData.getData(file_path, "tags", i, j);
					Thread.sleep(1000);
					f.enterFriendsToTag(name);
				}
			}
		}
//		Thread.sleep(2000);
//		f.saySomeThingAboutPic("hiii hello");
	}
}
