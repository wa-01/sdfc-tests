package com.jalasoft.sdfc.enums;

public enum HeaderTab {
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
    FORECASTS("Forecasts");

    private final String tabName;

    HeaderTab(String name) {
        this.tabName = name;
    }

    public String getName() {
        return tabName;
    }
}
