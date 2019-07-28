package com.jalasoft.sdfc.steps;

import com.jalasoft.sdfc.core.ui.IString;
import com.jalasoft.sdfc.pages.opportunities.OpportunityPage;
import com.jalasoft.sdfc.pages.opportunities.view.OpportunityDetails;
import com.jalasoft.sdfc.pages.opportunities.view.OpportunityView;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import java.util.*;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class OpportunitySteps {
    private OpportunityPage opportunityPage;
    private OpportunityDetails opportunityDetails;
    private OpportunityView opportunityView;

    public OpportunitySteps(OpportunityPage opportunityPage, OpportunityDetails opportunityDetails,
                            OpportunityView opportunityView) {
        this.opportunityPage = opportunityPage;
        this.opportunityDetails = opportunityDetails;
        this.opportunityView = opportunityView;
    }

    @Given("I click on the Add New Opportunity button")
    public void iClickOnTheAddNewOpportunityButton() {
        opportunityPage.clickNewButton();
    }

    @Then("I validate the opportunity view page displays")
    public void iValidateTheOpportunityViewPageDisplays(Map<String, String> data) {
        Map<String, IString> strategyMap = new HashMap<>();

        strategyMap.put("opportunity_name", () -> opportunityView.getOpportunityName());
        strategyMap.put("account_name", () -> opportunityView.getLinkValue("Account Name"));
        strategyMap.put("close_date", () -> opportunityView.getSpanValue("Close Date"));
        strategyMap.put("amount", () -> opportunityView.getSpanValue("Amount"));
        strategyMap.put("opportunity_owner", () -> opportunityView.getLinkValue("Opportunity Owner"));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            assertEquals(strategyMap.get(key).getText(), data.get(key));
        }
    }

    @And("I validate the selected stage in the view page is {string}")
    public void iValidateTheSelectedStageInTheViewPageIs(String stageName) {
        assertTrue(opportunityView.isCurrentStage(stageName));
    }

    @And("I go to opportunity {string}")
    public void iGoToOpportunity(String tabName) {
        opportunityView.goToTab(tabName);
    }

    @And("I validate the values set in the Opportunity Details are")
    public void iValidateTheValuesSetAre(Map<String, String> data) {
        // Map should contain the Label Name and the expected value
        Set<String> keys = data.keySet();
        for (String key : keys) {
            assertEquals(opportunityDetails.getFieldValue(key), data.get(key));
        }
    }

    @And("I validate the opportunity {string} is in table and the row has the following values")
    public void iValidateTheOpportunityTableHasARowWithFollowingValues(String name, Map<String, String> data) {
        assertTrue(opportunityPage.isOpportunityInTable(name));

        Map<String, IString> strategyMap = new HashMap<>();
        strategyMap.put("account_name", () -> opportunityPage.getLinkTextValueFromColum(name,"Account Name"));
        strategyMap.put("account_site", () -> opportunityPage.getLinkTextValueFromColum(name,"Account Site"));
        strategyMap.put("stage", () -> opportunityPage.getSpanTextValueFromColum(name,"Stage"));
        strategyMap.put("close_date", () -> opportunityPage.getSpanTextValueFromColum(name,"Close Date"));
        strategyMap.put("owner_alias", () -> opportunityPage.getSpanTextValueFromColum(name, "Opportunity Owner Alias"));

        Set<String> keys = data.keySet();
        for (String key : keys) {
            assertEquals(strategyMap.get(key).getText(), data.get(key));
        }
    }
}
