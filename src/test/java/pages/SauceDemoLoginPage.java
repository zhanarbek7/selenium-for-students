package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class SauceDemoLoginPage {

    public SauceDemoLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[.='Swag Labs']")
    public WebElement titleOfPage;

    @FindBy(id="user-name")
    public WebElement userNameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    public WebElement loginButton;
}
