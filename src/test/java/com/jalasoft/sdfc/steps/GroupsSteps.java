package com.jalasoft.sdfc.steps;

import com.jalasoft.sdfc.pages.common.ModalDialog;
import com.jalasoft.sdfc.pages.groups.GroupDetails;
import com.jalasoft.sdfc.pages.groups.GroupForm;
import com.jalasoft.sdfc.pages.groups.GroupsDashboard;
import com.jalasoft.sdfc.pages.header.Header;
import com.jalasoft.sdfc.pages.header.NavBar;
import com.jalasoft.sdfc.pages.header.NavBarMenu;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupsSteps {
    private GroupForm groupForm;
    private GroupDetails groupDetails;
    private GroupsDashboard groupsDashboard;
    private ModalDialog modalDialog;
    private NavBar navBar;
    private Header header;

    public GroupsSteps(GroupForm groupForm, GroupDetails groupDetails,
                       NavBar navBar, GroupsDashboard groupsDashboard, ModalDialog modalDialog,
                       Header header) {
        this.groupForm = groupForm;
        this.groupDetails = groupDetails;
        this.navBar = navBar;
        this.groupsDashboard = groupsDashboard;
        this.modalDialog = modalDialog;
        this.header = header;
    }

    @When("I click New button")
    public void iClickNewButton() {
        groupsDashboard.clickNewButton();
    }

    @And("I fill form")
    public void iFillTheCreateForm(List<Map<String, String>> data) {
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
        groupForm.setFormFields(dataFields);
    }

    @And("I click all footer buttons")
    public void iClickAllFooterButtons() {
        groupForm.clickButtons();
    }

    @And("I click {string} button")
    public void iClickButton(String arg0) {
        //groupForm.clickButton(arg0);
        modalDialog.clickButton(arg0);
    }

    @And("I click the {string} button")
    public void iClickTheButton(String arg0) {
        groupForm.clickButton(arg0);
        //modalDialog.clickButton(arg0);
    }
    @Then("I see {string} page title")
    public void iSeeNamePageTitle(String arg0) {
        System.out.println(groupDetails.getGroupName());
        String nameGroup = groupDetails.getGroupName();
        System.out.println(nameGroup);
        Assert.assertTrue(groupDetails.getGroupName().contains(arg0));
    }

    @And("I see {string} under page title")
    public void iSeeAccess_typeUnderPageTitle(String arg0) {
        String accessTypeGroup = groupDetails.getAccessType();
        Assert.assertTrue(accessTypeGroup.contains(arg0));
    }

    @And("I see {string} on group details section")
    public void iSeeDescriptionOnGroupDetailsSection(String arg0) {
        String descriptionGroup = groupDetails.getDescription();
        Assert.assertTrue(descriptionGroup.contains(arg0));
    }

    @And("I see {string} next to access type")
    public boolean iSeeBroadcastNextToAccessType(String arg0) {
        boolean broadcastGroup = groupDetails.getBroadcast();
        if (arg0.equals("unselect") && !broadcastGroup) {
            return true;
        }
        if (arg0.equals("select") && broadcastGroup) {
            return true;
        } else {
            return false;
        }
    }

    @And("I can find {string} using search box from nav bar")
    public void iCanFindNameUsingSearchBoxFromNavBar(String arg0) {
        Assert.assertTrue(groupsDashboard.searchBox(arg0));
    }

    @And("I close browser")
    public void iCloseBrowser() {
        groupsDashboard.closeBrowser();
    }

    @And("I can see {string} on group list page")
    public void iCanSeeNameOnGroupListPage(String arg0) {
        Assert.assertTrue(groupsDashboard.isInList(arg0));
    }

    @And("I click on tab {string}")
    public void iClickOnTab(String arg0) {
        navBar.clickOnTabNameContains(arg0);
    }

    @And("I select {string} option")
    public void iSelectOption(String arg0) {
        groupDetails.clickGroupOption(arg0);
    }

    @And("I delete {string} group")
    public void iDeleteGroup(String arg0) {
        groupDetails.deleteGroup(arg0);
        System.out.println("On delete group");
    }

    @And("I see delete message for {string}")
    public void iSeeDeleteMessageFor(String arg0) {
        String message = String.format("Group \"%s\" was deleted.", arg0);
        Assert.assertTrue(message.equals(header.getVisualMessageQueue()));
    }

    @And("I see edit message for {string}")
    public void iSeeEditMessageFor(String arg0) {
        String message = String.format("Group \"%s\" was saved.", arg0);
        Assert.assertTrue(message.equals(header.getVisualMessageQueue()));
    }

    @And("I do not see {string} on group list page")
    public void iDoNotSeeOnGroupListPage(String arg0) {
        Assert.assertFalse(groupsDashboard.isInList(arg0));
    }

    @And("I do not find {string} using search box from nav bar")
    public void iDoNotFindUsingSearchBoxFromNavBar(String arg0) {
        Assert.assertFalse(groupsDashboard.searchBox(arg0));
    }

    @Then("I see {string} message")
    public void iSeeMessage(String arg0) {
        Assert.assertTrue(arg0.equals(groupForm.getErrorMessage()));
    }
}
