package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import util.Config;
import util.ElementUtils;
import util.SetUp;

import javax.swing.text.html.parser.Element;

public class LoginPage extends PageObject {
    WebDriver webDriver = SetUp.driver;

    //Selenium Objects
    @FindBy(xpath = "//input[@id='ctl00_phlContent_ctlEmailValidationBox_txtEmail']")
    private WebElementFacade txtUsrEmail;
    @FindBy(xpath = "//span[@id='ctl00_phlContent_ctlEmailValidationBox_txtEmail-error']")
    private WebElementFacade lblUsrEmailError;
    @FindBy(xpath = "//a[@id='ctl00_phlContent_ctlEmailValidationBox_lbtContinue']")
    private WebElementFacade btnEmailValidation;
    @FindBy(xpath = "//input[@id='ctl00_phlContent_txtPassword']")
    private WebElementFacade txtPwd;
    @FindBy(xpath = "//a[@id='ctl00_phlContent_btnLogin']")
    private WebElementFacade btnLogin;

    //Selenium Actions
    public void openLoginPage() throws Exception {
        String LOGIN_URL = Config.getProperty("loginURL");
        setDriver(SetUp.driver);
        openUrl(LOGIN_URL);
        String LOGIN_TITLE = Config.getProperty("loginTitle");
        ElementUtils.waitPageLoad(getDriver(),LOGIN_TITLE);
    }

    public boolean getCurrentCursor(){
        return txtUsrEmail.equals(webDriver.switchTo().activeElement());
    }

    public void fillUsrEmail(String usrEmail) throws Exception{
        ElementUtils.tryFill(txtUsrEmail,usrEmail);
    }

    public void fillPwd(String userPwd) throws Exception{
        ElementUtils.waitElementPresent(txtPwd);
        ElementUtils.tryFill(txtPwd,userPwd);
    }

    public String getLblUsrError()throws Exception{
        return ElementUtils.tryGetText(lblUsrEmailError);
    }

    public String getLblUsrErrorColor(){
        String rgbColor = lblUsrEmailError.getCssValue("color");
        return Color.fromString(rgbColor).asHex();
    }

    public void clickBtnEmailValidation() throws Exception {
        ElementUtils.tryClick(btnEmailValidation);
    }

    public void clickBtnLogin() throws Exception {
        ElementUtils.tryClick(btnLogin);
    }
}
