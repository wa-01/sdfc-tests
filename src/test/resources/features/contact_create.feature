Feature: Contacts

  Background:
    Given I sign in as "username" user and "password" as password
    And I click on the AppLauncher Icon
    And I select the item "Contacts"

  Scenario Outline: Create a basic Contact
    When I click on the Add New Contact button
    And I fill the create form and click the "Save" button
      | fieldType | fieldName | value  |
      | text      | Last Name | <LastName> |
      | text      | First Name | <FirstName> |
    Then I validate the contact label is "Pepito Perez"
#    And I click on details tab
#    And I validate the contact name is "Pepito Perez"
#    And I click on Contacts tab
#    And I validate the contact "Pepito Perez" is visible in the table

    Examples:
      | LastName | FirstName|
      | Perez | Pepito |