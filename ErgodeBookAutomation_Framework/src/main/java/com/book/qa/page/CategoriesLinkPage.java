package com.book.qa.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aq.Base.TestBasae;
import com.qa.util.JavaScriptUtil;

public class CategoriesLinkPage extends TestBasae{
	
	public CategoriesLinkPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//li[@class='custom_id1']//a[text()='Action & Adventure']")
	public WebElement ActionAdventureLink;
	
	@FindBy(xpath="//li[@class='custom_id2']//a[text()='Arts, Films & Photography']")
	public WebElement ArtsFilmPhotoLink;
	
	@FindBy(xpath="//li[@class='custom_id83']//a[text()='Auto Gear']")
	public WebElement AutoGearLink;
	
	@FindBy(xpath="//li[@class='custom_id43']//a[text()='Biographies & Memoirs']")
	public WebElement BiographAndMemorisLink;
	
	@FindBy(xpath="//li[@class='custom_id3']//a[text()='Business, Economics & Law']")
	public WebElement BusinessEcoLawLinks;
	
	@FindBy(xpath="//li[@class='custom_id14']//a[text()='Calendars']")
	public WebElement CalendarsLinks;
	
	@FindBy(xpath="//a[normalize-space()='CDs & Vinyl']")
	public WebElement CdVinlyLinks;
	
	@FindBy(xpath="//li[@class='custom_id4']//a")
	public WebElement ChildrenBookLink;
	
	@FindBy(xpath="//li[@class='custom_id6']//a[text()='Crafts, Hobbies & Home']")
	public WebElement CraftHobbiesLink;
	
	@FindBy(xpath="//li[@class='custom_id5']//a[text()='Education']")
	public WebElement EducationLink;
	
	@FindBy(xpath="//li[@class='custom_id7']//a[text()='Fiction']")
	public WebElement FictionLink;
	
	@FindBy(xpath="//a[normalize-space()='Gay & Lesbian']")
	public WebElement GayLasbianLink;
	
	@FindBy(xpath="//li[@class='custom_id33 cutom-parent-li']//a[text()='Gifts']")
	public WebElement GiftsLink;
	
	@FindBy(xpath="//li[@class='custom_id8']//a[text()='Health, Fitness & Dieting']")
	public WebElement HealthFitnessLink;
	
	@FindBy(xpath="//li[@class='custom_id9']//a[text()='History & Literature ']")
	public WebElement HistoryLiterstureLink;
	
	@FindBy(xpath="//li[@class='custom_id45']//a[text()='Humor & Entertainment']")
	public WebElement HumorEntertainmentLink;
	
	@FindBy(xpath="//a[normalize-space()='Mystery, Thriller & Suspense']")
	public WebElement MystryThrillerLink;
	
	@FindBy(xpath="//li[@class='custom_id11']//a[text()='Politics, Society & Social Sciences']")
	public WebElement PoliticsSocietyLink;
	
	@FindBy(xpath="//li[@class='custom_id47']//a[text()='Reference']")
	public WebElement ReferenceLink;
	
	@FindBy(xpath="//li[@class='custom_id12']//a[text()='Religion & Spirituality']")
	public WebElement ReligionSpritualLink;
	
	@FindBy(xpath="//li[@class='custom_id10']//a[text()='Romance, Parenting & Relationships']")
	public WebElement RomanceRelationsLink;
	
	@FindBy(xpath="//li[@class='custom_id32']//a[text()='Self-Help']")
	public WebElement SelfHelpLink;
	
	@FindBy(xpath="//a[normalize-space()='Teen & Young Adult']")
	public WebElement TeenYoungAdultLink;
	
