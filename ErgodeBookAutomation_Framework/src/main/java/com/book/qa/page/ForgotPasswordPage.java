package com.book.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aq.Base.TestBasae;
import com.qa.util.JavaScriptUtil;

public class ForgotPasswordPage extends TestBasae{

	public ForgotPasswordPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[text()='Reset Your Password']")
	public WebElement ForgotPageLable;
	
	@FindBy(xpath="//input[@name='email']")
	public WebElement txtEmailAddress;
	
	@FindBy(xpath="//a[@class='button']")
	WebElement clickBackBtn;
	
	@FindBy(xpath="//input[@value='Continue']")
	public WebElement clickContinueBtn;
	
	
	public String validateForgotPageTitle() { 
		//Expected Title="Reset Your Password";
		return driver.getTitle();
	}
	public boolean validateForgotPageLable() {
		JavaScriptUtil.drawBorder(ForgotPageLable, driver);
		return ForgotPageLable.isDisplayed();
	}
	
	public void enterEmailAddForForgot(String email) throws InterruptedException {
		txtEmailAddress.sendKeys(email);
		clickContinueBtn.click();
	}
}
