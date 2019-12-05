package util;

import java.util.Properties;
import java.io.*;

public class Config {

    //load config file
    public static Properties loadConfigFile() {
        Properties prop = new Properties();
        //load config file
        FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/java"
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
    @Override
    public String getProperty(String propKeyWord) {
        String propValue = loadConfigFile().getProperty(propKeyWord);
        return propValue;
    }
}
