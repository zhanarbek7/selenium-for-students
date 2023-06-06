package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Elements {
    public static void main(String[] args)  {
        FirefoxOptions co = new FirefoxOptions();
        co.addPreference("javascript.options.showInConsole", false);
        WebDriver driver = new FirefoxDriver(co);
        driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
        WebElement imageOfIphone = driver.findElement(By.xpath("//img[@title='iPhone']"));
        // click on some link
        driver.findElement(By.linkText("Software")).click();
        // go to page of iphone
        imageOfIphone.click();
    }

    public static void readTable(){
        System.setProperty("webdriver.firefox.logfile", "NUL");
        FirefoxOptions co = new FirefoxOptions();
        co.addPreference("javascript.options.showInConsole", false);
        WebDriver driver = new FirefoxDriver(co);
        driver.get("https://chandanachaitanya.github.io/selenium-practice-site/");
        int columns = driver.findElements(By.xpath("//table[@id='BooksAuthorsTable']/tbody/tr/th")).size();
        int rows = driver.findElements(By.xpath("//table[@id='BooksAuthorsTable']/tbody/tr")).size();
        System.out.println(columns);
        System.out.println(rows);
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (i == 1) {
                    System.out.print(driver.findElement(By
                            .xpath("(//table[@id='BooksAuthorsTable']/tbody/tr["+i+"])/th["+j+"]")).getText()+" ");
                } else {
                    System.out.print(driver.findElement(
                            By.xpath("(//table[@id='BooksAuthorsTable']/tbody/tr["+i+"])/td["+j+"]")).getText()+" ");
                }
            }
            System.out.println();
        }
    }

    public static void interactWithSelect(){
        System.setProperty("webdriver.firefox.logfile", "NUL");
        FirefoxOptions co = new FirefoxOptions();
        co.addPreference("javascript.options.showInConsole", false);
        WebDriver driver = new FirefoxDriver(co);
        driver.get("https://blazedemo.com/index.php");
        WebElement selectElement = driver.findElement(By.name("fromPort"));
        Select select = new Select(selectElement);
        select.selectByIndex(select.getOptions().size()-1);
//        select.selectByVisibleText("São Paolo");
        List<WebElement> options = select.getOptions();
        for (WebElement i : options) {
            System.out.println("City: "+ i.getText()+" "+i.isSelected());
        }
    }

}
