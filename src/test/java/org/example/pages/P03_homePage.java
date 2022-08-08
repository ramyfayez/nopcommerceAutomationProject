package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class P03_homePage {
    public static void selectCurrency(String selection, By ElementId) {
        Select DDselection = new Select(Hooks.driver.findElement(ElementId));
        DDselection.selectByVisibleText(selection);
    }

    public List<WebElement> getEuroValues() {

        return Hooks.driver.findElements(By.className("price"));
    }

    public WebElement getSearchFiledElement() {

        return Hooks.driver.findElement(By.id("small-searchterms"));
    }

    public WebElement clickSearchBtn() {

        return Hooks.driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));
    }

    public List<WebElement> assertSearchValues() {

        return Hooks.driver.findElements(By.className("product-title"));
    }

    public WebElement clickOnProductSR() {

        return Hooks.driver.findElement(By.className("product-title"));
    }

    public WebElement assertSerialProduct() {

        return Hooks.driver.findElement(By.className("sku"));
    }

}
