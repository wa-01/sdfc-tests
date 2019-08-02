package com.jalasoft.sdfc.steps;

import com.jalasoft.sdfc.core.ui.ISteps;
import com.jalasoft.sdfc.core.ui.IString;
import com.jalasoft.sdfc.pages.common.BasicForm;
import com.jalasoft.sdfc.pages.groups.GroupDetails;
import com.jalasoft.sdfc.pages.groups.GroupsPage;
import com.jalasoft.sdfc.pages.header.NavBar;
import com.jalasoft.sdfc.pages.header.NavBarMenu;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupsSteps {
    GroupsPage groupsPage;
    private GroupDetails groupDetails;
    private NavBarMenu navBarMenu;
    private NavBar navBar;
    private BasicForm basicForm;

    public GroupsSteps(GroupsPage groupsPage, GroupDetails groupDetails, NavBarMenu navBarMenu, NavBar navBar, BasicForm basicForm) {
        this.groupsPage = groupsPage;
        this.groupDetails = groupDetails;
        this.navBarMenu = navBarMenu;
        this.navBar = navBar;
        this.basicForm = basicForm;
    }

    @And("Dashboard page of new public group is created")
    public void dashboard_page_of_new_public_group_is_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I click New button")
    public void iClickNewButton() {
        groupsPage.clickNewButtonGroups();
    }

    @And("I click {string} button")
    public void iClickButton(String arg0) {
        basicForm.clickFooterButton(arg0);
    }

    @And("I fill the create form")
    public void iFillTheCreateForm(DataTable dataTable) {
        List<Map<String, String>> datalist = dataTable.asMaps();
        Map<String, Map<String, String>> data = new HashMap<>();
        for (Map<String, String> dataRow: datalist) {
            data.get(dataRow.get("fieldType")).put(dataRow.get("fieldName"), dataRow.get("value"));
        }
        groupsPage.fillingForm(data);
    }
}
