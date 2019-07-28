/*
 * @autor: mauricioramirez
 * Project: sdfc
 * Package: com.jalasoft.sdfc.pages
 * Version: 1.0
 */
package com.jalasoft.sdfc.pages.Assets;

import com.jalasoft.sdfc.pages.AbstractPage;
import com.jalasoft.sdfc.pages.common.BasicNewItemForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AssetsPage extends AbstractPage {

    @FindBy(xpath = "//ul[contains(@class, 'branding-actions')]/descendant::a/div[contains(text(), 'New')]")
    private WebElement newItemButton;

    public BasicNewItemForm clickNewItemButton() {
        action.click(newItemButton);

        return new BasicNewItemForm();
    }
}
