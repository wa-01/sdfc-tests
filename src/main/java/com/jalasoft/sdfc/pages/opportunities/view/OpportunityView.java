package com.jalasoft.sdfc.pages.opportunities.view;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunityView extends AbstractPage {

    private static String TAB_NAME = "//ul[@class='tabs__nav']/descendant::a[@title='%s']";
    // locator for Close Date and Amount
    private static String SPAN_VALUE = "//span[@title='%s']/parent::div/child::div/descendant::span";
    // locator for Account Name and Opportunity Owner
    private static String LINK_VALUE = "//span[@title='%s']/parent::div/child::div/descendant::a";
    // to locate stage name
    private static String STAGE_LINK = "//ul[contains(@class,'slds-path__nav')]/descendant::a[contains(@title,'%s')]";

    @FindBy(css = ".slds-page-header__title > span")
    private WebElement opportunityName;

    @FindBy(xpath = "//ul[contains(@class,'slds-path__nav')]/child::li[contains(@class,'slds-is-curren')]/child::a")
    private WebElement currentStage;

    @FindBy(css = "button[class*=' slds-path__mark-complete']")
    private WebElement markStageAsCompleteButton;

    public String getOpportunityName() {
        return action.getText(opportunityName);
    }

    public String getSpanValue(String label){
        return action.getText(By.xpath(String.format(SPAN_VALUE, label)));
    }

    public String getLinkValue(String label){
        return action.getText(By.xpath(String.format(LINK_VALUE, label)));
    }

    public boolean isCurrentStage(String stageName) {
        return action.getAttribute(currentStage, "title").equals(stageName);
    }

    public void markStageAsComplete(String stageName) {
        action.click(By.xpath(String.format(STAGE_LINK, stageName)));
        action.click(markStageAsCompleteButton);
    }

    public void goToTab(String tabName) {
        action.click(By.xpath(String.format(TAB_NAME, tabName)));
    }

}
