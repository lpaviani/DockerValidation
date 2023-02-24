package remoteTesting.dockerValidation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.annotations.Test;

public class chromeTest1 {
@Test
public void test1() throws MalformedURLException 
{

	WebDriver driver;
	String host_url="http://localhost:4444/wd/hub";
	String app_url="http://www.google.com";
	//Setting ChromeOptions
	ChromeOptions chrome_options=new ChromeOptions();
	chrome_options.addArguments("--disable-dev-shm-usage");
    chrome_options.addArguments("--no-sandbox");
    
    //Initializing Chrome on RemoteWebDriver targeting the Docker Container
    driver = new RemoteWebDriver(new URL(host_url),chrome_options);
	driver.get(app_url);	
	//assertEquals(driver.getTitle(), "Google");
	System.out.println(driver.getTitle());
	driver.quit();
}

}
