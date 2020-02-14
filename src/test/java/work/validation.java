package work;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.homePage;
import resources.base;

public class validation extends base 
{
	//public static Logger log=LogManager.getLogger(application.class.getName());	
	//adding logs
	//generating html report
	//screenshots of failiure
	//jenkins integration
	
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void launch() throws IOException
	{
		driver=launchDriver();
		driver.get(prop.getProperty("url"));
		log.info("url entered for validation");
	}
	
	@Test
	public void oBrowser()
	{
		homePage i=new homePage(driver);
		Assert.assertEquals("FEATURED COURSES",i.getTitle().getText());
		Assert.assertTrue(i.bar().isDisplayed());
		log.info("success");
		//log.info("displayed");
		i.loginButton().click();
	}
	
	
	@AfterTest
	public void clear()
	{
		driver.close();
		driver=null;
	}
	
	
	}
	
	
		
	




	
	
	


