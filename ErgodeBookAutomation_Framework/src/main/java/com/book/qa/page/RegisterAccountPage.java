package com.book.qa.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aq.Base.TestBasae;

public class RegisterAccountPage extends TestBasae {
	
	public RegisterAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//h1[normalize-space()='Register Account']")
	WebElement RegisterAccountlogo;
	
	@FindBy(xpath="//a[normalize-space()='create an account']")
	WebElement clickCreateAcount;
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement txtfirstname;
	@FindBy(xpath="//input[@name='lastname']")
	WebElement txtlastname;
	@FindBy(xpath="//input[@name='email']")
	WebElement txtemailId;
	@FindBy(xpath="//input[@id='datepicker']")
	WebElement txtdob;
	@FindBy(xpath="//input[@name='password']")
	WebElement txtpassword;
	@FindBy(xpath="//input[@name='confirm']")
	WebElement txtconfirmpass;
	
	@FindBy(xpath="//input[@name='agree']") //clicking cheack box
	WebElement clickCheckBox;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement continuebtn;
	
	public boolean  RegisterAccountLable() {
		return RegisterAccountlogo.isDisplayed();
	}
	public void clickToRgister() {
		clickCreateAcount.click();
	}
	public void setAccountDetails(String FirstName,String LastName,String Email,String Dob,String Password,String Confirmpass) {
		txtfirstname.sendKeys(FirstName);
		txtlastname.sendKeys(LastName);
		txtemailId.sendKeys(Email);
		txtdob.sendKeys(Dob);
		txtdob.sendKeys(Keys.ENTER);
		txtpassword.sendKeys(Password);
		txtconfirmpass.sendKeys(Confirmpass);
	}
	public void clickCheckBox() {
		clickCheckBox.click();
	}
	public void CilckContinue() {
		continuebtn.click();
	}
	
}
