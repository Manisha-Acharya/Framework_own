package pOM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.WebCommonLib;

public class BankHomePage {

	WebCommonLib wcl=new WebCommonLib();
	@FindBy(xpath="//a[@class='closeBand']//img")
	private WebElement crossbtn;
	public void closebtn()
	{
		crossbtn.click();
	}
	@FindBy(xpath="//div[@class='loginClk jsloginClk']")
	private WebElement loginbtn;
	public void login() 
	{
		wcl.visibilityofelementWait(By.xpath("//div[@class='loginClk jsloginClk']"));
		wcl.mouseHover(loginbtn);
}
	@FindBy(xpath="//div[@class='logLinks']/a[@class='hidden-xs']")
	private WebElement loginlink;
	public void loginlink()
	{
		wcl.visibilityofelementWait(By.xpath("//div[@class='logLinks']/a[@class='hidden-xs']"));
		loginlink.click();
	}
	public BankHomePage(WebDriver dr)
	{
		PageFactory.initElements(dr, this);
	}
}
