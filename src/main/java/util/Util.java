package util;

import org.apache.commons.io.FileUtils;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.time.LocalDateTime;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.WebDriverQuestion;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static net.serenitybdd.screenplay.matchers.ConsequenceMatchers.displays;
import static net.serenitybdd.screenplay.matchers.ReportedErrorMessages.reportsErrors;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class Util {
    public static SoftAssertions softAssertions;

    public static void printLog(String msg){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now + " " + msg);
    }

    public static void takeScreenshotAtEndOfTest(WebDriver driver, String screenshotName) {
        try {
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String currentDir = System.getProperty("user.dir");
            FileUtils.copyFile(scrFile, new File("./screenshots/" + screenshotName + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
