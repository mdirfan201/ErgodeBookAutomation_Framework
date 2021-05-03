package com.book.qa.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aq.Base.TestBasae;

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
		ActionAdventureLink.click();
		Thread.sleep(5000);
	}
	//2
	public void ClickArtsFilmPhotoLink() throws InterruptedException {
		ArtsFilmPhotoLink.click();
		Thread.sleep(5000);
	}
	//3
	public void ClickAutoGearLink() throws InterruptedException {
		AutoGearLink.click();
		Thread.sleep(5000);
	}
	//4
	public void ClickBiographAndMemorisLink() throws InterruptedException {
		BiographAndMemorisLink.click();
		Thread.sleep(5000);
	}
	
	//5
	public void ClickBusinessEcoLawLinks() throws InterruptedException {
		BusinessEcoLawLinks.click();
		Thread.sleep(5000);
	}
	
	//6
	public void ClickCalendarsLinks() throws InterruptedException {
		CalendarsLinks.click();
		Thread.sleep(5000);
	}
	
	//7
	public void ClickCdVinlyLinks() throws InterruptedException {
		CdVinlyLinks.click();
		Thread.sleep(5000);
	}
	
	//8
	public void ClickChildrenBookLink() throws InterruptedException {
		ChildrenBookLink.click();
		Thread.sleep(5000);
	}
	
	//9
	public void ClickCraftHobbiesLink() throws InterruptedException {
		CraftHobbiesLink.click();
		Thread.sleep(5000);
	}
	
	//10
	public void ClickEducationLink() throws InterruptedException {
		EducationLink.click();
		Thread.sleep(5000);
	}
	
	//11
	public void ClickFictionLink() throws InterruptedException {
		FictionLink.click();
		Thread.sleep(5000);
	}
	
	//12
	public void ClickGayLasbianLink() throws InterruptedException {
		GayLasbianLink.click();
		Thread.sleep(5000);
	}
	
	//13
	public void ClickGiftsLink() throws InterruptedException {
		GiftsLink.click();
		Thread.sleep(5000);
	}
	
	//14
	public void ClickHealthFitnessLink() throws InterruptedException {
		HealthFitnessLink.click();
		Thread.sleep(5000);
	}
	
	//15
	public void ClickHistoryLiterstureLink() throws InterruptedException {
		HistoryLiterstureLink.click();
		Thread.sleep(5000);
	}
	
	//16
	public void ClickHumorEntertainmentLink() throws InterruptedException {
		HumorEntertainmentLink.click();
		Thread.sleep(5000);
	}
	
	//17
	public void ClickMystryThrillerLink() throws InterruptedException {
		MystryThrillerLink.click();
		Thread.sleep(5000);
	}
	
	//18
	public void ClickPoliticsSocietyLink() throws InterruptedException {
		PoliticsSocietyLink.click();
		Thread.sleep(5000);
	}
	
	//19
	public void ClickReferenceLink() throws InterruptedException {
		ReferenceLink.click();
		Thread.sleep(5000);
	}
	
	//20
	public void ClickReligionSpritualLink() throws InterruptedException {
		ReligionSpritualLink.click();
		Thread.sleep(5000);
	}
	
	//21
	public void ClickRomanceRelationsLink() throws InterruptedException {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,500)");
		RomanceRelationsLink.click();
		Thread.sleep(5000);
	}
	
	//22
	public void ClickSelfHelpLink() throws InterruptedException {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,500)");
		SelfHelpLink.click();
		Thread.sleep(5000);
	}
	
	//23
	public void ClickTeenYoungAdultLink() throws InterruptedException {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("scrollBy(0,500)");
		TeenYoungAdultLink.click();
		Thread.sleep(5000);
	}
	
	
	
	
	
	
	
}
