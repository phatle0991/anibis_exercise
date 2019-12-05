package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Drivers {
    public static WebDriver driver;

    public static void Init(String browser){
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        else if (browser.equals("IE")) {
            driver = new InternetExplorerDriver();
        }
        else if (browser.equals("safari")){
            driver = new SafariDriver();
        }
    }
}
