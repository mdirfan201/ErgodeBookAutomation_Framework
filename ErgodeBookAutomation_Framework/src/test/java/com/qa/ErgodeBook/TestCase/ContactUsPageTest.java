package com.qa.ErgodeBook.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aq.Base.TestBasae;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.book.qa.page.ContactUsPage;
import com.book.qa.page.HomePage;
import com.book.qa.page.LoginPage;
import com.qa.Custome_Listener.CustomeListner;
import com.qa.util.TestUtil;

@Listeners(CustomeListner.class)
public class ContactUsPageTest extends TestBasae{
	
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;
	static HomePage homepage;
	static LoginPage loginpage;
	static ContactUsPage contactuspage;
	String SheetName = "ContactUs";
	public ContactUsPageTest() {
		super();
	}
	
	@BeforeSuite
	public void ExtentReportsetUp() {
		extent= new ExtentReports();
		spark= new ExtentSparkReporter("C:\\Users\\MY-PC.DESKTOP-8EQSD1V\\git\\ErgodeBookAutomation_Framework\\ErgodeBookAutomation_Framework\\ExtentReports\\ErgodeBook_ContactUsReport.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("ContactUs Page Automation");
		spark.config().setReportName("Mohammed Irfanullah Ansari");
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
	public void setup() throws InterruptedException {
		initialization();
		homepage= new HomePage();
		homepage.ClickonLoginPageLink();
		loginpage =new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactuspage=new ContactUsPage();
		homepage.clickContactUsLink();
	}
	
	@Test(priority=1)
	public void validateContactusPageTitleTest() {
		test=extent.createTest("TC_01: Validating ContactUs Page Title");
		System.out.println(driver.getTitle());
		test.info("The Actual Title of ContactUs Page is===>" + driver.getTitle());
		String actualTitle=contactuspage.ValidateContactusTitle();
		String ExpectedTitle="Contact Us";
		Assert.assertEquals(actualTitle, ExpectedTitle);
		test.log(Status.PASS, "Test Case Pass Actual and Expected Title are same");
	}
	
	@Test(priority=2)
		public void verifyContactUSLogoImg() {
		test=extent.createTest("TC_02: Validating ContactUs Page Logo Image");
		boolean flag=contactuspage.verifyContactusLogoImg();
		Assert.assertTrue(flag);
		test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		
	}
	
	@Test(priority=3)
		public void verifyContactUsPageLable() {
		test=extent.createTest("TC_03: Validating ContactUs Page Lable");
		test.info("The Actual Lable is===>" + driver.findElement(By.xpath("//h1[normalize-space()='Contact Us']")).getText());
		String actualLable=contactuspage.ValidateContactusLable();
		String expectedLable="Contact Us";
		Assert.assertEquals(actualLable, expectedLable);
		test.log(Status.PASS, "Test Case Pass Actual and Expected Lable are same");
		
	}
	
	@Test(priority=4)
		public void verifyContactUsPageUserName() {
		test=extent.createTest("TC_04: Validating ContactUs Page UserName");
		test.info("The ContactUs User-Name is==>" + driver.findElement(By.xpath(" //a[normalize-space()='( Mohammed Irfanullah']")).getText());
		boolean flag=contactuspage.verifyContactusUserId();
		Assert.assertTrue(flag);
		test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		
		
	}
	
	@Test(priority=5,dataProvider="getContactDetails")
		public void EnterDataOnContactUsPage(String Name,String EmailAddress,String Telephone,String Subject,String Enquiry) throws InterruptedException {
		test=extent.createTest("TC_05: Entring Data in to ContactUS Page");
		Thread.sleep(2000);
		contactuspage.enterDeatilsOfContactUs(Name, EmailAddress, Telephone, Subject, Enquiry);
		test.info("Data Entered", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		Thread.sleep(2000);
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public static String getBase64ScreenShot() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	
	@DataProvider
	public Object[][] getContactDetails() {
		Object data[][]=TestUtil.getTestData(SheetName);
		return data;
	}
	
	}

