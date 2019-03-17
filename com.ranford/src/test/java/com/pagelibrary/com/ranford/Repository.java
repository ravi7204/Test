package com.pagelibrary.com.ranford;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestBase.Base;
import component.Validate;

public class Repository extends Base{
	public ExtentReports report;
	public ExtentTest test;
	//public WebDriver Firefox;
	
	@BeforeSuite
	public void extentreport()
	{
		 report=new ExtentReports("./extentreport/report.html",true);
	}
	
	//send the each method to report before executing
	@BeforeMethod
	public void functiontoreport(Method method)
	{
		test=report.startTest((this.getClass().getSimpleName()+": :"+method.getName()));// need explaination
		
		test.assignAuthor("Ravi");
		test.assignCategory("Regression");
	}
	
	
	public void login()
	{
		
		LoginPage.username_editbox().sendKeys(getconfig("username"));
		LoginPage.password_editbox().sendKeys(getconfig("password"));
		LoginPage.login_btn().click();
		
		if(Validate.IsTitlePresent(getconfig("loginexptittle")))//return true then if executes the extent reports
		{
			test.log(LogStatus.PASS,"my exptittle is :-"+getconfig("loginexptittle")+"  matching with my actualtittle :-"+driver.getTitle());
			test.log(LogStatus.INFO,"login is success branches is not displayed ");
		}
		
		else
		{
			test.log(LogStatus.FAIL,"my exptittle is :-"+getconfig("loginexptittle")+"  matching with my actualtittle :-"+driver.getTitle());
			test.log(LogStatus.INFO,"login is success branches is displayed");	
		}
			report.flush();
		
	}
	
	/*public void login(String u,String p) // Datadriven
	{
		LoginPage.username_editbox().sendKeys(u);
		LoginPage.password_editbox().sendKeys(p);
		LoginPage.login_btn().click();
		if(Validate.IsTitlePresent(getconfig("loginexptittle")))//return true then if executes
		{
			test.log(LogStatus.PASS,"my exptittle is :-"+getconfig("loginexptittle")+"  matching with my actualtittle :-"+driver.getTitle());
			test.log(LogStatus.INFO,"login is success branches is not displayed ");
		}
		
		else
		{
			test.log(LogStatus.FAIL,"my exptittle is :-"+getconfig("loginexptittle")+"  matching with my actualtittle :-"+driver.getTitle());
			test.log(LogStatus.INFO,"login is success branches is displayed");	
		}
			report.flush();
		
		driver.findElement(By.xpath("//img[@src='images/admin_but_03.jpg']")).click(); //Logout from Appln
	}*/
	
	public void brancheseearch()
	{
		Admin.branches().click();
		
		Generic.dp_handle(Branches.countrydropdown()).selectByVisibleText(getconfig("countrydropdown"));
		Generic.dp_handle(Branches.statedropdown()).selectByVisibleText(getconfig("statedropdown"));
		Generic.dp_handle(Branches.citydopdown()).selectByVisibleText(getconfig("citydropdown"));
	}
	
