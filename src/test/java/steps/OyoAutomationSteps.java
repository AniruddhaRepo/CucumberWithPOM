package steps;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pages.actions.HomePageActions;
import pages.actions.SearchResultsPageAction;
import pages.locators.HomePageLocators;
import utils.DriverManager;

import java.io.IOException;

public class OyoAutomationSteps {

    @Given("user is on the oyorooms home page")
    public void user_is_on_the_oyorooms_home_page() throws IOException {

        DriverManager.setUpDriver();

    }

    @AfterStep
    public void captureScreenshots(Scenario scneario) {
        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        scneario.attach(screenshot, "image/png", "image");
    }

    @When("user enters a city name as {string}")
    public void user_enters_a_city_name_as(String cityName) {
        HomePageActions.enterCityName(cityName);

    }

    @When("user enters a date from next month")
    public void user_enters_a_date_from_next_month() {
        HomePageActions.chooseDate();

    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        HomePageActions.clickOnSearchButton();

    }

    @Then("search results should be displayed")
    public void search_results_should_be_displayed() {
        SearchResultsPageAction.isSearchResultsPageDisplayed();

    }

    @When("user clicks on Book Now button")
    public void user_clicks_on_book_now_button() {
        SearchResultsPageAction.clickOnBookNowBtn();

    }

    @Then("it should be navigated to Enter Details page")
    public void it_should_be_navigated_to_enter_details_page() {

        SearchResultsPageAction.isEnterDetailsPageDisplayed();
    }
}
