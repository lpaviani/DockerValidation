package remoteTesting.dockerValidation;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class chromeStandAloneTest {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		//DOCKER
		//docker run -d -p 4444:4444 -p 7900:7900 --shm-size="2g" selenium/standalone-chrome:latest
		// **** Check the following URL to see visualize the execution : http://localhost:7900/?autoconnect=1&resize=scale&password=secret ****//		
		
		//RemoteWebDriver for remote running
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
