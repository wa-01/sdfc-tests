package com.jalasoft.sdfc.pages;

import com.jalasoft.sdfc.pages.header.NavBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public NavBar loginAs(String userName, String password) {
        action.setValue(userNameTextField, userName);
        action.setValue(passwordTextField, password);
        action.click(loginButton);
        return new NavBar();
    }
}