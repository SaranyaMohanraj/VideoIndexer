package PageObjects;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_VIAddVideo {
	
	WebDriver objdriver;
	public PO_VIAddVideo(WebDriver driver )
	{
		this.objdriver = driver;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath= "//button[@id='tabLibrary']")	
	public WebElement TabLibrary;
	
	@FindBy(xpath= "//button[@id='tabProjects']")	
	public WebElement TabProjects;
	
	@FindBy(xpath= "//button[@id='tabSamples']")	
	public WebElement TabSamples;
	
	
	@FindBy(xpath= "//div[@class='name']")	
	public WebElement LoginName;
	
	@FindBy(xpath= "//span[text()='Create unlimited account']")	
	public WebElement TrialAccount;
	
	@FindBy(xpath= "//button[@id='notificationsBtn']")	
	public WebElement Notificationbutton;
	
	@FindBy(xpath= "//button[@id='settings']")	
	public WebElement Settingsbutton;
	
	@FindBy(xpath= "//button[@id='help']")	
	public WebElement Helpbutton;
	
	@FindBy(xpath= "//div[@id='toggleBtn']")	
	public WebElement ToggleButton;
	
	@FindBy(xpath= "//button[@id='userButton']")	
	public WebElement Userbutton;
	
	@FindBy(xpath= "//span[text()='Media files']")	
	public WebElement MediaFiles;
	
	@FindBy(xpath= "//span[text()='Account settings']")	
	public WebElement Accountsettings;
	
	@FindBy(xpath= "//span[text()='Model customizations']")	
	public WebElement Modelcustomizations;
	
	@FindBy(xpath= "//input[@aria-label='Search']")	
	public WebElement SearchBox;
	
	@FindBy(xpath= "//button[@aria-label='Filters']")	
	public WebElement SearchFilter;
	
	@FindBy(xpath= "//button[@id='galleryUploademptyState']")	
	public WebElement Upload;  
	
	@FindBy(xpath= "//div[contains(text(),'Upload videos to see insights')]")	
	public WebElement UploadMainscreendisplaymessage;
	
	
	@FindBy(xpath= "//h1[text()=' Upload and index ']")	
	public WebElement Uploadpopup_Header;	
	
	@FindBy(xpath= "//button[@id='browseForFileAction']")	
	public WebElement Uploadpopup_Browseforfiles;
	
	@FindBy(xpath= "//input[@type='file']")	
	public WebElement UploadFileBrowse;
	
	
	@FindBy(xpath= "//button[@id='enterUrlAction']")	
	public WebElement Uploadpopup_enterURL;
	
	@FindBy(xpath= "//a[text()='Uploading guidelines']")	
	public WebElement Uploadpopup_uploadguidelines;
	
	@FindBy(xpath= "//span[text()=' Drag and drop files ']")	
	public WebElement Uploadpopup_dragdrop;
	
	@FindBy(xpath= "//label[contains(text(),'File name')]/../..//input")	
	public WebElement UploadedFileName;
	
	@FindBy(xpath= "//button[@id='addFilesButton']")	
	public WebElement AddFilesbutton;
	
	@FindBy(xpath= "//main[@class='main-view']//div[@id = 'indexingPrivacy']/../..//span[text() = 'Private']")	
	public WebElement DefaultPrivacySelection;
	
	@FindBy(xpath= "//main[@class='main-view']//div[@id = 'indexingPrivacy']/../..//p-dropdown")	
	public WebElement Privacy;
	
	@FindBy(xpath= "//main[@class='main-view']//div[@id = 'indexingStreaming']/../..//p-dropdown")	
	public WebElement Sreamingquality;
	
	@FindBy(xpath= "//main[@class='main-view']//div[@id = 'indexingStreaming']/../..//span[text() = 'Single bitrate']")	
	public WebElement DefaultStreamingquality;
	
	@FindBy(xpath= "//div[@id = 'PRIVATE']")	
	public WebElement PrivateOption;
	
	@FindBy(xpath= "//div[@id = 'PUBLIC']")	
	public WebElement PublicOption;
	
	@FindBy(xpath= "//div[@id = 'single']")	
	public WebElement singlestreamingoption;
	
	@FindBy(xpath= "//div[@id = 'adaptive']")	
	public WebElement adaptivestreamingoption;
	
	@FindBy(xpath= "//div[@id = 'noStream']")	
	public WebElement noStreamoption;
	
	@FindBy(xpath= "//main[@class='main-view']//vi-ui-tag-container[@id ='filesContainer']")	
	public WebElement FilesContainer;	
	
	
	@FindBy(xpath= "//main[@class='main-view']//div[@id = 'indexingLanguage']//span[text() = 'English']")	
	public WebElement VideoSourceLanguage;
	
	@FindBy(xpath= "//button[@id = 'advancedSettingsButton']")	
	public WebElement AdvancedSettings;	
	
	
	@FindBy(xpath= "//ul[@class = 'nav-bar']")	
	public WebElement AdvancedSettingsNavigationBar;
	
	@FindBy(xpath= "//button[@id = 'backToBasicButton']")	
	public WebElement Backtobasic;
	
	@FindBy(xpath= "//label[@class = 'c-label']//input//following::span")	
	public WebElement AgreementCheckbox;
	
	
	@FindBy(xpath= "//button[@id='uploadButtonAction']")	
	public WebElement UploadandIndex;
	
	@FindBy(xpath= "//button[@id='cancel']")	
	public WebElement UploadCancel;
	
	@FindBy(xpath= "//span[text() ='Uploading...']")	
	public WebElement UploadInProgress;
	
	
	@FindBy(xpath= "//span[text() = '1 file uploaded']")	
	public WebElement SuccessfulFileUpload;
	
	@FindBy(xpath= "//div[@class ='row']//label[contains(text(),'File')]/..//following-sibling::div/span[1]")	
	public WebElement SuccessfuluploadedFileName;
	
	@FindBy(xpath= "//div[@class ='row ng-star-inserted']//label[contains(text(),'Video source language')]/..//following-sibling::span")	
	public WebElement SuccessfuluploadedFileLang;
	
	@FindBy(xpath= "//div[@class ='row ng-star-inserted']//label[contains(text(),'Indexing preset')]/..//following-sibling::span")	
	public WebElement SuccessfuluploadedFileIndexPreset;
	
	@FindBy(xpath= "//div[@class ='row ng-star-inserted']//label[contains(text(),'Privacy')]/..//following-sibling::span")	
	public WebElement SuccessfuluploadedPrivacystatus;
	
	@FindBy(xpath= "//div[@class ='row ng-star-inserted']//label[contains(text(),'Streaming quality')]/..//following-sibling::span")	
	public WebElement SuccessfuluploadedStreaming;
	
	@FindBy(xpath= "//span[text() = 'Close']")	
	public WebElement FileUploadClose;
	
	@FindBy(xpath= "//span[text() = 'Indexing... ']")	
	public WebElement FileIndexing;	
	
	@FindBy(xpath= "//span[text() = ' Play']")	
	public WebElement FilePlay;	
	
	@FindBy(xpath= "//figure[@class='figure']")	
	public WebElement Figure;		
	
	@FindBy(xpath= "//div[@id='gallery-view-menu']")	
	public WebElement viewTilesorList;	
	
	@FindBy(xpath= "//span[text()='List']")	
	public WebElement viewList;	
	
	@FindBy(xpath= "//div[@class = 'cdk-virtual-scroll-content-wrapper']/div")	
	public  List<WebElement> UploadedFilesList;
	
	@FindBy(xpath= "//div[@class = 'cdk-virtual-scroll-content-wrapper']/div[1]//span[@class = 'col col-name']")	
	public  WebElement UploadedFilesName;
	
	@FindBy(xpath= "//div[@class = 'cdk-virtual-scroll-content-wrapper']/div[1]//span[@class = 'col col-owner']")	
	public  WebElement UploadedByName;
	
	@FindBy(xpath= "//div[@class = 'cdk-virtual-scroll-content-wrapper']/div[1]//span[@class = 'col col-last-modified ng-star-inserted']")	
	public  WebElement UploadedTime;
	
	@FindBy(xpath= "//div[@class = 'cdk-virtual-scroll-content-wrapper']/div[1]//button[@class ='action-button left']")	
	public  WebElement UploadedFileActions;
	
	@FindBy(xpath= "//div[@class ='sub-dropdown']//li//span[text() = 'Re-index']")	
	public  WebElement ReIndex;
	
	@FindBy(xpath= "//div[@class ='sub-dropdown']//li//span[text() = 'Editor']")	
	public  WebElement Editor; 

	@FindBy(xpath= "//div[@class ='sub-dropdown']//li//span[text() = 'Delete']")	
	public  WebElement Delete; 
	
	@FindBy(xpath= "//div[@class ='sub-dropdown']//li//span[text() = 'Copy file ID']")	
	public  WebElement CopyfileID; 
	
	@FindBy(xpath= "//span[text() = 'Delete']")	
	public  WebElement DeleteFile_popup; 
	
	
}
