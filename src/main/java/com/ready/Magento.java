package com.ready;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.List;

public class Magento {
    public static void main(String[] args) throws InterruptedException {
        findProductWithGoodRating();
    }

    public static void findProductWithGoodRating() throws InterruptedException {
        System.setProperty("webdriver.firefox.logfile", "NUL");
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("javascript.options.showInConsole", false);
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://magento.softwaretestingboard.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='ui-id-2']/li[3]")).click();
        driver.findElement(By.xpath("//main/div[last()]/div[1]//strong[.='Luma tees']")).click();
        List<WebElement> prices;
        List<WebElement> imagesToClickOn = driver
                .findElements(By.xpath("//div[@class='column main']//li//img"));
        int numberOfAddedTees = 0;
        for (int i = 0; i < imagesToClickOn.size();i++){
            prices = driver.findElements(By.xpath("//div[@class='column main']//li//span[contains(@id, 'p')]/span"));
            imagesToClickOn = driver.findElements(By.xpath("//div[@class='column main']//li//img"));
            double price = Double.parseDouble(prices.get(i).getText().substring(1));
            if(price > 30){
                numberOfAddedTees++;
                imagesToClickOn.get(i).click();
                Thread.sleep(1200);
                driver.findElement(By.xpath("((//div[@class='fieldset'])[1]//div[@index='0'])[1]")).click();
                driver.findElement(By.xpath("((//div[@class='fieldset'])[1]//div[@index='0'])[2]")).click();
                driver.findElement(By.id("product-addtocart-button")).click();
                driver.navigate().back();
                driver.navigate().back();
            }
            Thread.sleep(500);
        }
        String numberOfAdded = driver
                .findElement(By.xpath("//div[@class='minicart-wrapper']/a/span[2]/span")).getText();
        if(Integer.parseInt(numberOfAdded)==numberOfAddedTees){
            System.out.println("Success, added our tees to cart!");
        }
        else{
            System.out.println("Failed");
        }

    }
}
