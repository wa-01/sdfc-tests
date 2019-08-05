package com.jalasoft.sdfc.pages.Assets;/*
 * @autor: mauricioramirez
 * Project: sdfc
 * Package: com.jalasoft.sdfc.pages.Assets
 * Version: 1.0
 */

import com.jalasoft.sdfc.core.ui.ISteps;
import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class AssetPage extends AbstractPage {

    @FindBy(css = "nav.entityNameTitle + div.slds-page-header__title > span")
    private WebElement pageTitle;

    private String innerFormTextInputLocator = "//span[@class='test-id__field-label' and text()='%s'] /" +
            "ancestor::div[contains(@class, 'slds-form-element')] /" +
            "descendant::span[contains(@class, 'test-id__field-value')] / child::span";

    public String getPageTitle() {
        return action.getText(pageTitle);
    }

    public void getValueInnerFormField(String fieldType, String fieldName) {
        System.out.println();
    }

    public String getValueInnerFormTextInput(String fieldName) {
        String locatorString = String.format(innerFormTextInputLocator, fieldName);

        return action.getText(By.xpath(locatorString));
    }
}
