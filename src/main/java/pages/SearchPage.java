package pages;

import gherkin.lexer.El;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import util.Config;
import util.ElementUtils;
import util.SetUp;
import util.Util;

import java.util.List;

public class SearchPage extends PageObject{
    //Selenium Objects
    //List Category
    @FindBy(xpath = "//ul[@class='categories-list']//ul/li//span[@class='category-name']")
    private List<WebElementFacade> listCategory;

    //Location
    @FindBy(xpath = "//div[@id='ctl00_phlContent_Filter_ctlLocation_ctlLocationAutocomplete_divLocation']")
    private WebElementFacade txtLocation;
    @FindBy(xpath = "//div[@class='autocomplete-options']/ul[@id='ctl00_phlContent_Filter_ctlLocation_ctlLocationAutocomplete_ulAutocompleteOptionsList']/li")
    private List<WebElementFacade> listLocation;
    @FindBy(xpath = "//select[@id='ctl00_phlContent_Filter_ctlLocation_ddlDistance']")
    private WebElementFacade cbDistance;
    @FindBy(xpath = "//select[@id='ctl00_phlContent_Filter_ctlLocation_ddlDistance']/option")
    private List<WebElementFacade> listDistanceOptions;
    @FindBy(xpath = "//div[@data-chip-target='where']//a[@id='ctl00_phlContent_Filter_btnSearch']")
    private WebElementFacade btnApplyLocation;

    //Price
    @FindBy(xpath = "//input[@id='ctl00_phlContent_Filter_ctlPriceRange_txtFrom']")
    private WebElementFacade txtPriceFrom;
    @FindBy(xpath = "//input[@id='ctl00_phlContent_Filter_ctlPriceRange_txtTo']")
    private WebElementFacade txtPriceTo;
    @FindBy(xpath = "//div[@data-chip-target='price']//a[@id='ctl00_phlContent_Filter_btnSearch']")
    private WebElementFacade btnApplyPrice;

    //Result grid view
    @FindBy(xpath = "//ul[@class='listing-list serp-list clickable-cards']/li//li[@class='horizontal-list-item item-date']")
    private List<WebElementFacade> listSearchResultDate;
    @FindBy(xpath = "//ul[@class='listing-list serp-list clickable-cards']/li//div[@id='ctl00_phlContent_ResList_ctlDetail_ctlAdvertList_ctl01_divPrice']")
    private List<WebElementFacade> listSearchResultPrice;
    @FindBy(xpath = "//li[@class='active']//span[@class='button-text']")
    private WebElementFacade btnActivePage;
    @FindBy(xpath = "//div[@class='ghost-select sort-by-select']")
    private WebElementFacade cbSort;
    @FindBy(xpath = "//div[@class='ghost-select sort-by-select']//option")
    private List<WebElementFacade> listSortOptions;

    //Selenium Actions
    public void openSearchPage() throws Exception {
        String SEARCH_URL = Config.getProperty("searchURL");
        setDriver(SetUp.driver);
        openUrl(SEARCH_URL);
        String SEARCH_TITLE = Config.getProperty("searchTitle");
        ElementUtils.waitPageLoad(getDriver(),SEARCH_TITLE);
    }

    //Select Category
    public void selectCategoryListOption(String categoryName) throws Exception{
        ElementUtils.selectByListWebElementFacade(listCategory,categoryName,"contain");
    }

    //Location
    public void fillLocation(String location) throws Exception{
        ElementUtils.tryFill(txtLocation,location);
    }

    public void selectLocationListOption(String location) throws Exception{
        ElementUtils.selectByListWebElementFacade(listLocation,location,"equal");
    }

    public void selectDistanceListOption(String distance) throws Exception{
        ElementUtils.selectByListWebElementFacade(listDistanceOptions,distance,"equal");
    }

    public void clickApplyLocation() throws Exception{
        ElementUtils.tryClick(btnApplyLocation);
    }

    //Price
    public void fillPriceFrom(String priceFrom) throws Exception {
        ElementUtils.tryFill(txtPriceFrom,priceFrom);
    }

    public void fillPriceTo(String priceTo) throws Exception {
        ElementUtils.tryFill(txtPriceTo,priceTo);
    }

    public void clickApplyPrice() throws Exception{
        ElementUtils.tryClick(btnApplyPrice);
    }

    //Search Result
    public int getSearchResultSize() throws Exception{
        return listSearchResultDate.size();
    }

    public String getActivePageNumber() throws Exception{
        return ElementUtils.tryGetText(btnActivePage);
    }

    public void selectSort(String sortType) throws Exception{
        ElementUtils.tryClick(cbSort);
        Thread.sleep(Integer.parseInt(Config.getProperty("sleep2")));
        ElementUtils.selectByListWebElementFacade(listSortOptions,sortType,"equal");
    }

    public void verifySort(String sortType) throws Exception{
        if(sortType.equalsIgnoreCase("Plus récentes d'abord")){
            ElementUtils.verifySortResult(listSearchResultDate,sortType);
        }
        else{
            ElementUtils.verifySortResult(listSearchResultPrice,sortType);
        }
    }
}
