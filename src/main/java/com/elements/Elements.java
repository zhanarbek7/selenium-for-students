package com.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Elements {
    public static void main(String[] args)  {
        readTable();
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

    public static void otherElements(){

    }

}
