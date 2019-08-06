package com.jalasoft.sdfc.pages.groups;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GroupsDashboard extends AbstractPage {

    private static final String CSS_NEW_BUTTON = "a[title='New']";


    private static String XPATH_SEARCH_BOX = "//div[contains(@class,'autocompleteWrapper')]/descendant::div[contains(@class,'uiAutocomplete')]/child::input";

    private static String XPATH_SEARCH_OPTION = "//div[contains(@class,'listContent')]/child::ul/child::li/descendant::span[text()='\"%s\"']";

    private static String XPATH_GROUP_ROW = "//div[@data-aura-class='forceChatterCompoundFieldsGroupName']/descendant::a[text()='%s']";

    @FindBy(xpath = "//div[contains(@class,'uiAutocompleteList')]/descendant::ul/descendant::li[contains(@class,'SEARCH_OPTION')]/descendant::a/descendant::span[text()='\"%s\" in Groups')]")
    private WebElement searchOption;

    public void clickNewButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CSS_NEW_BUTTON)));
        action.click(By.cssSelector(CSS_NEW_BUTTON));
    }

    public void closeBrowser() {
        driver.close();
    }

    public boolean searchBox(String search) {
        action.setValue(By.xpath(XPATH_SEARCH_BOX), search);
        action.click(By.xpath(String.format(XPATH_SEARCH_OPTION, search)));
        String xpathRow = String.format(XPATH_GROUP_ROW, search);
        return action.isElementVisible(By.xpath(xpathRow));
    }

    public boolean isInList(String groupName) {
        String xpathRow = String.format(XPATH_GROUP_ROW, groupName);
        return action.isElementVisible(By.xpath(xpathRow));
    }

    public void reloadPage() {
        driver.navigate().refresh();
    }
}
