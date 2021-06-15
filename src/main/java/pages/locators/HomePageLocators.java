package pages.locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageLocators {

    @FindBy(how= How.ID,using = "autoComplete__home")
    public WebElement cityTextBox;
    @FindBy(how= How.XPATH,using = "//div[@class='d-popup geoSuggestionsList']//child::div[2]")
    public WebElement citySuggestion;

    @FindBy(how= How.XPATH,using = "//div[@class='searchContainer__wrapper']//child::div[2]")
    public WebElement datePicker;
    @FindBy(how= How.XPATH,using = "//div[@class='DateRangePicker__Month'][last()]//child::td[5]")
    public WebElement startDate;
    @FindBy(how= How.XPATH,using = "//div[@class='DateRangePicker__Month'][last()]//child::td[7]")
    public WebElement endDate;
    @FindBy(how= How.XPATH,using = "//button[contains(text(),'Search')]")
    public WebElement searchBtn;





}
