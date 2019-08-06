Feature: Delete Group

  Background:
    Given I sign in as "sf_user"
    And I click on the AppLauncher Icon
    And I select the item "Groups"
    And I click New button
    And I fill form
      | fieldType     | fieldName       | value           |
      | text          | Name            | Group testing 3 |
      | text_area     | Description     | A description   |
      | select_option | Access Type     | Public          |
      | checkbox      | Allow customers | unselect        |
      | checkbox      | Broadcast Only  | unselect        |
    And I click all footer buttons
    And I see 'Group testing 3' page title

  Scenario: Delete group
    When I select "Delete Group" option
    And I click "Delete Group" button
    And I see delete message for "Group testing 3"
    And I click on tab "Groups"
    And I do not see "Group testing 3" on group list page
    And I do not find "Group testing 3" using search box from nav bar
