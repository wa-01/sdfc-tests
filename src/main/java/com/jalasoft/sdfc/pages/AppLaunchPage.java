package com.jalasoft.sdfc.pages;

import com.jalasoft.sdfc.enums.Item;
import com.jalasoft.sdfc.pages.common.BasicPageFactory;
import org.openqa.selenium.By;

public class AppLaunchPage extends AbstractPage {

    private static final String ITEM_LINK = "//a[@title='%s']/descendant::span[@class='label slds-truncate slds-text-link']";

    // TODO: this should return a page factory
    public AbstractPage clickOnItem(Item item) {
        action.click(By.xpath(String.format(ITEM_LINK, item.getName())));

        return BasicPageFactory.getPage(item.getName().toLowerCase());
    }
}
