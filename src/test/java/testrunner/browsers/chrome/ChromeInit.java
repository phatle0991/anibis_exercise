package testrunner.browsers.chrome;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.assertj.core.api.SoftAssertions;
import org.junit.BeforeClass;
import util.SetUp;
import util.Util;

public class ChromeInit {
    @Before
    public static void initChromeBrowser() throws Exception {
        SetUp.initDriver("Chrome");
        Util.softAssertions = new SoftAssertions();
    }
}