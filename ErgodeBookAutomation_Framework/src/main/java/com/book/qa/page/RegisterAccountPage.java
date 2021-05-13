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
	
	//YOUR PERSONAL DETAILS:
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
	
	
	
	public String validateRegisterPageTitle() {
		return driver.getTitle();
	}
	public boolean  RegisterAccountLable() {
		return RegisterAccountlogo.isDisplayed();
	}
	public void registerWithInvalidData(String ftName,String ltName,String email,String dob,String pwd,String Confirmpwd) {
		txtfirstname.sendKeys(ftName);
		txtlastname.sendKeys(ltName);
		txtemailId.sendKeys(email);
		txtdob.sendKeys(dob);
		txtdob.sendKeys(Keys.ENTER);
		txtpassword.sendKeys(pwd);
		txtconfirmpass.sendKeys(Confirmpwd);
		
	}
	public void setAccountDetails(String ftName,String ltName,String email,String dob,String pwd,String Confirmpwd) {
		txtfirstname.sendKeys(ftName);
		txtlastname.sendKeys(ltName);
		txtemailId.sendKeys(email);
		txtdob.sendKeys(dob);
		txtdob.sendKeys(Keys.ENTER);
		txtpassword.sendKeys(pwd);
		txtconfirmpass.sendKeys(Confirmpwd);
	}
	public void clickCheckBox() {
		clickCheckBox.click();
	}
	public void CilckContinue() {
		continuebtn.click();
	}
	
}
