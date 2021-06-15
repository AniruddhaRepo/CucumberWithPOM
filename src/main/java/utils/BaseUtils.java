package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pages.actions.HomePageActions;
import pages.actions.SearchResultsPageAction;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseUtils {
    public static HomePageActions homePageActions = new HomePageActions(DriverManager.getDriver());
    public static SearchResultsPageAction searchResultsPageAction = new SearchResultsPageAction(DriverManager.getDriver());
    public static WebDriverWait wait;
    public static WebDriver popup;
    public static WebElement expectedElement;
    public static SoftAssert sa = new SoftAssert();

    public BaseUtils() {

    }

    public static void implicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static void pageLoadTimeOut(WebDriver driver) {
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
    }

    public static void clearCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public static void maximizeWindow(WebDriver driver) {
        driver.manage().window().maximize();
    }

    public static void explicitWait(WebDriver driver, WebElement element) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void switchWindowAndValidateText(WebDriver driver, String parentWinHandle) {
        Set<String> child_Window = driver.getWindowHandles();
        for (String handle : child_Window) {
            if (!handle.equals(parentWinHandle)) {
                popup = driver.switchTo().window(handle);
                expectedElement = popup.findElement(By.xpath("//span[contains(text(),'Enter your details')]"));
                sa.assertTrue(expectedElement.isDisplayed(), "Application is successfully navigated to desired page");

            }

        }
    }
}
