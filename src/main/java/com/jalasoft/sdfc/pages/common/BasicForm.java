/*
 * @autor: mauricioramirez
 * Project: sdfc
 * Package: com.jalasoft.sdfc.pages.common
 * Version: 1.0
 */
package com.jalasoft.sdfc.pages.common;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;

public class BasicForm extends AbstractPage {

    private static final String TEXT_FIELD = "//label/span[contains(text(), '%s')]/" +
            "ancestor::div[contains(@class, 'slds-form-element')]/descendant::input";
    private static final String TEXT_FIELD_OPTION = "//label/span[contains(text(), '%s')]/" +
            "ancestor::div[contains(@class, 'slds-form-element')]/descendant::div[@title = '%s']";
    private static final String SELECT_FIELD = "//span[contains(@id,'a-label')][contains(text(),'%s')]/" +
            "ancestor::div[contains(@class, 'uiInput')]/descendant::a[@class='select']";
    private static final String SELECT_FIELD_OPTION = "//div[contains(@class,'select-options') and " +
            "contains(@class,'uiMenuList') and contains(@class,'visible')]/descendant::a[text()='%s']";
    private static final String TEXT_AREA = "//span[text()='%s']/parent::label[contains(@class, 'uiLabel')]/" +
            "following-sibling::textarea";
    private static final String CHECK_BOX = "//span[text()='%s']/parent::label[contains(@class, 'uiLabel')]/" +
            "following-sibling::input[@type='checkbox']";
    private static final String FOOTER_BUTTON = "//div[@class = 'inlineFooter']/" +
            "descendant::span[text() = '%s']/parent::button";

    public void fillTextField(String label, String text) {

        String selectorXpath = String.format(TEXT_FIELD, label);

        action.setValue(By.xpath(selectorXpath), text);

    }

    public void selectOptionInTextField(String label, String option) {

        String textFieldXpath = String.format(TEXT_FIELD, label);
        String optionXpath = String.format(TEXT_FIELD_OPTION, label, option);

        action.setValue(By.xpath(textFieldXpath), option);
        action.click(By.xpath(optionXpath));

    }

    // TODO: this should return a PageFactory
    public void clickFooterButton(String name) {

        String buttonXpath = String.format(FOOTER_BUTTON, name);

        action.click(By.xpath(buttonXpath));

    }

}
