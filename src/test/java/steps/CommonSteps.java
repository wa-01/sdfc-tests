package steps;

import com.jalasoft.sdfc.pages.Signin;
import com.jalasoft.sdfc.pages.common.BasicNewItemForm;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonSteps {

    private BasicNewItemForm newBasicForm = new BasicNewItemForm();

    @Given("I sign in as {string} user and {string} as password")
    public void iSignInAsUserAnd(String userName, String password) {
        Signin signin = new Signin();
        signin.loginAs(userName, password);
    }

    @Given("I set the create form")
    public void iSetCreateForm(DataTable dt) {
        List<Map<String, String>> data = dt.asMaps(String.class, String.class);
        Map<String, String[]> formData = new HashMap<>();

        for (Map<String, String> dataRow: data) {
            String key = dataRow.get("fieldType");
            String[] valuePair = new String[2];

            valuePair[0] = dataRow.get("fieldName");
            valuePair[1] = dataRow.get("value");

            formData.put(key, valuePair);
        }

        newBasicForm.setFormFields(formData);
    }

    @When("I click the {string} button on new item Form Page")
    public void iClickFooterButtonOnForm(String buttonName) {
        newBasicForm.clickFooterButton(buttonName);
    }
}
