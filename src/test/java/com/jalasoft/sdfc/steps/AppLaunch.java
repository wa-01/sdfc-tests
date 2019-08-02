package com.jalasoft.sdfc.steps;

import com.jalasoft.sdfc.enums.Item;
import com.jalasoft.sdfc.pages.AppLaunchPage;
import com.jalasoft.sdfc.pages.header.NavBar;
import cucumber.api.java.en.And;

public class AppLaunch {
    public AppLaunch(AppLaunchPage appLauncher, NavBar navBar) {
        this.appLauncher = appLauncher;
        this.navBar = navBar;
    }

    private AppLaunchPage appLauncher;
    private NavBar navBar;

    @And("I click on the AppLauncher Icon")
    public void iClickOnTheAppLauncherIcon() {
        navBar.clickAppLauncherIcon();
    }

    @And("I select the item {string}")
    public void iSelectTheItem(String item) {
        appLauncher.clickOnItem(Item.valueOfItem(item));
    }
}
