package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility 

{
	public void selectByIndex(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void selectByValue(WebElement element)
	{
		Select select=new Select(element);
		select.selectByValue(null);
	}
	public void selectByVisibleText(WebElement element)
	{
		Select select=new Select(element);
		select.selectByVisibleText(null);
		
	}
	public void action(WebElement element)
	{ 
		Actions action=new Actions((WebDriver) element);
		action.moveToElement(element).click();
		action.doubleClick(element).click();
		
	}
	 public void scrollDown(WebDriver driver,WebElement element)
	{
		
		JavascriptExecutor javascript=(JavascriptExecutor) driver;
		javascript.executeScript("arguments[0].click();", element);
	}

}
