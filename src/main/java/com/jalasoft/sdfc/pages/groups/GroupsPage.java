package com.jalasoft.sdfc.pages.groups;

import com.jalasoft.sdfc.core.ui.ISteps;
import com.jalasoft.sdfc.pages.AbstractPage;
import com.jalasoft.sdfc.pages.common.BasicForm;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    @FindBy(xpath = "//span[text()='Broadcast Only']/parent::label[contains(@class,'uiLabel')]/following-sibling::input[@type='checkbox']")
    private WebElement broadcastOption;

    private BasicForm basicForm;

    public void clickNewButtonGroups() {
        action.click(newButton);
    }

    public void setGroupName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(nameField));
        action.setValue(nameField, name);

    }

    public void setGroupDescription(String description) {
        wait.until(ExpectedConditions.elementToBeClickable(descriptionField));
        action.setValue(descriptionField, description);
    }

    public void setGroupInformation(String information) {
        wait.until(ExpectedConditions.elementToBeClickable(informationField));
        action.setValue(informationField, information);
    }

    public void setAccessType(String information, String option) {
        wait.until(ExpectedConditions.elementToBeClickable(accessTypeSelector));
        action.click(accessTypeSelector);
        action.setValue(informationField, information);
    }

    public void fillingForm(Map<String, Map<String, String>> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        System.out.println(Arrdata.keySet());
        //strategyMap.put("Name", );
        //strategyMap.put("text", () -> data.get("text").forEach(this::fillTextField));
        //strategyMap.put("text_option", () -> data.get("text_option").forEach(this::selectOptionInTextField));
        //strategyMap.put("select_option", () -> data.get("select_option").forEach(this::selectOptionInSelectField));
        //strategyMap.put("text_area", () -> data.get("text_area").forEach(this::fillTextArea));
        //strategyMap.put("checkbox", () -> data.get("checkbox").forEach(this::selectCheckBox));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }
    }

/*
    private void selectOwner(String expectedOwner) {
        //action.click();
        String optionAccountLocator = String.format(OPTION_ACCOUNT_XPATH, expectedOwner);
        action.click(By.xpath(optionAccountLocator));
    }*/

    public void selectType() {
        System.out.println("Hola");
    }

}
