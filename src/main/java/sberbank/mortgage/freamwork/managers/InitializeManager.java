package sberbank.mortgage.freamwork.managers;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.DriverCommand.IMPLICITLY_WAIT;
import static sberbank.mortgage.freamwork.managers.DriverManagers.getDriver;
import static sberbank.mortgage.freamwork.managers.DriverManagers.quitDriver;
import static sberbank.mortgage.freamwork.util.PropertiesConstants.APP_URL;
import static sberbank.mortgage.freamwork.util.PropertiesConstants.PAGE_LOAD_TIMEOUT;

public class InitializeManager {

    public static TestPropManager props = TestPropManager.getTestPropManager();

    public static void initFramework() {
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
        getDriver().get(props.getProperty(APP_URL));
    }

    public static void quitFramework() {
        quitDriver();
    }
}
