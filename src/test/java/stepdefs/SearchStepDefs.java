package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import pages.LoginPage;
import pages.SearchPage;
import util.Config;
import util.SetUp;
import util.Util;

public class SearchStepDefs {
    @Steps
    SearchPage searchPage;

    @Given("I open Search Page")
    public void iOpenSearchPage() throws Exception{
        searchPage.openSearchPage();
    }

    @Then("I verify Search Page loaded successfully")
    public void iVerifySearchPageLoad() throws Exception{
        String currentTitle = searchPage.getTitle();
        String EXPECTED_TITLE = Config.getProperty("searchTitle");
        //Util.softAssertions.assertThat(currentTitle).isEqualTo(expectedTitle);
        Assert.assertEquals(EXPECTED_TITLE,currentTitle);
    }

    @When("^I select Search Category = \"([^\"]*)\"$")
    public void iSelectSearchCategory(String optionName) throws Exception {
        searchPage.selectCategoryListOption(optionName);
    }

    @When("^I fill out Location = \"([^\"]*)\"$")
    public void ifillOutLocation(String location) throws Exception{
        searchPage.fillLocation(location);
        searchPage.selectLocationListOption(location);
    }

    @When("^I select Distance = \"([^\"]*)\"$")
    public void iSelectDistance(String distance) throws Exception{
        searchPage.selectDistanceListOption(distance);
    }

    @When("I click on Apply Location button")
    public void iClickApplyLocationButton() throws Exception{
        searchPage.clickApplyLocation();
    }

    @When("^I fill out Price From = \"([^\"]*)\"$")
    public void iFillOutPriceFrom(String priceFrom) throws Exception{
        searchPage.fillPriceFrom(priceFrom);
    }

    @When("^I fill out Price To = \"([^\"]*)\"$")
    public void iFillOutPriceTo(String priceTo) throws Exception{
        searchPage.fillPriceTo(priceTo);
    }

    @When ("I click on Apply Price button")
    public void iClickApplyPriceButton() throws Exception {
        searchPage.clickApplyPrice();
    }

    @Then("I verify default page = 1")
    public void iVerifyDefaultPage() throws Exception{
        String currentPage = searchPage.getActivePageNumber();
        Assert.assertEquals("1",currentPage);
        Util.printLog("[INFO] Verify Default Page = 1 passed");
    }

    @Then ("I verify Search Result default items")
    public void iVerifySearchResultDefault() throws Exception{
        int currentSize = searchPage.getSearchResultSize();
        int EXPECTED_SIZE = Integer.parseInt(Config.getProperty("searchResultSize"));
        Assert.assertEquals(EXPECTED_SIZE,currentSize);
        Util.printLog("[INFO] Search Result default items = " + currentSize + " passed");
    }

    @When("^I select sort = \"([^\"]*)\"$")
    public void iSortSearchResult(String sortType) throws Exception{
        searchPage.selectSort(sortType);
        searchPage.verifySort(sortType);
    }
}
