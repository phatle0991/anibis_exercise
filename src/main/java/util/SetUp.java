package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class SetUp {
    public static WebDriver driver;

    public static WebDriver setup(String browser) throws Exception{
        //Check if parameter passed from TestNG is 'chrome'
        if(browser.equalsIgnoreCase("Chrome")){
            String version = util.Config.getProperty("chromeDriverVersion");
            WebDriverManager.chromedriver().version(version).setup();
            driver = new ChromeDriver();
        }
        //Check if parameter passed as 'firefox'
        else if(browser.equalsIgnoreCase("Firefox")){
            String version = util.Config.getProperty("firefoxDriverVersion");
            WebDriverManager.firefoxdriver().version(version).setup();
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'Edge'
        else if(browser.equalsIgnoreCase("Edge")){
            String version = util.Config.getProperty("edgeDriverVersion");
            WebDriverManager.edgedriver().version(version).setup();
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("IE")){
            String version = util.Config.getProperty("ieDriverVersion");
            WebDriverManager.iedriver().version(version).setup();
            driver = new InternetExplorerDriver();
        }
        else{
            //If no browser passed throw exception
            throw new Exception("Browser is not correct");
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
