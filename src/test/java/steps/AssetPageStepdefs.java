package steps;/*
 * @autor: mauricioramirez
 * Project: sdfc
 * Package: steps
 * Version: 1.0
 */

import com.jalasoft.sdfc.pages.Assets.AssetPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class AssetPageStepdefs {

    private AssetPage assetPage = new AssetPage();

    @Then("I verify that the title on {string} page is {string}")
    public void iVerifyThatTheTitleOnPageIs(String pageName, String expectedTitle) {
        assert assetPage.getPageTitle().equals(expectedTitle);
    }

    @And("I verify that {string} inner form text field is {string}")
    public void iVerifyThatInnerFormFieldIs(String fieldName, String expectedValue) {
        String actualValue = assetPage.getValueInnerFormTextInput(fieldName);

        assert actualValue.equals(expectedValue);
    }
}
