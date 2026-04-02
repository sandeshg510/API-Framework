package com.sandesh.api.utils;

import com.sandesh.api.constants.FrameworkConstants;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private ConfigReader() {}

    private static Properties properties;

    static {
        properties=new Properties();

        try {
            FileInputStream fis=new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config file",e);
        }
    }

    public static String get(String key){
        String value=properties.getProperty(key);
        if(value==null){
            throw new RuntimeException("Missing key"+key);
        }
        return value;
    }

}
