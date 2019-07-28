package com.jalasoft.sdfc.hooks;


import com.jalasoft.sdfc.core.ui.DriverManager;
import com.jalasoft.sdfc.enums.Item;
import com.jalasoft.sdfc.pages.header.NavBar;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before
    public void tearDown() {
        DriverManager.getInstance().getDriver().get("https://na132.lightning.force.com/lightning/setup/SetupOneHome/home");
    }

}