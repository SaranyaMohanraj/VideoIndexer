package PageSrc;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import CommonUtil.ExcelCommonUtil;
import PageObjects.PO_VISearch;

public class VIVideoSearch extends PO_VISearch {
	
	
	WebDriver driver;
	ExcelCommonUtil objExcelUtil;
	ExtentTest test;
	String Search_Text;
	String Search_ResultCount;
	String SearchVideoName;
	String SearchVideoUploadedBy;
	
	public VIVideoSearch(WebDriver driver,ExtentTest objtest)
	{
		super(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		this.driver = driver;
		this.test = objtest;
		objExcelUtil = new ExcelCommonUtil();	
		Search_Text = objExcelUtil.ReadTestData("SearchVideo", 1, 1);
		Search_ResultCount = objExcelUtil.ReadTestData("SearchVideo", 2, 1);
		SearchVideoName = objExcelUtil.ReadTestData("SearchVideo", 3, 1);
		SearchVideoUploadedBy = objExcelUtil.ReadTestData("SearchVideo", 4, 1);
	
		
	}	
	public void SearchVideo() throws InterruptedException
	{
		SamplesTab.click();
		this.test.log(LogStatus.PASS, "Clicked on the Samples Tab");
		SearchBox.sendKeys(Search_Text);
		this.test.log(LogStatus.PASS, "Entered"+Search_Text+"in Search Box");
		SearchBox.sendKeys(Keys.ENTER);
		Filter.click();
		this.test.log(LogStatus.PASS, "Clicked on Filter");
		Search_Insight.isDisplayed();
		this.test.log(LogStatus.PASS, "Search based on Insight is displayed in the Filter");
		Search_Searchin.isDisplayed();
		this.test.log(LogStatus.PASS, "Search based on Searchin is displayed in the Filter");
		SearchinDropdown.click();
		this.test.log(LogStatus.PASS, "Clicked on Search in Dropdown");
		TopicsOnly.click();
		this.test.log(LogStatus.PASS, "Clicked on Topics only option");
		Thread.sleep(Duration.ofSeconds(5));	
		Search.click();
		this.test.log(LogStatus.PASS, "Clicked on Search Button");
		Thread.sleep(Duration.ofSeconds(5));	
		Integer size = SearchVideos.size(); 
		if(size == Integer.parseInt(Search_ResultCount))
		Assert.assertTrue("Videos are displayed as expected",true);		
		viewTilesorList.click();
		this.test.log(LogStatus.PASS, "Click on ViewTilesorList button");
		viewList.click();
		this.test.log(LogStatus.PASS, "Click on ViewList");
		Assert.assertEquals(UploadedFilesName.getText(),SearchVideoName);	
		this.test.log(LogStatus.PASS, SearchVideoName+"-Video Name is verified in search results");
		Assert.assertEquals(UploadedByName.getText(),SearchVideoUploadedBy);				
		this.test.log(LogStatus.PASS, SearchVideoUploadedBy+"-Video Uploaded by Name is verified in search results");
		
	}

}
