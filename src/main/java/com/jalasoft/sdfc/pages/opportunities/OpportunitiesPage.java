package com.jalasoft.sdfc.pages.opportunities;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpportunitiesPage extends AbstractPage {

    @FindBy(css = "a[title='New'][role='button']")
    private WebElement newButton;

    public void clickNewButton(){
        action.click(newButton);
    }
}
