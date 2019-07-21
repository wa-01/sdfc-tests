/*
 * @autor: mauricioramirez
 * Project: sdfc
 * Package: com.jalasoft.sdfc.pages.common
 * Version: 1.0
 */
package com.jalasoft.sdfc.pages.common;

import com.jalasoft.sdfc.pages.AbstractPage;
import com.jalasoft.sdfc.core.ui.ISteps;
import org.openqa.selenium.By;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BasicNewItemForm extends AbstractPage {

    private static final String FORM_FIELD = "//label/span[contains(text(), '%s')]/" +
            "ancestor::div[contains(@class, 'slds-form-element')]/descendant::input";
    private static final String SELECT_OPTION_FIELD = "//label/span[contains(text(), '%s')]/" +
            "ancestor::div[contains(@class, 'slds-form-element')]/descendant::div[@title = '%s']";
    private static final String FOOTER_BUTTON = "//div[@class = 'inlineFooter']/" +
            "descendant::span[text() = '%s']/parent::button";

    public void fillTextField(String label, String text) {

        String selectorXpath = String.format(FORM_FIELD, label);

        action.setValue(By.xpath(selectorXpath), text);

    }

    public void clickSelectFieldAndSelect(String label, String option) {

        String textFieldXpath = String.format(FORM_FIELD, label);
        String optionXpath = String.format(SELECT_OPTION_FIELD, label, option);

        action.setValue(By.xpath(textFieldXpath), option);
        action.click(By.xpath(optionXpath));

    }

    // TODO: this should return a BasicPageFactory
    public void clickFooterButton(String name) {

        String buttonXpath = String.format(FOOTER_BUTTON, name);

        action.click(By.xpath(buttonXpath));

    }

    public void setFormFields(Map<String, String[]> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();

        strategyMap.put("text", () -> this.fillTextField(data.get("text")[0], data.get("text")[1]));
        strategyMap.put("select", () -> this.clickSelectFieldAndSelect(data.get("select")[0], data.get("select")[1]));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }

    }

}
