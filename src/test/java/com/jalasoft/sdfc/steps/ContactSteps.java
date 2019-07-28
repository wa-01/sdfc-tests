package com.jalasoft.sdfc.steps;

import com.jalasoft.sdfc.pages.contacts.ContactDetails;
import com.jalasoft.sdfc.pages.contacts.ContactsPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class ContactSteps {

    public ContactSteps ( ContactDetails contactDetails, ContactsPage contactsPage ) {
        this.contactDetails = contactDetails;
        this.contactsPage = contactsPage;
    }

    private ContactDetails contactDetails;
    private ContactsPage contactsPage;

    @When("I click on the Add New Contact button")
    public void iClickOnTheAddNewContactButton () {
        contactsPage.clickNewButton();
    }

    @Then("I validate the contact label is {string}")
    public void iValidateTheContactLabelIs ( String name ) {
        String actualContactName = contactDetails.getProjectNameLabel();
        Assert.assertEquals(actualContactName, name);
    }
}
