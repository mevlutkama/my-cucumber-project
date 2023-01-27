package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class MedunnaRoomPage {

    public MedunnaRoomPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }


}
