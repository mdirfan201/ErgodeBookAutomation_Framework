package com.book.qa.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aq.Base.TestBasae;
import com.aventstack.extentreports.ExtentTest;
import com.qa.util.JavaScriptUtil;

public class HomePage extends TestBasae{
	static ExtentTest test;
	//div[@id='menu']
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@id='logo']/a/img[@title='ergodebooks.com']")
	WebElement ergodebookLogo;
	
	@FindBy(xpath="//div[@id='menu']/ul/li/a[@title='Home']")
	WebElement clickOnHomePageLogoBtn;
	
	//Currency
	@FindBy(xpath="//div[@id='currency']")
	WebElement clickCurrency;
	@FindBy(xpath="//*[@id='currency']/ul/li/a[@title='INR']")
	WebElement clickINR;
	@FindBy(xpath="//*[@id='currency']/ul/li/a[@title='USD']")
	WebElement clickUSD;
	//************************************************************
	//MyAccounts
	@FindBy(xpath="//*[@id=\"welcome\"]/div")
	WebElement ClickMyAccountHeader;
	//List of Header MyAccount
	@FindBy(xpath="//div[@class='links']/ul/li/a[text()='My Account']")
	WebElement clickMyAccountLink;
	@FindBy(xpath="//a[@id='wishlist-total']")
	WebElement clickWishListLink;
	@FindBy(xpath="//div[@class='links']/ul/li/a[text()='Shopping Cart']")
	WebElement clickShoppingCartLink;
	@FindBy(xpath="//div[@class='links']/ul/li/a[text()='Checkout']")
	WebElement clickCheckoutLink;
	//********************************************************************
	
	@FindBy(xpath="//div[@id='welcome']/a[text()='Contact Us']")
	WebElement clickHeaderContactUs;
	
	@FindBy(xpath="//div[@id='welcome']/a[text()='login']")
	WebElement clickLoginButton;
	
	@FindBy(xpath="//div[@id='welcome']/a[text()='create an account']")
	WebElement clickCreateAccountButton;
	
	@FindBy(xpath="//input[@id='filter_name']")
	WebElement txtSearchBook;
	
	@FindBy(xpath="//*[@id='menu']/ul/li")
	List<WebElement> mainMenuList;
	
	@FindBy(xpath="//div[@class='box-content box-category']/ul[@id='cat_accordion']/li")
	List<WebElement> categoryList;
	
	@FindBy(xpath="//h3[text()='Information']/../ul/li")
	List<WebElement> linksUnderInformation;
	
	@FindBy(xpath="//h3[text()='Customer Service']/../ul/li")
	List<WebElement> linksUnderCustomerServices;
	
	@FindBy(xpath="//h3[text()='Extras']/../ul/li")
	List<WebElement> listUnderExtras;

	@FindBy(xpath="//h3[text()='My Account']/../ul/li")
	List<WebElement> listUnderFooterMyAccounts;
	
	@FindBy(xpath="//div[@id='powered']")
	private WebElement address;
	
	@FindBy(xpath="//div[@id='powered']")
	WebElement telephoneAndEmail;
	@FindBy(xpath="//div[@id='footer']") 
	WebElement fullFooterImg;
	
	//--------------Niv0 Image-------------------
	@FindBy(xpath="//div[@id='menu']//a[text()='Action & Adventure']")
	public WebElement MenuActionAdv;
	@FindBy(xpath="//div[@id='menu']//a[text()='Arts, Films & Photography']")
	public WebElement MenuArtFilmPhoto ;
	@FindBy(xpath="//div[@id='menu']//a[text()='Business, Economics & Law']")
	public WebElement MenuBusinessEcoLaw ;
	@FindBy(xpath="//div[@id='menu']//a[@href='https://ergodebooks.com/childrens-books-comics-graphic-novels']")
	public WebElement MenuChildrenBook ;
	@FindBy(xpath="//div[@id='menu']//a[normalize-space()='Crafts, Hobbies & Home']")
	public WebElement MenuCraftHobbies ;
	@FindBy(xpath="//div[@id='menu']//a[normalize-space()='Education']")
	public WebElement MenuEducation ;
	@FindBy(xpath="//div[@id='menu']//a[normalize-space()='Self-Help']")
	public WebElement MenuSelfHelp ;
	@FindBy(xpath="//a[normalize-space()='Blog']")
	public WebElement MenuBlog ;
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean isLogoDisplayed() {
		JavaScriptUtil.drawBorder(ergodebookLogo, driver);
		return ergodebookLogo.isDisplayed();
	}
	
	public void clickHomePageLogo() {
		clickOnHomePageLogoBtn.click();
	}
	
	public void clickCurrencyLink() throws InterruptedException {
		Actions action=new Actions(driver);
		action.moveToElement(clickCurrency).build().perform();
		clickINR.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,300)");
		Thread.sleep(3000);
		action.moveToElement(clickCurrency).build().perform();
		clickUSD.click();
		js.executeScript("scrollBy(0,300)");
		Thread.sleep(3000);
	}
	
	public void ClickMyAccountHeader() throws InterruptedException {
		Actions action=new Actions(driver);
		action.moveToElement(ClickMyAccountHeader).build().perform();
		clickMyAccountLink.click();
		getFailedScreenShot("MyAccount");
		Thread.sleep(2000);
		
		action.moveToElement(ClickMyAccountHeader).build().perform();
		clickWishListLink.click();
		getFailedScreenShot("WishList");
		Thread.sleep(2000);
		
		action.moveToElement(ClickMyAccountHeader).build().perform();
		clickShoppingCartLink.click();
		getFailedScreenShot("Shopping Cart");
	
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		Thread.sleep(2000);
		
		action.moveToElement(ClickMyAccountHeader).build().perform();
		clickCheckoutLink.click();
		getFailedScreenShot("Checkout");
		driver.findElement(By.xpath("//a[normalize-space()='Continue']")).click();
		Thread.sleep(2000);
		
	}
	
	public ContactUsPage clickContactUsLink() throws InterruptedException {
		clickHeaderContactUs.click();
		Thread.sleep(3000);
		//clickOnHomePageLogoBtn.click();
		return new	ContactUsPage();
		
	}
	
	public LoginPage ClickonLoginPageLink() {
		clickLoginButton.click();
		return new LoginPage();
	}
	
	public RegisterAccountPage CreateAccountClick() {
		clickCreateAccountButton.click();
		return new RegisterAccountPage();
	}
	
	
	public void enterBookToSearch(String EnterBookName) throws InterruptedException {
		txtSearchBook.sendKeys(EnterBookName,Keys.ENTER);
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,500)");
		//getFailedScreenShot("AddToCart");
		driver.findElement(By.xpath("//div[@class='cart']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='right']/a[@class='button']")).click();
		getFailedScreenShot("CheckOut");
		
	}
	
	
	public boolean NivoImageClick() throws InterruptedException {
		driver.findElement(By.xpath("//a[@rel='0']")).click();
		driver.findElement(By.xpath("//a[@rel='0']")).isDisplayed();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@rel='1']")).click();
		driver.findElement(By.xpath("//a[@rel='1']")).isDisplayed();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@rel='2']")).click();
		driver.findElement(By.xpath("//a[@rel='2']")).isDisplayed();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@rel='3']")).click();
		driver.findElement(By.xpath("//a[@rel='3']")).isDisplayed();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@rel='4']")).click();
		driver.findElement(By.xpath("//a[@rel='4']")).isDisplayed();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@rel='5']")).click();
		driver.findElement(By.xpath("//a[@rel='5']")).isDisplayed();
		Thread.sleep(2000);
		return true;
		
		
		/*Thread.sleep(2000);
		Actions act= new Actions(driver);
		WebElement ele= driver.findElement(By.xpath("//a[@href='https://ergodebooks.com/Gifts/mothers-day?utm_source=Website&utm_medium=Banner&utm_campaign=Mothers_Day']"));
		
		//act.moveToElement(ele).build().perform();
		ele.click();
		Thread.sleep(2000);
		clickOnHomePageLogoBtn.click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@rel='1']")).click();
		Thread.sleep(2000);
		WebElement ele2= driver.findElement(By.xpath("//img[@src='https://ergodebooks.com/image/cache/data/Banner 2021/Crafts, Hobbies _ Home 3-980x280.jpg' and @alt='Craft ']"));
		//act.moveToElement(ele2).build().perform();
		ele2.click();
		Thread.sleep(2000);*/
		
		
	}
	
	public List<String> getMainMenuList() {
		
		List<String> list = new ArrayList<String>();
		for(WebElement ele:mainMenuList) {
			String catText=ele.getText();
			System.out.print(":"+ catText);		
		}
		
		return list;
	}
	
