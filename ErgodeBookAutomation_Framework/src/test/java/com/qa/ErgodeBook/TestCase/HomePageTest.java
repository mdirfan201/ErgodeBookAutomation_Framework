package com.qa.ErgodeBook.TestCase;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aq.Base.TestBasae;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.book.qa.page.HomePage;
import com.qa.Custome_Listener.CustomeListner;

@Listeners(CustomeListner.class)
public class HomePageTest extends TestBasae{
	
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;
	static HomePage homepage;
	
	public HomePageTest() {
		super();
	}
	@BeforeSuite
	public void setupReports() {
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("C:\\Users\\MY-PC.DESKTOP-8EQSD1V\\git\\ErgodeBookAutomation_Framework\\ErgodeBookAutomation_Framework\\ExtentReports\\ErgodeBook_AutomationReport.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Tes");
		extent.attachReporter(spark);
		
		//Setting System/Environment
		extent.setSystemInfo("Author","Mohammed Irfan");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("System","Windows10");
		extent.setSystemInfo("Applicatoin","Eclipse");
		extent.setSystemInfo("Tools","Selenium With Java");
		
	}
	@AfterSuite
	public void tearExtentReport() {
		extent.flush();
	}
	
	@BeforeMethod
	public void setup() {
		test=extent.createTest("Oeping Chrome and entering into URL");
		initialization();
		homepage = new HomePage();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitle() {
		test=extent.createTest("HOMEPAGE:TC_01-VerifyHomePageTitle");
		System.out.println("The actual Title is====>" + driver.getTitle());
		test.info("Current Page title is====>"+driver.getTitle());
		String homeTitle=homepage.verifyHomePageTitle();
		String expected_Title="Buy Action & Adventure, Arts, Films & Photography, Business, Economics & Law, Children's Books, Comics & Graphic Novels, Crafts, Hobbies & Home - Ergodebooks.com";
		
		Assert.assertEquals(homeTitle, expected_Title,"HomePage Title not Matched");
		test.pass("Actual and Expected Title is Equal and Test is Pass");
	}
	
	@Test(priority=2)
	public void verifyingHomePageLogoTest(){
		test=extent.createTest("HOMEPAGE:TC_02-VerifyHomePageLogo");
		boolean flag=homepage.isLogoDisplayed();
		Assert.assertTrue(flag);
		test.pass("The Logo is Displayed is ErgoedBook Website");
	}
	
	@Test(priority=3)
	public void clickHomePageCurrencyTest() throws InterruptedException {
		test=extent.createTest("HOMEPAGE:TC_03-ClickHomePageCurrency");
		homepage.clickCurrencyLink();
		test.info("Opened CurrencyLink", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		Thread.sleep(2000);
	}
	
	@Test(priority=4)
	public void clickMyAccountLinkTest() throws InterruptedException {
		test=extent.createTest("HOMEPAGE:TC_04-ClickMyAccountLinkTest");
		homepage.ClickMyAccountHeader();
		
	}
	
	@Test(priority=5)
	public void clickOnContactUsPageTest() throws InterruptedException {
		test=extent.createTest("HOMEPAGE:TC_05-ClickOnContactUsPageTest");
		homepage.clickContactUsLink();
		test.info("Opened ContactUsPage", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
	}
	
	@Test(priority=6)
	public void clickOnLoginPageTest() {
		test=extent.createTest("HOMEPAGE:TC_06-ClickOnLoginPageTest");
		homepage.ClickonLoginPageLink();
		test.info("Opened LoginPage", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
	}
	

	@Test(priority=7)
	public void clickOnCreateAnAccountPageTest() {
		test=extent.createTest("HOMEPAGE:TC_07-ClickOnCreateAnAccountPageTest");
		homepage.CreateAccountClick();
		test.info("Opened Create An Account Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
	}
	
	@Test(priority=8)
	public void searchBookPageTest() throws InterruptedException {
		test=extent.createTest("HOMEPAGE:TC_08-Searching the Book in SearchBookPageTest");
		String BookToSearch="Weight Loss For People Who Feel Too Much: A 4-Step, 8-Week Plan To Finally Lose The Weight, Manage Emotional Eating, And Find Your Fabulous Self";
		
		homepage.enterBookToSearch(BookToSearch);
		test.info("CheckOut Page of searched Book");
		//test.fail("Failed To Payment Books", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
	}
	
	@Test(priority=9)
	public void verifyAddressOfCompany() {
		test=extent.createTest("HOMEPAGE:TC_09-Verify Company Address Page Test");
		String CompanyAdd=homepage.getCompanyAddress();
		System.out.println("The Address of Company is===> "+ CompanyAdd);
		String expectedAddress="Phone No: +1 281-738-1050 Email : support@ergodebooks.com Copyright @ 2021. ErgodeBooks.Com All Rights Reserved.";
		Assert.assertEquals(CompanyAdd, expectedAddress);
		
	}
	
	
	public String getBase64ScreenShots() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}


/*
@Test(priority=9)
public void verifyAllMainMenuAreDisplayed() {
	test=extent.createTest("HOMEPAGE:TC_09-Verify All MainMenu Are Displayed in Page Test");
	List<String> actualList =homepage.getMainMenuList();
	List<String> expectedMenuList = new ArrayList<String>(Arrays.asList("Home,Action &amp; Adventure,Arts, Films &amp; "+
	"Photography,Business, Economics &amp; Law,Children's Books, Comics &amp; Graphic Novels,Crafts, Hobbies &amp;"+
			" Home,Education,Self-Help,Blog"));
	Assert.assertEquals(actualList, expectedMenuList, "List does not match");
	//test.fail("TestCase Failed ", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
}

//ACTION & ADVENTURE ,ARTS, FILMS & PHOTOGRAPHY ,AUTO GEAR ,BIOGRAPHIES & MEMOIRS ,BUSINESS, ECONOMICS & LAW ,CALENDARS ,CDS & VINYL ,CHILDREN'S BOOKS, COMICS & GRAPHIC NOVELS ,CRAFTS, HOBBIES & HOME ,EDUCATION ,FICTION ,GAY & LESBIAN ,GIFTS ,HEALTH, FITNESS & DIETING ,HISTORY & LITERATURE ,HUMOR & ENTERTAINMENT ,MYSTERY, THRILLER & SUSPENSE ,POLITICS, SOCIETY & SOCIAL SCIENCES ,REFERENCE ,RELIGION & SPIRITUALITY ,ROMANCE, PARENTING & RELATIONSHIPS ,SELF-HELP ,TEEN & YOUNG ADULT

@Test(priority=10)
public void verifyAllCategoriesAreDisplayed() {
	test=extent.createTest("HOMEPAGE:TC_09-Verify All MainMenu Are Displayed in Page Test");
	List<String> actualcatList =homepage.getcategoryList();
	List<String> expectedcatList = new ArrayList<String>(Arrays.asList("ACTION & ADVENTURE ,ARTS, FILMS & PHOTOGRAPHY,"+""
			+ "AUTO GEAR ,BIOGRAPHIES & MEMOIRS ,BUSINESS, ECONOMICS & LAW ,CALENDARS ,CDS & VINYL ,CHILDREN'S BOOKS,"+ 
			" COMICS & GRAPHIC NOVELS ,CRAFTS, HOBBIES & HOME ,EDUCATION ,FICTION ,GAY & LESBIAN ,GIFTS ,HEALTH, "+ 
			"FITNESS & DIETING ,HISTORY & LITERATURE ,HUMOR & ENTERTAINMENT ,MYSTERY, THRILLER & SUSPENSE ,POLITICS, " 
			+"SOCIETY & SOCIAL SCIENCES ,REFERENCE ,RELIGION & SPIRITUALITY ,ROMANCE, PARENTING & RELATIONSHIPS ,SELF-HELP" 
			+" ,TEEN & YOUNG ADULT"));
	Assert.assertEquals(actualcatList, expectedcatList, "List does not match");
	//test.fail("TestCase Failed ", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
}



@Test(priority=10)
public void verifyOptionsDisplayedUnderInformation() {
	test=extent.createTest("HOMEPAGE:TC_10-Verify Options Displayed Under Information in Page Test");
	
	List<String> actualList=homepage.linksUnderInformation();
	System.out.println("Information Lsit===>"+ actualList);
	List<String> expectedInfoList= new ArrayList<String>(Arrays.asList("About Us,Delivery Information,Return & Refund Policy,Privacy Policy,Terms & Conditions"));
	Assert.assertEquals(actualList, expectedInfoList,"List does not match");

}

@Test(priority=11)
public void verifyOptionsDisplayedCustomerService() {
	test=extent.createTest("HOMEPAGE:TC_11-Verify Options Displayed Under CustomerServic in Page Test");
	List<String> actualList=homepage.listUnderCustomerServiceColumn();
	List<String> expectedCustomerServiceList= new ArrayList<String>(Arrays.asList("Contact Us,Return Product,Site Map, Customer Review"));
	Assert.assertEquals(actualList, expectedCustomerServiceList,"List does not match");

}
@Test(priority=12)
public void verifyOptionsDisplayedExtras() {
	test=extent.createTest("HOMEPAGE:TC_12-Verify Options Displayed Under asList in Page Test");
	List<String> actualList=homepage.listUnderExtras();
	List<String> expectedExtrasList= new ArrayList<String>(Arrays.asList("Publisher"));
	Assert.assertEquals(actualList, expectedExtrasList,"List does not match");

}
@Test(priority=13)
public void verifyOptionsDisplayedUnderMyAccount() {
	test=extent.createTest("HOMEPAGE:TC_13-Verify Options Displayed Under MyAccount in Page Test");
	List<String> actualList=homepage.listunderMyAccount();
	List<String> expectedMyAccount= new ArrayList<String>(Arrays.asList("My Account,Order History,Wish List,Newsletter"));
	Assert.assertEquals(actualList, expectedMyAccount,"List does not match");
	test.log(Status.PASS, "Test case pass");
}
*/