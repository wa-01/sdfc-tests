package com.jalasoft.sdfc.pages.header;

import com.jalasoft.sdfc.enums.Item;

import com.jalasoft.sdfc.pages.AbstractPage;
import com.jalasoft.sdfc.pages.AppLaunchPage;
import com.jalasoft.sdfc.pages.common.BasicPageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavBar extends AbstractPage {
    // it should allows to find almost all the tab items and they arrows in the header
    private final static String TAB_NAME = "//div[@class='bBottom']/descendant::a[contains(@title, '%s')]";
    private final static String TAB_NAME_ARROW = "%s/following::a/descendant::span[starts-with(text(),'%s')]/ancestor::a";

    @FindBy(css = ".slds-icon-waffle_container")
    private WebElement AppLauncherButton;

    @FindBy(css = ".appName span")
    private WebElement applicationName;

    public AppLaunchPage clickAppLauncherIcon() {
        action.click(AppLauncherButton);
        return new AppLaunchPage();
    }

    public AbstractPage clickOnTabName(Item tab) {
        // Method used to click a TAB item in the header.
//        action.click(By.xpath(String.format(TAB_NAME, tab.getName())));
        action.mouseClick(By.xpath(String.format(TAB_NAME, tab.getName())));

        return BasicPageFactory.getPage(tab.getName().toLowerCase());
    }

    public NavBarMenu clickOnTabNameArrow(Item tab) {
        // Method used to click in the arrow of a TAB item if exists in the header.
        String tabNameLocator = String.format(TAB_NAME, tab.getName());
        String arrowButtonLocator = String.format(TAB_NAME_ARROW, tabNameLocator, tab.getName());

        action.click(By.xpath(arrowButtonLocator));
        return new NavBarMenu();
    }

    public String getApplicationName() {
        // Returns the application name which is next to the AppLauncher button.
        return action.getText(applicationName);
    }
}
