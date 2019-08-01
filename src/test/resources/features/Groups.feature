Feature: Groups

  Background:
    Given I sign in as "rpfh1@mailinator.com" user and "654321*Aa" as password
    And I click on the AppLauncher Icon
    And I select the item "Groups"

  Scenario Outline: Create new public group
    When I click New button
    And I fill the create form
      | fieldType     | fieldName       | value             |
      | text_option   | Name            | <name>            |
      | text_area     | Description     | <description>     |
      | select_option | Access Type     | <access_type>     |
      | checkbox      | Allow customers | <allow_customers> |
      | checkbox      | Broadcast Only  | <broadcast>       |
#    And I click "Save & Next" button
#    And I click the "Next" button
#    And I click the "Done" button
#    Then I see dashboard page with group name as title page
#    And I see page title is "Group 1"
#    And I see "Public" under page title
#    And I see "Rosario Falconi"
#    And I can find it using search box from nav bar
    Examples:
      | name    | description       | access_type | allow_customers | broadcast |
      | Group 1 | Group description | Public      | unselect        | select    |
#      | Group 2 | A description 02  | Private     |


    # Verify it is not possible to create a public group with allow customers
  # New Lead for Group : *Salutation, First Name , *Last Name , Email, *Company, Title > button Save
  # Leas "first + last name" was created

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