package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import sberbank.mortgage.freamwork.managers.InitializeManager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static sberbank.mortgage.freamwork.managers.DriverManagers.getDriver;

public class Hooks {

    @Before
    public void beforeEach() {
        InitializeManager.initFramework();
    }


    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()) {
            Allure.attachment("failureScreen", addScreenshot());
        }
        InitializeManager.quitFramework();
    }

    @Attachment(value = "screenshot", type = "image/png")
    private static InputStream addScreenshot() {
        byte[] screenShot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);

        return new ByteArrayInputStream(screenShot);
    }
}
