package com.pal.dataexporter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class Main {
	
	private static final Logger log = Logger.getLogger(Main.class);

    public static void main(String[] args) {
    	log.debug("log4j loaded successfully");

        Properties prop = new Properties();
        try (InputStream input = Main.class.getClassLoader().getResourceAsStream("config.properties")) {

            // load a properties file
            prop.load(input);
            String name = prop.getProperty("name");

            if (!StringUtils.isEmpty(name)) {
                System.out.println(name);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
