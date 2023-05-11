package kg.codewise.testers.my;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.LocalDateTime;
import java.util.List;

public class TutorialsNinja {

    public static void main(String[] args) {
        chooseAllFeaturedProducts();
    }

    public static void checkNumberOfMenuButtons(){
        try{
            WebDriver driver = new FirefoxDriver();
            driver.get("https://tutorialsninja.com/demo/");
//            List<WebElement> menuElements = driver.findElements(By.cssSelector("nav#menu > div > ul > li\n"));
            List<WebElement> menuButtons = driver.findElements(By.xpath("//nav[@id='menu']/div/ul/li"));
            driver.quit();
            if(menuButtons.size()==8){
                System.out.println("Success, There are 8 menu buttons!");
            }
            else{
                throw new Exception("Number of menu buttons is not 8");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void checkNumberOfCurrencies(){
        try{
            WebDriver driver = new FirefoxDriver();
            driver.get("https://tutorialsninja.com/demo/");
            // if we don't use >, then it will look for all descendants not only to direct child
//            List<WebElement> currencyElements = driver.findElements(By.cssSelector("form#form-currency li"));
            List<WebElement> currencyElements = driver.findElements(By.xpath("//form[@id='form-currency']//li"));
            if(currencyElements.size()==3){
                System.out.println("Success, There are 3 currency options!");
            }
            else{
                throw new Exception("Number of currencies is not 3");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void checkNumberOfFeaturesProducts(){
        try{
            WebDriver driver = new FirefoxDriver();
            driver.get("https://tutorialsninja.com/demo/");
            // + div means choose immediate next sibling div, > div means choose any div child
//            List<WebElement> webElements = driver.findElements(By.cssSelector("h3[data='Featured']+ div > div"));
            List<WebElement> webElements = driver.findElements(By.xpath("//h3[.='Featured']//following-sibling::div[1]/div"));
            if(webElements.size()==3){
                System.out.println("Success, There are 4 products!");
            }
            else{
                throw new Exception("Number of products is not 4");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void registerFromMainPage(){
        try{
            WebDriver driver = new FirefoxDriver();
            driver.get("https://tutorialsninja.com/demo/");
//            WebElement myAccountButton = driver.findElement(By.cssSelector("div#top-links > span[data='My Account']"));
            WebElement myAccountButton = driver.findElement(By.xpath("//div[@id='top-links']//span[.='My Account']"));
//            WebElement registerButton = driver.findElement(By.cssSelector("div#top-links > a[data='Register']"));
            WebElement registerButton = driver.findElement(By.xpath("//div[@id='top-links']//a[.='Register']"));
            myAccountButton.click();
            registerButton.click();
            WebElement inputFirstName = driver.findElement(By.id("input-firstname"));
            WebElement inputLastName = driver.findElement(By.id("input-lastname"));
            WebElement inputEmail = driver.findElement(By.id("input-email"));
            WebElement inputTelephone = driver.findElement(By.id("input-telephone"));
            WebElement inputPassword = driver.findElement(By.id("input-password"));
            WebElement inputPasswordConfirm = driver.findElement(By.id("input-confirm"));
//            WebElement newsLetterRadioButton = driver.findElement(By.cssSelector("fieldset input[name='newsletter'][value='0']"));
            WebElement newsLetterRadioButton = driver.findElement(By.xpath("//fieldset//input[@name='newsletter' and @value='0']"));
//            WebElement agreePolicyButton = driver.findElement(By.cssSelector("div#content form div input[name='agree']"));
            WebElement agreePolicyButton = driver.findElement(By.xpath("//div[@id='content']//form/div//input[@name='agree']"));
//            WebElement continueButton = driver.findElement(By.cssSelector("div#content form div input[value='Continue']"));
            WebElement continueButton = driver.findElement(By.xpath("//div[@id='content']//form/div//input[@value='Continue']"));
            inputFirstName.sendKeys("Joe");
            inputLastName.sendKeys("Biden");
            inputEmail.sendKeys("joebiden@gmail.com"+ LocalDateTime.now().getNano());
            inputTelephone.sendKeys("1234567890");
            inputPassword.sendKeys("password123");
            inputPasswordConfirm.sendKeys("password123");
            newsLetterRadioButton.click();
            agreePolicyButton.click();
            continueButton.click();
            if(driver.getTitle().equals("Your Account Has Been Created!")){
                System.out.println("Success, Created account!");
            }
            else{
                throw new Exception();
            }
        }catch(Exception e){
            System.out.println("Unexpected exception");
        }
    }

    // not done yet
    public static void checkInvalidLoginNoEmail(){
        try{
            WebDriver driver = new FirefoxDriver();
            driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

        }catch(Exception e){
            System.out.println("Unexpected exception");
        }
    }

    // here I will have some exceptions, we will talk about it, elements became stale
    public static void chooseAllFeaturedProducts(){
        try{
            WebDriver driver = new FirefoxDriver();
            driver.get("https://tutorialsninja.com/demo/");
            List<WebElement> priceOfFeaturedProducts = driver
                    .findElements(By.xpath("//h3[.='Featured']//following-sibling::div[1]/div//p[@class='price']//span[starts-with(text(),'Ex')] "));
            for (int i = 0; i < priceOfFeaturedProducts.size(); i++) {
                priceOfFeaturedProducts = driver
                        .findElements(By.xpath("//h3[.='Featured']//following-sibling::div[1]/div//p[@class='price']//span[starts-with(text(),'Ex')] "));
                WebElement priceOfFeaturedProduct = priceOfFeaturedProducts.get(i);
                System.out.println("Current page: "+driver.getCurrentUrl());
                System.out.println("WebElement: "+priceOfFeaturedProduct);
                String text = priceOfFeaturedProduct.getText();
                text = text.substring(8);
                double priceExTax = Double.parseDouble(text);
                System.out.println(priceExTax);
                if (priceExTax < 200) {
                    int j = i+1;
                    WebElement productImage = driver.findElement(By.xpath("(//h3/following-sibling::div[1]//img)["+(j)+"]"));
                    WebElement productLink = driver.findElement(By.xpath("(//h3/following-sibling::div[1]//h4/a)["+j+"]"));
                    String productName = productLink.getText();
                    productImage.click();
                    addProductToCart(driver, productName);
                    driver.navigate().back();
                }
            }
        }catch(Exception e){
            System.out.println("Unexpected exception");
            e.printStackTrace();
        }
    }

    public static void addProductToCart(WebDriver driver, String productName){
        switch (productName){
            case "MacBook","iPhone" -> {
                WebElement element = driver.findElement(By.id("button-cart"));
                element.click();
            }
            case "Apple Cinema 30\"" -> {
                WebElement element = driver.findElement(By.xpath("//div[@id='input-option218']//input[@value=6]"));
                element.click();
            }
            case "Canon EOS 5D" -> {
                System.out.println("We are out of Canon EOS 5D");
            }
            default -> {
            }
        }
    }




}
