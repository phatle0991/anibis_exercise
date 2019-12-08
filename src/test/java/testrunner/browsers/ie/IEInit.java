package testrunner.browsers.ie;

import cucumber.api.java.Before;
import org.assertj.core.api.SoftAssertions;
import util.SetUp;
import util.Util;

public class IEInit {
    @Before
    public static void initIEBrowser() throws Exception{
        SetUp.initDriver("IE");
        Util.softAssertions = new SoftAssertions();
    }
}
