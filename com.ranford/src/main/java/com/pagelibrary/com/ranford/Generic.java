package com.pagelibrary.com.ranford;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Select;

public class Generic {
	
	
	public static Select dp_handle(WebElement element)
	{
		Select s=new Select(element);
		return s;
	}
	
	/*public static Action Action_frame(WebDriver driver)
	{
		Action a=new Action(driver);
		return a;
	}*/

}
