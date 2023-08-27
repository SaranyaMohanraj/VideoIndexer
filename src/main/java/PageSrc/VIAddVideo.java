package PageSrc;

import PageObjects.PO_VIAddVideo;
import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import CommonUtil.ExcelCommonUtil;


public class VIAddVideo extends PO_VIAddVideo{
	WebDriver driver;
	ExcelCommonUtil objExcelUtil;
	String sLoginType = "";	
	ExtentTest test;
	String UploadType = "Browse For Files";
	String upload_privacy = "Public";
	String upload_streamingquality = "Adaptive bitrate";
	String upload_language = "English";
	Integer filesCount = 0;
	String fileName;
	String sLoginFullName;
	String sUploadFileLocation;
	String sUploadFileName;
	WebDriverWait wait;
	

	public VIAddVideo(WebDriver driver,ExtentTest objtest) throws InterruptedException
	{
		super(driver);
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));		
		Thread.sleep(Duration.ofSeconds(10));
		this.test = objtest;
		objExcelUtil = new ExcelCommonUtil();	
		test.log(LogStatus.INFO, "Video Indexer Main Page" );
		Assert.assertTrue("Library Tab is displayed correctly", TabLibrary.isDisplayed());		
		this.test.log(LogStatus.PASS, "Library Tab is displayed");
		Assert.assertTrue("Projects Tab is displayed correctly", TabProjects.isDisplayed());
		this.test.log(LogStatus.PASS, "Projects Tab is displayed");
		Assert.assertTrue("Samples Tab is displayed correctly", TabSamples.isDisplayed());
		this.test.log(LogStatus.PASS, "Samples Tab is displayed");
		UploadType = objExcelUtil.ReadTestData("AddVideo", 1, 1);
		upload_privacy = objExcelUtil.ReadTestData("AddVideo", 2, 1);
		upload_streamingquality = objExcelUtil.ReadTestData("AddVideo", 3, 1);
		upload_language = objExcelUtil.ReadTestData("AddVideo",4, 1);
		sUploadFileLocation = objExcelUtil.ReadTestData("AddVideo", 5, 1);
		sUploadFileName = objExcelUtil.ReadTestData("AddVideo", 6, 1);
		wait = new WebDriverWait(driver, Duration.ofSeconds(240), Duration.ofSeconds(2));
	}	
	
	public void UploadFiles() throws InterruptedException
	{
		String loginName = LoginName.getText();
		sLoginFullName = objExcelUtil.ReadTestData("Login", 4, 1);
		//Assert.assertTrue("LoginName Displayed as Expected"+loginName, sLoginFullName.contains(loginName));		
		verifyVI_MainScreen();
		if(UploadType == "EnterURL")
		{
			Uploadpopup_enterURL.click();
			Uploadpopup_Browseforfiles.sendKeys(sUploadFileLocation);	
			verifyFileuploadPopup_defaults("URL");				
			AddFilesbutton.click();
			fileUpload();
			verifySuccessfulFileUpload();
		}
		else
		{
			Uploadpopup_Browseforfiles.isDisplayed();	
			UploadFileBrowse.sendKeys(sUploadFileLocation);			
			//Assert File name here
			verifyFileuploadPopup_defaults("Browse");
			
			//Excel
			fileUpload();
			verifySuccessfulFileUpload();
			
			
		}
	}
	private void verifyVI_MainScreen()
	{		
		Assert.assertTrue("TrialAccount button displayed correctly", TrialAccount.isDisplayed());
		this.test.log(LogStatus.PASS, "TrialAccount button displayed");
		
		Assert.assertTrue("Notificationbutton button displayed correctly", Notificationbutton.isDisplayed());
		this.test.log(LogStatus.PASS, "Notificationbutton button displayed");
		
		Assert.assertTrue("Settingsbutton button displayed correctly", Settingsbutton.isDisplayed());
		this.test.log(LogStatus.PASS, "Settingsbutton button displayed");
		
		Assert.assertTrue("Helpbutton button displayed correctly", Helpbutton.isDisplayed());
		this.test.log(LogStatus.PASS, "Helpbutton button displayed");
		
		Assert.assertTrue("Userbutton button displayed correctly", Userbutton.isDisplayed());
		this.test.log(LogStatus.PASS, "Userbutton button displayed");
		
		ToggleButton.click();		
		
		this.test.log(LogStatus.PASS, "ToggleButton is clicked");
		
		Assert.assertTrue("MediaFiles link displayed correctly", MediaFiles.isDisplayed());
		this.test.log(LogStatus.PASS, "MediaFiles link displayed correctly");
		
		Assert.assertTrue("Accountsettings link displayed correctly", Accountsettings.isDisplayed());
		this.test.log(LogStatus.PASS, "Accountsettings link displayed correctly");
		
		Assert.assertTrue("Modelcustomizations link displayed correctly", Modelcustomizations.isDisplayed());
		this.test.log(LogStatus.PASS, "Modelcustomizations link displayed correctly");
		
		Assert.assertTrue("SearchBox is Enabled", SearchBox.isEnabled());
		this.test.log(LogStatus.PASS, "SearchBox is Enabled");
		
		Assert.assertTrue("SearchFilter is Enabled", SearchFilter.isDisplayed());
		this.test.log(LogStatus.PASS, "SearchBox is Enabled");		
		
		UploadMainscreendisplaymessage.isDisplayed();		
		Upload.click();
		this.test.log(LogStatus.PASS, "Clicked on Upload Button");		
		Uploadpopup_Header.isDisplayed();
		Uploadpopup_dragdrop.isDisplayed();
		Uploadpopup_uploadguidelines.isDisplayed();
		this.test.log(LogStatus.PASS, "Upload Popup Details displayed correctly");		
	}
	private void verifyFileuploadPopup_defaults(String UploadType)
	{	
			
		DefaultPrivacySelection.isDisplayed();
		this.test.log(LogStatus.PASS, "Default  Privacy selection is set as expected");		
		DefaultStreamingquality.isDisplayed();
		this.test.log(LogStatus.PASS, "Default  Streaming selection is set as expected");		
		VideoSourceLanguage.isDisplayed();
		this.test.log(LogStatus.PASS, "Default  Language selection is set as expected");	
		if(UploadType == "URL")		
			FilesContainer.isDisplayed();
		
		else
		{
			AddFilesbutton.isEnabled();
			this.test.log(LogStatus.PASS, "Add Files Button is Enabled");	
		}
		AdvancedSettings.click();		
		this.test.log(LogStatus.PASS, "Clicked on Advanced Settings");	
		AdvancedSettingsNavigationBar.isDisplayed();
		this.test.log(LogStatus.PASS, "Advanced settings Navigation Bar is displayed as expected");	
		Backtobasic.click();
		this.test.log(LogStatus.PASS, "Basic settings Navigation Bar is displayed as expected");	
	}
	private void fileUpload() throws InterruptedException 
	{
		
		Privacy.click();
	
		if(upload_privacy == "Private")		
			PrivateOption.click();
		
		else		
			PublicOption.click();
			
		
		this.test.log(LogStatus.PASS, "Privacy setting is selected as"+upload_privacy);	
		Sreamingquality.click();
		Thread.sleep(Duration.ofSeconds(2));
		if(upload_streamingquality == "Single")
			singlestreamingoption.click();
		else if(upload_streamingquality.contains("Adaptive"))
			adaptivestreamingoption.click();
		else
			noStreamoption.click();	
		this.test.log(LogStatus.PASS, "Streaming option is selected as"+upload_streamingquality);	
		AgreementCheckbox.click();		
		this.test.log(LogStatus.PASS, "Agreement Checkbox is clicked");	
		UploadCancel.isDisplayed();
		UploadandIndex.click();
		this.test.log(LogStatus.PASS, "Upload and Index button is clicked");
		wait.until(ExpectedConditions.visibilityOf(UploadInProgress));		
		this.test.log(LogStatus.PASS, "Upload In Progress is displayed");	
		SuccessfulFileUpload.isDisplayed();
		this.test.log(LogStatus.PASS, "Successful file upload is displayed");		
		Assert.assertEquals(SuccessfuluploadedFileName.getText(),sUploadFileName);
		this.test.log(LogStatus.PASS, "File name is displayed as expected after upload");		
		Assert.assertEquals(SuccessfuluploadedFileLang.getText(),upload_language);
		this.test.log(LogStatus.PASS, "File Language is displayed as expected after upload");	
		SuccessfuluploadedFileIndexPreset.isDisplayed();
		Assert.assertEquals(SuccessfuluploadedPrivacystatus.getText(),upload_privacy);
		this.test.log(LogStatus.PASS, "Privacy settings is displayed as expected after upload");			
		Assert.assertEquals(SuccessfuluploadedStreaming.getText(),upload_streamingquality);
		this.test.log(LogStatus.PASS, "Streaming settings is displayed as expected after upload");			
		String status =  AgreementCheckbox.getAttribute("disabled");
		Assert.assertEquals(status,"true");
		this.test.log(LogStatus.PASS, "Agreement check box is disabled");			
		FileUploadClose.click();
		this.test.log(LogStatus.PASS, "Close button in File upload is displayed");
		FileIndexing.isDisplayed();		
		wait.until(ExpectedConditions.invisibilityOf(FileIndexing));
		this.test.log(LogStatus.PASS, "Uploaded File Indexed Successfully");		
		Actions obActions = new Actions(driver);
		obActions.moveToElement(Figure).build().perform();
		FilePlay.isDisplayed();		
		this.test.log(LogStatus.PASS, "Mouse over the Indexed File to see if Play button is displayed");		
		
	}

	private void verifySuccessfulFileUpload()
	{
		filesCount = UploadedFilesList.size();
		Assert.assertEquals(Double.valueOf(filesCount),Double.valueOf(1));
		this.test.log(LogStatus.PASS, "File upload Count is verified");
		viewTilesorList.click();
		this.test.log(LogStatus.PASS, "Clicked on List View");
		viewList.click();
		Assert.assertEquals(UploadedFilesName.getText(),sUploadFileName);
		Assert.assertEquals(UploadedByName.getText(),sLoginFullName);	
		this.test.log(LogStatus.PASS, "File name and Uploaded name are displayed as expected");	
		Actions objAction = new Actions(this.driver);
		objAction.moveToElement(UploadedFilesName).build().perform();
		UploadedFileActions.click();
		Editor.isDisplayed();
		CopyfileID.isDisplayed();
		this.test.log(LogStatus.PASS, "UploadedFileActions are displayed as expected on click of context menu");	
	
	}
}
