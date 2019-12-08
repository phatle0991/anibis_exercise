/*
Element Support to prevent timed out error. Web Element actions will be re-executed until successful, except exceeded maxTries
 */
package util;

import net.serenitybdd.core.pages.WebElementFacade;

import java.text.SimpleDateFormat;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

public class ElementUtils {
    private static int MAX_TRIES = Integer.parseInt(Config.getProperty("maxTries"));
    private static int SLEEP1 = Integer.parseInt(Config.getProperty("sleep1"));
    private static int SLEEP2 = Integer.parseInt(Config.getProperty("sleep2"));
    private static int SLEEP3 = Integer.parseInt(Config.getProperty("sleep3"));

    //Try to click Web Element Facade, stop to try after maxTries times
    public static void tryClick(WebElementFacade btnClick) throws Exception {
        int count = 1;
        boolean nextTry = true;
        try {
            while(nextTry == true) {
                btnClick.waitUntilClickable();
                btnClick.click();
                Util.printLog("[INFO] Click on " + btnClick + " successfully after " + count + " times");
                Thread.sleep(SLEEP2);
                nextTry = false;
                }
            } catch (Exception e){
                Thread.sleep(SLEEP2);
                if (count == MAX_TRIES) {
                    Util.printLog("[ERROR] Clink on " + btnClick + " failed after tried " + count + " times");
                    throw e;
                }
                count++;
            }
    }

    //Try to fill Web Element Facade, stop to try after maxTries times
    public static void tryFill(WebElementFacade txtField, String text) throws Exception {
        int count = 1;
        boolean nextTry = true;
        try {
            while(nextTry == true) {
                txtField.waitUntilPresent();
                txtField.sendKeys(text);
                Thread.sleep(SLEEP1);
                Util.printLog("[INFO] Fill out " + txtField + " = " + text + " successfully after = " + count + " times");
                nextTry = false;
            }
        } catch (Exception e){
            Thread.sleep(SLEEP2);
            if (count == MAX_TRIES) {
                Util.printLog("[ERROR] Fill out " + txtField  + " = " + text + " failed after tried " + count + " times");
                throw e;
            }
            count++;
        }
    }

    //Try to get Web Element Facade text, stop to try after maxTries times
    public static String tryGetText(WebElementFacade lblField) throws Exception {
        int count = 1;
        String result ="";
        boolean nextTry = true;
        try {
            while(nextTry == true) {
                Thread.sleep(SLEEP1);
                lblField.waitUntilPresent();
                result = lblField.getText();
                Util.printLog("[INFO] Get " + lblField + " = " + result + " after "+ count + " times");
                nextTry = false;
            }
        } catch (Exception e){
            Thread.sleep(SLEEP2);
            if (count == MAX_TRIES) {
                Util.printLog("[ERROR] Get value of " + lblField + " failed after tried " + count + " times");
                throw e;
            }
            count++;
        }
        return result;
    }

    //Wait for page load, stop to try after maxTries times
    public static void waitPageLoad(WebDriver driver, String expectedTitle) throws Exception {
        int count = 1;
        boolean nextTry = true;
        while(nextTry == true){
            String currentTitle = driver.getTitle();
            Thread.sleep(SLEEP2);
            if (currentTitle.equals(expectedTitle)){
                nextTry = false;
                Util.printLog("[INFO] Page loaded successfully with title = " + expectedTitle + " after " + count + " times");
            }
            else if(count == MAX_TRIES) {
                throw new Exception("[ERROR] Waiting for title = " + expectedTitle + " failed after " + count + " times");
            }
            count++;
        }
    }

    //Wait for element present, stop to try after maxTries times
    public static void waitElementPresent(WebElementFacade elementObject) throws Exception {
        int count = 1;
        boolean nextTry = true;
        while(nextTry == true){
            try {
                elementObject.waitUntilPresent();
                Util.printLog("[INFO] Element " + elementObject + " is presented");
                nextTry = false;
            } catch (ElementClickInterceptedException e){
                Thread.sleep(SLEEP2);
                if (count == MAX_TRIES){
                    Util.printLog("[ERROR] Element " + elementObject + " is not presented after wait " + count + " times");
                    throw e;
                }
                count++;
            }
        }
    }

    //Select by list. We have 2 kind of search type: equal | contain
    public static void selectByListWebElementFacade(List<WebElementFacade> elementFacade, String option, String searchType) throws Exception {
        for(WebElementFacade element: elementFacade){
            String currentListName = element.getText();
            //In case search type = equal
            if (searchType.equalsIgnoreCase("equal")){
                if (currentListName.equalsIgnoreCase(option)) {
                    ElementUtils.tryClick(element);
                    Util.printLog("[INFO] Search type = equal. " + currentListName + " category has been selected successfully");
                    break;
                }
            }
            //In case search type = contain
            else {
                if (currentListName.contains(option)) {
                    ElementUtils.tryClick(element);
                    Util.printLog("[INFO] Search type = contain. " + currentListName + " category has been selected successfully");
                    break;
                }
            }
        }
    }

    //Verify Sort Result
    public static void verifySortResult(List<WebElementFacade> elementFacade, String sortType){
        int previousItem = 0;
        for(WebElementFacade element: elementFacade){
            String currentItemStr = element.getText();
            //In Case Date - change Date to formate YYYYYMMDD
            if(sortType.equalsIgnoreCase("Plus récentes d'abord")){
                SimpleDateFormat formatter = new SimpleDateFormat("YYYYMMDD");
                currentItemStr = formatter.format(currentItemStr);
            }
            //In Case Price
            else {
                currentItemStr = currentItemStr.replaceAll("[^0-9]", "");
            }

            int currentItem = Integer.parseInt(currentItemStr);
            if(previousItem != 0 && previousItem != currentItem) {
                if (sortType.equalsIgnoreCase("Plus récentes d'abord")) {
                    assertThat("timestamp", currentItem, greaterThan(previousItem));
                } else if (sortType.equalsIgnoreCase("Prix croissant")) {
                    assertThat("price up", currentItem, greaterThan(previousItem));
                } else if (sortType.equalsIgnoreCase("Prix décroissant")) {
                    assertThat("price down", previousItem, greaterThan(currentItem));
                }
            }
            previousItem = currentItem;
        }
        Util.printLog("[INFO] Verify sort result passed with sort mode = " + sortType);
    }
}
