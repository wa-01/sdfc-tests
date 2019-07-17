/*
 * @autor: mauricioramirez
 * Project: sdfc
 * Package: com.jalasoft.sdfc.pages.common
 * Version: 1.0
 */
package com.jalasoft.sdfc.pages.common;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;

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

    // TODO: this should return a PageFactory
    public void clickFooterButton(String name) {

        String buttonXpath = String.format(FOOTER_BUTTON, name);

        action.click(By.xpath(buttonXpath));

    }

}
