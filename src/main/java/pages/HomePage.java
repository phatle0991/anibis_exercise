package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;

@DefaultUrl("https://stage.anibis.ch/fr/default.aspx")
public class HomePage{
    private WebDriver driver;

    @FindBy(xpath = "//a[@id='ctl00_Header1_ctlHeaderMetaBar_ucMainLinks_hypMyAnibis']")
    private WebElementFacade loginLink;

    //Constructor
    public HomePage (WebDriver driver){
        this.driver = driver;
        //Initialise Elements

    }

    public void verifyHomePageLoad(){

    }
}
