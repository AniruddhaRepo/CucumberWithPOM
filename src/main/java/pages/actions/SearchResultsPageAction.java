package pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import pages.locators.HomePageLocators;
import pages.locators.SearchResultsPageLocators;
import utils.BaseUtils;

public class SearchResultsPageAction {
    public static WebDriver driver;
    public static String parentWindowHandle;
    public static SoftAssert softAssert = new SoftAssert();
    public static SearchResultsPageLocators searchResultsPageLocators;

    public SearchResultsPageAction(WebDriver driver) {
        this.driver = driver;
        searchResultsPageLocators = new SearchResultsPageLocators();
        PageFactory.initElements(this.driver, searchResultsPageLocators);
    }
    public static void isSearchResultsPageDisplayed()
    {
        softAssert.assertTrue(searchResultsPageLocators.bookNowBtn.isDisplayed());
    }
    public static void clickOnBookNowBtn()
    {
        parentWindowHandle=driver.getWindowHandle();
        searchResultsPageLocators.bookNowBtn.click();
    }

    public static void isEnterDetailsPageDisplayed()
    {
        BaseUtils.switchWindowAndValidateText(driver,parentWindowHandle);
    }
}
