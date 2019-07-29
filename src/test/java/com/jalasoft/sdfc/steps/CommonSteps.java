package com.jalasoft.sdfc.steps;

import com.jalasoft.sdfc.enums.Item;
import com.jalasoft.sdfc.pages.Signin;
import com.jalasoft.sdfc.pages.common.BasicForm;
import com.jalasoft.sdfc.pages.common.ModalDialog;
import com.jalasoft.sdfc.pages.header.Header;
import com.jalasoft.sdfc.pages.header.NavBar;
import com.jalasoft.sdfc.pages.header.NavBarMenu;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CommonSteps {

    private BasicForm basicForm;
    private Header header;
    private NavBar navBar;
    private NavBarMenu navBarMenu;
    private ModalDialog modalDialog;

    public CommonSteps(BasicForm basicForm, Header header, NavBar navBar, NavBarMenu navBarMenu, ModalDialog modalDialog) {
        this.basicForm = basicForm;
        this.header = header;
        this.navBar = navBar;
        this.navBarMenu = navBarMenu;
        this.modalDialog = modalDialog;
    }

    @Given("I sign in as {string} user and {string} as password")
    public void iSignInAsUserAnd(String userName, String password) {
        Signin signin = new Signin();
        signin.loginAs(userName, password);
    }

    @Given("I fill the create form and click the {string} button")
    public void iSetCreateForm(String buttonName, List<Map<String, String>> data) {
        Map<String, Map<String, String>> dataFields = new HashMap<>();
        for (Map<String, String> dataRow: data) {
            if (dataFields.containsKey(dataRow.get("fieldType"))) {
                dataFields.get(dataRow.get("fieldType")).put(dataRow.get("fieldName"), dataRow.get("value"));
            } else {
                Map<String, String> values = new HashMap<>();
                values.put(dataRow.get("fieldName"), dataRow.get("value"));
                dataFields.put(dataRow.get("fieldType"),values);
            }
        }
        basicForm.setFormFields(dataFields);
        basicForm.clickFooterButton(buttonName);
    }

    @And("I validate the name {string} is in the {string} menu")
    public void iValidateTheNameNameIsInTheMenu(String name, String menuName) {
        navBar.clickOnTabNameArrow(Item.valueOfItem(menuName));
        assertTrue(navBarMenu.isMenuItemVisible(name));
    }

    @And("I click on the {string} tab")
    public void iClickOnTheTab(String tabName) {
        navBar.clickOnTabName(Item.valueOfItem(tabName));
    }

    @Then("I validate the notification message says {string}")
    public void iValidateTheNotificationMessageSaysOpportunityWasCreated(String message) {
        assertEquals(header.getVisualMessageQueue(), message);
    }

    @And("I click {string} in the modal dialog")
    public void iClickInTheModalDialog(String btnName) {
        this.modalDialog.clickButton(btnName);
    }

    @And("I validate the opportunity {string} is not in the {string} menu")
    public void iValidateTheOpportunityIsNotInTheMenu(String name, String menuName) {
        navBar.clickOnTabNameArrow(Item.valueOfItem(menuName));
        assertFalse(navBarMenu.isMenuItemVisible(name));
    }
}
