Feature: Contacts

  Background:
    Given I sign in as "sf_user"
    And I click on the AppLauncher Icon
    And I select the item "Contacts"

  Scenario: Verify that Contact is not created when required fields are not filled
    When I click on the Add New Contact button
    And I fill the create form and click the "Save" button
      | fieldType | fieldName  | value     |
      | text      | First Name | FirstName |
    Then I verify the following error message in the form: "These required fields must be completed: Last Name"
    And I verify that the following fields are required in the form:
      | Last Name |

  Scenario Outline: Create a basic Contact
    When I click on the Add New Contact button
    And I fill the create form and click the "Save" button
      | fieldType | fieldName  | value       |
      | text      | Last Name  | <LastName>  |
      | text      | First Name | <FirstName> |
    Then I validate the notification message says 'Contact "<FirstName> <LastName>" was created.'
    And I validate the contact label is '<FirstName> <LastName>'
    And I click on "Details" tab
    And I validate the contact name is "<FirstName> <LastName>"
    And I click on the AppLauncher Icon
    And I select the item "Contacts"
    And I validate the contact "<FirstName> <LastName>" is visible in the table
    Examples:
      | LastName | FirstName |
      | LastName | Contact   |