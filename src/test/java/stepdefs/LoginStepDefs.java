package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;

import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import pages.LoginPage;
import util.*;

public class LoginStepDefs {
    @Steps
    LoginPage loginPage;

    @Given("I open Login Page")
    public void iOpenLoginPage() throws Exception {
        loginPage.openLoginPage();
    }

    @Then("I verify Login Page loaded successfully")
    public void iVerifyLoginPageLoad() throws Exception{
        String currentTitle = loginPage.getTitle();
        String EXPECTED_TITLE = Config.getProperty("loginTitle");
        //Util.softAssertions.assertThat(currentTitle).isEqualTo(expectedTitle);
        Assert.assertEquals(currentTitle,EXPECTED_TITLE);
    }

    @Then("I verify cursor is focused on User Email field")
    public void iVerifyCurrentCusor() throws Exception {
        boolean currentCursor = loginPage.getCurrentCursor();
        //Util.softAssertions.assertThat(currentCursor).isTrue();
        Assert.assertTrue("[Error] Cursor is not focused on User Email",currentCursor);
    }

    @When("^I enter User Email = \"([^\"]*)\"$")
    public void iEnterUserEmail(String usrEmail) throws Exception{
        String USER_EMAIL = "";
        //In Case get data from config.properties
        if(usrEmail.equals("$validUserEmail")){
            USER_EMAIL = Config.getProperty("validUsrEmail");
        }
        //In Case not get data from config.properties
        else {
            USER_EMAIL = usrEmail;
        }
        loginPage.fillUsrEmail(USER_EMAIL);
    }

    @When("^I enter User Password = \"([^\"]*)\"$")
    public void iEnterUserPwd(String usrPwd) throws Exception{
        String USER_PWD = "";
        //In Case get data from config.properties
        if(usrPwd.equals("$validPassword")){
            USER_PWD = Config.getProperty("validPwd");
        }
        //In Case not get data from config.properties
        else {
            USER_PWD = usrPwd;
        }
        loginPage.fillPwd(USER_PWD);
    }

    @Then("^I verify User Email error message = \"([^\"]*)\"$")
    public void iVerifyErrorMessage(String expectedErrMsg) throws Exception{
        String currentErrMsg = loginPage.getLblUsrError();
        Assert.assertEquals(expectedErrMsg,currentErrMsg);
        Util.printLog("[INFO] Verify User Email error message content passed. Current error message = " + currentErrMsg);
    }

    @Then("^I verify User Email error message = \"([^\"]*)\" color$")
    public void iVerifyErrorMessageColor(String currentErrMsg){
        if (!currentErrMsg.isEmpty()){
            String currentColor = loginPage.getLblUsrErrorColor();
            String EXPECTED_COLOR = Config.getProperty("loginErrColor");
            Assert.assertEquals(EXPECTED_COLOR,currentColor);
        }
        Util.printLog("[INFO] Verify User Email color passed");
    }

    @When("I click on Email Validation button")
    public void iClickOnBtnEmailValidation() throws Exception{
        loginPage.clickBtnEmailValidation();
    }

    @When("I click on Login button")
    public void iClickOnBtnLogin() throws Exception{
        loginPage.clickBtnLogin();
    }
}
