package com.jalasoft.sdfc.pages.contacts;

import com.jalasoft.sdfc.core.ui.ISteps;
import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ContactsPage extends AbstractPage {

    @FindBy(css = "a[title='New']")
    private WebElement newButton;

    @FindBy(css = "input[class=\"lastName compoundBLRadius compoundBRRadius form-element__row input\"]")
    private WebElement ContactLastNameTextField;

    @FindBy(css = "button[title=\"Save\"]")
    private WebElement saveButton;

    public void clickNewButton () {
        action.click(newButton);
    }

}
