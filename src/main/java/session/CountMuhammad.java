package session;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CountMuhammad {
    public static void main(String[] args) {
        System.setProperty("webdriver.firefox.logfile", "/dev/null");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.wikipedia.org/");
        driver.manage().window().maximize();

        WebElement webElement1 = driver.findElement(By.id("searchInput"));
        webElement1.sendKeys("Muhammed Ali");
        driver.findElement(By.xpath("//*[@class='pure-button pure-button-primary-progressive']"));

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();

        driver.get("https://wordcounter.net/");

        WebElement webElement2 = driver.findElement(By.id("box"));
        webElement2.click();
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

    }
}
