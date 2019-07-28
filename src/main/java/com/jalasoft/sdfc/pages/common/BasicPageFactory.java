package com.jalasoft.sdfc.pages.common;

import com.jalasoft.sdfc.pages.AbstractPage;
import com.jalasoft.sdfc.pages.AppLaunchPage;
import com.jalasoft.sdfc.pages.Assets.AssetsPage;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class BasicPageFactory {

    private static final Map<String, Supplier<AbstractPage>> PAGES = new HashMap<>();

    static {
        PAGES.put("assets", AssetsPage::new);
        PAGES.put("newItemForm", BasicNewItemForm::new);
        PAGES.put("appLauncher", AppLaunchPage::new);
    }

    public static AbstractPage getPage(String pageName) {
        return PAGES.get(pageName).get();
    }
}
