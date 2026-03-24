package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class NewsPage {
	WebDriver driver;
	PageUtility utility = new PageUtility();
	WaitUtility wait = new WaitUtility();
	public NewsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	WebElement newbutton;
	@FindBy(xpath="//textarea[@id='news']")
	WebElement textarea;
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchButton1;
	@FindBy(xpath="//input[@class='form-control']")
	WebElement newsTosearch;
	@FindBy(xpath="//button[@class='btn btn-danger btn-fix']")
	WebElement searchButton2;
	
	
	public NewsPage clickNewButtonInNewsPage()
	{
		newbutton.click();
		return this;
	}
	public NewsPage enterNewsFieldInNewsPage(String message)
	{
		textarea.sendKeys(message);
		return this;
	
	}
	public NewsPage clickSavebuttonInNewsPage()
	{
		save.click();
		return this;
	}
	public NewsPage clickOnSearchButton1InNewsPage()
	{
		searchButton1.click();
		return this;
	
	}
	public NewsPage enterTheNewsThatToBeSearched(String newstofind)
	{
		newsTosearch.sendKeys(newstofind);
		return this;
	}
	public NewsPage clickOnsearchButton2InNewsPage()
	{
		searchButton2.click();
		return this;
	}
	public boolean isSearchedNewsIsPresentInNewsPage(String expectedNews) {
		wait.waitForElementToBeVisible(driver, By.xpath("//table/tbody/tr"));
		List<WebElement> newsThatPresent = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		if (newsThatPresent.size() == 0) {   //If no rows found
			System.out.println("No user found");
			return false;
		}
		for (WebElement element : newsThatPresent) {
			String actual = element.getText().trim();
			System.out.println("Checking: " + actual);
			if (actual.equalsIgnoreCase(expectedNews)) {
				return true;

			}
		}
		return false;

	}
	
	
	

}
