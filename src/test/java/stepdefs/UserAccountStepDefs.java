package stepdefs;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import pages.UserAccountPage;

import java.util.HashMap;
import java.util.Map;

import util.Config;
import util.*;


public class UserAccountStepDefs {
    UserAccountPage userAccountPage;

    @Then("I verify User Account Page loaded successfully")
    public void iVerifyUserAccountPageLoad() throws Exception{
        userAccountPage.verifyUserAccountPageLoad();
    }

    @Then("^I verify User Logged In information with Expected User Name = \"([^\"]*)\" and User Email = \"([^\"]*)\"$")
    public void iVerifyUserLoggedInInfo(String usrName, String usrEmail) throws Exception{
        Map<String,String> userInforMap = new HashMap<String, String>();

        //Get User Info Map. Keys: userName, userEmail
        userInforMap = userAccountPage.getUserInfo();

        //Get Current User Name, User Email
        String currentUsrName = userInforMap.get("userName");
        String currentUsrEmail = userInforMap.get("userEmail");

        //Get Expected User Name, User Email CONSTANT from config.properties
        String EXPECTED_USER_EMAIL = "";
        //In Case get data from config.properties
        if(usrEmail.equals("$validUserEmail")){
            EXPECTED_USER_EMAIL = Config.getProperty("validUsrEmail");
        }
        //In case not get data from config.properties
        else{
            EXPECTED_USER_EMAIL = usrEmail;
        }

        String EXPECTED_USER_NAME = "";
        //In Case get data from config.properties
        if(usrName.equals("$validUserName")){
            EXPECTED_USER_NAME = Config.getProperty("validUsrName");
        }
        //In case not get data from config.properties
        else{
            EXPECTED_USER_NAME = usrName;
        }

        Assert.assertEquals(EXPECTED_USER_NAME, currentUsrName);
        Assert.assertEquals(EXPECTED_USER_EMAIL, currentUsrEmail);
        Util.printLog("[INFO] Logged User Name = " + currentUsrName);
        Util.printLog("[INFO] Logged User Email = " + currentUsrEmail);
    }
}
