package com.jalasoft.sdfc.pages;

import com.jalasoft.sdfc.enums.Item;
import org.openqa.selenium.By;

public class AppLaunchPage extends AbstractPage {

    private static final String ITEM_LINK = "//a[@title='%s']";

    public IPage clickOnItem(Item item) {
        action.click(By.xpath(String.format(ITEM_LINK, item.getName())));
        return FactoryPage.getItemPage(item);
    }
}
