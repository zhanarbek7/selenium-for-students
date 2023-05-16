package com.websites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Expedia {
    public static void main(String[] args) {
        buyTicket();
    }


    public static void buyTicket(){
        try{
            System.setProperty("webdriver.firefox.logfile", "NUL");
            FirefoxOptions co = new FirefoxOptions();
            co.addPreference("javascript.options.showInConsole", false);
            WebDriver driver = new FirefoxDriver(co);
            System.out.println("Firefox browser is opened");
            driver.get("https://www.expedia.com/");
            // click on flights button
            driver.findElement(By.linkText("Flights")).click();


        }catch (Exception e){
            System.out.println("Failed to open Firefox browser");
        }


    }
}
