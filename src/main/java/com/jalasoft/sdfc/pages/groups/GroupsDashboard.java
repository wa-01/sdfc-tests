package com.jalasoft.sdfc.pages.groups;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GroupsDashboard extends AbstractPage {

    private static String XPATH_SEARCH_BOX = "//div[contains(@class,'autocompleteWrapper')]/descendant::div[contains(@class,'uiAutocomplete')]/child::input";
    private static String XPATH_SEARCH_OPTION = "//ul[@class='lookup__list  visible']/child::li[contains(@class,'uiAutocompleteOption')]/child::a[contains(text(),'\"%s\"')]";

    public void closeBrowser() {
        driver.close();
    }

    public void searchBox(String search) {
        action.click(By.xpath(XPATH_SEARCH_BOX));
        action.setValue(By.xpath(XPATH_SEARCH_BOX), search);
        driver.findElement(By.xpath(String.format(XPATH_SEARCH_OPTION, search))).click();
    }
}
