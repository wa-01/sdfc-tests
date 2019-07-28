package com.jalasoft.sdfc.pages.opportunities;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OpportunityPage extends AbstractPage {
    // Opportunity name in the table (set name of opportunity)
    private static String CELL_OPPORTUNITY_NAME = "//a[text()='%s']";
    // Allows to select the row where CELL_OPPORTUNITY_NAME is located
    private static String ROW_OPPORTUNITY_NAME = CELL_OPPORTUNITY_NAME + "/ancestor::tr";
    // Allows to select a cell by its column name in the table (set opportunity name and column name)
    private static String CELL_OPPORTUNITY_COLUMN = ROW_OPPORTUNITY_NAME + "/td[count(//table/thead/descendant::" +
            "span[text()='%s']/preceding::th)]/descendant::span[contains(@class,'slds-truncate')]";
    private static String CELL_OPPORTUNITY_COLUMN_LINK = ROW_OPPORTUNITY_NAME + "/td[count(//table/thead/descendant::" +
            "span[text()='%s']/preceding::th)]/descendant::a[contains(@class,'slds-truncate')]";
    // The actions button in the row (set name of opportunity)
    private static String ACTIONS_BUTTON = ROW_OPPORTUNITY_NAME + "/descendant::a[@role='button']";
    // To select a menu item after clicking the ACTIONS_BUTTON (Edit, Delete, Change Owner)
    private static String ACTION_MENU_ITEM = "//div[@role='menu']/descendant::a[@title='%s']";

    @FindBy(xpath = "//div[@title='New']/parent::a")
    private WebElement newButton;

    public void clickNewButton(){
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".transitioning")));
        action.click(newButton);
    }

    public String getSpanTextValueFromColum(String opportunity, String columName) {
        // Method to retrieve values in the columns Stage, Close Date, and Opportunity Owner
        String xPath = String.format(CELL_OPPORTUNITY_COLUMN, opportunity, columName);
        return action.getText(By.xpath(xPath));
    }

    public String getLinkTextValueFromColum(String opportunity, String columName) {
        // Method to retrieve values in the columns Opportunity Name, Account Name
        String xPath = String.format(CELL_OPPORTUNITY_COLUMN_LINK, opportunity, columName);
        return action.getText(By.xpath(xPath));
    }

    public void clickAction(String opportunity, String actionName) {
        // it clicks the action button at right and click a action like Edit, Delete, Change Owner
        action.click(By.xpath(String.format(ACTIONS_BUTTON, opportunity)));
        action.click(By.xpath(String.format(ACTION_MENU_ITEM, actionName)));
    }

    public boolean isOpportunityInTable(String name) {
        return action.isElementVisible(By.xpath(String.format(CELL_OPPORTUNITY_NAME, name)));
    }
}
