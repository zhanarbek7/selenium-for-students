package websites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class Imdb {
    static WebDriver driver;
    public static void main(String[] args) {
        printMoviesWithRateBetween(8.5,8.8);
    }

    public static void printMoviesWithRateBetween(double low, double high){
        driver = new ChromeDriver();
        driver.get("https://www.imdb.com/chart/top");
        List<WebElement> tableHeads = driver
                .findElements(By.xpath("//div[@class='lister']/table/thead//th")); // get all tableHeaders

        for (WebElement element : tableHeads) {
            System.out.print(element.getText() + " "); // print headers one by one
        }
        System.out.println();

        List<WebElement> ratings = driver.findElements(By.xpath("//div[@class='lister']/table//td[3]")); // get all ratings
        for(int i = 0 ; i < ratings.size(); i++){
            double rating = Double.parseDouble(ratings.get(i).getText()); // converts String to double and saves

            if(rating>=low && rating<=high){
                int j = i+1; // we need this one for positions of titles in xpath
                String xpath = "(//div[@class='lister']/table//td[2]/a)"+"["+(j)+"]"; // xpath to get titles by positions
                String movieTitle = driver.findElement(By.xpath(xpath)).getText(); // get 1 title using driver find
                String movieRating = ratings.get(i).getText(); // get movie rating out of the list ratings
                System.out.println("Title: "+movieTitle + ", Rating:"+ movieRating); // print out title and rating
                System.out.println(); // new line after every movie and rating
            }
        }
    }

}
