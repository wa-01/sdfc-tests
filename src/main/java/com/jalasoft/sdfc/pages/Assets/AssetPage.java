package com.jalasoft.sdfc.pages.Assets;/*
 * @autor: mauricioramirez
 * Project: sdfc
 * Package: com.jalasoft.sdfc.pages.Assets
 * Version: 1.0
 */

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssetPage extends AbstractPage {

    @FindBy(css = "nav.entityNameTitle + div.slds-page-header__title > span")
    private WebElement pageTitle;

    @FindBy(xpath = "//descendant::li[contains(@class, 'tabs__item')] /" +
            "descendant::span[@class='title' and text()='%s'] / parent::a")
    private WebElement tabHeaderLink;

    @FindBy(xpath = "//span[@class='test-id__field-label' and text()='Asset Name'] /" +
            "ancestor::div[contains(@class, 'slds-form-element')] /" +
            "descendant::span[contains(@class, 'test-id__field-value')] / child::span")
    private WebElement innerFormTextInput;
}
