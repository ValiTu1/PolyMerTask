package todomcv.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {

    private ConfigurationReader(){}


    private static Properties properties;

    static{

        try{

            String filePath = "configuration.properties";

            //adding the file to Java memory
            FileInputStream input = new FileInputStream(filePath);

            //creating an object of Properties class
            properties = new Properties();

            //loading the file from Java memory into property object
            properties.load(input);

            //closing the input file from Java memory
            input.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //creating get() method to retrieve values from properties object using the key
    public static String get(String key){
        return properties.getProperty(key);
    }





}
