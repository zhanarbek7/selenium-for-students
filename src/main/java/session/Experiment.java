package session;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Experiment {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.firefox.logfile", "/dev/null");
        WebDriver driver = new FirefoxDriver();

        System.out.println("Firefox browser is started");

        driver.get("https://www.wikipedia.org/");

        driver.findElement(By.id("searchInput")).sendKeys("Muhammed Ali", Keys.ENTER);
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.COMMAND).sendKeys("a","c").keyUp(Keys.COMMAND).perform();
        driver.get("https://wordcounter.net/");

        WebElement textArea = driver.findElement(By.xpath("//div[@id='editor_container']//span/textArea"));
        Thread.sleep(2000);

        actions.keyDown(textArea, Keys.COMMAND).sendKeys("v").keyUp(Keys.COMMAND).perform();
        String result = driver.findElement(By.xpath("//div[@id='top_counter']//h1/span"))
                .getText().trim();

        if(result.equals("25,146 words 157,518 characters")){
            System.out.println("Success, scenario is passed!");
        }
    }
}
