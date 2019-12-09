package util;

import org.apache.commons.io.FileUtils;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

import static net.serenitybdd.screenplay.questions.WebElementQuestion.the;
import static org.hamcrest.Matchers.is;

public class Util {
    public static SoftAssertions softAssertions;

    public static void printLog(String msg){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now + " " + msg);
    }

    public static String covertStrToDate (String dateStr, String format) throws Exception {
        Date currentItemDate = new SimpleDateFormat("DD.MM.YYYY").parse(dateStr);
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        String result = dateFormat.format(currentItemDate).toString();
        return result;
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
