package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PO_Login {
	
	WebDriver objdriver;
	public PO_Login(WebDriver driver )
	{
		this.objdriver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath= "//div[text()=' Choose an account to continue: ']")	
	public WebElement LoginAccountsHeader;
	
	@FindBy(xpath= "//button[@id='viLoginAAD']")	
	public WebElement AADLogin;
	
	@FindBy(xpath= "//button[@id='viLoginOutlook']")	
	public WebElement MicrosoftLogin;
	
	@FindBy(xpath= "//button[@id='viLoginGoogle']")	
	public WebElement GoogleLogin;	
	
	@FindBy(xpath= "//a[contains(@href,'facebook')]")	
	public WebElement FacebookLink;
	
	@FindBy(xpath= "//a[contains(@href,'servicesagreement')]")	
	public WebElement ServicesAgreement;
	
	@FindBy(xpath= "//input[@type = 'email']")	
	public WebElement MicrosoftLoginName;
	
	@FindBy(xpath= "//input[@type = 'submit']")	
	public WebElement MicrosoftLoginNext;
	
	@FindBy(xpath= "//input[@name = 'passwd']")	
	public WebElement MicrosoftLoginPwd;
	
	
	@FindBy(xpath= "//input[@value= 'Sign in']")	
	public WebElement MicrosoftSignIn;
	
	
	@FindBy(xpath= "//input[@value= 'No']")	
	public WebElement MicrosoftStaySignIn_No;
	
	
	@FindBy(xpath= "//div[text() = ' Azure AI Video Indexer ']")	
	public WebElement AppMainPage;
	
	

	
	
}
