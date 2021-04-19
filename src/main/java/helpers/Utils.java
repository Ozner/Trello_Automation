package helpers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

import static helpers.PropertiesReader.getProperty;

public class Utils {

    public static long generateRandomNumber(int digits) {
        long min = (long) Math.pow(10, digits - 1);
        return ThreadLocalRandom.current().nextLong(min, min * 10);
    }


    public static String getEnvironment(){
        String selectedEnvironment = System.getProperty("environment");
        String defaultEnvironment = getProperty("configurations","default_environment");
        if(!Arrays.asList(getProperty("configurations","availables_environments").split(",")).contains(selectedEnvironment) ||
                "".equals(selectedEnvironment) || selectedEnvironment.equals(null)) {
            return defaultEnvironment;
        } else {
            return selectedEnvironment;
        }
    }

    public static String getBrowser(){
        String selectedBrowser = System.getProperty("browser");
        String defaultBrowser = getProperty("configurations", "default_browser");

        if(!Arrays.asList(getProperty("configurations","availables_browsers").split(",")).contains(selectedBrowser) ||
                "".equals(selectedBrowser) || selectedBrowser.equals(null)) {
            return defaultBrowser;
        } else {
            return selectedBrowser;
        }
    }

    public static Boolean isHeadless(){
        String isHeadless = System.getProperty("headless");

        switch(isHeadless.toLowerCase()){
            case "true":
            case "t":
            case "1":
                return true;
            case "false":
            case "f":
            case "0":
                return false;
            default:
                return false;
        }
    }
}
