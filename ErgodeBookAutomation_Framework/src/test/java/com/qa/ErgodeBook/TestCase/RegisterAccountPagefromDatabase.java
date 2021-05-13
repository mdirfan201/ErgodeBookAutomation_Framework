package com.qa.ErgodeBook.TestCase;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
import com.book.qa.page.HomePage;
import com.book.qa.page.RegisterAccountPage;
	
import com.qa.Custome_Listener.CustomeListner;
import com.qa.util.TestUtil;

@Listeners(CustomeListner.class)
public class RegisterAccountPagefromDatabase extends TestBasae{
	static HomePage homepage;
	static RegisterAccountPage registeraccountpage;
	static RegisterAccountPagefromDatabase registeraccountpagetest;
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;
	String SheetName ="Registeration";
	public RegisterAccountPagefromDatabase()  {
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
		registeraccountpagetest=new RegisterAccountPagefromDatabase();
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
			test.log(Status.PASS, "Test Case Pass Actual and Expected Title are same");
			
		}
	
		@Test(priority=2)
		public void verifyContactUSLogoImg() {
		test=extent.createTest("TC_02: Validating ContactUs Page Logo Image");
		boolean flag=registeraccountpage.RegisterAccountLable();
		Assert.assertTrue(flag);
		test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
		
	}
		
		@Test(priority=3)
		public void ContinueRegisterWithEmptyFields() throws InterruptedException {
			test=extent.createTest("TC_03: Continue Register With Empty Fields Test");
			registeraccountpage.setAccountDetails("", "", "", "", "", "");
			Thread.sleep(2000);
			registeraccountpage.clickCheckBox();
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
			registeraccountpage.CilckContinue();
			test.info("The waring msg displyed in First Name:===> "+ driver.findElement(By.xpath("//span[normalize-space()='First Name must be between 3 and 32 characters!']")).getText());
			test.info("The waring msg displyed in Last Name:===> "+ driver.findElement(By.xpath("//span[normalize-space()='Last Name must be between 3 and 32 characters!']")).getText());
			test.info("The waring msg displyed in E-Mail:===> "+ driver.findElement(By.xpath("//span[normalize-space()='E-Mail Address does not appear to be valid!']")).getText());
			test.info("The waring msg displyed in Password:===> "+ driver.findElement(By.xpath("//span[normalize-space()='Password must be between 4 and 20 characters!']")).getText());
			test.info("The waring msg displyed in Enter the code in the box:===> "+ driver.findElement(By.xpath("//span[normalize-space()='Invalid Captcha']")).getText());
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
			
		}
		
		@Test(priority=3,dataProvider="getRegisterDetails")
		public void ContinueRegisterWithValidFields(String FirstName,String LastName,String Email,String DOB,String Password,String ConfirmPass) throws InterruptedException, SQLException {
			test=extent.createTest("TC_04: Continue Register With Valid Data in Fields Test");
			//contactuspage.enterDeatilsOfContactUs(Name, EmailAddress, Telephone, Subject, Enquiry);
			registeraccountpage.setAccountDetails(FirstName,LastName,Email,DOB,Password,ConfirmPass);
			Thread.sleep(2000);
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
			registeraccountpage.clickCheckBox();
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShot()).build());
			registeraccountpage.CilckContinue();
			test.info("The waring msg displyed in Enter the code in the box:===> "+ driver.findElement(By.xpath("//span[normalize-space()='Invalid Captcha']")).getText());
	//********************************************************************************************************************//	
			//Database validation
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
			java.sql.Statement stmt= con.createStatement();
			String query="Select firstname 	,lastname,email,telephone from oc_customer";
			ResultSet rs=stmt.executeQuery(query);
			boolean status=false;
			while(rs.next()) {
				String firstname= rs.getString("firstname");
				String lastname= rs.getString("lastname");
				String email= rs.getString("email");
				String telephone= rs.getString("telephone");
			
				if(FirstName.equals(firstname) && LastName.equals(lastname)  && Email.equals(email) ) {
					System.out.println("Record found in the table || TestCase passed");
					status=true;
					break;
				}
			}
			if(status==false) {
				System.out.println("Record not found || Test failed");
			}
			
	//********************************************************************************************************************//
			
		}
		
		
		@AfterMethod
		public void tearDown() {
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
		
		}

