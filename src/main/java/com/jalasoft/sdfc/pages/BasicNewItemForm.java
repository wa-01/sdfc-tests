/*
 * @autor: mauricioramirez
 * Project: sdfc
 * Package: com.jalasoft.sdfc.pages.common
 * Version: 1.0
 */
package com.jalasoft.sdfc.pages;

import org.openqa.selenium.By;

public class BasicNewItemForm extends AbstractPage {

    private static final String FORM_FIELD = "//label/span[contains(text(), '%s')]/ancestor::div[contains(@class, 'slds-form-element')]/descendant::input";

    public void fillTextField(String label, String text) {

        String selectorXpath = String.format(FORM_FIELD, label);

        action.setValue(By.xpath(selectorXpath), text);

    }

}
