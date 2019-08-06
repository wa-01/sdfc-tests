/*
 * @autor: mauricioramirez
 * Project: sdfc
 * Package: com.jalasoft.sdfc.pages
 * Version: 1.0
 */
package com.jalasoft.sdfc.pages.Assets;

import com.jalasoft.sdfc.pages.AbstractPage;
import com.jalasoft.sdfc.pages.common.BasicForm;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssetsPage extends AbstractPage {

    @FindBy(xpath = "//ul[contains(@class, 'branding-actions')]/descendant::a/div[contains(text(), 'New')]")
    private WebElement newItemButton;

    @FindBy(xpath = "//div[@title = 'Edit']/parent::a")
    private WebElement innerTableEditButton;

    private final static String INNER_TABLE_TITLE = "//table[contains(@class, 'slds-table')] /" +
            "descendant::a[text() = '%s']";
    private final static String INNER_TABLE_OPTIONS_BUTTON = "/ ancestor::tr/" +
            "descendant::a[contains(@class, 'rowActionsPlaceHolder')]";

    public BasicForm clickNewItemButton() {
        action.click(newItemButton);

        return new BasicForm();
    }

    public String getInnerTableAssetNameText(String assetName) {
        String assetNameTitleLocator = String.format(INNER_TABLE_TITLE, assetName);

        return action.getText(By.xpath(assetNameTitleLocator));
    }

    public BasicForm clickEditButtonOnAsset(String assetName) {
        String assetNameTitleLocator = String.format(INNER_TABLE_TITLE, assetName);
        String innerTableOptionsButtonLocator = assetNameTitleLocator + INNER_TABLE_OPTIONS_BUTTON;

        action.click(By.xpath(innerTableOptionsButtonLocator));
        action.click(innerTableEditButton);

        return new BasicForm();
    }

    public AssetPage clickAssetLink(String assetName) {
        String assetNameTitleLocator = String.format(INNER_TABLE_TITLE, assetName);

        action.mouseClick(By.xpath(assetNameTitleLocator));

        return new AssetPage();
    }
}
