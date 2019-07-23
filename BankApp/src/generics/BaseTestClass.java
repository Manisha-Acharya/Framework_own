package generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTestClass {
	public static WebDriver dr;
	FileLibrary fl=new FileLibrary();
	
	@BeforeTest
	public void openbrowser() throws Throwable
	{
		String brs = fl.getKeyValue("browser");
		if(brs.equalsIgnoreCase("chrome")) 
		{
		ChromeOptions cr=new ChromeOptions();
		cr.addArguments("--disable-notifications");
		dr=new ChromeDriver(cr);
		}
		else if(brs.equalsIgnoreCase("firefox"))
		{
			dr=new FirefoxDriver();
		}
		else
		{
			Reporter.log("wrong enter");
		}
		dr.get(fl.getKeyValue("url"));
		dr.manage().window().maximize();
		Thread.sleep(2000);
		dr.navigate().to("https://www.axisbank.com/");
		Thread.sleep(2000);
		dr.navigate().refresh();
		Thread.sleep(2000);
	}
	@AfterTest
	public void close()
	{
		
	}
}
