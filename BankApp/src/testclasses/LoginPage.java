package testclasses;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generics.BaseTestClass;
import generics.FileLibrary;
import generics.WebCommonLib;
import pOM.BankHomePage;

@Listeners(generics.MyListenerClass.class)
public class LoginPage extends BaseTestClass {
	WebCommonLib wcl=new WebCommonLib();
	FileLibrary fl1=new FileLibrary();
	@Test
	public void loginpage() throws Throwable
	{
		BankHomePage bhp=new BankHomePage(dr);
		bhp.closebtn();
		bhp.login();
		bhp.loginlink();
		
		String actresult=dr.getTitle();
		Reporter.log(actresult);
		fl1.writeCellData("Sheet1", 2, 3, actresult);
		String expresult = fl1.getCellData("Sheet1", 2, 2);
		String status = fl1.validateMsg(actresult, expresult);
		fl1.writeCellData("Sheet1", 2, 4, status);
	
	}
	
}
