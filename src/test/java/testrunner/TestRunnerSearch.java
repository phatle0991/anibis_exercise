package testrunner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Drivers;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/Home.feature",  glue = {"stepdefs"})
public class TestRunnerSearch {

    @BeforeClass
    Drivers.Init()

}


