package kg.codewise.testers.my;

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
        System.setProperty("webdriver.firefox.logfile", "NUL"); // On Windows
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("javascript.options.showInConsole", false);
        options.addPreference("javascript.enabled", false);
        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://magento.softwaretestingboard.com/men/tops-men/tees-men.html");
        List<WebElement> prices = driver
                .findElements(By.xpath("//div[@class='column main']//li//span[contains(@id, 'p')]/span"));
        List<WebElement> imagesToClickOn = driver
                .findElements(By.xpath("//div[@class='column main']//li//img"));
        for (int i = 0; i < imagesToClickOn.size();i++){
            double price = Double.parseDouble(prices.get(i).getText().substring(1));
            if(price > 30){
                imagesToClickOn.get(i).click();
//                WebElement =
            }
        }


    }
}