	/*public void newbranch() ---> Keyword Driven
	{
		Admin.branches().click();
		Branches.newbranchesbtn().click();
	  NewBranch.branchname().sendKeys(getconfig("branchname"));//getconfig used to read data from config.properties
	  NewBranch.address1().sendKeys(getconfig("address1"));
	  NewBranch.zipcode().sendKeys(getconfig("zipcode"));
	  Generic.dp_handle(NewBranch.country()).selectByVisibleText(getconfig("country"));
	  WebDriverWait wait= new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lst_stateI")));
	  Generic.dp_handle(NewBranch.state()).selectByVisibleText(getconfig("state"));;
	  
	  Generic.dp_handle(NewBranch.city()).selectByVisibleText(getconfig("city"));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_insert")));
	  NewBranch.submit().click();
	  driver.switchTo().alert().accept();
	  
	 }*/
	public void newbranch(String n, String a, String z) // Data Driven
	{
		Admin.branches().click();
		Branches.newbranchesbtn().click();
	  NewBranch.branchname().sendKeys(n);//getconfig used to read data from config.properties
	  NewBranch.address1().sendKeys(a);
	  NewBranch.zipcode().sendKeys(z);
	  Generic.dp_handle(NewBranch.country()).selectByVisibleText(getconfig("country"));
	  WebDriverWait wait= new WebDriverWait(driver,30);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lst_stateI")));
	  Generic.dp_handle(NewBranch.state()).selectByVisibleText(getconfig("state"));;
	  
	  Generic.dp_handle(NewBranch.city()).selectByVisibleText(getconfig("city"));
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btn_insert")));
	  NewBranch.submit().click();
	  if(Validate.IsAlertPresent(getconfig("branchmsg")))//return true then if executes
		{
			test.log(LogStatus.PASS,"my exptittle is :-"+getconfig("branchmsg")+"  matching with my actualtittle :-"+driver.switchTo().alert().getText());
			test.log(LogStatus.INFO,"login is success branches is not displayed ");
		}
		
		else
		{
			test.log(LogStatus.FAIL,"my exptittle is :-"+getconfig("branchmsg")+"  matching with my actualtittle :-"+driver.switchTo().alert().getText());
			test.log(LogStatus.INFO,"login is success branches is displayed");	
		}
			report.flush();
	  
	  driver.switchTo().alert().accept();
	  
	 }
	
	
	/*public void newroles()   //KeywordDriven
	{
		Admin.roles().click();
		newrole.newrolebtn().click();
		newrole.rolename().sendKeys(getconfig("rolename"));
		newrole.roledesc().sendKeys("roledesc");
		Generic.dp_handle(newrole.roletype()).selectByVisibleText(getconfig("roletype"));
		
		
	}*/
	
	public void newroles(String r, String s)
	{
		Admin.roles().click();
		newrole.newrolebtn().click();
		newrole.rolename().sendKeys(r);
		newrole.roledesc().sendKeys(s);
		Generic.dp_handle(newrole.roletype()).selectByVisibleText(getconfig("roletype"));
		newrole.submit().click();
		if(Validate.IsAlertPresent(getconfig("alertmsg")))//return true then if executes
		{
			test.log(LogStatus.PASS,"my exptittle is :-"+getconfig("alertmsg")+"  matching with my actualtittle :-"+driver.switchTo().alert().getText());
			test.log(LogStatus.INFO,"login is success branches is not displayed ");
		}
		
		else
		{
			test.log(LogStatus.FAIL,"my exptittle is :-"+getconfig("alertmsg")+"  matching with my actualtittle :-"+driver.switchTo().alert().getText());
			test.log(LogStatus.INFO,"login is success branches is displayed");	
		}
			report.flush();
			driver.switchTo().alert().accept();
		
		
	}
	
	
	/*public void launch()
	{
		switch (getconfig("browser"))
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			System.setProperty("webdriver.gecko.driver","" );
			driver=new ChromeDriver();
			break;
			
		}*/
	public void launch(String browser)//For testng
	{
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			driver=new ChromeDriver();
		
			
		}
		else {
			System.setProperty("webdriver.gecko.driver","./driver/geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get(Base.getconfig("build1"));
		if(Validate.IsTitlePresent(getconfig("loginexptittle")))//return true then if executes
		{
			test.log(LogStatus.PASS,"my exptittle is :-"+getconfig("loginexptittle")+"  matching with my actualtittle :-"+driver.getTitle());
			test.log(LogStatus.INFO,"login is success branches is not displayed ");
		}
		
		else
		{
			test.log(LogStatus.FAIL,"my exptittle is :-"+getconfig("loginexptittle")+"  matching with my actualtittle :-"+driver.getTitle());
			test.log(LogStatus.INFO,"login is success branches is displayed");	
		}
			report.flush();
		
	}
	}

