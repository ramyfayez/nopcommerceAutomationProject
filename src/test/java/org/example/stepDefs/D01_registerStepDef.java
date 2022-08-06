package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.P01_register;
import org.openqa.selenium.By;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.asserts.SoftAssert;


public class D01_registerStepDef {
    P01_register register = new P01_register();
    SoftAssert softassert = new SoftAssert();

    @Given("user go to register page")
    public void goRegisterPage() {

        register.registerlink().click();
    }

    @When("user select gender type")
    public void selectGenderType() {
        register.selectGender().click();
    }

    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void enterFirstAndlastNames(String firstname, String lastname) {
        register.login("automation", "tester");
    }

    @When("user enter date of birth")
    public void enterDateOfBirth() {
        P01_register.selectDateOfBirth("29", By.name("DateOfBirthDay"));
        P01_register.selectDateOfBirth("October", By.name("DateOfBirthMonth"));
        P01_register.selectDateOfBirth("2000", By.name("DateOfBirthYear"));
    }

    @And("^user enter email \"(.*)\" field$")
    public void enterEmail(String email) {
        String randomemail = RandomStringUtils.randomAlphabetic(10);
        register.enterEmail().sendKeys(randomemail + "@example.com");
    }

    @When("^user fills Password fields \"(.*)\" \"(.*)\"$")
    public void enterPassword(String password, String confirmpassword) {
        register.enterPassword().sendKeys("P@ssw0rd");
        register.enterConfirmPassword().sendKeys("P@ssw0rd");
    }

    @And("user clicks on register button")
    public void clickRegisterButton() {
        register.clickRegisterButton().click();
    }

    @Then("success message is displayed")
    public void assertSuccessfullyRegistration() {
        softassert.assertTrue(register.getSuccessfullyMessagetext().isDisplayed());
        String sucessregisterationMsg = register.getSuccessfullyMessagetext().getText();
        softassert.assertEquals(sucessregisterationMsg, "Your registration completed");
        String sucessregisterationMsgColor = register.getSuccessfullyMessagetext().getCssValue("color");
        System.out.println(sucessregisterationMsgColor);

        softassert.assertEquals(sucessregisterationMsgColor, "rgba(76, 177, 124, 1)");
        softassert.assertAll();
    }
}
