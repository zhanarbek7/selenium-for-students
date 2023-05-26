package session;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().arm64().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://youtube.com");


    }


}
