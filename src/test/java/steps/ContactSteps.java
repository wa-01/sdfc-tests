package steps;

import com.jalasoft.sdfc.pages.contacts.ContactDetails;
import com.jalasoft.sdfc.pages.contacts.ContactsPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

import java.util.Map;

public class ContactSteps {

    private ContactDetails contactDetails;

    @When("I click the new button")
    public void iClickTheNewButton() {
        ContactsPage contact = new ContactsPage();
        contact.clickNewButton();
    }


    @And("I set the contact form")
    public void iSetTheContactForm(Map<String, String> data) {
        ContactsPage contact = new ContactsPage();
        contactDetails = contact.createContact(data);

    }

    @Then("I validate the contact label is {string}")
    public void iValidateTheContactLabelIs(String name) {
        String actualContactName = contactDetails.getProjectNameLabel();
        Assert.assertEquals(actualContactName, name);
    }
}
