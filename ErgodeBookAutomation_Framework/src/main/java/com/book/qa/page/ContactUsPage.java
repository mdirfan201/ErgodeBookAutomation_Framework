package com.book.qa.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aq.Base.TestBasae;

public class ContactUsPage extends TestBasae{

	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}
	
	//All Actions:
	
	@FindBy(xpath="//img[contains(@title,'ergodebooks.com')]")
	public WebElement ContactUsErgodeBookLogo;
	@FindBy(xpath="//h1[text()='Contact Us']")
	WebElement ContactLable;
	@FindBy(xpath="//a[normalize-space()='( Mohammed Irfanullah']")
	WebElement ContactusUserNameId;
	
	//Input Fields
	@FindBy(xpath="//input[@name='name']")
	public WebElement txtUSerName;
	@FindBy(xpath="//input[@name='email']")
	public WebElement txtUserEmailAddress;
	@FindBy(xpath="//input[@name='telephone']")
	public WebElement txtTelephone;
	@FindBy(xpath="//input[@name='subject']")
	public WebElement txtSubject;
	@FindBy(xpath="//textarea[@name='enquiry']")
	public WebElement txtEnquiry;
	@FindBy(xpath="//input[@value='SUBMIT']")
	public WebElement ContactUsSubmitBtn;


	public String ValidateContactusTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyContactusLogoImg() {
		return ContactUsErgodeBookLogo.isDisplayed();
	}
	public String ValidateContactusLable() {
		//ExpectedLable="Contact Us";
		return driver.getTitle();
	}
	
	public boolean verifyContactusUserId() {
		return ContactusUserNameId.isDisplayed();
	}
	
	public void enterDeatilsOfContactUs(String Name, String EmailAddress,String Telephone,String Subject,String Enquiry) throws InterruptedException { //String Name, String EmailAddress,
		txtUSerName.clear();
		txtUSerName.sendKeys(Name);
		txtUserEmailAddress.clear();
		txtUserEmailAddress.sendKeys(EmailAddress);
		txtTelephone.sendKeys(Telephone);
		txtSubject.sendKeys(Subject);
		txtEnquiry.sendKeys(Enquiry);
		Thread.sleep(3000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("scrollBy(0,1000)");
		//ContactUsSubmitBtn.click();
		
		
	}

}

