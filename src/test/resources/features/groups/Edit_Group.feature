Feature: Edit Group

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

  Scenario: Edit public group
    When I select "Edit Group" option
    And I fill form
      | fieldType     | fieldName       | value                |
      | text          | Name            | Edited group         |
      | text_area     | Description     | A description plus++ |
      | select_option | Access Type     | Private              |
      | checkbox      | Allow customers | select               |
      | checkbox      | Broadcast Only  | unselect             |
    And I click "Save" button
    Then I see edit message for "Edited group"
    And I see 'Edited group' page title
    And I see 'Private' under page title
    And I see 'A description plus++' on group details section
    And I click on tab "Groups"
    And I can see 'Edited group' on group list page
    And I can find 'Edited group' using search box from nav bar
    And I delete "Edited group" group
