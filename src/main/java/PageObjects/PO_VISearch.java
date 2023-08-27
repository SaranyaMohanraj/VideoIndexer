package PageObjects;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_VISearch {
	
	WebDriver objdriver;
	public PO_VISearch(WebDriver driver )
	{
		this.objdriver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath= "//input[@id = 'viFilterSearchInput']")	
	public WebElement SearchBox;
	
	@FindBy(xpath= "//button[@id = 'filterGalleryButton']")	
	public WebElement Filter;
	
	
	@FindBy(xpath= "//vi-gallery-search-view//div[@class='col col-thumbnail']")	
	public List<WebElement> SearchVideos;
	
	@FindBy(xpath= "//label[text()='Insight type']")	
	public WebElement Search_Insight;
	
	@FindBy(xpath= "//label[text()='Search in']")	
	public WebElement Search_Searchin;	
	
	@FindBy(xpath= "//span[text()='Search']")	
	public WebElement Search;	
	
	@FindBy(xpath= "//button[@id='tabSamples']")	
	public WebElement SamplesTab;	
	
	@FindBy(xpath= "//div[@aria-label = 'Search in']//p-dropdown")	
	public WebElement SearchinDropdown;	
	
	@FindBy(xpath= "//li//div//span[text() = 'Topics only']")	
	public WebElement TopicsOnly;	
	
	
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
	
	
}
