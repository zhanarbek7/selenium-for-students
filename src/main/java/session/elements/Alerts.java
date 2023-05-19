package session.elements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        confirmAlert();
    }

    // ok alert
    public static void okAlert() throws InterruptedException {
            FirefoxOptions co = new FirefoxOptions();
            co.addPreference("javascript.options.showInConsole", false);
            WebDriver driver = new FirefoxDriver(co);
            driver.get("https://demoqa.com/alerts");
            driver.findElement(By.id("alertButton")).click();
            driver.switchTo().alert().accept();

            Thread.sleep(3000);
            driver.quit();
            System.out.println("No exception");
            System.out.println("Our code is working");
    }

    public static void confirmAlert() throws InterruptedException {
        FirefoxOptions co = new FirefoxOptions();
        co.addPreference("javascript.options.showInConsole", false);
        WebDriver driver = new FirefoxDriver(co);
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("confirmButton"));
        System.out.println(alertButton.getText());
        alertButton.click();

        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();


        driver.quit();
    }

    public static void promptAlert() throws InterruptedException {
        FirefoxOptions co = new FirefoxOptions();
        co.addPreference("javascript.options.showInConsole", false);
        WebDriver driver = new FirefoxDriver(co);
        driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.id("promptButton"));
        alertButton.click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
