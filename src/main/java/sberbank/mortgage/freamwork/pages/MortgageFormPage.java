package sberbank.mortgage.freamwork.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MortgageFormPage extends BasePage {


    @FindBy(xpath = "//div[@data-label]")
    List<WebElement> condition;

    @FindBy(xpath = "//div[@data-e2e-id='mland-calculator/discounts-block']//div[@class='styles_item__1SP5M']")
    List<WebElement> additionalServices;

    @FindBy(xpath = "//div[@data-e2e-id]//ul[@class='styles_list__2ouxK']//span[@class='style_label__270Um']")
    List<WebElement> fieldValues;

    public MortgageFormPage selectCondition(String nameCondition, String sum) {
        WebElement conditionAndSum = null;

        for (WebElement element : condition) {
            if (element.getAttribute("data-label").equalsIgnoreCase(nameCondition)) {
                conditionAndSum = element.findElement(By.xpath(".//input"));
                while (true) {
                    try {
                        Integer.parseInt(conditionAndSum.getAttribute("value").replaceAll(" ", ""));
                        conditionAndSum.sendKeys(Keys.BACK_SPACE);
                    } catch (NumberFormatException e) {
                        conditionAndSum.sendKeys(sum);
                        return this;
                    }
                }
            }
        }
        Assert.fail("Указаны некоректные данные");
        return this;
    }


    public MortgageFormPage selectAdditionalServices(String nameAdditionalServices, String consent) {
        WebElement additionalServicesElement;
        WebElement accept;


        for (WebElement element: additionalServices) {
            additionalServicesElement = element.findElement(By.xpath("./div/div/span"));
            if (additionalServicesElement.getText().toLowerCase().contains(nameAdditionalServices)) {
                accept = element.findElement(By.xpath(".//input"));

                if (accept.getAttribute("aria-checked").equals("true") && consent.toLowerCase().equals("нет")) {
                    accept.click();
                }else if ((accept.getAttribute("aria-checked").equals("false")) && consent.toLowerCase().equals("да")){
                    accept.click();
                }
            }
        }
        return this;
    }


    public MortgageFormPage checkFieldValues() {
        String errorMassage = "Ошибка в значении поля";
        WebElement fieldElement;
        for (WebElement element: fieldValues) {
            fieldElement = element.findElement(By.xpath("./../span[@data-e2e-id]/span"));
            switch (element.getText()) {
                case "Ежемесячный платеж":
                    Assert.assertEquals(errorMassage, "16017",
                            fieldElement.getText().replaceAll("\\D", ""));
                    break;
                case "Сумма кредита":
                    Assert.assertEquals(errorMassage, "2122000",
                            fieldElement.getText().replaceAll("\\D", ""));
                    break;
                case "Необходимый доход":
                    Assert.assertEquals(errorMassage, "20698",
                            fieldElement.getText().replaceAll("\\D", ""));
                    break;
                case "Процентная ставка":
                    Assert.assertEquals(errorMassage,"11%",fieldElement.getText());
                    break;
            }
        }
        return this;
    }
}
