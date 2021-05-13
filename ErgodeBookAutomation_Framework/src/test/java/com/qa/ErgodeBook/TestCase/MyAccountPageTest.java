package com.qa.ErgodeBook.TestCase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aq.Base.TestBasae;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.book.qa.page.AccountPage;
import com.book.qa.page.HomePage;
import com.book.qa.page.LoginPage;

public class MyAccountPageTest extends TestBasae{
	static HomePage homepage;
	static LoginPage loginpage;
	static AccountPage accountpage;
	
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;
	public MyAccountPageTest() {
		super();
	}

	@BeforeSuite
	public void setupExtentReport() {

		extent= new ExtentReports();
		spark = new ExtentSparkReporter("C:\\Users\\MY-PC.DESKTOP-8EQSD1V\\git\\ErgodeBookAutomation_Framework\\ErgodeBookAutomation_Framework\\ExtentReports\\MyAccPageReports.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("MyAccountPage Automation");
		spark.config().setReportName("Mohammed Irfan Ansari");
		extent.attachReporter(spark);
		//Setting System/Environment
		extent.setSystemInfo("Author","Mohammed Irfan");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("System","Windows10");
		extent.setSystemInfo("Applicatoin","Eclipse");
		extent.setSystemInfo("Tools","Selenium With Java");

	}

	@AfterSuite()
	public void tearExtentReport() {
		extent.flush();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage= new HomePage();
		homepage.ClickonLoginPageLink();
		loginpage = new LoginPage();
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		accountpage= new  AccountPage();
	}
	@Test(priority=1)
	public void ValidateMyAccountTitleTest() {
		test= extent.createTest("TC_01:ErgodeBook -: Validating MyAccount Page Title Test");
		String extualTitle="My Account";
		String actualTitle=accountpage.validateTitle();
		Assert.assertEquals(actualTitle, extualTitle,"Title not matched");
		test.info("The Actual and Excepted Title are===>"+driver.getTitle());
	}
	
	@Test(priority=2)
	public void ClickMyAccountLinkTest() throws InterruptedException {
		test= extent.createTest("TC_02:ErgodeBook -: Click MyAccount Link Test");
		accountpage.clickEditAccount.click();
		test.info("The MyEdit Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		Thread.sleep(2000);
		accountpage.clickBackBtn.click();
		
		accountpage.clickChangePass.click();
		test.info("The ChangePassword Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		Thread.sleep(2000);
		accountpage.clickBackBtn.click();
		
		accountpage.clickModifyAddBook.click();
		test.info("The ModifyAddressBook Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		Thread.sleep(2000);
		accountpage.clickBackBtn.click();
		
		accountpage.clickModifyWishList.click();
		test.info("The ModifyWishList Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		Thread.sleep(2000);
		accountpage.clickContinueBtn.click();
		
		accountpage.clickOrderHistory.click();
		test.info("The OrderHistory Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		Thread.sleep(2000);
		accountpage.clickContinueBtn.click();
		
		accountpage.clickDownloadsBtn.click();
		test.info("The DownloadsBtn Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		Thread.sleep(2000);
		accountpage.clickContinueBtn.click();
		
		accountpage.clickRewardBtn.click();
		test.info("The RewardPinnts Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		Thread.sleep(2000);
		accountpage.clickContinueBtn.click();
		
		accountpage.clickReturnReq.click();
		test.info("The ReturnReq Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		Thread.sleep(2000);
		accountpage.clickContinueBtn.click();
		
		accountpage.clickYourTransactions.click();
		test.info("The YourTransactions Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		Thread.sleep(2000);
		accountpage.clickContinueBtn.click();
		
		accountpage.clickRecurringPayment.click();
		test.info("The YourTransactions Page", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		Thread.sleep(2000);
		accountpage.clickContinueBtn.click();
		
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
	
	
}
