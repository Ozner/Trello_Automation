package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import java.util.Arrays;

import static helpers.PropertiesReader.*;
import static helpers.DriverManager.*;

//@Listeners({helpers.ListenerFailure.class})
public class BaseTest {

    public WebDriver driver;

    String user1 = getProperty("data","user");
    String pass1 = getProperty("data","pass");
    String userName = getProperty("data","userName");

    @BeforeMethod
    public void before() {
        try {
            setDriver(getBrowser(), isHeadless());
            driver = getDriver();
            String url_application = getProperty("configurations", "url-" + getEnvironment());
            driver.get(url_application);
        } catch (Exception ex) {
            System.out.println("ERROR BEFORE: " + ex);
        }

    }

    @AfterMethod
    public void after() {
        try {
            if (driver != null) {
                driver.quit();
            }
            if(getBrowser().equals("firefox")) {
                Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe /T");
                Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
                Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe /T");
            }
        } catch(Exception ex){
            System.out.println("ERROR AFTER METHOD: " + ex);
        }
    }

    public String getEnvironment(){
        String selectedEnvironment = System.getProperty("environment");
        String defaultEnvironment = getProperty("configurations","default_environment");
        if(!Arrays.asList(getProperty("configurations","availables_environments").split(",")).contains(selectedEnvironment) ||
                "".equals(selectedEnvironment) || selectedEnvironment.equals(null)) {
            return defaultEnvironment;
        } else {
            return selectedEnvironment;
        }
    }

    public String getBrowser(){
        String selectedBrowser = System.getProperty("browser");
        String defaultBrowser = getProperty("configurations", "default_browser");

        if(!Arrays.asList(getProperty("configurations","availables_browsers").split(",")).contains(selectedBrowser) ||
                "".equals(selectedBrowser) || selectedBrowser.equals(null)) {
            return defaultBrowser;
        } else {
            return selectedBrowser;
        }
    }

    public Boolean isHeadless(){
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
