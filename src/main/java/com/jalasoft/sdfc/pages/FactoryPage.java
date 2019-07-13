package com.jalasoft.sdfc.pages;

import com.jalasoft.sdfc.enums.Item;
import com.jalasoft.sdfc.pages.accounts.AccountsPage;
import com.jalasoft.sdfc.pages.contacts.ContactsPage;
import com.jalasoft.sdfc.pages.groups.GroupsPage;
import com.jalasoft.sdfc.pages.opportunities.OpportunitiesPage;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FactoryPage {

    // Map of all pages that can be selected through the NavBar or AppLauncher
    private static Map<Item, IPage> pageMap;
    static {
        Map<Item, IPage> map = new HashMap<>();
        map.put(Item.ACCOUNTS, AccountsPage::new);
        map.put(Item.CONTACTS, ContactsPage::new);
        map.put(Item.GROUPS, GroupsPage::new);
        map.put(Item.OPPORTUNITIES, OpportunitiesPage::new);
        // map cannot be modified with the following
        pageMap = Collections.unmodifiableMap(map);
    }

    /**
     * Factory method which allows to create different page objects
     * @param item Item enum where are page names are located
     * @return A IPage object interface which is the bridge to retrieve the page objects.
     */
    public static IPage getItemPage(Item item){
        return pageMap.get(item);
    }
}
