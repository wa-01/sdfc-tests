Feature: Add Group

  Background:
    Given I sign in as "sf_user"
    And I click on the AppLauncher Icon
    And I select the item "Groups"

  Scenario Outline: Create new group
    When I click New button
    And I fill form
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
    And I click on tab "Groups"
    And I can see '<name>' on group list page
    And I can find '<name>' using search box from nav bar
    Examples:
      | name              | description             | access_type | allow_customers | broadcast |
      | New public group  | This is the hhuhu group | Public     | unselect          | unselect    |
      | New private group | This is the hhuhu group | Private      | select        | select  |


  Scenario: It is not possible to create public group allowing customers
    When I click New button
    And I fill form
      | fieldType     | fieldName       | value                   |
      | text          | Name            | Public group            |
      | text_area     | Description     | This is the hhuhu group |
      | select_option | Access Type     | Public                  |
      | checkbox      | Allow customers | select                  |
      | checkbox      | Broadcast Only  | unselect                |
    And I click the "Save & Next" button
    Then I see "Allow customers: Public groups can’t have customers." message