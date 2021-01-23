package config;

import org.apache.commons.lang3.StringUtils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ApplicationConfiguration {

    public static ApplicationConfiguration instance = new ApplicationConfiguration();
    public static Properties configuration;

    public ApplicationConfiguration() {
        loadConfiguration();
    }

    private void loadConfiguration() {
        Properties props = new Properties();
        FileInputStream inputStream = null;
        String configFileName = "target/classes/config.properties";
        try {
            inputStream = new FileInputStream(configFileName);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Could not get config file.", e);
        }

        try {
            props.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file: " + configFileName, e);
        }
        configuration = (Properties) props.clone();
    }

    public String getStringNotNull(String name) {
        String result = configuration.getProperty(name);
        result = StringUtils.trimToNull(result);
        if (StringUtils.isEmpty(result)) {
            throw new RuntimeException("Please specify property with name: " + name);
        }
        return result;
    }
}
