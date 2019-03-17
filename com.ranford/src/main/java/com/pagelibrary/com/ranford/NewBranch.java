package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebElement;

import TestBase.Base;

public class NewBranch extends Base {
	public static WebElement branchname() 
	{
		return driver.findElement(getElement("branchname"));//OR.Properties
		
	}
	
	public static WebElement address1()
	{
		return driver.findElement(getElement("address1"));
	}
	
	public static WebElement zipcode()
	{
		return driver.findElement(getElement("zipcode"));
	}
	public static WebElement country()
	{
		return driver.findElement(getElement("country"));
	}
	
	public static WebElement state()
	{
		return driver.findElement(getElement("state"));
	}
	
	public static WebElement city()
	{
		return driver.findElement(getElement("city"));
	}
	
	public static WebElement submit()
	{
		return driver.findElement(getElement("submit"));
	}

}
