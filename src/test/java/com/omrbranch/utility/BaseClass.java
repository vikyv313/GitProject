package com.omrbranch.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.omrbranch.hooks.HooksClass;

public class BaseClass {
	Logger log = LogManager.getLogger(BaseClass.class);

	public static WebDriver driver;

	public byte[] screenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;
	}

	public static String getProjectPath() {
		String property = System.getProperty("user.dir");
		return property;
	}

	public String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "//src//test//resources//config//config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		log.info("Get valuefrom file" + value);
		return value;
	}

	public void browserLaunch(String browserType) {
		switch (browserType) {
		case "CHROME":
			driver = new ChromeDriver();
			break;
		case "EDGE":
			driver = new EdgeDriver();
			break;
		case "FIREFOX":
			driver = new FirefoxDriver();
			break;

		default:
			break;
		}
	}

	public void enterApplicationUrl(String url) {
		driver.get(url);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	public void implictlyWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public void sendKeysElement(WebElement element, String data) {
		element.sendKeys(data);
	}

	public void clickElement(WebElement element) {
		element.click();
	}

	public String getTextElement(WebElement element) {
		String text = element.getText();
		return text;
	}

	public void closeBrowser() {
		driver.quit();
	}

}
