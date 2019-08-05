package com.jalasoft.sdfc.pages.groups;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GroupDetails extends AbstractPage {

    private static String XPATH_DESCRIPTION = "//div[contains(@class, 'groupDescription')]/descendant::span";

    private static String XPATH_INFORMATION = "//div[contains(@class, 'informationBody')]/descendant::div";

    private static String XPATH_DROPDOWN_BUTTON_ARROW = "//div[@class='uiMenu']/descendant::a/descendant::span[text()='Show more actions']/ancestor::a";

    private static String XPATH_DROPDOWN_OPTION = "//div[contains(@class,'uiMenuList')]/descendant::ul[@class='scrollable']/child::li/child::a/child::div[text()='%s']";

    //Here goes the owner name
    private static String XPATH_OWNER = "//div[@data-component-id='forceChatter_groupDetailCard']/descendant::a[contains(@title, '%s')]";

    private static String XPATH_GROUP_NAME = "//div[contains(@class,'slds-page-header')]/descendant::div[contains(@class,'nameActionsContainer')]/descendant::b";

    private static String XPATH_ACCESS_TYPE = "//div[contains(@class,'slds-page-header')]/descendant::div[contains(@class,'nameActionsContainer')]/descendant::span[contains(@class,'forceChatterOutputGroupCombinedType')]";

    private static String XPATH_BROADCAST = "//div[contains(@class,'slds-page-header')]/descendant::div[contains(@class,'nameActionsContainer')]/descendant::span[contains(@class,'forceChatterOutputGroupIsBroadcast')]";

    public String getGroupName() {
        return action.getText(By.xpath(XPATH_GROUP_NAME));
    }

    public String getDescription() {
        return action.getText(By.xpath(XPATH_DESCRIPTION));
    }

    public String getInformation() {
        return action.getText(By.xpath(XPATH_INFORMATION));
    }

    public String getOwner() {
        return action.getText(By.xpath(XPATH_OWNER));
    }

    public String getAccessType() {
        return action.getText(By.xpath(XPATH_ACCESS_TYPE));
    }

    public boolean getBroadcast() {
        return action.isElementVisible(By.xpath(XPATH_BROADCAST));
    }

    public void clickGroupOption(String optionName) {
        String option = String.format(XPATH_DROPDOWN_OPTION, optionName);
        action.click(By.xpath(XPATH_DROPDOWN_BUTTON_ARROW));
        action.mouseClick(By.xpath(option));
    }

    public void deleteGroup(String optionName) {
        String option = String.format(XPATH_DROPDOWN_OPTION, optionName);
        action.click(By.xpath(XPATH_DROPDOWN_BUTTON_ARROW));
        action.mouseClick(By.xpath(option));
    }

}
