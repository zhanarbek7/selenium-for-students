package session;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class TutorialsNinja {
    public static void main(String[] args) throws InterruptedException {
        checkNumberOfCurrencies();
    }

    public static void checkNumberOfMenuButtons(){
        WebDriver driver = new FirefoxDriver();
        driver.get("https://tutorialsninja.com/demo/");
        List<WebElement> elements = driver.findElements(By.xpath("//nav/div/ul/li"));
        for (WebElement i: elements) {
            System.out.println(i.getText());
        }

        if(elements.size()==8){
            System.out.println("----Success, test is passed!----");
        }
        else{
            System.out.println("----Error, there are less links than 8----");
        }
    }

    public static void checkNumberOfCurrencies() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://tutorialsninja.com/demo/");
        WebElement currenciesBtn = driver.findElement(By.xpath("(//nav//button)[1]"));
        currenciesBtn.click();
        Thread.sleep(5000);

        List<WebElement> currencies = driver.findElements(By.xpath("//ul[@class='dropdown-menu']/li"));
        if(currencies.size()==3){
            System.out.println("Success, there are 3 currencies");
        }
        else{
            System.out.println("Failed!");
        }
        driver.quit();

    }

}
