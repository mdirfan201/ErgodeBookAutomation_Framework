	package com.book.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aq.Base.TestBasae;

public class LoginPage extends TestBasae{
	
	//Initialization the PageObeject
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Page Factory
	@FindBy(xpath="//input[@name='email']")
	public WebElement txtEmailAddress;
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement txtPassword;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement loginBtn;
	
	@FindBy(xpath="//a[normalize-space()='Continue']")
	public WebElement clickRegisterAccount;
	
	@FindBy(xpath="//img[contains(@title,'ergodebooks.com')]")
	public WebElement LoginPageErgodeBookLogo;
	
	@FindBy(xpath="//span[normalize-space()='Home']")
	public WebElement clickHomeLogo;
	
	@FindBy(xpath="//div[@id='welcome']//a[text()=' Logout )']")
	public WebElement LogoutBtn;
	
	@FindBy(xpath="//div[@class='right']//a[text()='Continue']")
	public WebElement ContinueBtn;
	
	@FindBy(xpath="//a[@class='forgot_pass']")
	public WebElement clickOnForgotPassword;
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateLoginPageImage() {
		return LoginPageErgodeBookLogo.isDisplayed();
	}
	
	public void login(String Email, String pwd) {
		txtEmailAddress.sendKeys(Email);
		txtPassword.sendKeys(pwd);
		loginBtn.click();
	}
	
	public ForgotPasswordPage ClickOnForgotPassword() {
		clickOnForgotPassword.click();
		
		return new ForgotPasswordPage();
	}
	
	public void clickOnLogoutBtn() {
		LogoutBtn.click();
		ContinueBtn.click();
	}
}
