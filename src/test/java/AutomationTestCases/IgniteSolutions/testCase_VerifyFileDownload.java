package AutomationTestCases.IgniteSolutions;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.BaseClass;

public class testCase_VerifyFileDownload extends BaseClass {
	WebDriver driver = initializeDriver();

	@BeforeTest
	public void validateTitle() {

		String cTitle = driver.getTitle();
		String title = "React App";
		assertTrue(cTitle.equalsIgnoreCase(title), "Title Matched");
		// Just a basic verification
	}

	@Test
	public void toVerifyDownloadedFile() throws InterruptedException {

		String section = "FICTION";

		driver.findElement(By.linkText(section)).click();

		String book = "The Adventures of Tom Sawyer";

		Thread.sleep(10000);

		WebElement bookToBeClickedOn = driver.findElement(By.linkText(book));

		String filePath = bookToBeClickedOn.getAttribute("href");

		bookToBeClickedOn.click();

		verifyDownloadedFile(filePath);

	}

	public void verifyDownloadedFile(String path) {
		File fileLocation = new File(downloadPath);

		File[] allFiles = fileLocation.listFiles();

		for (File file : allFiles) {
			if (path.contains(file.getName())) {
				System.out.println("File Downloaded Successfully");
				file.delete();
				break;
			}

		}
	}

	@AfterTest
	public void tearDown() {
		driver.quit();

	}
}
