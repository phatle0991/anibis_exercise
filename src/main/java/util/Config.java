package util;

import java.util.Properties;
import java.io.*;

public class Config {

    //load config file
    public static Properties loadConfigFile() throws Exception  {
        Properties prop = new Properties();
        //load config file
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java"
                + "/config/config.properties");
        try {
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            ip.close();
        }
        return prop;
    }

    //Return property value based on input Property Keyword
    public static String getProperty(String propKeyWord){
        String propValue = null;
        try {
            propValue = loadConfigFile().getProperty(propKeyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Util.printLog("[INFO] Get property " + propKeyWord + " = " + propValue);
        return propValue;
    }
}
