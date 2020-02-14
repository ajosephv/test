package work;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObject.homePage;
import resources.base;


public class titlevalidate extends base {
	public static Logger log=LogManager.getLogger(application.class.getName());
	@BeforeTest
	public void launch() throws IOException
	{
		driver=launchDriver();
		//log.info("Driver is initilized");
		driver.get(prop.getProperty("url"));
		log.info("url is opened for tittle");
	}
	
	@Test
	public void hBrowser() throws IOException
	{
	//home page
		homePage i=new homePage(driver);
		Assert.assertEquals("FEATURED COURSES",i.getTitle().getText());
		
		
		//i.loginButton().click();
		
		
	}
	
	
	@AfterTest
	public void navClose()
	{
		driver.close();
		driver=null;
	}
	
		
	}

	
	
	


