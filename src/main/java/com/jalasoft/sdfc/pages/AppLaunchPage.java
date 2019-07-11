package com.jalasoft.sdfc.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppLaunchPage extends AbstractPage {
    private static final String PRIVACY_CSS = "//a[@title='%s']";
    @FindBy(css = ".slds-icon-waffle_container")
    private WebElement AppLauncherButton;

    @FindBy(css = "#password")
    private WebElement passwordTextField;

    @FindBy(css = "#Login")
    private WebElement loginButton;

    public Header LaunchApp(String feature) {
        action.click(AppLauncherButton);
        action.click(By.xpath(String.format(PRIVACY_CSS, feature)));
        return new Header();
    }
}
