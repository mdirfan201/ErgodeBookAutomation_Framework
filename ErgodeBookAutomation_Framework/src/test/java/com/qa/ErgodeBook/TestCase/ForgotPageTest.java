package com.qa.ErgodeBook.TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import com.book.qa.page.ForgotPasswordPage;
import com.book.qa.page.HomePage;
import com.book.qa.page.LoginPage;
import com.qa.Custome_Listener.CustomeListner;
import com.qa.util.TestUtil;

@Listeners(CustomeListner.class)
public class ForgotPageTest extends TestBasae{
	
	static HomePage homepage;
	static LoginPage loginpage;
	static ForgotPasswordPage forgotpage;
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;
	String sheetName="Forgot";
	
	public ForgotPageTest() {
		super();
	}
	

	@BeforeSuite
	public void ExtentReportsetUp() {
		extent= new ExtentReports();
		spark= new ExtentSparkReporter("C:\\Users\\MY-PC.DESKTOP-8EQSD1V\\git\\ErgodeBookAutomation_Framework\\ErgodeBookAutomation_Framework\\ExtentReports\\ErgodeBook_ForgotPageReport.html");
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
		loginpage.ClickOnForgotPassword();	
		forgotpage = new ForgotPasswordPage();
	}
	
	@Test(priority=1)
	public void validateForgotPageTitleTest() {
		test=extent.createTest("TC_01: Validating Forgot Page Title");
		System.out.println(driver.getTitle());
		test.info("The Actual Title of ContactUs Page is===>" + driver.getTitle());
		String Actual_Title=forgotpage.validateForgotPageTitle();
		String Expected_Title="Reset Your Password";
		Assert.assertEquals(Actual_Title, Expected_Title);
		test.log(Status.PASS, "Test Case Pass Actual and Expected Title are same");
	}
	
	@Test(priority=2)
	public void validateForgotPageLable() {
		test=extent.createTest("TC_02: Validating Forgot Page Lable");
		test.info("The Actual Lable is===>" + driver.findElement(By.xpath("//h1[text()='Reset Your Password']")).getText());
		boolean flag=forgotpage.validateForgotPageLable();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void enterForgotPasswordEmailAdressEmptyTest() throws InterruptedException {
		test=extent.createTest("TC_03:Enter Forgot Password Email-Address Empty Test");
		forgotpage.enterEmailAddForForgot("");
		Thread.sleep(2000);
		Thread.sleep(2000);
	}
	
	@DataProvider
	public Object[][] getTestdata() {
		Object data[][]=TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=4, dataProvider="getTestdata")
	public void enterForgotPasswordEmailAdressTest(String Email) throws InterruptedException {
		test=extent.createTest("TC_04:Enter Forgot Password Email-Address Test");
		forgotpage.enterEmailAddForForgot(Email);
		test.info("The warning is===>"+ driver.findElement(By.xpath("//div[@class='warning']")).getText());
		Thread.sleep(2000);
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
	public String getBase64ScreenShot() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	
}

