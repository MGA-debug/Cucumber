package sberbank.mortgage.freamwork.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sberbank.mortgage.freamwork.managers.PageManagers;


import static sberbank.mortgage.freamwork.managers.DriverManagers.getDriver;


public class BasePage {

    protected PageManagers app = PageManagers.getManagerPages();

    protected WebDriverWait wait = new WebDriverWait(getDriver(), 10, 1000);

    protected JavascriptExecutor js = (JavascriptExecutor) getDriver();


    public BasePage() {
        PageFactory.initElements(getDriver(), this);
    }


    protected void waitUtilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUtilElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
