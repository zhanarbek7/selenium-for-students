package kg.codewise.testers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //https://github.com
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        String url = "https://www.google.com";
        chromeDriver.get(url);
        chromeDriver.navigate().refresh();
        Thread.sleep(10000);
        chromeDriver.close();

    }
}