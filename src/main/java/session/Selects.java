package session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Selects {
    public static void main(String[] args) {
        System.setProperty("webdriver.firefox.logfile", "/dev/null");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");
        WebElement firstDrop = driver.findElement(By.xpath("//select[@id='first']"));
        Select firstDropdown = new Select(firstDrop);
        List<WebElement> firstDropdown1 = firstDropdown.getOptions();
        if(firstDropdown1.size()==4){
            System.out.println("First test passed");
            firstDropdown.selectByVisibleText("Yahoo");
        }
        else System.out.println("First test failed");

        // second part
        WebElement secondDrop = driver.findElement(By.xpath("//select[@id='animals']"));

        Select secondDropdown = new Select(secondDrop);

        List<WebElement> secondDropdown1 = secondDropdown.getOptions();
        if(secondDropdown1.size()==4){
            System.out.println("First test passed");
            secondDropdown.selectByVisibleText("Baby Cat");

        }
        else System.out.println("First test faileed");

        // third part
        List<WebElement> third = driver.findElements(By.xpath("//select[@id='second']/option"));

        if (third.size()==4){
            System.out.println("Third test passed");
            for(WebElement i: third){
                i.click();
                System.out.println(i.getText());
            }
        }
        else System.out.println("Third test failed");











    }
}
