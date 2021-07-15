package AutomationTestCases.IgniteSolutions;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.BaseClass;

public class TestCase extends BaseClass {
	WebDriver driver = initializeDriver();

	@BeforeTest
	public void getURL() {
		driver.navigate().to("http://skunkworks.ignitesol.com:3000/");
	}

	@Test
	public void validateTitle() {

		String cTitle = driver.getTitle();
		String title = "React App";
		assertTrue(cTitle.equalsIgnoreCase(title), "Title Matched");
	}

	@Test
	public void getButtonCount()
	{
		List<WebElement> buttons = driver.findElements(By.xpath("//span[@class='MuiButton-label']"));
		System.out.println(buttons.size());
	}
}
