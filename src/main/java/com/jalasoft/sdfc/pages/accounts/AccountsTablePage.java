package com.jalasoft.sdfc.pages.accounts;

import com.jalasoft.sdfc.pages.AbstractPage;
import org.openqa.selenium.By;

public class AccountsTablePage extends AbstractPage {

    private static String ACCOUNT_NAME = "a[title='%s']";

    public boolean isAccountVisible(String accName) {
        return action.isElementVisible(By.xpath(String.format(ACCOUNT_NAME, accName)));
    }
}
