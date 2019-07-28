package com.jalasoft.sdfc.pages.opportunities;

import com.jalasoft.sdfc.core.ui.ISteps;
import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OpportunityPage extends AbstractPage {
    // Opportunity name in the table (set name of opportunity)
    private static String CELL_OPPORTUNITY_NAME = "//a[text()='%s']";
    // Allows to select the row where CELL_OPPORTUNITY_NAME is located
    private static String ROW_OPPORTUNITY_NAME = CELL_OPPORTUNITY_NAME + "/ancestor::tr";
    // Allows to select a cell by its column name in the table (set opportunity name and column name)
    private static String CELL_OPPORTUNITY_COLUMN = ROW_OPPORTUNITY_NAME + "/td[count(//table/thead/descendant::" +
            "span[text()='%s']/preceding::th)]/descendant::span[contains(@class,'slds-truncate')]";
    // Allows to select a cell by its column name in the table (set opportunity name and column name)
    private static String CELL_OPPORTUNITY_COLUMN_LINK = ROW_OPPORTUNITY_NAME + "/td[count(//table/thead/descendant::" +
            "span[text()='%s']/preceding::th)]/descendant::a[contains(@class,'slds-truncate')]";
    // Allows to click the edit button in Account Name, Stage, and Close Date cells (set name of opportunity and the column name
    private static String CELL_EDIT = ROW_OPPORTUNITY_NAME + "/td[count(//table/thead/descendant::" +
            "span[text()='%s']/preceding::th)]";
    private static String CELL_EDIT_BUTTON = ROW_OPPORTUNITY_NAME + "/td[count(//table/thead/descendant::" +
            "span[text()='%s']/preceding::th)]/descendant::button[contains(@class,'slds-button')]";
    // Allows to click the edit button in Opportunity Name cell (set opportunity name)
    private static String CELL_OPPORTUNITY_NAME_EDIT = "//a[text()='%s']/ancestor::th";
    private static String CELL_OPPORTUNITY_NAME_EDIT_BUTTON = "//a[text()='%s']/following-sibling::span/button";
    // Allows to click an option in the Stage dropdown
    private static String STAGE_OPTION_DROPDOWN = "//div[@class='select-options']/descendant::li/a[@title='%s']";
    // The actions button in the row (set name of opportunity)
    private static String ACTIONS_BUTTON = ROW_OPPORTUNITY_NAME + "/descendant::a[@role='button']";
    // To select a menu item after clicking the ACTIONS_BUTTON (Edit, Delete, Change Owner)
    private static String ACTION_MENU_ITEM = "//div[@role='menu']/descendant::a[@title='%s']";
    // To select an account once Search_Account dropdown is clicked (set the account name)
    private static String SEARCH_ACCOUNT_OPTION = "//input[@title='Search Accounts']/following-sibling::div/descendant::" +
            "div[@title='%s']";
    // To click Save or Cancel button once the opportunity is edited
    private static String SAVE_CANCEL_BUTTON = "//span[text()='%s']/parent::button";

    @FindBy(xpath = "//div[@title='New']/parent::a")
    private WebElement newButton;

    @FindBy(css = "input.slds-grow")
    private WebElement edit_text_field;   // Field to edit Opportunity Name and Close Date in the table

    @FindBy(xpath = "//input[@title='Search Accounts']")
    private WebElement search_account_dropdown;  // Field to search accounts one the edit button is clicked

    @FindBy(xpath = "//div[contains(@class,'uiInputSelect')]/descendant::a[@class='select']")
    private WebElement stage_dropdown;          // Field to open/click the stage dropdown

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

    public void editOpportunityCells(String opportunityName, Map<String, String> data) {
        Map<String, ISteps> strategyMap = new HashMap<>();
        strategyMap.put("name", () -> editOpportunityNameCell(opportunityName, data.get("name")));
        strategyMap.put("account_name", () -> editAccountNameCell(data.get("name"), data.get("account_name")));
        strategyMap.put("stage", () -> editStageCell(data.get("name"), data.get("stage")));
        strategyMap.put("close_date", () -> editCloseDateCell(data.get("name"), data.get("close_date")));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            strategyMap.get(key).execute();
        }
    }

    private void editOpportunityNameCell(String oppName, String newData) {
        //clicks the edit button in the cell
        action.click(By.xpath(String.format(CELL_OPPORTUNITY_NAME_EDIT, oppName)));
        action.click(By.xpath(String.format(CELL_OPPORTUNITY_NAME_EDIT_BUTTON, oppName)));
        edit_text_field.clear();
        action.setValue(edit_text_field, newData);
        edit_text_field.sendKeys(Keys.ENTER);
    }

    private void editAccountNameCell(String oppName, String newData) {
        //clicks the edit button in the cell
        action.click(By.xpath(String.format(CELL_EDIT, oppName, "Account Name")));
        action.click(By.xpath(String.format(CELL_EDIT_BUTTON, oppName, "Account Name")));
        search_account_dropdown.clear();
        action.setValue(search_account_dropdown, newData);
        action.click(By.xpath(String.format(SEARCH_ACCOUNT_OPTION, newData)));
    }

    private void editStageCell(String oppName, String newData) {
        //clicks the edit button in the cell
        action.click(By.xpath(String.format(CELL_EDIT, oppName, "Stage")));
        action.click(By.xpath(String.format(CELL_EDIT_BUTTON, oppName, "Stage")));
        action.click(stage_dropdown);
        action.click(By.xpath(String.format(STAGE_OPTION_DROPDOWN, newData)));
    }

    private void editCloseDateCell(String oppName, String newData) {
        //clicks the edit button in the cell
        action.click(By.xpath(String.format(CELL_EDIT, oppName, "Close Date")));
        action.click(By.xpath(String.format(CELL_EDIT_BUTTON, oppName, "Close Date")));
        edit_text_field.clear();
        action.setValue(edit_text_field, newData);
        edit_text_field.sendKeys(Keys.ENTER);
    }

    public void clickSaveCancelButton(String btnName) {
        action.click(By.xpath(String.format(SAVE_CANCEL_BUTTON, btnName)));
    }

    public void clickOpportunityInTheTable(String name) {
        action.click(By.xpath(String.format(CELL_OPPORTUNITY_NAME, name)));
    }
}
