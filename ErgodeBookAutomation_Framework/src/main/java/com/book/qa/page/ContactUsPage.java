package com.book.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aq.Base.TestBasae;
import com.qa.util.JavaScriptUtil;

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
	@FindBy(xpath="//a[normalize-space()='Logout )']")
	public static WebElement LogoutBtn;

	public String ValidateContactusTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyContactusLogoImg() {
		JavaScriptUtil.drawBorder(ContactUsErgodeBookLogo, driver);
		return ContactUsErgodeBookLogo.isDisplayed();
	}
	public String ValidateContactusLable() {
		WebElement element= driver.findElement(By.xpath("//h1[normalize-space()='Contact Us']"));
		JavaScriptUtil.drawBorder(element, driver);
		return driver.findElement(By.xpath("//h1[normalize-space()='Contact Us']")).getText();
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
		Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement Element=driver.findElement(By.xpath("//h1[normalize-space()='Contact Us']"));
		js.executeScript("arguments[0].scrollIntoView();", Element);
		//ContactUsSubmitBtn.click();	
	}
	
	public void clickLogoutBtn() {
		LogoutBtn.click();
	}

}

