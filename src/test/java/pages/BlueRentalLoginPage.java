package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentalLoginPage {

    public BlueRentalLoginPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "formBasicEmail")
    public WebElement emailInput;

    @FindBy(id = "formBasicPassword")
    public WebElement passwordInput;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement loginSubmitButton;

}
