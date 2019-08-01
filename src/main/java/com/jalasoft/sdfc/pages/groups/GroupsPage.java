package com.jalasoft.sdfc.pages.groups;

import com.jalasoft.sdfc.core.ui.ISteps;
import com.jalasoft.sdfc.pages.AbstractPage;
import com.jalasoft.sdfc.pages.AppLaunchPage;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GroupsPage extends AbstractPage {

    // Buttons
    @FindBy(css = "a[title='New']")
    private WebElement newButton;

    @FindBy(css = "//button/descendant::span[text()='Save & Next']")
    private WebElement saveButton;

    // Fields
    @FindBy(css = "//span[text()='Name']/parent::label/following-sibling::input")
    private WebElement nameField;

    @FindBy(css = "//input[@title='Search People']")
    private WebElement ownerField;

    public void clickNewButtonGroups(){
        action.click(newButton);
    }

/*
    private void selectOwner(String expectedOwner) {
        //action.click();
        String optionAccountLocator = String.format(OPTION_ACCOUNT_XPATH, expectedOwner);
        action.click(By.xpath(optionAccountLocator));
    }*/

public void selectType(){
    System.out.println("Hola");
}

}
