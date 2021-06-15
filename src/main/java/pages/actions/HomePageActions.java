package pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.locators.HomePageLocators;
import utils.BaseUtils;
import utils.DriverManager;

public class HomePageActions {
    public static WebDriver driver;
    public static HomePageLocators homePageLocators;

    public HomePageActions(WebDriver driver) {
        this.driver = driver;
        homePageLocators = new HomePageLocators();
        PageFactory.initElements(this.driver, homePageLocators);
    }

    public static void enterCityName(String city) {
        homePageLocators.cityTextBox.sendKeys(city);
        homePageLocators.citySuggestion.click();
    }

    public static void chooseDate() {
        try {
            //BaseUtils.explicitWait(driver, homePageLocators.datePicker);
            homePageLocators.datePicker.click();
            homePageLocators.startDate.click();
            homePageLocators.endDate.click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void clickOnSearchButton() {
        homePageLocators.searchBtn.click();
    }
}
