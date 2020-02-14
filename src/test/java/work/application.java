package work;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.homePage;
import pageObject.loginPage;
import resources.base;


public class application extends base {
	
	//public static Logger log=LogManager.getLogger(application.class.getName());
	public static Logger log =LogManager.getLogger(base.class.getName());

@BeforeTest
public void launch() throws IOException
{
	driver=launchDriver();
	log.info("driver initialised");
	//log.info("Driver is initilized");
}
	
	
	@Test(dataProvider="getData")
	public void openBrowser(String User,String Password,String text) throws IOException
	{
		
		driver.get(prop.getProperty("url"));
		log.info("url opened");
		//log.info("url is opened");
	//home page
		homePage i=new homePage(driver);
		
		//homePage i=new homePage(driver);
		Assert.assertEquals("FEATURED COURSES",i.getTitle().getText());
		log.info("value matches");
		//log.info("title is correct");
		Assert.assertTrue(i.bar().isDisplayed());
		//log.info("title bara are available");
		
		i.loginButton().click();
		
		//login page
		loginPage o=new loginPage(driver);
		o.getEmail().sendKeys(User);
		log.info("user ID entered");
		o.getPassword().sendKeys(hello);
		System.out.println(text);
		o.getLogin().click();
	}
	

	// wbhen dealign with array always start with 0	
	@DataProvider
		public Object[][] getData()
		{
			Object[][] data=new Object[2][3];
			data[0][0]="abc@qw.com";
			data[0][1]="12345634324243234323";
			data[0][2]="non restricted user";
			
			data[1][0]="restricted.com";
			data[1][1]="312323";
			data[1][2]="restricted user";
			return data;	
		}
	
	@AfterTest
	public void navClose()
	{
		driver.close();
		driver=null;
	}
	}

	
	
	


