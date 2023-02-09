package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentalHomePage {

    public BlueRentalHomePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//a[@role='button'])[1]")
    public WebElement loginButton;
    @FindBy(id = "dropdown-basic-button")
    public WebElement userIdSection;
}
