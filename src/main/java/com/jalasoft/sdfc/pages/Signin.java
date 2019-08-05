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

    public NavBar loginAs(String userName, String password) {
        if (driver.getTitle().contains("Login | Salesforce")){
            //driver.get("https://login.salesforce.com/");
            action.setValue(userNameTextField, userName);
            action.setValue(passwordTextField, password);
            action.click(loginButton);
        }
        return new NavBar();
    }
}