package com.book.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aq.Base.TestBasae;

public class AccountPage extends TestBasae {
	
	public AccountPage() {
		PageFactory.initElements(driver, this);
	}
	
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
	
	
	//------My Account Information	
	@FindBy(xpath="//h1[normalize-space()='My Account Information']")
	public WebElement MyAccInfoLable;
	
	
	public String validateTitle() {
		return driver.getTitle();
	}
	
	
	
}
