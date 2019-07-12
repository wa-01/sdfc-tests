package com.jalasoft.sdfc.pages;

import org.openqa.selenium.By;

public class AppLaunchPage extends AbstractPage {

    private static final String ITEM_LINK = "//a[@title='%s']";

    public void clickOnItem(String item) {

        action.click(By.xpath(String.format(ITEM_LINK, item)));

    }
}
