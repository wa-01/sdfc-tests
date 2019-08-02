package com.jalasoft.sdfc.steps;

import com.jalasoft.sdfc.pages.common.BasicForm;
import com.jalasoft.sdfc.pages.contacts.AllContacts;
import com.jalasoft.sdfc.pages.contacts.ContactDetails;
import com.jalasoft.sdfc.pages.contacts.ContactsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactSteps {

    public ContactSteps(ContactDetails contactDetails, ContactsPage contactsPage, AllContacts allContacts, BasicForm basicForm) {
        this.contactDetails = contactDetails;
        this.contactsPage = contactsPage;
        this.allContacts = allContacts;
        this.basicForm = basicForm;
    }

    private ContactDetails contactDetails;
    private ContactsPage contactsPage;
    private AllContacts allContacts;
    private BasicForm basicForm;


    @When("I click on the Add New Contact button")
    public void iClickOnTheAddNewContactButton() {
        contactsPage.clickNewButton();
    }

    @Then("I validate the contact label is {string}")
    public void iValidateTheContactLabelIs(String name) {
        String actualContactName = contactDetails.getContactNameLabel();
        Assert.assertEquals(actualContactName, name);
    }

    @And("I click on {string} tab")
    public void iClickOnTab(String tab) {
        contactDetails.goToTab(tab);
    }

    @And("I validate the contact name is {string}")
    public void iValidateTheContactNameIs(String name) {
        String actualContactName = contactDetails.getContactNameDetails();
        Assert.assertEquals(actualContactName, name);
    }

    @And("I validate the contact {string} is visible in the table")
    public void iValidateTheContactIsVisibleInTheTable(String name) {
        allContacts.isContactVisible(name);
    }

    @When("I click on {string} icon")
    public void iClickOnEditIcon(String iconName) {
        contactDetails.clickEditIcon(iconName);
    }

    @And("I update the contact data and click the {string} button")
    public void iUpdateTheContactDataAndClickTheButton(String buttonName, List<Map<String, String>> data) {
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
        contactDetails.clickUpdateDetailsButton(buttonName);
    }

    @And("I expand the actions of {string} contact")
    public void iExpandTheActionsContact(String accountName) {
        allContacts.ClickContactActions(accountName);

    }

    @And("I click on the {string} option")
    public void iClickOnTheOption(String option) {
        allContacts.selectOptionActions(option);
    }

    @And("I accept to delete contact")
    public void iAcceptToDeleteContact() {
        allContacts.delectContact();
    }

}
