package resources;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected String path = System.getProperty("user.dir");
	WebDriver driver;
	protected String downloadPath = path + "\\downloaded-files"; 

	public WebDriver initializeDriver() {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

		HashMap<String, Object> chromePref = new HashMap<>();
		
		chromePref.put("profile.default_content_settings.popups", 0);

		chromePref.put("download.default_directory", downloadPath); /*We are setting chrome download path so that file
																	  will be downloaded in the project irrespective of
																	  any user*/

		options.setExperimentalOption("prefs", chromePref);

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://skunkworks.ignitesol.com:3000/");

		return driver;

	}
}
