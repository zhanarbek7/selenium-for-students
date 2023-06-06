package websites;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import utility.Driver;

import java.util.Random;
import java.util.Scanner;

public class MyTesting {
    public static void main(String[] args) {
        successRegistration();
    }

    public static void successRegistration(){
        Scanner scanner = new Scanner(System.in);
        // write your code ...
        Random random = new Random();
        WebDriver driver = Driver.getDriver();
        driver.get("https://mytestingthoughts.com/Sample/home.html");
        Faker faker = Faker.instance();
        driver.findElement(By.name("first_name")).sendKeys(faker.name().firstName());
        driver.findElement(By.name("last_name")).sendKeys(faker.name().lastName());
        int randomGender = random.nextInt(1,3);
        if(randomGender==1){
            driver.findElement(By.id("inlineRadioMale")).click();
        }
        else{
            driver.findElement(By.id("inlineRadioFemale")).click();
        }
        Select hobbiesSelect = new Select(driver.findElement(By.id("exampleFormControlSelect2")));
        int firstRandomHobbies = random.nextInt(1,5);
        int secondRandomHobbies = random.nextInt(1,5);
        hobbiesSelect.selectByIndex(firstRandomHobbies);
        hobbiesSelect.selectByIndex(secondRandomHobbies);
        int randomDepartment = random.nextInt(1,10);
        Select departmentSelect = new Select(driver.findElement(By.name("department")));
        departmentSelect.selectByIndex(randomDepartment);
        String firstName = faker.name().firstName().toLowerCase();
        String lastName = faker.name().lastName().toLowerCase();
        String randomNumber = faker.random().nextInt(100, 999).toString();
        String username = firstName + lastName + randomNumber;
        driver.findElement(By.name("user_name")).sendKeys(username);
        String password = faker.internet().password(10,20);
        driver.findElement(By.name("user_password")).sendKeys(password);
        driver.findElement(By.name("confirm_password")).sendKeys(password);
        driver.findElement(By.name("email")).sendKeys(faker.internet().emailAddress());
        String additional = scanner.nextLine();
        driver.findElement(By.xpath("exampleFormControlTextarea1")).sendKeys(additional);
        driver.findElement(By.id("contact_form")).submit();
        driver.findElement(By.id("success_message"));
    }
}
