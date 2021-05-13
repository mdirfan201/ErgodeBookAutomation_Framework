package com.qa.ErgodeBook.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
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
import com.qa.util.JavaScriptUtil;
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
		test=extent.createTest("TC_01:ErgodeBook -: Validating ContactUs Page Title");
		System.out.println(driver.getTitle());
		test.info("The Actual Title of ContactUs Page is===>" + driver.getTitle());
		String actualTitle=contactuspage.ValidateContactusTitle();
		String ExpectedTitle="Contact Us";
		Assert.assertEquals(actualTitle, ExpectedTitle);
		test.info("The actual and expected title are same==>"+ driver.getTitle());
	}

	@Test(priority=2)
	public void verifyContactUSLogoImg() {
		test=extent.createTest("TC_02:ErgodeBook -: Validating ContactUs Page Logo Image");
		boolean flag=contactuspage.verifyContactusLogoImg();
		Assert.assertTrue(flag);	
	}

	@Test(priority=3)
	public void verifyContactUsPageLable() {
		test=extent.createTest("TC_03:ErgodeBook -: Validating ContactUs Page Lable");
		test.info("The Actual Lable is===>" + driver.findElement(By.xpath("//h1[normalize-space()='Contact Us']")).getText());
		String actualLable=contactuspage.ValidateContactusLable();
		String expectedLable="Contact Us";
		Assert.assertEquals(actualLable, expectedLable);
		test.info("The actual and expected Lable are same==>"+ driver.findElement(By.xpath("//h1[normalize-space()='Contact Us']")).getText());

	}
	
	

	@Test(priority=4)
	public void verifyContactUsPageUserName() {
		test=extent.createTest("TC_04:ErgodeBook -: Validating ContactUs Page UserName");
		WebElement element=driver.findElement(By.xpath(" //a[normalize-space()='( Mohammed Irfanullah']"));
		JavaScriptUtil.drawBorder(element, driver);
		boolean flag=contactuspage.verifyContactusUserId();
		Assert.assertTrue(flag);
		test.info("The ContactUs User-Name is==>" + driver.findElement(By.xpath(" //a[normalize-space()='( Mohammed Irfanullah']")).getText());
		
	}

	@Test(priority=5)
	public void ContustUsPageEmptyDataSubmitTest() {
		test=extent.createTest("TC_05: ErgodeBook -: ContustUs Page EmptyData Submit Test");
		driver.findElement(By.xpath("//input[@name='name']")).clear();
		driver.findElement(By.xpath("//input[@name='email']")).clear();
		driver.findElement(By.xpath("//textarea[@name='enquiry']")).sendKeys("need book",Keys.TAB);;
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,700)");
		
		contactuspage.ContactUsSubmitBtn.click();
		
		System.out.println("The warning of Name is===>"+driver.findElement(By.xpath("//span[normalize-space()='Name must be between 3 and 32 characters!']")).getText());
		test.info("The warning of Name is===>"+driver.findElement(By.xpath("//span[normalize-space()='Name must be between 3 and 32 characters!']")).getText());
		System.out.println("The warning of Name is===>"+ driver.findElement(By.xpath("//span[normalize-space()='E-Mail Address does not appear to be valid!']")).getText());
		test.info("The warning of Name is===>"+driver.findElement(By.xpath("//span[normalize-space()='E-Mail Address does not appear to be valid!']")).getText());
		System.out.println("The warning of Name is===>"+ driver.findElement(By.xpath("//span[normalize-space()='Telephone must be between 10 and 15 numbers!']")).getText());
		test.info("The warning of Name is===>"+driver.findElement(By.xpath("//span[normalize-space()='Telephone must be between 10 and 15 numbers!']")).getText());
		System.out.println("The warning of Name is===>"+ driver.findElement(By.xpath("//span[normalize-space()='Verification code does not match the image!']")).getText());
		test.info("The warning of Name is===>"+driver.findElement(By.xpath("//span[normalize-space()='Verification code does not match the image!']")).getText());
	
		
	}
	
	@Test(priority=6)
	public void ContustUsPageInvalidEmailIdTest() {
		test=extent.createTest("TC_06: ErgodeBook -: ContustUsPage Invalid EmailId Test");
		driver.findElement(By.xpath("//input[@name='email']")).clear();
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("irfan201.com");
		driver.findElement(By.xpath("//textarea[@name='enquiry']")).sendKeys("need book",Keys.TAB);;
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,700)");
		
		contactuspage.ContactUsSubmitBtn.click();
		System.out.println("The warning of Name is===>"+ driver.findElement(By.xpath("//span[normalize-space()='E-Mail Address does not appear to be valid!']")).getText());
		test.info("The warning of Name is===>"+driver.findElement(By.xpath("//span[normalize-space()='E-Mail Address does not appear to be valid!']")).getText());
		System.out.println("The warning of Name is===>"+ driver.findElement(By.xpath("//span[normalize-space()='Telephone must be between 10 and 15 numbers!']")).getText());
		test.info("The warning of Name is===>"+driver.findElement(By.xpath("//span[normalize-space()='Telephone must be between 10 and 15 numbers!']")).getText());
		System.out.println("The warning of Name is===>"+ driver.findElement(By.xpath("//span[normalize-space()='Verification code does not match the image!']")).getText());
		test.info("The warning of Name is===>"+driver.findElement(By.xpath("//span[normalize-space()='Verification code does not match the image!']")).getText());
	
		
	}
	
	@Test(priority=7)
	public void ContustUsPageInvalidTelephoneTest() {
		test=extent.createTest("TC_06: ErgodeBook -: ContustUsPage Invalid Telephone Test");
		driver.findElement(By.xpath("//input[@name='telephone']")).clear();
		driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("771894243www");
		driver.findElement(By.xpath("//textarea[@name='enquiry']")).sendKeys("need book",Keys.TAB);;
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("scrollBy(0,700)");
		
		contactuspage.ContactUsSubmitBtn.click();
		System.out.println("The warning of Name is===>"+ driver.findElement(By.xpath("//span[normalize-space()='E-Mail Address does not appear to be valid!']")).getText());
		test.info("The warning of Name is===>"+driver.findElement(By.xpath("//span[normalize-space()='E-Mail Address does not appear to be valid!']")).getText());
		System.out.println("The warning of Name is===>"+ driver.findElement(By.xpath("//span[normalize-space()='Telephone must be between 10 and 15 numbers!']")).getText());
		test.info("The warning of Name is===>"+driver.findElement(By.xpath("//span[normalize-space()='Telephone must be between 10 and 15 numbers!']")).getText());
		System.out.println("The warning of Name is===>"+ driver.findElement(By.xpath("//span[normalize-space()='Verification code does not match the image!']")).getText());
		test.info("The warning of Name is===>"+driver.findElement(By.xpath("//span[normalize-space()='Verification code does not match the image!']")).getText());
	
		
	}
	
	@Test(priority=8,dataProvider="getContactDetails")
	public void EnterDataOnContactUsPage(String Name,String EmailAddress,String Telephone,String Subject,String Enquiry) throws InterruptedException {
		test=extent.createTest("TC_08: ErgodeBook -: Entring Data in to ContactUS Page");
		contactuspage.enterDeatilsOfContactUs(Name, EmailAddress, Telephone, Subject, Enquiry);
		Thread.sleep(2000);
		test.info("The Name is==>"+contactuspage.txtUSerName.getAttribute("value"));
		test.info("The Name is==>"+contactuspage.txtUserEmailAddress.getAttribute("value"));
		Thread.sleep(2000);
		contactuspage.clickLogoutBtn();
	}
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test cases MethodName Failed ==>" + result.getName());
			test.log(Status.FAIL, "Test cases MethodName Error is==>" + result.getThrowable());
			test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Test cases MethodName Skiped ==>" + result.getName());
			test.log(Status.SKIP, "Test cases MethodName Skiped ==>" + result.getThrowable());	
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test cases MethodName==>" + result.getName());
			//String screenshotPath=LoginPageTest.getBase64ScreenShots();
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		}
		driver.quit();
	}

	public static String getBase64ScreenShot() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}

	@DataProvider
	public Object[][] getContactDetails() {
		//Object data[][]=TestUtil.getTestData(SheetName);
		  Object data[][]=TestUtil.getTestData(SheetName);
		return data;
	}

}

