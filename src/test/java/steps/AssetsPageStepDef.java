package steps;/*
 * @autor: mauricioramirez
 * Project: sdfc
 * Package: steps
 * Version: 1.0
 */

import com.jalasoft.sdfc.pages.AssetsPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AssetsPageStepDef {

    private AssetsPage assetsPage = new AssetsPage();

    @Given("I click on Assets Page {string} button")
    public void iClickOnNewAssetButton(String button_name) {
        assetsPage.clickNewItemButton();
    }

    @Then("I should see a new row")
    public void iShouldSeeANewRow() {
        System.out.print("pass");
    }
}
