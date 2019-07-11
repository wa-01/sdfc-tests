package com.jalasoft.sdfc.pages;

import com.jalasoft.sdfc.enums.HeaderTab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage {

    // it should allows to find almost all the tab items and they arrows in the header
    private final static String TAB_NAME = "//div[@class='bBottom']/descendant::a[@title='%s']";
    private final static String TAB_NAME_ARROW = "%s/following::a/descendant::span[starts-with(text(),'%s')]/ancestor::a";

    @FindBy(css = ".appName span")
    private WebElement applicationName;

    public void clickOnTabName(HeaderTab tab) {
        // Method used to click a TAB item in the header.
        action.click(By.xpath(String.format(TAB_NAME, tab.getName())));
    }

    public void clickOnTabNameArrow(HeaderTab tab) {
        // Method used to click in the arrow of a TAB item if exists in the header.
        String tabName = String.format(TAB_NAME, tab.getName());
        action.click(By.xpath(String.format(TAB_NAME_ARROW, tabName, tab.getName())));
    }

    public String getApplicationName() {
        // Returns the application name which is next to the AppLauncher button.
        return action.getText(applicationName);
    }


}