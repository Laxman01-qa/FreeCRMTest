package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	String sheetName ="Contacts";
	
	public ContactsPageTest(){
		super();
	}

	@BeforeMethod
	public void setUP(){
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = new HomePage();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		
	}
	
	@Test(priority=1)
	public void verifyContactPageTitleTest(){
		testUtil.switchToFrame();
		Boolean flag = contactsPage.verifyContactsLabel();
		Assert.assertTrue(flag);
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws EncryptedDocumentException, IOException{
		Object inputData[][] = testUtil.getTestData(sheetName);
		return inputData;
	}

	@Test(priority=2, dataProvider="getCRMTestData")
	public void validateNewConataPageLinkTest(String title, String ftName, String ltName, String com){
		testUtil.switchToFrame();
		homePage.clickOnNewContactLink();
		contactsPage.newContactLink(title, ftName, ltName, com);
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
		
}

