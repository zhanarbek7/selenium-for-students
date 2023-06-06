package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

public class Iframe {
    public static void main(String[] args) {

    }
    public void iframe1() throws InterruptedException {
        FirefoxOptions co = new FirefoxOptions();
        co.addPreference("javascript.options.showInConsole", false);
        WebDriver driver = new FirefoxDriver(co);

        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
        driver.findElement(By.id("name")).sendKeys("Hello");
        driver.switchTo().frame("frm1");
        Select coursesSelect = new Select(driver.findElement(By.id("course")));
        coursesSelect.selectByVisibleText("Java");
        driver.switchTo().defaultContent();
        WebElement name = driver.findElement(By.id("name"));
        name.clear();
        name.sendKeys("World");
    }

    public void iframe2(){
        FirefoxOptions co = new FirefoxOptions();
        co.addPreference("javascript.options.showInConsole", false);
        WebDriver driver = new FirefoxDriver(co);
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");


        driver.switchTo().frame("frm3");
        driver.switchTo().frame("frm1");
        Select courseSelect = new Select(driver.findElement(By.id("course")));
        courseSelect.selectByVisibleText("Java");
        driver.switchTo().parentFrame();
        driver.findElement(By.id("name")).sendKeys("Zhaanrbek");;
        driver.switchTo().defaultContent();
        driver.findElement(By.id("name")).sendKeys("Abdurasul");
    }
}
