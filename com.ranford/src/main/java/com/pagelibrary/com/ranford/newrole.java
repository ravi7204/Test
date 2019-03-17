package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebElement;

import TestBase.Base;

public class newrole extends Base {
	
	public static WebElement newrolebtn()
	{
		return driver.findElement(getElement("newrole"));
	}
	
	public static WebElement rolename()
	{
		return driver.findElement(getElement("rolename"));
	}
	
	public static WebElement roledesc()
	{
		return driver.findElement(getElement("roledesc"));
	}
	
	public static WebElement roletype()
	{
		return driver.findElement(getElement("roletype"));
	}
	public static WebElement submit()
	{
		return driver.findElement(getElement("submit2"));
	}
	
	
	
}
