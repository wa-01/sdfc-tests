package com.jalasoft.sdfc.steps;

import com.jalasoft.sdfc.pages.Signin;
import com.jalasoft.sdfc.pages.common.BasicForm;
import com.jalasoft.sdfc.pages.header.Header;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.testng.Assert.assertEquals;

public class CommonSteps {

    public CommonSteps(BasicForm basicForm, Header header) {
        this.basicForm = basicForm;
        this.header = header;
    }

    private BasicForm basicForm;
    private Header header;

    @Given("I sign in as {string} user and {string} as password")
    public void iSignInAsUserAnd(String userName, String password) {
        Signin signin = new Signin();
        signin.loginAs(userName, password);
    }

    @Given("I fill the create form and click the {string} button")
    public void iSetCreateForm(String buttonName, List<Map<String, String>> data) {
        Map<String, Map<String, String>> dataFields = new HashMap<>();
        for (Map<String, String> dataRow : data) {
            if (dataFields.containsKey(dataRow.get("fieldType"))) {
                dataFields.get(dataRow.get("fieldType")).put(dataRow.get("fieldName"), dataRow.get("value"));
            } else {
                Map<String, String> values = new HashMap<>();
                values.put(dataRow.get("fieldName"), dataRow.get("value"));
                dataFields.put(dataRow.get("fieldType"), values);
            }
        }
        basicForm.setFormFields(dataFields);
        basicForm.clickFooterButton(buttonName);
    }

    @Then("I validate the notification message says {string}")
    public void iValidateTheNotificationMessageSaysOpportunityWasCreated(String message) {
        assertEquals(header.getVisualMessageQueue(), message);
    }

}