package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_VIVideoInsights {
	
	WebDriver objdriver;
	public PO_VIVideoInsights(WebDriver driver )
	{
		this.objdriver = driver;
		PageFactory.initElements(driver, this);
	}	
	
		
	@FindBy(xpath= "//span[contains(text(),'topic')]")	
	public WebElement Video_Topic;
	
	@FindBy(xpath= "//span[contains(text(),'people')]")	
	public WebElement Video_People;
	
	@FindBy(xpath= "//span[contains(text(),'auio')]")	
	public WebElement Video_audio;
	
	@FindBy(xpath= "//span[contains(text(),'keyword')]")	
	public WebElement Video_keyword;
	
	@FindBy(xpath= "//span[contains(text(),'label')]")	
	public WebElement Video_label;
	
	@FindBy(xpath= "//span[contains(text(),'entity')]")	
	public WebElement Video_entity;
	
	//
	
	@FindBy(xpath= "//div[@class='vi-player video embed-video']")	
	public WebElement Video;
	
	@FindBy(xpath= "//div[@class='grid-wrapper ng-star-inserted']/div[1]//span[@class ='col col-name']")	
	public WebElement PlayVideo;
	
	
	@FindBy(xpath= "//*[@id='facesComponent']/div[4]/div/app-vi-insights-horizontal-timeline/div[1]//*[name()='svg']//*[name()='rect'][1]")	
	public WebElement PeopleTimeline;
	
	@FindBy(xpath= "//section[contains(@class,'topics-component')]/div[2]/div/div/app-vi-insights-horizontal-timeline/div[1]//*[name()='svg']//*[name()='rect'][1]")	
	public WebElement TopicTimeline;
	
	
	@FindBy(xpath= "//*[@id='acousticEventsComponent']/div[3]/div/app-vi-insights-horizontal-timeline/div[1]//*[name()='svg']//*[name()='rect'][1]")	
	public WebElement AudioTimeline;
	
	@FindBy(xpath= "//*[@id='labelsComponent']/div[3]/div/app-vi-insights-horizontal-timeline/div[1]//*[name()='svg']//*[name()='rect'][1]")	
	public WebElement LabelTimeline;
	
	@FindBy(xpath= "//*[@id='keywordsComponent']/div[3]/div/app-vi-insights-horizontal-timeline/div[1]//*[name()='svg']//*[name()='rect'][1]")	
	public WebElement KeywordTimeline;
	
	@FindBy(xpath= "//*[@id='mentionedEntitiesComponent']/div[3]/div/app-vi-insights-horizontal-timeline/div[1]//*[name()='svg']//*[name()='rect'][1]")	
	public WebElement EntititesTimeline;
	
	
	@FindBy(xpath= "//*[@id='acousticEventsComponent']/div[3]/div/app-vi-insights-horizontal-timeline/div[1]//*[name()='svg']//*[name()='g']//*[name()='text']")	
	public WebElement AudioTimelineText;
	
	@FindBy(xpath= "//*[@id='facesComponent']/div[4]/div/app-vi-insights-horizontal-timeline/div[1]//*[name()='svg']//*[name()='g']//*[name()='text']")	
	public WebElement PeopleTimelineText;
	
	@FindBy(xpath= "//section[contains(@class,'topics-component')]/div[2]/div/div/app-vi-insights-horizontal-timeline/div[1]//*[name()='svg']//*[name()='g']//*[name()='text']")	
	public WebElement TopicTimelineText;
	
	@FindBy(xpath= "//*[@id='labelsComponent']/div[3]/div/app-vi-insights-horizontal-timeline/div[1]//*[name()='svg']//*[name()='g']//*[name()='text']")	
	public WebElement LabelTimelineText;
	
	@FindBy(xpath= "//*[@id='keywordsComponent']/div[3]/div/app-vi-insights-horizontal-timeline/div[1]//*[name()='svg']//*[name()='g']//*[name()='text']")	
	public WebElement KeywordTimelineText;
	
	@FindBy(xpath= "//*[@id='mentionedEntitiesComponent']/div[3]/div/app-vi-insights-horizontal-timeline/div[1]//*[name()='svg']//*[name()='g']//*[name()='text']")	
	public WebElement EntititesTimelineText;
	
	@FindBy(xpath= "//div[@class ='vjs-play-progress vjs-slider-bar ']")	
	public WebElement VideoTimestamp;
	
	@FindBy(xpath= "//div[@class ='vjs-slider-handle ']")	
	public WebElement VideoSliderhandle;
	
	@FindBy(xpath= "//div[@aria-label = 'video player']")	
	public WebElement VideoContent;
	
	@FindBy(xpath= "//button[@class='vjs-play-control vjs-control vjs-button outline-enabled-control vjs-playing']")	
	public WebElement VideoPlaying;
	
	
	@FindBy(xpath= "//button[@id='tab1']")	
	public WebElement TimeLineTab;
	
	
	@FindBy(xpath= "//button[@id = 'download-insights']")	
	public WebElement DownloadVideo;
	
	@FindBy(xpath= "//span[text() = 'Insights (JSON)']")	
	public WebElement JsonDownload;
	
	
	@FindBy(xpath= "//ul[@id='submenu-download-insights']/li[contains(@title,'Artifacts')]")	
	public WebElement ArtifactsDownload;
	

	@FindBy(xpath= "//span[text() = 'Closed captions']")	
	public WebElement ClosedCaptions;

	@FindBy(xpath= "//h1[text() =' Download closed captions ']")	
	public WebElement DownloadCaptionsPopup;
	
	@FindBy(xpath= "//span[text() = 'SRT']")	
	public WebElement DefaultSRTOption;
	
	@FindBy(xpath= "//button[@id= 'download']")	
	public WebElement DownloadSRT;
	

	



	
	
	
	
}
