package tests;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SauceDemoLoginPage;
import utility.Config;
import utility.Driver;

public class Test1 {
    private SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();

    @Before
    public void before(){
        Driver.getDriver();
    }

    @After
    public void after(){
        Driver.quitDriver();
    }


    // happy path
    @Test
    public void loginOnSauceDemo() throws InterruptedException {
        Driver.getDriver().get(Config.getValue("url"));
        String Title = sauceDemoLoginPage.titleOfPage.getText();
        System.out.println("Invalid test title: "+ Title);

        sauceDemoLoginPage.userNameInput.sendKeys(Config.getValue("username"));
        sauceDemoLoginPage.passwordInput.sendKeys(Config.getValue("password"));
        Thread.sleep(3000);
        sauceDemoLoginPage.passwordInput.submit();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectedUrl, Driver.getDriver().getCurrentUrl());
        Thread.sleep(3000);
    }

    // invalid password - do not pass to main page
    @Test
    public void invalidPasswordLoginOnSauceDemo() throws InterruptedException {
        Driver.getDriver().get(Config.getValue("url")); // goes to saucedemo
        String Title = sauceDemoLoginPage.titleOfPage.getText();
        System.out.println("Invalid test title: "+ Title);

        sauceDemoLoginPage.userNameInput.sendKeys(Config.getValue("username"));
        sauceDemoLoginPage.passwordInput.sendKeys("invalid");
        Thread.sleep(3000);

        sauceDemoLoginPage.passwordInput.submit();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertFalse(expectedUrl.equals(Driver.getDriver().getCurrentUrl()));
        Thread.sleep(3000);
    }

    // empty login and password
    @Test
    public void emptyLoginOnSauceDemo() throws InterruptedException {
        Driver.getDriver().get(Config.getValue("url"));
        String Title = sauceDemoLoginPage.titleOfPage.getText();
        System.out.println("Invalid test title: "+ Title);
        sauceDemoLoginPage.userNameInput.sendKeys("");
        sauceDemoLoginPage.passwordInput.sendKeys("");
        Thread.sleep(3000);

        sauceDemoLoginPage.passwordInput.submit();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertFalse(expectedUrl.equals(Driver.getDriver().getCurrentUrl()));
        Thread.sleep(3000);
    }


}
