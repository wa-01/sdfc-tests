package com.jalasoft.sdfc.pages.contacts;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDetails extends AbstractPage {

    @FindBy(css = "span[class=\"custom-truncate uiOutputText\"]")
    private WebElement contactNameLabel;

    private static String TAB_NAME = "//span[@class=\"title\" and text()=\"%s\"]";
    private static String CONTACT_NAME = "//span[text()='Name']/ancestor::div[contains(@class, 'slds-form-element_edit')]/descendant::span[@class='uiOutputText']";

    //    private static String CONTACT_TAB = "//span[text()='Contacts']/ancestor::a";
    public String getContactNameLabel() {
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("span[class=\"custom-truncate uiOutputText\"]")));
        return action.getText(contactNameLabel);
    }

    public String getContactNameDetails() {
        return action.getText(By.xpath(CONTACT_NAME));
    }

//    public void clickContactTab(){
//        action.click(By.xpath(CONTACT_TAB ));
//    }

    public void clickEditIcon(String iconName) {
        action.click(By.cssSelector(String.format("button[title=\"%s\"]", iconName)));
    }

    public void goToTab(String tab) {
        action.click(By.xpath(String.format(TAB_NAME, tab)));
    }

    public void clickUpdateDetailsButton(String button){
        action.click(By.cssSelector(String.format("button[title=\"%s\"]", button)));

    }
}
