package com.jalasoft.sdfc.enums;

public enum Item {
    HOME("Home"),
    OBJECT_MANAGER("Object Manager"),
    OPPORTUNITIES("Opportunities"),
    LEADS("Leads"),
    TASKS("Tasks"),
    FILES("Files"),
    ACCOUNTS("Accounts"),
    CONTACTS("Contacts"),
    CAMPAIGNS("Campaigns"),
    DASHBOARDS("Dashboards"),
    REPORTS("Reports"),
    CHATTER("Chatter"),
    GROUPS("Groups"),
    CALENDAR("Calendar"),
    PEOPLE("People"),
    CASES("Cases"),
    FORECASTS("Forecasts"),
    ASSETS("Assets");

    private final String itemName;

    Item(String name) {
        this.itemName = name;
    }

    public String getName() {
        return itemName;
    }

    /**
     * It returns an Item object if the introduced string match with the Item.itemName.
     * For example if name is "Accounts", it should return the object Item.ACCOUNTS
     * @param name String used to search an Item object
     * @return an Item object if 'name' value matches with Item.itemName.
     */
    public static Item valueOfItem(String name){
        for (Item item : values()){
            if (item.itemName.equals(name)){
                return item;
            }
        }
        // it will return Home if 'name' doesn't exists.
        return Item.HOME;
    }
}
