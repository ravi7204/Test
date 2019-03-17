package com.pagelibrary.com.ranford;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//@org.testng.annotations.Parameters



//import com.relevantcodes.extentreports.LogStatus;

import EXcel.Excel_class;


public class TestExecution extends Repository {
	
	
	@Parameters({"browser"})
	@Test(priority=1) 
	
	public void verify_lauch(String browser)//For TestNg execution
	{
		launch(browser);
	}
	/*@Test(priority=1) 
	public void verify_lauch()
	{
		launch();
	}*/
	
	@Test(priority=2)
	public void verify_login()
	{
		login();// Keyword driven
			/*Excel_class.excelconnection("data.xls", "login");
			Excel_class.outputexcelconnection("data.xls", "output.xls", "login");
			for(int r=1;r<Excel_class.rcount();r++)
			{
				     String username= Excel_class.readdata(0, r);
				     String pass=Excel_class.readdata(1, r);
				      login(username,pass);
				
				String actualtittle=driver.getTitle();
				if(actualtittle.contains("KEXKIM BANK"))
				{
					Excel_class.writedata(2, r, "Test Failed");
				}
				else if(actualtittle.contains("Ranford Bank"))
				{
					Excel_class.writedata(2, r, "Test Passed");
				}
				else
				{
					Excel_class.writedata(2, r, "Operation is failed");
				}
			}
			Excel_class.saveworkbook();*/
			
		}
	
	@Test(priority=3)
	public void verify_newbranch() throws InterruptedException
	{
		//newbranch();
		Excel_class.excelconnection("branch.xls", "branches");
		Excel_class.outputexcelconnection("branch.xls", "output1.xls", "branches");
		for(int r=1;r<Excel_class.rcount();r++)
		{
			     String branchname= Excel_class.readdata(0, r);
			     String address1=Excel_class.readdata(1, r);
			     //String address2=Excel_class.readdata(2, r);
			     //String address3=Excel_class.readdata(3, r);
			     //String area=Excel_class.readdata(4, r);
			         //int zipcode=  Integer.parseInt(Excel_class.readdata(5, r));
			     String zipcode=Excel_class.readdata(5, r);
			     
			      newbranch(branchname,address1,zipcode);
			
			String actualtittle=driver.getTitle();
			if(actualtittle.contains("New Branch with id"))
			{
				Excel_class.writedata(2, r, "Test Failed");
				
				//test.log(LogStatus.PASS, "");
			}
			else if(actualtittle.contains("Ranford Bank"))
			{
				Excel_class.writedata(2, r, "Test Passed");
				//test.log(LogStatus.FAIL, details);
			}
			else
			{
				Excel_class.writedata(2, r, "Operation is failed");
			}
		}
		Excel_class.saveworkbook();
		
	}

	@Test(priority=4)
	public void verify_newroles()
	{
		
		Excel_class.excelconnection("rol.xls", "roles");
		Excel_class.outputexcelconnection("rol.xls", "output2.xls", "roles");
		for(int r=1;r<Excel_class.rcount();r++)
		{
			     String rolename= Excel_class.readdata(0, r);
			     String roledesc=Excel_class.readdata(1, r);
			     //String address2=Excel_class.readdata(2, r);
			     //String address3=Excel_class.readdata(3, r);
			     //String area=Excel_class.readdata(4, r);
			     //String zipcode=Excel_class.readdata(5, r);
			     
			      newroles(rolename,roledesc);
			
			String actualtittle=driver.getTitle();
			if(actualtittle.contains("KEXKIM BANK"))
			{
				Excel_class.writedata(2, r, "Test Failed");
			}
			else if(actualtittle.contains("New Role with id"))
			{
				Excel_class.writedata(2, r, "Test Passed");
			}
			else
			{
				Excel_class.writedata(2, r, "Operation is failed");
			}
		}
		Excel_class.saveworkbook();
		
	}
}
