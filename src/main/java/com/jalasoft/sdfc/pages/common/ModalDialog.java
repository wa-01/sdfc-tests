package com.jalasoft.sdfc.pages.common;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;

public class ModalDialog extends AbstractPage {

    // to click buttons like Cancel, Save, Delete in the modal dialog
    private static String DIALOG_BUTTON = "//span[text()='%s']/parent::button[contains(@class,'forceActionButton')]";

    public void clickButton(String btnName) {
        action.click(By.xpath(String.format(DIALOG_BUTTON, btnName)));
    }
}