	//1
	public void ClickActionAdventureLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(ActionAdventureLink, driver);
		ActionAdventureLink.click();
		Thread.sleep(2000);
	}
	//2
	public void ClickArtsFilmPhotoLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(ActionAdventureLink, driver);
		ArtsFilmPhotoLink.click();
		Thread.sleep(2000);
	}
	//3
	public void ClickAutoGearLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(AutoGearLink, driver);
		AutoGearLink.click();
		Thread.sleep(2000);
	}
	//4
	public void ClickBiographAndMemorisLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(BiographAndMemorisLink, driver);
		BiographAndMemorisLink.click();
		Thread.sleep(2000);
	}
	
	//5
	public void ClickBusinessEcoLawLinks() throws InterruptedException {
		JavaScriptUtil.drawBorder(BusinessEcoLawLinks, driver);
		BusinessEcoLawLinks.click();
		Thread.sleep(2000);
	}
	
	//6
	public void ClickCalendarsLinks() throws InterruptedException {
		JavaScriptUtil.drawBorder(CalendarsLinks, driver);
		CalendarsLinks.click();
		Thread.sleep(2000);
	}
	
	//7
	public void ClickCdVinlyLinks() throws InterruptedException {
		JavaScriptUtil.drawBorder(CdVinlyLinks, driver);
		CdVinlyLinks.click();
		Thread.sleep(2000);
	}
	
	//8
	public void ClickChildrenBookLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(ChildrenBookLink, driver);
		ChildrenBookLink.click();
		Thread.sleep(2000);
	}
	
	//9
	public void ClickCraftHobbiesLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(CraftHobbiesLink, driver);
		CraftHobbiesLink.click();
		Thread.sleep(2000);
	}
	
	//10
	public void ClickEducationLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(EducationLink, driver);
		EducationLink.click();
		Thread.sleep(2000);
	}
	//11
	public void ClickFictionLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(FictionLink, driver);
		FictionLink.click();
		Thread.sleep(2000);
	}
	
	//12
	public void ClickGayLasbianLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(GayLasbianLink, driver);
		GayLasbianLink.click();
		Thread.sleep(2000);
	}
	
	//13
	public void ClickGiftsLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(GiftsLink, driver);
		GiftsLink.click();
		Thread.sleep(2000);
	}
	
	//14
	public void ClickHealthFitnessLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(HealthFitnessLink, driver);
		HealthFitnessLink.click();
		Thread.sleep(2000);
	}
	
	//15
	public void ClickHistoryLiterstureLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(HistoryLiterstureLink, driver);
		HistoryLiterstureLink.click();
		Thread.sleep(2000);
	}
	
	//16
	public void ClickHumorEntertainmentLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(HumorEntertainmentLink, driver);
		HumorEntertainmentLink.click();
		Thread.sleep(2000);
	}
	
	//17
	public void ClickMystryThrillerLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(MystryThrillerLink, driver);
		MystryThrillerLink.click();
		Thread.sleep(2000);
	}
	
	//18
	public void ClickPoliticsSocietyLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(PoliticsSocietyLink, driver);
		PoliticsSocietyLink.click();
		Thread.sleep(2000);
	}
	
	//19
	public void ClickReferenceLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(ReferenceLink, driver);
		ReferenceLink.click();
		Thread.sleep(2000);
	}
	
	//20
	public void ClickReligionSpritualLink() throws InterruptedException {
		JavaScriptUtil.drawBorder(ReligionSpritualLink, driver);
		ReligionSpritualLink.click();
		Thread.sleep(2000);
	}
	
	//21
	public void ClickRomanceRelationsLink() throws InterruptedException {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,500)");
		JavaScriptUtil.drawBorder(RomanceRelationsLink, driver);
		RomanceRelationsLink.click();
		Thread.sleep(2000);
	}
	
	//22
	public void ClickSelfHelpLink() throws InterruptedException {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,500)");
		JavaScriptUtil.drawBorder(SelfHelpLink, driver);
		SelfHelpLink.click();
		Thread.sleep(2000);
	}
	
	//23
	public void ClickTeenYoungAdultLink() throws InterruptedException {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,500)");
		JavaScriptUtil.drawBorder(TeenYoungAdultLink, driver);
		TeenYoungAdultLink.click();
		Thread.sleep(2000);
	}
	
	
	
	
	
	
	
}
