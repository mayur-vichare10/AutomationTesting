package resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected String path = System.getProperty("user.dir");
	WebDriver driver;

	public WebDriver initializeDriver() {

		Properties prop = new Properties();
		try {
			InputStream file = new FileInputStream(path + "/configuration/config.properties");
			prop.load(file);
		} catch (IOException e) {
			System.out.println("File Exception Occured : " + e);
		}
		String bname = prop.getProperty("browser");

		if (bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (bname.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("No browser input in config file");
		}

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.navigate().to("http://skunkworks.ignitesol.com:3000/");

		return driver;

	}
}
