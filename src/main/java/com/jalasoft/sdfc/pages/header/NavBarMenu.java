package com.jalasoft.sdfc.pages.header;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;

public class NavBarMenu extends AbstractPage {
    private static String MENU_ITEM = "//span[text()='%s']/ancestor::a[@role='menuitemcheckbox']";

    /**
     * It allows to click in the New button of items in the NavBar, just send the string value
     * which is after the word 'New', for example, if you want to click the button "New Group"
     * then just send "Group".
     * @param itemName It can be values like: Account, Contact, Task, Lead, Opportunity, etc     *
     */
    public void clickNewButton(String itemName) {
        action.click(By.xpath(String.format(MENU_ITEM, "New " + itemName)));
    }

    public boolean isMenuItemVisible(String item) {
        return action.isElementVisible(By.xpath(String.format(MENU_ITEM, item)));
    }

    public void clickMenuItem(String item) {
        action.click(By.xpath(String.format(MENU_ITEM, item)));
    }

    public void getMenuItem(String itemName) {
        String itemLocator = String.format(MENU_ITEM, itemName);

        driver.findElement(By.xpath(itemLocator));
    }
}
