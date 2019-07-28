package com.jalasoft.sdfc.pages.header;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractPage {

    @FindBy(xpath = "//div[@class='forceVisualMessageQueue']/descendant::span[@data-aura-class='forceActionsText']")
    private WebElement visualSuccessMessage;

    public String getSuccessMessage() {
        return action.getText(visualSuccessMessage);
    }
}
