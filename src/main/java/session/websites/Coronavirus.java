package session.websites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Coronavirus {
    static WebDriver driver;
    public static void main(String[] args) {
        countriesLessThan2Percentage();
    }

    public static void countriesLessThan2Percentage(){

        driver = new ChromeDriver();
        driver.get("https://coronavirus.jhu.edu/data/mortality");
        List<WebElement> fatalities = driver.findElements(By.xpath("//table[1]/tbody//td[4]"));

        for (int i = 0; i < fatalities.size(); i++) {
            int j = i+1;
            String xpath = "//table[1]/tbody//tr["+j+"]/td[1]";
            String number = fatalities.get(i).getText().replace("%","");
            String countryName = driver.findElement(By.xpath(xpath)).getText();
            double percentage = Double.parseDouble(number);
            if(percentage<2){
                System.out.println("CountryName: "+countryName+", fatalities: "+percentage);
            }
        }
    }
}
