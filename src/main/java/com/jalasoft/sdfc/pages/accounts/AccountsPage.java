package com.jalasoft.sdfc.pages.accounts;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AccountsPage extends AbstractPage {

    @FindBy(css = "a[title='New'][role='button']")
    private WebElement newButton;
    public void clickNewButton() {
        action.click(newButton);
    }
}
