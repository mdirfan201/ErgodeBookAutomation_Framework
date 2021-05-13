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
import com.book.qa.page.LoginPage;
import com.qa.Custome_Listener.CustomeListner;


@Listeners(CustomeListner.class)
public class LoginPageTest extends TestBasae {
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;

	static HomePage homepage;
	static LoginPage loginpage;

	public LoginPageTest() {
		super();
	}

	@BeforeSuite
	public void ExtentReportsetUp() {

		extent= new ExtentReports();
		spark=new ExtentSparkReporter("C:\\Users\\MY-PC.DESKTOP-8EQSD1V\\git\\ErgodeBookAutomation_Framework\\ErgodeBookAutomation_Framework\\ExtentReports\\ErgodeBook_LoginPageReport.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("Automation Test");
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
	public void setup() {
		initialization();
		homepage = new HomePage();
		homepage.ClickonLoginPageLink();
		loginpage= new LoginPage();
	}

	@Test(priority=1)
	public void LoginPageTitleTest() {
		test=extent.createTest("TC_01 : Validate Login Page Title");
		String actualTitle=loginpage.validateLoginPageTitle();
		test.info("Actual login Page title is==> "+ driver.getTitle());
		String expectedTitle="Account Login";
		Assert.assertEquals(actualTitle, expectedTitle, "Title not matched");
		test.log(Status.PASS, "Test case Pass as,Actual and Expected Title are Equal");
		//test.info("LoginPage Title SS", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
	}

	@Test(priority=2)
	public void LoginPageLogoImgTest() {
		test=extent.createTest("TC_02 : Validate Login Page Logo Image");
		boolean flag=loginpage.validateLoginPageImage();
		Assert.assertTrue(flag);
		test.info("LoginPage Logo Image is Displayed Successfully");
		//test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
	}
	@Test(priority=3)
	public void loginwithEmptyIdAndPassTest() {
		test=extent.createTest("TC_03 :Login with Empty fields in LoginPage Test");
		loginpage.login("", "");
		test.info("The waring msg displyed is===> "+ driver.findElement(By.xpath("//div[@class='warning']")).getText());
		//test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
	}

	@Test(priority=4)
	public void loginwithValidIdTest() {
		test=extent.createTest("TC_04 :Login with Valid EmailAddress in LoginPage Test");
		loginpage.login(prop.getProperty("username"), prop.getProperty("invalidPass"));
		test.info("The waring msg displyed is===> "+ driver.findElement(By.xpath("//div[@class='warning']")).getText());
		//test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
	}

	@Test(priority=5)
	public void loginwithValidPassTest() {
		test=extent.createTest("TC_05 :Login with Valid Password in LoginPage Test");
		loginpage.login(prop.getProperty("invalidusername"), prop.getProperty("password"));
		test.info("The waring msg displyed is===> "+ driver.findElement(By.xpath("//div[@class='warning']")).getText());
		//test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
	}

	@Test(priority=6)
	public void loginwithValidIdAndPassTest() throws InterruptedException {
		test=extent.createTest("TC_06 :Login with Valid EmailAddress ans Valid Password in LoginPage Test");
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		test.info("TestCase Passesed successfully");
	
		homepage.clickHomePageLogo();
		loginpage.clickOnLogoutBtn();
		Thread.sleep(2000);
	
	}


	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test cases Failed ==>" + result.getName());
			test.log(Status.FAIL, "Test cases Error is==>" + result.getThrowable());
			String screenshotPath=LoginPageTest.getBase64ScreenShots();
			test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Test cases Skiped ==>" + result.getName());
			test.log(Status.SKIP, "Test cases Skiped ==>" + result.getThrowable());	
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test cases Pass==>" + result.getName());
			String screenshotPath=LoginPageTest.getBase64ScreenShots();
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
		}

		driver.quit();
	}

	public static String getBase64ScreenShots() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
}