public List<String> getcategoryList() {
		
		List<String> list = new ArrayList<String>();
		for(WebElement ele:categoryList) {
			String catText=ele.getText();
			System.out.print(":"+ catText);		
		}
//		list.remove(0);
//		list.remove(list.size() - 1);
		
		return list;
	}
	//linksUnderInformation
	public List<String> linksUnderInformation() {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",linksUnderInformation);
		List<String> list = new ArrayList<String>();

		for (WebElement ele : linksUnderInformation) {

			list.add(ele.getText());
		}

		return list;
	}
	
	public List<String> listUnderCustomerServiceColumn() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",linksUnderCustomerServices	);
		List<String> list = new ArrayList<String>();
		
		for (WebElement ele : linksUnderCustomerServices) {

			list.add(ele.getText());
		}

		return list;
	}

	
	public List<String> listUnderExtras() {

		List<String> list = new ArrayList<String>();

		for (WebElement ele : listUnderExtras) {

			list.add(ele.getText());
		}

		return list;
	}

	
	public List<String> listunderMyAccount() {
		((JavascriptExecutor) driver).executeScript("srcollBy(0,1500)");
		List<String> list = new ArrayList<String>();

		for (WebElement ele : listUnderFooterMyAccounts) {

			list.add(ele.getText());
		}

		return list;
	}
	
	
	public String getCompanyAddress() {
		WebElement element= driver.findElement(By.xpath("//h2[text()='Ergodebooks.com - Best online store to shop!']"));
		JavaScriptUtil.scrolluptoanelementByJS(element, driver);
		WebElement ele= driver.findElement(By.xpath("//div[@id='powered']"));
		JavaScriptUtil.drawBorder(ele, driver);
		return address.getText();
	}

	public String getCompanyTelephone() {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", telephoneAndEmail);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return telephoneAndEmail.getText().split("Email:")[0].trim().split("Telephone:")[1].trim();

	}

	public String getCompanyEmail() {

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", telephoneAndEmail);
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return telephoneAndEmail.getText().split("Email:")[1].trim().split("Copyright")[0].trim();
	}
}
