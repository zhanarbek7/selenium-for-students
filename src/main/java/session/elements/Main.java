package session.elements;

import org.openqa.selenium.WebDriver;
import session.utility.Driver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Driver.getDriver();
        driver.get("https://youtube.com");

        Driver.driver=null;
        System.out.println(driver);
        System.out.println(Driver.driver);
        driver.get("https://google.com");
    }
}
