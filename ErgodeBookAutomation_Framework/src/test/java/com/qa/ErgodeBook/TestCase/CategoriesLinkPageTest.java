package com.qa.ErgodeBook.TestCase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import com.book.qa.page.CategoriesLinkPage;
import com.book.qa.page.HomePage;

public class CategoriesLinkPageTest extends TestBasae{
	
	
	static ExtentReports extent;
	static ExtentSparkReporter spark;
	static ExtentTest test;
	static HomePage homepage;
	static CategoriesLinkPage categoriespageLink;
	static CategoriesLinkPageTest categoriespageTest;
	
	public CategoriesLinkPageTest() {
		super();
	}
	
	@BeforeSuite
	public void setupReports() {
		
		extent = new ExtentReports();
		spark = new ExtentSparkReporter("C:\\Users\\MY-PC.DESKTOP-8EQSD1V\\git\\ErgodeBookAutomation_Framework\\"+
					"ErgodeBookAutomation_Framework\\ExtentReports\\ErgodeBook_CategoriesLinkPageReport.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Mohammed Irfanullah Ansari");
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
		categoriespageLink= new CategoriesLinkPage();
		categoriespageTest=new CategoriesLinkPageTest();
	}
	
	@Test
	public void ValidateCategoriesLink() throws InterruptedException {
		test= extent.createTest("Validate Categories Link");
		
		categoriespageLink.ClickActionAdventureLink();
		test.pass("1..Action Adventure Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickArtsFilmPhotoLink();
		test.pass("2..Arts,Film & Photo Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickAutoGearLink();
		test.pass("3..AutoGear Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickBiographAndMemorisLink();
		test.pass("4..Biograph And Memoris Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickBusinessEcoLawLinks();
		test.pass("5..Business Eco And Law Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickCalendarsLinks();
		test.pass("6..Calendars Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickCdVinlyLinks();
		test.pass("7..Cd & Vinly Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickChildrenBookLink();
		test.pass("8..Children Book Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickCraftHobbiesLink();
		test.pass("9..Craft Hobbies Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickEducationLink();
		test.pass("10..Educatio Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickFictionLink();
		test.pass("11..Fiction Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickGayLasbianLink();
		test.pass("12..Gay Lasbian Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickGiftsLink();
		test.pass("13..Gifts Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickHealthFitnessLink();
		test.pass("14..Health Fitness Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickHistoryLiterstureLink();
		test.pass("15..History Litersture Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickHumorEntertainmentLink();
		test.pass("16..Humor Entertainment Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickMystryThrillerLink();
		test.pass("17..Mystry Thriller Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickPoliticsSocietyLink();
		test.pass("18..Politics Society Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickReferenceLink();
		test.pass("19..Reference Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickReligionSpritualLink();
		test.pass("20..Religion Spritual Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickRomanceRelationsLink();
		test.pass("21..Romance Relations Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickSelfHelpLink();
		test.pass("22..Self Help Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		
		categoriespageLink.ClickTeenYoungAdultLink();
		test.pass("23..Teen Young Adult Link Title is==>"+driver.getTitle(), MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64ScreenShots()).build());
		test.log(Status.PASS, "All links are Pass");
	
	
	
	}
	
	
	
	public static String getBase64ScreenShots() {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test cases Failed is==>"+result.getName());
			test.log(Status.FAIL, "Test cases Error is==>"+result.getThrowable());
			String screenshotPath=CategoriesLinkPageTest.getBase64ScreenShots();
			test.log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Test cases Skiped is==>"+result.getName());
			test.log(Status.SKIP, "Test cases Skiped is==>"+result.getThrowable());	
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test cases Failed is==>"+result.getName());
			String screenshotPath=CategoriesLinkPageTest.getBase64ScreenShots();
			test.log(Status.PASS, MediaEntityBuilder.createScreenCaptureFromBase64String(screenshotPath).build());
		}
		
		driver.quit();
	}
}
