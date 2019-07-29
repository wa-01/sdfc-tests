Feature: Groups

  Background:
    Given I sign in as "rpfh1@mailinator.com" user and "654321*Aa" as password
    And I click on the AppLauncher Icon
    And I select the item "Groups"

  Scenario: Create new public group
    When I click the New button
    And I fill form with following attributes
      | text   | Name        | Group 1 |
      | select | Access Type | Public  |
    And I click the "Save & Next" button
    And I click the "Next" button
    And I click the "Done" button
    Then I see dashboard page with group name as title page
    And I see page title is "Group 1"
    And I see "Public" under page title
    And I see "Rosario Falconi"
    And I can find it using search box from nav bar


  Scenario: Edit public group
    When I click dropdown button
    And I click "Edit" option
    And I fill New Group form with following attributes
      | name       | Group 1         |
      | owner      | Rosario Falconi |
      | accessType | Public          |


  Scenario: Delete group
    When I go to "Group name" dashboard
    And I click dropdown button
    And I click "Delete" option
    And I click "Delete Group" button
    Then I confirmation message with "Second Group" is displayed
    And I am addressed to Groups list page
    And I do not find "Second Group" group using search box from groups dashboard page
    And I do not find "Second Group" group using search box from nav bar page
    #Group "Second Group" was deleted.



