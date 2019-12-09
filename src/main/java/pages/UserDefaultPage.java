package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import util.ElementUtils;

public class UserDefaultPage extends PageObject {
    @FindBy(xpath = "//div[@id='ctl00_Header1_ctlHeaderActionBar_ctlMemberNavigation_divHeaderMenu']" +
            "//a[@href[starts-with(.,'https://stage.anibis.ch/member/profile')]]")
    private WebElementFacade linkMyAccountPage;

    public void navigateToMyAccountPage() throws Exception{
        ElementUtils.tryClick(linkMyAccountPage);
    }

    public void verifyMyAccountPageLoaded() throws Exception{
        ElementUtils.waitElementPresent(linkMyAccountPage);
    }
}
