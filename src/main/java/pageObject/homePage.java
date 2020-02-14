package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage {
	public WebDriver driver;
	
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By title=By.xpath("//*[@id=\"content\"]/div/div");
	By bar=By.xpath("//div[@class='container']/nav");
		
	
	
	public homePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public WebElement loginButton()
	{
		return driver.findElement(signin);
	}

	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement bar()
	{
		return driver.findElement(bar);
	}
}
