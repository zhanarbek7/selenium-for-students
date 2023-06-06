package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public class YoutubeMainPage {
    public YoutubeMainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public WebElement searchBar;
}
