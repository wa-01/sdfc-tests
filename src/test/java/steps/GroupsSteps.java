package steps;

import com.jalasoft.sdfc.pages.common.BasicForm;
import com.jalasoft.sdfc.pages.groups.GroupsDashboard;
import com.jalasoft.sdfc.pages.groups.GroupsPage;
import com.jalasoft.sdfc.pages.header.NavBar;
import com.jalasoft.sdfc.pages.header.NavBarMenu;
import com.sun.tools.javac.util.List;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.Map;

public class GroupsSteps {
    GroupsPage groupsPage;
    private GroupsDashboard groupsDashboard;
    private NavBarMenu navBarMenu;
    private NavBar navBar;
    private BasicForm basicForm;

    public GroupsSteps(GroupsPage groupsPage, GroupsDashboard groupsDashboard, NavBarMenu navBarMenu, NavBar navBar, BasicForm basicForm) {
        this.groupsPage = groupsPage;
        this.groupsDashboard = groupsDashboard;
        this.navBarMenu = navBarMenu;
        this.navBar = navBar;
        this.basicForm = basicForm;
    }

    @And("Dashboard page of new public group is created")
    public void dashboard_page_of_new_public_group_is_created() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("I click the New button")
    public void iClickTheNewButton() {
        groupsPage.clickNewButtonGroups();
    }

    @And("I fill form with following attributes")
    public void iFillFormWithFollowingAttributes(List<Map<String, String>> data) {
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
    }
}
