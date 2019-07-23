package generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebCommonLib extends BaseTestClass{

	public void implicitWait()
	{
		dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	public void explicitwait1(By locator)
	{
		WebDriverWait wait=new WebDriverWait(dr, 10);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void visibilityofelementWait(By locator)
	{
		WebDriverWait wait=new WebDriverWait(dr, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	public void getTitlewait(String title)
	{
		WebDriverWait wait=new WebDriverWait(dr, 10);
		wait.until(ExpectedConditions.titleContains(title));
	}
	public void selectText(WebElement address,String text)
	{
		Select sel=new Select(address);
		sel.selectByVisibleText(text);
	}
	public void selectValue(WebElement address,String value)
	{
		Select sel=new Select(address);
		sel.selectByValue(value);;
	}
	public void mouseHover(WebElement target)
	{
		Actions act=new Actions(dr);
		act.moveToElement(target);
	}
	
}
