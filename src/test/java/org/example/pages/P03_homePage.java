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
}
