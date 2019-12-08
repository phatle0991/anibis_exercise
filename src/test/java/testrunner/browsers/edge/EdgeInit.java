package testrunner.browsers.edge;

import cucumber.api.java.Before;
import org.assertj.core.api.SoftAssertions;
import util.SetUp;
import util.Util;

public class EdgeInit {
    @Before
    public static void initEdgeBrowser() throws Exception{
        SetUp.initDriver("Edge");
        Util.softAssertions = new SoftAssertions();
    }
}
