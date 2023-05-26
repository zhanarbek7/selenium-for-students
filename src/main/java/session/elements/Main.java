package session.elements;

import org.openqa.selenium.WebDriver;
import session.utility.Driver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://youtube.com");
        driver.quit();
    }
}
