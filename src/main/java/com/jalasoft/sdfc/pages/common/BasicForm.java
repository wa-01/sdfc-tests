package com.jalasoft.sdfc.pages.common;

import com.jalasoft.sdfc.core.ui.ISteps;
import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BasicForm extends AbstractPage {

    private static final String TEXT_FIELD = "//label/span[starts-with(text(), '%s')]/" +
            "ancestor::div[contains(@class,'uiInput')]/descendant::input";
    private static final String TEXT_FIELD_OPTION = "//label/span[starts-with(text(), '%s')]/" +
            "ancestor::div[contains(@class, 'slds-form-element')]/descendant::div[@title = '%s']";
    private static final String SELECT_FIELD = "//span[contains(@id,'a-label')][starts-with(text(),'%s')]/" +
            "ancestor::div[contains(@class, 'uiInput')]/descendant::a[@class='select']";
    private static final String SELECT_FIELD_OPTION = "//div[contains(@class,'select-options') and " +
            "contains(@class,'uiMenuList') and contains(@class,'visible')]/descendant::a[text()='%s']";
    private static final String TEXT_AREA = "//span[starts-with(text(),'%s')]/parent::label[contains(@class, 'uiLabel')]/" +
            "following-sibling::textarea";
    private static final String CHECK_BOX = "//span[starts-with(text(),'%s')]/parent::label[contains(@class, 'uiLabel')]/" +
            "following-sibling::input[@type='checkbox']";
    private static final String FOOTER_BUTTON = "//div[@class = 'inlineFooter']/" +
            "descendant::span[text() = '%s']/parent::button";

    public void fillTextField(String label, String text) {
        String selectorXpath = String.format(TEXT_FIELD, label);
        action.setValue(By.xpath(selectorXpath), text);
    }

    public void selectOptionInTextField(String label, String option) {
        action.setValue(By.xpath(String.format(TEXT_FIELD, label)), option);
        action.click(By.xpath(String.format(TEXT_FIELD_OPTION, label, option)));
    }

    public void selectOptionInSelectField(String label, String option) {
        action.click(By.xpath(String.format(SELECT_FIELD, label)));
        action.click(By.xpath(String.format(SELECT_FIELD_OPTION, option)));
    }

    public void fillTextArea(String label, String text) {
        action.setValue(By.xpath(String.format(TEXT_AREA, label)), text);
    }

    public void selectCheckBox(String label, String value) {
        boolean isSelected = action.isSelected(By.xpath(String.format(CHECK_BOX, label)));
        if (value.equals("select") && !isSelected){
            action.click(By.xpath(String.format(CHECK_BOX, label)));
        }

        if (value.equals("unselect") && isSelected){
            action.click(By.xpath(String.format(CHECK_BOX, label)));
        }
    }

    // TODO: this should return a PageFactory
    public void clickFooterButton(String btnName) {
        String buttonXpath = String.format(FOOTER_BUTTON, btnName);
        action.click(By.xpath(buttonXpath));
    }

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
}