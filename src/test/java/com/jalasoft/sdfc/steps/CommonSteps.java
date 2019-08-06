package com.jalasoft.sdfc.steps;

import com.jalasoft.sdfc.core.Environment;
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
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CommonSteps {

    private BasicForm basicForm;
    private Header header;
    private Signin signin;
    private NavBar navBar;
    private NavBarMenu navBarMenu;
    private ModalDialog modalDialog;

    public CommonSteps(BasicForm basicForm, Header header,Signin signin, NavBar navBar, NavBarMenu navBarMenu, ModalDialog modalDialog) {
        this.basicForm = basicForm;
        this.header = header;
        this.signin = signin;
        this.navBar = navBar;
        this.navBarMenu = navBarMenu;
        this.modalDialog = modalDialog;
    }

    @Given("I sign in as {string}")
    public void iSignInAsUserAnd(String user) {
        String userName = Environment.getInstance().getValue(String.format("$['credentials']['%s']['username']", user));
        String password = Environment.getInstance().getValue(String.format("$['credentials']['%s']['password']", user));
        signin.loginAs(userName, password);
    }

    @Given("I fill the create form with")
    public void iFillTheCreateFormWith(List<Map<String, String>> data) {
        Map<String, Map<String, String>> dataFields = new HashMap<>();

        for (Map<String, String> dataRow: data) {
            if (!dataFields.containsKey(dataRow.get("fieldType"))) {
                dataFields.put(dataRow.get("fieldType"), new HashMap<>());
            }

            dataFields.get(dataRow.get("fieldType")).put(dataRow.get("fieldName"), dataRow.get("value"));
        }

        basicForm.setFormFields(dataFields);
    }

    @Given("I fill the create form and click the {string} button")
    public void iSetCreateForm(String buttonName, List<Map<String, String>> data) {
        iFillTheCreateFormWith(data);
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

    @When("I click the {string} button on edit item Form Page")
    public void iClickTheButtonOnEditItemFormPage(String buttonName) {
        basicForm.clickFooterButton(buttonName);
    }

    @When("I click the {string} button on new item Form Page")
    public void iClickTheButtonOnNewItemFormPage(String buttonName) {
        basicForm.clickFooterButton(buttonName);
    }

    @Then("I verify that {string} is on dropdown menu of {string} tab")
    public void iVerifyThatIsOnDropdownMenuOfTab(String expectedValue, String tabName) {
        navBarMenu = navBar.clickOnTabNameArrow(Item.valueOfItem(tabName));

        assert navBarMenu.isMenuItemVisible(expectedValue);
    }

    @And("I add {string} text to the following fields in the edit form:")
    public void iAddTextToTheFollowingFieldsInTheEditForm(String text, DataTable data) {
        List<Map<String, String>> dataMaps = data.asMaps();

        for (Map<String, String> dataMap: dataMaps) {
            basicForm.addTextToField(text, dataMap);
        }

        basicForm.clickFooterButton("Save");
    }

    @Then("I verify the following error message in the form: {string}")
    public void iValidateTheCreateFormAnErrorMessageSays(String message) {
        assertEquals(message, basicForm.getErrorMessageAfterClickSave());
    }

    @And("I verify that the following fields are required in the form:")
    public void iValidateTheseFieldsAreRequiredToCompleteInTheForm(List<String> fieldList) {
        for (String fieldName : fieldList) {
            assertTrue(basicForm.isMarkedAsRequiredAfterClickSave(fieldName));
        }
    }
}
