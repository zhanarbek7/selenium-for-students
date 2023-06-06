package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class UploadNDownload {
    public static void main(String[] args) throws InterruptedException {
    }

    public static void upload() throws InterruptedException {
        FirefoxOptions co = new FirefoxOptions();
        co.addPreference("javascript.options.showInConsole", false);
        WebDriver driver = new FirefoxDriver(co);
        driver.get("http://the-internet.herokuapp.com/upload");
        WebElement fileInput = driver.findElement(By.id("file-upload"));

        fileInput.sendKeys("/Users/zhanarbekabdurasulov/Desktop/file.txt");
        fileInput.sendKeys("/Users/zhanarbekabdurasulov/Desktop/file.txt");

        // Click the Upload button to submit the file
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();

        // Wait for the upload process to complete or handle any resulting actions
        Thread.sleep(5000);
        driver.quit();

    }

    public static void download() throws InterruptedException{
        FirefoxOptions co = new FirefoxOptions();
        co.addPreference("javascript.options.showInConsole", false);
        WebDriver driver = new FirefoxDriver(co);
        driver.get("http://the-internet.herokuapp.com/download");

        // Find link of downloading file
        WebElement fileDownloadLink = driver.findElement(By.linkText("photo.png"));

        // Start of downloading
        fileDownloadLink.click();

        Thread.sleep(5000);
        driver.quit();
    }


}
