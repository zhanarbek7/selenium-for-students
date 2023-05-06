package kg.codewise.testers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        String url = "https://www.saucedemo.com/";
        chromeDriver.get(url);

        // to click on username input, and write username
        WebElement usernameInput = chromeDriver
                .findElement(By.xpath("//input[@id='user-name']"));
        usernameInput.click();
        usernameInput.sendKeys("standard_user");

        Thread.sleep(5000);

        // to click on password input, and write password
        WebElement passwordInput = chromeDriver
                .findElement(By.xpath("//input[@id='password']"));
        passwordInput.click();
        passwordInput.sendKeys("secret_sauce");

        Thread.sleep(5000);


        // to click on login button
        WebElement loginButton = chromeDriver
                .findElement(By.xpath("//input[@name='login-button']"));
        loginButton.click();

        Thread.sleep(5000);

        chromeDriver.close();

    }
}