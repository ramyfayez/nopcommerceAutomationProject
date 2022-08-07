package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class D03_currenciesStepDef {
    P03_homePage currency = new P03_homePage();

    @Given("Select Euro currency from the dropdown list on the top left of home page")
    public void selectEuroCurrency() {
        P03_homePage.selectCurrency("Euro", By.id("customerCurrency"));
    }

    @Then("Find all Elements with Euro currency")
    public void getElementEuroCurrency() {
        List<WebElement> eurovalues = currency.getEuroValues();
        for (WebElement webElement : eurovalues) {
            System.out.println(webElement.getText());
            Assert.assertTrue(eurovalues.get(0).getText().contains("€"));
            Assert.assertTrue(eurovalues.get(1).getText().contains("€"));
            Assert.assertTrue(eurovalues.get(2).getText().contains("€"));
            Assert.assertTrue(eurovalues.get(3).getText().contains("€"));
        }

    }

}
