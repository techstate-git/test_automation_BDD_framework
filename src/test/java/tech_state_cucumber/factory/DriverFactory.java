

/***************************************************/

package tech_state_cucumber.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import static tech_state_cucumber.constants.FrameworkConstants.BROWSER_CHROME;
import static tech_state_cucumber.constants.FrameworkConstants.BROWSER_FIREFOX;
import static tech_state_cucumber.constants.FrameworkConstants.BROWSER_SAFARI;
import static tech_state_cucumber.constants.FrameworkConstants.BROWSER_EDGE;
import static tech_state_cucumber.constants.FrameworkConstants.BROWSER_OPERA;

public class DriverFactory {

	public static WebDriver initializeDriver(String browser) {
		WebDriver driver;
//        switch (browser) {
//            case "chrome" -> {
//                WebDriverManager.chromedriver().setup();
//                driver = new ChromeDriver();
//            }
//            case "firefox" -> {
//                WebDriverManager.firefoxdriver().setup();
//                driver = new FirefoxDriver();
//            }
//            default -> throw new IllegalStateException("INVALID BROWSER: " + browser);
//        }

		switch (browser) {

		case BROWSER_CHROME: {
			System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

			// Initialize ChromeOptions
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");

			// Add any desired options to the ChromeOptions

			// Initialize ChromeDriver with ChromeOptions
			driver = new ChromeDriver(options);
			break;
		}
		case BROWSER_FIREFOX: {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		case BROWSER_SAFARI: {
			driver = new SafariDriver();
			break;
		}
		case BROWSER_EDGE: {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}
		case BROWSER_OPERA: {
			WebDriverManager.operadriver().setup();
		//	driver = new OperaDriver();
		//	break;
		}
		default:
			throw new IllegalStateException("INVALID BROWSER: " + browser);
		}
		driver.manage().window().maximize();
		return driver;
	}
}
