package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import util.Config;
import util.ElementUtils;
import util.SetUp;

public class HomePage extends PageObject {
    @FindBy(xpath = "//a[@id='ctl00_Header1_ctlHeaderMetaBar_ucMainLinks_hypMyAnibis']")
    private WebElementFacade linkLogin;
    @FindBy(xpath = "//a[@id='ctl00_Header1_ctlHeaderMetaBar_ucMainLinks_hypMyAnibis']/font/font")
    private WebElementFacade linkUserLoggedIn;
    @FindBy(xpath = "//a[@id='ctl00_phlContent_ctlHeaderSearchFilter_ctlKeywordAutocomplete_btnSearch']")
    private WebElementFacade btnSearch;


    public void navToHomePage() throws Exception {
        String HOME_URL = Config.getProperty("homeURL");
        setDriver(SetUp.driver);
        openUrl(HOME_URL);
        String HOME_TITLE = Config.getProperty("homeTitle");
        ElementUtils.waitPageLoad(getDriver(),HOME_TITLE);
    }

    public void navigateToLoginPage() throws Exception {
        ElementUtils.tryClick(linkLogin);
    }

    public void navigateToUserDefaultPage() throws Exception{
        ElementUtils.tryClick(linkUserLoggedIn);
    }

    public void clickBtnSearch() throws Exception{
        ElementUtils.tryClick(btnSearch);
    }
}
