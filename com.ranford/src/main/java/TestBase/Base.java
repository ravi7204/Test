package TestBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Base 
{
	static Properties property;
	public static WebDriver driver;
	
	
	public static void loadproperty()
	{
		 
			try {
				File f=new File("./src/main/java/configuration/OR.properties");
				FileReader fr=new FileReader(f);
				property=new Properties();
				property.load(fr);
			    } catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e)
			   {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   }
			
			
	}
	public static By getElement(String key)
	{
		 By loc=null;
		loadproperty();
		String value=property.getProperty(key);
		String loctype=value.split(":")[0];
		String locvalue=value.split(":")[1];
		
		switch(loctype)
		{
			case  "id":
			loc=By.id(locvalue);
			break;
			
			case "name":
				loc=By.name(locvalue);
			case "xpath":
				loc=By.xpath(locvalue);
		}
		
		return loc;
		
	}
	public static void loadpropertyconfig()
	{
		 
			try {
				File f=new File("./src/main/java/configuration/config.properties");
				FileReader fr=new FileReader(f);
				property=new Properties();
				property.load(fr);
			    } catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e)
			   {
				// TODO Auto-generated catch block
				e.printStackTrace();
			   }
	}
	
	public static String getconfig(String key)
	{
		loadpropertyconfig();
		String pro=property.getProperty(key);
		return pro;
	}
}

