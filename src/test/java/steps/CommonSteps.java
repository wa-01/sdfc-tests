package steps;

import com.jalasoft.sdfc.pages.Signin;
import com.jalasoft.sdfc.pages.common.BasicForm;
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
    @Given("I sign in as {string} user and {string} as password")
    public void iSignInAsUserAnd(String userName, String password) {
        Signin signin = new Signin();
        signin.loginAs(userName, password);
    }

    @Given("I fill the create form and click the {string} button")
    public void iSetCreateForm(String buttonName, List<Map<String, String>> data) {
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
        basicForm.clickFooterButton(buttonName);
    }
}
