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

    public void create_public_group(Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("Name", () -> action.setValue(nameField, data.get("name")));
        strategyMap.put("Owner", () -> action.setValue(ownerField, data.get("owner")));
//        strategyMap.put("owner", () -> selectAccount(data.get("account")));
//        strategyMap.put("accessType", () -> action.click(By.cssSelector(String.format(PRIVACY_CSS, data.get("privacy")))));
//
        Set<String> keys = data.keySet();
        for (String key : keys) {
            //strategyMap.get(key).execute();
            System.out.println(data.get(key));
            strategyMap.get(data.get(key)).execute();
            System.out.println("HOLS");
        }
        //action.click(saveButton);
    }

/*
    private void selectOwner(String expectedOwner) {
        //action.click();
        String optionAccountLocator = String.format(OPTION_ACCOUNT_XPATH, expectedOwner);
        action.click(By.xpath(optionAccountLocator));
    }*/

}
