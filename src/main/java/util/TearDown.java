package util;

public class TearDown {
    public static void tearDown(){
        SetUp.driver.quit();
    }
}
