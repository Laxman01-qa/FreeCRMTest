package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TestUtil testUtil;
	CompaniesPage companiesPage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUP(){
	 initialization();
	 loginPage = new LoginPage();
	 homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	 homePage = new HomePage();
	 contactsPage = new ContactsPage();
	 dealsPage = new DealsPage();
	 testUtil = new TestUtil();
	 companiesPage = new CompaniesPage();
		
	}
	
	@Test(priority = 1)
	public void verifyHomePageTitleTest(){
		String homeTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homeTitle, "CRMPRO");
	}
	
	@Test(priority = 2)
	public void verifyUserLabelTest(){
		testUtil.switchToFrame();
		Boolean flag = homePage.verifyUserLabel();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame();
		contactsPage = homePage.verifyContactsLink();
	}
	
	@Test(priority = 4)
	public void verifyDealsLinkTest(){
		testUtil.switchToFrame();
		dealsPage = homePage.verifyDealsLink();
	}
	
	@Test(priority = 5)
	public void verifyCompaniesLinkTest(){
		testUtil.switchToFrame();
		companiesPage = homePage.verifyCompaniesLink();
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
