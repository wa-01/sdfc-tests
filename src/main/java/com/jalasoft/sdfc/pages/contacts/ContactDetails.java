package com.jalasoft.sdfc.pages.contacts;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactDetails extends AbstractPage {

    @FindBy(css = "span[class=\"custom-truncate uiOutputText\"]")
    private WebElement contactNameLabel;

    public String getProjectNameLabel() {

        return action.getText(contactNameLabel);

    }
}
