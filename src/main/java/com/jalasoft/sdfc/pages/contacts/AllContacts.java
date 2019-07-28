package com.jalasoft.sdfc.pages.contacts;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;

public class AllContacts extends AbstractPage {

    private static String CONTACT_NAME = "a[title='%s']";
    private static String CONTACT_ACTION = "//a[text()='%s']/ancestor::th/following-sibling::td/descendant::span[text()='Show More']/ancestor::a";
//            "//a[@class='slds-truncate outputLookupLink slds-truncate forceOutputLookup' and text()='AccountMagui']/ancestor::th/following-sibling::td/descendant::span[text()='Show More']";

    public boolean isContactVisible(String contactName) {
        return action.isElementVisible(By.xpath(String.format(CONTACT_NAME, contactName)));
    }

    public void ClickContactActions(String contactName){
        action.click(By.xpath(String.format(CONTACT_ACTION, contactName)));
    }

    public void selectOptionActions(String option){
        action.click(By.cssSelector(String.format("a[title=\"%s\"]", option)));
    }

    public void delectContact(){
        action.click(By.xpath(String.format("//span[@class=\" label bBody\" and text()=\"Delete\"]")));
    }

}
