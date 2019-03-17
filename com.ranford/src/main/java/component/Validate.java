package component;

import TestBase.Base;

public class Validate extends Base{
	
	public static boolean IsTitlePresent(String exp)
	{
		boolean b=driver.getTitle().contains(exp);
		return b;
	}
	
	public static boolean IsAlertPresent(String exp)
	{
		boolean b=driver.switchTo().alert().getText().contains(exp);
		return b;
	}

	
}
