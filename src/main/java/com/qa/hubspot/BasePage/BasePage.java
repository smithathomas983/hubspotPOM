package com.qa.hubspot.BasePage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BasePage {

	public WebDriver driver;
	public Properties prop;

	public WebDriver init_Browser(String browserName) {
		if (browserName.equals("chrome")) {
			System.setProperty("webDriver.Chrome.driver", System.getProperty("user.dir")+"/scr/main/resources/drivers/chromedriver");
			if (prop.getProperty("headless").equals("yes")) {
				ChromeOptions co = new ChromeOptions();
				co.addArguments("--headless");
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}

		} else if (browserName.equals("firefox")) {
			System.setProperty("webDriver.firefox.driver", System.getProperty("user.dir")+"/scr/main/resources/drivers/geckodriver");
			if (prop.getProperty("headless").equals("yes")) {
				FirefoxBinary fb = new FirefoxBinary();
				fb.addCommandLineOptions("--headless");
				FirefoxOptions fo = new FirefoxOptions();
				fo.setBinary(fb);

				driver = new FirefoxDriver(fo);
			} else {
				driver = new FirefoxDriver();
			}
		} else {
			System.out.println(browserName + "...IS INCORRECT OR BLANK");
			try {
				throw new Exception("NO BROWSERFOUND EXCEPTION");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageloadtimeout")), TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		return driver;

	}

	public Properties init_Properties() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream(
					"C:/Users/Balu/Desktop/QA/Eclipse/Naveen/hubPOM/src/main/java/com/qa/hubspot/Config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
