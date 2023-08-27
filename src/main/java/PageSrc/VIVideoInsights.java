package PageSrc;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonUtil.ExcelCommonUtil;
import PageObjects.PO_VIVideoInsights;

public class VIVideoInsights extends PO_VIVideoInsights {
	WebDriver driver;
	ExtentTest test;
	WebDriverWait wait;
	ExcelCommonUtil objExcelUtil;
	String TimelineInsight_People;
	String TranscribedInfoSheetname;
	public VIVideoInsights(WebDriver driver,ExtentTest objtest) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
		this.driver = driver;
		this.test = objtest;
		objExcelUtil = new ExcelCommonUtil();	
		wait = new WebDriverWait(driver, Duration.ofSeconds(120), Duration.ofSeconds(2));
		TimelineInsight_People = objExcelUtil.ReadTestData("VideoIndexing", 4, 1);
		TranscribedInfoSheetname = objExcelUtil.ReadTestData("VideoIndexing", 3, 1);
	
		
	}
	public void ClickInsightstimeline() throws InterruptedException, ParseException
	{
		
		 
		String sTimelineText;
		String VideoTimelineText;
		Actions objAction = new Actions(this.driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		PlayVideo.click();
		this.test.log(LogStatus.PASS, "Click on Playing Video"); 
		wait.until(ExpectedConditions.visibilityOf(Video));	
		objAction.moveToElement(Video).build().perform();		
		wait.until(ExpectedConditions.visibilityOf(VideoPlaying));
		objAction.moveToElement(VideoContent).build().perform();		
		this.test.log(LogStatus.PASS, "Video Started Playing");
		//The Below is done for People timeline.. The same could be extended to other Insights as well
		//Moved to an offset of 20which could be parameterized
		if(TimelineInsight_People.contains("Yes"))
		{
		objAction.moveToElement(PeopleTimeline).moveByOffset(20, 2).click().build().perform();			
		sTimelineText = (String) js.executeScript("return arguments[0].textContent",PeopleTimelineText);
		Thread.sleep(Duration.ofSeconds(1));		
		this.test.log(LogStatus.INFO, "Timeline is set to  "+sTimelineText);
		VideoTimelineText = VideoTimestamp.getAttribute("data-current-time");		
		this.test.log(LogStatus.INFO, "Video is correctly advanced based on the Timeline of "+VideoTimelineText);		
		Assert.assertTrue(sTimelineText.contains(VideoTimelineText));		
		this.test.log(LogStatus.PASS, "Video is correctly advanced based on the Timeline");
		}
	}

	public void TimelineTab() throws InterruptedException, IOException
	{
		Thread.sleep(Duration.ofSeconds(10));	
		TimeLineTab.click();
		int loopcount = objExcelUtil.getRowCount(TranscribedInfoSheetname);
		String Xpath;
		String Time;
		String TranscribedText;
		WebElement objTranscribed;
		for(int i=1;i<loopcount;i++)
		{
			Time = objExcelUtil.ReadTestData(TranscribedInfoSheetname,i, 0);
			TranscribedText = objExcelUtil.ReadTestData(TranscribedInfoSheetname,i, 1);
			Xpath ="//div[text() ='"+Time+"']/../following-sibling::div//li[contains(text() , '"+TranscribedText+"')]";
			objTranscribed = driver.findElement(By.xpath(Xpath));
			Assert.assertTrue(objTranscribed.isDisplayed());	
			this.test.log(LogStatus.PASS, "Transcribed Text Present"+Time+"-"+TranscribedText);
			
		}
		this.test.log(LogStatus.PASS, "Transcribed Text is verified Successfully");
	}
	
	public void VerifyDownloadOptions() throws InterruptedException, IOException
	{
		File file;
		boolean fileexists = false;
		Path path ;	
		 String source = System.getProperty("user.home");			
		DownloadVideo.click();
		this.test.log(LogStatus.PASS, "Click on Download Button");
		JsonDownload.click();
		this.test.log(LogStatus.PASS, "Click on Json Download Button");
		
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());		
		 driver.switchTo().window(tabs.get(1));
		 String JsonDownloadURL = driver.switchTo().window(tabs.get(1)).getCurrentUrl();
		 Assert.assertTrue("Newly opened URL Contains Video Indexer", JsonDownloadURL.contains("https://api.videoindexer.ai/Trial/"));
		 this.test.log(LogStatus.PASS, "Json download Opens a new tab and is verified");
		 driver.close();	
		 this.test.log(LogStatus.PASS, "Json download opened tab is closed Successfully");
		 driver.switchTo().window(tabs.get(0));
		 Thread.sleep(Duration.ofSeconds(5));		
		 DownloadVideo.click();
		 this.test.log(LogStatus.PASS, "Switch to the main window and click on Download again");
		 ArtifactsDownload.click();
		 this.test.log(LogStatus.PASS, "Click on ArtifactsDownload button");
		 Thread.sleep(Duration.ofSeconds(25));	
		
		 file = new File(source+"/Downloads/ElephantsDream.zip");
		 path = Paths.get(source+"/Downloads/ElephantsDream.zip");
		 fileexists =  file.exists();
		 Assert.assertTrue("File Download Successful", fileexists);
		 Files.delete(path);
		 this.test.log(LogStatus.PASS, "File Downloaded Successfully in Zip format");
		 DownloadVideo.click();
		 this.test.log(LogStatus.PASS, "Click on Download Button");
		 ClosedCaptions.click();	
		 this.test.log(LogStatus.PASS, "Click on ClosedCaptions button");
		 Assert.assertTrue("DownloadCaptionsPopup Successful", DownloadCaptionsPopup.isDisplayed()); 		 
		 Assert.assertTrue("DefaultSRTOption is shown", DefaultSRTOption.isDisplayed());
		 this.test.log(LogStatus.PASS, "Download popup is shown and verified");
		 DownloadSRT.click();
		 Thread.sleep(Duration.ofSeconds(25));	
		 file = new File(source+"/Downloads/ElephantsDream.srt");
		 path = Paths.get(source+"/Downloads/ElephantsDream.srt");
		 fileexists =  file.exists();
		 Assert.assertTrue("File Download Successful", fileexists);
		 Files.delete(path); 
		 this.test.log(LogStatus.PASS, "File Downloaded Successfully in SRT format");
		 
		 
	}

}

