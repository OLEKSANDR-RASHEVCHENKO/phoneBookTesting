package e2e.pages;

import org.openqa.selenium.WebDriver;

public class DeleteAddress extends AddressesInfoPage {

    public DeleteAddress(WebDriver driver) {
        super(driver);
    }

    public void removeAddress() {
        optionDropDown.click();
        getWait().forVisibility(removeButton);
        removeButton.click();
        getWait().forInvisibility(removeButton);
    }
}
