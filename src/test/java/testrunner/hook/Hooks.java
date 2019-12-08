package testrunner.hook;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import util.SetUp;
import util.Util;

public class Hooks {
    @Before(order=0)
    public void setUp1(){
        Util.printLog("----------------------------------Start of Scenario-----------------------------------");
    }

    @After(order=0)
    public void tearDown() throws Exception {
        SetUp.driver.quit();
        Util.softAssertions.assertAll();
    }
    @After(order=1)
    public void tearDown1() throws InterruptedException {
        String currentDir = System.getProperty("user.dir");
        Util.printLog("Please refer to below link for Serenity Report: " + currentDir + "/target/site/serenity/index.html");
        Util.printLog("----------------------------------End of Scenario-----------------------------------");
    }
}
