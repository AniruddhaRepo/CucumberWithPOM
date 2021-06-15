package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SearchResultsPageLocators {

    @FindBy(how= How.XPATH, using = "//span[contains(text(),'Book Now')]")
    public WebElement bookNowBtn;
}
