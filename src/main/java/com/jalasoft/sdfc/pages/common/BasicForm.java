/*
 * @autor: mauricioramirez
 * Project: sdfc
 * Package: com.jalasoft.sdfc.pages.common
 * Version: 1.0
 */
package com.jalasoft.sdfc.pages.common;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;

import java.util.Map;

public abstract class BasicForm extends AbstractPage {

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
        action.click(By.xpath(String.format(TEXT_FIELD, label)));
        action.click(By.xpath(String.format(TEXT_FIELD_OPTION, label, option)));
    }

    public void selectOptionInSelectField(String label, String option) {
        action.click(By.xpath(String.format(SELECT_FIELD, label)));
        action.click(By.xpath(String.format(SELECT_FIELD_OPTION, option)));
    }

    public void fillTextArea(String label, String text) {
        action.setValue(By.xpath(String.format(TEXT_AREA, label)), text);
    }

    public void selectCheckBox(String label) {
        action.click(By.xpath(String.format(CHECK_BOX, label)));
    }

    // TODO: this should return a PageFactory
    public void clickFooterButton(String btnName) {
        String buttonXpath = String.format(FOOTER_BUTTON, btnName);
        action.click(By.xpath(buttonXpath));
    }

    public abstract void setFormFields(Map<String, String> data);
}
