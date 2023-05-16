package com.websites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SeekableByteChannel;

public class Threedayrule {
    public static void main(String[] args) throws InterruptedException {
        register();
    }

    public static void register() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.threedayrule.com/");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Get Started")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='name_container']/input[1]"))
                .sendKeys("Azamat");
        driver.findElement(By.xpath("//div[@class='name_container']/input[2]"))
                .sendKeys("Baimuratov");
        Select seekingFor = new Select(driver.findElement(By.id("user_gender_seeking_gender")));
        seekingFor.selectByVisibleText("Man seeking a Woman");
        Select monthSelect = new Select(driver.findElement(By.id("user_birth_date_2i")));
        monthSelect.selectByVisibleText("Jan");
        Select daySelect = new Select(driver.findElement(By.id("user_birth_date_3i")));
        daySelect.selectByVisibleText("19");
        Select yearSelect = new Select(driver.findElement(By.id("user_birth_date_1i")));
        yearSelect.selectByVisibleText("1999");
        driver.findElement(By.id("user_authenticatable_attributes_phone")).sendKeys("7779999999");
        driver.findElement(By.id("user_zip")).sendKeys("60555");
        driver.findElement(By.id("user_occupation")).sendKeys("");
        driver.findElement(By.id("user_occupation")).sendKeys("Software Engineer in Testing");
        Select incomeSelect = new Select(driver.findElement(By.id("user_income_answer_id")));
        incomeSelect.selectByIndex(incomeSelect.getAllSelectedOptions().size());
        Select hearAboutUs = new Select(driver.findElement(By.id("user_source")));
        hearAboutUs.selectByIndex(1);
        driver.findElement(By.id("user_authenticatable_attributes_email")).sendKeys("zhanarbekabdurasulov@gmail.com");
        driver.findElement(By.id("main_signup_form")).submit();
        Select userFeet = new Select(driver.findElement(By.id("user_feet")));
        userFeet.selectByIndex(1);
        Select userInches = new Select(driver.findElement(By.id("user_inches")));
        userInches.selectByIndex(1);

    }
}
