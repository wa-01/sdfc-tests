Feature: Groups

  Background:
    Given I sign in as "rpfh1@mailinator.com" user and "654321*Aa" as password
    And I click on the AppLauncher Icon
    And I select the item "Groups"

  Scenario Outline: Create new group
    When I click New button
    And I fill the create form
      | fieldType     | fieldName       | value             |
      | text          | Name            | <name>            |
      | text_area     | Description     | <description>     |
      | select_option | Access Type     | <access_type>     |
      | checkbox      | Allow customers | <allow_customers> |
      | checkbox      | Broadcast Only  | <broadcast>       |
    And I click all footer buttons
    Then I see '<name>' page title
    And I see '<access_type>' under page title
    And I see '<description>' on group details section
    And I see '<broadcast>' next to access type
    And I click on the "Groups" tab
    And I can see '<name>' on group list page
    And I can find '<name>' using search box from nav bar
    And I close browser
    Examples:
      | name        | description              | access_type | allow_customers | broadcast |
      | My first 36 | This is the hhuhu group | Private     | select          | select    |


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
