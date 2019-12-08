package testrunner.browsers.firefox;

import cucumber.api.java.Before;
import org.assertj.core.api.SoftAssertions;
import util.SetUp;
import util.Util;

public class FirefoxInit {
    @Before
    public static void initFirefoxBrowser() throws Exception{
        SetUp.initDriver("Firefox");
        Util.softAssertions = new SoftAssertions();
    }
}
