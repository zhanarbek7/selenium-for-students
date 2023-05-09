package kg.codewise.testers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("1");
        WebDriver driver = new FirefoxDriver();
        System.out.println("2");
        driver.manage().window().maximize();
        System.out.println("3");
        driver.get("https://youtube.com/");
        System.out.println("4");
        WebElement play = driver.findElement(By.xpath("//yt-formatted-string[@title='Unstoppable']"));
        System.out.println("5");
        play.click();

//        String url = "https://www.saucedemo.com/";
//        chromeDriver.get(url);
//        // to click on username input, and write username
//        WebElement usernameInput = chromeDriver
//                .findElement(By.name("user-name"));
//        usernameInput.click();
//        usernameInput.sendKeys("standard_user");
//        // to click on password input, and write password
//        WebElement passwordInput = chromeDriver
//                .findElement(By.id("password"));
//        passwordInput.click();
//        passwordInput.sendKeys("secret_sauce");
//        // to click on login button
//        WebElement loginButton = chromeDriver
//                .findElement(By.id("login-button"));
//        loginButton.click();
//        // we signed in
//
//        // we found product with title
//        List<WebElement> buttons = chromeDriver
//                .findElements(By.xpath("//div[@class='inventory_item']//button"));
//        for(int i = 0; i < 4; i++){
//            buttons.get(i).click();
//        }
//        Thread.sleep(1500);
//
//        WebElement cardButton = chromeDriver.findElement(By.id("shopping_cart_container"));
//        cardButton.click();
//        Thread.sleep(5000);
//        List<WebElement> elements = chromeDriver
//                .findElements(By.xpath("//div[@class='cart_list']//div[@class='cart_item']"));
//        System.out.println(elements.size()==4);
//        chromeDriver.close();

    }
}