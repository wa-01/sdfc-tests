package com.jalasoft.sdfc.pages.accounts;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountDetails extends AbstractPage {

    private static final String TEXT_FIELD = "//span[contains(text(),'%s')]/parent::label/following-sibling::input";

    @FindBy(css = "span[class=\"custom-truncate uiOutputText\"]")
    private WebElement contactNameLabel;

    @FindBy(css = "a[class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix']")
    private WebElement headerDropDown;

    @FindBy(css = "a[title='Delete']")
    private WebElement deleteOption;

    @FindBy(css = "button[title=\"Delete\"]")
    private WebElement deleteButton;

    private static String EDITBUTTON_NAME = "button[title='%s']";
    private static String SAVEBUTTON_NAME = "button[title='%s']";
    private static String TAB_NAME = "//span[@class=\"title\" and text()=\"%s\"]";
    private static String ACCOUNT_NAME = "//span[text()='Account Name']/ancestor::div[contains(@class, 'slds-form-element_edit')]/descendant::span[@class='uiOutputText']";
    public String getAccountNameLabel() {
        return action.getText(contactNameLabel);
    }

    public void goToTab(String tabName) {
        action.click(By.xpath(String.format(TAB_NAME, tabName)));
    }

    public String getAccountNameDetails() {
        return action.getText(By.xpath(ACCOUNT_NAME));
    }

    public void clickEditButton(String editName) {
//        action.mouseClick(By.ByCssSelector);
        action.click(By.cssSelector(String.format(EDITBUTTON_NAME, editName)));
    }

    public void setTextField(String fieldName, String value){
        action.setValue(By.xpath(String.format(TEXT_FIELD, fieldName)), value);
    }

    public void ClickButton(String button) {
//        action.click(saveButton);\
        action.click(By.cssSelector(String.format(SAVEBUTTON_NAME, button)));
    }

    public void ClickHeaderDropDown() {
        action.click(headerDropDown);
    }

    public void ClickDeleteOption() {
        action.click(deleteOption);
    }

    public void ClickDeleteButton() {
        action.click(deleteButton);
    }
}

