package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchResultsPage {
	
	WebDriver driver;
	private ElementUtils elementUtils;
	
	public SearchResultsPage(WebDriver driver)
	{
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils= new ElementUtils(driver);		
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement productStatus;
	
	@FindBy(xpath="//input[@id='button-search']/following-sibling::p")
	private WebElement productNotAvailableMessage;
	
	public boolean displayProductStatus()
	{
		return elementUtils.displayStatusOfElement(productStatus, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);		
		
	}
	
	public String  noProductMatch()
	{
		return elementUtils.getTextFromElement(productNotAvailableMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);		
		
	}

}
