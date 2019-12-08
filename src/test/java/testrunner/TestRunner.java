package testrunner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/features/Search.feature"},  glue = {"stepdefs","testrunner.hook","testrunner.browsers.chrome"})
public class TestRunner {
}

