package com.amajon.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import com.amajon.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig = new ReadConfig();

	String url = readConfig.getBaseUrl();
	String browser = readConfig.getBrowser();

	public static WebDriver driver;

	@BeforeClass
	public void setup() {

		// launch browser
		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "msedge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			driver = null;
			break;

		}

		// implicit wait of 10 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// open url
		driver.get(url);
		driver.manage().window().maximize();
	}

	public void tearDown() {
		driver.close();
//		driver.quit();
	}

	// user method to capture screen shot
	public void captureScreenShot(WebDriver driver, String testName) throws IOException {
		// step1: convert webdriver object to TakesScreenshot interface
		try {
			TakesScreenshot screenshot = ((TakesScreenshot) driver);

			// step2: call getScreenshotAs method to create image file

			File src = screenshot.getScreenshotAs(OutputType.FILE);

			File dest = new File(System.getProperty("user.dir") + "//Screenshots//" + testName + ".png");

			// step3: copy image file to destination
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void implicitlyWait(int duration) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	public void goToHome() {
		driver.navigate().to("https://www.amazon.in/");
	}

	public void mouseHover(WebElement targetElement) {
		Actions actions = new Actions(driver);
		actions.moveToElement(targetElement).build().perform();
	}

	public void waitForElementToAppear(By ele, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
	}

	public void waitForElementToAppear(WebElement ele, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void waitForElementToAppear(List<WebElement> ele, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}

	public void waitForElementToDisappear(WebElement ele, int duration) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public void scrollPage(int n) {
		// To perform scroll
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, arguments[0])", n);
	}

	public void switchWindow() {
		Set<String> handle = driver.getWindowHandles();
		java.util.Iterator<String> it = handle.iterator();
		String parentId = it.next();
		System.out.println(parentId);
		String childId = it.next();
		System.out.println(childId);
		driver.switchTo().window(childId);
	}

}
