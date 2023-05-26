package session.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

// This class we need to open browser and to close browser
public class Driver {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null){
            WebDriverManager.firefoxdriver().arm64().setup();
            FirefoxOptions co = new FirefoxOptions();
            co.addPreference("javascript.options.showInConsole", false);
            driver = new FirefoxDriver(co);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quit(){
        driver.quit();
    }

}
