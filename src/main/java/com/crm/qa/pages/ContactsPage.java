package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	//Page Object - OR
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(name="title")
	WebElement dropdown;
	
	@FindBy(id="first_name")
	WebElement firstName;
	
	@FindBy(id="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
  //Initializing page object
  public ContactsPage(){
	  PageFactory.initElements(driver, this);
  }
  
  public boolean verifyContactsLabel(){
	  return contactsLabel.isDisplayed();
  }
    
  public void newContactLink(String title, String ftName, String ltName, String com){
	  Select select = new Select(dropdown);
	  select.selectByVisibleText(title);
	  
	  firstName.sendKeys(ftName);
	  lastName.sendKeys(ltName);
	  company.sendKeys(com);
	  saveBtn.click();

}
}
