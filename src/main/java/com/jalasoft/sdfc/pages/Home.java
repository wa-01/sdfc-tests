package com.jalasoft.sdfc.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends AbstractPage {

    @FindBy(css = ".slds-icon-waffle_container")
    private WebElement AppLauncherButton;


    public AppLaunchPage clickWaffleIcon() {
        action.click(AppLauncherButton);
        return new AppLaunchPage();
    }
}
