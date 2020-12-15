package sberbank.mortgage.freamwork.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static sberbank.mortgage.freamwork.util.PropertiesConstants.PATH_CHROME_DRIVER;

public class DriverManagers {

    private static WebDriver driver;

    private DriverManagers() {
    }

    private static TestPropManager props = TestPropManager.getTestPropManager();

    public static WebDriver getDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    private static void initDriver() {
        System.setProperty("webdriver.chrome.driver", props.getProperty(PATH_CHROME_DRIVER));
        driver = new ChromeDriver();
    }


    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
