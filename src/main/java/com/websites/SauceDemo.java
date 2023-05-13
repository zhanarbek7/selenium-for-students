package com.websites;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.List;

public class SauceDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        String url = "https://www.saucedemo.com/";
        driver.get(url);
        // to click on username input, and write username
        WebElement usernameInput = driver
                .findElement(By.name("user-name"));
        usernameInput.click();
        usernameInput.sendKeys("standard_user");
        // to click on password input, and write password
        WebElement passwordInput = driver
                .findElement(By.id("password"));
        passwordInput.click();
        passwordInput.sendKeys("secret_sauce");
        // to click on login button
        WebElement loginButton = driver
                .findElement(By.id("login-button"));
        loginButton.click();
        // we signed in

        // we found product with title
        List<WebElement> buttons = driver
                .findElements(By.xpath("//div[@class='inventory_item']//button"));
        for(int i = 0; i < 4; i++){
            buttons.get(i).click();
        }
        Thread.sleep(1500);

        WebElement cardButton = driver.findElement(By.id("shopping_cart_container"));
        cardButton.click();
        Thread.sleep(5000);
        List<WebElement> elements = driver
                .findElements(By.xpath("//div[@class='cart_list']//div[@class='cart_item']"));
        System.out.println(elements.size()==4);
        driver.close();

    }
}