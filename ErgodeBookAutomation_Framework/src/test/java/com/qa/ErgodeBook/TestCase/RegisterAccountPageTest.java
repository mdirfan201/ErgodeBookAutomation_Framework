package com.qa.ErgodeBook.TestCase;

import org.openqa.selenium.By;
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
import com.book.qa.page.HomePage;
import com.book.qa.page.RegisterAccountPage;
import com.qa.Custome_Listener.CustomeListner;
import com.qa.util.JavaScriptUtil;
import com.qa.util.TestUtil;

@Listeners(CustomeListner.class)
public class RegisterAccountPageTest extends TestBasae{
	static HomePage homepage;
	static RegisterAccountPage registeraccountpage;
	static RegisterAccountPageTest registeraccountpagetest;
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;
	String SheetName ="Registeration";
	String InvalidsheetName ="InvalidRegisterData";
	public RegisterAccountPageTest()  {
		super();
	}
	
	@BeforeSuite
	public void ExtentReportsetUp() {
		extent= new ExtentReports();
		spark= new ExtentSparkReporter("C:\\Users\\MY-PC.DESKTOP-8EQSD1V\\git\\ErgodeBookAutomation_Framework\\"+ 
									   "ErgodeBookAutomation_Framework\\ExtentReports\\ErgodeBook_RegisterAccountPageReport.html");
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
		registeraccountpagetest=new RegisterAccountPageTest();
		homepage = new HomePage();
		homepage.CreateAccountClick();
		registeraccountpage= new RegisterAccountPage();
				
		}
		
		@Test(priority=1)
		public void validateRegisterPageTitle() {
			test=extent.createTest("TC_01: Validating ContactUs Page Title");
			System.out.println(driver.getTitle());
			test.info("The Actual Title of ContactUs Page is===>" + driver.getTitle());
			String actualTitle=registeraccountpage.validateRegisterPageTitle();
			String ExpectedTitle="Register Account";
			Assert.assertEquals(actualTitle, ExpectedTitle);
			test.log(Status.PASS, "Test Case Pass Actual and Expected Title are same==>"+driver.getTitle());
			
		}
	
		@Test(priority=2)
		public void verifyRegisterLogoImg() {
		test=extent.createTest("TC_02: Validating ContactUs Page Logo Image");
		boolean flag=registeraccountpage.RegisterAccountLable();
		Assert.assertTrue(flag);
		
	}
		
		@Test(priority=3)
		public void ContinueRegisterWithEmptyFields() throws InterruptedException {
			test=extent.createTest("TC_03: Continue Register With Empty Fields Test");
			registeraccountpage.setAccountDetails("", "", "", "", "", "");
			Thread.sleep(2000);
			registeraccountpage.clickCheckBox();
			registeraccountpage.CilckContinue();
			WebElement element= driver.findElement(By.xpath("//h2[normalize-space()='Your Personal Details']"));
			JavaScriptUtil.scrolluptoanelementByJS(element, driver);
			test.info("The waring msg displyed in First Name:===> "+ driver.findElement(By.xpath("//span[normalize-space()='First Name must be between 3 and 32 characters!']")).getText());
			test.info("The waring msg displyed in Last Name:===> "+ driver.findElement(By.xpath("//span[normalize-space()='Last Name must be between 3 and 32 characters!']")).getText());
			test.info("The waring msg displyed in E-Mail:===> "+ driver.findElement(By.xpath("//span[normalize-space()='E-Mail Address does not appear to be valid!']")).getText());
			test.info("The waring msg displyed in Password:===> "+ driver.findElement(By.xpath("//span[normalize-space()='Password must be between 4 and 20 characters!']")).getText());
			test.info("The waring msg displyed in Enter the code in the box:===> "+ driver.findElement(By.xpath("//span[normalize-space()='Invalid Captcha']")).getText());
			
		}
		
		@Test(priority=4,dataProvider="getRegisterInvalidDetails")
		public void ContinueRegisterWithInValidFields(String FirstName,String LastName,String Email,String DOB,String Password,String ConfirmPass) throws InterruptedException {
			test=extent.createTest("TC_04: Continue Register With INValid Data in Fields Test");
			//contactuspage.enterDeatilsOfContactUs(Name, EmailAddress, Telephone, Subject, Enquiry);
			registeraccountpage.setAccountDetails(FirstName,LastName,Email,DOB,Password,ConfirmPass);
			Thread.sleep(2000);
			registeraccountpage.clickCheckBox();
			registeraccountpage.CilckContinue();
			WebElement element= driver.findElement(By.xpath("//h2[normalize-space()='Your Personal Details']"));
			JavaScriptUtil.scrolluptoanelementByJS(element, driver);
			test.info("The waring msg displyed in Enter the code in the box:===> "+ driver.findElement(By.xpath("//span[normalize-space()='Invalid Captcha']")).getText());
			
			
		}
		
		
		@Test(priority=5,dataProvider="getRegisterDetails")
		public void ContinueRegisterWithValidFields(String FirstName,String LastName,String Email,String DOB,String Password,String ConfirmPass) throws InterruptedException {
			test=extent.createTest("TC_05: Continue Register With Valid Data in Fields Test");
			registeraccountpage.setAccountDetails(FirstName,LastName,Email,DOB,Password,ConfirmPass);
			Thread.sleep(2000);
			registeraccountpage.clickCheckBox();
			registeraccountpage.CilckContinue();
			WebElement element= driver.findElement(By.xpath("//h2[normalize-space()='Your Personal Details']"));
			JavaScriptUtil.scrolluptoanelementByJS(element, driver);
			test.info("The waring msg displyed in Enter the code in the box:===> "+ driver.findElement(By.xpath("//span[normalize-space()='Invalid Captcha']")).getText());
			
			
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
		
		@DataProvider
		public Object[][] getRegisterDetails() {
			Object data[][]=TestUtil.getTestData(SheetName);
			return data;
		}
		
		@DataProvider
		public Object[][] getRegisterInvalidDetails() {
			Object data[][]=TestUtil.getTestInvalidData(InvalidsheetName);
			return data;
		}
		
		}

