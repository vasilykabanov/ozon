package ru.kabanov.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by yasup on 27.11.2019.
 */
public class TestProperties {
    private final Properties properties = new Properties();
    private static TestProperties INSTANCE = null;

    public TestProperties() {
        try {
            //properties.load(new FileInputStream(new File("./" + System.getProperty("environment") + ".properties")));
            properties.load(new FileInputStream(new File("C:\\Users\\yasup\\Desktop\\testOzon\\environment.properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TestProperties getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new TestProperties();
        }

        return INSTANCE;
    }

    public Properties getProperties() {
        return properties;
    }
}
