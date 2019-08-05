package com.jalasoft.sdfc.pages;

import com.jalasoft.sdfc.enums.Item;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AppLaunchPage extends AbstractPage {

    private static final String ITEM_LINK = "//span[contains(@class,'slds-text-link')]/ancestor::a[@title='%s']";

    // TODO: this should return a page factory
    public void clickOnItem(Item item) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".slds-scrollable")));
        action.click(By.xpath(String.format(ITEM_LINK, item.getName())));
    }
}
