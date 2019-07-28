Feature: Contacts

  Background:
    Given I sign in as "owner"
    And I click on the AppLauncher Icon
    And I select the item "Contacts"
    And I click on the Add New Contact button
    And I fill the create form and click the "Save" button
      | fieldType | fieldName | value  |
      | text      | Last Name | Contact |


  Scenario: Delete Contact
    When I click on "Details" tab
    And I click on the AppLauncher Icon
    And I select the item "Contacts"
    And I expand the actions of "Contact" contact
    And I click on the "Delete" option
    And I accept to delete contact
    Then I validate the notification message says 'Contact "Contact" was deleted.'