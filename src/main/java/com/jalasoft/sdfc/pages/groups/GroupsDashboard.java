package com.jalasoft.sdfc.pages.groups;

import com.jalasoft.sdfc.pages.AbstractPage;
import jdk.dynalink.beans.StaticClass;
import jdk.nashorn.internal.ir.debug.PrintVisitor;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GroupsDashboard extends AbstractPage {

    private static String XPATH_SEARCH_BOX = "//div[contains(@class,'autocompleteWrapper')]/descendant::div[contains(@class,'uiAutocomplete')]/child::input";
    private static String XPATH_SEARCH_OPTION = "//ul[@class='lookup__list  visible']/child::li[contains(@class,'uiAutocompleteOption')]/child::a[contains(text(),'\"%s\"')]";
    private static String XPATH_GROUP_ROW = "//div[@data-aura-class='forceChatterCompoundFieldsGroupName']/descendant::a[contains(text(),'%s')]";

    public void closeBrowser() {
        driver.close();
    }

    public void searchBox(String search) {
        action.click(By.xpath(XPATH_SEARCH_BOX));
        action.setValue(By.xpath(XPATH_SEARCH_BOX), search);
        driver.findElement(By.xpath(String.format(XPATH_SEARCH_OPTION, search))).click();
    }

    public boolean isInList(String groupName){
        String xpathRow = String.format(XPATH_GROUP_ROW, groupName);
        return action.isElementVisible(By.xpath(xpathRow));

    }
}
