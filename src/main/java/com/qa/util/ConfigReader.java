package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    /**
     * This method will load the contents of config properties file
     * @return Properties
     */
    public Properties init_properties() {
        prop = new Properties();

        try {
            FileInputStream fis = null;
            fis = new FileInputStream("src/test/resources/config/config.properties");

            prop.load(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return prop;


    }
}
