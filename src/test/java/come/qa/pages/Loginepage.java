package come.qa.pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.SendKeysAction;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class Loginepage {
	
	@FindBy ( xpath=(""))
	WebElement User_ID;
	
	
	/*
	 * construter for logine
	 */
	public Loginepage(WebDriver driver)
	
	{
		PageFactory.initElements(driver, this);
	}
	
	//set User_ID
	
	public void setUser_ID(String UN)
	{
		User_ID.sendKeys(UN);
	}

	

}
