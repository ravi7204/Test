package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebElement;

import TestBase.Base;

public class Branches extends Base {
     //Mouse hoover action on branches
	public static WebElement newbranchesbtn()
	{
		return driver.findElement(getElement("newbranch"));
	}
	public static WebElement branches()
	{
		return driver.findElement(getElement("branches"));
	}
	
	public static WebElement countrydropdown()
	{
		return driver.findElement(getElement("countrydropdown"));
	}
	
	public static WebElement statedropdown()
	{
		return driver.findElement(getElement("statedropdown"));
	}
	public static WebElement citydopdown()
	{
		return driver.findElement(getElement("citydropdown"));
	}
	public static WebElement search()
	{
		return driver.findElement(getElement("search"));
	}
	
	public static WebElement newbranch()
	{
		return driver.findElement(getElement("newbranch"));
	}
	
}
