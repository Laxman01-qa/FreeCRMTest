package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page object - OR
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//td[contains(text(),'User: Demo User')]")  
	WebElement userLabel;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Companies')]")
	WebElement companiesLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	//Initializing the page object
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyUserLabel(){
		return userLabel.isDisplayed();
	}
	
	public ContactsPage verifyContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage verifyDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public CompaniesPage verifyCompaniesLink(){
		companiesLink.click();
		return new CompaniesPage();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}
	
	

}
