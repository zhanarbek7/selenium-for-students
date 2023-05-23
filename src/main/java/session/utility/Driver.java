package session.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// This class we need to open browser and to close browser
public class Driver {

    public static WebDriver driver;

    public static WebDriver getDriver(){
        if(driver==null){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quit(){
        driver.quit();
    }

}
