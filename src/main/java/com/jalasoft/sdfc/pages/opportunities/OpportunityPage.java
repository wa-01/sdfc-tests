package com.jalasoft.sdfc.pages.opportunities;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunityPage extends AbstractPage {
    // Opportunity name in the table (set name of opportunity)
    private static String CELL_OPPORTUNITY_NAME = "//a[text()='%s']";
    // Allows to select the row where CELL_OPPORTUNITY_NAME is located
    private static String ROW_OPPORTUNITY_NAME = CELL_OPPORTUNITY_NAME + "/ancestor::tr";
    // Allows to select a cell by its column name in the table (set opportunity name and column name)
    private static String CELL_OPPORTUNITY_COLUMN = ROW_OPPORTUNITY_NAME + "/td[count(//table/thead/descendant::" +
            "span[text()='%s']/preceding::th)]/descendant::span[@class='slds-truncate']";
    // The actions button in the row (set name of opportunity)
    private static String ACTIONS_BUTTON = ROW_OPPORTUNITY_NAME + "/descendant::a[@role='button']";
    // To select a menu item after clicking the ACTIONS_BUTTON (Edit, Delete, Change Owner)
    private static String ACTION_MENU_ITEM = "//div[@role='menu']/descendant::a[@title='%s']";

    @FindBy(css = "a[title='New'][role='button']")
    private WebElement newButton;

    public void clickNewButton(){
        action.click(newButton);
    }
}
