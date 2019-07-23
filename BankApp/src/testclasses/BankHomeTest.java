package testclasses;

import org.testng.Reporter;
//import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generics.BaseTestClass;
import generics.FileLibrary;


@Listeners(generics.MyListenerClass.class)
public class BankHomeTest extends BaseTestClass
{
FileLibrary fl1=new FileLibrary();
	@Test
	public void homePageTest() throws Throwable
	{
		String actresult = dr.getTitle();
		Reporter.log(actresult);
		fl1.writeCellData("Sheet1", 1, 3, actresult);
		String expresult = fl1.getCellData("Sheet1", 1, 2);
		String status = fl1.validateMsg(actresult, expresult);
		fl1.writeCellData("Sheet1", 1, 4, status);
		Thread.sleep(2000);
	}
}
