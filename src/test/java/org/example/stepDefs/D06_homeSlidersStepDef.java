package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.P03_homePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D06_homeSlidersStepDef {
    P03_homePage sliderhomepage = new P03_homePage();
    SoftAssert softassert = new SoftAssert();

    @Given("first slider is clickable on home page")
    public void clickFirstSliderURL() {
        sliderhomepage.clickSliderElement().click();
        sliderhomepage.implicitWait();
    }

    @Then("^user should navigate to clickable URL \"(.*)\"$")
    public void asserCurrenURL(String URL) {
        switch (URL) {
            case "Nokia1020":
                softassert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/nokia-lumia-1020");
                softassert.assertAll();
                break;
            case "Iphone":
                softassert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/iphone-6");
                softassert.assertAll();
                break;
        }

    }

    @Given("second slider is clickable on home page")
    public void clickSecondSliderURL() {
        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.attributeToBe(By.xpath("//*[@id=\"nivo-slider\"]/a[1]"), "style", "display: none;"));
        sliderhomepage.clickSliderElement().click();
        sliderhomepage.implicitWait();
    }
}
