package common;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {

	public static String url = "https://www.united.com/ual/en/us/";
	public static WebDriver driver;
	private static String projectPath;
	public static JFrame frame;	
	
	public PageBase() {
		
		File currentDirectory = new File(".");
		projectPath = currentDirectory.getAbsolutePath();
		
		
	}
	
	public static void setUpDriver() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", projectPath + "\\chromedriver.exe");
		    
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-extensions");
		options.addArguments("disable-infobars");  // With chromedriver 2.28, there's an info bar that we don't want to have when browser is launched
		
		driver = new ChromeDriver(options);		
		
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		
	}
	
	
	public static void waitForElementPresent(By by, int seconds) {
		
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		
	}

}
