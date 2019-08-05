package com.jalasoft.sdfc.steps;/*
 * @autor: mauricioramirez
 * Project: sdfc
 * Package: steps
 * Version: 1.0
 */

import com.jalasoft.sdfc.pages.Assets.AssetPage;
import com.jalasoft.sdfc.pages.Assets.AssetsPage;
import com.jalasoft.sdfc.pages.common.BasicForm;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AssetsPageStepDef {

    private AssetsPage assetsPage;

    public AssetsPageStepDef(AssetsPage assetsPage) {
        this.assetsPage = assetsPage;
    }

    @Given("I click on Assets Page {string} button")
    public void iClickOnNewAssetButton(String button_name) {
        assetsPage.clickNewItemButton();
    }

    @And("I verify that {string} is on a row in inner Assets table")
    public void iVerifyThatIsOnARowInInnerAssetsTable(String assetName) {
        String actualAssetName = assetsPage.getInnerTableAssetNameText(assetName);

        assert actualAssetName.equals(assetName);
    }

    @And("I click the edit button for {string} Asset")
    public BasicForm iClickTheEditButtonForAsset(String assetName) {
        return assetsPage.clickEditButtonOnAsset(assetName);
    }

    @And("I click on the {string} asset link")
    public AssetPage iClickOnTheAssetLink(String assetName) {
        return assetsPage.clickAssetLink(assetName);
    }
}
