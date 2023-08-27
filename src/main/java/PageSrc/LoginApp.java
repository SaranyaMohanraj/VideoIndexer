package PageSrc;

import PageObjects.PO_Login;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.net.UrlChecker.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import CommonUtil.ExcelCommonUtil;
import java.time.Duration;

public class LoginApp extends PO_Login{
	WebDriver driver;
	ExcelCommonUtil objExcelUtil;
	String sLoginType = "";	
	ExtentTest test;
	String sLoginName;
	String sLoginPwd;

	public LoginApp(WebDriver driver,ExtentTest objtest) throws InterruptedException
	{
		super(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		this.driver = driver;
		
		this.test = objtest;
		objExcelUtil = new ExcelCommonUtil();
		
		sLoginName = objExcelUtil.ReadTestData("Login", 1, 1);
		sLoginPwd = objExcelUtil.ReadTestData("Login", 2, 1);
		sLoginType = objExcelUtil.ReadTestData("Login", 3, 1);
		Assert.assertTrue("FacebookLink displayed as expected", FacebookLink.isDisplayed());
		this.test.log(LogStatus.PASS, "FacebookLink is displayed");
		
		Assert.assertTrue("ServicesAgreement link displayed as expected", ServicesAgreement.isDisplayed());
		this.test.log(LogStatus.PASS, "ServicesAgreement link displayed as expected");
		
		Assert.assertTrue("AADLogin button is displayed as expected", AADLogin.isDisplayed());
		this.test.log(LogStatus.PASS, "AADLogin button is displayed");
		
		Assert.assertTrue("MicrosoftLogin button is displayed as expected", MicrosoftLogin.isDisplayed());
		this.test.log(LogStatus.PASS, "MicrosoftLogin button is displayed");
		
		Assert.assertTrue("GoogleLogin button is displayed as expected", GoogleLogin.isDisplayed());
		this.test.log(LogStatus.PASS, "GoogleLogin button is displayed");	
	
	
		if(sLoginType.trim().contains( "Microsoft"))
		{
		
		MicrosoftLogin.click();		
		MicrosoftLoginName.sendKeys(sLoginName);
		MicrosoftLoginNext.click();
		MicrosoftLoginPwd.sendKeys(sLoginPwd);
		MicrosoftSignIn.click();
		MicrosoftStaySignIn_No.click();
		Assert.assertTrue("Video Indexer application Login successfully using Microsoft Account", AppMainPage.isDisplayed());
		this.test.log(LogStatus.PASS, "Video Indexer Application is Successfully Logged in");
		}
	
		
	}	
}
