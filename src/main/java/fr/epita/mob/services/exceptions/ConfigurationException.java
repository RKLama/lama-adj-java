package fr.epita.mob.services.exceptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationException {

    private static ConfigurationException instance;
    private Properties properties;

    private ConfigurationException(){
    }

    public static synchronized ConfigurationException getInstance() {
        if (instance == null){
            instance = new ConfigurationException();
            Properties properties = new Properties();
            String confFile = System.getProperty("conf.file");
            try {
                properties.load(new FileInputStream(confFile));
            } catch (IOException e) {
                throw new BadConfigurationException("The file was not found at location: " + confFile);
            }
            instance.properties = properties;
        }
        return instance;
    }

    public String getDBUser(){
        return properties.getProperty("db.user");
    }

    public String getDBPassword(){
        return properties.getProperty("db.password");
    }

    public String getDBUrl(){
        return properties.getProperty("db.url");
    }


}
