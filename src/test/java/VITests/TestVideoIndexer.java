package VITests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import java.io.IOException;
import java.text.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonUtil.ExcelCommonUtil;
import PageSrc.LoginApp;
import PageSrc.VIAddVideo;
import PageSrc.VIVideoInsights;
import PageSrc.VIVideoSearch;

public class TestVideoIndexer {
	
	WebDriver driver;
	LoginApp objAppLogin;	
	VIAddVideo objVIAddVideo;
	VIVideoInsights objVIVideoInsights;
	VIVideoSearch objVIVideoSearch;
	public ExtentTest test;
	public ExtentReports report;
	ExcelCommonUtil objExcelUtil;
@BeforeTest
public void StartReport()
{

	report = new ExtentReports(" //../src/test/Reports/"+"VideoIndexerReport.html");
	
}
@BeforeMethod
public void SetDriver() throws InterruptedException
{	

	objExcelUtil = new ExcelCommonUtil();	
	String url = objExcelUtil.ReadTestData("Login", 5, 1);
	driver = new ChromeDriver() ;
	driver.get(url);		
	driver.manage().window().maximize();	
	
	
}
@AfterMethod
public void CloseBrowser() throws IOException
{
	driver.quit();
	objExcelUtil.CloseExcel();
	 
}
@AfterTest
public void EndReport()
{
	report.flush();
}
public void Initialize(String sTestName) throws InterruptedException
{	
	
	test = report.startTest(sTestName);
	objAppLogin = new LoginApp(driver,test);	
	objVIAddVideo = new VIAddVideo(driver, test);
	objVIVideoInsights = new VIVideoInsights(driver,test);
	objVIVideoSearch = new VIVideoSearch(driver, test);
	
}

@Test(testName="User Story 1 – Add A Video",priority = 1)
  public void UserStory1_Verify_AddVideo() throws InterruptedException, IOException {	
	 
	  Initialize("UserStory1_Verify_AddVideo");	
	  test.log(LogStatus.INFO, "Start User Story 1 – Add A Video" ); 	 	
	  objVIAddVideo.UploadFiles();	
	  test.log(LogStatus.INFO, "File Upload Successful" ); 	
	  report.endTest(test);	
	  
	  
  }
  
@Test(testName="UserStory2_View_VideoInsights",priority = 2)
  public void UserStory2_View_VideoInsights() throws InterruptedException, IOException, ParseException {	
	 
	 Initialize("UserStory2_View_VideoInsights");	
	 test.log(LogStatus.INFO, "Start Executing Test ->UserStory2_View_VideoInsights" ); 		
	 objVIVideoInsights.ClickInsightstimeline();	 
	 objVIVideoInsights.TimelineTab();
	 objVIVideoInsights.VerifyDownloadOptions();	
	 report.endTest(test);	  
	  
  }
  
 @Test(testName="UserStory3_Search Videos with Insights",priority = 3)
  public void UserStory3_SearchVideoswithInsights() throws InterruptedException, IOException {	
	 
	  Initialize("UserStory3_SearchVideoswithInsights");	
	  test.log(LogStatus.INFO, "Start Executing Test ->UserStory3_Search Videos with Insights" ); 	
	  objVIVideoSearch.SearchVideo();  
	  report.endTest(test);		  
	  
  }
 
}
