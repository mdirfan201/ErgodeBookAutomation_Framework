	package com.book.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aq.Base.TestBasae;
import com.qa.util.JavaScriptUtil;

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
	//-=-----------------Link After LoginPage()--
	@FindBy(xpath="//h1[normalize-space()='My Account']")
	public WebElement MyAcountLable;
	@FindBy(xpath="//a[normalize-space()='Edit your account information']")
	public WebElement clickEditAccount;
	@FindBy(xpath="//a[normalize-space()='Change your password']")
	public WebElement clickChangePass;
	@FindBy(xpath="//a[normalize-space()='Modify your address book entries']")
	public WebElement clickModifyAddBook;
	@FindBy(xpath="//a[normalize-space()='Modify your wish list']")
	public WebElement clickModifyWishList;
	@FindBy(xpath="//a[normalize-space()='Continue']")
	public WebElement clickContinueBtn;
	@FindBy(xpath="//a[normalize-space()='View your order history']")
	public WebElement clickOrderHistory; //----> then click Continue
	@FindBy(xpath="//div[@class='content']//a[normalize-space()='Downloads']")
	public WebElement clickDownloadsBtn; //----> then click Continue
	@FindBy(xpath="//a[normalize-space()='Your Reward Points']")
	public WebElement clickRewardBtn; //----> then click Continue
	@FindBy(xpath="//a[normalize-space()='View your return requests']")
	public WebElement clickReturnReq; //----> then click Continue
	@FindBy(xpath="//a[normalize-space()='Your Transactions']")
	public WebElement clickYourTransactions; //----> then click Continue
	@FindBy(xpath="//a[normalize-space()='Recurring payments']	")
	public WebElement clickRecurringPayment;//----> then click Continue
	@FindBy(xpath="//a[normalize-space()='Back']")
	public WebElement clickBackBtn;
	//------------------------------------------------------------------
	
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
	public MyAccountInfoPage validateEditYourAccount(String Email, String pwd) {
		txtEmailAddress.sendKeys(Email);
		txtPassword.sendKeys(pwd);
		loginBtn.click();
		clickEditAccount.click();
		WebElement element= driver.findElement(By.xpath("//h2[normalize-space()='Your Personal Details']"));
		JavaScriptUtil.drawBorder(element, driver);
		return new MyAccountInfoPage();
	}
}
