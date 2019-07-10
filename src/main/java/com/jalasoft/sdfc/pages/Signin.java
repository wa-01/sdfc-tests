package com.jalasoft.sdfc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Signin extends AbstractPage {

    @FindBy(css = "#username")
    private WebElement userNameTextField;

    @FindBy(css = "#password")
    private WebElement passwordTextField;

    @FindBy(css = "#Login")
    private WebElement loginButton;

    public Signin() {
        driver.get("https://login.salesforce.com/");
    }

    public Header loginAs(String userName, String password) {
        action.setValue(userNameTextField, userName);
        action.setValue(passwordTextField, password);
        action.click(loginButton);

        wait.until( ExpectedConditions.titleIs("Verify Your Identity | Salesforce"));
        return new Header();
    }
}
