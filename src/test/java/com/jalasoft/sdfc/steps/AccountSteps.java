package com.jalasoft.sdfc.steps;

import com.jalasoft.sdfc.pages.accounts.AccountDetails;
import com.jalasoft.sdfc.pages.accounts.AccountsPage;
import com.jalasoft.sdfc.pages.accounts.AccountsTablePage;
import com.jalasoft.sdfc.pages.header.Header;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;

public class AccountSteps {

    private AccountsPage accountsPage;
    private AccountDetails accountDetails;
    private AccountsTablePage accountsTablePage;
    private Header header;

    public AccountSteps(AccountsPage accountsPage, AccountDetails accountDetails, AccountsTablePage accountsTablePage,
                        Header header) {
        this.accountsPage = accountsPage;
        this.accountDetails = accountDetails;
        this.accountsTablePage = accountsTablePage;
        this.header = header;
    }

    @When("I click on the Add New Account button")
    public void iClickOnTheAddNewAccountButton() {
        accountsPage.clickNewButton();
    }

    @Then("I validate the account label is table {string}")
    public void iValidateTheAccountLabelIsTable(String name) {
        String actualAccountName = accountDetails.getAccountNameLabel();
        Assert.assertEquals(actualAccountName, name);
    }

    @And("I click on account {string} tab")
    public void iClickOnTab(String tabName) {
        accountDetails.goToTab(tabName);
    }

    @And("I validate the account name is {string}")
    public void iValidateTheAccountNameIs(String accName) {
        String actualContactName = accountDetails.getAccountNameDetails();
        Assert.assertEquals(actualContactName, accName);

    }

    @And("I validate the account {string} is displayed in accounts table")
    public void iValaditeTheAccountIsDisplayedInAccountsTable(String accNname) {
        accountsTablePage.isAccountVisible(accNname);
    }

    @And("I click on {string} option button")
    public void iClickOnButton(String EditName) {
        accountDetails.clickEditButton(EditName);

    }

    @And("I add on the name {string} string.")
    public void iAddOnTheNameString(String EditedName) {
        accountDetails.EditAccountName(EditedName);

    }

    @And("I click on {string} button")
    public void iClikOnButton(String button) {
        accountDetails.ClickButton(button);
    }

    @When("I click on the Header dropDown Button")
    public void iClickOnTheHeaderDropDownButton() {
        accountDetails.ClickHeaderDropDown();
    }

    @And("I click on delete option")
    public void iClickOnDeleteOption() {
        accountDetails.ClickDeleteOption();
    }

    @And("I click on delete button")
    public void iClickOnDeleteButton() {
        accountDetails.ClickDeleteButton();
    }

    @Then("I validate the following success message is displayed {string}")
    public void iValidateTheFollowingSuccessMessageIsDisplayedAccountWasDeleted(String message) {
        assertEquals(header.getVisualMessageQueue(), message);
    }
}
