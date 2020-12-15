package sberbank.mortgage.freamwork.util;


import io.cucumber.plugin.event.*;
import io.qameta.allure.Allure;
import io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import static sberbank.mortgage.freamwork.managers.DriverManagers.getDriver;

public class ScreenShotUtils extends AllureCucumber5Jvm {

    public void setEventPublisher(EventPublisher publisher) {

        publisher.registerHandlerFor(TestStepFinished.class, testStepFinished -> {
            if (testStepFinished.getResult().getStatus().equals(Status.FAILED))
                Allure.attachment("screen",new ByteArrayInputStream(addScreenShot()));
        });

    }

    public static byte[] addScreenShot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }

}
