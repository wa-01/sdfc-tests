Feature: Contacts

  Background:
    Given I sign in as "mfuentes@test.com" user and "BQEmagui1" as password
    And I click on the AppLauncher Icon
    And I select the item "Contacts"
    And I click on the Add New Contact button
    And I fill the create form and click the "Save" button
      | fieldType | fieldName  | value |
      | text      | Last Name  | LastName |
      | text      | First Name | Contact  |


  Scenario Outline: Edit Contact
    When I click on "Details" tab
    And I click on "Edit Name" icon
    And I update the contact data and click the "Save" button
      | fieldType | fieldName  | value       |
      | text      | Last Name  | <LastName>  |
      | text      | First Name | <FirstName> |
    Then I validate the contact name is 'Contact<FirstName> LastName<LastName>'
    And I validate the contact label is 'Contact<FirstName> LastName<LastName>'
    And I click on the AppLauncher Icon
    And I select the item "Contacts"
    And I validate the contact 'Contact<FirstName> LastName<LastName>' is visible in the table

    Examples:
      | LastName | FirstName |
      | update    | update    |