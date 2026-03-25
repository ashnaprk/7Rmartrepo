package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class PageUtility

{
	public void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectByValue(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByValue(text);
	}

	public void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}

	public void action(WebElement element) {
		Actions action = new Actions((WebDriver) element);
		action.moveToElement(element).click();
		action.doubleClick(element).click();

	}

	public void scrollToElement(WebDriver driver, WebElement element)

	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickUsingJs(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);

	}
    public void scrollByPixel(WebDriver driver,int x,int y)
    {
    	JavascriptExecutor js=(JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x,y);
    
    }
    
}
