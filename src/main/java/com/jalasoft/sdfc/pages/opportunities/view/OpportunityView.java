package com.jalasoft.sdfc.pages.opportunities.view;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunityView extends AbstractPage {
    // tabs
    // .tabs__nav > .tabs__item > a[title='Details']
    // //ul[@class='tabs__nav']/descendant::a[@title='Details']

    //@FindBy(xpath = "//nav[@class='entityNameTitle']/following-sibling::div/child::span")
    @FindBy(css = ".slds-page-header__title > span")
    private WebElement title;

    public String getTitle() {
        return action.getText(title);
    }

}
