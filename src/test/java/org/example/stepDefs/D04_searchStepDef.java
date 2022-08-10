package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P03_homePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Objects;

public class D04_searchStepDef {
    P03_homePage search = new P03_homePage();
    SoftAssert softassert = new SoftAssert();

    @Given("^user enter search \"([^\"]*)\" and get search result$")
    public void enetrSearchkeyword(String keyword) throws InterruptedException {
        search.getSearchFiledElement().sendKeys(keyword);
        search.clickSearchBtn().click();
        Thread.sleep(2000);
    }

    @When("user get search result on valid page")
    public void validateSearchPageURL() {
        softassert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/search?q="));
        softassert.assertAll();
    }

    @Then("^user find each result contains the search word \"([^\"]*)\"$")
    public void validateSearchResultValues(String searchword) {
        if (Objects.equals(searchword, "book") || Objects.equals(searchword, "laptop") || Objects.equals(searchword, "nike")) {

            List<WebElement> searchkeyword = search.assertSearchValues();
            for (WebElement element : searchkeyword) {
                softassert.assertTrue(element.getText().toLowerCase().contains(searchword));
                softassert.assertAll();
                System.out.println(element.getText());
            }

        } else if (Objects.equals(searchword, "SCI_FAITH") || Objects.equals(searchword, "APPLE_CAM") || Objects.equals(searchword, "SF_PRO_11") || Objects.equals(searchword, "AP_MBP_13")) {
            Assert.assertTrue(search.assertSerialProduct().getText().contains(searchword));
            System.out.println(search.assertSerialProduct().getText());
        }
    }

    @When("user click on the product in search result")
    public void clickOnProductSR() {
        search.clickOnProductSR().click();
    }

}
