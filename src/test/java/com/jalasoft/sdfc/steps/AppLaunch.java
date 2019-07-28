package com.jalasoft.sdfc.steps;

import com.jalasoft.sdfc.enums.Item;
import com.jalasoft.sdfc.pages.AppLaunchPage;
import com.jalasoft.sdfc.pages.header.NavBar;
import cucumber.api.java.en.And;

public class AppLaunch {

    @And("I click on the AppLauncher Icon")
    public void iClickOnTheAppLauncherIcon() {
        NavBar navBar = new NavBar();
        navBar.clickAppLauncherIcon();
    }

    @And("I select the item {string}")
    public void iSelectTheItem(String item) {
        AppLaunchPage appLauncher = new AppLaunchPage();
        appLauncher.clickOnItem(Item.valueOfItem(item));
    }
}
