package resources;



import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver launchDriver() throws IOException
	{
     prop=new Properties();
    FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

    prop.load(fis);
    
    //mvn test -Dbrowser=chrome
    
    String browser=System.getProperty("browser");
    //String browser=prop.getProperty("browser");

   // if(browser.equals("chrome"))
    if(browser.contains("chrome"))
    {
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\chromedriver_win32\\chromedriver.exe");
	ChromeOptions options=new ChromeOptions();
	if(browser.contains("headless"))
	{
		options.addArguments("headless");  //this help us to run in headless modecmd
		
	}
	
			driver=new ChromeDriver(options);
    }

    else if(browser.equals("IE"))
    {
	System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\IEDriverServer_x64_3.150.1\\IEDriverServer.exe");
	 driver=new InternetExplorerDriver();
     }


    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    return driver;
    }
	
	
	public void getScreenshot(String result) throws IOException
	{
	File src=  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	FileUtils.copyFile(src,new File("C:\\selenium scripts\\SS\\"+result+"screenshot.png"));
	}
	
 }










