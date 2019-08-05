package com.jalasoft.sdfc.hooks;

import com.jalasoft.sdfc.core.ui.DriverManager;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        if (!DriverManager.getInstance().getDriver().getTitle().contains("Salesforce")){
            DriverManager.getInstance().getDriver().get("https://login.salesforce.com/");
        }
        else {
            DriverManager.getInstance().getDriver().get("https://na132.lightning.force.com/lightning/setup/SetupOneHome/home");
        }
    }
}