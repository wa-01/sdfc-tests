package steps;

import com.jalasoft.sdfc.enums.Item;
import com.jalasoft.sdfc.pages.Signin;
import com.jalasoft.sdfc.pages.common.BasicForm;
import com.jalasoft.sdfc.pages.header.NavBar;
import com.jalasoft.sdfc.pages.header.NavBarMenu;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonSteps {

    private BasicForm basicForm = new BasicForm();

    private NavBar navBar = new NavBar();
    private NavBarMenu navBarMenu = new NavBarMenu();

    @Given("I sign in as {string} user and {string} as password")
    public void iSignInAsUserAnd(String userName, String password) {
        Signin signin = new Signin();
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

    @When("I click the {string} button on new item Form Page")
    public void iClickTheButtonOnNewItemFormPage(String buttonName) {
        basicForm.clickFooterButton(buttonName);
    }

    @Then("I verify that {string} is on dropdown menu of {string} tab")
    public void iVerifyThatIsOnDropdownMenuOfTab(String expectedValue, String tabName) {
        navBarMenu = navBar.clickOnTabNameArrow(Item.valueOfItem(tabName.toUpperCase()));

        assert navBarMenu.isMenuItemVisible(expectedValue);
    }
}
