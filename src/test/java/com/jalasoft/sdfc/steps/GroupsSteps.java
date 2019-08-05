package com.jalasoft.sdfc.steps;

import com.jalasoft.sdfc.pages.common.BasicForm;
import com.jalasoft.sdfc.pages.groups.GroupDetails;
import com.jalasoft.sdfc.pages.groups.GroupForm;
import com.jalasoft.sdfc.pages.groups.GroupsDashboard;
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
    private NavBarMenu navBarMenu;
    private NavBar navBar;

    public GroupsSteps(GroupForm groupForm, GroupDetails groupDetails, NavBarMenu navBarMenu, NavBar navBar, GroupsDashboard groupsDashboard) {
        this.groupForm = groupForm;
        this.groupDetails = groupDetails;
        this.navBarMenu = navBarMenu;
        this.navBar = navBar;
        this.groupsDashboard = groupsDashboard;
    }

    @And("Dashboard page of new public group is created")
    public void dashboard_page_of_new_public_group_is_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I click New button")
    public void iClickNewButton() {
        groupForm.clickNewButton();
    }

    @And("I click {string} button on add group form")
    public void iClickButtonOnAddGroupForm(String arg0) {
        groupForm.clickButton(arg0);
    }

    @And("I fill the create form")
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

    @Then("I see {string} page title")
    public void iSeeNamePageTitle(String arg0) {
        String nameGroup = groupDetails.getGroupName();
        Assert.assertTrue(nameGroup.contains(arg0));
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
        if (arg0.equals("unselect") && !broadcastGroup){
            return true;
        }
        if (arg0.equals("select") && broadcastGroup){
            return true;
        }
        else{
            return false;
        }
    }

    @And("I can find {string} using search box from nav bar")
    public void iCanFindNameUsingSearchBoxFromNavBar(String arg0) {
        groupsDashboard.searchBox(arg0);
    }

    @And("I close browser")
    public void iCloseBrowser() {
        groupsDashboard.closeBrowser();
    }

    @And("I can see {string} on group list page")
    public void iCanSeeNameOnGroupListPage(String arg0) {
        groupsDashboard.isInList(arg0);
    }
}
