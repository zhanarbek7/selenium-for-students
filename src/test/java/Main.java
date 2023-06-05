import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    @Test
    public void goToGoogle(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @Test
    public void goToYoutube(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://youtube.com");
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }
    @Test
    public void goToFacebook(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://facebook.com");
        String expectedTitle = "Facebook - log in or sign up";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }


}
