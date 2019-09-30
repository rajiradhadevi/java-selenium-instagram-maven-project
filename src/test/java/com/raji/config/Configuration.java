package com.raji.config;


import com.raji.util.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;


public class Configuration {

    public static BrowserType Browser = BrowserType.UseDefault;
    public static int TimeOut = 10;
    public static WebDriver driver = null;

    private static boolean KeepBrowserOpenAfterTestRun = false;

    public static String ScreenShotsDirectory = "./screenshots/";



    private static String DriverDirectory = "C:\\AutomationSchool\\drivers\\";

    public static WebDriver ConfigureDriver() throws Exception {

        //move these driver properties to configuration / command line in a later exercise
        //Chrome
        System.setProperty("webdriver.chrome.driver", DriverDirectory + "chromedriver"+".exe");
        //IE
        System.setProperty("webdriver.ie.driver", DriverDirectory + "IEDriverServer");
        //Firefox
        System.setProperty("webdriver.gecko.driver", DriverDirectory + "geckodriver");

        switch(Configuration.Browser) {
            case Chrome:
                driver = new ChromeDriver();
                break;
            case IE:
                driver = new InternetExplorerDriver();
                break;
            case Firefox:
                driver = new FirefoxDriver();
                break;
            default:
                //We only support Chrome, IE, Firefox. We default to Chrome
                driver = new ChromeDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(AppConfiguration.TimeOut, TimeUnit.SECONDS);
        return driver;
    }

    public static void ExitDriver() {
        if(!KeepBrowserOpenAfterTestRun && driver != null) {
            driver.close();
            driver.quit();
        }
    }
}

