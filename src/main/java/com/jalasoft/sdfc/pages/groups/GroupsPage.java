package com.jalasoft.sdfc.pages.groups;

import com.jalasoft.sdfc.core.ui.ISteps;
import com.jalasoft.sdfc.pages.AbstractPage;
import com.jalasoft.sdfc.pages.AppLaunchPage;
import com.jalasoft.sdfc.pages.common.BasicForm;
import io.cucumber.datatable.DataTable;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.annotation.JsonProperty;
import io.cucumber.datatable.dependency.com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

public class GroupsPage extends AbstractPage {

    // Buttons
    @FindBy(css = "a[title='New']")
    private WebElement newButton;

    @FindBy(xpath = "//button/descendant::span[text()='Save & Next']")
    private WebElement saveButton;

    // Fields
    @FindBy(xpath = "//span[text()='Name']/parent::label/following-sibling::input")
    private WebElement nameField;

    @FindBy(xpath = "//span[text()='Description']/parent::label/following-sibling::textarea")
    private WebElement descriptionField;

    @FindBy(xpath = "//span[starts-with(text(),'Information')]/ancestor::div[contains(@class, 'slds-form-element_readonly')]/descendant::div[@class='ql-clipboard']")
    private WebElement informationField;

    @FindBy(className = ".deleteAction")
    private WebElement cleanOwnerField;

    @FindBy(xpath = "//input[@title='Search People']")
    private WebElement ownerField;

    @FindBy(css = ".select")
    private WebElement accessTypeSelector;

    @FindBy(xpath = ".select")
    private WebElement accessTypeOption;

    @FindBy(xpath = "//span[text()='Allow customers']/parent::label[contains(@class,'uiLabel')]/following-sibling::input[@type='checkbox']")
    private WebElement allowCustomersOption;

    @FindBy(xpath = "//span[text()='Allow customers']/parent::label[contains(@class,'uiLabel')]/following-sibling::input[@type='checkbox']")
    private WebElement broadcastOption;

    private BasicForm basicForm;

    public void clickNewButtonGroups(){
        action.click(newButton);
    }

    public void setGroupName(String name){
        wait.until(ExpectedConditions.elementToBeClickable(nameField));
        action.setValue(nameField,name);
    }

    public void setGroupDescription(String description){
        wait.until(ExpectedConditions.elementToBeClickable(descriptionField));
        action.setValue(descriptionField,description);
    }

    public void setGroupInformation(String information){
        wait.until(ExpectedConditions.elementToBeClickable(informationField));
        action.setValue(informationField,information);
    }

    public void filllingForm(List<Map<String, String>> data){
        basicForm = new BasicForm();
        Map<String, Map<String, String>> dataFields = new HashMap<>();
        for (Map<String,String> value: data ) {
            if (dataFields.containsKey(value.get("fieldType"))) {
                dataFields.get(value.get("fieldType")).put(value.get("fieldName"), value.get("value"));
                System.out.println("1. "+value.values());

            } else {
                Map<String, String> values = new HashMap<>();
                values.put(value.get("fieldName"), value.get("value"));
                dataFields.put(value.get("fieldType"),values);
                System.out.println("2. " + value.values());

            }
        }
        basicForm.setFormFields(dataFields);
        System.out.println("============================================");

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
