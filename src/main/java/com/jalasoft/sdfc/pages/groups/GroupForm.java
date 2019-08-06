package com.jalasoft.sdfc.pages.groups;

import com.jalasoft.sdfc.core.ui.ISteps;
import com.jalasoft.sdfc.pages.AbstractPage;
import com.jalasoft.sdfc.pages.common.BasicForm;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupForm extends BasicForm {

    // Buttons
    private static final String XPATH_FOOTER_BUTTONS = "//div[@class='wizard-step active']/" +
            "descendant::div[contains(@class,'wizard-step-navigator')]/" +
            "child::button/child::span[starts-with(text(),'%s')]";

    private static final String XPATH_RICH_TEXT = "//span[starts-with(text(),'%s')]" +
            "/ancestor::div[contains(@class, 'slds-form-element_readonly')]" +
            "/descendant::div[@class='ql-clipboard']";

    private static final String GROUP_SELECT_FIELD = "//span[contains(@id,'label')][starts-with(text(),'%s')]/" +
            "ancestor::div[contains(@class, 'uiInput')]/descendant::a[@class='select']";
    private static final String GROUP_SELECT_FIELD_OPTION = "//div[contains(@class,'select-options') and " +
            "contains(@class,'uiMenuList') and contains(@class,'visible')]/descendant::a[text()='%s']";

    @FindBy(className = ".deleteAction")
    private WebElement cleanOwnerField;

    @FindBy(xpath = "//input[@title='Search People']")
    private WebElement ownerField;

    @Override
    public void selectOptionInSelectField(String label, String option) {
        action.click(By.xpath(String.format(GROUP_SELECT_FIELD, label)));
        action.click(By.xpath(String.format(GROUP_SELECT_FIELD_OPTION, option)));
    }

    @Override
    public void setFormFields(Map<String, Map<String, String>> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();

        strategyMap.put("text", () -> data.get("text").forEach(this::fillTextField));
        strategyMap.put("text_option", () -> data.get("text_option").forEach(this::selectOptionInTextField));
        strategyMap.put("select_option", () -> data.get("select_option").forEach(this::selectOptionInSelectField));
        strategyMap.put("text_area", () -> data.get("text_area").forEach(this::fillTextArea));
        strategyMap.put("checkbox", () -> data.get("checkbox").forEach(this::selectCheckBox));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }
    }

    public void clickButton(String btnName) {
        String buttonXpath = String.format(XPATH_FOOTER_BUTTONS, btnName);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(buttonXpath)));
        action.click(By.xpath(buttonXpath));
    }

    public void clickButtons() {
        String save = String.format(XPATH_FOOTER_BUTTONS, "Save & Next");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(save)));
        action.click(By.xpath(save));
        String next = String.format(XPATH_FOOTER_BUTTONS, "Next");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(next)));
        action.click(By.xpath(next));
        String done = String.format(XPATH_FOOTER_BUTTONS, "Done");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(done)));
        action.click(By.xpath(done));
    }

    public String getErrorMessage() {
        return action.getText(By.xpath("//ul[@class='errorsList']/child::li"));
    }
}
