package com.jalasoft.sdfc.pages.common;

import com.jalasoft.sdfc.pages.AbstractPage;
import com.jalasoft.sdfc.pages.AppLaunchPage;
import com.jalasoft.sdfc.pages.Assets.AssetsPage;
import com.jalasoft.sdfc.pages.accounts.AccountsPage;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BasicPageFactory {

    private static final Map<String, Supplier<AbstractPage>> PAGES = new HashMap<>();

    static {
        PAGES.put("assets", AssetsPage::new);
        PAGES.put("accounts", AccountsPage::new);
        PAGES.put("newItemForm", BasicForm::new);
        PAGES.put("appLauncher", AppLaunchPage::new);
    }

    public static AbstractPage getPage(String pageName) {
        return PAGES.get(pageName).get();
    }
}
