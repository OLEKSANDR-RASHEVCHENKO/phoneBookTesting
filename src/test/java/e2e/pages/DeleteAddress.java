package e2e.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DeleteAddress extends AddressesInfoPage {

    public DeleteAddress(WebDriver driver) {
        super(driver);
    }

    public void removeAddress() {
        optionDropDown.click();
        WebElement removeButton = null;
        getWait().forVisibility(removeButton);
        removeButton.click();
        getWait().forInvisibility(removeButton);
    }


}
